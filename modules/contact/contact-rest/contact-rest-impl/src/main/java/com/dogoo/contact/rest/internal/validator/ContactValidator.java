package com.dogoo.contact.rest.internal.validator;


import com.dogoo.common.exception.model.DG_FieldDuplicateException;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.contact.rest.dto.v2_0.Contact;
import com.dogoo.contact.rest.dto.v2_0.Email;
import com.dogoo.contact.rest.dto.v2_0.Phone;
import com.dogoo.contact.rest.internal.service.LanguageService;
import com.dogoo.contact.rest.internal.util.LanguageKeys;
import com.dogoo.contact.service.exception.NoSuchContactEntryException;
import com.dogoo.contact.service.model.ContactEntry;
import com.dogoo.contact.service.service.ContactEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;

@Component(
        immediate = true,
        service = ContactValidator.class
)
public class ContactValidator {


    public void validateForAdd(long customerId,
                               Contact contact,
                               Locale locale)
            throws DG_FieldRequiredException,
            DG_NoSuchEntryException,
            DG_FieldDuplicateException {
        validateProvided(contact, locale);
        validateForSubContact(contact, customerId, locale);


    }

    public void validateForDelete(
            long contactId,
            Locale locale)
            throws NoSuchContactEntryException {
        validateContactEntryExist(contactId, locale);

    }

    public void validateForUpdate(long customerId,
                                  long contactId,
                                  Contact contact,
                                  Locale locale)
            throws NoSuchContactEntryException,
            DG_FieldRequiredException,
            DG_NoSuchEntryException,
            DG_FieldDuplicateException {
        validateContactEntryExist(contactId, locale);
        validateProvided(contact, locale);
        validateForSubContact(contact, customerId, locale);
    }

    private void validateForSubContact(Contact contact, long customerId, Locale locale)
            throws DG_FieldRequiredException,
            DG_NoSuchEntryException,
            DG_FieldDuplicateException {
        if (contact.getEmails().length > 0) {

            for (Email email : contact.getEmails()) {
                _emailValidator.validateForAdd(customerId, email, locale);
            }

        }
        if (contact.getPhones().length > 0) {

            for (Phone phone : contact.getPhones()) {
                _phoneValidator.validateForAdd(customerId, phone, locale);
            }

        }
    }

    private void validateProvided(Contact contact, Locale locale)
            throws DG_FieldRequiredException {
        if (contact.getPhones() == null)
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, LanguageKeys.CONTACT_ENTRY_PHONE_NOT_PROVIDED));
        if (contact.getEmails() == null)
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, LanguageKeys.CONTACT_ENTRY_EMAILS_NOT_PROVIDED));
    }

    public void validateContactEntryExist(long contactId, Locale locale)
            throws NoSuchContactEntryException {
        ContactEntry entry = _contactEntryLocalService.fetchContactEntry(contactId);
        if (entry == null) {
            throw new NoSuchContactEntryException(
                    _languageService.getMessage(locale, LanguageKeys.CONTACT_ENTRY_NOT_FOUND));
        }

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
    private ContactEntryLocalService _contactEntryLocalService;

    @Reference
    private EmailValidator _emailValidator;

    @Reference
    private PhoneValidator _phoneValidator;


}
