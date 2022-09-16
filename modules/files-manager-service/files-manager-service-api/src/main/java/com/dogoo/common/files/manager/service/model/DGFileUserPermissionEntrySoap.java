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

package com.dogoo.common.files.manager.service.model;

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
public class DGFileUserPermissionEntrySoap implements Serializable {

	public static DGFileUserPermissionEntrySoap toSoapModel(
		DGFileUserPermissionEntry model) {

		DGFileUserPermissionEntrySoap soapModel =
			new DGFileUserPermissionEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setFileUserPermissionId(model.getFileUserPermissionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setFileId(model.getFileId());
		soapModel.setUserAllowedId(model.getUserAllowedId());
		soapModel.setRole(model.getRole());
		soapModel.setStatus(model.getStatus());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static DGFileUserPermissionEntrySoap[] toSoapModels(
		DGFileUserPermissionEntry[] models) {

		DGFileUserPermissionEntrySoap[] soapModels =
			new DGFileUserPermissionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DGFileUserPermissionEntrySoap[][] toSoapModels(
		DGFileUserPermissionEntry[][] models) {

		DGFileUserPermissionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DGFileUserPermissionEntrySoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new DGFileUserPermissionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DGFileUserPermissionEntrySoap[] toSoapModels(
		List<DGFileUserPermissionEntry> models) {

		List<DGFileUserPermissionEntrySoap> soapModels =
			new ArrayList<DGFileUserPermissionEntrySoap>(models.size());

		for (DGFileUserPermissionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DGFileUserPermissionEntrySoap[soapModels.size()]);
	}

	public DGFileUserPermissionEntrySoap() {
	}

	public long getPrimaryKey() {
		return _fileUserPermissionId;
	}

	public void setPrimaryKey(long pk) {
		setFileUserPermissionId(pk);
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

	public long getFileUserPermissionId() {
		return _fileUserPermissionId;
	}

	public void setFileUserPermissionId(long fileUserPermissionId) {
		_fileUserPermissionId = fileUserPermissionId;
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

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public long getUserAllowedId() {
		return _userAllowedId;
	}

	public void setUserAllowedId(long userAllowedId) {
		_userAllowedId = userAllowedId;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileUserPermissionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _fileId;
	private long _userAllowedId;
	private String _role;
	private String _status;
	private String _type;

}