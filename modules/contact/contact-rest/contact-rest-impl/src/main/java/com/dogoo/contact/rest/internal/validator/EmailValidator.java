package com.dogoo.contact.rest.internal.validator;


import com.dogoo.common.exception.model.DG_FieldDuplicateException;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.contact.rest.dto.v2_0.Email;
import com.dogoo.contact.rest.internal.service.LanguageService;
import com.dogoo.contact.rest.internal.util.LanguageKeys;
import com.dogoo.contact.service.model.EmailEntry;
import com.dogoo.contact.service.service.EmailEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;

@Component(
        immediate = true,
        service = EmailValidator.class
)
public class EmailValidator {

    public void validateForAdd(long customerId,
                               Email email,
                               Locale locale)
            throws DG_FieldDuplicateException,
            DG_FieldRequiredException{
        validateProvided(email, locale);
        validateEmailAddressForAdd(customerId, email.getEmailAddress(), locale);
    }

    public void validateForUpdate(long customerId,
                                  Email email,
                                  Locale locale)
            throws DG_FieldRequiredException,
            DG_FieldDuplicateException {
        validateForAdd(customerId, email, locale);

    }

    public void validateForDelete() {

    }

    private void validateProvided(Email email, Locale locale)
            throws DG_FieldRequiredException{
        isNotPopulated(email.getEmailAddress(), LanguageKeys.EMAIL_ENTRY_EMAIL_ADDRESS_NOT_PROVIDED, locale);
        isNotPopulated(email.getIsDefaulted(), LanguageKeys.EMAIL_ENTRY_EMAIL_IS_DEFAULTED_NOT_PROVIDED, locale);
    }


    private void validateEmailAddressForAdd(long customerId, String emailAddress, Locale locale)
            throws DG_FieldDuplicateException {

        EmailEntry entry = _emailEntryLocalService.fetchEmailEntryByEmailAddress(customerId, emailAddress);
        if (entry == null) return;

        throw new DG_FieldDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.EMAIL_ENTRY_EMAIL_ADDRESS_DUPLICATED));


    }



    private void isNotPopulated(Serializable value,
                                String errorMsgKey,
                                Locale locale)
            throws DG_FieldRequiredException {
        if (null == value ||  value.toString().trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private EmailEntryLocalService _emailEntryLocalService;
}
