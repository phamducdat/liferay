package com.dogoo.common.comment.rest.internal.mapper;

import com.dogoo.common.comment.rest.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.dto.v2_0.Mention;
import com.dogoo.common.comment.service.mapper.model.CommentMapperModel;
import com.dogoo.common.comment.service.mapper.model.MentionMapperModel;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = CommentMapper.class)
public class CommentMapper {

    public Comment mapCommentFromCommentEntry(CommentEntry from) {
        Comment to = new Comment();

        to.setCommentId(from.getCommentId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setClassPkId(from.getClassPkId());
        to.setClassPkName(from.getClassPkName());
        to.setCreatorUserId(from.getCreatorId());
        to.setCreatorUserName(from.getCreatorFullName());
        to.setCreateDateNow(from.getCreateDate().toString());
        to.setContent(from.getContent());
        to.setParentId(from.getParentId());
        return to;
    }

    public List<Comment> mapFromCommentToCommentList(List<CommentEntry> from){
        List<Comment> to = new ArrayList<>();

        from.forEach(commentEntry -> {
             to.add(mapCommentFromCommentEntry(commentEntry));
        });

        return to;
    }

    public CommentMapperModel mapCommentMapperModelFromComment(Comment from) {
        CommentMapperModel model = new CommentMapperModel();
        model.setClassPkId(from.getClassPkId());
        model.setExternalReferenceCode(from.getExternalReferenceCode());
        model.setClassPkName(from.getClassPkName());
        model.setContent(from.getContent());
        model.setParentId(from.getParentId());
        model.setCreatorFullName(from.getCreatorUserName());

        model.setMentions(
                TransformUtil.transform(
                        from.getMentions(),
                        this::mapMentionMapperModelFromDto,
                        MentionMapperModel.class
                )
        );

        return model ;
    }

    private MentionMapperModel mapMentionMapperModelFromDto(Mention mention) {

        MentionMapperModel model = new MentionMapperModel();

        model.setId(mention.getId());
        model.setMentionChar(mention.getMentionChar());

        return model;
    }
}
