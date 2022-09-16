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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PhoneEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhoneEntry
 * @generated
 */
public class PhoneEntryWrapper
	extends BaseModelWrapper<PhoneEntry>
	implements ModelWrapper<PhoneEntry>, PhoneEntry {

	public PhoneEntryWrapper(PhoneEntry phoneEntry) {
		super(phoneEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("phoneId", getPhoneId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("customerId", getCustomerId());
		attributes.put("contactId", getContactId());
		attributes.put("number", getNumber());
		attributes.put("isDefaulted", isIsDefaulted());
		attributes.put("description", getDescription());

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

		Long phoneId = (Long)attributes.get("phoneId");

		if (phoneId != null) {
			setPhoneId(phoneId);
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

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Boolean isDefaulted = (Boolean)attributes.get("isDefaulted");

		if (isDefaulted != null) {
			setIsDefaulted(isDefaulted);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public PhoneEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this phone entry.
	 *
	 * @return the company ID of this phone entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact ID of this phone entry.
	 *
	 * @return the contact ID of this phone entry
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the create date of this phone entry.
	 *
	 * @return the create date of this phone entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this phone entry.
	 *
	 * @return the creator ID of this phone entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this phone entry.
	 *
	 * @return the customer ID of this phone entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the description of this phone entry.
	 *
	 * @return the description of this phone entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external reference code of this phone entry.
	 *
	 * @return the external reference code of this phone entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this phone entry.
	 *
	 * @return the group ID of this phone entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is defaulted of this phone entry.
	 *
	 * @return the is defaulted of this phone entry
	 */
	@Override
	public boolean getIsDefaulted() {
		return model.getIsDefaulted();
	}

	/**
	 * Returns the modified date of this phone entry.
	 *
	 * @return the modified date of this phone entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the number of this phone entry.
	 *
	 * @return the number of this phone entry
	 */
	@Override
	public String getNumber() {
		return model.getNumber();
	}

	/**
	 * Returns the phone ID of this phone entry.
	 *
	 * @return the phone ID of this phone entry
	 */
	@Override
	public long getPhoneId() {
		return model.getPhoneId();
	}

	/**
	 * Returns the primary key of this phone entry.
	 *
	 * @return the primary key of this phone entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this phone entry.
	 *
	 * @return the user ID of this phone entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this phone entry.
	 *
	 * @return the user name of this phone entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this phone entry.
	 *
	 * @return the user uuid of this phone entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this phone entry.
	 *
	 * @return the uuid of this phone entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this phone entry is is defaulted.
	 *
	 * @return <code>true</code> if this phone entry is is defaulted; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDefaulted() {
		return model.isIsDefaulted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this phone entry.
	 *
	 * @param companyId the company ID of this phone entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact ID of this phone entry.
	 *
	 * @param contactId the contact ID of this phone entry
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the create date of this phone entry.
	 *
	 * @param createDate the create date of this phone entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this phone entry.
	 *
	 * @param creatorId the creator ID of this phone entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this phone entry.
	 *
	 * @param customerId the customer ID of this phone entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the description of this phone entry.
	 *
	 * @param description the description of this phone entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external reference code of this phone entry.
	 *
	 * @param externalReferenceCode the external reference code of this phone entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this phone entry.
	 *
	 * @param groupId the group ID of this phone entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this phone entry is is defaulted.
	 *
	 * @param isDefaulted the is defaulted of this phone entry
	 */
	@Override
	public void setIsDefaulted(boolean isDefaulted) {
		model.setIsDefaulted(isDefaulted);
	}

	/**
	 * Sets the modified date of this phone entry.
	 *
	 * @param modifiedDate the modified date of this phone entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the number of this phone entry.
	 *
	 * @param number the number of this phone entry
	 */
	@Override
	public void setNumber(String number) {
		model.setNumber(number);
	}

	/**
	 * Sets the phone ID of this phone entry.
	 *
	 * @param phoneId the phone ID of this phone entry
	 */
	@Override
	public void setPhoneId(long phoneId) {
		model.setPhoneId(phoneId);
	}

	/**
	 * Sets the primary key of this phone entry.
	 *
	 * @param primaryKey the primary key of this phone entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this phone entry.
	 *
	 * @param userId the user ID of this phone entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this phone entry.
	 *
	 * @param userName the user name of this phone entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this phone entry.
	 *
	 * @param userUuid the user uuid of this phone entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this phone entry.
	 *
	 * @param uuid the uuid of this phone entry
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
	protected PhoneEntryWrapper wrap(PhoneEntry phoneEntry) {
		return new PhoneEntryWrapper(phoneEntry);
	}

}