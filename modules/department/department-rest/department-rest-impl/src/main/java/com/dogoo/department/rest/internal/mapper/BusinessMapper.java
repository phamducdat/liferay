package com.dogoo.department.rest.internal.mapper;


import com.dogoo.department.rest.dto.v2_0.Business;
import com.dogoo.department.service.model.BusinessEntry;
import com.dogoo.department.service.service.BusinessEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = BusinessMapper.class
)
public class BusinessMapper {


    public Business mapBusinessFromBusinessEntry(BusinessEntry from) {
        if (from == null)  return null;
        Business to  = new Business();

        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setId(from.getBusinessId());
        to.setName(from.getName());

        return to;
    }

    public long getBusinessEntryId(String referenceCode) {
        BusinessEntry entry = getObject(referenceCode);
        if (Validator.isNull(entry)) {
            return 0l;
        }

        return entry.getBusinessId();
    }

    public BusinessEntry getObject(String referenceCode) {
        BusinessEntry businessEntry =
                _businessEntryLocalService.fetchBusinessEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(),
                        referenceCode
                );
        if (businessEntry == null) {
            businessEntry = _businessEntryLocalService.fetchBusinessEntry(
                    GetterUtil.getLong(referenceCode)
            );
        }
        return businessEntry;
    }

    @Reference
    private BusinessEntryLocalService _businessEntryLocalService;
}
