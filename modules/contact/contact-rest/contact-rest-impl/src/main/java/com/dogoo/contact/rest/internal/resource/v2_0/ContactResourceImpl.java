package com.dogoo.contact.rest.internal.resource.v2_0;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.contact.rest.dto.v2_0.Contact;
import com.dogoo.contact.rest.internal.mapper.ContactMapper;
import com.dogoo.contact.rest.internal.odata.v2_0.ContactEntryModel;
import com.dogoo.contact.rest.internal.service.ContactService;
import com.dogoo.contact.rest.internal.util.LanguageKeys;
import com.dogoo.contact.rest.internal.validator.ContactValidator;
import com.dogoo.contact.rest.resource.v2_0.ContactResource;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Locale;

/**
 * @author khoa
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/contact.properties",
        scope = ServiceScope.PROTOTYPE, service = ContactResource.class
)
public class ContactResourceImpl extends BaseContactResourceImpl {
    private final ContactEntryModel contactEntryModel = new ContactEntryModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return contactEntryModel;
    }

    @Override
    public Contact postContact(Contact contact) throws Exception {
        _validator.validateForAdd(
                getUserToken().getCustomerId(),
                contact,
                getLocale());

        return _contactService.addContact(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                contact,
                getServiceContext());
    }

    @Override
    public void deleteContact(Long contactId) throws Exception {
        _validator.validateForDelete(contactId, getLocale());
        _contactService.deleteContact(contactId);
    }

    @Override
    public Contact putContact(Long contactId, Contact contact) throws Exception {
        _validator.validateForUpdate(
                getUserToken().getCustomerId(),
                contactId,
                contact,
                getLocale()
        );
        return _contactService.updateContact(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                contactId, contact, getServiceContext());
    }


    public Page<Contact> getContactsPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        return _contactService.getContactsPage(
                getUserToken().getCustomerId(),
                search,
                filter,
                pagination,
                sorts,
                getServiceContext()
        );
    }

    @Override
    public Contact getContact(Long contactId) throws Exception {
        _validator.validateContactEntryExist(contactId, getLocale());
        return _contactService.getContactById(contactId);
    }

    @Override
    public void deleteContactByExternalReferenceCode(String externalReferenceCode) throws Exception {
        long contactId = _contactMapper.getContactEntryId(externalReferenceCode);
        deleteContact(contactId);
    }

    @Override
    public Contact putContactByExternalReferenceCode(String externalReferenceCode, Contact contact) throws Exception {
        long contactId = _contactMapper.getContactEntryId(externalReferenceCode);
        return putContact(contactId, contact);
    }

    @Override
    public Contact getContactByExternalReferenceCode(String externalReferenceCode) throws Exception {
        long contactId = _contactMapper.getContactEntryId(externalReferenceCode);
        return getContact(contactId);
    }


    public Locale getLocale() {

        Locale locale = contextHttpServletRequest.getLocale();

        if (locale.getLanguage().isEmpty()) {
            locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
        }

        return locale;
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;

    }

    private UserTokenModel getUserToken() {
        return _tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper _tokenHelper;

    @Reference
    private ContactValidator _validator;

    @Reference
    private ContactService _contactService;

    @Reference
    private ContactMapper _contactMapper;


}