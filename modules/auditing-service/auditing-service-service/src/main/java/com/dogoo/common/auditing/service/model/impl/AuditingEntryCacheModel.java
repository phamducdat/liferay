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

package com.dogoo.common.auditing.service.model.impl;

import com.dogoo.common.auditing.service.model.AuditingEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuditingEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditingEntryCacheModel
	implements CacheModel<AuditingEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuditingEntryCacheModel)) {
			return false;
		}

		AuditingEntryCacheModel auditingEntryCacheModel =
			(AuditingEntryCacheModel)object;

		if (auditingId == auditingEntryCacheModel.auditingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", auditingId=");
		sb.append(auditingId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", creatorName=");
		sb.append(creatorName);
		sb.append(", name=");
		sb.append(name);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", message=");
		sb.append(message);
		sb.append(", payload=");
		sb.append(payload);
		sb.append(", classPkId=");
		sb.append(classPkId);
		sb.append(", classPkName=");
		sb.append(classPkName);
		sb.append(", parentPkId=");
		sb.append(parentPkId);
		sb.append(", parentPkName=");
		sb.append(parentPkName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuditingEntry toEntityModel() {
		AuditingEntryImpl auditingEntryImpl = new AuditingEntryImpl();

		if (uuid == null) {
			auditingEntryImpl.setUuid("");
		}
		else {
			auditingEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			auditingEntryImpl.setExternalReferenceCode("");
		}
		else {
			auditingEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		auditingEntryImpl.setAuditingId(auditingId);
		auditingEntryImpl.setGroupId(groupId);
		auditingEntryImpl.setCompanyId(companyId);
		auditingEntryImpl.setUserId(userId);

		if (userName == null) {
			auditingEntryImpl.setUserName("");
		}
		else {
			auditingEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			auditingEntryImpl.setCreateDate(null);
		}
		else {
			auditingEntryImpl.setCreateDate(new Date(createDate));
		}

		auditingEntryImpl.setCustomerId(customerId);
		auditingEntryImpl.setCreatorId(creatorId);

		if (creatorName == null) {
			auditingEntryImpl.setCreatorName("");
		}
		else {
			auditingEntryImpl.setCreatorName(creatorName);
		}

		if (name == null) {
			auditingEntryImpl.setName("");
		}
		else {
			auditingEntryImpl.setName(name);
		}

		if (eventType == null) {
			auditingEntryImpl.setEventType("");
		}
		else {
			auditingEntryImpl.setEventType(eventType);
		}

		if (message == null) {
			auditingEntryImpl.setMessage("");
		}
		else {
			auditingEntryImpl.setMessage(message);
		}

		if (payload == null) {
			auditingEntryImpl.setPayload("");
		}
		else {
			auditingEntryImpl.setPayload(payload);
		}

		auditingEntryImpl.setClassPkId(classPkId);

		if (classPkName == null) {
			auditingEntryImpl.setClassPkName("");
		}
		else {
			auditingEntryImpl.setClassPkName(classPkName);
		}

		auditingEntryImpl.setParentPkId(parentPkId);

		if (parentPkName == null) {
			auditingEntryImpl.setParentPkName("");
		}
		else {
			auditingEntryImpl.setParentPkName(parentPkName);
		}

		auditingEntryImpl.resetOriginalValues();

		return auditingEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		auditingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();
		creatorName = objectInput.readUTF();
		name = objectInput.readUTF();
		eventType = objectInput.readUTF();
		message = objectInput.readUTF();
		payload = objectInput.readUTF();

		classPkId = objectInput.readLong();
		classPkName = objectInput.readUTF();

		parentPkId = objectInput.readLong();
		parentPkName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (externalReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceCode);
		}

		objectOutput.writeLong(auditingId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(customerId);

		objectOutput.writeLong(creatorId);

		if (creatorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(creatorName);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (payload == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(payload);
		}

		objectOutput.writeLong(classPkId);

		if (classPkName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classPkName);
		}

		objectOutput.writeLong(parentPkId);

		if (parentPkName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentPkName);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long auditingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long customerId;
	public long creatorId;
	public String creatorName;
	public String name;
	public String eventType;
	public String message;
	public String payload;
	public long classPkId;
	public String classPkName;
	public long parentPkId;
	public String parentPkName;

}