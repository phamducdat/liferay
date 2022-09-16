package com.dogoo.common.comment.rest.internal.graphql.query.v2_0;

import com.dogoo.common.comment.rest.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.dto.v2_0.Emoticon;
import com.dogoo.common.comment.rest.dto.v2_0.TreeComment;
import com.dogoo.common.comment.rest.resource.v2_0.CommentResource;
import com.dogoo.common.comment.rest.resource.v2_0.EmoticonResource;
import com.dogoo.common.comment.rest.resource.v2_0.TreeCommentResource;

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

	public static void setCommentResourceComponentServiceObjects(
		ComponentServiceObjects<CommentResource>
			commentResourceComponentServiceObjects) {

		_commentResourceComponentServiceObjects =
			commentResourceComponentServiceObjects;
	}

	public static void setEmoticonResourceComponentServiceObjects(
		ComponentServiceObjects<EmoticonResource>
			emoticonResourceComponentServiceObjects) {

		_emoticonResourceComponentServiceObjects =
			emoticonResourceComponentServiceObjects;
	}

	public static void setTreeCommentResourceComponentServiceObjects(
		ComponentServiceObjects<TreeCommentResource>
			treeCommentResourceComponentServiceObjects) {

		_treeCommentResourceComponentServiceObjects =
			treeCommentResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {comment(commentId: ___){commentId, externalReferenceCode, classPkId, classPkName, creatorUserId, creatorUserName, createDateNow, content, parentId, mentions}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "get comment by commentId")
	public Comment comment(@GraphQLName("commentId") Long commentId)
		throws Exception {

		return _applyComponentServiceObjects(
			_commentResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentResource -> commentResource.getComment(commentId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {emoticons(classPkId: ___, classPkName: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Comment . Results can be paginated, filtered, searched, and sorted."
	)
	public EmoticonPage emoticons(
			@GraphQLName("classPkId") Long classPkId,
			@GraphQLName("classPkName") String classPkName)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> new EmoticonPage(
				emoticonResource.getEmoticons(classPkId, classPkName)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {emoticon(emoticonId: ___){emoticonId, classPkId, classPkName, cretorUserId, emoji, creatorUserName}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Emoticon emoticon(@GraphQLName("emoticonId") Long emoticonId)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.getEmoticon(emoticonId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {emoticonByUser(classPkId: ___, classPkName: ___, creatorUserId: ___){emoticonId, classPkId, classPkName, cretorUserId, emoji, creatorUserName}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "get emoticon by user Id")
	public Emoticon emoticonByUser(
			@GraphQLName("classPkId") Long classPkId,
			@GraphQLName("classPkName") String classPkName,
			@GraphQLName("creatorUserId") Long creatorUserId)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.getEmoticonByUser(
				classPkId, classPkName, creatorUserId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allTreeComment(classPkId: ___, classPkName: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Comment . Results can be paginated, filtered, searched, and sorted."
	)
	public TreeCommentPage allTreeComment(
			@GraphQLName("classPkId") Long classPkId,
			@GraphQLName("classPkName") String classPkName,
			@GraphQLName("pageSize") Integer pageSize)
		throws Exception {

		return _applyComponentServiceObjects(
			_treeCommentResourceComponentServiceObjects,
			this::_populateResourceContext,
			treeCommentResource -> new TreeCommentPage(
				treeCommentResource.getAllTreeComment(
					classPkId, classPkName, pageSize)));
	}

	@GraphQLTypeExtension(TreeComment.class)
	public class GetCommentTypeExtension {

		public GetCommentTypeExtension(TreeComment treeComment) {
			_treeComment = treeComment;
		}

		@GraphQLField(description = "get comment by commentId")
		public Comment comment() throws Exception {
			return _applyComponentServiceObjects(
				_commentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				commentResource -> commentResource.getComment(
					_treeComment.getCommentId()));
		}

		private TreeComment _treeComment;

	}

	@GraphQLName("CommentPage")
	public class CommentPage {

		public CommentPage(Page commentPage) {
			actions = commentPage.getActions();

			items = commentPage.getItems();
			lastPage = commentPage.getLastPage();
			page = commentPage.getPage();
			pageSize = commentPage.getPageSize();
			totalCount = commentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Comment> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("EmoticonPage")
	public class EmoticonPage {

		public EmoticonPage(Page emoticonPage) {
			actions = emoticonPage.getActions();

			items = emoticonPage.getItems();
			lastPage = emoticonPage.getLastPage();
			page = emoticonPage.getPage();
			pageSize = emoticonPage.getPageSize();
			totalCount = emoticonPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Emoticon> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("TreeCommentPage")
	public class TreeCommentPage {

		public TreeCommentPage(Page treeCommentPage) {
			actions = treeCommentPage.getActions();

			items = treeCommentPage.getItems();
			lastPage = treeCommentPage.getLastPage();
			page = treeCommentPage.getPage();
			pageSize = treeCommentPage.getPageSize();
			totalCount = treeCommentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<TreeComment> items;

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

	private void _populateResourceContext(CommentResource commentResource)
		throws Exception {

		commentResource.setContextAcceptLanguage(_acceptLanguage);
		commentResource.setContextCompany(_company);
		commentResource.setContextHttpServletRequest(_httpServletRequest);
		commentResource.setContextHttpServletResponse(_httpServletResponse);
		commentResource.setContextUriInfo(_uriInfo);
		commentResource.setContextUser(_user);
		commentResource.setGroupLocalService(_groupLocalService);
		commentResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(EmoticonResource emoticonResource)
		throws Exception {

		emoticonResource.setContextAcceptLanguage(_acceptLanguage);
		emoticonResource.setContextCompany(_company);
		emoticonResource.setContextHttpServletRequest(_httpServletRequest);
		emoticonResource.setContextHttpServletResponse(_httpServletResponse);
		emoticonResource.setContextUriInfo(_uriInfo);
		emoticonResource.setContextUser(_user);
		emoticonResource.setGroupLocalService(_groupLocalService);
		emoticonResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			TreeCommentResource treeCommentResource)
		throws Exception {

		treeCommentResource.setContextAcceptLanguage(_acceptLanguage);
		treeCommentResource.setContextCompany(_company);
		treeCommentResource.setContextHttpServletRequest(_httpServletRequest);
		treeCommentResource.setContextHttpServletResponse(_httpServletResponse);
		treeCommentResource.setContextUriInfo(_uriInfo);
		treeCommentResource.setContextUser(_user);
		treeCommentResource.setGroupLocalService(_groupLocalService);
		treeCommentResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CommentResource>
		_commentResourceComponentServiceObjects;
	private static ComponentServiceObjects<EmoticonResource>
		_emoticonResourceComponentServiceObjects;
	private static ComponentServiceObjects<TreeCommentResource>
		_treeCommentResourceComponentServiceObjects;

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