package com.dogoo.contact.rest.internal.validator;


import com.dogoo.common.exception.model.DG_FieldDuplicateException;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.contact.rest.dto.v2_0.Phone;
import com.dogoo.contact.rest.internal.service.LanguageService;
import com.dogoo.contact.rest.internal.util.LanguageKeys;
import com.dogoo.contact.service.model.PhoneEntry;
import com.dogoo.contact.service.service.PhoneEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;

@Component(
        immediate = true,
        service = PhoneValidator.class
)
public class PhoneValidator {

    public void validateForAdd(long customerId,
                               Phone phone,
                               Locale locale)
            throws DG_FieldDuplicateException,
            DG_FieldRequiredException,
            DG_NoSuchEntryException {
        validateProvided(phone, locale);
        validateNumberForAdd(customerId, phone.getNumber(), locale);
    }

    public void validateForUpdate(long customerId,
                                  Phone phone,
                                  Locale locale)
            throws DG_FieldRequiredException,
            DG_FieldDuplicateException,
            DG_NoSuchEntryException {
        validateForAdd(customerId, phone, locale);

    }

    public void validateForDelete() {

    }

    private void validateProvided(Phone phone, Locale locale)
            throws DG_FieldRequiredException {
        isNotPopulated(phone.getNumber(), LanguageKeys.PHONE_ENTRY_NUMBER_NOT_PROVIDED, locale);
        isNotPopulated(phone.getIsDefaulted(), LanguageKeys.PHONE_ENTRY_PHONE_IS_DEFAULTED_NOT_PROVIDED, locale);
    }


    private void validateNumberForAdd(long customerId, String number, Locale locale)
            throws DG_FieldDuplicateException {
        PhoneEntry entry = _phoneEntryLocalService.fetchPhoneEntryByNumber(customerId, number);
        if (entry == null) return;

        throw new DG_FieldDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.PHONE_ENTRY_NUMBER_IS_DUPLICATED));


    }


    private void isNotPopulated(Serializable value,
                                String errorMsgKey,
                                Locale locale)
            throws DG_FieldRequiredException {
        if (null == value || value.toString().trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private PhoneEntryLocalService _phoneEntryLocalService;
}
