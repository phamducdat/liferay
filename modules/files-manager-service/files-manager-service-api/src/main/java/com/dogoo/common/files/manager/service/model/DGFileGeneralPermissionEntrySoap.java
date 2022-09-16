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
public class DGFileGeneralPermissionEntrySoap implements Serializable {

	public static DGFileGeneralPermissionEntrySoap toSoapModel(
		DGFileGeneralPermissionEntry model) {

		DGFileGeneralPermissionEntrySoap soapModel =
			new DGFileGeneralPermissionEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setFileGeneralPermissionId(
			model.getFileGeneralPermissionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setFileId(model.getFileId());
		soapModel.setAllowed(model.getAllowed());
		soapModel.setRole(model.getRole());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static DGFileGeneralPermissionEntrySoap[] toSoapModels(
		DGFileGeneralPermissionEntry[] models) {

		DGFileGeneralPermissionEntrySoap[] soapModels =
			new DGFileGeneralPermissionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DGFileGeneralPermissionEntrySoap[][] toSoapModels(
		DGFileGeneralPermissionEntry[][] models) {

		DGFileGeneralPermissionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DGFileGeneralPermissionEntrySoap
				[models.length][models[0].length];
		}
		else {
			soapModels = new DGFileGeneralPermissionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DGFileGeneralPermissionEntrySoap[] toSoapModels(
		List<DGFileGeneralPermissionEntry> models) {

		List<DGFileGeneralPermissionEntrySoap> soapModels =
			new ArrayList<DGFileGeneralPermissionEntrySoap>(models.size());

		for (DGFileGeneralPermissionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DGFileGeneralPermissionEntrySoap[soapModels.size()]);
	}

	public DGFileGeneralPermissionEntrySoap() {
	}

	public long getPrimaryKey() {
		return _fileGeneralPermissionId;
	}

	public void setPrimaryKey(long pk) {
		setFileGeneralPermissionId(pk);
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

	public long getFileGeneralPermissionId() {
		return _fileGeneralPermissionId;
	}

	public void setFileGeneralPermissionId(long fileGeneralPermissionId) {
		_fileGeneralPermissionId = fileGeneralPermissionId;
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

	public String getAllowed() {
		return _allowed;
	}

	public void setAllowed(String allowed) {
		_allowed = allowed;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileGeneralPermissionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _fileId;
	private String _allowed;
	private String _role;
	private String _type;

}