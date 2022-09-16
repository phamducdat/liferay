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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmoticonEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmoticonEntry
 * @generated
 */
public class EmoticonEntryWrapper
	extends BaseModelWrapper<EmoticonEntry>
	implements EmoticonEntry, ModelWrapper<EmoticonEntry> {

	public EmoticonEntryWrapper(EmoticonEntry emoticonEntry) {
		super(emoticonEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("emoticonId", getEmoticonId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("classPkId", getClassPkId());
		attributes.put("classPkName", getClassPkName());
		attributes.put("creatorFullName", getCreatorFullName());
		attributes.put("emoji", getEmoji());

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

		Long emoticonId = (Long)attributes.get("emoticonId");

		if (emoticonId != null) {
			setEmoticonId(emoticonId);
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

		Long classPkId = (Long)attributes.get("classPkId");

		if (classPkId != null) {
			setClassPkId(classPkId);
		}

		String classPkName = (String)attributes.get("classPkName");

		if (classPkName != null) {
			setClassPkName(classPkName);
		}

		String creatorFullName = (String)attributes.get("creatorFullName");

		if (creatorFullName != null) {
			setCreatorFullName(creatorFullName);
		}

		String emoji = (String)attributes.get("emoji");

		if (emoji != null) {
			setEmoji(emoji);
		}
	}

	@Override
	public EmoticonEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the class pk ID of this emoticon entry.
	 *
	 * @return the class pk ID of this emoticon entry
	 */
	@Override
	public long getClassPkId() {
		return model.getClassPkId();
	}

	/**
	 * Returns the class pk name of this emoticon entry.
	 *
	 * @return the class pk name of this emoticon entry
	 */
	@Override
	public String getClassPkName() {
		return model.getClassPkName();
	}

	/**
	 * Returns the company ID of this emoticon entry.
	 *
	 * @return the company ID of this emoticon entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this emoticon entry.
	 *
	 * @return the create date of this emoticon entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator full name of this emoticon entry.
	 *
	 * @return the creator full name of this emoticon entry
	 */
	@Override
	public String getCreatorFullName() {
		return model.getCreatorFullName();
	}

	/**
	 * Returns the creator ID of this emoticon entry.
	 *
	 * @return the creator ID of this emoticon entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this emoticon entry.
	 *
	 * @return the customer ID of this emoticon entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the emoji of this emoticon entry.
	 *
	 * @return the emoji of this emoticon entry
	 */
	@Override
	public String getEmoji() {
		return model.getEmoji();
	}

	/**
	 * Returns the emoticon ID of this emoticon entry.
	 *
	 * @return the emoticon ID of this emoticon entry
	 */
	@Override
	public long getEmoticonId() {
		return model.getEmoticonId();
	}

	/**
	 * Returns the external reference code of this emoticon entry.
	 *
	 * @return the external reference code of this emoticon entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this emoticon entry.
	 *
	 * @return the group ID of this emoticon entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this emoticon entry.
	 *
	 * @return the modified date of this emoticon entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this emoticon entry.
	 *
	 * @return the primary key of this emoticon entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this emoticon entry.
	 *
	 * @return the user ID of this emoticon entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this emoticon entry.
	 *
	 * @return the user name of this emoticon entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this emoticon entry.
	 *
	 * @return the user uuid of this emoticon entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this emoticon entry.
	 *
	 * @return the uuid of this emoticon entry
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
	 * Sets the class pk ID of this emoticon entry.
	 *
	 * @param classPkId the class pk ID of this emoticon entry
	 */
	@Override
	public void setClassPkId(long classPkId) {
		model.setClassPkId(classPkId);
	}

	/**
	 * Sets the class pk name of this emoticon entry.
	 *
	 * @param classPkName the class pk name of this emoticon entry
	 */
	@Override
	public void setClassPkName(String classPkName) {
		model.setClassPkName(classPkName);
	}

	/**
	 * Sets the company ID of this emoticon entry.
	 *
	 * @param companyId the company ID of this emoticon entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this emoticon entry.
	 *
	 * @param createDate the create date of this emoticon entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator full name of this emoticon entry.
	 *
	 * @param creatorFullName the creator full name of this emoticon entry
	 */
	@Override
	public void setCreatorFullName(String creatorFullName) {
		model.setCreatorFullName(creatorFullName);
	}

	/**
	 * Sets the creator ID of this emoticon entry.
	 *
	 * @param creatorId the creator ID of this emoticon entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this emoticon entry.
	 *
	 * @param customerId the customer ID of this emoticon entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the emoji of this emoticon entry.
	 *
	 * @param emoji the emoji of this emoticon entry
	 */
	@Override
	public void setEmoji(String emoji) {
		model.setEmoji(emoji);
	}

	/**
	 * Sets the emoticon ID of this emoticon entry.
	 *
	 * @param emoticonId the emoticon ID of this emoticon entry
	 */
	@Override
	public void setEmoticonId(long emoticonId) {
		model.setEmoticonId(emoticonId);
	}

	/**
	 * Sets the external reference code of this emoticon entry.
	 *
	 * @param externalReferenceCode the external reference code of this emoticon entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this emoticon entry.
	 *
	 * @param groupId the group ID of this emoticon entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this emoticon entry.
	 *
	 * @param modifiedDate the modified date of this emoticon entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this emoticon entry.
	 *
	 * @param primaryKey the primary key of this emoticon entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this emoticon entry.
	 *
	 * @param userId the user ID of this emoticon entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this emoticon entry.
	 *
	 * @param userName the user name of this emoticon entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this emoticon entry.
	 *
	 * @param userUuid the user uuid of this emoticon entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this emoticon entry.
	 *
	 * @param uuid the uuid of this emoticon entry
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
	protected EmoticonEntryWrapper wrap(EmoticonEntry emoticonEntry) {
		return new EmoticonEntryWrapper(emoticonEntry);
	}

}