package com.dogoo.common.files.manager.service.mapper.model;

public class FileSettingPermissionMapperModel {
    Boolean permissionEditor;
    Boolean permissionViewer;

    String type;


    public String getType() {
        if (type == null) return "file";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Boolean getPermissionEditor() {
        return permissionEditor;
    }

    public void setPermissionEditor(Boolean permissionEditor) {
        this.permissionEditor = permissionEditor;
    }

    public Boolean getPermissionViewer() {
        return permissionViewer;
    }

    public void setPermissionViewer(Boolean permissionViewer) {
        this.permissionViewer = permissionViewer;
    }
}
