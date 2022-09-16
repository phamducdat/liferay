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

package com.dogoo.common.comment.service.model.impl;

import com.dogoo.common.comment.service.model.EmoticonEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmoticonEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmoticonEntryCacheModel
	implements CacheModel<EmoticonEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmoticonEntryCacheModel)) {
			return false;
		}

		EmoticonEntryCacheModel emoticonEntryCacheModel =
			(EmoticonEntryCacheModel)object;

		if (emoticonId == emoticonEntryCacheModel.emoticonId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, emoticonId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", emoticonId=");
		sb.append(emoticonId);
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
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", classPkId=");
		sb.append(classPkId);
		sb.append(", classPkName=");
		sb.append(classPkName);
		sb.append(", creatorFullName=");
		sb.append(creatorFullName);
		sb.append(", emoji=");
		sb.append(emoji);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmoticonEntry toEntityModel() {
		EmoticonEntryImpl emoticonEntryImpl = new EmoticonEntryImpl();

		if (uuid == null) {
			emoticonEntryImpl.setUuid("");
		}
		else {
			emoticonEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			emoticonEntryImpl.setExternalReferenceCode("");
		}
		else {
			emoticonEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		emoticonEntryImpl.setEmoticonId(emoticonId);
		emoticonEntryImpl.setGroupId(groupId);
		emoticonEntryImpl.setCompanyId(companyId);
		emoticonEntryImpl.setUserId(userId);

		if (userName == null) {
			emoticonEntryImpl.setUserName("");
		}
		else {
			emoticonEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			emoticonEntryImpl.setCreateDate(null);
		}
		else {
			emoticonEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			emoticonEntryImpl.setModifiedDate(null);
		}
		else {
			emoticonEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		emoticonEntryImpl.setCustomerId(customerId);
		emoticonEntryImpl.setCreatorId(creatorId);
		emoticonEntryImpl.setClassPkId(classPkId);

		if (classPkName == null) {
			emoticonEntryImpl.setClassPkName("");
		}
		else {
			emoticonEntryImpl.setClassPkName(classPkName);
		}

		if (creatorFullName == null) {
			emoticonEntryImpl.setCreatorFullName("");
		}
		else {
			emoticonEntryImpl.setCreatorFullName(creatorFullName);
		}

		if (emoji == null) {
			emoticonEntryImpl.setEmoji("");
		}
		else {
			emoticonEntryImpl.setEmoji(emoji);
		}

		emoticonEntryImpl.resetOriginalValues();

		return emoticonEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		emoticonId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		classPkId = objectInput.readLong();
		classPkName = objectInput.readUTF();
		creatorFullName = objectInput.readUTF();
		emoji = objectInput.readUTF();
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

		objectOutput.writeLong(emoticonId);

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

		objectOutput.writeLong(customerId);

		objectOutput.writeLong(creatorId);

		objectOutput.writeLong(classPkId);

		if (classPkName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classPkName);
		}

		if (creatorFullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(creatorFullName);
		}

		if (emoji == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emoji);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long emoticonId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long classPkId;
	public String classPkName;
	public String creatorFullName;
	public String emoji;

}