package com.dogoo.department.rest.internal.graphql.mutation.v2_0;

import com.dogoo.department.rest.dto.v2_0.Business;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.resource.v2_0.BusinessResource;
import com.dogoo.department.rest.resource.v2_0.DepartmentResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setBusinessResourceComponentServiceObjects(
		ComponentServiceObjects<BusinessResource>
			businessResourceComponentServiceObjects) {

		_businessResourceComponentServiceObjects =
			businessResourceComponentServiceObjects;
	}

	public static void setDepartmentResourceComponentServiceObjects(
		ComponentServiceObjects<DepartmentResource>
			departmentResourceComponentServiceObjects) {

		_departmentResourceComponentServiceObjects =
			departmentResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create new a Business")
	public Business createBusiness(@GraphQLName("business") Business business)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.postBusiness(business));
	}

	@GraphQLField
	public Response createBusinessBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.postBusinessBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete a Business")
	public boolean deleteBusiness(@GraphQLName("businessId") Long businessId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.deleteBusiness(businessId));

		return true;
	}

	@GraphQLField
	public Response deleteBusinessBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.deleteBusinessBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update a Business")
	public Business updateBusiness(
			@GraphQLName("businessId") Long businessId,
			@GraphQLName("business") Business business)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.putBusiness(
				businessId, business));
	}

	@GraphQLField
	public Response updateBusinessBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.putBusinessBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete a Business by externalReferenceCode")
	public boolean deleteBusinessByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource ->
				businessResource.deleteBusinessByExternalReferenceCode(
					externalReferenceCode));

		return true;
	}

	@GraphQLField(description = "Update a Business by externalReferenceCode")
	public Business updateBusinessByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("business") Business business)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource ->
				businessResource.putBusinessByExternalReferenceCode(
					externalReferenceCode, business));
	}

	@GraphQLField(description = "Create new a Department")
	public Department createDepartment(
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.postDepartment(
				department));
	}

	@GraphQLField
	public Response createDepartmentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.postDepartmentBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete a Department")
	public boolean deleteDepartment(
			@GraphQLName("departmentId") Long departmentId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.deleteDepartment(
				departmentId));

		return true;
	}

	@GraphQLField
	public Response deleteDepartmentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.deleteDepartmentBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update a Department")
	public Department updateDepartment(
			@GraphQLName("departmentId") Long departmentId,
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.putDepartment(
				departmentId, department));
	}

	@GraphQLField
	public Response updateDepartmentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.putDepartmentBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete a Department by externalReferenceCode")
	public boolean deleteDepartmentByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource ->
				departmentResource.deleteDepartmentByExternalReferenceCode(
					externalReferenceCode));

		return true;
	}

	@GraphQLField(description = "Update a Department by externalReferenceCode")
	public Department updateDepartmentByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource ->
				departmentResource.putDepartmentByExternalReferenceCode(
					externalReferenceCode, department));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(BusinessResource businessResource)
		throws Exception {

		businessResource.setContextAcceptLanguage(_acceptLanguage);
		businessResource.setContextCompany(_company);
		businessResource.setContextHttpServletRequest(_httpServletRequest);
		businessResource.setContextHttpServletResponse(_httpServletResponse);
		businessResource.setContextUriInfo(_uriInfo);
		businessResource.setContextUser(_user);
		businessResource.setGroupLocalService(_groupLocalService);
		businessResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(DepartmentResource departmentResource)
		throws Exception {

		departmentResource.setContextAcceptLanguage(_acceptLanguage);
		departmentResource.setContextCompany(_company);
		departmentResource.setContextHttpServletRequest(_httpServletRequest);
		departmentResource.setContextHttpServletResponse(_httpServletResponse);
		departmentResource.setContextUriInfo(_uriInfo);
		departmentResource.setContextUser(_user);
		departmentResource.setGroupLocalService(_groupLocalService);
		departmentResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<BusinessResource>
		_businessResourceComponentServiceObjects;
	private static ComponentServiceObjects<DepartmentResource>
		_departmentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}