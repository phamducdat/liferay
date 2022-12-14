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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DGFilePermissionEntry service. Represents a row in the &quot;DG_FilePermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionEntry
 * @generated
 */
@ProviderType
public interface DGFilePermissionEntryModel
	extends BaseModel<DGFilePermissionEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dg file permission entry model instance should use the {@link DGFilePermissionEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this dg file permission entry.
	 *
	 * @return the primary key of this dg file permission entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dg file permission entry.
	 *
	 * @param primaryKey the primary key of this dg file permission entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dg file permission entry.
	 *
	 * @return the uuid of this dg file permission entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dg file permission entry.
	 *
	 * @param uuid the uuid of this dg file permission entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this dg file permission entry.
	 *
	 * @return the external reference code of this dg file permission entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this dg file permission entry.
	 *
	 * @param externalReferenceCode the external reference code of this dg file permission entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the file permission ID of this dg file permission entry.
	 *
	 * @return the file permission ID of this dg file permission entry
	 */
	public long getFilePermissionId();

	/**
	 * Sets the file permission ID of this dg file permission entry.
	 *
	 * @param filePermissionId the file permission ID of this dg file permission entry
	 */
	public void setFilePermissionId(long filePermissionId);

	/**
	 * Returns the group ID of this dg file permission entry.
	 *
	 * @return the group ID of this dg file permission entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dg file permission entry.
	 *
	 * @param groupId the group ID of this dg file permission entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dg file permission entry.
	 *
	 * @return the company ID of this dg file permission entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dg file permission entry.
	 *
	 * @param companyId the company ID of this dg file permission entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dg file permission entry.
	 *
	 * @return the user ID of this dg file permission entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dg file permission entry.
	 *
	 * @param userId the user ID of this dg file permission entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dg file permission entry.
	 *
	 * @return the user uuid of this dg file permission entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dg file permission entry.
	 *
	 * @param userUuid the user uuid of this dg file permission entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dg file permission entry.
	 *
	 * @return the user name of this dg file permission entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dg file permission entry.
	 *
	 * @param userName the user name of this dg file permission entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dg file permission entry.
	 *
	 * @return the create date of this dg file permission entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dg file permission entry.
	 *
	 * @param createDate the create date of this dg file permission entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dg file permission entry.
	 *
	 * @return the modified date of this dg file permission entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dg file permission entry.
	 *
	 * @param modifiedDate the modified date of this dg file permission entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the customer ID of this dg file permission entry.
	 *
	 * @return the customer ID of this dg file permission entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this dg file permission entry.
	 *
	 * @param customerId the customer ID of this dg file permission entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the creator ID of this dg file permission entry.
	 *
	 * @return the creator ID of this dg file permission entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this dg file permission entry.
	 *
	 * @param creatorId the creator ID of this dg file permission entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the file ID of this dg file permission entry.
	 *
	 * @return the file ID of this dg file permission entry
	 */
	public long getFileId();

	/**
	 * Sets the file ID of this dg file permission entry.
	 *
	 * @param fileId the file ID of this dg file permission entry
	 */
	public void setFileId(long fileId);

	/**
	 * Returns the general permission of this dg file permission entry.
	 *
	 * @return the general permission of this dg file permission entry
	 */
	@AutoEscape
	public String getGeneralPermission();

	/**
	 * Sets the general permission of this dg file permission entry.
	 *
	 * @param generalPermission the general permission of this dg file permission entry
	 */
	public void setGeneralPermission(String generalPermission);

	/**
	 * Returns the role of this dg file permission entry.
	 *
	 * @return the role of this dg file permission entry
	 */
	@AutoEscape
	public String getRole();

	/**
	 * Sets the role of this dg file permission entry.
	 *
	 * @param role the role of this dg file permission entry
	 */
	public void setRole(String role);

	/**
	 * Returns the allow action for editor of this dg file permission entry.
	 *
	 * @return the allow action for editor of this dg file permission entry
	 */
	public boolean getAllowActionForEditor();

	/**
	 * Returns <code>true</code> if this dg file permission entry is allow action for editor.
	 *
	 * @return <code>true</code> if this dg file permission entry is allow action for editor; <code>false</code> otherwise
	 */
	public boolean isAllowActionForEditor();

	/**
	 * Sets whether this dg file permission entry is allow action for editor.
	 *
	 * @param allowActionForEditor the allow action for editor of this dg file permission entry
	 */
	public void setAllowActionForEditor(boolean allowActionForEditor);

	/**
	 * Returns the allow action for viewer of this dg file permission entry.
	 *
	 * @return the allow action for viewer of this dg file permission entry
	 */
	public boolean getAllowActionForViewer();

	/**
	 * Returns <code>true</code> if this dg file permission entry is allow action for viewer.
	 *
	 * @return <code>true</code> if this dg file permission entry is allow action for viewer; <code>false</code> otherwise
	 */
	public boolean isAllowActionForViewer();

	/**
	 * Sets whether this dg file permission entry is allow action for viewer.
	 *
	 * @param allowActionForViewer the allow action for viewer of this dg file permission entry
	 */
	public void setAllowActionForViewer(boolean allowActionForViewer);

	@Override
	public DGFilePermissionEntry cloneWithOriginalValues();

}