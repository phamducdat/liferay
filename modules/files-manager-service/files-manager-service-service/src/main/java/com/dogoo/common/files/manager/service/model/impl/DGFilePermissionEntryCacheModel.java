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

import com.dogoo.common.files.manager.service.model.DGFilePermissionEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFilePermissionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFilePermissionEntryCacheModel
	implements CacheModel<DGFilePermissionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFilePermissionEntryCacheModel)) {
			return false;
		}

		DGFilePermissionEntryCacheModel dgFilePermissionEntryCacheModel =
			(DGFilePermissionEntryCacheModel)object;

		if (filePermissionId ==
				dgFilePermissionEntryCacheModel.filePermissionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, filePermissionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", filePermissionId=");
		sb.append(filePermissionId);
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
		sb.append(", generalPermission=");
		sb.append(generalPermission);
		sb.append(", role=");
		sb.append(role);
		sb.append(", allowActionForEditor=");
		sb.append(allowActionForEditor);
		sb.append(", allowActionForViewer=");
		sb.append(allowActionForViewer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGFilePermissionEntry toEntityModel() {
		DGFilePermissionEntryImpl dgFilePermissionEntryImpl =
			new DGFilePermissionEntryImpl();

		if (uuid == null) {
			dgFilePermissionEntryImpl.setUuid("");
		}
		else {
			dgFilePermissionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgFilePermissionEntryImpl.setExternalReferenceCode("");
		}
		else {
			dgFilePermissionEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgFilePermissionEntryImpl.setFilePermissionId(filePermissionId);
		dgFilePermissionEntryImpl.setGroupId(groupId);
		dgFilePermissionEntryImpl.setCompanyId(companyId);
		dgFilePermissionEntryImpl.setUserId(userId);

		if (userName == null) {
			dgFilePermissionEntryImpl.setUserName("");
		}
		else {
			dgFilePermissionEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgFilePermissionEntryImpl.setCreateDate(null);
		}
		else {
			dgFilePermissionEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgFilePermissionEntryImpl.setModifiedDate(null);
		}
		else {
			dgFilePermissionEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgFilePermissionEntryImpl.setCustomerId(customerId);
		dgFilePermissionEntryImpl.setCreatorId(creatorId);
		dgFilePermissionEntryImpl.setFileId(fileId);

		if (generalPermission == null) {
			dgFilePermissionEntryImpl.setGeneralPermission("");
		}
		else {
			dgFilePermissionEntryImpl.setGeneralPermission(generalPermission);
		}

		if (role == null) {
			dgFilePermissionEntryImpl.setRole("");
		}
		else {
			dgFilePermissionEntryImpl.setRole(role);
		}

		dgFilePermissionEntryImpl.setAllowActionForEditor(allowActionForEditor);
		dgFilePermissionEntryImpl.setAllowActionForViewer(allowActionForViewer);

		dgFilePermissionEntryImpl.resetOriginalValues();

		return dgFilePermissionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		filePermissionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		fileId = objectInput.readLong();
		generalPermission = objectInput.readUTF();
		role = objectInput.readUTF();

		allowActionForEditor = objectInput.readBoolean();

		allowActionForViewer = objectInput.readBoolean();
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

		objectOutput.writeLong(filePermissionId);

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

		if (generalPermission == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(generalPermission);
		}

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		objectOutput.writeBoolean(allowActionForEditor);

		objectOutput.writeBoolean(allowActionForViewer);
	}

	public String uuid;
	public String externalReferenceCode;
	public long filePermissionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long fileId;
	public String generalPermission;
	public String role;
	public boolean allowActionForEditor;
	public boolean allowActionForViewer;

}