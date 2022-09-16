/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.department.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DepartmentEntrySoap implements Serializable {

	public static DepartmentEntrySoap toSoapModel(DepartmentEntry model) {
		DepartmentEntrySoap soapModel = new DepartmentEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setParentId(model.getParentId());
		soapModel.setOrder(model.getOrder());
		soapModel.setType(model.getType());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setTax(model.getTax());
		soapModel.setAddress(model.getAddress());
		soapModel.setHeadOffice(model.getHeadOffice());
		soapModel.setAlias(model.getAlias());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static DepartmentEntrySoap[] toSoapModels(DepartmentEntry[] models) {
		DepartmentEntrySoap[] soapModels =
			new DepartmentEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DepartmentEntrySoap[][] toSoapModels(
		DepartmentEntry[][] models) {

		DepartmentEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DepartmentEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DepartmentEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DepartmentEntrySoap[] toSoapModels(
		List<DepartmentEntry> models) {

		List<DepartmentEntrySoap> soapModels =
			new ArrayList<DepartmentEntrySoap>(models.size());

		for (DepartmentEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DepartmentEntrySoap[soapModels.size()]);
	}

	public DepartmentEntrySoap() {
	}

	public long getPrimaryKey() {
		return _departmentId;
	}

	public void setPrimaryKey(long pk) {
		setDepartmentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public Integer getOrder() {
		return _order;
	}

	public void setOrder(Integer order) {
		_order = order;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
	}

	public String getTax() {
		return _tax;
	}

	public void setTax(String tax) {
		_tax = tax;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getHeadOffice() {
		return _headOffice;
	}

	public void setHeadOffice(String headOffice) {
		_headOffice = headOffice;
	}

	public String getAlias() {
		return _alias;
	}

	public void setAlias(String alias) {
		_alias = alias;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _departmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creatorId;
	private long _customerId;
	private String _name;
	private String _code;
	private long _parentId;
	private Integer _order;
	private String _type;
	private long _businessId;
	private String _tax;
	private String _address;
	private String _headOffice;
	private String _alias;
	private String _description;
	private String _status;
	private Date _statusDate;

}