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
public class DGFilePermissionSoap implements Serializable {

	public static DGFilePermissionSoap toSoapModel(DGFilePermission model) {
		DGFilePermissionSoap soapModel = new DGFilePermissionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setFilePermissionId(model.getFilePermissionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setFileId(model.getFileId());
		soapModel.setGeneralPermission(model.getGeneralPermission());
		soapModel.setRole(model.getRole());
		soapModel.setAllowActionForEditor(model.isAllowActionForEditor());
		soapModel.setAllowActionForViewer(model.isAllowActionForViewer());

		return soapModel;
	}

	public static DGFilePermissionSoap[] toSoapModels(
		DGFilePermission[] models) {

		DGFilePermissionSoap[] soapModels =
			new DGFilePermissionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DGFilePermissionSoap[][] toSoapModels(
		DGFilePermission[][] models) {

		DGFilePermissionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DGFilePermissionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DGFilePermissionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DGFilePermissionSoap[] toSoapModels(
		List<DGFilePermission> models) {

		List<DGFilePermissionSoap> soapModels =
			new ArrayList<DGFilePermissionSoap>(models.size());

		for (DGFilePermission model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DGFilePermissionSoap[soapModels.size()]);
	}

	public DGFilePermissionSoap() {
	}

	public long getPrimaryKey() {
		return _filePermissionId;
	}

	public void setPrimaryKey(long pk) {
		setFilePermissionId(pk);
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

	public long getFilePermissionId() {
		return _filePermissionId;
	}

	public void setFilePermissionId(long filePermissionId) {
		_filePermissionId = filePermissionId;
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

	public String getGeneralPermission() {
		return _generalPermission;
	}

	public void setGeneralPermission(String generalPermission) {
		_generalPermission = generalPermission;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public boolean getAllowActionForEditor() {
		return _allowActionForEditor;
	}

	public boolean isAllowActionForEditor() {
		return _allowActionForEditor;
	}

	public void setAllowActionForEditor(boolean allowActionForEditor) {
		_allowActionForEditor = allowActionForEditor;
	}

	public boolean getAllowActionForViewer() {
		return _allowActionForViewer;
	}

	public boolean isAllowActionForViewer() {
		return _allowActionForViewer;
	}

	public void setAllowActionForViewer(boolean allowActionForViewer) {
		_allowActionForViewer = allowActionForViewer;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _filePermissionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _fileId;
	private String _generalPermission;
	private String _role;
	private boolean _allowActionForEditor;
	private boolean _allowActionForViewer;

}