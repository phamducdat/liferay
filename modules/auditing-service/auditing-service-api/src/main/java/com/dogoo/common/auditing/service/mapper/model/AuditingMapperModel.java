package com.dogoo.common.auditing.service.mapper.model;

import com.liferay.portal.kernel.util.GetterUtil;

public class AuditingMapperModel {
    String name;
    String eventType;
    String message;
    String payload;
    Long parentPkId;
    String parentPkName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getParentPkId() {
        return parentPkId;
    }

    public void setParentPkId(Long parentPkId) {
        this.parentPkId = GetterUtil.getLong(parentPkId);
    }

    public String getParentPkName() {
        return parentPkName;
    }

    public void setParentPkName(String parentPkName) {
        this.parentPkName = parentPkName;
    }
}
