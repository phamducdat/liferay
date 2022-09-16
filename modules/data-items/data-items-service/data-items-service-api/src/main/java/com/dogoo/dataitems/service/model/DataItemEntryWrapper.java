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

package com.dogoo.dataitems.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataItemEntry}.
 * </p>
 *
 * @author nghiatt
 * @see DataItemEntry
 * @generated
 */
public class DataItemEntryWrapper
	extends BaseModelWrapper<DataItemEntry>
	implements DataItemEntry, ModelWrapper<DataItemEntry> {

	public DataItemEntryWrapper(DataItemEntry dataItemEntry) {
		super(dataItemEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("dataItemId", getDataItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("customerId", getCustomerId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("order_", getOrder_());
		attributes.put("type", getType());
		attributes.put("parentId", getParentId());
		attributes.put("isDefaultValue", isIsDefaultValue());

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

		Long dataItemId = (Long)attributes.get("dataItemId");

		if (dataItemId != null) {
			setDataItemId(dataItemId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long order_ = (Long)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Boolean isDefaultValue = (Boolean)attributes.get("isDefaultValue");

		if (isDefaultValue != null) {
			setIsDefaultValue(isDefaultValue);
		}
	}

	@Override
	public DataItemEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this data item entry.
	 *
	 * @return the company ID of this data item entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this data item entry.
	 *
	 * @return the create date of this data item entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this data item entry.
	 *
	 * @return the creator ID of this data item entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this data item entry.
	 *
	 * @return the customer ID of this data item entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the data item ID of this data item entry.
	 *
	 * @return the data item ID of this data item entry
	 */
	@Override
	public long getDataItemId() {
		return model.getDataItemId();
	}

	/**
	 * Returns the description of this data item entry.
	 *
	 * @return the description of this data item entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external reference code of this data item entry.
	 *
	 * @return the external reference code of this data item entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this data item entry.
	 *
	 * @return the group ID of this data item entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is default value of this data item entry.
	 *
	 * @return the is default value of this data item entry
	 */
	@Override
	public boolean getIsDefaultValue() {
		return model.getIsDefaultValue();
	}

	/**
	 * Returns the modified date of this data item entry.
	 *
	 * @return the modified date of this data item entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this data item entry.
	 *
	 * @return the name of this data item entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the order_ of this data item entry.
	 *
	 * @return the order_ of this data item entry
	 */
	@Override
	public long getOrder_() {
		return model.getOrder_();
	}

	/**
	 * Returns the parent ID of this data item entry.
	 *
	 * @return the parent ID of this data item entry
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this data item entry.
	 *
	 * @return the primary key of this data item entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this data item entry.
	 *
	 * @return the type of this data item entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this data item entry.
	 *
	 * @return the user ID of this data item entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data item entry.
	 *
	 * @return the user name of this data item entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data item entry.
	 *
	 * @return the user uuid of this data item entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data item entry.
	 *
	 * @return the uuid of this data item entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this data item entry is is default value.
	 *
	 * @return <code>true</code> if this data item entry is is default value; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDefaultValue() {
		return model.isIsDefaultValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this data item entry.
	 *
	 * @param companyId the company ID of this data item entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this data item entry.
	 *
	 * @param createDate the create date of this data item entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this data item entry.
	 *
	 * @param creatorId the creator ID of this data item entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this data item entry.
	 *
	 * @param customerId the customer ID of this data item entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the data item ID of this data item entry.
	 *
	 * @param dataItemId the data item ID of this data item entry
	 */
	@Override
	public void setDataItemId(long dataItemId) {
		model.setDataItemId(dataItemId);
	}

	/**
	 * Sets the description of this data item entry.
	 *
	 * @param description the description of this data item entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external reference code of this data item entry.
	 *
	 * @param externalReferenceCode the external reference code of this data item entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this data item entry.
	 *
	 * @param groupId the group ID of this data item entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this data item entry is is default value.
	 *
	 * @param isDefaultValue the is default value of this data item entry
	 */
	@Override
	public void setIsDefaultValue(boolean isDefaultValue) {
		model.setIsDefaultValue(isDefaultValue);
	}

	/**
	 * Sets the modified date of this data item entry.
	 *
	 * @param modifiedDate the modified date of this data item entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this data item entry.
	 *
	 * @param name the name of this data item entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the order_ of this data item entry.
	 *
	 * @param order_ the order_ of this data item entry
	 */
	@Override
	public void setOrder_(long order_) {
		model.setOrder_(order_);
	}

	/**
	 * Sets the parent ID of this data item entry.
	 *
	 * @param parentId the parent ID of this data item entry
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this data item entry.
	 *
	 * @param primaryKey the primary key of this data item entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this data item entry.
	 *
	 * @param type the type of this data item entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this data item entry.
	 *
	 * @param userId the user ID of this data item entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data item entry.
	 *
	 * @param userName the user name of this data item entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data item entry.
	 *
	 * @param userUuid the user uuid of this data item entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data item entry.
	 *
	 * @param uuid the uuid of this data item entry
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
	protected DataItemEntryWrapper wrap(DataItemEntry dataItemEntry) {
		return new DataItemEntryWrapper(dataItemEntry);
	}

}