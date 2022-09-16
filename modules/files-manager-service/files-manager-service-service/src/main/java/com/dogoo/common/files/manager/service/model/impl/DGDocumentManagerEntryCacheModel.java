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

import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DGDocumentManagerEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DGDocumentManagerEntryCacheModel
	implements CacheModel<DGDocumentManagerEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGDocumentManagerEntryCacheModel)) {
			return false;
		}

		DGDocumentManagerEntryCacheModel dgDocumentManagerEntryCacheModel =
			(DGDocumentManagerEntryCacheModel)object;

		if (documentManagerId ==
				dgDocumentManagerEntryCacheModel.documentManagerId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentManagerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", documentManagerId=");
		sb.append(documentManagerId);
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
		sb.append(", pkCode=");
		sb.append(pkCode);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", category=");
		sb.append(category);
		sb.append(", type=");
		sb.append(type);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", fileExtension=");
		sb.append(fileExtension);
		sb.append(", mineType=");
		sb.append(mineType);
		sb.append(", path=");
		sb.append(path);
		sb.append(", moduleId=");
		sb.append(moduleId);
		sb.append(", appId=");
		sb.append(appId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", isPrivate=");
		sb.append(isPrivate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DGDocumentManagerEntry toEntityModel() {
		DGDocumentManagerEntryImpl dgDocumentManagerEntryImpl =
			new DGDocumentManagerEntryImpl();

		if (uuid == null) {
			dgDocumentManagerEntryImpl.setUuid("");
		}
		else {
			dgDocumentManagerEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dgDocumentManagerEntryImpl.setExternalReferenceCode("");
		}
		else {
			dgDocumentManagerEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		dgDocumentManagerEntryImpl.setDocumentManagerId(documentManagerId);
		dgDocumentManagerEntryImpl.setGroupId(groupId);
		dgDocumentManagerEntryImpl.setCompanyId(companyId);
		dgDocumentManagerEntryImpl.setUserId(userId);

		if (userName == null) {
			dgDocumentManagerEntryImpl.setUserName("");
		}
		else {
			dgDocumentManagerEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dgDocumentManagerEntryImpl.setCreateDate(null);
		}
		else {
			dgDocumentManagerEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgDocumentManagerEntryImpl.setModifiedDate(null);
		}
		else {
			dgDocumentManagerEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgDocumentManagerEntryImpl.setCustomerId(customerId);
		dgDocumentManagerEntryImpl.setCreatorId(creatorId);

		if (pkCode == null) {
			dgDocumentManagerEntryImpl.setPkCode("");
		}
		else {
			dgDocumentManagerEntryImpl.setPkCode(pkCode);
		}

		dgDocumentManagerEntryImpl.setParentId(parentId);

		if (name == null) {
			dgDocumentManagerEntryImpl.setName("");
		}
		else {
			dgDocumentManagerEntryImpl.setName(name);
		}

		if (category == null) {
			dgDocumentManagerEntryImpl.setCategory("");
		}
		else {
			dgDocumentManagerEntryImpl.setCategory(category);
		}

		if (type == null) {
			dgDocumentManagerEntryImpl.setType("");
		}
		else {
			dgDocumentManagerEntryImpl.setType(type);
		}

		dgDocumentManagerEntryImpl.setFileId(fileId);

		if (fileSize == null) {
			dgDocumentManagerEntryImpl.setFileSize("");
		}
		else {
			dgDocumentManagerEntryImpl.setFileSize(fileSize);
		}

		if (fileExtension == null) {
			dgDocumentManagerEntryImpl.setFileExtension("");
		}
		else {
			dgDocumentManagerEntryImpl.setFileExtension(fileExtension);
		}

		if (mineType == null) {
			dgDocumentManagerEntryImpl.setMineType("");
		}
		else {
			dgDocumentManagerEntryImpl.setMineType(mineType);
		}

		if (path == null) {
			dgDocumentManagerEntryImpl.setPath("");
		}
		else {
			dgDocumentManagerEntryImpl.setPath(path);
		}

		if (moduleId == null) {
			dgDocumentManagerEntryImpl.setModuleId("");
		}
		else {
			dgDocumentManagerEntryImpl.setModuleId(moduleId);
		}

		if (appId == null) {
			dgDocumentManagerEntryImpl.setAppId("");
		}
		else {
			dgDocumentManagerEntryImpl.setAppId(appId);
		}

		dgDocumentManagerEntryImpl.setDepartmentId(departmentId);
		dgDocumentManagerEntryImpl.setIsPrivate(isPrivate);

		dgDocumentManagerEntryImpl.resetOriginalValues();

		return dgDocumentManagerEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		documentManagerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();
		pkCode = objectInput.readUTF();

		parentId = objectInput.readLong();
		name = objectInput.readUTF();
		category = objectInput.readUTF();
		type = objectInput.readUTF();

		fileId = objectInput.readLong();
		fileSize = objectInput.readUTF();
		fileExtension = objectInput.readUTF();
		mineType = objectInput.readUTF();
		path = objectInput.readUTF();
		moduleId = objectInput.readUTF();
		appId = objectInput.readUTF();

		departmentId = objectInput.readLong();

		isPrivate = objectInput.readBoolean();
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

		objectOutput.writeLong(documentManagerId);

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

		if (pkCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pkCode);
		}

		objectOutput.writeLong(parentId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(fileId);

		if (fileSize == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		if (fileExtension == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileExtension);
		}

		if (mineType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mineType);
		}

		if (path == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(path);
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

		objectOutput.writeLong(departmentId);

		objectOutput.writeBoolean(isPrivate);
	}

	public String uuid;
	public String externalReferenceCode;
	public long documentManagerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public String pkCode;
	public long parentId;
	public String name;
	public String category;
	public String type;
	public long fileId;
	public String fileSize;
	public String fileExtension;
	public String mineType;
	public String path;
	public String moduleId;
	public String appId;
	public long departmentId;
	public boolean isPrivate;

}