package com.dogoo.common.api.rest.internal.service;

import com.dogoo.common.api.rest.dto.v2_0.EmployeeReference;
import com.dogoo.common.api.rest.internal.mapper.EmployeeReferenceMapper;
import com.dogoo.common.api.rest.internal.util.EmployeeIndexerKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = EmployeeReferenceService.class)
public class EmployeeReferenceService {
    private final int DEFAULT_PAGE_SIZE = 100;

    public Page<EmployeeReference> getEmployeeReferencesPage(long customerId,
                                                             String search,
                                                             Filter filter,
                                                             Pagination pagination,
                                                             Sort[] sorts,
                                                             ServiceContext serviceContext) throws Exception {
        pagination = Pagination.of(pagination.getPage(), DEFAULT_PAGE_SIZE);

        List<EmployeeReference> employeeReferences =
                _mapper.mapEmployeeReferencesFromDocuments(
                        searchEmployeeReference(
                                serviceContext.getCompanyId(),
                                customerId,
                                search,
                                filter,
                                sorts,
                                pagination.getStartPosition(),
                                pagination.getEndPosition()));

        return Page.of(employeeReferences, pagination, employeeReferences.size());
    }

    public Document[] searchEmployeeReference(long companyId,
                                              long customerId,
                                              String keyword,
                                              Filter filter,
                                              Sort[] sorts,
                                              int start,
                                              int end) throws SearchException, ParseException {

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        searchContext.setSorts(sorts);
        searchContext.setStart(start);
        searchContext.setEnd(end);

        BooleanQuery booleanQuery = buildQuery(customerId, keyword, filter);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }


    private BooleanQuery buildQuery(long customerId,
                                    String keyword,
                                    Filter filter) throws ParseException {


        TermFilter employeeFilter = new TermFilter(Field.ENTRY_CLASS_NAME, EmployeeIndexerKeys.EMPLOYEE_CLASS_NAME);
        TermFilter departmentFilter = new TermFilter(Field.ENTRY_CLASS_NAME, EmployeeIndexerKeys.DEPARTMENT_CLASS_NAME);
        TermFilter positionFilter = new TermFilter(Field.ENTRY_CLASS_NAME, EmployeeIndexerKeys.POSITION_CLASS_NAME);

        BooleanFilter booleanFilter = new BooleanFilter();

        BooleanFilter classNameFilter = new BooleanFilter();

        classNameFilter.add(employeeFilter, BooleanClauseOccur.SHOULD);
        classNameFilter.add(departmentFilter, BooleanClauseOccur.SHOULD);
        classNameFilter.add(positionFilter, BooleanClauseOccur.SHOULD);

        booleanFilter.add(classNameFilter, BooleanClauseOccur.MUST);

        if (Validator.isNotNull(filter)) {
            BooleanFilter extCodeFiler = new BooleanFilter();
            extCodeFiler.add(filter, BooleanClauseOccur.SHOULD);

            booleanFilter.add(extCodeFiler, BooleanClauseOccur.MUST);
        }

        BooleanQuery searchName = new BooleanQueryImpl();

        searchName.addTerm(Field.NAME,
                StringUtil.quote(Validator.isNotNull(keyword) ?
                        keyword : StringPool.BLANK, StringPool.PERCENT), true);

        BooleanQuery query = new BooleanQueryImpl();
        query.addRequiredTerm(EmployeeIndexerKeys.CUSTOMER_ID, String.valueOf(customerId));
        query.setPreBooleanFilter(booleanFilter);

        if (Validator.isNotNull(keyword)) {
            query.add(searchName, BooleanClauseOccur.MUST);
        }

        return query;
    }

    // TODO

    public Page<EmployeeReference> getEmployeeExternalReferencesPage(long customerId,
                                                             String search,
                                                             Filter filter,
                                                             Pagination pagination,
                                                             Sort[] sorts,
                                                             ServiceContext serviceContext) throws Exception {
        pagination = Pagination.of(pagination.getPage(), DEFAULT_PAGE_SIZE);

        List<EmployeeReference> employeeReferences =
                _mapper.mapEmployeeReferencesFromDocuments(
                        searchEmployeeExternalReference(
                                serviceContext.getCompanyId(),
                                customerId,
                                search,
                                filter,
                                sorts,
                                pagination.getStartPosition(),
                                pagination.getEndPosition()));

        return Page.of(employeeReferences, pagination, employeeReferences.size());
    }

    public Document[] searchEmployeeExternalReference(long companyId,
                                              long customerId,
                                              String keyword,
                                              Filter filter,
                                              Sort[] sorts,
                                              int start,
                                              int end) throws SearchException, ParseException {

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        searchContext.setSorts(sorts);
        searchContext.setStart(start);
        searchContext.setEnd(end);


        BooleanQuery booleanQuery = buildQueryExternal(customerId, keyword, filter);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }


    private BooleanQuery buildQueryExternal(long customerId,
                                    String keyword,
                                    Filter filter) throws ParseException {


        TermFilter employeeFilter = new TermFilter(Field.ENTRY_CLASS_NAME, EmployeeIndexerKeys.EMPLOYEE_CLASS_NAME);
        TermFilter departmentFilter = new TermFilter(Field.ENTRY_CLASS_NAME, EmployeeIndexerKeys.DEPARTMENT_CLASS_NAME);
        TermFilter positionFilter = new TermFilter(Field.ENTRY_CLASS_NAME, EmployeeIndexerKeys.POSITION_CLASS_NAME);
        TermFilter titleFilter = new TermFilter(Field.ENTRY_CLASS_NAME, EmployeeIndexerKeys.TITLE_CLASS_NAME);

        BooleanFilter booleanFilter = new BooleanFilter();

        BooleanFilter classNameFilter = new BooleanFilter();

        classNameFilter.add(employeeFilter, BooleanClauseOccur.SHOULD);
        classNameFilter.add(departmentFilter, BooleanClauseOccur.SHOULD);
        classNameFilter.add(positionFilter, BooleanClauseOccur.SHOULD);
        classNameFilter.add(titleFilter, BooleanClauseOccur.SHOULD);

        booleanFilter.add(classNameFilter, BooleanClauseOccur.MUST);

        if (Validator.isNotNull(filter)) {
            BooleanFilter extCodeFiler = new BooleanFilter();
            extCodeFiler.add(filter, BooleanClauseOccur.SHOULD);

            booleanFilter.add(extCodeFiler, BooleanClauseOccur.MUST);
        }

        BooleanQuery searchName = new BooleanQueryImpl();

        searchName.addTerm(Field.NAME,
                StringUtil.quote(Validator.isNotNull(keyword) ?
                        keyword : StringPool.BLANK, StringPool.PERCENT), true);

        BooleanQuery query = new BooleanQueryImpl();
        query.addRequiredTerm(EmployeeIndexerKeys.CUSTOMER_ID, String.valueOf(customerId));
        query.setPreBooleanFilter(booleanFilter);

        if (Validator.isNotNull(keyword)) {
            query.add(searchName, BooleanClauseOccur.MUST);
        }

        return query;
    }

    // FIXME

    @Reference
    private EmployeeReferenceMapper _mapper;
}
