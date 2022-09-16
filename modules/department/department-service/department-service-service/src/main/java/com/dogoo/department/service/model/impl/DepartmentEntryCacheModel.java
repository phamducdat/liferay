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

package com.dogoo.department.service.model.impl;

import com.dogoo.department.service.model.DepartmentEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DepartmentEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DepartmentEntryCacheModel
	implements CacheModel<DepartmentEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DepartmentEntryCacheModel)) {
			return false;
		}

		DepartmentEntryCacheModel departmentEntryCacheModel =
			(DepartmentEntryCacheModel)object;

		if (departmentId == departmentEntryCacheModel.departmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, departmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", departmentId=");
		sb.append(departmentId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", order=");
		sb.append(order);
		sb.append(", type=");
		sb.append(type);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", tax=");
		sb.append(tax);
		sb.append(", address=");
		sb.append(address);
		sb.append(", headOffice=");
		sb.append(headOffice);
		sb.append(", alias=");
		sb.append(alias);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DepartmentEntry toEntityModel() {
		DepartmentEntryImpl departmentEntryImpl = new DepartmentEntryImpl();

		if (uuid == null) {
			departmentEntryImpl.setUuid("");
		}
		else {
			departmentEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			departmentEntryImpl.setExternalReferenceCode("");
		}
		else {
			departmentEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		departmentEntryImpl.setDepartmentId(departmentId);
		departmentEntryImpl.setGroupId(groupId);
		departmentEntryImpl.setCompanyId(companyId);
		departmentEntryImpl.setUserId(userId);

		if (userName == null) {
			departmentEntryImpl.setUserName("");
		}
		else {
			departmentEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			departmentEntryImpl.setCreateDate(null);
		}
		else {
			departmentEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			departmentEntryImpl.setModifiedDate(null);
		}
		else {
			departmentEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		departmentEntryImpl.setCreatorId(creatorId);
		departmentEntryImpl.setCustomerId(customerId);

		if (name == null) {
			departmentEntryImpl.setName("");
		}
		else {
			departmentEntryImpl.setName(name);
		}

		if (code == null) {
			departmentEntryImpl.setCode("");
		}
		else {
			departmentEntryImpl.setCode(code);
		}

		departmentEntryImpl.setParentId(parentId);
		departmentEntryImpl.setOrder(order);

		if (type == null) {
			departmentEntryImpl.setType("");
		}
		else {
			departmentEntryImpl.setType(type);
		}

		departmentEntryImpl.setBusinessId(businessId);

		if (tax == null) {
			departmentEntryImpl.setTax("");
		}
		else {
			departmentEntryImpl.setTax(tax);
		}

		if (address == null) {
			departmentEntryImpl.setAddress("");
		}
		else {
			departmentEntryImpl.setAddress(address);
		}

		if (headOffice == null) {
			departmentEntryImpl.setHeadOffice("");
		}
		else {
			departmentEntryImpl.setHeadOffice(headOffice);
		}

		if (alias == null) {
			departmentEntryImpl.setAlias("");
		}
		else {
			departmentEntryImpl.setAlias(alias);
		}

		if (description == null) {
			departmentEntryImpl.setDescription("");
		}
		else {
			departmentEntryImpl.setDescription(description);
		}

		if (status == null) {
			departmentEntryImpl.setStatus("");
		}
		else {
			departmentEntryImpl.setStatus(status);
		}

		if (statusDate == Long.MIN_VALUE) {
			departmentEntryImpl.setStatusDate(null);
		}
		else {
			departmentEntryImpl.setStatusDate(new Date(statusDate));
		}

		departmentEntryImpl.resetOriginalValues();

		return departmentEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		departmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		customerId = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		parentId = objectInput.readLong();

		order = objectInput.readInt();
		type = objectInput.readUTF();

		businessId = objectInput.readLong();
		tax = objectInput.readUTF();
		address = objectInput.readUTF();
		headOffice = objectInput.readUTF();
		alias = objectInput.readUTF();
		description = objectInput.readUTF();
		status = objectInput.readUTF();
		statusDate = objectInput.readLong();
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

		objectOutput.writeLong(departmentId);

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

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(parentId);

		objectOutput.writeInt(order);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(businessId);

		if (tax == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tax);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (headOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(headOffice);
		}

		if (alias == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(alias);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public String externalReferenceCode;
	public long departmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long customerId;
	public String name;
	public String code;
	public long parentId;
	public int order;
	public String type;
	public long businessId;
	public String tax;
	public String address;
	public String headOffice;
	public String alias;
	public String description;
	public String status;
	public long statusDate;

}