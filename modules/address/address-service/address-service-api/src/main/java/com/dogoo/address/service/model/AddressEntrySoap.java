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

package com.dogoo.address.service.model;

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
public class AddressEntrySoap implements Serializable {

	public static AddressEntrySoap toSoapModel(AddressEntry model) {
		AddressEntrySoap soapModel = new AddressEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setDetail(model.getDetail());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setWard(model.getWard());
		soapModel.setDistrict(model.getDistrict());
		soapModel.setProvince(model.getProvince());
		soapModel.setCountry(model.getCountry());
		soapModel.setWardCode(model.getWardCode());
		soapModel.setDistrictCode(model.getDistrictCode());
		soapModel.setProvinceCode(model.getProvinceCode());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setTitle(model.getTitle());

		return soapModel;
	}

	public static AddressEntrySoap[] toSoapModels(AddressEntry[] models) {
		AddressEntrySoap[] soapModels = new AddressEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressEntrySoap[][] toSoapModels(AddressEntry[][] models) {
		AddressEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressEntrySoap[] toSoapModels(List<AddressEntry> models) {
		List<AddressEntrySoap> soapModels = new ArrayList<AddressEntrySoap>(
			models.size());

		for (AddressEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressEntrySoap[soapModels.size()]);
	}

	public AddressEntrySoap() {
	}

	public long getPrimaryKey() {
		return _addressId;
	}

	public void setPrimaryKey(long pk) {
		setAddressId(pk);
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

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
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

	public String getDetail() {
		return _detail;
	}

	public void setDetail(String detail) {
		_detail = detail;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getWard() {
		return _ward;
	}

	public void setWard(String ward) {
		_ward = ward;
	}

	public String getDistrict() {
		return _district;
	}

	public void setDistrict(String district) {
		_district = district;
	}

	public String getProvince() {
		return _province;
	}

	public void setProvince(String province) {
		_province = province;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getWardCode() {
		return _wardCode;
	}

	public void setWardCode(String wardCode) {
		_wardCode = wardCode;
	}

	public String getDistrictCode() {
		return _districtCode;
	}

	public void setDistrictCode(String districtCode) {
		_districtCode = districtCode;
	}

	public String getProvinceCode() {
		return _provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		_provinceCode = provinceCode;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _addressId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creatorId;
	private long _customerId;
	private String _detail;
	private String _postalCode;
	private String _ward;
	private String _district;
	private String _province;
	private String _country;
	private String _wardCode;
	private String _districtCode;
	private String _provinceCode;
	private String _countryCode;
	private String _title;

}