package com.dogoo.department.rest.internal.graphql.query.v2_0;

import com.dogoo.department.rest.dto.v2_0.Business;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.resource.v2_0.BusinessResource;
import com.dogoo.department.rest.resource.v2_0.DepartmentResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class Query {

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

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {businesss(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the business. Results can be paginated, filtered, searched, and sorted."
	)
	public BusinessPage businesss(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> new BusinessPage(
				businessResource.getBusinesssPage(
					search,
					_filterBiFunction.apply(businessResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(businessResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {business(businessId: ___){id, externalReferenceCode, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a Business")
	public Business business(@GraphQLName("businessId") Long businessId)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.getBusiness(businessId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {businessByExternalReferenceCode(externalReferenceCode: ___){id, externalReferenceCode, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a Business by externalReferenceCode")
	public Business businessByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource ->
				businessResource.getBusinessByExternalReferenceCode(
					externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {departments(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the department. Results can be paginated, filtered, searched, and sorted."
	)
	public DepartmentPage departments(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> new DepartmentPage(
				departmentResource.getDepartmentsPage(
					search,
					_filterBiFunction.apply(departmentResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(departmentResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {department(departmentId: ___){id, externalReferenceCode, name, code, parentId, business, businessId, order, type, tax, address, headOffice, alias, description, status, statusDate, isDeleted}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a Department")
	public Department department(@GraphQLName("departmentId") Long departmentId)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.getDepartment(
				departmentId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {departmentByExternalReferenceCode(externalReferenceCode: ___){id, externalReferenceCode, name, code, parentId, business, businessId, order, type, tax, address, headOffice, alias, description, status, statusDate, isDeleted}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a Department by externalReferenceCode")
	public Department departmentByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource ->
				departmentResource.getDepartmentByExternalReferenceCode(
					externalReferenceCode));
	}

	@GraphQLTypeExtension(Business.class)
	public class GetDepartmentByExternalReferenceCodeTypeExtension {

		public GetDepartmentByExternalReferenceCodeTypeExtension(
			Business business) {

			_business = business;
		}

		@GraphQLField(description = "Get a Department by externalReferenceCode")
		public Department departmentByExternalReferenceCode() throws Exception {
			return _applyComponentServiceObjects(
				_departmentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				departmentResource ->
					departmentResource.getDepartmentByExternalReferenceCode(
						_business.getExternalReferenceCode()));
		}

		private Business _business;

	}

	@GraphQLTypeExtension(Department.class)
	public class GetBusinessTypeExtension {

		public GetBusinessTypeExtension(Department department) {
			_department = department;
		}

		@GraphQLField(description = "Get a Business")
		public Business business() throws Exception {
			return _applyComponentServiceObjects(
				_businessResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				businessResource -> businessResource.getBusiness(
					_department.getBusinessId()));
		}

		private Department _department;

	}

	@GraphQLTypeExtension(Department.class)
	public class GetBusinessByExternalReferenceCodeTypeExtension {

		public GetBusinessByExternalReferenceCodeTypeExtension(
			Department department) {

			_department = department;
		}

		@GraphQLField(description = "Get a Business by externalReferenceCode")
		public Business businessByExternalReferenceCode() throws Exception {
			return _applyComponentServiceObjects(
				_businessResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				businessResource ->
					businessResource.getBusinessByExternalReferenceCode(
						_department.getExternalReferenceCode()));
		}

		private Department _department;

	}

	@GraphQLName("BusinessPage")
	public class BusinessPage {

		public BusinessPage(Page businessPage) {
			actions = businessPage.getActions();

			items = businessPage.getItems();
			lastPage = businessPage.getLastPage();
			page = businessPage.getPage();
			pageSize = businessPage.getPageSize();
			totalCount = businessPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Business> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("DepartmentPage")
	public class DepartmentPage {

		public DepartmentPage(Page departmentPage) {
			actions = departmentPage.getActions();

			items = departmentPage.getItems();
			lastPage = departmentPage.getLastPage();
			page = departmentPage.getPage();
			pageSize = departmentPage.getPageSize();
			totalCount = departmentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Department> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}