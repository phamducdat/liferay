package com.dogoo.common.auditing.service.internal.retriever;

import com.dogoo.common.auditing.service.constant.SearchFields;
import com.dogoo.common.auditing.service.model.AuditingEntry;
import com.dogoo.common.auditing.service.retriever.AuditingRetriever;
import com.dogoo.common.util.api.CommonUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.DateRangeTermFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.search.generic.MatchQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component(
        scope = ServiceScope.PROTOTYPE, service = AuditingRetriever.class
)
public class AuditingRetrieverImpl implements AuditingRetriever {

    private static final String PATTERN = "yyyyMMddHHmmss";
    SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);

    @Override
    public Document[] getAuditings(long customerId,
                                   long classPKId,
                                   String classPkName,
                                   Date startDate,
                                   Date endDate,
                                   Filter filter,
                                   ServiceContext serviceContext) throws SearchException, ParseException {
        SearchContext searchContext = new SearchContext();

        searchContext.setCompanyId(serviceContext.getCompanyId());
        searchContext.setSorts(new Sort(Field.CREATE_DATE, Sort.LONG_TYPE, true));

        BooleanQuery booleanQuery = buildQuery(customerId, classPKId, classPkName, startDate, endDate, filter);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        Document[] children = getChildren(customerId, classPKId, classPkName, startDate, endDate, filter, searchContext);
        return Stream
                .of(hits.getDocs(), children)
                .flatMap(Stream::of)
                .sorted((o1, o2) -> {
                    try {
                        Date date1 = o1.getDate(SearchFields.CREATE_DATE);
                        Date date2 = o2.getDate(SearchFields.CREATE_DATE);

                        return DateUtil.compareTo(date2, date1);
                    } catch (java.text.ParseException e) {
                        return 0;
                    }
                })
                .toArray(Document[]::new);
    }

    private Document[] getChildren(long customerId,
                                   long parentId,
                                   String parentName,
                                   Date startDate,
                                   Date endDate,
                                   Filter filter,
                                   SearchContext searchContext) throws ParseException, SearchException {
        BooleanQuery booleanQuery = buildQuerySearchByParent(customerId, parentId, parentName, startDate, endDate, filter);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        if (hits.getDocs().length == 0) {
            return new Document[]{};
        }

        List<Long> seekedIds = new ArrayList<>();

        return Arrays
                .stream(hits.getDocs())
                .map(doc -> {
                    long childId = GetterUtil.getLong(doc.get(SearchFields.CLASS_PK_ID));

                    if (!seekedIds.contains(childId)) {
                        String childName = doc.get(SearchFields.CLASS_PK_NAME);
                        seekedIds.add(childId);

                        try {
                            Document[] children = getChildren(customerId, childId, childName, startDate, endDate, filter, searchContext);

                            List<Document> childrenList = Arrays.stream(children).collect(Collectors.toList());

                            childrenList.add(doc);

                            return childrenList.toArray(Document[]::new);
                        } catch (ParseException | SearchException e) {
                            e.printStackTrace();
                        }
                    }
                    return new Document[]{doc};
                }).flatMap(Stream::of).toArray(Document[]::new);
    }

    private BooleanQuery buildQuery(long customerId,
                                    long classPkId,
                                    String classPkName,
                                    Date startDate,
                                    Date endDate,
                                    Filter filter) throws ParseException {
        TermFilter customerFilter = new TermFilter(SearchFields.CUSTOMER_ID, Long.toString(customerId));
        MatchQuery classPkIdFilter = new MatchQuery(SearchFields.CLASS_PK_ID, Long.toString(classPkId));
        MatchQuery classPkNameFilter = new MatchQuery(SearchFields.CLASS_PK_NAME, classPkName);

        DateRangeTermFilter dateRangeTermFilter = new DateRangeTermFilter(
                SearchFields.CREATE_DATE,
                true,
                true,
                Validator.isNotNull(startDate) ? sdf.format(_commonUtil.getStartOfDate(startDate)) : null,
                Validator.isNotNull(endDate) ? sdf.format(_commonUtil.getEndOfDate(endDate)) : null);

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(dateRangeTermFilter, BooleanClauseOccur.MUST);

        BooleanQuery booleanQuery = new BooleanQueryImpl();
        booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, AuditingEntry.class.getName());
        booleanQuery.setPostFilter(filter);
        booleanQuery.setPreBooleanFilter(booleanFilter);
        booleanQuery.add(classPkIdFilter, BooleanClauseOccur.MUST);
        booleanQuery.add(classPkNameFilter, BooleanClauseOccur.MUST);

        return booleanQuery;

    }

    private BooleanQuery buildQuerySearchByParent(long customerId,
                                                  long parentId,
                                                  String parentName,
                                                  Date startDate,
                                                  Date endDate,
                                                  Filter filter) throws ParseException {
        TermFilter customerFilter = new TermFilter(SearchFields.CUSTOMER_ID, Long.toString(customerId));
        MatchQuery parentPkIdFilter = new MatchQuery(SearchFields.PARENT_PK_ID, Long.toString(parentId));
        MatchQuery parentPkNameFilter = new MatchQuery(SearchFields.PARENT_PK_NAME, parentName);

        DateRangeTermFilter dateRangeTermFilter = new DateRangeTermFilter(
                SearchFields.CREATE_DATE,
                true,
                true,
                Validator.isNotNull(startDate) ? sdf.format(_commonUtil.getStartOfDate(startDate)) : null,
                Validator.isNotNull(endDate) ? sdf.format(_commonUtil.getEndOfDate(endDate)) : null);

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(dateRangeTermFilter, BooleanClauseOccur.MUST);

        BooleanQuery booleanQuery = new BooleanQueryImpl();
        booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, AuditingEntry.class.getName());
        booleanQuery.setPostFilter(filter);
        booleanQuery.setPreBooleanFilter(booleanFilter);
        booleanQuery.add(parentPkIdFilter, BooleanClauseOccur.MUST);
        booleanQuery.add(parentPkNameFilter, BooleanClauseOccur.MUST);

        return booleanQuery;

    }

    @Reference
    private CommonUtil _commonUtil;
}

