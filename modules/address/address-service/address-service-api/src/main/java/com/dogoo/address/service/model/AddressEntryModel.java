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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AddressEntry service. Represents a row in the &quot;DG_AddressEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.address.service.model.impl.AddressEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.address.service.model.impl.AddressEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressEntry
 * @generated
 */
@ProviderType
public interface AddressEntryModel
	extends BaseModel<AddressEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a address entry model instance should use the {@link AddressEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this address entry.
	 *
	 * @return the primary key of this address entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this address entry.
	 *
	 * @param primaryKey the primary key of this address entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this address entry.
	 *
	 * @return the uuid of this address entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this address entry.
	 *
	 * @param uuid the uuid of this address entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this address entry.
	 *
	 * @return the external reference code of this address entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this address entry.
	 *
	 * @param externalReferenceCode the external reference code of this address entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the address ID of this address entry.
	 *
	 * @return the address ID of this address entry
	 */
	public long getAddressId();

	/**
	 * Sets the address ID of this address entry.
	 *
	 * @param addressId the address ID of this address entry
	 */
	public void setAddressId(long addressId);

	/**
	 * Returns the group ID of this address entry.
	 *
	 * @return the group ID of this address entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this address entry.
	 *
	 * @param groupId the group ID of this address entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this address entry.
	 *
	 * @return the company ID of this address entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this address entry.
	 *
	 * @param companyId the company ID of this address entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this address entry.
	 *
	 * @return the user ID of this address entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this address entry.
	 *
	 * @param userId the user ID of this address entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this address entry.
	 *
	 * @return the user uuid of this address entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this address entry.
	 *
	 * @param userUuid the user uuid of this address entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this address entry.
	 *
	 * @return the user name of this address entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this address entry.
	 *
	 * @param userName the user name of this address entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this address entry.
	 *
	 * @return the create date of this address entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this address entry.
	 *
	 * @param createDate the create date of this address entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this address entry.
	 *
	 * @return the modified date of this address entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this address entry.
	 *
	 * @param modifiedDate the modified date of this address entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the creator ID of this address entry.
	 *
	 * @return the creator ID of this address entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this address entry.
	 *
	 * @param creatorId the creator ID of this address entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the customer ID of this address entry.
	 *
	 * @return the customer ID of this address entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this address entry.
	 *
	 * @param customerId the customer ID of this address entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the detail of this address entry.
	 *
	 * @return the detail of this address entry
	 */
	@AutoEscape
	public String getDetail();

	/**
	 * Sets the detail of this address entry.
	 *
	 * @param detail the detail of this address entry
	 */
	public void setDetail(String detail);

	/**
	 * Returns the postal code of this address entry.
	 *
	 * @return the postal code of this address entry
	 */
	@AutoEscape
	public String getPostalCode();

	/**
	 * Sets the postal code of this address entry.
	 *
	 * @param postalCode the postal code of this address entry
	 */
	public void setPostalCode(String postalCode);

	/**
	 * Returns the ward of this address entry.
	 *
	 * @return the ward of this address entry
	 */
	@AutoEscape
	public String getWard();

	/**
	 * Sets the ward of this address entry.
	 *
	 * @param ward the ward of this address entry
	 */
	public void setWard(String ward);

	/**
	 * Returns the district of this address entry.
	 *
	 * @return the district of this address entry
	 */
	@AutoEscape
	public String getDistrict();

	/**
	 * Sets the district of this address entry.
	 *
	 * @param district the district of this address entry
	 */
	public void setDistrict(String district);

	/**
	 * Returns the province of this address entry.
	 *
	 * @return the province of this address entry
	 */
	@AutoEscape
	public String getProvince();

	/**
	 * Sets the province of this address entry.
	 *
	 * @param province the province of this address entry
	 */
	public void setProvince(String province);

	/**
	 * Returns the country of this address entry.
	 *
	 * @return the country of this address entry
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this address entry.
	 *
	 * @param country the country of this address entry
	 */
	public void setCountry(String country);

	/**
	 * Returns the ward code of this address entry.
	 *
	 * @return the ward code of this address entry
	 */
	@AutoEscape
	public String getWardCode();

	/**
	 * Sets the ward code of this address entry.
	 *
	 * @param wardCode the ward code of this address entry
	 */
	public void setWardCode(String wardCode);

	/**
	 * Returns the district code of this address entry.
	 *
	 * @return the district code of this address entry
	 */
	@AutoEscape
	public String getDistrictCode();

	/**
	 * Sets the district code of this address entry.
	 *
	 * @param districtCode the district code of this address entry
	 */
	public void setDistrictCode(String districtCode);

	/**
	 * Returns the province code of this address entry.
	 *
	 * @return the province code of this address entry
	 */
	@AutoEscape
	public String getProvinceCode();

	/**
	 * Sets the province code of this address entry.
	 *
	 * @param provinceCode the province code of this address entry
	 */
	public void setProvinceCode(String provinceCode);

	/**
	 * Returns the country code of this address entry.
	 *
	 * @return the country code of this address entry
	 */
	@AutoEscape
	public String getCountryCode();

	/**
	 * Sets the country code of this address entry.
	 *
	 * @param countryCode the country code of this address entry
	 */
	public void setCountryCode(String countryCode);

	/**
	 * Returns the title of this address entry.
	 *
	 * @return the title of this address entry
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this address entry.
	 *
	 * @param title the title of this address entry
	 */
	public void setTitle(String title);

	@Override
	public AddressEntry cloneWithOriginalValues();

}