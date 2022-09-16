package com.dogoo.contact.rest.internal.mapper;


import com.dogoo.contact.rest.dto.v2_0.Contact;
import com.dogoo.contact.service.model.ContactEntry;
import com.dogoo.contact.service.service.ContactEntryLocalService;
import com.dogoo.contact.service.service.EmailEntryLocalService;
import com.dogoo.contact.service.service.PhoneEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ContactMapper.class
)
public class ContactMapper {

    public Contact mapContactFromContactEntry(ContactEntry from) {

        Contact to  = new Contact();
        to.setId(from.getContactId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setFacebook(from.getFacebook());
        to.setTwitter(from.getTwitter());
        to.setLinkedin(from.getLinkedin());
        to.setEmails(
                _emailMapper.mapEmailListFromEmailEntries(
                        _emailEntryLocalService.getEmailEntriesByContactId(
                                from.getCustomerId(), from.getContactId()
                        )
                )
        );
        to.setPhones(
                _phoneMapper.mapPhoneListFromPhoneEntries(
                        _phoneEntryLocalService.getPhoneEntriesByContactId(
                                from.getCustomerId(), from.getContactId()
                        )
                )
        );

        return to;
    }

    public long getContactEntryId(String referenceCode) {
        ContactEntry entry = getObject(referenceCode);
        if (Validator.isNull(entry)) {return 0l;}

        return entry.getContactId();
    }

    public ContactEntry getObject(String referenceCode) {
        ContactEntry contactEntry =
                _contactEntryLocalService.fetchContactEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(),
                        referenceCode
                );
        if (contactEntry == null) {
            contactEntry = _contactEntryLocalService.fetchContactEntry(
                    GetterUtil.getLong(referenceCode)
            );
        }
        return contactEntry;
    }

    @Reference
    private EmailEntryLocalService _emailEntryLocalService;

    @Reference
    private PhoneEntryLocalService _phoneEntryLocalService;

    @Reference
    private EmailMapper _emailMapper;

    @Reference
    private PhoneMapper _phoneMapper;

    @Reference
    private ContactEntryLocalService _contactEntryLocalService;
}
