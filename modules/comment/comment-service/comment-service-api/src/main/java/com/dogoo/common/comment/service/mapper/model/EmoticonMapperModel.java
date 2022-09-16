package com.dogoo.common.comment.service.mapper.model;

public class EmoticonMapperModel {

    private long classPkId;
    private String classPkName;
    private String creatorFullName;
    private String emoji ;

    public long getClassPkId() {
        return classPkId;
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

    public String getCreatorFullName() {
        return creatorFullName;
    }

    public void setCreatorFullName(String creatorFullName) {
        this.creatorFullName = creatorFullName;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
