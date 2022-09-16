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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BusinessEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntry
 * @generated
 */
public class BusinessEntryWrapper
	extends BaseModelWrapper<BusinessEntry>
	implements BusinessEntry, ModelWrapper<BusinessEntry> {

	public BusinessEntryWrapper(BusinessEntry businessEntry) {
		super(businessEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("businessId", getBusinessId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("customerId", getCustomerId());
		attributes.put("name", getName());

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

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
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

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public BusinessEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the business ID of this business entry.
	 *
	 * @return the business ID of this business entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the company ID of this business entry.
	 *
	 * @return the company ID of this business entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this business entry.
	 *
	 * @return the create date of this business entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this business entry.
	 *
	 * @return the creator ID of this business entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this business entry.
	 *
	 * @return the customer ID of this business entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the external reference code of this business entry.
	 *
	 * @return the external reference code of this business entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this business entry.
	 *
	 * @return the group ID of this business entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this business entry.
	 *
	 * @return the modified date of this business entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this business entry.
	 *
	 * @return the name of this business entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this business entry.
	 *
	 * @return the primary key of this business entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this business entry.
	 *
	 * @return the user ID of this business entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this business entry.
	 *
	 * @return the user name of this business entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this business entry.
	 *
	 * @return the user uuid of this business entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this business entry.
	 *
	 * @return the uuid of this business entry
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
	 * Sets the business ID of this business entry.
	 *
	 * @param businessId the business ID of this business entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the company ID of this business entry.
	 *
	 * @param companyId the company ID of this business entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this business entry.
	 *
	 * @param createDate the create date of this business entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this business entry.
	 *
	 * @param creatorId the creator ID of this business entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this business entry.
	 *
	 * @param customerId the customer ID of this business entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the external reference code of this business entry.
	 *
	 * @param externalReferenceCode the external reference code of this business entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this business entry.
	 *
	 * @param groupId the group ID of this business entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this business entry.
	 *
	 * @param modifiedDate the modified date of this business entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this business entry.
	 *
	 * @param name the name of this business entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this business entry.
	 *
	 * @param primaryKey the primary key of this business entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this business entry.
	 *
	 * @param userId the user ID of this business entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this business entry.
	 *
	 * @param userName the user name of this business entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this business entry.
	 *
	 * @param userUuid the user uuid of this business entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this business entry.
	 *
	 * @param uuid the uuid of this business entry
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
	protected BusinessEntryWrapper wrap(BusinessEntry businessEntry) {
		return new BusinessEntryWrapper(businessEntry);
	}

}