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
public class DGDocumentManagerEntrySoap implements Serializable {

	public static DGDocumentManagerEntrySoap toSoapModel(
		DGDocumentManagerEntry model) {

		DGDocumentManagerEntrySoap soapModel = new DGDocumentManagerEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setDocumentManagerId(model.getDocumentManagerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setPkCode(model.getPkCode());
		soapModel.setParentId(model.getParentId());
		soapModel.setName(model.getName());
		soapModel.setCategory(model.getCategory());
		soapModel.setType(model.getType());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setFileExtension(model.getFileExtension());
		soapModel.setMineType(model.getMineType());
		soapModel.setPath(model.getPath());
		soapModel.setModuleId(model.getModuleId());
		soapModel.setAppId(model.getAppId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setIsPrivate(model.isIsPrivate());

		return soapModel;
	}

	public static DGDocumentManagerEntrySoap[] toSoapModels(
		DGDocumentManagerEntry[] models) {

		DGDocumentManagerEntrySoap[] soapModels =
			new DGDocumentManagerEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DGDocumentManagerEntrySoap[][] toSoapModels(
		DGDocumentManagerEntry[][] models) {

		DGDocumentManagerEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DGDocumentManagerEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DGDocumentManagerEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DGDocumentManagerEntrySoap[] toSoapModels(
		List<DGDocumentManagerEntry> models) {

		List<DGDocumentManagerEntrySoap> soapModels =
			new ArrayList<DGDocumentManagerEntrySoap>(models.size());

		for (DGDocumentManagerEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DGDocumentManagerEntrySoap[soapModels.size()]);
	}

	public DGDocumentManagerEntrySoap() {
	}

	public long getPrimaryKey() {
		return _documentManagerId;
	}

	public void setPrimaryKey(long pk) {
		setDocumentManagerId(pk);
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

	public long getDocumentManagerId() {
		return _documentManagerId;
	}

	public void setDocumentManagerId(long documentManagerId) {
		_documentManagerId = documentManagerId;
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

	public String getPkCode() {
		return _pkCode;
	}

	public void setPkCode(String pkCode) {
		_pkCode = pkCode;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileSize() {
		return _fileSize;
	}

	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
	}

	public String getFileExtension() {
		return _fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		_fileExtension = fileExtension;
	}

	public String getMineType() {
		return _mineType;
	}

	public void setMineType(String mineType) {
		_mineType = mineType;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
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

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public boolean getIsPrivate() {
		return _isPrivate;
	}

	public boolean isIsPrivate() {
		return _isPrivate;
	}

	public void setIsPrivate(boolean isPrivate) {
		_isPrivate = isPrivate;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _documentManagerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private long _creatorId;
	private String _pkCode;
	private long _parentId;
	private String _name;
	private String _category;
	private String _type;
	private long _fileId;
	private String _fileSize;
	private String _fileExtension;
	private String _mineType;
	private String _path;
	private String _moduleId;
	private String _appId;
	private long _departmentId;
	private boolean _isPrivate;

}