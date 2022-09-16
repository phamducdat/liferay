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

import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFileSettingPermissionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFileSettingPermissionEntryCacheModel
	implements CacheModel<DGFileSettingPermissionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFileSettingPermissionEntryCacheModel)) {
			return false;
		}

		DGFileSettingPermissionEntryCacheModel
			dgFileSettingPermissionEntryCacheModel =
				(DGFileSettingPermissionEntryCacheModel)object;

		if (fileSettingPermissionId ==
				dgFileSettingPermissionEntryCacheModel.
					fileSettingPermissionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileSettingPermissionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", fileSettingPermissionId=");
		sb.append(fileSettingPermissionId);
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
		sb.append(", permissionEditor=");
		sb.append(permissionEditor);
		sb.append(", permissionViewer=");
		sb.append(permissionViewer);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGFileSettingPermissionEntry toEntityModel() {
		DGFileSettingPermissionEntryImpl dgFileSettingPermissionEntryImpl =
			new DGFileSettingPermissionEntryImpl();

		if (uuid == null) {
			dgFileSettingPermissionEntryImpl.setUuid("");
		}
		else {
			dgFileSettingPermissionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgFileSettingPermissionEntryImpl.setExternalReferenceCode("");
		}
		else {
			dgFileSettingPermissionEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgFileSettingPermissionEntryImpl.setFileSettingPermissionId(
			fileSettingPermissionId);
		dgFileSettingPermissionEntryImpl.setGroupId(groupId);
		dgFileSettingPermissionEntryImpl.setCompanyId(companyId);
		dgFileSettingPermissionEntryImpl.setUserId(userId);

		if (userName == null) {
			dgFileSettingPermissionEntryImpl.setUserName("");
		}
		else {
			dgFileSettingPermissionEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgFileSettingPermissionEntryImpl.setCreateDate(null);
		}
		else {
			dgFileSettingPermissionEntryImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgFileSettingPermissionEntryImpl.setModifiedDate(null);
		}
		else {
			dgFileSettingPermissionEntryImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		dgFileSettingPermissionEntryImpl.setCustomerId(customerId);
		dgFileSettingPermissionEntryImpl.setCreatorId(creatorId);
		dgFileSettingPermissionEntryImpl.setFileId(fileId);
		dgFileSettingPermissionEntryImpl.setPermissionEditor(permissionEditor);
		dgFileSettingPermissionEntryImpl.setPermissionViewer(permissionViewer);

		if (type == null) {
			dgFileSettingPermissionEntryImpl.setType("");
		}
		else {
			dgFileSettingPermissionEntryImpl.setType(type);
		}

		dgFileSettingPermissionEntryImpl.resetOriginalValues();

		return dgFileSettingPermissionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		fileSettingPermissionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		fileId = objectInput.readLong();

		permissionEditor = objectInput.readBoolean();

		permissionViewer = objectInput.readBoolean();
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

		objectOutput.writeLong(fileSettingPermissionId);

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

		objectOutput.writeBoolean(permissionEditor);

		objectOutput.writeBoolean(permissionViewer);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long fileSettingPermissionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long fileId;
	public boolean permissionEditor;
	public boolean permissionViewer;
	public String type;

}