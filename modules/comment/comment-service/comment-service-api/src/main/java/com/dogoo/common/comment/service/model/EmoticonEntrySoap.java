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

package com.dogoo.common.comment.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmoticonEntrySoap implements Serializable {

	public static EmoticonEntrySoap toSoapModel(EmoticonEntry model) {
		EmoticonEntrySoap soapModel = new EmoticonEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setEmoticonId(model.getEmoticonId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setClassPkId(model.getClassPkId());
		soapModel.setClassPkName(model.getClassPkName());
		soapModel.setCreatorFullName(model.getCreatorFullName());
		soapModel.setEmoji(model.getEmoji());

		return soapModel;
	}

	public static EmoticonEntrySoap[] toSoapModels(EmoticonEntry[] models) {
		EmoticonEntrySoap[] soapModels = new EmoticonEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmoticonEntrySoap[][] toSoapModels(EmoticonEntry[][] models) {
		EmoticonEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmoticonEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmoticonEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmoticonEntrySoap[] toSoapModels(List<EmoticonEntry> models) {
		List<EmoticonEntrySoap> soapModels = new ArrayList<EmoticonEntrySoap>(
			models.size());

		for (EmoticonEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmoticonEntrySoap[soapModels.size()]);
	}

	public EmoticonEntrySoap() {
	}

	public long getPrimaryKey() {
		return _emoticonId;
	}

	public void setPrimaryKey(long pk) {
		setEmoticonId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public long getEmoticonId() {
		return _emoticonId;
	}

	public void setEmoticonId(long emoticonId) {
		_emoticonId = emoticonId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getClassPkId() {
		return _classPkId;
	}

	public void setClassPkId(long classPkId) {
		_classPkId = classPkId;
	}

	public String getClassPkName() {
		return _classPkName;
	}

	public void setClassPkName(String classPkName) {
		_classPkName = classPkName;
	}

	public String getCreatorFullName() {
		return _creatorFullName;
	}

	public void setCreatorFullName(String creatorFullName) {
		_creatorFullName = creatorFullName;
	}

	public String getEmoji() {
		return _emoji;
	}

	public void setEmoji(String emoji) {
		_emoji = emoji;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _emoticonId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _classPkId;
	private String _classPkName;
	private String _creatorFullName;
	private String _emoji;

}