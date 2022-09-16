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

package com.dogoo.common.comment.service.service.persistence;

import com.dogoo.common.comment.service.model.EmoticonEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the emoticon entry service. This utility wraps <code>com.dogoo.common.comment.service.service.persistence.impl.EmoticonEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmoticonEntryPersistence
 * @generated
 */
public class EmoticonEntryUtil {

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
	public static void clearCache(EmoticonEntry emoticonEntry) {
		getPersistence().clearCache(emoticonEntry);
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
	public static Map<Serializable, EmoticonEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmoticonEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmoticonEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmoticonEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmoticonEntry update(EmoticonEntry emoticonEntry) {
		return getPersistence().update(emoticonEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmoticonEntry update(
		EmoticonEntry emoticonEntry, ServiceContext serviceContext) {

		return getPersistence().update(emoticonEntry, serviceContext);
	}

	/**
	 * Returns all the emoticon entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the emoticon entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByUuid_First(
			String uuid, OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByUuid_First(
		String uuid, OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByUuid_Last(
			String uuid, OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByUuid_Last(
		String uuid, OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the emoticon entries before and after the current emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param emoticonId the primary key of the current emoticon entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry[] findByUuid_PrevAndNext(
			long emoticonId, String uuid,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			emoticonId, uuid, orderByComparator);
	}

	/**
	 * Removes all the emoticon entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of emoticon entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emoticon entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the emoticon entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the emoticon entry that was removed
	 */
	public static EmoticonEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of emoticon entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching emoticon entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the emoticon entries before and after the current emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param emoticonId the primary key of the current emoticon entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry[] findByUuid_C_PrevAndNext(
			long emoticonId, String uuid, long companyId,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			emoticonId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the emoticon entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emoticon entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching emoticon entries
	 */
	public static List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName) {

		return getPersistence().findByC_C_C(customerId, classPkId, classPkName);
	}

	/**
	 * Returns a range of all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start,
		int end) {

		return getPersistence().findByC_C_C(
			customerId, classPkId, classPkName, start, end);
	}

	/**
	 * Returns an ordered range of all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().findByC_C_C(
			customerId, classPkId, classPkName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emoticon entries
	 */
	public static List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_C_C(
			customerId, classPkId, classPkName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByC_C_C_First(
			long customerId, long classPkId, String classPkName,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByC_C_C_First(
			customerId, classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the first emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByC_C_C_First(
		long customerId, long classPkId, String classPkName,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().fetchByC_C_C_First(
			customerId, classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the last emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByC_C_C_Last(
			long customerId, long classPkId, String classPkName,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByC_C_C_Last(
			customerId, classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the last emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByC_C_C_Last(
		long customerId, long classPkId, String classPkName,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().fetchByC_C_C_Last(
			customerId, classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the emoticon entries before and after the current emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param emoticonId the primary key of the current emoticon entry
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry[] findByC_C_C_PrevAndNext(
			long emoticonId, long customerId, long classPkId,
			String classPkName,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByC_C_C_PrevAndNext(
			emoticonId, customerId, classPkId, classPkName, orderByComparator);
	}

	/**
	 * Removes all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	public static void removeByC_C_C(
		long customerId, long classPkId, String classPkName) {

		getPersistence().removeByC_C_C(customerId, classPkId, classPkName);
	}

	/**
	 * Returns the number of emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching emoticon entries
	 */
	public static int countByC_C_C(
		long customerId, long classPkId, String classPkName) {

		return getPersistence().countByC_C_C(
			customerId, classPkId, classPkName);
	}

	/**
	 * Returns the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByC_C_C_C(
			long customerId, long classPkId, String classPkName, long creatorId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByC_C_C_C(
			customerId, classPkId, classPkName, creatorId);
	}

	/**
	 * Returns the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId) {

		return getPersistence().fetchByC_C_C_C(
			customerId, classPkId, classPkName, creatorId);
	}

	/**
	 * Returns the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId,
		boolean useFinderCache) {

		return getPersistence().fetchByC_C_C_C(
			customerId, classPkId, classPkName, creatorId, useFinderCache);
	}

	/**
	 * Removes the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the emoticon entry that was removed
	 */
	public static EmoticonEntry removeByC_C_C_C(
			long customerId, long classPkId, String classPkName, long creatorId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().removeByC_C_C_C(
			customerId, classPkId, classPkName, creatorId);
	}

	/**
	 * Returns the number of emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the number of matching emoticon entries
	 */
	public static int countByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId) {

		return getPersistence().countByC_C_C_C(
			customerId, classPkId, classPkName, creatorId);
	}

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the emoticon entry that was removed
	 */
	public static EmoticonEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of emoticon entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching emoticon entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the emoticon entry in the entity cache if it is enabled.
	 *
	 * @param emoticonEntry the emoticon entry
	 */
	public static void cacheResult(EmoticonEntry emoticonEntry) {
		getPersistence().cacheResult(emoticonEntry);
	}

	/**
	 * Caches the emoticon entries in the entity cache if it is enabled.
	 *
	 * @param emoticonEntries the emoticon entries
	 */
	public static void cacheResult(List<EmoticonEntry> emoticonEntries) {
		getPersistence().cacheResult(emoticonEntries);
	}

	/**
	 * Creates a new emoticon entry with the primary key. Does not add the emoticon entry to the database.
	 *
	 * @param emoticonId the primary key for the new emoticon entry
	 * @return the new emoticon entry
	 */
	public static EmoticonEntry create(long emoticonId) {
		return getPersistence().create(emoticonId);
	}

	/**
	 * Removes the emoticon entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry that was removed
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry remove(long emoticonId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().remove(emoticonId);
	}

	public static EmoticonEntry updateImpl(EmoticonEntry emoticonEntry) {
		return getPersistence().updateImpl(emoticonEntry);
	}

	/**
	 * Returns the emoticon entry with the primary key or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry findByPrimaryKey(long emoticonId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getPersistence().findByPrimaryKey(emoticonId);
	}

	/**
	 * Returns the emoticon entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry, or <code>null</code> if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry fetchByPrimaryKey(long emoticonId) {
		return getPersistence().fetchByPrimaryKey(emoticonId);
	}

	/**
	 * Returns all the emoticon entries.
	 *
	 * @return the emoticon entries
	 */
	public static List<EmoticonEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of emoticon entries
	 */
	public static List<EmoticonEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emoticon entries
	 */
	public static List<EmoticonEntry> findAll(
		int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of emoticon entries
	 */
	public static List<EmoticonEntry> findAll(
		int start, int end, OrderByComparator<EmoticonEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the emoticon entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of emoticon entries.
	 *
	 * @return the number of emoticon entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmoticonEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EmoticonEntryPersistence _persistence;

}