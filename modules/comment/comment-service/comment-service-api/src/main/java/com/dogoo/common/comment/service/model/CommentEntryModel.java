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

package com.dogoo.common.comment.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CommentEntry service. Represents a row in the &quot;DG_CommentEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.common.comment.service.model.impl.CommentEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.common.comment.service.model.impl.CommentEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentEntry
 * @generated
 */
@ProviderType
public interface CommentEntryModel
	extends BaseModel<CommentEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a comment entry model instance should use the {@link CommentEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this comment entry.
	 *
	 * @return the primary key of this comment entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this comment entry.
	 *
	 * @param primaryKey the primary key of this comment entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this comment entry.
	 *
	 * @return the uuid of this comment entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this comment entry.
	 *
	 * @param uuid the uuid of this comment entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this comment entry.
	 *
	 * @return the external reference code of this comment entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this comment entry.
	 *
	 * @param externalReferenceCode the external reference code of this comment entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the comment ID of this comment entry.
	 *
	 * @return the comment ID of this comment entry
	 */
	public long getCommentId();

	/**
	 * Sets the comment ID of this comment entry.
	 *
	 * @param commentId the comment ID of this comment entry
	 */
	public void setCommentId(long commentId);

	/**
	 * Returns the group ID of this comment entry.
	 *
	 * @return the group ID of this comment entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this comment entry.
	 *
	 * @param groupId the group ID of this comment entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this comment entry.
	 *
	 * @return the company ID of this comment entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this comment entry.
	 *
	 * @param companyId the company ID of this comment entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this comment entry.
	 *
	 * @return the user ID of this comment entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this comment entry.
	 *
	 * @param userId the user ID of this comment entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this comment entry.
	 *
	 * @return the user uuid of this comment entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this comment entry.
	 *
	 * @param userUuid the user uuid of this comment entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this comment entry.
	 *
	 * @return the user name of this comment entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this comment entry.
	 *
	 * @param userName the user name of this comment entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this comment entry.
	 *
	 * @return the create date of this comment entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this comment entry.
	 *
	 * @param createDate the create date of this comment entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this comment entry.
	 *
	 * @return the modified date of this comment entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this comment entry.
	 *
	 * @param modifiedDate the modified date of this comment entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the customer ID of this comment entry.
	 *
	 * @return the customer ID of this comment entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this comment entry.
	 *
	 * @param customerId the customer ID of this comment entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the creator ID of this comment entry.
	 *
	 * @return the creator ID of this comment entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this comment entry.
	 *
	 * @param creatorId the creator ID of this comment entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the class pk ID of this comment entry.
	 *
	 * @return the class pk ID of this comment entry
	 */
	public long getClassPkId();

	/**
	 * Sets the class pk ID of this comment entry.
	 *
	 * @param classPkId the class pk ID of this comment entry
	 */
	public void setClassPkId(long classPkId);

	/**
	 * Returns the class pk name of this comment entry.
	 *
	 * @return the class pk name of this comment entry
	 */
	@AutoEscape
	public String getClassPkName();

	/**
	 * Sets the class pk name of this comment entry.
	 *
	 * @param classPkName the class pk name of this comment entry
	 */
	public void setClassPkName(String classPkName);

	/**
	 * Returns the creator full name of this comment entry.
	 *
	 * @return the creator full name of this comment entry
	 */
	@AutoEscape
	public String getCreatorFullName();

	/**
	 * Sets the creator full name of this comment entry.
	 *
	 * @param creatorFullName the creator full name of this comment entry
	 */
	public void setCreatorFullName(String creatorFullName);

	/**
	 * Returns the content of this comment entry.
	 *
	 * @return the content of this comment entry
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this comment entry.
	 *
	 * @param content the content of this comment entry
	 */
	public void setContent(String content);

	/**
	 * Returns the parent ID of this comment entry.
	 *
	 * @return the parent ID of this comment entry
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this comment entry.
	 *
	 * @param parentId the parent ID of this comment entry
	 */
	public void setParentId(long parentId);

	@Override
	public CommentEntry cloneWithOriginalValues();

}