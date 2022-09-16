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

package com.dogoo.dataitems.service.model.impl;

import com.dogoo.dataitems.service.model.DataItemEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataItemEntry in entity cache.
 *
 * @author nghiatt
 * @generated
 */
public class DataItemEntryCacheModel
	implements CacheModel<DataItemEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataItemEntryCacheModel)) {
			return false;
		}

		DataItemEntryCacheModel dataItemEntryCacheModel =
			(DataItemEntryCacheModel)object;

		if (dataItemId == dataItemEntryCacheModel.dataItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", dataItemId=");
		sb.append(dataItemId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", order_=");
		sb.append(order_);
		sb.append(", type=");
		sb.append(type);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", isDefaultValue=");
		sb.append(isDefaultValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataItemEntry toEntityModel() {
		DataItemEntryImpl dataItemEntryImpl = new DataItemEntryImpl();

		if (uuid == null) {
			dataItemEntryImpl.setUuid("");
		}
		else {
			dataItemEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dataItemEntryImpl.setExternalReferenceCode("");
		}
		else {
			dataItemEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		dataItemEntryImpl.setDataItemId(dataItemId);
		dataItemEntryImpl.setGroupId(groupId);
		dataItemEntryImpl.setCompanyId(companyId);
		dataItemEntryImpl.setUserId(userId);

		if (userName == null) {
			dataItemEntryImpl.setUserName("");
		}
		else {
			dataItemEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataItemEntryImpl.setCreateDate(null);
		}
		else {
			dataItemEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataItemEntryImpl.setModifiedDate(null);
		}
		else {
			dataItemEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataItemEntryImpl.setCreatorId(creatorId);
		dataItemEntryImpl.setCustomerId(customerId);

		if (name == null) {
			dataItemEntryImpl.setName("");
		}
		else {
			dataItemEntryImpl.setName(name);
		}

		if (description == null) {
			dataItemEntryImpl.setDescription("");
		}
		else {
			dataItemEntryImpl.setDescription(description);
		}

		dataItemEntryImpl.setOrder_(order_);

		if (type == null) {
			dataItemEntryImpl.setType("");
		}
		else {
			dataItemEntryImpl.setType(type);
		}

		dataItemEntryImpl.setParentId(parentId);
		dataItemEntryImpl.setIsDefaultValue(isDefaultValue);

		dataItemEntryImpl.resetOriginalValues();

		return dataItemEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		dataItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		customerId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		order_ = objectInput.readLong();
		type = objectInput.readUTF();

		parentId = objectInput.readLong();

		isDefaultValue = objectInput.readBoolean();
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

		objectOutput.writeLong(dataItemId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(order_);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(parentId);

		objectOutput.writeBoolean(isDefaultValue);
	}

	public String uuid;
	public String externalReferenceCode;
	public long dataItemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long customerId;
	public String name;
	public String description;
	public long order_;
	public String type;
	public long parentId;
	public boolean isDefaultValue;

}