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
 * This class is a wrapper for {@link DGFilePermissionEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionEntry
 * @generated
 */
public class DGFilePermissionEntryWrapper
	extends BaseModelWrapper<DGFilePermissionEntry>
	implements DGFilePermissionEntry, ModelWrapper<DGFilePermissionEntry> {

	public DGFilePermissionEntryWrapper(
		DGFilePermissionEntry dgFilePermissionEntry) {

		super(dgFilePermissionEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("filePermissionId", getFilePermissionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("fileId", getFileId());
		attributes.put("generalPermission", getGeneralPermission());
		attributes.put("role", getRole());
		attributes.put("allowActionForEditor", isAllowActionForEditor());
		attributes.put("allowActionForViewer", isAllowActionForViewer());

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

		Long filePermissionId = (Long)attributes.get("filePermissionId");

		if (filePermissionId != null) {
			setFilePermissionId(filePermissionId);
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

		String generalPermission = (String)attributes.get("generalPermission");

		if (generalPermission != null) {
			setGeneralPermission(generalPermission);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Boolean allowActionForEditor = (Boolean)attributes.get(
			"allowActionForEditor");

		if (allowActionForEditor != null) {
			setAllowActionForEditor(allowActionForEditor);
		}

		Boolean allowActionForViewer = (Boolean)attributes.get(
			"allowActionForViewer");

		if (allowActionForViewer != null) {
			setAllowActionForViewer(allowActionForViewer);
		}
	}

	@Override
	public DGFilePermissionEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allow action for editor of this dg file permission entry.
	 *
	 * @return the allow action for editor of this dg file permission entry
	 */
	@Override
	public boolean getAllowActionForEditor() {
		return model.getAllowActionForEditor();
	}

	/**
	 * Returns the allow action for viewer of this dg file permission entry.
	 *
	 * @return the allow action for viewer of this dg file permission entry
	 */
	@Override
	public boolean getAllowActionForViewer() {
		return model.getAllowActionForViewer();
	}

	/**
	 * Returns the company ID of this dg file permission entry.
	 *
	 * @return the company ID of this dg file permission entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dg file permission entry.
	 *
	 * @return the create date of this dg file permission entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this dg file permission entry.
	 *
	 * @return the creator ID of this dg file permission entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this dg file permission entry.
	 *
	 * @return the customer ID of this dg file permission entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the external reference code of this dg file permission entry.
	 *
	 * @return the external reference code of this dg file permission entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the file ID of this dg file permission entry.
	 *
	 * @return the file ID of this dg file permission entry
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the file permission ID of this dg file permission entry.
	 *
	 * @return the file permission ID of this dg file permission entry
	 */
	@Override
	public long getFilePermissionId() {
		return model.getFilePermissionId();
	}

	/**
	 * Returns the general permission of this dg file permission entry.
	 *
	 * @return the general permission of this dg file permission entry
	 */
	@Override
	public String getGeneralPermission() {
		return model.getGeneralPermission();
	}

	/**
	 * Returns the group ID of this dg file permission entry.
	 *
	 * @return the group ID of this dg file permission entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this dg file permission entry.
	 *
	 * @return the modified date of this dg file permission entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this dg file permission entry.
	 *
	 * @return the primary key of this dg file permission entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this dg file permission entry.
	 *
	 * @return the role of this dg file permission entry
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the user ID of this dg file permission entry.
	 *
	 * @return the user ID of this dg file permission entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this dg file permission entry.
	 *
	 * @return the user name of this dg file permission entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this dg file permission entry.
	 *
	 * @return the user uuid of this dg file permission entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this dg file permission entry.
	 *
	 * @return the uuid of this dg file permission entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this dg file permission entry is allow action for editor.
	 *
	 * @return <code>true</code> if this dg file permission entry is allow action for editor; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllowActionForEditor() {
		return model.isAllowActionForEditor();
	}

	/**
	 * Returns <code>true</code> if this dg file permission entry is allow action for viewer.
	 *
	 * @return <code>true</code> if this dg file permission entry is allow action for viewer; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllowActionForViewer() {
		return model.isAllowActionForViewer();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this dg file permission entry is allow action for editor.
	 *
	 * @param allowActionForEditor the allow action for editor of this dg file permission entry
	 */
	@Override
	public void setAllowActionForEditor(boolean allowActionForEditor) {
		model.setAllowActionForEditor(allowActionForEditor);
	}

	/**
	 * Sets whether this dg file permission entry is allow action for viewer.
	 *
	 * @param allowActionForViewer the allow action for viewer of this dg file permission entry
	 */
	@Override
	public void setAllowActionForViewer(boolean allowActionForViewer) {
		model.setAllowActionForViewer(allowActionForViewer);
	}

	/**
	 * Sets the company ID of this dg file permission entry.
	 *
	 * @param companyId the company ID of this dg file permission entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dg file permission entry.
	 *
	 * @param createDate the create date of this dg file permission entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this dg file permission entry.
	 *
	 * @param creatorId the creator ID of this dg file permission entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this dg file permission entry.
	 *
	 * @param customerId the customer ID of this dg file permission entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the external reference code of this dg file permission entry.
	 *
	 * @param externalReferenceCode the external reference code of this dg file permission entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the file ID of this dg file permission entry.
	 *
	 * @param fileId the file ID of this dg file permission entry
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the file permission ID of this dg file permission entry.
	 *
	 * @param filePermissionId the file permission ID of this dg file permission entry
	 */
	@Override
	public void setFilePermissionId(long filePermissionId) {
		model.setFilePermissionId(filePermissionId);
	}

	/**
	 * Sets the general permission of this dg file permission entry.
	 *
	 * @param generalPermission the general permission of this dg file permission entry
	 */
	@Override
	public void setGeneralPermission(String generalPermission) {
		model.setGeneralPermission(generalPermission);
	}

	/**
	 * Sets the group ID of this dg file permission entry.
	 *
	 * @param groupId the group ID of this dg file permission entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this dg file permission entry.
	 *
	 * @param modifiedDate the modified date of this dg file permission entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this dg file permission entry.
	 *
	 * @param primaryKey the primary key of this dg file permission entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this dg file permission entry.
	 *
	 * @param role the role of this dg file permission entry
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the user ID of this dg file permission entry.
	 *
	 * @param userId the user ID of this dg file permission entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this dg file permission entry.
	 *
	 * @param userName the user name of this dg file permission entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this dg file permission entry.
	 *
	 * @param userUuid the user uuid of this dg file permission entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this dg file permission entry.
	 *
	 * @param uuid the uuid of this dg file permission entry
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
	protected DGFilePermissionEntryWrapper wrap(
		DGFilePermissionEntry dgFilePermissionEntry) {

		return new DGFilePermissionEntryWrapper(dgFilePermissionEntry);
	}

}