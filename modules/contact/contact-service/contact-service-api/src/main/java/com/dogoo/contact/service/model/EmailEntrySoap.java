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

package com.dogoo.contact.service.model;

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
public class EmailEntrySoap implements Serializable {

	public static EmailEntrySoap toSoapModel(EmailEntry model) {
		EmailEntrySoap soapModel = new EmailEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setEmailId(model.getEmailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setContactId(model.getContactId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setIsDefaulted(model.isIsDefaulted());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static EmailEntrySoap[] toSoapModels(EmailEntry[] models) {
		EmailEntrySoap[] soapModels = new EmailEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailEntrySoap[][] toSoapModels(EmailEntry[][] models) {
		EmailEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailEntrySoap[] toSoapModels(List<EmailEntry> models) {
		List<EmailEntrySoap> soapModels = new ArrayList<EmailEntrySoap>(
			models.size());

		for (EmailEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailEntrySoap[soapModels.size()]);
	}

	public EmailEntrySoap() {
	}

	public long getPrimaryKey() {
		return _emailId;
	}

	public void setPrimaryKey(long pk) {
		setEmailId(pk);
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

	public long getEmailId() {
		return _emailId;
	}

	public void setEmailId(long emailId) {
		_emailId = emailId;
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

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public boolean getIsDefaulted() {
		return _isDefaulted;
	}

	public boolean isIsDefaulted() {
		return _isDefaulted;
	}

	public void setIsDefaulted(boolean isDefaulted) {
		_isDefaulted = isDefaulted;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _emailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creatorId;
	private long _customerId;
	private long _contactId;
	private String _emailAddress;
	private boolean _isDefaulted;
	private String _description;

}