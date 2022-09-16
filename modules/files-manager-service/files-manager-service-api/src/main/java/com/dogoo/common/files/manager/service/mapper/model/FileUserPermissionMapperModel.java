package com.dogoo.common.files.manager.service.mapper.model;

public class FileUserPermissionMapperModel {
    long userId;

    String role;

    String type;


    public String getType() {
        if (type == null) return "file";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
