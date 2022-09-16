package com.dogoo.department.rest.internal.resource.v2_0;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.department.rest.dto.v2_0.Business;
import com.dogoo.department.rest.internal.mapper.BusinessMapper;
import com.dogoo.department.rest.internal.odata.v2_0.BusinessEntityModel;
import com.dogoo.department.rest.internal.service.BusinessService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.dogoo.department.rest.internal.validator.BusinessValidator;
import com.dogoo.department.rest.resource.v2_0.BusinessResource;
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
        properties = "OSGI-INF/liferay/rest/v2_0/business.properties",
        scope = ServiceScope.PROTOTYPE, service = BusinessResource.class
)
public class BusinessResourceImpl extends BaseBusinessResourceImpl {

    private final BusinessEntityModel businessEntityModel = new BusinessEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return businessEntityModel;
    }

    @Override
    public Page<Business> getBusinesssPage(String search,
                                           Filter filter,
                                           Pagination pagination,
                                           Sort[] sorts) throws Exception {

        return _service.getBusinesssPage(
                getUserToken().getCustomerId(),
                search,
                filter,
                pagination,
                sorts,
                getServiceContext());
    }

    @Override
    public Business postBusiness(Business business) throws Exception {
        _validator.validateForAdd(
                getUserToken().getCustomerId(),
                business,
                getLocale());

        return _service.addBusiness(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                business,
                getServiceContext());
    }

    @Override
    public void deleteBusiness(Long businessId) throws Exception {

        _validator.validateForDelete(
                getUserToken().getCustomerId(),
                businessId,
                getLocale());

        _service.deleteBusiness(businessId);
    }

    @Override
    public Business getBusiness(Long businessId) throws Exception {
        _validator.validateBusinessEntryExist(
                businessId,
                getLocale());

        return _service.getBusinessById(businessId);
    }

    @Override
    public Business putBusiness(Long businessId, Business business) throws Exception {

        _validator.validateForUpdate(
                getUserToken().getCustomerId(),
                businessId,
                business,
                getLocale());

        return _service.updateBusiness(
                getUserToken().getUserId(),
                businessId,
                business,
                getServiceContext());
    }

    @Override
    public void deleteBusinessByExternalReferenceCode(String externalReferenceCode)
            throws Exception {

        long businessId = _mapper.getBusinessEntryId(externalReferenceCode);

        deleteBusiness(businessId);
    }

    @Override
    public Business getBusinessByExternalReferenceCode(String externalReferenceCode)
            throws Exception {
        long businessId = _mapper.getBusinessEntryId(externalReferenceCode);

        return getBusiness(businessId);
    }

    @Override
    public Business putBusinessByExternalReferenceCode(
            String externalReferenceCode,
            Business business) throws Exception {

        long businessId = _mapper.getBusinessEntryId(externalReferenceCode);

        return putBusiness(businessId, business);
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
    private BusinessService _service;

    @Reference
    private BusinessValidator _validator;

    @Reference
    private BusinessMapper _mapper;


}