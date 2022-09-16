package com.dogoo.department.rest.internal.service;


import com.dogoo.department.rest.dto.v2_0.Business;
import com.dogoo.department.rest.internal.mapper.BusinessMapper;
import com.dogoo.department.service.constant.SearchFields;
import com.dogoo.department.service.model.BusinessEntry;
import com.dogoo.department.service.service.BusinessEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(
        immediate = true,
        service = BusinessService.class
)
public class BusinessService {

    public Page<Business> getBusinesssPage(long customerId,
                                           String search,
                                           Filter filter,
                                           Pagination pagination,
                                           Sort[] sorts,
                                           ServiceContext serviceContext) throws Exception {

//        List<Business> businessList = new ArrayList<>();
//
//        for (BusinessEntry entry : _localService.getBusinessEntries(-1, -1)) {
//            businessList.add(_mapper.mapBusinessFromBusinessEntry(entry));
//        }
//        return Page.of(businessList);
        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    TermFilter customerIdFilter =
                            new TermFilter(SearchFields.CUSTOMER_ID, String.valueOf(customerId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                BusinessEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long businessId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _mapper.mapBusinessFromBusinessEntry(
                            _localService.getBusinessEntry(businessId));
                });

    }

    public Business addBusiness(
            long customerId,
            long creatorId,
            Business business,
            ServiceContext context) {
        BusinessEntry entry = _localService.addBusinessEntry(
                customerId,
                creatorId,
                business.getName(),
                context
        );
        return _mapper.mapBusinessFromBusinessEntry(entry);
    }

    public Business updateBusiness(
            long creatorId,
            long businessId,
            Business business,
            ServiceContext context
    ) throws PortalException {
        BusinessEntry entry = _localService.updateBusinessEntry(
                creatorId,
                businessId,
                business.getName(),
                context
        );

        return _mapper.mapBusinessFromBusinessEntry(entry);
    }

    public void deleteBusiness(long businessId) throws PortalException {
        _localService.deleteBusinessEntry(businessId);
    }

    public Business getBusinessById(long businessId) {
        return _mapper.mapBusinessFromBusinessEntry(
                _localService.fetchBusinessEntry(businessId));
    }

    @Reference
    private BusinessEntryLocalService _localService;

    @Reference
    private BusinessMapper _mapper;
}
