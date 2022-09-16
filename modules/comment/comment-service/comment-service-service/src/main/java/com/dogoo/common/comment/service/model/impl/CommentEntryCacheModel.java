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

package com.dogoo.common.comment.service.model.impl;

import com.dogoo.common.comment.service.model.CommentEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommentEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CommentEntryCacheModel
	implements CacheModel<CommentEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommentEntryCacheModel)) {
			return false;
		}

		CommentEntryCacheModel commentEntryCacheModel =
			(CommentEntryCacheModel)object;

		if (commentId == commentEntryCacheModel.commentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", commentId=");
		sb.append(commentId);
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
		sb.append(", classPkId=");
		sb.append(classPkId);
		sb.append(", classPkName=");
		sb.append(classPkName);
		sb.append(", creatorFullName=");
		sb.append(creatorFullName);
		sb.append(", content=");
		sb.append(content);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommentEntry toEntityModel() {
		CommentEntryImpl commentEntryImpl = new CommentEntryImpl();

		if (uuid == null) {
			commentEntryImpl.setUuid("");
		}
		else {
			commentEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			commentEntryImpl.setExternalReferenceCode("");
		}
		else {
			commentEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		commentEntryImpl.setCommentId(commentId);
		commentEntryImpl.setGroupId(groupId);
		commentEntryImpl.setCompanyId(companyId);
		commentEntryImpl.setUserId(userId);

		if (userName == null) {
			commentEntryImpl.setUserName("");
		}
		else {
			commentEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commentEntryImpl.setCreateDate(null);
		}
		else {
			commentEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commentEntryImpl.setModifiedDate(null);
		}
		else {
			commentEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		commentEntryImpl.setCustomerId(customerId);
		commentEntryImpl.setCreatorId(creatorId);
		commentEntryImpl.setClassPkId(classPkId);

		if (classPkName == null) {
			commentEntryImpl.setClassPkName("");
		}
		else {
			commentEntryImpl.setClassPkName(classPkName);
		}

		if (creatorFullName == null) {
			commentEntryImpl.setCreatorFullName("");
		}
		else {
			commentEntryImpl.setCreatorFullName(creatorFullName);
		}

		if (content == null) {
			commentEntryImpl.setContent("");
		}
		else {
			commentEntryImpl.setContent(content);
		}

		commentEntryImpl.setParentId(parentId);

		commentEntryImpl.resetOriginalValues();

		return commentEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		commentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		classPkId = objectInput.readLong();
		classPkName = objectInput.readUTF();
		creatorFullName = objectInput.readUTF();
		content = objectInput.readUTF();

		parentId = objectInput.readLong();
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

		objectOutput.writeLong(commentId);

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

		objectOutput.writeLong(classPkId);

		if (classPkName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classPkName);
		}

		if (creatorFullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(creatorFullName);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(parentId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long commentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long classPkId;
	public String classPkName;
	public String creatorFullName;
	public String content;
	public long parentId;

}