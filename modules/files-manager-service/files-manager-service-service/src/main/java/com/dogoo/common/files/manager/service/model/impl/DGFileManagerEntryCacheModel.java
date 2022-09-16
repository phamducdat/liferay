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

import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGFileManagerEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGFileManagerEntryCacheModel
	implements CacheModel<DGFileManagerEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFileManagerEntryCacheModel)) {
			return false;
		}

		DGFileManagerEntryCacheModel dgFileManagerEntryCacheModel =
			(DGFileManagerEntryCacheModel)object;

		if (fileManagerId == dgFileManagerEntryCacheModel.fileManagerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileManagerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", fileManagerId=");
		sb.append(fileManagerId);
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
		sb.append(", parentCode=");
		sb.append(parentCode);
		sb.append(", fileType=");
		sb.append(fileType);
		sb.append(", type=");
		sb.append(type);
		sb.append(", pkType=");
		sb.append(pkType);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", moduleId=");
		sb.append(moduleId);
		sb.append(", appId=");
		sb.append(appId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGFileManagerEntry toEntityModel() {
		DGFileManagerEntryImpl dgFileManagerEntryImpl =
			new DGFileManagerEntryImpl();

		if (uuid == null) {
			dgFileManagerEntryImpl.setUuid("");
		}
		else {
			dgFileManagerEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgFileManagerEntryImpl.setExternalReferenceCode("");
		}
		else {
			dgFileManagerEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgFileManagerEntryImpl.setFileManagerId(fileManagerId);
		dgFileManagerEntryImpl.setGroupId(groupId);
		dgFileManagerEntryImpl.setCompanyId(companyId);
		dgFileManagerEntryImpl.setUserId(userId);

		if (userName == null) {
			dgFileManagerEntryImpl.setUserName("");
		}
		else {
			dgFileManagerEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgFileManagerEntryImpl.setCreateDate(null);
		}
		else {
			dgFileManagerEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgFileManagerEntryImpl.setModifiedDate(null);
		}
		else {
			dgFileManagerEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgFileManagerEntryImpl.setCustomerId(customerId);
		dgFileManagerEntryImpl.setCreatorId(creatorId);
		dgFileManagerEntryImpl.setFileId(fileId);

		if (parentCode == null) {
			dgFileManagerEntryImpl.setParentCode("");
		}
		else {
			dgFileManagerEntryImpl.setParentCode(parentCode);
		}

		if (fileType == null) {
			dgFileManagerEntryImpl.setFileType("");
		}
		else {
			dgFileManagerEntryImpl.setFileType(fileType);
		}

		if (type == null) {
			dgFileManagerEntryImpl.setType("");
		}
		else {
			dgFileManagerEntryImpl.setType(type);
		}

		if (pkType == null) {
			dgFileManagerEntryImpl.setPkType("");
		}
		else {
			dgFileManagerEntryImpl.setPkType(pkType);
		}

		if (fileName == null) {
			dgFileManagerEntryImpl.setFileName("");
		}
		else {
			dgFileManagerEntryImpl.setFileName(fileName);
		}

		if (fileSize == null) {
			dgFileManagerEntryImpl.setFileSize("");
		}
		else {
			dgFileManagerEntryImpl.setFileSize(fileSize);
		}

		if (moduleId == null) {
			dgFileManagerEntryImpl.setModuleId("");
		}
		else {
			dgFileManagerEntryImpl.setModuleId(moduleId);
		}

		if (appId == null) {
			dgFileManagerEntryImpl.setAppId("");
		}
		else {
			dgFileManagerEntryImpl.setAppId(appId);
		}

		dgFileManagerEntryImpl.resetOriginalValues();

		return dgFileManagerEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		fileManagerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		fileId = objectInput.readLong();
		parentCode = objectInput.readUTF();
		fileType = objectInput.readUTF();
		type = objectInput.readUTF();
		pkType = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileSize = objectInput.readUTF();
		moduleId = objectInput.readUTF();
		appId = objectInput.readUTF();
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

		objectOutput.writeLong(fileManagerId);

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

		if (parentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentCode);
		}

		if (fileType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileType);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (pkType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pkType);
		}

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileSize == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		if (moduleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moduleId);
		}

		if (appId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appId);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long fileManagerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long fileId;
	public String parentCode;
	public String fileType;
	public String type;
	public String pkType;
	public String fileName;
	public String fileSize;
	public String moduleId;
	public String appId;

}