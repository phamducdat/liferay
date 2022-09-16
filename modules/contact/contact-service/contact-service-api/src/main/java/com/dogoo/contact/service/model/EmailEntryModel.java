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

package com.dogoo.contact.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EmailEntry service. Represents a row in the &quot;DG_EmailEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.contact.service.model.impl.EmailEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.contact.service.model.impl.EmailEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailEntry
 * @generated
 */
@ProviderType
public interface EmailEntryModel
	extends BaseModel<EmailEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a email entry model instance should use the {@link EmailEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this email entry.
	 *
	 * @return the primary key of this email entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this email entry.
	 *
	 * @param primaryKey the primary key of this email entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this email entry.
	 *
	 * @return the uuid of this email entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this email entry.
	 *
	 * @param uuid the uuid of this email entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this email entry.
	 *
	 * @return the external reference code of this email entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this email entry.
	 *
	 * @param externalReferenceCode the external reference code of this email entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the email ID of this email entry.
	 *
	 * @return the email ID of this email entry
	 */
	public long getEmailId();

	/**
	 * Sets the email ID of this email entry.
	 *
	 * @param emailId the email ID of this email entry
	 */
	public void setEmailId(long emailId);

	/**
	 * Returns the group ID of this email entry.
	 *
	 * @return the group ID of this email entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this email entry.
	 *
	 * @param groupId the group ID of this email entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this email entry.
	 *
	 * @return the company ID of this email entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this email entry.
	 *
	 * @param companyId the company ID of this email entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this email entry.
	 *
	 * @return the user ID of this email entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this email entry.
	 *
	 * @param userId the user ID of this email entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this email entry.
	 *
	 * @return the user uuid of this email entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this email entry.
	 *
	 * @param userUuid the user uuid of this email entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this email entry.
	 *
	 * @return the user name of this email entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this email entry.
	 *
	 * @param userName the user name of this email entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this email entry.
	 *
	 * @return the create date of this email entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this email entry.
	 *
	 * @param createDate the create date of this email entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this email entry.
	 *
	 * @return the modified date of this email entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this email entry.
	 *
	 * @param modifiedDate the modified date of this email entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the creator ID of this email entry.
	 *
	 * @return the creator ID of this email entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this email entry.
	 *
	 * @param creatorId the creator ID of this email entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the customer ID of this email entry.
	 *
	 * @return the customer ID of this email entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this email entry.
	 *
	 * @param customerId the customer ID of this email entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the contact ID of this email entry.
	 *
	 * @return the contact ID of this email entry
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this email entry.
	 *
	 * @param contactId the contact ID of this email entry
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the email address of this email entry.
	 *
	 * @return the email address of this email entry
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this email entry.
	 *
	 * @param emailAddress the email address of this email entry
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the is defaulted of this email entry.
	 *
	 * @return the is defaulted of this email entry
	 */
	public boolean getIsDefaulted();

	/**
	 * Returns <code>true</code> if this email entry is is defaulted.
	 *
	 * @return <code>true</code> if this email entry is is defaulted; <code>false</code> otherwise
	 */
	public boolean isIsDefaulted();

	/**
	 * Sets whether this email entry is is defaulted.
	 *
	 * @param isDefaulted the is defaulted of this email entry
	 */
	public void setIsDefaulted(boolean isDefaulted);

	/**
	 * Returns the description of this email entry.
	 *
	 * @return the description of this email entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this email entry.
	 *
	 * @param description the description of this email entry
	 */
	public void setDescription(String description);

	@Override
	public EmailEntry cloneWithOriginalValues();

}