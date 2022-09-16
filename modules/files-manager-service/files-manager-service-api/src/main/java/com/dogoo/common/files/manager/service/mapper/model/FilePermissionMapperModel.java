package com.dogoo.common.files.manager.service.mapper.model;

public class FilePermissionMapperModel {

    long fileId;
    String generalPermission;
    String role;
    Boolean allowActionForEditor;
    Boolean allowActionForViewer;

    String type;

    public String getType() {
        if (type == null) return "file";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getGeneralPermission() {
        return generalPermission;
    }

    public void setGeneralPermission(String generalPermission) {
        this.generalPermission = generalPermission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getAllowActionForEditor() {
        return allowActionForEditor;
    }

    public void setAllowActionForEditor(Boolean allowActionForEditor) {
        this.allowActionForEditor = allowActionForEditor;
    }

    public Boolean getAllowActionForViewer() {
        return allowActionForViewer;
    }

    public void setAllowActionForViewer(Boolean allowActionForViewer) {
        this.allowActionForViewer = allowActionForViewer;
    }
}
