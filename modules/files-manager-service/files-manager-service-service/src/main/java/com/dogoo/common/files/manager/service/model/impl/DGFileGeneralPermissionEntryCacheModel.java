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

import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFileGeneralPermissionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFileGeneralPermissionEntryCacheModel
	implements CacheModel<DGFileGeneralPermissionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFileGeneralPermissionEntryCacheModel)) {
			return false;
		}

		DGFileGeneralPermissionEntryCacheModel
			dgFileGeneralPermissionEntryCacheModel =
				(DGFileGeneralPermissionEntryCacheModel)object;

		if (fileGeneralPermissionId ==
				dgFileGeneralPermissionEntryCacheModel.
					fileGeneralPermissionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileGeneralPermissionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", fileGeneralPermissionId=");
		sb.append(fileGeneralPermissionId);
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
		sb.append(", allowed=");
		sb.append(allowed);
		sb.append(", role=");
		sb.append(role);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGFileGeneralPermissionEntry toEntityModel() {
		DGFileGeneralPermissionEntryImpl dgFileGeneralPermissionEntryImpl =
			new DGFileGeneralPermissionEntryImpl();

		if (uuid == null) {
			dgFileGeneralPermissionEntryImpl.setUuid("");
		}
		else {
			dgFileGeneralPermissionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgFileGeneralPermissionEntryImpl.setExternalReferenceCode("");
		}
		else {
			dgFileGeneralPermissionEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgFileGeneralPermissionEntryImpl.setFileGeneralPermissionId(
			fileGeneralPermissionId);
		dgFileGeneralPermissionEntryImpl.setGroupId(groupId);
		dgFileGeneralPermissionEntryImpl.setCompanyId(companyId);
		dgFileGeneralPermissionEntryImpl.setUserId(userId);

		if (userName == null) {
			dgFileGeneralPermissionEntryImpl.setUserName("");
		}
		else {
			dgFileGeneralPermissionEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgFileGeneralPermissionEntryImpl.setCreateDate(null);
		}
		else {
			dgFileGeneralPermissionEntryImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgFileGeneralPermissionEntryImpl.setModifiedDate(null);
		}
		else {
			dgFileGeneralPermissionEntryImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		dgFileGeneralPermissionEntryImpl.setCustomerId(customerId);
		dgFileGeneralPermissionEntryImpl.setCreatorId(creatorId);
		dgFileGeneralPermissionEntryImpl.setFileId(fileId);

		if (allowed == null) {
			dgFileGeneralPermissionEntryImpl.setAllowed("");
		}
		else {
			dgFileGeneralPermissionEntryImpl.setAllowed(allowed);
		}

		if (role == null) {
			dgFileGeneralPermissionEntryImpl.setRole("");
		}
		else {
			dgFileGeneralPermissionEntryImpl.setRole(role);
		}

		if (type == null) {
			dgFileGeneralPermissionEntryImpl.setType("");
		}
		else {
			dgFileGeneralPermissionEntryImpl.setType(type);
		}

		dgFileGeneralPermissionEntryImpl.resetOriginalValues();

		return dgFileGeneralPermissionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		fileGeneralPermissionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		fileId = objectInput.readLong();
		allowed = objectInput.readUTF();
		role = objectInput.readUTF();
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

		objectOutput.writeLong(fileGeneralPermissionId);

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

		if (allowed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(allowed);
		}

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
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
	public long fileGeneralPermissionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long fileId;
	public String allowed;
	public String role;
	public String type;

}