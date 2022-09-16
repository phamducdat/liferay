package com.dogoo.department.service.mapper.model;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

public class DepartmentMapperModel {

    private String name;

    private String code;

    private Long parentId;

    private Integer order;

    private String type;

    private Long businessId;

    private String tax;

    private String address;

    private String headOffice;

    private String alias;

    private String description;

    private String status;

    private Date statusDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = GetterUtil.getLong(parentId, 0L);
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = GetterUtil.getInteger(order, 0);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = GetterUtil.getLong(businessId, -1L);
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
