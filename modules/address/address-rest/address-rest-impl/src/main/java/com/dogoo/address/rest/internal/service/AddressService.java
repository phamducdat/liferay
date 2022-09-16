package com.dogoo.address.rest.internal.service;

import com.dogoo.address.rest.dto.v2_0.Address;
import com.dogoo.address.rest.internal.mapper.AddressMapper;
import com.dogoo.address.service.constant.SearchFields;
import com.dogoo.address.service.model.AddressEntry;
import com.dogoo.address.service.service.AddressEntryLocalService;
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
        service = com.dogoo.address.rest.internal.service.AddressService.class
)

public class AddressService {
    public Page<Address> getAddresses(long customerId,
                                      String search,
                                      Filter filter,
                                      Pagination pagination,
                                      Sort[] sorts,
                                      ServiceContext serviceContext) throws Exception {
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
                AddressEntry.class.getName(),
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
                    long addressId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _addressMapper.mapFromAddressEntryToAddress(
                            _addressEntryLocalService.getAddressEntry(addressId));
                });
    }

    public Address getAddressById(long addressId) throws PortalException {
        AddressEntry addressEntry = _addressEntryLocalService.getAddressEntry(addressId);

        return _addressMapper.mapFromAddressEntryToAddress(addressEntry);
    }

    public Address addAddress(long customerId,
                               long creatorId,
                               Address address,
                               ServiceContext serviceContext) {
        AddressEntry addressEntry = _addressEntryLocalService.addAddress(
                address.getDetail(),
                address.getPostalCode(),
                address.getWard(),
                address.getDistrict(),
                address.getProvince(),
                address.getCountry(),
                address.getWardCode(),
                address.getDistrictCode(),
                address.getProvinceCode(),
                address.getCountryCode(),
                address.getTitle(),
                customerId,
                creatorId,
                serviceContext
        );

        return _addressMapper.mapFromAddressEntryToAddress(addressEntry);
    }

    public Address updateAddress(long creatorId,
                                 long addressId,
                                 Address address,
                                 ServiceContext serviceContext) throws PortalException {
        AddressEntry addressEntry = _addressEntryLocalService.updateAddress(
                addressId,
                address.getDetail(),
                address.getPostalCode(),
                address.getWard(),
                address.getDistrict(),
                address.getProvince(),
                address.getCountry(),
                address.getWardCode(),
                address.getDistrictCode(),
                address.getProvinceCode(),
                address.getCountryCode(),
                address.getTitle(),
                creatorId,
                serviceContext
        );

        return _addressMapper.mapFromAddressEntryToAddress(addressEntry);
    }

    public void deleteAddress(long addressId) throws PortalException {
        _addressEntryLocalService.deleteAddressEntry(addressId);
    }

    @Reference
    private AddressMapper _addressMapper;

    @Reference
    private AddressEntryLocalService _addressEntryLocalService;
}
