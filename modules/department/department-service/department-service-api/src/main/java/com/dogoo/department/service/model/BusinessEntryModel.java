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

package com.dogoo.department.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the BusinessEntry service. Represents a row in the &quot;DG_BusinessEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.department.service.model.impl.BusinessEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.department.service.model.impl.BusinessEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntry
 * @generated
 */
@ProviderType
public interface BusinessEntryModel
	extends BaseModel<BusinessEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a business entry model instance should use the {@link BusinessEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this business entry.
	 *
	 * @return the primary key of this business entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this business entry.
	 *
	 * @param primaryKey the primary key of this business entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this business entry.
	 *
	 * @return the uuid of this business entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this business entry.
	 *
	 * @param uuid the uuid of this business entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this business entry.
	 *
	 * @return the external reference code of this business entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this business entry.
	 *
	 * @param externalReferenceCode the external reference code of this business entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the business ID of this business entry.
	 *
	 * @return the business ID of this business entry
	 */
	public long getBusinessId();

	/**
	 * Sets the business ID of this business entry.
	 *
	 * @param businessId the business ID of this business entry
	 */
	public void setBusinessId(long businessId);

	/**
	 * Returns the group ID of this business entry.
	 *
	 * @return the group ID of this business entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this business entry.
	 *
	 * @param groupId the group ID of this business entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this business entry.
	 *
	 * @return the company ID of this business entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this business entry.
	 *
	 * @param companyId the company ID of this business entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this business entry.
	 *
	 * @return the user ID of this business entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this business entry.
	 *
	 * @param userId the user ID of this business entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this business entry.
	 *
	 * @return the user uuid of this business entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this business entry.
	 *
	 * @param userUuid the user uuid of this business entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this business entry.
	 *
	 * @return the user name of this business entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this business entry.
	 *
	 * @param userName the user name of this business entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this business entry.
	 *
	 * @return the create date of this business entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this business entry.
	 *
	 * @param createDate the create date of this business entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this business entry.
	 *
	 * @return the modified date of this business entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this business entry.
	 *
	 * @param modifiedDate the modified date of this business entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the creator ID of this business entry.
	 *
	 * @return the creator ID of this business entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this business entry.
	 *
	 * @param creatorId the creator ID of this business entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the customer ID of this business entry.
	 *
	 * @return the customer ID of this business entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this business entry.
	 *
	 * @param customerId the customer ID of this business entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the name of this business entry.
	 *
	 * @return the name of this business entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this business entry.
	 *
	 * @param name the name of this business entry
	 */
	public void setName(String name);

	@Override
	public BusinessEntry cloneWithOriginalValues();

}