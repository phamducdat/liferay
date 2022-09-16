package com.dogoo.common.comment.service.mapper.model;

public class CommentMapperModel {

    private long classPkId;

    private String externalReferenceCode ;
    private String classPkName;
    private String content;
    private String creatorFullName;
    private long parentId;

    private MentionMapperModel[] mentions;

    public MentionMapperModel[] getMentions() {
        return mentions;
    }

    public void setMentions(MentionMapperModel[] mentions) {
        this.mentions = mentions;
    }

    public long getClassPkId() {
        return classPkId;
    }

    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this.externalReferenceCode = externalReferenceCode;
    }

    public void setClassPkId(long classPkId) {
        this.classPkId = classPkId;
    }

    public String getClassPkName() {
        return classPkName;
    }

    public void setClassPkName(String classPkName) {
        this.classPkName = classPkName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatorFullName() {
        return creatorFullName;
    }

    public void setCreatorFullName(String creatorFullName) {
        this.creatorFullName = creatorFullName;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
