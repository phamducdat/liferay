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
public class DGFileSettingPermissionEntrySoap implements Serializable {

	public static DGFileSettingPermissionEntrySoap toSoapModel(
		DGFileSettingPermissionEntry model) {

		DGFileSettingPermissionEntrySoap soapModel =
			new DGFileSettingPermissionEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setFileSettingPermissionId(
			model.getFileSettingPermissionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setFileId(model.getFileId());
		soapModel.setPermissionEditor(model.isPermissionEditor());
		soapModel.setPermissionViewer(model.isPermissionViewer());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static DGFileSettingPermissionEntrySoap[] toSoapModels(
		DGFileSettingPermissionEntry[] models) {

		DGFileSettingPermissionEntrySoap[] soapModels =
			new DGFileSettingPermissionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DGFileSettingPermissionEntrySoap[][] toSoapModels(
		DGFileSettingPermissionEntry[][] models) {

		DGFileSettingPermissionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DGFileSettingPermissionEntrySoap
				[models.length][models[0].length];
		}
		else {
			soapModels = new DGFileSettingPermissionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DGFileSettingPermissionEntrySoap[] toSoapModels(
		List<DGFileSettingPermissionEntry> models) {

		List<DGFileSettingPermissionEntrySoap> soapModels =
			new ArrayList<DGFileSettingPermissionEntrySoap>(models.size());

		for (DGFileSettingPermissionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DGFileSettingPermissionEntrySoap[soapModels.size()]);
	}

	public DGFileSettingPermissionEntrySoap() {
	}

	public long getPrimaryKey() {
		return _fileSettingPermissionId;
	}

	public void setPrimaryKey(long pk) {
		setFileSettingPermissionId(pk);
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

	public long getFileSettingPermissionId() {
		return _fileSettingPermissionId;
	}

	public void setFileSettingPermissionId(long fileSettingPermissionId) {
		_fileSettingPermissionId = fileSettingPermissionId;
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

	public boolean getPermissionEditor() {
		return _permissionEditor;
	}

	public boolean isPermissionEditor() {
		return _permissionEditor;
	}

	public void setPermissionEditor(boolean permissionEditor) {
		_permissionEditor = permissionEditor;
	}

	public boolean getPermissionViewer() {
		return _permissionViewer;
	}

	public boolean isPermissionViewer() {
		return _permissionViewer;
	}

	public void setPermissionViewer(boolean permissionViewer) {
		_permissionViewer = permissionViewer;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileSettingPermissionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _fileId;
	private boolean _permissionEditor;
	private boolean _permissionViewer;
	private String _type;

}