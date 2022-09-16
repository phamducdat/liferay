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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AddressEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressEntry
 * @generated
 */
public class AddressEntryWrapper
	extends BaseModelWrapper<AddressEntry>
	implements AddressEntry, ModelWrapper<AddressEntry> {

	public AddressEntryWrapper(AddressEntry addressEntry) {
		super(addressEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("addressId", getAddressId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("customerId", getCustomerId());
		attributes.put("detail", getDetail());
		attributes.put("postalCode", getPostalCode());
		attributes.put("ward", getWard());
		attributes.put("district", getDistrict());
		attributes.put("province", getProvince());
		attributes.put("country", getCountry());
		attributes.put("wardCode", getWardCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("provinceCode", getProvinceCode());
		attributes.put("countryCode", getCountryCode());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String detail = (String)attributes.get("detail");

		if (detail != null) {
			setDetail(detail);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String ward = (String)attributes.get("ward");

		if (ward != null) {
			setWard(ward);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String province = (String)attributes.get("province");

		if (province != null) {
			setProvince(province);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String wardCode = (String)attributes.get("wardCode");

		if (wardCode != null) {
			setWardCode(wardCode);
		}

		String districtCode = (String)attributes.get("districtCode");

		if (districtCode != null) {
			setDistrictCode(districtCode);
		}

		String provinceCode = (String)attributes.get("provinceCode");

		if (provinceCode != null) {
			setProvinceCode(provinceCode);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	@Override
	public AddressEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address ID of this address entry.
	 *
	 * @return the address ID of this address entry
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the company ID of this address entry.
	 *
	 * @return the company ID of this address entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of this address entry.
	 *
	 * @return the country of this address entry
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the country code of this address entry.
	 *
	 * @return the country code of this address entry
	 */
	@Override
	public String getCountryCode() {
		return model.getCountryCode();
	}

	/**
	 * Returns the create date of this address entry.
	 *
	 * @return the create date of this address entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this address entry.
	 *
	 * @return the creator ID of this address entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this address entry.
	 *
	 * @return the customer ID of this address entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the detail of this address entry.
	 *
	 * @return the detail of this address entry
	 */
	@Override
	public String getDetail() {
		return model.getDetail();
	}

	/**
	 * Returns the district of this address entry.
	 *
	 * @return the district of this address entry
	 */
	@Override
	public String getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the district code of this address entry.
	 *
	 * @return the district code of this address entry
	 */
	@Override
	public String getDistrictCode() {
		return model.getDistrictCode();
	}

	/**
	 * Returns the external reference code of this address entry.
	 *
	 * @return the external reference code of this address entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this address entry.
	 *
	 * @return the group ID of this address entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this address entry.
	 *
	 * @return the modified date of this address entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the postal code of this address entry.
	 *
	 * @return the postal code of this address entry
	 */
	@Override
	public String getPostalCode() {
		return model.getPostalCode();
	}

	/**
	 * Returns the primary key of this address entry.
	 *
	 * @return the primary key of this address entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the province of this address entry.
	 *
	 * @return the province of this address entry
	 */
	@Override
	public String getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the province code of this address entry.
	 *
	 * @return the province code of this address entry
	 */
	@Override
	public String getProvinceCode() {
		return model.getProvinceCode();
	}

	/**
	 * Returns the title of this address entry.
	 *
	 * @return the title of this address entry
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this address entry.
	 *
	 * @return the user ID of this address entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this address entry.
	 *
	 * @return the user name of this address entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this address entry.
	 *
	 * @return the user uuid of this address entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this address entry.
	 *
	 * @return the uuid of this address entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the ward of this address entry.
	 *
	 * @return the ward of this address entry
	 */
	@Override
	public String getWard() {
		return model.getWard();
	}

	/**
	 * Returns the ward code of this address entry.
	 *
	 * @return the ward code of this address entry
	 */
	@Override
	public String getWardCode() {
		return model.getWardCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address ID of this address entry.
	 *
	 * @param addressId the address ID of this address entry
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the company ID of this address entry.
	 *
	 * @param companyId the company ID of this address entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of this address entry.
	 *
	 * @param country the country of this address entry
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
	}

	/**
	 * Sets the country code of this address entry.
	 *
	 * @param countryCode the country code of this address entry
	 */
	@Override
	public void setCountryCode(String countryCode) {
		model.setCountryCode(countryCode);
	}

	/**
	 * Sets the create date of this address entry.
	 *
	 * @param createDate the create date of this address entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this address entry.
	 *
	 * @param creatorId the creator ID of this address entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this address entry.
	 *
	 * @param customerId the customer ID of this address entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the detail of this address entry.
	 *
	 * @param detail the detail of this address entry
	 */
	@Override
	public void setDetail(String detail) {
		model.setDetail(detail);
	}

	/**
	 * Sets the district of this address entry.
	 *
	 * @param district the district of this address entry
	 */
	@Override
	public void setDistrict(String district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the district code of this address entry.
	 *
	 * @param districtCode the district code of this address entry
	 */
	@Override
	public void setDistrictCode(String districtCode) {
		model.setDistrictCode(districtCode);
	}

	/**
	 * Sets the external reference code of this address entry.
	 *
	 * @param externalReferenceCode the external reference code of this address entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this address entry.
	 *
	 * @param groupId the group ID of this address entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this address entry.
	 *
	 * @param modifiedDate the modified date of this address entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the postal code of this address entry.
	 *
	 * @param postalCode the postal code of this address entry
	 */
	@Override
	public void setPostalCode(String postalCode) {
		model.setPostalCode(postalCode);
	}

	/**
	 * Sets the primary key of this address entry.
	 *
	 * @param primaryKey the primary key of this address entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the province of this address entry.
	 *
	 * @param province the province of this address entry
	 */
	@Override
	public void setProvince(String province) {
		model.setProvince(province);
	}

	/**
	 * Sets the province code of this address entry.
	 *
	 * @param provinceCode the province code of this address entry
	 */
	@Override
	public void setProvinceCode(String provinceCode) {
		model.setProvinceCode(provinceCode);
	}

	/**
	 * Sets the title of this address entry.
	 *
	 * @param title the title of this address entry
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this address entry.
	 *
	 * @param userId the user ID of this address entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this address entry.
	 *
	 * @param userName the user name of this address entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this address entry.
	 *
	 * @param userUuid the user uuid of this address entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this address entry.
	 *
	 * @param uuid the uuid of this address entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the ward of this address entry.
	 *
	 * @param ward the ward of this address entry
	 */
	@Override
	public void setWard(String ward) {
		model.setWard(ward);
	}

	/**
	 * Sets the ward code of this address entry.
	 *
	 * @param wardCode the ward code of this address entry
	 */
	@Override
	public void setWardCode(String wardCode) {
		model.setWardCode(wardCode);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AddressEntryWrapper wrap(AddressEntry addressEntry) {
		return new AddressEntryWrapper(addressEntry);
	}

}