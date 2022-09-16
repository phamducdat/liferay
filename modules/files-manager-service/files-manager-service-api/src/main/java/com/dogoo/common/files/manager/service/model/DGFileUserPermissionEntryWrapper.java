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
 * This class is a wrapper for {@link DGFileUserPermissionEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileUserPermissionEntry
 * @generated
 */
public class DGFileUserPermissionEntryWrapper
	extends BaseModelWrapper<DGFileUserPermissionEntry>
	implements DGFileUserPermissionEntry,
			   ModelWrapper<DGFileUserPermissionEntry> {

	public DGFileUserPermissionEntryWrapper(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		super(dgFileUserPermissionEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("fileUserPermissionId", getFileUserPermissionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("fileId", getFileId());
		attributes.put("userAllowedId", getUserAllowedId());
		attributes.put("role", getRole());
		attributes.put("status", getStatus());
		attributes.put("type", getType());

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

		Long fileUserPermissionId = (Long)attributes.get(
			"fileUserPermissionId");

		if (fileUserPermissionId != null) {
			setFileUserPermissionId(fileUserPermissionId);
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

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Long userAllowedId = (Long)attributes.get("userAllowedId");

		if (userAllowedId != null) {
			setUserAllowedId(userAllowedId);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public DGFileUserPermissionEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this dg file user permission entry.
	 *
	 * @return the company ID of this dg file user permission entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dg file user permission entry.
	 *
	 * @return the create date of this dg file user permission entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this dg file user permission entry.
	 *
	 * @return the creator ID of this dg file user permission entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this dg file user permission entry.
	 *
	 * @return the customer ID of this dg file user permission entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the external reference code of this dg file user permission entry.
	 *
	 * @return the external reference code of this dg file user permission entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the file ID of this dg file user permission entry.
	 *
	 * @return the file ID of this dg file user permission entry
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the file user permission ID of this dg file user permission entry.
	 *
	 * @return the file user permission ID of this dg file user permission entry
	 */
	@Override
	public long getFileUserPermissionId() {
		return model.getFileUserPermissionId();
	}

	/**
	 * Returns the group ID of this dg file user permission entry.
	 *
	 * @return the group ID of this dg file user permission entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this dg file user permission entry.
	 *
	 * @return the modified date of this dg file user permission entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this dg file user permission entry.
	 *
	 * @return the primary key of this dg file user permission entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this dg file user permission entry.
	 *
	 * @return the role of this dg file user permission entry
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the status of this dg file user permission entry.
	 *
	 * @return the status of this dg file user permission entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this dg file user permission entry.
	 *
	 * @return the type of this dg file user permission entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user allowed ID of this dg file user permission entry.
	 *
	 * @return the user allowed ID of this dg file user permission entry
	 */
	@Override
	public long getUserAllowedId() {
		return model.getUserAllowedId();
	}

	/**
	 * Returns the user ID of this dg file user permission entry.
	 *
	 * @return the user ID of this dg file user permission entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this dg file user permission entry.
	 *
	 * @return the user name of this dg file user permission entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this dg file user permission entry.
	 *
	 * @return the user uuid of this dg file user permission entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this dg file user permission entry.
	 *
	 * @return the uuid of this dg file user permission entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this dg file user permission entry.
	 *
	 * @param companyId the company ID of this dg file user permission entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dg file user permission entry.
	 *
	 * @param createDate the create date of this dg file user permission entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this dg file user permission entry.
	 *
	 * @param creatorId the creator ID of this dg file user permission entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this dg file user permission entry.
	 *
	 * @param customerId the customer ID of this dg file user permission entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the external reference code of this dg file user permission entry.
	 *
	 * @param externalReferenceCode the external reference code of this dg file user permission entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the file ID of this dg file user permission entry.
	 *
	 * @param fileId the file ID of this dg file user permission entry
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the file user permission ID of this dg file user permission entry.
	 *
	 * @param fileUserPermissionId the file user permission ID of this dg file user permission entry
	 */
	@Override
	public void setFileUserPermissionId(long fileUserPermissionId) {
		model.setFileUserPermissionId(fileUserPermissionId);
	}

	/**
	 * Sets the group ID of this dg file user permission entry.
	 *
	 * @param groupId the group ID of this dg file user permission entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this dg file user permission entry.
	 *
	 * @param modifiedDate the modified date of this dg file user permission entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this dg file user permission entry.
	 *
	 * @param primaryKey the primary key of this dg file user permission entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this dg file user permission entry.
	 *
	 * @param role the role of this dg file user permission entry
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the status of this dg file user permission entry.
	 *
	 * @param status the status of this dg file user permission entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type of this dg file user permission entry.
	 *
	 * @param type the type of this dg file user permission entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user allowed ID of this dg file user permission entry.
	 *
	 * @param userAllowedId the user allowed ID of this dg file user permission entry
	 */
	@Override
	public void setUserAllowedId(long userAllowedId) {
		model.setUserAllowedId(userAllowedId);
	}

	/**
	 * Sets the user ID of this dg file user permission entry.
	 *
	 * @param userId the user ID of this dg file user permission entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this dg file user permission entry.
	 *
	 * @param userName the user name of this dg file user permission entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this dg file user permission entry.
	 *
	 * @param userUuid the user uuid of this dg file user permission entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this dg file user permission entry.
	 *
	 * @param uuid the uuid of this dg file user permission entry
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
	protected DGFileUserPermissionEntryWrapper wrap(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return new DGFileUserPermissionEntryWrapper(dgFileUserPermissionEntry);
	}

}