package com.dogoo.common.api.rest.internal.graphql.query.v2_0;

import com.dogoo.common.api.rest.dto.v2_0.EmployeeReference;
import com.dogoo.common.api.rest.resource.v2_0.EmployeeReferenceResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
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

	public static void setEmployeeReferenceResourceComponentServiceObjects(
		ComponentServiceObjects<EmployeeReferenceResource>
			employeeReferenceResourceComponentServiceObjects) {

		_employeeReferenceResourceComponentServiceObjects =
			employeeReferenceResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {employeeReferences(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get DataItems by parentcode")
	public EmployeeReferencePage employeeReferences(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_employeeReferenceResourceComponentServiceObjects,
			this::_populateResourceContext,
			employeeReferenceResource -> new EmployeeReferencePage(
				employeeReferenceResource.getEmployeeReferencesPage(
					search,
					_filterBiFunction.apply(
						employeeReferenceResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(
						employeeReferenceResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {employeeExternalReferences(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get DataItems by parentcode")
	public EmployeeReferencePage employeeExternalReferences(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_employeeReferenceResourceComponentServiceObjects,
			this::_populateResourceContext,
			employeeReferenceResource -> new EmployeeReferencePage(
				employeeReferenceResource.getEmployeeExternalReferencesPage(
					search,
					_filterBiFunction.apply(
						employeeReferenceResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(
						employeeReferenceResource, sortsString))));
	}

	@GraphQLName("EmployeeReferencePage")
	public class EmployeeReferencePage {

		public EmployeeReferencePage(Page employeeReferencePage) {
			actions = employeeReferencePage.getActions();

			items = employeeReferencePage.getItems();
			lastPage = employeeReferencePage.getLastPage();
			page = employeeReferencePage.getPage();
			pageSize = employeeReferencePage.getPageSize();
			totalCount = employeeReferencePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<EmployeeReference> items;

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

	private void _populateResourceContext(
			EmployeeReferenceResource employeeReferenceResource)
		throws Exception {

		employeeReferenceResource.setContextAcceptLanguage(_acceptLanguage);
		employeeReferenceResource.setContextCompany(_company);
		employeeReferenceResource.setContextHttpServletRequest(
			_httpServletRequest);
		employeeReferenceResource.setContextHttpServletResponse(
			_httpServletResponse);
		employeeReferenceResource.setContextUriInfo(_uriInfo);
		employeeReferenceResource.setContextUser(_user);
		employeeReferenceResource.setGroupLocalService(_groupLocalService);
		employeeReferenceResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<EmployeeReferenceResource>
		_employeeReferenceResourceComponentServiceObjects;

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