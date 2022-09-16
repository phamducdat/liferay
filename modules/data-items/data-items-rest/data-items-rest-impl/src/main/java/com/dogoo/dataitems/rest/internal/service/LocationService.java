package com.dogoo.dataitems.rest.internal.service;

import com.dogoo.dataitems.rest.dto.v2_0.Location;
import com.dogoo.dataitems.rest.internal.mapper.LocationMapper;
import com.dogoo.dataitems.service.constant.SearchFields;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
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

@Component(immediate = true, service = LocationService.class)
public class LocationService {

    private final String CUSTOMER_GLOBAL_ID = "0";
    private final int DEFAULT_PAGE_SIZE = 5;

    public Page<Location> getLocationsPage(String search,
                                           Filter filter,
                                           Pagination pagination,
                                           Sort[] sorts,
                                           ServiceContext serviceContext) throws Exception {

        pagination = Pagination.of(pagination.getPage(), DEFAULT_PAGE_SIZE);

        List<Location> locations = _mapper.mapLocationListFromDocuments(
                searchLocation(
                        serviceContext.getCompanyId(),
                        search,
                        sorts,
                        pagination.getStartPosition(),
                        pagination.getEndPosition()));

        return Page.of(locations, pagination, locations.size());

    }

    public Document[] searchLocation(long companyId,
                                     String keyword,
                                     Sort [] sort,
                                     int start,
                                     int end) throws SearchException, ParseException {

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        searchContext.setStart(start);
        searchContext.setEnd(end);
        searchContext.setSorts(sort);

        BooleanQuery booleanQuery = buildQuery(keyword);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }


    private BooleanQuery buildQuery(String keyword) throws ParseException {

        TermFilter customerIdFilter = new TermFilter(SearchFields.CUSTOMER_ID, CUSTOMER_GLOBAL_ID);
        TermFilter typeFilter = new TermFilter(Field.TYPE, SearchFields.LOCATION_TYPE);

        BooleanFilter booleanFilter = new BooleanFilter();
        booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(typeFilter, BooleanClauseOccur.MUST);

        BooleanQuery searchName = new BooleanQueryImpl();

        BooleanQuery searchTitle = new BooleanQueryImpl();
        BooleanQuery searchTitleVn = new BooleanQueryImpl();

        searchTitle.addTerm(Field.TITLE,
                StringUtil.quote(Validator.isNotNull(keyword) ?
                        keyword : StringPool.BLANK, StringPool.PERCENT), true);

        searchTitleVn.addTerm(SearchFields.LOCATION_TITLE_VN,
                StringUtil.quote(Validator.isNotNull(keyword) ?
                        keyword : StringPool.BLANK, StringPool.PERCENT), true);

        searchName.add(searchTitle, BooleanClauseOccur.SHOULD);
        searchName.add(searchTitleVn, BooleanClauseOccur.SHOULD);

        BooleanQuery query = new BooleanQueryImpl();
        query.addRequiredTerm(Field.ENTRY_CLASS_NAME, DataItemEntry.class.getName());
        query.setPreBooleanFilter(booleanFilter);

        if (Validator.isNotNull(keyword)) {
            query.add(searchName, BooleanClauseOccur.MUST);
        }

        return query;
    }

    @Reference
    LocationMapper _mapper;

}
