package com.dogoo.address.rest.internal.mapper;

import com.dogoo.address.rest.dto.v2_0.Address;
import com.dogoo.address.service.model.AddressEntry;
import com.dogoo.address.service.service.AddressEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        service = AddressMapper.class
)
public class AddressMapper {
    public Address mapFromAddressEntryToAddress(AddressEntry from) {

        Address to = new Address();

        to.setId(from.getAddressId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setDetail(from.getDetail());
        to.setPostalCode(from.getPostalCode());
        to.setWard(from.getWard());
        to.setDistrict(from.getDistrict());
        to.setProvince(from.getProvince());
        to.setCountry(from.getCountry());
        to.setWardCode(from.getWardCode());
        to.setDistrictCode(from.getDistrictCode());
        to.setProvinceCode(from.getProvinceCode());
        to.setCountryCode(from.getCountryCode());
        to.setTitle(from.getTitle());

        return to;
    }

    public long getAddressEntryId(String referenceCode) {
        AddressEntry addressEntry = getObject(referenceCode);

        if (Validator.isNull(addressEntry)) {return 0l;}

        return addressEntry.getAddressId();
    }

    public AddressEntry getObject(String referenceCode) {
        AddressEntry petEntry =
                _addressEntryLocalService.fetchAddressEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(),
                        referenceCode);

        if (petEntry == null) {
            petEntry = _addressEntryLocalService
                    .fetchAddressEntry(GetterUtil.getLong(referenceCode));
        }

        return petEntry;
    }

    @Reference
    private AddressEntryLocalService _addressEntryLocalService;
}
