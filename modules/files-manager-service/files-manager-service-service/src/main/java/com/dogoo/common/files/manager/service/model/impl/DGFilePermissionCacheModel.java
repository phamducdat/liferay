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

import com.dogoo.common.files.manager.service.model.DGFilePermission;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFilePermission in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFilePermissionCacheModel
	implements CacheModel<DGFilePermission>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFilePermissionCacheModel)) {
			return false;
		}

		DGFilePermissionCacheModel dgFilePermissionCacheModel =
			(DGFilePermissionCacheModel)object;

		if (filePermissionId == dgFilePermissionCacheModel.filePermissionId) {
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
	public DGFilePermission toEntityModel() {
		DGFilePermissionImpl dgFilePermissionImpl = new DGFilePermissionImpl();

		if (uuid == null) {
			dgFilePermissionImpl.setUuid("");
		}
		else {
			dgFilePermissionImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgFilePermissionImpl.setExternalReferenceCode("");
		}
		else {
			dgFilePermissionImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgFilePermissionImpl.setFilePermissionId(filePermissionId);
		dgFilePermissionImpl.setGroupId(groupId);
		dgFilePermissionImpl.setCompanyId(companyId);
		dgFilePermissionImpl.setUserId(userId);

		if (userName == null) {
			dgFilePermissionImpl.setUserName("");
		}
		else {
			dgFilePermissionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgFilePermissionImpl.setCreateDate(null);
		}
		else {
			dgFilePermissionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgFilePermissionImpl.setModifiedDate(null);
		}
		else {
			dgFilePermissionImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgFilePermissionImpl.setCustomerId(customerId);
		dgFilePermissionImpl.setCreatorId(creatorId);
		dgFilePermissionImpl.setFileId(fileId);

		if (generalPermission == null) {
			dgFilePermissionImpl.setGeneralPermission("");
		}
		else {
			dgFilePermissionImpl.setGeneralPermission(generalPermission);
		}

		if (role == null) {
			dgFilePermissionImpl.setRole("");
		}
		else {
			dgFilePermissionImpl.setRole(role);
		}

		dgFilePermissionImpl.setAllowActionForEditor(allowActionForEditor);
		dgFilePermissionImpl.setAllowActionForViewer(allowActionForViewer);

		dgFilePermissionImpl.resetOriginalValues();

		return dgFilePermissionImpl;
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