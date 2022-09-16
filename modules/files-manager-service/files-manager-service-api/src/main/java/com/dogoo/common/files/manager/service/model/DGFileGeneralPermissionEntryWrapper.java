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
 * This class is a wrapper for {@link DGFileGeneralPermissionEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileGeneralPermissionEntry
 * @generated
 */
public class DGFileGeneralPermissionEntryWrapper
	extends BaseModelWrapper<DGFileGeneralPermissionEntry>
	implements DGFileGeneralPermissionEntry,
			   ModelWrapper<DGFileGeneralPermissionEntry> {

	public DGFileGeneralPermissionEntryWrapper(
		DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		super(dgFileGeneralPermissionEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("fileGeneralPermissionId", getFileGeneralPermissionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("fileId", getFileId());
		attributes.put("allowed", getAllowed());
		attributes.put("role", getRole());
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

		Long fileGeneralPermissionId = (Long)attributes.get(
			"fileGeneralPermissionId");

		if (fileGeneralPermissionId != null) {
			setFileGeneralPermissionId(fileGeneralPermissionId);
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

		String allowed = (String)attributes.get("allowed");

		if (allowed != null) {
			setAllowed(allowed);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public DGFileGeneralPermissionEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allowed of this dg file general permission entry.
	 *
	 * @return the allowed of this dg file general permission entry
	 */
	@Override
	public String getAllowed() {
		return model.getAllowed();
	}

	/**
	 * Returns the company ID of this dg file general permission entry.
	 *
	 * @return the company ID of this dg file general permission entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dg file general permission entry.
	 *
	 * @return the create date of this dg file general permission entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this dg file general permission entry.
	 *
	 * @return the creator ID of this dg file general permission entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this dg file general permission entry.
	 *
	 * @return the customer ID of this dg file general permission entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the external reference code of this dg file general permission entry.
	 *
	 * @return the external reference code of this dg file general permission entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the file general permission ID of this dg file general permission entry.
	 *
	 * @return the file general permission ID of this dg file general permission entry
	 */
	@Override
	public long getFileGeneralPermissionId() {
		return model.getFileGeneralPermissionId();
	}

	/**
	 * Returns the file ID of this dg file general permission entry.
	 *
	 * @return the file ID of this dg file general permission entry
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the group ID of this dg file general permission entry.
	 *
	 * @return the group ID of this dg file general permission entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this dg file general permission entry.
	 *
	 * @return the modified date of this dg file general permission entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this dg file general permission entry.
	 *
	 * @return the primary key of this dg file general permission entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this dg file general permission entry.
	 *
	 * @return the role of this dg file general permission entry
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the type of this dg file general permission entry.
	 *
	 * @return the type of this dg file general permission entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this dg file general permission entry.
	 *
	 * @return the user ID of this dg file general permission entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this dg file general permission entry.
	 *
	 * @return the user name of this dg file general permission entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this dg file general permission entry.
	 *
	 * @return the user uuid of this dg file general permission entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this dg file general permission entry.
	 *
	 * @return the uuid of this dg file general permission entry
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
	 * Sets the allowed of this dg file general permission entry.
	 *
	 * @param allowed the allowed of this dg file general permission entry
	 */
	@Override
	public void setAllowed(String allowed) {
		model.setAllowed(allowed);
	}

	/**
	 * Sets the company ID of this dg file general permission entry.
	 *
	 * @param companyId the company ID of this dg file general permission entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dg file general permission entry.
	 *
	 * @param createDate the create date of this dg file general permission entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this dg file general permission entry.
	 *
	 * @param creatorId the creator ID of this dg file general permission entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this dg file general permission entry.
	 *
	 * @param customerId the customer ID of this dg file general permission entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the external reference code of this dg file general permission entry.
	 *
	 * @param externalReferenceCode the external reference code of this dg file general permission entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the file general permission ID of this dg file general permission entry.
	 *
	 * @param fileGeneralPermissionId the file general permission ID of this dg file general permission entry
	 */
	@Override
	public void setFileGeneralPermissionId(long fileGeneralPermissionId) {
		model.setFileGeneralPermissionId(fileGeneralPermissionId);
	}

	/**
	 * Sets the file ID of this dg file general permission entry.
	 *
	 * @param fileId the file ID of this dg file general permission entry
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the group ID of this dg file general permission entry.
	 *
	 * @param groupId the group ID of this dg file general permission entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this dg file general permission entry.
	 *
	 * @param modifiedDate the modified date of this dg file general permission entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this dg file general permission entry.
	 *
	 * @param primaryKey the primary key of this dg file general permission entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this dg file general permission entry.
	 *
	 * @param role the role of this dg file general permission entry
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the type of this dg file general permission entry.
	 *
	 * @param type the type of this dg file general permission entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this dg file general permission entry.
	 *
	 * @param userId the user ID of this dg file general permission entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this dg file general permission entry.
	 *
	 * @param userName the user name of this dg file general permission entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this dg file general permission entry.
	 *
	 * @param userUuid the user uuid of this dg file general permission entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this dg file general permission entry.
	 *
	 * @param uuid the uuid of this dg file general permission entry
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
	protected DGFileGeneralPermissionEntryWrapper wrap(
		DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		return new DGFileGeneralPermissionEntryWrapper(
			dgFileGeneralPermissionEntry);
	}

}