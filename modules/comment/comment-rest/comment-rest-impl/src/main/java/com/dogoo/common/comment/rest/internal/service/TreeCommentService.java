package com.dogoo.common.comment.rest.internal.service;

import com.dogoo.common.comment.rest.dto.v2_0.TreeComment;
import com.dogoo.common.comment.rest.internal.mapper.TreeCommentMapper;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.dogoo.common.comment.service.service.CommentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = TreeCommentService.class)
public class TreeCommentService {

    public List<TreeComment> getTreeCommentByPkIdAndPkName(long customerId,
                                                           long classPkId,
                                                           String classPkName){
        List<CommentEntry> commentEntries = _commentEntryLocalService.
                getCommentsByPkIdAndPkNameOfTreeComment(customerId , classPkId , classPkName , 0);
        return _mapper.mapFromTreeCommentToCommentList(commentEntries);
    }

    @Reference
    private CommentEntryLocalService _commentEntryLocalService ;

    @Reference
    private TreeCommentMapper _mapper ;

}
