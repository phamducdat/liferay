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

package com.dogoo.dataitems.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author nghiatt
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DataItemEntrySoap implements Serializable {

	public static DataItemEntrySoap toSoapModel(DataItemEntry model) {
		DataItemEntrySoap soapModel = new DataItemEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setDataItemId(model.getDataItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setOrder_(model.getOrder_());
		soapModel.setType(model.getType());
		soapModel.setParentId(model.getParentId());
		soapModel.setIsDefaultValue(model.isIsDefaultValue());

		return soapModel;
	}

	public static DataItemEntrySoap[] toSoapModels(DataItemEntry[] models) {
		DataItemEntrySoap[] soapModels = new DataItemEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataItemEntrySoap[][] toSoapModels(DataItemEntry[][] models) {
		DataItemEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataItemEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataItemEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataItemEntrySoap[] toSoapModels(List<DataItemEntry> models) {
		List<DataItemEntrySoap> soapModels = new ArrayList<DataItemEntrySoap>(
			models.size());

		for (DataItemEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataItemEntrySoap[soapModels.size()]);
	}

	public DataItemEntrySoap() {
	}

	public long getPrimaryKey() {
		return _dataItemId;
	}

	public void setPrimaryKey(long pk) {
		setDataItemId(pk);
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

	public long getDataItemId() {
		return _dataItemId;
	}

	public void setDataItemId(long dataItemId) {
		_dataItemId = dataItemId;
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

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getOrder_() {
		return _order_;
	}

	public void setOrder_(long order_) {
		_order_ = order_;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public boolean getIsDefaultValue() {
		return _isDefaultValue;
	}

	public boolean isIsDefaultValue() {
		return _isDefaultValue;
	}

	public void setIsDefaultValue(boolean isDefaultValue) {
		_isDefaultValue = isDefaultValue;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _dataItemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creatorId;
	private long _customerId;
	private String _name;
	private String _description;
	private long _order_;
	private String _type;
	private long _parentId;
	private boolean _isDefaultValue;

}