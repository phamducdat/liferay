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

package com.dogoo.address.service.service.persistence;

import com.dogoo.address.service.model.AddressEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the address entry service. This utility wraps <code>com.dogoo.address.service.service.persistence.impl.AddressEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressEntryPersistence
 * @generated
 */
public class AddressEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AddressEntry addressEntry) {
		getPersistence().clearCache(addressEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AddressEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AddressEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AddressEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AddressEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AddressEntry update(AddressEntry addressEntry) {
		return getPersistence().update(addressEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AddressEntry update(
		AddressEntry addressEntry, ServiceContext serviceContext) {

		return getPersistence().update(addressEntry, serviceContext);
	}

	/**
	 * Returns all the address entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching address entries
	 */
	public static List<AddressEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the address entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @return the range of matching address entries
	 */
	public static List<AddressEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address entries
	 */
	public static List<AddressEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching address entries
	 */
	public static List<AddressEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AddressEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public static AddressEntry findByUuid_First(
			String uuid, OrderByComparator<AddressEntry> orderByComparator)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByUuid_First(
		String uuid, OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public static AddressEntry findByUuid_Last(
			String uuid, OrderByComparator<AddressEntry> orderByComparator)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the address entries before and after the current address entry in the ordered set where uuid = &#63;.
	 *
	 * @param addressId the primary key of the current address entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address entry
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public static AddressEntry[] findByUuid_PrevAndNext(
			long addressId, String uuid,
			OrderByComparator<AddressEntry> orderByComparator)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			addressId, uuid, orderByComparator);
	}

	/**
	 * Removes all the address entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of address entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching address entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the address entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAddressEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public static AddressEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the address entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the address entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the address entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the address entry that was removed
	 */
	public static AddressEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of address entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching address entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching address entries
	 */
	public static List<AddressEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @return the range of matching address entries
	 */
	public static List<AddressEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address entries
	 */
	public static List<AddressEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching address entries
	 */
	public static List<AddressEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AddressEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public static AddressEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AddressEntry> orderByComparator)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public static AddressEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AddressEntry> orderByComparator)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the address entries before and after the current address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param addressId the primary key of the current address entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address entry
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public static AddressEntry[] findByUuid_C_PrevAndNext(
			long addressId, String uuid, long companyId,
			OrderByComparator<AddressEntry> orderByComparator)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			addressId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the address entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching address entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the address entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAddressEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public static AddressEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the address entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the address entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the address entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the address entry that was removed
	 */
	public static AddressEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of address entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching address entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the address entry in the entity cache if it is enabled.
	 *
	 * @param addressEntry the address entry
	 */
	public static void cacheResult(AddressEntry addressEntry) {
		getPersistence().cacheResult(addressEntry);
	}

	/**
	 * Caches the address entries in the entity cache if it is enabled.
	 *
	 * @param addressEntries the address entries
	 */
	public static void cacheResult(List<AddressEntry> addressEntries) {
		getPersistence().cacheResult(addressEntries);
	}

	/**
	 * Creates a new address entry with the primary key. Does not add the address entry to the database.
	 *
	 * @param addressId the primary key for the new address entry
	 * @return the new address entry
	 */
	public static AddressEntry create(long addressId) {
		return getPersistence().create(addressId);
	}

	/**
	 * Removes the address entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry that was removed
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public static AddressEntry remove(long addressId)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().remove(addressId);
	}

	public static AddressEntry updateImpl(AddressEntry addressEntry) {
		return getPersistence().updateImpl(addressEntry);
	}

	/**
	 * Returns the address entry with the primary key or throws a <code>NoSuchAddressEntryException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public static AddressEntry findByPrimaryKey(long addressId)
		throws com.dogoo.address.service.exception.NoSuchAddressEntryException {

		return getPersistence().findByPrimaryKey(addressId);
	}

	/**
	 * Returns the address entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry, or <code>null</code> if a address entry with the primary key could not be found
	 */
	public static AddressEntry fetchByPrimaryKey(long addressId) {
		return getPersistence().fetchByPrimaryKey(addressId);
	}

	/**
	 * Returns all the address entries.
	 *
	 * @return the address entries
	 */
	public static List<AddressEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the address entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @return the range of address entries
	 */
	public static List<AddressEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the address entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address entries
	 */
	public static List<AddressEntry> findAll(
		int start, int end, OrderByComparator<AddressEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the address entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of address entries
	 */
	public static List<AddressEntry> findAll(
		int start, int end, OrderByComparator<AddressEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the address entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of address entries.
	 *
	 * @return the number of address entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AddressEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AddressEntryPersistence _persistence;

}