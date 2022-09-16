package com.dogoo.common.comment.rest.internal.resource.v2_0;

import com.dogoo.common.comment.rest.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.internal.service.CommentService;
import com.dogoo.common.comment.rest.internal.util.LanguageKeys;
import com.dogoo.common.comment.rest.internal.validator.CommentValidator;
import com.dogoo.common.comment.rest.resource.v2_0.CommentResource;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;
import java.util.Locale;

/**
 * @author khoa
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/comment.properties",
	scope = ServiceScope.PROTOTYPE, service = CommentResource.class
)
public class CommentResourceImpl extends BaseCommentResourceImpl {

	@Override
	public Comment postComponent(Comment comment) throws Exception {
		_commentValidator.validateForAddEmployee(comment,getLocale());
		return _commentService.postComment(
				getUserToken().getCustomerId(),
				getUserToken().getUserId(),
				getUserToken().getFullName(),
				comment,
				getServiceContext());
	}

	@Override
	public void deleteComments(Long commentId) throws Exception {
		_commentValidator.validatorCommentIsNotOfUserId(getUserToken().getUserId() , commentId , getLocale());
		_commentService.deleteComment(
				getUserToken().getCustomerId(),
				commentId);
	}

	@Override
	public Comment putComment(Long commentId, Comment comment) throws Exception {
		_commentValidator.validatorCommentIsNotOfUserId(
				getUserToken().getUserId() ,
				commentId ,
				getLocale());

		_commentValidator.validatorCommentIsExists(commentId,getLocale());

		return _commentService.updateComment(
				commentId,
				comment,
				getServiceContext());
	}

	@Override
	public void deleteCommentsDeletes(String classPkName, @NotNull Long[] classPkId) throws Exception {
		_commentService.deleteComments(
				getUserToken().getCustomerId(),
				classPkId ,
				classPkName);
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	public Locale getLocale() {

		Locale locale = contextHttpServletRequest.getLocale();

		if (locale.getLanguage().isEmpty()) {
			locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
		}

		return locale;
	}

	public UserTokenModel getUserToken() {
		return _commonTokenHelper.getUserToken(contextHttpServletRequest);
	}

	@Reference
	private CommonTokenHelper _commonTokenHelper;

	@Reference
	private CommentService _commentService;

	@Reference
	private CommentValidator _commentValidator;
}