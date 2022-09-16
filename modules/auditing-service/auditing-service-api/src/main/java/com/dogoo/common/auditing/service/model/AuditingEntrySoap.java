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

package com.dogoo.common.auditing.service.model;

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
public class AuditingEntrySoap implements Serializable {

	public static AuditingEntrySoap toSoapModel(AuditingEntry model) {
		AuditingEntrySoap soapModel = new AuditingEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setAuditingId(model.getAuditingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatorName(model.getCreatorName());
		soapModel.setName(model.getName());
		soapModel.setEventType(model.getEventType());
		soapModel.setMessage(model.getMessage());
		soapModel.setPayload(model.getPayload());
		soapModel.setClassPkId(model.getClassPkId());
		soapModel.setClassPkName(model.getClassPkName());
		soapModel.setParentPkId(model.getParentPkId());
		soapModel.setParentPkName(model.getParentPkName());

		return soapModel;
	}

	public static AuditingEntrySoap[] toSoapModels(AuditingEntry[] models) {
		AuditingEntrySoap[] soapModels = new AuditingEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuditingEntrySoap[][] toSoapModels(AuditingEntry[][] models) {
		AuditingEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuditingEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuditingEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuditingEntrySoap[] toSoapModels(List<AuditingEntry> models) {
		List<AuditingEntrySoap> soapModels = new ArrayList<AuditingEntrySoap>(
			models.size());

		for (AuditingEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuditingEntrySoap[soapModels.size()]);
	}

	public AuditingEntrySoap() {
	}

	public long getPrimaryKey() {
		return _auditingId;
	}

	public void setPrimaryKey(long pk) {
		setAuditingId(pk);
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

	public long getAuditingId() {
		return _auditingId;
	}

	public void setAuditingId(long auditingId) {
		_auditingId = auditingId;
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

	public String getCreatorName() {
		return _creatorName;
	}

	public void setCreatorName(String creatorName) {
		_creatorName = creatorName;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getPayload() {
		return _payload;
	}

	public void setPayload(String payload) {
		_payload = payload;
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

	public Long getParentPkId() {
		return _parentPkId;
	}

	public void setParentPkId(Long parentPkId) {
		_parentPkId = parentPkId;
	}

	public String getParentPkName() {
		return _parentPkName;
	}

	public void setParentPkName(String parentPkName) {
		_parentPkName = parentPkName;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _auditingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _customerId;
	private long _creatorId;
	private String _creatorName;
	private String _name;
	private String _eventType;
	private String _message;
	private String _payload;
	private long _classPkId;
	private String _classPkName;
	private Long _parentPkId;
	private String _parentPkName;

}