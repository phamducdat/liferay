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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DGDocumentManagerEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGDocumentManagerEntry
 * @generated
 */
public class DGDocumentManagerEntryWrapper
	extends BaseModelWrapper<DGDocumentManagerEntry>
	implements DGDocumentManagerEntry, ModelWrapper<DGDocumentManagerEntry> {

	public DGDocumentManagerEntryWrapper(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		super(dgDocumentManagerEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("documentManagerId", getDocumentManagerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("pkCode", getPkCode());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("category", getCategory());
		attributes.put("type", getType());
		attributes.put("fileId", getFileId());
		attributes.put("fileSize", getFileSize());
		attributes.put("fileExtension", getFileExtension());
		attributes.put("mineType", getMineType());
		attributes.put("path", getPath());
		attributes.put("moduleId", getModuleId());
		attributes.put("appId", getAppId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("isPrivate", isIsPrivate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long documentManagerId = (Long)attributes.get("documentManagerId");

		if (documentManagerId != null) {
			setDocumentManagerId(documentManagerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		String pkCode = (String)attributes.get("pkCode");

		if (pkCode != null) {
			setPkCode(pkCode);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String fileExtension = (String)attributes.get("fileExtension");

		if (fileExtension != null) {
			setFileExtension(fileExtension);
		}

		String mineType = (String)attributes.get("mineType");

		if (mineType != null) {
			setMineType(mineType);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String moduleId = (String)attributes.get("moduleId");

		if (moduleId != null) {
			setModuleId(moduleId);
		}

		String appId = (String)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Boolean isPrivate = (Boolean)attributes.get("isPrivate");

		if (isPrivate != null) {
			setIsPrivate(isPrivate);
		}
	}

	@Override
	public DGDocumentManagerEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the app ID of this dg document manager entry.
	 *
	 * @return the app ID of this dg document manager entry
	 */
	@Override
	public String getAppId() {
		return model.getAppId();
	}

	/**
	 * Returns the category of this dg document manager entry.
	 *
	 * @return the category of this dg document manager entry
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the company ID of this dg document manager entry.
	 *
	 * @return the company ID of this dg document manager entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dg document manager entry.
	 *
	 * @return the create date of this dg document manager entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this dg document manager entry.
	 *
	 * @return the creator ID of this dg document manager entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this dg document manager entry.
	 *
	 * @return the customer ID of this dg document manager entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the department ID of this dg document manager entry.
	 *
	 * @return the department ID of this dg document manager entry
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the document manager ID of this dg document manager entry.
	 *
	 * @return the document manager ID of this dg document manager entry
	 */
	@Override
	public long getDocumentManagerId() {
		return model.getDocumentManagerId();
	}

	/**
	 * Returns the external reference code of this dg document manager entry.
	 *
	 * @return the external reference code of this dg document manager entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the file extension of this dg document manager entry.
	 *
	 * @return the file extension of this dg document manager entry
	 */
	@Override
	public String getFileExtension() {
		return model.getFileExtension();
	}

	/**
	 * Returns the file ID of this dg document manager entry.
	 *
	 * @return the file ID of this dg document manager entry
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the file size of this dg document manager entry.
	 *
	 * @return the file size of this dg document manager entry
	 */
	@Override
	public String getFileSize() {
		return model.getFileSize();
	}

	/**
	 * Returns the group ID of this dg document manager entry.
	 *
	 * @return the group ID of this dg document manager entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is private of this dg document manager entry.
	 *
	 * @return the is private of this dg document manager entry
	 */
	@Override
	public boolean getIsPrivate() {
		return model.getIsPrivate();
	}

	/**
	 * Returns the mine type of this dg document manager entry.
	 *
	 * @return the mine type of this dg document manager entry
	 */
	@Override
	public String getMineType() {
		return model.getMineType();
	}

	/**
	 * Returns the modified date of this dg document manager entry.
	 *
	 * @return the modified date of this dg document manager entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the module ID of this dg document manager entry.
	 *
	 * @return the module ID of this dg document manager entry
	 */
	@Override
	public String getModuleId() {
		return model.getModuleId();
	}

	/**
	 * Returns the name of this dg document manager entry.
	 *
	 * @return the name of this dg document manager entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent ID of this dg document manager entry.
	 *
	 * @return the parent ID of this dg document manager entry
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the path of this dg document manager entry.
	 *
	 * @return the path of this dg document manager entry
	 */
	@Override
	public String getPath() {
		return model.getPath();
	}

	/**
	 * Returns the pk code of this dg document manager entry.
	 *
	 * @return the pk code of this dg document manager entry
	 */
	@Override
	public String getPkCode() {
		return model.getPkCode();
	}

	/**
	 * Returns the primary key of this dg document manager entry.
	 *
	 * @return the primary key of this dg document manager entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this dg document manager entry.
	 *
	 * @return the type of this dg document manager entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this dg document manager entry.
	 *
	 * @return the user ID of this dg document manager entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this dg document manager entry.
	 *
	 * @return the user name of this dg document manager entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this dg document manager entry.
	 *
	 * @return the user uuid of this dg document manager entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this dg document manager entry.
	 *
	 * @return the uuid of this dg document manager entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this dg document manager entry is is private.
	 *
	 * @return <code>true</code> if this dg document manager entry is is private; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsPrivate() {
		return model.isIsPrivate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the app ID of this dg document manager entry.
	 *
	 * @param appId the app ID of this dg document manager entry
	 */
	@Override
	public void setAppId(String appId) {
		model.setAppId(appId);
	}

	/**
	 * Sets the category of this dg document manager entry.
	 *
	 * @param category the category of this dg document manager entry
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the company ID of this dg document manager entry.
	 *
	 * @param companyId the company ID of this dg document manager entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dg document manager entry.
	 *
	 * @param createDate the create date of this dg document manager entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this dg document manager entry.
	 *
	 * @param creatorId the creator ID of this dg document manager entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this dg document manager entry.
	 *
	 * @param customerId the customer ID of this dg document manager entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the department ID of this dg document manager entry.
	 *
	 * @param departmentId the department ID of this dg document manager entry
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the document manager ID of this dg document manager entry.
	 *
	 * @param documentManagerId the document manager ID of this dg document manager entry
	 */
	@Override
	public void setDocumentManagerId(long documentManagerId) {
		model.setDocumentManagerId(documentManagerId);
	}

	/**
	 * Sets the external reference code of this dg document manager entry.
	 *
	 * @param externalReferenceCode the external reference code of this dg document manager entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the file extension of this dg document manager entry.
	 *
	 * @param fileExtension the file extension of this dg document manager entry
	 */
	@Override
	public void setFileExtension(String fileExtension) {
		model.setFileExtension(fileExtension);
	}

	/**
	 * Sets the file ID of this dg document manager entry.
	 *
	 * @param fileId the file ID of this dg document manager entry
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the file size of this dg document manager entry.
	 *
	 * @param fileSize the file size of this dg document manager entry
	 */
	@Override
	public void setFileSize(String fileSize) {
		model.setFileSize(fileSize);
	}

	/**
	 * Sets the group ID of this dg document manager entry.
	 *
	 * @param groupId the group ID of this dg document manager entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this dg document manager entry is is private.
	 *
	 * @param isPrivate the is private of this dg document manager entry
	 */
	@Override
	public void setIsPrivate(boolean isPrivate) {
		model.setIsPrivate(isPrivate);
	}

	/**
	 * Sets the mine type of this dg document manager entry.
	 *
	 * @param mineType the mine type of this dg document manager entry
	 */
	@Override
	public void setMineType(String mineType) {
		model.setMineType(mineType);
	}

	/**
	 * Sets the modified date of this dg document manager entry.
	 *
	 * @param modifiedDate the modified date of this dg document manager entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the module ID of this dg document manager entry.
	 *
	 * @param moduleId the module ID of this dg document manager entry
	 */
	@Override
	public void setModuleId(String moduleId) {
		model.setModuleId(moduleId);
	}

	/**
	 * Sets the name of this dg document manager entry.
	 *
	 * @param name the name of this dg document manager entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent ID of this dg document manager entry.
	 *
	 * @param parentId the parent ID of this dg document manager entry
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the path of this dg document manager entry.
	 *
	 * @param path the path of this dg document manager entry
	 */
	@Override
	public void setPath(String path) {
		model.setPath(path);
	}

	/**
	 * Sets the pk code of this dg document manager entry.
	 *
	 * @param pkCode the pk code of this dg document manager entry
	 */
	@Override
	public void setPkCode(String pkCode) {
		model.setPkCode(pkCode);
	}

	/**
	 * Sets the primary key of this dg document manager entry.
	 *
	 * @param primaryKey the primary key of this dg document manager entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this dg document manager entry.
	 *
	 * @param type the type of this dg document manager entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this dg document manager entry.
	 *
	 * @param userId the user ID of this dg document manager entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this dg document manager entry.
	 *
	 * @param userName the user name of this dg document manager entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this dg document manager entry.
	 *
	 * @param userUuid the user uuid of this dg document manager entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this dg document manager entry.
	 *
	 * @param uuid the uuid of this dg document manager entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DGDocumentManagerEntryWrapper wrap(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		return new DGDocumentManagerEntryWrapper(dgDocumentManagerEntry);
	}

}