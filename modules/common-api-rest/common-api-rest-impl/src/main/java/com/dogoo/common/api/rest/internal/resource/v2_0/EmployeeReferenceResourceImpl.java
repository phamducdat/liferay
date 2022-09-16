package com.dogoo.common.api.rest.internal.resource.v2_0;

import com.dogoo.common.api.rest.dto.v2_0.EmployeeReference;
import com.dogoo.common.api.rest.internal.odata.v2_0.ReferenceEntryModel;
import com.dogoo.common.api.rest.internal.service.EmployeeReferenceService;
import com.dogoo.common.api.rest.resource.v2_0.EmployeeReferenceResource;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
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

/**
 * @author khoa
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/employee-reference.properties",
	scope = ServiceScope.PROTOTYPE, service = EmployeeReferenceResource.class
)
public class EmployeeReferenceResourceImpl
	extends BaseEmployeeReferenceResourceImpl {

	private final EntityModel entityModel = new ReferenceEntryModel();

	@Override
	public Page<EmployeeReference> getEmployeeReferencesPage(String search,
															 Filter filter,
															 Pagination pagination,
															 Sort[] sorts) throws Exception {

		return _service
				.getEmployeeReferencesPage(
						getUserToken().getCustomerId(),
						search,
						filter,
						pagination,
						sorts,
						getServiceContext());
	}

	@Override
	public Page<EmployeeReference> getEmployeeExternalReferencesPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		return _service
				.getEmployeeExternalReferencesPage(
						getUserToken().getCustomerId(),
						search,
						filter,
						pagination,
						sorts,
						getServiceContext());
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
		return entityModel;
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
	private EmployeeReferenceService _service;
}