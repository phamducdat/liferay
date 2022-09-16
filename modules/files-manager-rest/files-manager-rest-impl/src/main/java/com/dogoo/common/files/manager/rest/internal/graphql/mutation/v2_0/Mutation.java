package com.dogoo.common.files.manager.rest.internal.graphql.mutation.v2_0;

import com.dogoo.common.files.manager.rest.dto.v2_0.DGAttachedDocumentManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.DGDocumentManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.DGFileManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.User;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGDocumentManagerResource;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGFileManagerResource;

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

	public static void setDGDocumentManagerResourceComponentServiceObjects(
		ComponentServiceObjects<DGDocumentManagerResource>
			dgDocumentManagerResourceComponentServiceObjects) {

		_dgDocumentManagerResourceComponentServiceObjects =
			dgDocumentManagerResourceComponentServiceObjects;
	}

	public static void setDGFileManagerResourceComponentServiceObjects(
		ComponentServiceObjects<DGFileManagerResource>
			dgFileManagerResourceComponentServiceObjects) {

		_dgFileManagerResourceComponentServiceObjects =
			dgFileManagerResourceComponentServiceObjects;
	}

	@GraphQLField
	public boolean createDGDocumentManagerAttach(
			@GraphQLName("dgAttachedDocumentManager") DGAttachedDocumentManager
				dgAttachedDocumentManager)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.postDGDocumentManagerAttach(
					dgAttachedDocumentManager));

		return true;
	}

	@GraphQLField
	public DGDocumentManager createDGDocumentManager(
			@GraphQLName("dgDocumentManager") DGDocumentManager
				dgDocumentManager)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.postDGDocumentManager(
					dgDocumentManager));
	}

	@GraphQLField
	public Response createDGDocumentManagerBatch(
			@GraphQLName("dgDocumentManager") DGDocumentManager
				dgDocumentManager,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.postDGDocumentManagerBatch(
					dgDocumentManager, callbackURL, object));
	}

	@GraphQLField
	public boolean updateDGDocumentManagerPublic(
			@GraphQLName("id") Long id,
			@GraphQLName("dgDocumentManager") DGDocumentManager
				dgDocumentManager)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.putDGDocumentManagerPublic(
					id, dgDocumentManager));

		return true;
	}

	@GraphQLField
	public boolean deleteDGDocumentManager(@GraphQLName("id") Long id)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.deleteDGDocumentManager(id));

		return true;
	}

	@GraphQLField
	public Response deleteDGDocumentManagerBatch(
			@GraphQLName("id") Long id,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.deleteDGDocumentManagerBatch(
					id, callbackURL, object));
	}

	@GraphQLField
	public DGDocumentManager updateDGDocumentManager(
			@GraphQLName("id") Long id,
			@GraphQLName("dgDocumentManager") DGDocumentManager
				dgDocumentManager)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.putDGDocumentManager(
					id, dgDocumentManager));
	}

	@GraphQLField
	public Response updateDGDocumentManagerBatch(
			@GraphQLName("id") Long id,
			@GraphQLName("dgDocumentManager") DGDocumentManager
				dgDocumentManager,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.putDGDocumentManagerBatch(
					id, dgDocumentManager, callbackURL, object));
	}

	@GraphQLField
	public boolean deleteDocuments(@GraphQLName("pkCode") String pkCode)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.deleteDocuments(pkCode));

		return true;
	}

	@GraphQLField
	public DGFileManager createDGFileManager(
			@GraphQLName("dgFileManager") DGFileManager dgFileManager)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource -> dgFileManagerResource.postDGFileManager(
				dgFileManager));
	}

	@GraphQLField
	public Response createDGFileManagerBatch(
			@GraphQLName("dgFileManager") DGFileManager dgFileManager,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource ->
				dgFileManagerResource.postDGFileManagerBatch(
					dgFileManager, callbackURL, object));
	}

	@GraphQLField
	public boolean deleteDGFileManager(@GraphQLName("fileId") Long fileId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource -> dgFileManagerResource.deleteDGFileManager(
				fileId));

		return true;
	}

	@GraphQLField
	public Response deleteDGFileManagerBatch(
			@GraphQLName("fileId") Long fileId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource ->
				dgFileManagerResource.deleteDGFileManagerBatch(
					fileId, callbackURL, object));
	}

	@GraphQLField
	public boolean deleteMediaFiles(
			@GraphQLName("parentCode") String parentCode)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource -> dgFileManagerResource.deleteMediaFiles(
				parentCode));

		return true;
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

	private void _populateResourceContext(
			DGDocumentManagerResource dgDocumentManagerResource)
		throws Exception {

		dgDocumentManagerResource.setContextAcceptLanguage(_acceptLanguage);
		dgDocumentManagerResource.setContextCompany(_company);
		dgDocumentManagerResource.setContextHttpServletRequest(
			_httpServletRequest);
		dgDocumentManagerResource.setContextHttpServletResponse(
			_httpServletResponse);
		dgDocumentManagerResource.setContextUriInfo(_uriInfo);
		dgDocumentManagerResource.setContextUser(_user);
		dgDocumentManagerResource.setGroupLocalService(_groupLocalService);
		dgDocumentManagerResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			DGFileManagerResource dgFileManagerResource)
		throws Exception {

		dgFileManagerResource.setContextAcceptLanguage(_acceptLanguage);
		dgFileManagerResource.setContextCompany(_company);
		dgFileManagerResource.setContextHttpServletRequest(_httpServletRequest);
		dgFileManagerResource.setContextHttpServletResponse(
			_httpServletResponse);
		dgFileManagerResource.setContextUriInfo(_uriInfo);
		dgFileManagerResource.setContextUser(_user);
		dgFileManagerResource.setGroupLocalService(_groupLocalService);
		dgFileManagerResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<DGDocumentManagerResource>
		_dgDocumentManagerResourceComponentServiceObjects;
	private static ComponentServiceObjects<DGFileManagerResource>
		_dgFileManagerResourceComponentServiceObjects;

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