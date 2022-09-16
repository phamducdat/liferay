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
public class DGFileManagerEntrySoap implements Serializable {

	public static DGFileManagerEntrySoap toSoapModel(DGFileManagerEntry model) {
		DGFileManagerEntrySoap soapModel = new DGFileManagerEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setFileManagerId(model.getFileManagerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setFileId(model.getFileId());
		soapModel.setParentCode(model.getParentCode());
		soapModel.setFileType(model.getFileType());
		soapModel.setType(model.getType());
		soapModel.setPkType(model.getPkType());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setModuleId(model.getModuleId());
		soapModel.setAppId(model.getAppId());

		return soapModel;
	}

	public static DGFileManagerEntrySoap[] toSoapModels(
		DGFileManagerEntry[] models) {

		DGFileManagerEntrySoap[] soapModels =
			new DGFileManagerEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DGFileManagerEntrySoap[][] toSoapModels(
		DGFileManagerEntry[][] models) {

		DGFileManagerEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DGFileManagerEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DGFileManagerEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DGFileManagerEntrySoap[] toSoapModels(
		List<DGFileManagerEntry> models) {

		List<DGFileManagerEntrySoap> soapModels =
			new ArrayList<DGFileManagerEntrySoap>(models.size());

		for (DGFileManagerEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DGFileManagerEntrySoap[soapModels.size()]);
	}

	public DGFileManagerEntrySoap() {
	}

	public long getPrimaryKey() {
		return _fileManagerId;
	}

	public void setPrimaryKey(long pk) {
		setFileManagerId(pk);
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

	public long getFileManagerId() {
		return _fileManagerId;
	}

	public void setFileManagerId(long fileManagerId) {
		_fileManagerId = fileManagerId;
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

	public String getParentCode() {
		return _parentCode;
	}

	public void setParentCode(String parentCode) {
		_parentCode = parentCode;
	}

	public String getFileType() {
		return _fileType;
	}

	public void setFileType(String fileType) {
		_fileType = fileType;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getPkType() {
		return _pkType;
	}

	public void setPkType(String pkType) {
		_pkType = pkType;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileSize() {
		return _fileSize;
	}

	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
	}

	public String getModuleId() {
		return _moduleId;
	}

	public void setModuleId(String moduleId) {
		_moduleId = moduleId;
	}

	public String getAppId() {
		return _appId;
	}

	public void setAppId(String appId) {
		_appId = appId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileManagerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _fileId;
	private String _parentCode;
	private String _fileType;
	private String _type;
	private String _pkType;
	private String _fileName;
	private String _fileSize;
	private String _moduleId;
	private String _appId;

}