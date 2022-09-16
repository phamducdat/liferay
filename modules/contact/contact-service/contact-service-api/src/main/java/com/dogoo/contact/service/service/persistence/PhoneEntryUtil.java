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

package com.dogoo.contact.service.service.persistence;

import com.dogoo.contact.service.model.PhoneEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the phone entry service. This utility wraps <code>com.dogoo.contact.service.service.persistence.impl.PhoneEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhoneEntryPersistence
 * @generated
 */
public class PhoneEntryUtil {

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
	public static void clearCache(PhoneEntry phoneEntry) {
		getPersistence().clearCache(phoneEntry);
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
	public static Map<Serializable, PhoneEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhoneEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhoneEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhoneEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhoneEntry update(PhoneEntry phoneEntry) {
		return getPersistence().update(phoneEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhoneEntry update(
		PhoneEntry phoneEntry, ServiceContext serviceContext) {

		return getPersistence().update(phoneEntry, serviceContext);
	}

	/**
	 * Returns all the phone entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching phone entries
	 */
	public static List<PhoneEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	public static List<PhoneEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	public static List<PhoneEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	public static List<PhoneEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByUuid_First(
			String uuid, OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByUuid_First(
		String uuid, OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByUuid_Last(
			String uuid, OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByUuid_Last(
		String uuid, OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public static PhoneEntry[] findByUuid_PrevAndNext(
			long phoneId, String uuid,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			phoneId, uuid, orderByComparator);
	}

	/**
	 * Removes all the phone entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of phone entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching phone entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the phone entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the phone entry that was removed
	 */
	public static PhoneEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of phone entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching phone entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching phone entries
	 */
	public static List<PhoneEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	public static List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	public static List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	public static List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public static PhoneEntry[] findByUuid_C_PrevAndNext(
			long phoneId, String uuid, long companyId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			phoneId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the phone entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching phone entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the matching phone entries
	 */
	public static List<PhoneEntry> findByC_C(long customerId, long contactId) {
		return getPersistence().findByC_C(customerId, contactId);
	}

	/**
	 * Returns a range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	public static List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end) {

		return getPersistence().findByC_C(customerId, contactId, start, end);
	}

	/**
	 * Returns an ordered range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	public static List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().findByC_C(
			customerId, contactId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	public static List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_C(
			customerId, contactId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByC_C_First(
			long customerId, long contactId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByC_C_First(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the first phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_C_First(
		long customerId, long contactId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().fetchByC_C_First(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the last phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByC_C_Last(
			long customerId, long contactId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByC_C_Last(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the last phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_C_Last(
		long customerId, long contactId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().fetchByC_C_Last(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public static PhoneEntry[] findByC_C_PrevAndNext(
			long phoneId, long customerId, long contactId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByC_C_PrevAndNext(
			phoneId, customerId, contactId, orderByComparator);
	}

	/**
	 * Removes all the phone entries where customerId = &#63; and contactId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 */
	public static void removeByC_C(long customerId, long contactId) {
		getPersistence().removeByC_C(customerId, contactId);
	}

	/**
	 * Returns the number of phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the number of matching phone entries
	 */
	public static int countByC_C(long customerId, long contactId) {
		return getPersistence().countByC_C(customerId, contactId);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByC_N(long customerId, String number)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByC_N(customerId, number);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_N(long customerId, String number) {
		return getPersistence().fetchByC_N(customerId, number);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_N(
		long customerId, String number, boolean useFinderCache) {

		return getPersistence().fetchByC_N(customerId, number, useFinderCache);
	}

	/**
	 * Removes the phone entry where customerId = &#63; and number = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the phone entry that was removed
	 */
	public static PhoneEntry removeByC_N(long customerId, String number)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().removeByC_N(customerId, number);
	}

	/**
	 * Returns the number of phone entries where customerId = &#63; and number = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the number of matching phone entries
	 */
	public static int countByC_N(long customerId, String number) {
		return getPersistence().countByC_N(customerId, number);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByC_I(long customerId, boolean isDefaulted)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_I(long customerId, boolean isDefaulted) {
		return getPersistence().fetchByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_I(
		long customerId, boolean isDefaulted, boolean useFinderCache) {

		return getPersistence().fetchByC_I(
			customerId, isDefaulted, useFinderCache);
	}

	/**
	 * Removes the phone entry where customerId = &#63; and isDefaulted = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the phone entry that was removed
	 */
	public static PhoneEntry removeByC_I(long customerId, boolean isDefaulted)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().removeByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the number of phone entries where customerId = &#63; and isDefaulted = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the number of matching phone entries
	 */
	public static int countByC_I(long customerId, boolean isDefaulted) {
		return getPersistence().countByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public static PhoneEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the phone entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the phone entry that was removed
	 */
	public static PhoneEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of phone entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching phone entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the phone entry in the entity cache if it is enabled.
	 *
	 * @param phoneEntry the phone entry
	 */
	public static void cacheResult(PhoneEntry phoneEntry) {
		getPersistence().cacheResult(phoneEntry);
	}

	/**
	 * Caches the phone entries in the entity cache if it is enabled.
	 *
	 * @param phoneEntries the phone entries
	 */
	public static void cacheResult(List<PhoneEntry> phoneEntries) {
		getPersistence().cacheResult(phoneEntries);
	}

	/**
	 * Creates a new phone entry with the primary key. Does not add the phone entry to the database.
	 *
	 * @param phoneId the primary key for the new phone entry
	 * @return the new phone entry
	 */
	public static PhoneEntry create(long phoneId) {
		return getPersistence().create(phoneId);
	}

	/**
	 * Removes the phone entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry that was removed
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public static PhoneEntry remove(long phoneId)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().remove(phoneId);
	}

	public static PhoneEntry updateImpl(PhoneEntry phoneEntry) {
		return getPersistence().updateImpl(phoneEntry);
	}

	/**
	 * Returns the phone entry with the primary key or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public static PhoneEntry findByPrimaryKey(long phoneId)
		throws com.dogoo.contact.service.exception.NoSuchPhoneEntryException {

		return getPersistence().findByPrimaryKey(phoneId);
	}

	/**
	 * Returns the phone entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry, or <code>null</code> if a phone entry with the primary key could not be found
	 */
	public static PhoneEntry fetchByPrimaryKey(long phoneId) {
		return getPersistence().fetchByPrimaryKey(phoneId);
	}

	/**
	 * Returns all the phone entries.
	 *
	 * @return the phone entries
	 */
	public static List<PhoneEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of phone entries
	 */
	public static List<PhoneEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phone entries
	 */
	public static List<PhoneEntry> findAll(
		int start, int end, OrderByComparator<PhoneEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phone entries
	 */
	public static List<PhoneEntry> findAll(
		int start, int end, OrderByComparator<PhoneEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the phone entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phone entries.
	 *
	 * @return the number of phone entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhoneEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PhoneEntryPersistence _persistence;

}