package com.dogoo.common.auditing.rest.internal.graphql.query.v2_0;

import com.dogoo.common.auditing.rest.dto.v2_0.Auditing;
import com.dogoo.common.auditing.rest.resource.v2_0.AuditingResource;

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

import java.util.Date;
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

	public static void setAuditingResourceComponentServiceObjects(
		ComponentServiceObjects<AuditingResource>
			auditingResourceComponentServiceObjects) {

		_auditingResourceComponentServiceObjects =
			auditingResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {auditings(classPkId: ___, classPkName: ___, endDate: ___, filter: ___, startDate: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get List Auditing")
	public AuditingPage auditings(
			@GraphQLName("classPkId") Long classPkId,
			@GraphQLName("classPkName") String classPkName,
			@GraphQLName("startDate") Date startDate,
			@GraphQLName("endDate") Date endDate,
			@GraphQLName("filter") String filterString)
		throws Exception {

		return _applyComponentServiceObjects(
			_auditingResourceComponentServiceObjects,
			this::_populateResourceContext,
			auditingResource -> new AuditingPage(
				auditingResource.getAuditings(
					classPkId, classPkName, startDate, endDate,
					_filterBiFunction.apply(auditingResource, filterString))));
	}

	@GraphQLName("AuditingPage")
	public class AuditingPage {

		public AuditingPage(Page auditingPage) {
			actions = auditingPage.getActions();

			items = auditingPage.getItems();
			lastPage = auditingPage.getLastPage();
			page = auditingPage.getPage();
			pageSize = auditingPage.getPageSize();
			totalCount = auditingPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Auditing> items;

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

	private void _populateResourceContext(AuditingResource auditingResource)
		throws Exception {

		auditingResource.setContextAcceptLanguage(_acceptLanguage);
		auditingResource.setContextCompany(_company);
		auditingResource.setContextHttpServletRequest(_httpServletRequest);
		auditingResource.setContextHttpServletResponse(_httpServletResponse);
		auditingResource.setContextUriInfo(_uriInfo);
		auditingResource.setContextUser(_user);
		auditingResource.setGroupLocalService(_groupLocalService);
		auditingResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<AuditingResource>
		_auditingResourceComponentServiceObjects;

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