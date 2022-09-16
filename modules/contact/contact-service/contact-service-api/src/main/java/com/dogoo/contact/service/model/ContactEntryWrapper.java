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
 * This class is a wrapper for {@link ContactEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactEntry
 * @generated
 */
public class ContactEntryWrapper
	extends BaseModelWrapper<ContactEntry>
	implements ContactEntry, ModelWrapper<ContactEntry> {

	public ContactEntryWrapper(ContactEntry contactEntry) {
		super(contactEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("customerId", getCustomerId());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());
		attributes.put("linkedin", getLinkedin());

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

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
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

		String facebook = (String)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}

		String linkedin = (String)attributes.get("linkedin");

		if (linkedin != null) {
			setLinkedin(linkedin);
		}
	}

	@Override
	public ContactEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this contact entry.
	 *
	 * @return the company ID of this contact entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact ID of this contact entry.
	 *
	 * @return the contact ID of this contact entry
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the create date of this contact entry.
	 *
	 * @return the create date of this contact entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this contact entry.
	 *
	 * @return the creator ID of this contact entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this contact entry.
	 *
	 * @return the customer ID of this contact entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the external reference code of this contact entry.
	 *
	 * @return the external reference code of this contact entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the facebook of this contact entry.
	 *
	 * @return the facebook of this contact entry
	 */
	@Override
	public String getFacebook() {
		return model.getFacebook();
	}

	/**
	 * Returns the group ID of this contact entry.
	 *
	 * @return the group ID of this contact entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the linkedin of this contact entry.
	 *
	 * @return the linkedin of this contact entry
	 */
	@Override
	public String getLinkedin() {
		return model.getLinkedin();
	}

	/**
	 * Returns the modified date of this contact entry.
	 *
	 * @return the modified date of this contact entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this contact entry.
	 *
	 * @return the primary key of this contact entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the twitter of this contact entry.
	 *
	 * @return the twitter of this contact entry
	 */
	@Override
	public String getTwitter() {
		return model.getTwitter();
	}

	/**
	 * Returns the user ID of this contact entry.
	 *
	 * @return the user ID of this contact entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this contact entry.
	 *
	 * @return the user name of this contact entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this contact entry.
	 *
	 * @return the user uuid of this contact entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this contact entry.
	 *
	 * @return the uuid of this contact entry
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
	 * Sets the company ID of this contact entry.
	 *
	 * @param companyId the company ID of this contact entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact ID of this contact entry.
	 *
	 * @param contactId the contact ID of this contact entry
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the create date of this contact entry.
	 *
	 * @param createDate the create date of this contact entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this contact entry.
	 *
	 * @param creatorId the creator ID of this contact entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this contact entry.
	 *
	 * @param customerId the customer ID of this contact entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the external reference code of this contact entry.
	 *
	 * @param externalReferenceCode the external reference code of this contact entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the facebook of this contact entry.
	 *
	 * @param facebook the facebook of this contact entry
	 */
	@Override
	public void setFacebook(String facebook) {
		model.setFacebook(facebook);
	}

	/**
	 * Sets the group ID of this contact entry.
	 *
	 * @param groupId the group ID of this contact entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the linkedin of this contact entry.
	 *
	 * @param linkedin the linkedin of this contact entry
	 */
	@Override
	public void setLinkedin(String linkedin) {
		model.setLinkedin(linkedin);
	}

	/**
	 * Sets the modified date of this contact entry.
	 *
	 * @param modifiedDate the modified date of this contact entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this contact entry.
	 *
	 * @param primaryKey the primary key of this contact entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the twitter of this contact entry.
	 *
	 * @param twitter the twitter of this contact entry
	 */
	@Override
	public void setTwitter(String twitter) {
		model.setTwitter(twitter);
	}

	/**
	 * Sets the user ID of this contact entry.
	 *
	 * @param userId the user ID of this contact entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this contact entry.
	 *
	 * @param userName the user name of this contact entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this contact entry.
	 *
	 * @param userUuid the user uuid of this contact entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this contact entry.
	 *
	 * @param uuid the uuid of this contact entry
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
	protected ContactEntryWrapper wrap(ContactEntry contactEntry) {
		return new ContactEntryWrapper(contactEntry);
	}

}