package com.dogoo.common.files.manager.service.mapper.model;

public class FileDepartmentPermissionMapperModel {

    long id;

    String role;

    String type;


    public String getType() {
        if (type == null) return "file";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
