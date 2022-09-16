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

import com.dogoo.contact.service.model.ContactEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactEntryCacheModel
	implements CacheModel<ContactEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContactEntryCacheModel)) {
			return false;
		}

		ContactEntryCacheModel contactEntryCacheModel =
			(ContactEntryCacheModel)object;

		if (contactId == contactEntryCacheModel.contactId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contactId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", contactId=");
		sb.append(contactId);
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
		sb.append(", facebook=");
		sb.append(facebook);
		sb.append(", twitter=");
		sb.append(twitter);
		sb.append(", linkedin=");
		sb.append(linkedin);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactEntry toEntityModel() {
		ContactEntryImpl contactEntryImpl = new ContactEntryImpl();

		if (uuid == null) {
			contactEntryImpl.setUuid("");
		}
		else {
			contactEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			contactEntryImpl.setExternalReferenceCode("");
		}
		else {
			contactEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		contactEntryImpl.setContactId(contactId);
		contactEntryImpl.setGroupId(groupId);
		contactEntryImpl.setCompanyId(companyId);
		contactEntryImpl.setUserId(userId);

		if (userName == null) {
			contactEntryImpl.setUserName("");
		}
		else {
			contactEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactEntryImpl.setCreateDate(null);
		}
		else {
			contactEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactEntryImpl.setModifiedDate(null);
		}
		else {
			contactEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		contactEntryImpl.setCreatorId(creatorId);
		contactEntryImpl.setCustomerId(customerId);

		if (facebook == null) {
			contactEntryImpl.setFacebook("");
		}
		else {
			contactEntryImpl.setFacebook(facebook);
		}

		if (twitter == null) {
			contactEntryImpl.setTwitter("");
		}
		else {
			contactEntryImpl.setTwitter(twitter);
		}

		if (linkedin == null) {
			contactEntryImpl.setLinkedin("");
		}
		else {
			contactEntryImpl.setLinkedin(linkedin);
		}

		contactEntryImpl.resetOriginalValues();

		return contactEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		contactId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		customerId = objectInput.readLong();
		facebook = objectInput.readUTF();
		twitter = objectInput.readUTF();
		linkedin = objectInput.readUTF();
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

		objectOutput.writeLong(contactId);

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

		if (facebook == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facebook);
		}

		if (twitter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(twitter);
		}

		if (linkedin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkedin);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long contactId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long customerId;
	public String facebook;
	public String twitter;
	public String linkedin;

}