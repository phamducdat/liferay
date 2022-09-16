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

package com.dogoo.common.files.manager.service.model.impl;

import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFileUserPermissionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFileUserPermissionEntryCacheModel
	implements CacheModel<DGFileUserPermissionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFileUserPermissionEntryCacheModel)) {
			return false;
		}

		DGFileUserPermissionEntryCacheModel
			dgFileUserPermissionEntryCacheModel =
				(DGFileUserPermissionEntryCacheModel)object;

		if (fileUserPermissionId ==
				dgFileUserPermissionEntryCacheModel.fileUserPermissionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileUserPermissionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", fileUserPermissionId=");
		sb.append(fileUserPermissionId);
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
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", userAllowedId=");
		sb.append(userAllowedId);
		sb.append(", role=");
		sb.append(role);
		sb.append(", status=");
		sb.append(status);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGFileUserPermissionEntry toEntityModel() {
		DGFileUserPermissionEntryImpl dgFileUserPermissionEntryImpl =
			new DGFileUserPermissionEntryImpl();

		if (uuid == null) {
			dgFileUserPermissionEntryImpl.setUuid("");
		}
		else {
			dgFileUserPermissionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgFileUserPermissionEntryImpl.setExternalReferenceCode("");
		}
		else {
			dgFileUserPermissionEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgFileUserPermissionEntryImpl.setFileUserPermissionId(
			fileUserPermissionId);
		dgFileUserPermissionEntryImpl.setGroupId(groupId);
		dgFileUserPermissionEntryImpl.setCompanyId(companyId);
		dgFileUserPermissionEntryImpl.setUserId(userId);

		if (userName == null) {
			dgFileUserPermissionEntryImpl.setUserName("");
		}
		else {
			dgFileUserPermissionEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgFileUserPermissionEntryImpl.setCreateDate(null);
		}
		else {
			dgFileUserPermissionEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgFileUserPermissionEntryImpl.setModifiedDate(null);
		}
		else {
			dgFileUserPermissionEntryImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		dgFileUserPermissionEntryImpl.setCustomerId(customerId);
		dgFileUserPermissionEntryImpl.setCreatorId(creatorId);
		dgFileUserPermissionEntryImpl.setFileId(fileId);
		dgFileUserPermissionEntryImpl.setUserAllowedId(userAllowedId);

		if (role == null) {
			dgFileUserPermissionEntryImpl.setRole("");
		}
		else {
			dgFileUserPermissionEntryImpl.setRole(role);
		}

		if (status == null) {
			dgFileUserPermissionEntryImpl.setStatus("");
		}
		else {
			dgFileUserPermissionEntryImpl.setStatus(status);
		}

		if (type == null) {
			dgFileUserPermissionEntryImpl.setType("");
		}
		else {
			dgFileUserPermissionEntryImpl.setType(type);
		}

		dgFileUserPermissionEntryImpl.resetOriginalValues();

		return dgFileUserPermissionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		fileUserPermissionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		fileId = objectInput.readLong();

		userAllowedId = objectInput.readLong();
		role = objectInput.readUTF();
		status = objectInput.readUTF();
		type = objectInput.readUTF();
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

		objectOutput.writeLong(fileUserPermissionId);

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

		objectOutput.writeLong(fileId);

		objectOutput.writeLong(userAllowedId);

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long fileUserPermissionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long fileId;
	public long userAllowedId;
	public String role;
	public String status;
	public String type;

}