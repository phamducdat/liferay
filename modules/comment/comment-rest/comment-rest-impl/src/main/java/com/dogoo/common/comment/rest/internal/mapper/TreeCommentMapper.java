package com.dogoo.common.comment.rest.internal.mapper;

import com.dogoo.common.comment.rest.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.dto.v2_0.TreeComment;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.dogoo.common.comment.service.service.CommentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = TreeCommentMapper.class)
public class TreeCommentMapper {

    public TreeComment mapFromTreeCommentToComment(CommentEntry from){
        TreeComment to = new TreeComment();

        to.setCommentId(from.getCommentId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setClassPkId(from.getClassPkId());
        to.setClassPkName(from.getClassPkName());
        to.setCreatorUserId(from.getCreatorId());
        to.setCreatorUserName(from.getCreatorFullName());
        to.setCreateDateNow(from.getCreateDate().toString());
        to.setContent(from.getContent());
        to.setParentId(from.getParentId());

        List<CommentEntry> commentEntryList = _commentEntryLocalService.
                getCommentsByPkParentId(from.getCommentId());
        List<Comment> commentList = _mapper.mapFromCommentToCommentList(commentEntryList);
        to.setTreeComments(commentList.toArray(new Comment[0]));

        return to;
    }

    public List<TreeComment> mapFromTreeCommentToCommentList(List<CommentEntry> from){

        List<TreeComment> to = new ArrayList<>();

        from.forEach(commentEntry -> {
            to.add(mapFromTreeCommentToComment(commentEntry));
        });

        return to;
    }

    @Reference
    private CommentEntryLocalService _commentEntryLocalService ;

    @Reference
    private CommentMapper _mapper ;

}
