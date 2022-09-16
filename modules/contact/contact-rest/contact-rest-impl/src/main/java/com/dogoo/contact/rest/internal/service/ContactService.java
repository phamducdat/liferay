package com.dogoo.contact.rest.internal.service;


import com.dogoo.contact.rest.dto.v2_0.Contact;
import com.dogoo.contact.rest.dto.v2_0.Email;
import com.dogoo.contact.rest.dto.v2_0.Phone;
import com.dogoo.contact.rest.internal.mapper.ContactMapper;
import com.dogoo.contact.service.constant.SearchFields;
import com.dogoo.contact.service.model.ContactEntry;
import com.dogoo.contact.service.model.EmailEntry;
import com.dogoo.contact.service.model.PhoneEntry;
import com.dogoo.contact.service.service.ContactEntryLocalService;
import com.dogoo.contact.service.service.EmailEntryLocalService;
import com.dogoo.contact.service.service.PhoneEntryLocalService;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component(
        immediate = true,
        service = ContactService.class
)
public class ContactService {

    public Page<Contact> getContactsPage(long customerId,
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
                ContactEntry.class.getName(),
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
                    long contactId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _contactMapper.mapContactFromContactEntry(
                            _contactEntryLocalService.getContactEntry(contactId));
                });

    }


    public Contact addContact(long customerId,
                              long creatorId,
                              Contact contact,
                              ServiceContext context) {
        ContactEntry to = _contactEntryLocalService.addContactEntry(
                customerId, creatorId,
                contact.getFacebook(),
                contact.getTwitter(),
                contact.getLinkedin(),
                context);


        addEmailList(Arrays.asList(contact.getEmails()),
                customerId,
                creatorId,
                to.getContactId(),
                context
        );

        addPhoneList(Arrays.asList(contact.getPhones()),
                customerId,
                creatorId,
                to.getContactId(),
                context
        );
        return _contactMapper.mapContactFromContactEntry(to);
    }

    public Contact updateContact(long customerId,
                                 long creatorId,
                                 long entryId,
                                 Contact contact,
                                 ServiceContext context) throws PortalException {
        ContactEntry to = _contactEntryLocalService.updateContactEntry(
                customerId,
                entryId,
                contact.getFacebook(),
                contact.getTwitter(),
                contact.getLinkedin(),
                context
        );
        deleteEmailList(customerId, to.getContactId());
        deletePhoneList(customerId, to.getContactId());
        addEmailList(Arrays.asList(contact.getEmails()),
                customerId,
                creatorId,
                to.getContactId(),
                context
        );

        addPhoneList(Arrays.asList(contact.getPhones()),
                customerId,
                creatorId,
                to.getContactId(),
                context
        );
        return _contactMapper.mapContactFromContactEntry(to);
    }

    public Contact getContactById(long contactId) throws PortalException {
        ContactEntry entry = _contactEntryLocalService.getContactEntry(contactId);
        return _contactMapper.mapContactFromContactEntry(entry);
    }

    public void deleteContact(long contactId) throws PortalException {
        ContactEntry entry = _contactEntryLocalService.getContactEntry(contactId);
        deleteEmailList(entry.getCustomerId(), contactId);
        deletePhoneList(entry.getCustomerId(), contactId);
        _contactEntryLocalService.deleteContactEntry(contactId);
    }


    public void addEmailList(List<Email> from, long customerId, long creatorId, long contactId, ServiceContext context) {
        from.forEach(item -> {
            _emailEntryLocalService.addEmailEntry(
                    customerId,
                    creatorId,
                    contactId,
                    item.getEmailAddress(),
                    item.getDescription(),
                    item.getIsDefaulted(),
                    context
            );
        });
    }

    public void addPhoneList(List<Phone> from, long customerId, long creatorId, long contactId, ServiceContext context) {
        from.forEach(item -> {
            _phoneEntryLocalService.addPhoneEntry(
                    customerId,
                    creatorId,
                    contactId,
                    item.getNumber(),
                    item.getDescription(),
                    item.getIsDefaulted(),
                    context
            );
        });
    }

    public void deleteEmailList(long customerId, long contactId) {
        List<EmailEntry> emailEntries = _emailEntryLocalService.getEmailEntriesByContactId(customerId, contactId);
        emailEntries.forEach(item -> {
            try {
                _emailEntryLocalService.deleteEmailEntry(item.getEmailId());
            } catch (PortalException e) {
                e.printStackTrace();
            }
        });

    }


    public void deletePhoneList(long customerId, long contactId) {
        List<PhoneEntry> emailEntries = _phoneEntryLocalService.getPhoneEntriesByContactId(customerId, contactId);
        emailEntries.forEach(item -> {
            try {
                _phoneEntryLocalService.deletePhoneEntry(item.getPhoneId());
            } catch (PortalException e) {
                e.printStackTrace();
            }
        });

    }




    @Reference
    private ContactEntryLocalService _contactEntryLocalService;

    @Reference
    private EmailEntryLocalService _emailEntryLocalService;

    @Reference
    private PhoneEntryLocalService _phoneEntryLocalService;


    @Reference
    private ContactMapper _contactMapper;
}
