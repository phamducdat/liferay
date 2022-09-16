package com.dogoo.department.rest.internal.validator;

import com.dogoo.common.exception.model.DG_EntryAssociatedException;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NameDuplicateException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.department.rest.dto.v2_0.Business;
import com.dogoo.department.rest.internal.service.LanguageService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.dogoo.department.service.model.BusinessEntry;
import com.dogoo.department.service.service.BusinessEntryLocalService;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;

@Component(
        immediate = true,
        service = BusinessValidator.class
)
public class BusinessValidator {

    public void validateForAdd(long customerId,
                               Business business,
                               Locale locale)
            throws PortalException {
        isNotPopulated(business.getName(), LanguageKeys.BUSINESS_ENTRY_NAME_NOT_PROVIDED, locale);
        validateForNameAdd(customerId, business.getName(), locale);
    }

    public void validateForUpdate(long customerId,
                                  long businessId,
                                  Business business,
                                  Locale locale)
            throws PortalException {
        validateBusinessEntryExist(businessId, locale);
        isNotPopulated(business.getName(), LanguageKeys.BUSINESS_ENTRY_NAME_NOT_PROVIDED, locale);
        ValidateForNameUpdate(customerId,
                businessId,
                business.getName(),
                locale);

    }

    public void validateForDelete(long customerId,
                                  long businessId,
                                  Locale locale)
            throws DG_NoSuchEntryException, DG_EntryAssociatedException {
//        validateBusinessEntryExist(businessId, locale);
//        List<DepartmentEntry> departmentEntries = _departmentEntryLocalService.(customerId, businessId);
//        if (departmentEntries.size() > 0) throw new DG_EntryAssociatedException(
//                _languageService.getMessage(locale, LanguageKeys.BUSINESS_ENTRY_USED)
        return;
//        );
    }

    private void validateForNameAdd(long customerId,
                                    String name,
                                    Locale locale)
            throws PortalException {
        BusinessEntry entry = _localService.fetchBusinessEntry(customerId, name);
        if (Validator.isNull(entry)) return;
        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.BUSINESS_ENTRY_NAME_DUPLICATE)
        );
    }

    private void ValidateForNameUpdate(long customerId,
                                       long businessId,
                                       String name,
                                       Locale locale) throws PortalException {
        BusinessEntry entry = _localService.fetchBusinessEntry(customerId, name);
        if (entry.getBusinessId() == businessId) return;
        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.BUSINESS_ENTRY_NAME_DUPLICATE)
        );
    }

    public void validateBusinessEntryExist(
            Long businessId,
            Locale locale
    ) throws DG_NoSuchEntryException {
        if (businessId == null) return;
        BusinessEntry entry = _localService.fetchBusinessEntry(businessId);
        if (Validator.isNotNull(entry)) return;
        throw new DG_NoSuchEntryException(
                _languageService.getMessage(locale, LanguageKeys.BUSINESS_ENTRY_NOT_FOUND));
    }

    private void isNotPopulated(Serializable value,
                                String errorMsgKey,
                                Locale locale) throws DG_FieldRequiredException {
        if (null == value || value.toString().trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private BusinessEntryLocalService _localService;

    @Reference
    private DepartmentEntryLocalService _departmentEntryLocalService;


}
