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

import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFileDepartmentPermissionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFileDepartmentPermissionEntryCacheModel
	implements CacheModel<DGFileDepartmentPermissionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFileDepartmentPermissionEntryCacheModel)) {
			return false;
		}

		DGFileDepartmentPermissionEntryCacheModel
			dgFileDepartmentPermissionEntryCacheModel =
				(DGFileDepartmentPermissionEntryCacheModel)object;

		if (fileDepartmentPermissionId ==
				dgFileDepartmentPermissionEntryCacheModel.
					fileDepartmentPermissionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileDepartmentPermissionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", fileDepartmentPermissionId=");
		sb.append(fileDepartmentPermissionId);
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
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", role=");
		sb.append(role);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGFileDepartmentPermissionEntry toEntityModel() {
		DGFileDepartmentPermissionEntryImpl
			dgFileDepartmentPermissionEntryImpl =
				new DGFileDepartmentPermissionEntryImpl();

		if (uuid == null) {
			dgFileDepartmentPermissionEntryImpl.setUuid("");
		}
		else {
			dgFileDepartmentPermissionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgFileDepartmentPermissionEntryImpl.setExternalReferenceCode("");
		}
		else {
			dgFileDepartmentPermissionEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgFileDepartmentPermissionEntryImpl.setFileDepartmentPermissionId(
			fileDepartmentPermissionId);
		dgFileDepartmentPermissionEntryImpl.setGroupId(groupId);
		dgFileDepartmentPermissionEntryImpl.setCompanyId(companyId);
		dgFileDepartmentPermissionEntryImpl.setUserId(userId);

		if (userName == null) {
			dgFileDepartmentPermissionEntryImpl.setUserName("");
		}
		else {
			dgFileDepartmentPermissionEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgFileDepartmentPermissionEntryImpl.setCreateDate(null);
		}
		else {
			dgFileDepartmentPermissionEntryImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgFileDepartmentPermissionEntryImpl.setModifiedDate(null);
		}
		else {
			dgFileDepartmentPermissionEntryImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		dgFileDepartmentPermissionEntryImpl.setCustomerId(customerId);
		dgFileDepartmentPermissionEntryImpl.setCreatorId(creatorId);
		dgFileDepartmentPermissionEntryImpl.setFileId(fileId);
		dgFileDepartmentPermissionEntryImpl.setDepartmentId(departmentId);

		if (role == null) {
			dgFileDepartmentPermissionEntryImpl.setRole("");
		}
		else {
			dgFileDepartmentPermissionEntryImpl.setRole(role);
		}

		if (type == null) {
			dgFileDepartmentPermissionEntryImpl.setType("");
		}
		else {
			dgFileDepartmentPermissionEntryImpl.setType(type);
		}

		dgFileDepartmentPermissionEntryImpl.resetOriginalValues();

		return dgFileDepartmentPermissionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		fileDepartmentPermissionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		fileId = objectInput.readLong();

		departmentId = objectInput.readLong();
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

		objectOutput.writeLong(fileDepartmentPermissionId);

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

		objectOutput.writeLong(departmentId);

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
	public long fileDepartmentPermissionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long fileId;
	public long departmentId;
	public String role;
	public String type;

}