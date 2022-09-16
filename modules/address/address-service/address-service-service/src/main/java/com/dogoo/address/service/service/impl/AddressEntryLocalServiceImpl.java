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

package com.dogoo.address.service.service.impl;

import com.dogoo.address.service.exception.NoSuchAddressEntryException;
import com.dogoo.address.service.model.AddressEntry;
import com.dogoo.address.service.service.base.AddressEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.dogoo.address.service.model.AddressEntry",
	service = AopService.class
)
public class AddressEntryLocalServiceImpl
	extends AddressEntryLocalServiceBaseImpl {

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public AddressEntry addAddress(String detail,
								   String postalCode,
								   String ward,
								   String district,
								   String province,
								   String country,
								   String wardCode,
								   String districtCode,
								   String provinceCode,
								   String countryCode,
								   String title,
								   long customerId,
								   long creatorId,
								   ServiceContext serviceContext) {
		AddressEntry addressEntry = createAddressEntry(counterLocalService.increment(AddressEntry.class.getName()));

		Date currentDate = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				addressEntry,
				currentDate,
				userLocalService.fetchUser(serviceContext.getUserId()),
				serviceContext);

		addressEntry.setDetail(detail);
		addressEntry.setPostalCode(postalCode);
		addressEntry.setWard(ward);
		addressEntry.setDistrict(district);
		addressEntry.setProvince(province);
		addressEntry.setCountry(country);
		addressEntry.setWardCode(wardCode);
		addressEntry.setDistrictCode(districtCode);
		addressEntry.setProvinceCode(provinceCode);
		addressEntry.setCountryCode(countryCode);
		addressEntry.setTitle(title);

		return addAddressEntry(addressEntry);
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public AddressEntry updateAddress(long addAddressId,
									  String detail,
									  String postalCode,
									  String ward,
									  String district,
									  String province,
									  String country,
									  String wardCode,
									  String districtCode,
									  String provinceCode,
									  String countryCode,
									  String title,
									  long creatorId,
									  ServiceContext serviceContext) throws PortalException {
		AddressEntry addressEntry = getAddressEntry(addAddressId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				addressEntry,
				currentDate,
				userLocalService.fetchUser(serviceContext.getUserId()),
				serviceContext);

		addressEntry.setDetail(detail);
		addressEntry.setPostalCode(postalCode);
		addressEntry.setWard(ward);
		addressEntry.setDistrict(district);
		addressEntry.setProvince(province);
		addressEntry.setCountry(country);
		addressEntry.setWardCode(wardCode);
		addressEntry.setDistrictCode(districtCode);
		addressEntry.setProvinceCode(provinceCode);
		addressEntry.setCountryCode(countryCode);
		addressEntry.setTitle(title);

		return updateAddressEntry(addressEntry);
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 AddressEntry addAddressEntry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		addAddressEntry.setCustomerId(customerId);
		addAddressEntry.setGroupId(serviceContext.getScopeGroupId());
		addAddressEntry.setCompanyId(serviceContext.getCompanyId());
		addAddressEntry.setCreateDate(serviceContext.getCreateDate(current));
		addAddressEntry.setExternalReferenceCode(UUID.randomUUID().toString());

		updateModifierAudit(creatorId, addAddressEntry, current, user, serviceContext);
	}

	private void updateModifierAudit(long creatorId,
									 AddressEntry addressEntry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		if (user != null) {
			addressEntry.setUserName(user.getFullName());
			addressEntry.setUserUuid(user.getUserUuid());
		}

		addressEntry.setModifiedDate(serviceContext.getModifiedDate(current));
		addressEntry.setUserId(serviceContext.getUserId());
		addressEntry.setCreatorId(creatorId);
	}
}