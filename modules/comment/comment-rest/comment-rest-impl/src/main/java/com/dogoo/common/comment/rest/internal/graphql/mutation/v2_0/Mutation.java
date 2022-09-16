package com.dogoo.common.comment.rest.internal.graphql.mutation.v2_0;

import com.dogoo.common.comment.rest.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.dto.v2_0.Emoticon;
import com.dogoo.common.comment.rest.resource.v2_0.CommentResource;
import com.dogoo.common.comment.rest.resource.v2_0.EmoticonResource;

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

	@GraphQLField
	public Comment createComponent(@GraphQLName("comment") Comment comment)
		throws Exception {

		return _applyComponentServiceObjects(
			_commentResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentResource -> commentResource.postComponent(comment));
	}

	@GraphQLField
	public boolean deleteComments(@GraphQLName("commentId") Long commentId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_commentResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentResource -> commentResource.deleteComments(commentId));

		return true;
	}

	@GraphQLField(description = "update comment by commentId")
	public Comment updateComment(
			@GraphQLName("commentId") Long commentId,
			@GraphQLName("comment") Comment comment)
		throws Exception {

		return _applyComponentServiceObjects(
			_commentResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentResource -> commentResource.putComment(commentId, comment));
	}

	@GraphQLField
	public Response updateCommentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_commentResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentResource -> commentResource.putCommentBatch(
				callbackURL, object));
	}

	@GraphQLField
	public boolean deleteCommentsDeletes(
			@GraphQLName("classPkName") String classPkName,
			@GraphQLName("classPkId") Long[] classPkId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_commentResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentResource -> commentResource.deleteCommentsDeletes(
				classPkName, classPkId));

		return true;
	}

	@GraphQLField
	public Emoticon createEmoticon(@GraphQLName("emoticon") Emoticon emoticon)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.postEmoticon(emoticon));
	}

	@GraphQLField
	public Response createEmoticonBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.postEmoticonBatch(
				callbackURL, object));
	}

	@GraphQLField
	public boolean deleteEmoticon(@GraphQLName("emoticonId") Long emoticonId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.deleteEmoticon(emoticonId));

		return true;
	}

	@GraphQLField
	public Response deleteEmoticonBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.deleteEmoticonBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "update Emoticon by emoticon Id")
	public Emoticon updateEmoticon(
			@GraphQLName("emoticonId") Long emoticonId,
			@GraphQLName("emoticon") Emoticon emoticon)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.putEmoticon(
				emoticonId, emoticon));
	}

	@GraphQLField
	public Response updateEmoticonBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_emoticonResourceComponentServiceObjects,
			this::_populateResourceContext,
			emoticonResource -> emoticonResource.putEmoticonBatch(
				callbackURL, object));
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

	private static ComponentServiceObjects<CommentResource>
		_commentResourceComponentServiceObjects;
	private static ComponentServiceObjects<EmoticonResource>
		_emoticonResourceComponentServiceObjects;

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