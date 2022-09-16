package com.dogoo.dataitems.rest.internal.graphql.query.v2_0;

import com.dogoo.dataitems.rest.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.dto.v2_0.Location;
import com.dogoo.dataitems.rest.resource.v2_0.DataItemResource;
import com.dogoo.dataitems.rest.resource.v2_0.LocationResource;

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

	public static void setDataItemResourceComponentServiceObjects(
		ComponentServiceObjects<DataItemResource>
			dataItemResourceComponentServiceObjects) {

		_dataItemResourceComponentServiceObjects =
			dataItemResourceComponentServiceObjects;
	}

	public static void setLocationResourceComponentServiceObjects(
		ComponentServiceObjects<LocationResource>
			locationResourceComponentServiceObjects) {

		_locationResourceComponentServiceObjects =
			locationResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {dataItem(dataItemId: ___){id, externalReferenceCode, name, description, order, type, parentId, isDefault, dataItems}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a DataItem")
	public DataItem dataItem(@GraphQLName("dataItemId") Long dataItemId)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.getDataItem(dataItemId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {dataItemByExternalReferenceCode(externalReferenceCode: ___){id, externalReferenceCode, name, description, order, type, parentId, isDefault, dataItems}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a DataItem by externalReferenceCode")
	public DataItem dataItemByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource ->
				dataItemResource.getDataItemByExternalReferenceCode(
					externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {dataItemByParentCode(parentCode: ___, sibling: ___, type: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get DataItems by parentcode")
	public DataItemPage dataItemByParentCode(
			@GraphQLName("type") String type,
			@GraphQLName("parentCode") String parentCode,
			@GraphQLName("sibling") Integer sibling)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> new DataItemPage(
				dataItemResource.getDataItemByParentCode(
					type, parentCode, sibling)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {locationDatas(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get DataItems by parentcode")
	public LocationPage locationDatas(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_locationResourceComponentServiceObjects,
			this::_populateResourceContext,
			locationResource -> new LocationPage(
				locationResource.getLocationDatasPage(
					search,
					_filterBiFunction.apply(locationResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(locationResource, sortsString))));
	}

	@GraphQLName("DataItemPage")
	public class DataItemPage {

		public DataItemPage(Page dataItemPage) {
			actions = dataItemPage.getActions();

			items = dataItemPage.getItems();
			lastPage = dataItemPage.getLastPage();
			page = dataItemPage.getPage();
			pageSize = dataItemPage.getPageSize();
			totalCount = dataItemPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<DataItem> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("LocationPage")
	public class LocationPage {

		public LocationPage(Page locationPage) {
			actions = locationPage.getActions();

			items = locationPage.getItems();
			lastPage = locationPage.getLastPage();
			page = locationPage.getPage();
			pageSize = locationPage.getPageSize();
			totalCount = locationPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Location> items;

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

	private void _populateResourceContext(DataItemResource dataItemResource)
		throws Exception {

		dataItemResource.setContextAcceptLanguage(_acceptLanguage);
		dataItemResource.setContextCompany(_company);
		dataItemResource.setContextHttpServletRequest(_httpServletRequest);
		dataItemResource.setContextHttpServletResponse(_httpServletResponse);
		dataItemResource.setContextUriInfo(_uriInfo);
		dataItemResource.setContextUser(_user);
		dataItemResource.setGroupLocalService(_groupLocalService);
		dataItemResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(LocationResource locationResource)
		throws Exception {

		locationResource.setContextAcceptLanguage(_acceptLanguage);
		locationResource.setContextCompany(_company);
		locationResource.setContextHttpServletRequest(_httpServletRequest);
		locationResource.setContextHttpServletResponse(_httpServletResponse);
		locationResource.setContextUriInfo(_uriInfo);
		locationResource.setContextUser(_user);
		locationResource.setGroupLocalService(_groupLocalService);
		locationResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<DataItemResource>
		_dataItemResourceComponentServiceObjects;
	private static ComponentServiceObjects<LocationResource>
		_locationResourceComponentServiceObjects;

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