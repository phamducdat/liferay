package com.dogoo.common.files.manager.service.mapper.model;

public class FileGeneralPermissionMapperModel {

    String allowed;
    String role;

    String type;

    public String getType() {
        if (type == null) return "file";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
