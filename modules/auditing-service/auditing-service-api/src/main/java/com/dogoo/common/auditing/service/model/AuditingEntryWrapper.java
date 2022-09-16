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

package com.dogoo.common.auditing.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditingEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditingEntry
 * @generated
 */
public class AuditingEntryWrapper
	extends BaseModelWrapper<AuditingEntry>
	implements AuditingEntry, ModelWrapper<AuditingEntry> {

	public AuditingEntryWrapper(AuditingEntry auditingEntry) {
		super(auditingEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("auditingId", getAuditingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("creatorName", getCreatorName());
		attributes.put("name", getName());
		attributes.put("eventType", getEventType());
		attributes.put("message", getMessage());
		attributes.put("payload", getPayload());
		attributes.put("classPkId", getClassPkId());
		attributes.put("classPkName", getClassPkName());
		attributes.put("parentPkId", getParentPkId());
		attributes.put("parentPkName", getParentPkName());

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

		Long auditingId = (Long)attributes.get("auditingId");

		if (auditingId != null) {
			setAuditingId(auditingId);
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

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		String creatorName = (String)attributes.get("creatorName");

		if (creatorName != null) {
			setCreatorName(creatorName);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String payload = (String)attributes.get("payload");

		if (payload != null) {
			setPayload(payload);
		}

		Long classPkId = (Long)attributes.get("classPkId");

		if (classPkId != null) {
			setClassPkId(classPkId);
		}

		String classPkName = (String)attributes.get("classPkName");

		if (classPkName != null) {
			setClassPkName(classPkName);
		}

		Long parentPkId = (Long)attributes.get("parentPkId");

		if (parentPkId != null) {
			setParentPkId(parentPkId);
		}

		String parentPkName = (String)attributes.get("parentPkName");

		if (parentPkName != null) {
			setParentPkName(parentPkName);
		}
	}

	@Override
	public AuditingEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the auditing ID of this auditing entry.
	 *
	 * @return the auditing ID of this auditing entry
	 */
	@Override
	public long getAuditingId() {
		return model.getAuditingId();
	}

	/**
	 * Returns the class pk ID of this auditing entry.
	 *
	 * @return the class pk ID of this auditing entry
	 */
	@Override
	public long getClassPkId() {
		return model.getClassPkId();
	}

	/**
	 * Returns the class pk name of this auditing entry.
	 *
	 * @return the class pk name of this auditing entry
	 */
	@Override
	public String getClassPkName() {
		return model.getClassPkName();
	}

	/**
	 * Returns the company ID of this auditing entry.
	 *
	 * @return the company ID of this auditing entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this auditing entry.
	 *
	 * @return the create date of this auditing entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this auditing entry.
	 *
	 * @return the creator ID of this auditing entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the creator name of this auditing entry.
	 *
	 * @return the creator name of this auditing entry
	 */
	@Override
	public String getCreatorName() {
		return model.getCreatorName();
	}

	/**
	 * Returns the customer ID of this auditing entry.
	 *
	 * @return the customer ID of this auditing entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the event type of this auditing entry.
	 *
	 * @return the event type of this auditing entry
	 */
	@Override
	public String getEventType() {
		return model.getEventType();
	}

	/**
	 * Returns the external reference code of this auditing entry.
	 *
	 * @return the external reference code of this auditing entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this auditing entry.
	 *
	 * @return the group ID of this auditing entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the message of this auditing entry.
	 *
	 * @return the message of this auditing entry
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the name of this auditing entry.
	 *
	 * @return the name of this auditing entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent pk ID of this auditing entry.
	 *
	 * @return the parent pk ID of this auditing entry
	 */
	@Override
	public Long getParentPkId() {
		return model.getParentPkId();
	}

	/**
	 * Returns the parent pk name of this auditing entry.
	 *
	 * @return the parent pk name of this auditing entry
	 */
	@Override
	public String getParentPkName() {
		return model.getParentPkName();
	}

	/**
	 * Returns the payload of this auditing entry.
	 *
	 * @return the payload of this auditing entry
	 */
	@Override
	public String getPayload() {
		return model.getPayload();
	}

	/**
	 * Returns the primary key of this auditing entry.
	 *
	 * @return the primary key of this auditing entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this auditing entry.
	 *
	 * @return the user ID of this auditing entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this auditing entry.
	 *
	 * @return the user name of this auditing entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this auditing entry.
	 *
	 * @return the user uuid of this auditing entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this auditing entry.
	 *
	 * @return the uuid of this auditing entry
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
	 * Sets the auditing ID of this auditing entry.
	 *
	 * @param auditingId the auditing ID of this auditing entry
	 */
	@Override
	public void setAuditingId(long auditingId) {
		model.setAuditingId(auditingId);
	}

	/**
	 * Sets the class pk ID of this auditing entry.
	 *
	 * @param classPkId the class pk ID of this auditing entry
	 */
	@Override
	public void setClassPkId(long classPkId) {
		model.setClassPkId(classPkId);
	}

	/**
	 * Sets the class pk name of this auditing entry.
	 *
	 * @param classPkName the class pk name of this auditing entry
	 */
	@Override
	public void setClassPkName(String classPkName) {
		model.setClassPkName(classPkName);
	}

	/**
	 * Sets the company ID of this auditing entry.
	 *
	 * @param companyId the company ID of this auditing entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this auditing entry.
	 *
	 * @param createDate the create date of this auditing entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this auditing entry.
	 *
	 * @param creatorId the creator ID of this auditing entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the creator name of this auditing entry.
	 *
	 * @param creatorName the creator name of this auditing entry
	 */
	@Override
	public void setCreatorName(String creatorName) {
		model.setCreatorName(creatorName);
	}

	/**
	 * Sets the customer ID of this auditing entry.
	 *
	 * @param customerId the customer ID of this auditing entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the event type of this auditing entry.
	 *
	 * @param eventType the event type of this auditing entry
	 */
	@Override
	public void setEventType(String eventType) {
		model.setEventType(eventType);
	}

	/**
	 * Sets the external reference code of this auditing entry.
	 *
	 * @param externalReferenceCode the external reference code of this auditing entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this auditing entry.
	 *
	 * @param groupId the group ID of this auditing entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the message of this auditing entry.
	 *
	 * @param message the message of this auditing entry
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the name of this auditing entry.
	 *
	 * @param name the name of this auditing entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent pk ID of this auditing entry.
	 *
	 * @param parentPkId the parent pk ID of this auditing entry
	 */
	@Override
	public void setParentPkId(Long parentPkId) {
		model.setParentPkId(parentPkId);
	}

	/**
	 * Sets the parent pk name of this auditing entry.
	 *
	 * @param parentPkName the parent pk name of this auditing entry
	 */
	@Override
	public void setParentPkName(String parentPkName) {
		model.setParentPkName(parentPkName);
	}

	/**
	 * Sets the payload of this auditing entry.
	 *
	 * @param payload the payload of this auditing entry
	 */
	@Override
	public void setPayload(String payload) {
		model.setPayload(payload);
	}

	/**
	 * Sets the primary key of this auditing entry.
	 *
	 * @param primaryKey the primary key of this auditing entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this auditing entry.
	 *
	 * @param userId the user ID of this auditing entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this auditing entry.
	 *
	 * @param userName the user name of this auditing entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this auditing entry.
	 *
	 * @param userUuid the user uuid of this auditing entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this auditing entry.
	 *
	 * @param uuid the uuid of this auditing entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected AuditingEntryWrapper wrap(AuditingEntry auditingEntry) {
		return new AuditingEntryWrapper(auditingEntry);
	}

}