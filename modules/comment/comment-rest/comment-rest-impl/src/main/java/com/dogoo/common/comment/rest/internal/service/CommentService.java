package com.dogoo.common.comment.rest.internal.service;

import com.dogoo.common.comment.rest.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.internal.mapper.CommentMapper;
import com.dogoo.common.comment.service.exception.NoSuchCommentEntryException;
import com.dogoo.common.comment.service.mapper.model.CommentMapperModel;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.dogoo.common.comment.service.model.EmoticonEntry;
import com.dogoo.common.comment.service.service.CommentEntryLocalService;
import com.dogoo.common.comment.service.service.EmoticonEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = CommentService.class)
public class CommentService {


    public Comment postComment(long customerId,
                               long userId,
                               String fullName,
                               Comment comment,
                               ServiceContext serviceContext) {
        Comment comment1 = comment;
        long parentId = GetterUtil.get(comment.getParentId(), 0l);
        if (parentId == 0){
            comment1.setParentId(parentId);
        }
        comment1.setCreatorUserName(fullName);

        CommentMapperModel model = _mapper.mapCommentMapperModelFromComment(comment1);

        CommentEntry commentEntry = _commentEntryLocalService.addComment(
                customerId , userId , model , serviceContext );

        return _mapper.mapCommentFromCommentEntry(commentEntry);
    }

    public void deleteComment(long customerId,long commentId) throws PortalException {

        List<CommentEntry> commentEntryList = _commentEntryLocalService.getCommentsByPkParentId(commentId);

        for (CommentEntry commentEntry : commentEntryList){

            List<EmoticonEntry> emoticonEntryList = _emoticonEntryLocalService.
                    getEmoticonEntriesByClassPkIdAndClassPkName(customerId,
                                                                commentEntry.getClassPkId() ,
                                                                commentEntry.getClassPkName());

            for (EmoticonEntry emoticonEntry : emoticonEntryList){
                _emoticonEntryLocalService.deleteEmoticonEntry(emoticonEntry.getEmoticonId());
            }
            _commentEntryLocalService.deleteCommentEntry(commentEntry.getCommentId());
        }
        CommentEntry commentEntry = _commentEntryLocalService.fetchCommentEntry(commentId);

        List<EmoticonEntry> emoticonEntryList = _emoticonEntryLocalService.
                getEmoticonEntriesByClassPkIdAndClassPkName(customerId,
                        commentEntry.getClassPkId() ,
                        commentEntry.getClassPkName());

        for (EmoticonEntry emoticonEntry : emoticonEntryList){
            _emoticonEntryLocalService.deleteEmoticonEntry(emoticonEntry.getEmoticonId());
        }
        _commentEntryLocalService.deleteCommentEntry(commentEntry.getCommentId());
    }

    public Comment updateComment(long commentId ,
                                 Comment comment ,
                                 ServiceContext serviceContext) throws NoSuchCommentEntryException {

        CommentEntry commentEntry = _commentEntryLocalService.fetchCommentEntry(commentId);

        Comment comment1 = comment ;
        comment1.setClassPkId(commentEntry.getClassPkId());
        comment1.setClassPkName(commentEntry.getClassPkName());
        comment1.setCreatorUserName(commentEntry.getCreatorFullName());
        comment1.setParentId(commentEntry.getParentId());

        CommentMapperModel model = _mapper.mapCommentMapperModelFromComment(comment1);

        CommentEntry updateCommentEntry = _commentEntryLocalService.
                updateComment(commentId , model , serviceContext);

        return _mapper.mapCommentFromCommentEntry(updateCommentEntry);
    }

    public void deleteComments(long customerId,
                              Long[] classPkIds ,
                              String classPkName) throws PortalException {

        for(int j = 0 ; j<classPkIds.length ; j++){
            List<CommentEntry> commentEntries = _commentEntryLocalService.
                    getCommentsByPkIdAndPkName(customerId, classPkIds[j],classPkName);
            for (CommentEntry commentEntry : commentEntries){
                List<EmoticonEntry> emoticonEntryList = _emoticonEntryLocalService.
                        getEmoticonEntriesByClassPkIdAndClassPkName(customerId,
                                commentEntry.getClassPkId() ,
                                commentEntry.getClassPkName());
                for (EmoticonEntry emoticonEntry : emoticonEntryList){
                    _emoticonEntryLocalService.deleteEmoticonEntry(emoticonEntry.getEmoticonId());
                }
                _commentEntryLocalService.deleteCommentEntry(commentEntry.getCommentId());
            }
        }
    }

    @Reference
    private CommentEntryLocalService _commentEntryLocalService ;

    @Reference
    private CommentMapper _mapper ;

    @Reference
    private EmoticonEntryLocalService _emoticonEntryLocalService;
}
