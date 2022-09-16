package com.dogoo.common.files.manager.rest.internal.graphql.query.v2_0;

import com.dogoo.common.files.manager.rest.dto.v2_0.DGDocumentManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.DGFileManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.User;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGDocumentManagerResource;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGFileManagerResource;

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

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGDocumentManagerCompany(page: ___, pageSize: ___, parentId: ___, search: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGDocumentManagerPage allDGDocumentManagerCompany(
			@GraphQLName("search") String search,
			@GraphQLName("parentId") Long parentId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource -> new DGDocumentManagerPage(
				dgDocumentManagerResource.getAllDGDocumentManagerCompany(
					search, parentId, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGDocumentManagerPersonalCompany(page: ___, pageSize: ___, parentId: ___, search: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGDocumentManagerPage allDGDocumentManagerPersonalCompany(
			@GraphQLName("search") String search,
			@GraphQLName("parentId") Long parentId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource -> new DGDocumentManagerPage(
				dgDocumentManagerResource.
					getAllDGDocumentManagerPersonalCompany(
						search, parentId, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allModules(moduleId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGDocumentManagerPage allModules(
			@GraphQLName("moduleId") String moduleId)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource -> new DGDocumentManagerPage(
				dgDocumentManagerResource.getAllModules(moduleId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGDocumentManagerPersonalAttach(app: ___, page: ___, pageSize: ___, parentId: ___, search: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGDocumentManagerPage allDGDocumentManagerPersonalAttach(
			@GraphQLName("search") String search,
			@GraphQLName("parentId") Long parentId,
			@GraphQLName("app") String app,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource -> new DGDocumentManagerPage(
				dgDocumentManagerResource.getAllDGDocumentManagerPersonalAttach(
					search, parentId, app, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGDocumentManagerAttachProject(page: ___, pageSize: ___, parentId: ___, pkCode: ___, search: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGDocumentManagerPage allDGDocumentManagerAttachProject(
			@GraphQLName("search") String search,
			@GraphQLName("parentId") Long parentId,
			@GraphQLName("pkCode") String pkCode,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource -> new DGDocumentManagerPage(
				dgDocumentManagerResource.getAllDGDocumentManagerAttachProject(
					search, parentId, pkCode, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGDocumentManagerPersonal(page: ___, pageSize: ___, parentId: ___, search: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGDocumentManagerPage allDGDocumentManagerPersonal(
			@GraphQLName("search") String search,
			@GraphQLName("parentId") Long parentId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource -> new DGDocumentManagerPage(
				dgDocumentManagerResource.getAllDGDocumentManagerPersonal(
					search, parentId, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGDocumentManager(appId: ___, page: ___, pageSize: ___, parentId: ___, pkCode: ___, search: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGDocumentManagerPage allDGDocumentManager(
			@GraphQLName("pkCode") String pkCode,
			@GraphQLName("appId") String appId,
			@GraphQLName("search") String search,
			@GraphQLName("parentId") Long parentId,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource -> new DGDocumentManagerPage(
				dgDocumentManagerResource.getAllDGDocumentManager(
					pkCode, appId, search, parentId,
					Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {dGDocumentManager(appId: ___, category: ___, id: ___){id, pkCode, name, type, category, fileId, parentId, permission, isPrivate, paths, task, role, metadata, uploadFilesInfo, uploadMediaInfo, uploadImageInfo, uploadTextInfo, uploadDiffInfo, fileSize, extension, downloadPath, previewPath, mineType, sharedObjectBriefs, creatorId, creatorName, modifiedDate}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public DGDocumentManager dGDocumentManager(
			@GraphQLName("id") Long id,
			@GraphQLName("category") String category,
			@GraphQLName("appId") String appId)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgDocumentManagerResource ->
				dgDocumentManagerResource.getDGDocumentManager(
					id, category, appId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGFileManager(parentCode: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGFileManagerPage allDGFileManager(
			@GraphQLName("parentCode") String parentCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource -> new DGFileManagerPage(
				dgFileManagerResource.getAllDGFileManager(parentCode)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allDGFileManagerByPkType(parentCode: ___, pkType: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Media File . Results can be paginated, filtered, searched, and sorted."
	)
	public DGFileManagerPage allDGFileManagerByPkType(
			@GraphQLName("parentCode") String parentCode,
			@GraphQLName("pkType") String pkType)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource -> new DGFileManagerPage(
				dgFileManagerResource.getAllDGFileManagerByPkType(
					parentCode, pkType)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {dGFileManager(fileId: ___){fileId, parentCode, fileType, type, pkType, fileName, fileSize, mineType, metadata}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public DGFileManager dGFileManager(@GraphQLName("fileId") Long fileId)
		throws Exception {

		return _applyComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects,
			this::_populateResourceContext,
			dgFileManagerResource -> dgFileManagerResource.getDGFileManager(
				fileId));
	}

	@GraphQLName("DGDocumentManagerPage")
	public class DGDocumentManagerPage {

		public DGDocumentManagerPage(Page dgDocumentManagerPage) {
			actions = dgDocumentManagerPage.getActions();

			items = dgDocumentManagerPage.getItems();
			lastPage = dgDocumentManagerPage.getLastPage();
			page = dgDocumentManagerPage.getPage();
			pageSize = dgDocumentManagerPage.getPageSize();
			totalCount = dgDocumentManagerPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<DGDocumentManager> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("DGFileManagerPage")
	public class DGFileManagerPage {

		public DGFileManagerPage(Page dgFileManagerPage) {
			actions = dgFileManagerPage.getActions();

			items = dgFileManagerPage.getItems();
			lastPage = dgFileManagerPage.getLastPage();
			page = dgFileManagerPage.getPage();
			pageSize = dgFileManagerPage.getPageSize();
			totalCount = dgFileManagerPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<DGFileManager> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLTypeExtension(DGDocumentManager.class)
	public class ParentDGDocumentManagerIdTypeExtension {

		public ParentDGDocumentManagerIdTypeExtension(
			DGDocumentManager dGDocumentManager) {

			_dGDocumentManager = dGDocumentManager;
		}

		@GraphQLField
		public DGDocumentManager parentDGDocumentManager(
				@GraphQLName("category") String category,
				@GraphQLName("appId") String appId)
			throws Exception {

			if (_dGDocumentManager.getParentId() == null) {
				return null;
			}

			return _applyComponentServiceObjects(
				_dgDocumentManagerResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				dgDocumentManagerResource ->
					dgDocumentManagerResource.getDGDocumentManager(
						_dGDocumentManager.getParentId(), category, appId));
		}

		private DGDocumentManager _dGDocumentManager;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}