package com.dogoo.dataitems.rest.internal.graphql.mutation.v2_0;

import com.dogoo.dataitems.rest.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.dto.v2_0.InitDataItem;
import com.dogoo.dataitems.rest.resource.v2_0.DataItemResource;

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

	public static void setDataItemResourceComponentServiceObjects(
		ComponentServiceObjects<DataItemResource>
			dataItemResourceComponentServiceObjects) {

		_dataItemResourceComponentServiceObjects =
			dataItemResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create new a DataItem")
	public boolean createInitDataItem(
			@GraphQLName("initDataItem") InitDataItem initDataItem)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.postInitDataItem(
				initDataItem));

		return true;
	}

	@GraphQLField(description = "Create new a DataItem")
	public DataItem createDataItem(@GraphQLName("dataItem") DataItem dataItem)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.postDataItem(dataItem));
	}

	@GraphQLField
	public Response createDataItemBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.postDataItemBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete a DataItem")
	public boolean deleteDataItem(@GraphQLName("dataItemId") Long dataItemId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.deleteDataItem(dataItemId));

		return true;
	}

	@GraphQLField
	public Response deleteDataItemBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.deleteDataItemBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update a DataItem")
	public DataItem updateDataItem(
			@GraphQLName("dataItemId") Long dataItemId,
			@GraphQLName("dataItem") DataItem dataItem)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.putDataItem(
				dataItemId, dataItem));
	}

	@GraphQLField
	public Response updateDataItemBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource -> dataItemResource.putDataItemBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete a DataItem by externalReferenceCode")
	public boolean deleteDataItemByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource ->
				dataItemResource.deleteDataItemByExternalReferenceCode(
					externalReferenceCode));

		return true;
	}

	@GraphQLField(description = "Update a DataItem by externalReferenceCode")
	public DataItem updateDataItemByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("dataItem") DataItem dataItem)
		throws Exception {

		return _applyComponentServiceObjects(
			_dataItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			dataItemResource ->
				dataItemResource.putDataItemByExternalReferenceCode(
					externalReferenceCode, dataItem));
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

	private static ComponentServiceObjects<DataItemResource>
		_dataItemResourceComponentServiceObjects;

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