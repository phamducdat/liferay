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

package com.dogoo.common.files.manager.service.service.persistence;

import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dg file user permission entry service. This utility wraps <code>com.dogoo.common.files.manager.service.service.persistence.impl.DGFileUserPermissionEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileUserPermissionEntryPersistence
 * @generated
 */
public class DGFileUserPermissionEntryUtil {

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
	public static void clearCache(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		getPersistence().clearCache(dgFileUserPermissionEntry);
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
	public static Map<Serializable, DGFileUserPermissionEntry>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DGFileUserPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DGFileUserPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DGFileUserPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DGFileUserPermissionEntry update(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return getPersistence().update(dgFileUserPermissionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DGFileUserPermissionEntry update(
		DGFileUserPermissionEntry dgFileUserPermissionEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(
			dgFileUserPermissionEntry, serviceContext);
	}

	/**
	 * Returns all the dg file user permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByUuid_PrevAndNext(
			long fileUserPermissionId, String uuid,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			fileUserPermissionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByUUID_G(
			String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dg file user permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file user permission entry that was removed
	 */
	public static DGFileUserPermissionEntry removeByUUID_G(
			String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileUserPermissionId, String uuid, long companyId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fileUserPermissionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_F(
			long customerId, long userAllowedId, long fileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_F(customerId, userAllowedId, fileId);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_F(
		long customerId, long userAllowedId, long fileId) {

		return getPersistence().fetchByC_U_F(customerId, userAllowedId, fileId);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_F(
		long customerId, long userAllowedId, long fileId,
		boolean useFinderCache) {

		return getPersistence().fetchByC_U_F(
			customerId, userAllowedId, fileId, useFinderCache);
	}

	/**
	 * Removes the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the dg file user permission entry that was removed
	 */
	public static DGFileUserPermissionEntry removeByC_U_F(
			long customerId, long userAllowedId, long fileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().removeByC_U_F(
			customerId, userAllowedId, fileId);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_U_F(
		long customerId, long userAllowedId, long fileId) {

		return getPersistence().countByC_U_F(customerId, userAllowedId, fileId);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId) {

		return getPersistence().findByC_U(customerId, userAllowedId);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end) {

		return getPersistence().findByC_U(
			customerId, userAllowedId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_U(
			customerId, userAllowedId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U(
			customerId, userAllowedId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_First(
			long customerId, long userAllowedId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_First(
			customerId, userAllowedId, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_First(
		long customerId, long userAllowedId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_First(
			customerId, userAllowedId, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_Last(
			long customerId, long userAllowedId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_Last(
			customerId, userAllowedId, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_Last(
		long customerId, long userAllowedId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_Last(
			customerId, userAllowedId, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_U_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_PrevAndNext(
			fileUserPermissionId, customerId, userAllowedId, orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 */
	public static void removeByC_U(long customerId, long userAllowedId) {
		getPersistence().removeByC_U(customerId, userAllowedId);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_U(long customerId, long userAllowedId) {
		return getPersistence().countByC_U(customerId, userAllowedId);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status) {

		return getPersistence().findByC_U_S(customerId, userAllowedId, status);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start,
		int end) {

		return getPersistence().findByC_U_S(
			customerId, userAllowedId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_U_S(
			customerId, userAllowedId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			customerId, userAllowedId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_S_First(
			long customerId, long userAllowedId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_S_First(
			customerId, userAllowedId, status, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_S_First(
		long customerId, long userAllowedId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_First(
			customerId, userAllowedId, status, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_S_Last(
			long customerId, long userAllowedId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_S_Last(
			customerId, userAllowedId, status, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_S_Last(
		long customerId, long userAllowedId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_Last(
			customerId, userAllowedId, status, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_U_S_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_S_PrevAndNext(
			fileUserPermissionId, customerId, userAllowedId, status,
			orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 */
	public static void removeByC_U_S(
		long customerId, long userAllowedId, String status) {

		getPersistence().removeByC_U_S(customerId, userAllowedId, status);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_U_S(
		long customerId, long userAllowedId, String status) {

		return getPersistence().countByC_U_S(customerId, userAllowedId, status);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId) {

		return getPersistence().findByC_F(customerId, fileId);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end) {

		return getPersistence().findByC_F(customerId, fileId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_F(
			customerId, fileId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_F(
			customerId, fileId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_First(
			long customerId, long fileId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_First(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_First(
		long customerId, long fileId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_First(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_Last(
			long customerId, long fileId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_Last(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_Last(
		long customerId, long fileId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_Last(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_F_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_PrevAndNext(
			fileUserPermissionId, customerId, fileId, orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 */
	public static void removeByC_F(long customerId, long fileId) {
		getPersistence().removeByC_F(customerId, fileId);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_F(long customerId, long fileId) {
		return getPersistence().countByC_F(customerId, fileId);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status) {

		return getPersistence().findByC_F_S(customerId, fileId, status);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end) {

		return getPersistence().findByC_F_S(
			customerId, fileId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_F_S(
			customerId, fileId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_F_S(
			customerId, fileId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_S_First(
			long customerId, long fileId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_S_First(
			customerId, fileId, status, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_S_First(
		long customerId, long fileId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_S_First(
			customerId, fileId, status, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_S_Last(
			long customerId, long fileId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_S_Last(
			customerId, fileId, status, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_S_Last(
		long customerId, long fileId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_S_Last(
			customerId, fileId, status, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_F_S_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_S_PrevAndNext(
			fileUserPermissionId, customerId, fileId, status,
			orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 */
	public static void removeByC_F_S(
		long customerId, long fileId, String status) {

		getPersistence().removeByC_F_S(customerId, fileId, status);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_F_S(
		long customerId, long fileId, String status) {

		return getPersistence().countByC_F_S(customerId, fileId, status);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_F_T(
			long customerId, long userAllowedId, long fileId, String type)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_F_T(
			customerId, userAllowedId, fileId, type);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type) {

		return getPersistence().fetchByC_U_F_T(
			customerId, userAllowedId, fileId, type);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type,
		boolean useFinderCache) {

		return getPersistence().fetchByC_U_F_T(
			customerId, userAllowedId, fileId, type, useFinderCache);
	}

	/**
	 * Removes the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file user permission entry that was removed
	 */
	public static DGFileUserPermissionEntry removeByC_U_F_T(
			long customerId, long userAllowedId, long fileId, String type)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().removeByC_U_F_T(
			customerId, userAllowedId, fileId, type);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type) {

		return getPersistence().countByC_U_F_T(
			customerId, userAllowedId, fileId, type);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type) {

		return getPersistence().findByC_U_T(customerId, userAllowedId, type);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end) {

		return getPersistence().findByC_U_T(
			customerId, userAllowedId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_U_T(
			customerId, userAllowedId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_T(
			customerId, userAllowedId, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_T_First(
			long customerId, long userAllowedId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_T_First(
			customerId, userAllowedId, type, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_T_First(
		long customerId, long userAllowedId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_T_First(
			customerId, userAllowedId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_T_Last(
			long customerId, long userAllowedId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_T_Last(
			customerId, userAllowedId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_T_Last(
		long customerId, long userAllowedId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_T_Last(
			customerId, userAllowedId, type, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_U_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_T_PrevAndNext(
			fileUserPermissionId, customerId, userAllowedId, type,
			orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 */
	public static void removeByC_U_T(
		long customerId, long userAllowedId, String type) {

		getPersistence().removeByC_U_T(customerId, userAllowedId, type);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_U_T(
		long customerId, long userAllowedId, String type) {

		return getPersistence().countByC_U_T(customerId, userAllowedId, type);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type) {

		return getPersistence().findByC_U_S_T(
			customerId, userAllowedId, status, type);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end) {

		return getPersistence().findByC_U_S_T(
			customerId, userAllowedId, status, type, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_U_S_T(
			customerId, userAllowedId, status, type, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_U_S_T(
			customerId, userAllowedId, status, type, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_S_T_First(
			long customerId, long userAllowedId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_S_T_First(
			customerId, userAllowedId, status, type, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_S_T_First(
		long customerId, long userAllowedId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_T_First(
			customerId, userAllowedId, status, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_U_S_T_Last(
			long customerId, long userAllowedId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_S_T_Last(
			customerId, userAllowedId, status, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_U_S_T_Last(
		long customerId, long userAllowedId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_U_S_T_Last(
			customerId, userAllowedId, status, type, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_U_S_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_U_S_T_PrevAndNext(
			fileUserPermissionId, customerId, userAllowedId, status, type,
			orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 */
	public static void removeByC_U_S_T(
		long customerId, long userAllowedId, String status, String type) {

		getPersistence().removeByC_U_S_T(
			customerId, userAllowedId, status, type);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_U_S_T(
		long customerId, long userAllowedId, String status, String type) {

		return getPersistence().countByC_U_S_T(
			customerId, userAllowedId, status, type);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type) {

		return getPersistence().findByC_F_T(customerId, fileId, type);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end) {

		return getPersistence().findByC_F_T(
			customerId, fileId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_F_T(
			customerId, fileId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_F_T(
			customerId, fileId, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_T_First(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_T_First(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_T_First(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_T_First(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_T_Last(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_T_Last(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_T_Last(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_T_Last(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_F_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_T_PrevAndNext(
			fileUserPermissionId, customerId, fileId, type, orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 */
	public static void removeByC_F_T(
		long customerId, long fileId, String type) {

		getPersistence().removeByC_F_T(customerId, fileId, type);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_F_T(long customerId, long fileId, String type) {
		return getPersistence().countByC_F_T(customerId, fileId, type);
	}

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type) {

		return getPersistence().findByC_F_S_T(customerId, fileId, status, type);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end) {

		return getPersistence().findByC_F_S_T(
			customerId, fileId, status, type, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findByC_F_S_T(
			customerId, fileId, status, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end, OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_F_S_T(
			customerId, fileId, status, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_S_T_First(
			long customerId, long fileId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_S_T_First(
			customerId, fileId, status, type, orderByComparator);
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_S_T_First(
		long customerId, long fileId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_S_T_First(
			customerId, fileId, status, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_F_S_T_Last(
			long customerId, long fileId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_S_T_Last(
			customerId, fileId, status, type, orderByComparator);
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_F_S_T_Last(
		long customerId, long fileId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_S_T_Last(
			customerId, fileId, status, type, orderByComparator);
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry[] findByC_F_S_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_F_S_T_PrevAndNext(
			fileUserPermissionId, customerId, fileId, status, type,
			orderByComparator);
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 */
	public static void removeByC_F_S_T(
		long customerId, long fileId, String status, String type) {

		getPersistence().removeByC_F_S_T(customerId, fileId, status, type);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_F_S_T(
		long customerId, long fileId, String status, String type) {

		return getPersistence().countByC_F_S_T(
			customerId, fileId, status, type);
	}

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file user permission entry that was removed
	 */
	public static DGFileUserPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of dg file user permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file user permission entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the dg file user permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileUserPermissionEntry the dg file user permission entry
	 */
	public static void cacheResult(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		getPersistence().cacheResult(dgFileUserPermissionEntry);
	}

	/**
	 * Caches the dg file user permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileUserPermissionEntries the dg file user permission entries
	 */
	public static void cacheResult(
		List<DGFileUserPermissionEntry> dgFileUserPermissionEntries) {

		getPersistence().cacheResult(dgFileUserPermissionEntries);
	}

	/**
	 * Creates a new dg file user permission entry with the primary key. Does not add the dg file user permission entry to the database.
	 *
	 * @param fileUserPermissionId the primary key for the new dg file user permission entry
	 * @return the new dg file user permission entry
	 */
	public static DGFileUserPermissionEntry create(long fileUserPermissionId) {
		return getPersistence().create(fileUserPermissionId);
	}

	/**
	 * Removes the dg file user permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry that was removed
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry remove(long fileUserPermissionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().remove(fileUserPermissionId);
	}

	public static DGFileUserPermissionEntry updateImpl(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return getPersistence().updateImpl(dgFileUserPermissionEntry);
	}

	/**
	 * Returns the dg file user permission entry with the primary key or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry findByPrimaryKey(
			long fileUserPermissionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileUserPermissionEntryException {

		return getPersistence().findByPrimaryKey(fileUserPermissionId);
	}

	/**
	 * Returns the dg file user permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry, or <code>null</code> if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry fetchByPrimaryKey(
		long fileUserPermissionId) {

		return getPersistence().fetchByPrimaryKey(fileUserPermissionId);
	}

	/**
	 * Returns all the dg file user permission entries.
	 *
	 * @return the dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dg file user permission entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dg file user permission entries.
	 *
	 * @return the number of dg file user permission entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DGFileUserPermissionEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DGFileUserPermissionEntryPersistence _persistence;

}