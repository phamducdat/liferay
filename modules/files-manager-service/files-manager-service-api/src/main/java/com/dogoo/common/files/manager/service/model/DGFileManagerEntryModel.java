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
 * The base model interface for the DGFileManagerEntry service. Represents a row in the &quot;DG_FileManager&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.common.files.manager.service.model.impl.DGFileManagerEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.common.files.manager.service.model.impl.DGFileManagerEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileManagerEntry
 * @generated
 */
@ProviderType
public interface DGFileManagerEntryModel
	extends BaseModel<DGFileManagerEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dg file manager entry model instance should use the {@link DGFileManagerEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this dg file manager entry.
	 *
	 * @return the primary key of this dg file manager entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dg file manager entry.
	 *
	 * @param primaryKey the primary key of this dg file manager entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dg file manager entry.
	 *
	 * @return the uuid of this dg file manager entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dg file manager entry.
	 *
	 * @param uuid the uuid of this dg file manager entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this dg file manager entry.
	 *
	 * @return the external reference code of this dg file manager entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this dg file manager entry.
	 *
	 * @param externalReferenceCode the external reference code of this dg file manager entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the file manager ID of this dg file manager entry.
	 *
	 * @return the file manager ID of this dg file manager entry
	 */
	public long getFileManagerId();

	/**
	 * Sets the file manager ID of this dg file manager entry.
	 *
	 * @param fileManagerId the file manager ID of this dg file manager entry
	 */
	public void setFileManagerId(long fileManagerId);

	/**
	 * Returns the group ID of this dg file manager entry.
	 *
	 * @return the group ID of this dg file manager entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dg file manager entry.
	 *
	 * @param groupId the group ID of this dg file manager entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dg file manager entry.
	 *
	 * @return the company ID of this dg file manager entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dg file manager entry.
	 *
	 * @param companyId the company ID of this dg file manager entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dg file manager entry.
	 *
	 * @return the user ID of this dg file manager entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dg file manager entry.
	 *
	 * @param userId the user ID of this dg file manager entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dg file manager entry.
	 *
	 * @return the user uuid of this dg file manager entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dg file manager entry.
	 *
	 * @param userUuid the user uuid of this dg file manager entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dg file manager entry.
	 *
	 * @return the user name of this dg file manager entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dg file manager entry.
	 *
	 * @param userName the user name of this dg file manager entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dg file manager entry.
	 *
	 * @return the create date of this dg file manager entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dg file manager entry.
	 *
	 * @param createDate the create date of this dg file manager entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dg file manager entry.
	 *
	 * @return the modified date of this dg file manager entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dg file manager entry.
	 *
	 * @param modifiedDate the modified date of this dg file manager entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the customer ID of this dg file manager entry.
	 *
	 * @return the customer ID of this dg file manager entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this dg file manager entry.
	 *
	 * @param customerId the customer ID of this dg file manager entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the creator ID of this dg file manager entry.
	 *
	 * @return the creator ID of this dg file manager entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this dg file manager entry.
	 *
	 * @param creatorId the creator ID of this dg file manager entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the file ID of this dg file manager entry.
	 *
	 * @return the file ID of this dg file manager entry
	 */
	public long getFileId();

	/**
	 * Sets the file ID of this dg file manager entry.
	 *
	 * @param fileId the file ID of this dg file manager entry
	 */
	public void setFileId(long fileId);

	/**
	 * Returns the parent code of this dg file manager entry.
	 *
	 * @return the parent code of this dg file manager entry
	 */
	@AutoEscape
	public String getParentCode();

	/**
	 * Sets the parent code of this dg file manager entry.
	 *
	 * @param parentCode the parent code of this dg file manager entry
	 */
	public void setParentCode(String parentCode);

	/**
	 * Returns the file type of this dg file manager entry.
	 *
	 * @return the file type of this dg file manager entry
	 */
	@AutoEscape
	public String getFileType();

	/**
	 * Sets the file type of this dg file manager entry.
	 *
	 * @param fileType the file type of this dg file manager entry
	 */
	public void setFileType(String fileType);

	/**
	 * Returns the type of this dg file manager entry.
	 *
	 * @return the type of this dg file manager entry
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this dg file manager entry.
	 *
	 * @param type the type of this dg file manager entry
	 */
	public void setType(String type);

	/**
	 * Returns the pk type of this dg file manager entry.
	 *
	 * @return the pk type of this dg file manager entry
	 */
	@AutoEscape
	public String getPkType();

	/**
	 * Sets the pk type of this dg file manager entry.
	 *
	 * @param pkType the pk type of this dg file manager entry
	 */
	public void setPkType(String pkType);

	/**
	 * Returns the file name of this dg file manager entry.
	 *
	 * @return the file name of this dg file manager entry
	 */
	@AutoEscape
	public String getFileName();

	/**
	 * Sets the file name of this dg file manager entry.
	 *
	 * @param fileName the file name of this dg file manager entry
	 */
	public void setFileName(String fileName);

	/**
	 * Returns the file size of this dg file manager entry.
	 *
	 * @return the file size of this dg file manager entry
	 */
	@AutoEscape
	public String getFileSize();

	/**
	 * Sets the file size of this dg file manager entry.
	 *
	 * @param fileSize the file size of this dg file manager entry
	 */
	public void setFileSize(String fileSize);

	/**
	 * Returns the module ID of this dg file manager entry.
	 *
	 * @return the module ID of this dg file manager entry
	 */
	@AutoEscape
	public String getModuleId();

	/**
	 * Sets the module ID of this dg file manager entry.
	 *
	 * @param moduleId the module ID of this dg file manager entry
	 */
	public void setModuleId(String moduleId);

	/**
	 * Returns the app ID of this dg file manager entry.
	 *
	 * @return the app ID of this dg file manager entry
	 */
	@AutoEscape
	public String getAppId();

	/**
	 * Sets the app ID of this dg file manager entry.
	 *
	 * @param appId the app ID of this dg file manager entry
	 */
	public void setAppId(String appId);

	@Override
	public DGFileManagerEntry cloneWithOriginalValues();

}