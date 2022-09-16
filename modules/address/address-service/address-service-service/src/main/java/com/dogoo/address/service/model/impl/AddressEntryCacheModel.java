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

package com.dogoo.address.service.model.impl;

import com.dogoo.address.service.model.AddressEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AddressEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressEntryCacheModel
	implements CacheModel<AddressEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AddressEntryCacheModel)) {
			return false;
		}

		AddressEntryCacheModel addressEntryCacheModel =
			(AddressEntryCacheModel)object;

		if (addressId == addressEntryCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", addressId=");
		sb.append(addressId);
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
		sb.append(", detail=");
		sb.append(detail);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", ward=");
		sb.append(ward);
		sb.append(", district=");
		sb.append(district);
		sb.append(", province=");
		sb.append(province);
		sb.append(", country=");
		sb.append(country);
		sb.append(", wardCode=");
		sb.append(wardCode);
		sb.append(", districtCode=");
		sb.append(districtCode);
		sb.append(", provinceCode=");
		sb.append(provinceCode);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressEntry toEntityModel() {
		AddressEntryImpl addressEntryImpl = new AddressEntryImpl();

		if (uuid == null) {
			addressEntryImpl.setUuid("");
		}
		else {
			addressEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			addressEntryImpl.setExternalReferenceCode("");
		}
		else {
			addressEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		addressEntryImpl.setAddressId(addressId);
		addressEntryImpl.setGroupId(groupId);
		addressEntryImpl.setCompanyId(companyId);
		addressEntryImpl.setUserId(userId);

		if (userName == null) {
			addressEntryImpl.setUserName("");
		}
		else {
			addressEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			addressEntryImpl.setCreateDate(null);
		}
		else {
			addressEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			addressEntryImpl.setModifiedDate(null);
		}
		else {
			addressEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		addressEntryImpl.setCreatorId(creatorId);
		addressEntryImpl.setCustomerId(customerId);

		if (detail == null) {
			addressEntryImpl.setDetail("");
		}
		else {
			addressEntryImpl.setDetail(detail);
		}

		if (postalCode == null) {
			addressEntryImpl.setPostalCode("");
		}
		else {
			addressEntryImpl.setPostalCode(postalCode);
		}

		if (ward == null) {
			addressEntryImpl.setWard("");
		}
		else {
			addressEntryImpl.setWard(ward);
		}

		if (district == null) {
			addressEntryImpl.setDistrict("");
		}
		else {
			addressEntryImpl.setDistrict(district);
		}

		if (province == null) {
			addressEntryImpl.setProvince("");
		}
		else {
			addressEntryImpl.setProvince(province);
		}

		if (country == null) {
			addressEntryImpl.setCountry("");
		}
		else {
			addressEntryImpl.setCountry(country);
		}

		if (wardCode == null) {
			addressEntryImpl.setWardCode("");
		}
		else {
			addressEntryImpl.setWardCode(wardCode);
		}

		if (districtCode == null) {
			addressEntryImpl.setDistrictCode("");
		}
		else {
			addressEntryImpl.setDistrictCode(districtCode);
		}

		if (provinceCode == null) {
			addressEntryImpl.setProvinceCode("");
		}
		else {
			addressEntryImpl.setProvinceCode(provinceCode);
		}

		if (countryCode == null) {
			addressEntryImpl.setCountryCode("");
		}
		else {
			addressEntryImpl.setCountryCode(countryCode);
		}

		if (title == null) {
			addressEntryImpl.setTitle("");
		}
		else {
			addressEntryImpl.setTitle(title);
		}

		addressEntryImpl.resetOriginalValues();

		return addressEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		addressId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		customerId = objectInput.readLong();
		detail = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		ward = objectInput.readUTF();
		district = objectInput.readUTF();
		province = objectInput.readUTF();
		country = objectInput.readUTF();
		wardCode = objectInput.readUTF();
		districtCode = objectInput.readUTF();
		provinceCode = objectInput.readUTF();
		countryCode = objectInput.readUTF();
		title = objectInput.readUTF();
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

		objectOutput.writeLong(addressId);

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

		if (detail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detail);
		}

		if (postalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		if (ward == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ward);
		}

		if (district == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(district);
		}

		if (province == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(province);
		}

		if (country == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (wardCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(wardCode);
		}

		if (districtCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(districtCode);
		}

		if (provinceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provinceCode);
		}

		if (countryCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long addressId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long customerId;
	public String detail;
	public String postalCode;
	public String ward;
	public String district;
	public String province;
	public String country;
	public String wardCode;
	public String districtCode;
	public String provinceCode;
	public String countryCode;
	public String title;

}