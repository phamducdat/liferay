package com.dogoo.dataitems.rest.internal.resource.v2_0;

import com.dogoo.dataitems.rest.dto.v2_0.Location;
import com.dogoo.dataitems.rest.internal.odata.v2_0.DataItemEntryModel;
import com.dogoo.dataitems.rest.internal.service.LocationService;
import com.dogoo.dataitems.rest.resource.v2_0.LocationResource;

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
	properties = "OSGI-INF/liferay/rest/v2_0/location.properties",
	scope = ServiceScope.PROTOTYPE, service = LocationResource.class
)
public class LocationResourceImpl extends BaseLocationResourceImpl {

	private final EntityModel _entityModel = new DataItemEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return _entityModel;
	}

	@Override
	public Page<Location> getLocationDatasPage(String search,
											   Filter filter,
											   Pagination pagination,
											   Sort[] sorts) throws Exception {

		return _service.getLocationsPage(
				search,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	@Reference
	private LocationService _service;
}