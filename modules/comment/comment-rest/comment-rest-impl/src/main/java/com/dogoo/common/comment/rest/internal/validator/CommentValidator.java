package com.dogoo.common.comment.rest.internal.validator;

import com.dogoo.common.comment.rest.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.internal.service.LanguageService;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.dogoo.common.comment.service.service.CommentEntryLocalService;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.common.exception.model.DG_UnAuthorizationException;
import com.dogoo.common.validator.api.CommonValidatorHelper;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(immediate = true, service = CommentValidator.class)
public class CommentValidator {

    private void validateRequiredField(Comment comment,
                                       Locale locale) throws DG_FieldRequiredException {

        _commonValidatorHelper.isNotPopulated(
                comment.getContent(),
                _languageService.getMessage(locale, "comment.content.field.required"));

        long classPkId = GetterUtil.get(comment.getClassPkId(), 0l);
        if (classPkId == 0 ){
            throw new DG_FieldRequiredException(_languageService.getMessage(locale , "comment.parent.id.field.required"));
        }

        _commonValidatorHelper.isNotPopulated(
                comment.getClassPkName(),
                _languageService.getMessage(locale, "comment.parent.name.field.required"));
    }

    public void validateForAddEmployee(Comment comment,
                                       Locale locale)
            throws DG_FieldRequiredException {

        validateRequiredField(comment, locale);
    }

    public void validatorCommentIsNotOfUserId(long UserId ,
                                              long commentId ,
                                              Locale locale) throws DG_UnAuthorizationException {

        CommentEntry commentEntry = _commentEntryLocalService.fetchCommentEntry(commentId);

        if(commentEntry.getCreatorId() == UserId){
            return;
        }
        throw new DG_UnAuthorizationException(_languageService.getMessage(locale, "comment.creator.not.comment"));
    }

    public void validatorCommentIsExists(long commentId ,
                                         Locale locale) throws DG_NoSuchEntryException {
        CommentEntry commentEntry = _commentEntryLocalService.fetchCommentEntry(commentId);

        if(commentEntry != null){
            return;
        }

        throw  new DG_NoSuchEntryException(_languageService.getMessage(locale, "comment.not.found"));
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private CommentEntryLocalService _commentEntryLocalService;

    @Reference
    private CommonValidatorHelper _commonValidatorHelper;

}
