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

package com.dogoo.contact.service.model.impl;

import com.dogoo.contact.service.model.EmailEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmailEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmailEntryCacheModel
	implements CacheModel<EmailEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmailEntryCacheModel)) {
			return false;
		}

		EmailEntryCacheModel emailEntryCacheModel =
			(EmailEntryCacheModel)object;

		if (emailId == emailEntryCacheModel.emailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, emailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", emailId=");
		sb.append(emailId);
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
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", isDefaulted=");
		sb.append(isDefaulted);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmailEntry toEntityModel() {
		EmailEntryImpl emailEntryImpl = new EmailEntryImpl();

		if (uuid == null) {
			emailEntryImpl.setUuid("");
		}
		else {
			emailEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			emailEntryImpl.setExternalReferenceCode("");
		}
		else {
			emailEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		emailEntryImpl.setEmailId(emailId);
		emailEntryImpl.setGroupId(groupId);
		emailEntryImpl.setCompanyId(companyId);
		emailEntryImpl.setUserId(userId);

		if (userName == null) {
			emailEntryImpl.setUserName("");
		}
		else {
			emailEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			emailEntryImpl.setCreateDate(null);
		}
		else {
			emailEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			emailEntryImpl.setModifiedDate(null);
		}
		else {
			emailEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		emailEntryImpl.setCreatorId(creatorId);
		emailEntryImpl.setCustomerId(customerId);
		emailEntryImpl.setContactId(contactId);

		if (emailAddress == null) {
			emailEntryImpl.setEmailAddress("");
		}
		else {
			emailEntryImpl.setEmailAddress(emailAddress);
		}

		emailEntryImpl.setIsDefaulted(isDefaulted);

		if (description == null) {
			emailEntryImpl.setDescription("");
		}
		else {
			emailEntryImpl.setDescription(description);
		}

		emailEntryImpl.resetOriginalValues();

		return emailEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		emailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		customerId = objectInput.readLong();

		contactId = objectInput.readLong();
		emailAddress = objectInput.readUTF();

		isDefaulted = objectInput.readBoolean();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(emailId);

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
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(creatorId);

		objectOutput.writeLong(customerId);

		objectOutput.writeLong(contactId);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeBoolean(isDefaulted);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long emailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long customerId;
	public long contactId;
	public String emailAddress;
	public boolean isDefaulted;
	public String description;

}