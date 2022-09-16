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

import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dg file department permission entry service. This utility wraps <code>com.dogoo.common.files.manager.service.service.persistence.impl.DGFileDepartmentPermissionEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileDepartmentPermissionEntryPersistence
 * @generated
 */
public class DGFileDepartmentPermissionEntryUtil {

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
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		getPersistence().clearCache(dgFileDepartmentPermissionEntry);
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
	public static Map<Serializable, DGFileDepartmentPermissionEntry>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DGFileDepartmentPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DGFileDepartmentPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DGFileDepartmentPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DGFileDepartmentPermissionEntry update(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		return getPersistence().update(dgFileDepartmentPermissionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DGFileDepartmentPermissionEntry update(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(
			dgFileDepartmentPermissionEntry, serviceContext);
	}

	/**
	 * Returns all the dg file department permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry[] findByUuid_PrevAndNext(
			long fileDepartmentPermissionId, String uuid,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			fileDepartmentPermissionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dg file department permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByUUID_G(
			String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dg file department permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file department permission entry that was removed
	 */
	public static DGFileDepartmentPermissionEntry removeByUUID_G(
			String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileDepartmentPermissionId, String uuid, long companyId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fileDepartmentPermissionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dg file department permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_D_F(
			long customerId, long departmentId, long fileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_F(customerId, departmentId, fileId);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_F(
		long customerId, long departmentId, long fileId) {

		return getPersistence().fetchByC_D_F(customerId, departmentId, fileId);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_F(
		long customerId, long departmentId, long fileId,
		boolean useFinderCache) {

		return getPersistence().fetchByC_D_F(
			customerId, departmentId, fileId, useFinderCache);
	}

	/**
	 * Removes the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the dg file department permission entry that was removed
	 */
	public static DGFileDepartmentPermissionEntry removeByC_D_F(
			long customerId, long departmentId, long fileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().removeByC_D_F(customerId, departmentId, fileId);
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByC_D_F(
		long customerId, long departmentId, long fileId) {

		return getPersistence().countByC_D_F(customerId, departmentId, fileId);
	}

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @return the matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId) {

		return getPersistence().findByC_D(customerId, departmentId);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end) {

		return getPersistence().findByC_D(customerId, departmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findByC_D(
			customerId, departmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_D(
			customerId, departmentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_D_First(
			long customerId, long departmentId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_First(
			customerId, departmentId, orderByComparator);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_First(
		long customerId, long departmentId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_D_First(
			customerId, departmentId, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_D_Last(
			long customerId, long departmentId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_Last(
			customerId, departmentId, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_Last(
		long customerId, long departmentId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_D_Last(
			customerId, departmentId, orderByComparator);
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry[] findByC_D_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long departmentId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_PrevAndNext(
			fileDepartmentPermissionId, customerId, departmentId,
			orderByComparator);
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and departmentId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 */
	public static void removeByC_D(long customerId, long departmentId) {
		getPersistence().removeByC_D(customerId, departmentId);
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByC_D(long customerId, long departmentId) {
		return getPersistence().countByC_D(customerId, departmentId);
	}

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId) {

		return getPersistence().findByC_F(customerId, fileId);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end) {

		return getPersistence().findByC_F(customerId, fileId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findByC_F(
			customerId, fileId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_F(
			customerId, fileId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_F_First(
			long customerId, long fileId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_F_First(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_F_First(
		long customerId, long fileId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_First(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_F_Last(
			long customerId, long fileId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_F_Last(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_F_Last(
		long customerId, long fileId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_Last(
			customerId, fileId, orderByComparator);
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry[] findByC_F_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long fileId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_F_PrevAndNext(
			fileDepartmentPermissionId, customerId, fileId, orderByComparator);
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 */
	public static void removeByC_F(long customerId, long fileId) {
		getPersistence().removeByC_F(customerId, fileId);
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByC_F(long customerId, long fileId) {
		return getPersistence().countByC_F(customerId, fileId);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_D_F_T(
			long customerId, long departmentId, long fileId, String type)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_F_T(
			customerId, departmentId, fileId, type);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_F_T(
		long customerId, long departmentId, long fileId, String type) {

		return getPersistence().fetchByC_D_F_T(
			customerId, departmentId, fileId, type);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_F_T(
		long customerId, long departmentId, long fileId, String type,
		boolean useFinderCache) {

		return getPersistence().fetchByC_D_F_T(
			customerId, departmentId, fileId, type, useFinderCache);
	}

	/**
	 * Removes the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file department permission entry that was removed
	 */
	public static DGFileDepartmentPermissionEntry removeByC_D_F_T(
			long customerId, long departmentId, long fileId, String type)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().removeByC_D_F_T(
			customerId, departmentId, fileId, type);
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByC_D_F_T(
		long customerId, long departmentId, long fileId, String type) {

		return getPersistence().countByC_D_F_T(
			customerId, departmentId, fileId, type);
	}

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @return the matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type) {

		return getPersistence().findByC_D_T(customerId, departmentId, type);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end) {

		return getPersistence().findByC_D_T(
			customerId, departmentId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findByC_D_T(
			customerId, departmentId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_D_T(
			customerId, departmentId, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_D_T_First(
			long customerId, long departmentId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_T_First(
			customerId, departmentId, type, orderByComparator);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_T_First(
		long customerId, long departmentId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_D_T_First(
			customerId, departmentId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_D_T_Last(
			long customerId, long departmentId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_T_Last(
			customerId, departmentId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_D_T_Last(
		long customerId, long departmentId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_D_T_Last(
			customerId, departmentId, type, orderByComparator);
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry[] findByC_D_T_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long departmentId,
			String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_D_T_PrevAndNext(
			fileDepartmentPermissionId, customerId, departmentId, type,
			orderByComparator);
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 */
	public static void removeByC_D_T(
		long customerId, long departmentId, String type) {

		getPersistence().removeByC_D_T(customerId, departmentId, type);
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByC_D_T(
		long customerId, long departmentId, String type) {

		return getPersistence().countByC_D_T(customerId, departmentId, type);
	}

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type) {

		return getPersistence().findByC_F_T(customerId, fileId, type);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end) {

		return getPersistence().findByC_F_T(
			customerId, fileId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findByC_F_T(
			customerId, fileId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_F_T(
			customerId, fileId, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_F_T_First(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_F_T_First(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_F_T_First(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_T_First(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_F_T_Last(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_F_T_Last(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_F_T_Last(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().fetchByC_F_T_Last(
			customerId, fileId, type, orderByComparator);
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry[] findByC_F_T_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long fileId,
			String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_F_T_PrevAndNext(
			fileDepartmentPermissionId, customerId, fileId, type,
			orderByComparator);
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
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
	 * Returns the number of dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByC_F_T(long customerId, long fileId, String type) {
		return getPersistence().countByC_F_T(customerId, fileId, type);
	}

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file department permission entry that was removed
	 */
	public static DGFileDepartmentPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of dg file department permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file department permission entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the dg file department permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileDepartmentPermissionEntry the dg file department permission entry
	 */
	public static void cacheResult(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		getPersistence().cacheResult(dgFileDepartmentPermissionEntry);
	}

	/**
	 * Caches the dg file department permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileDepartmentPermissionEntries the dg file department permission entries
	 */
	public static void cacheResult(
		List<DGFileDepartmentPermissionEntry>
			dgFileDepartmentPermissionEntries) {

		getPersistence().cacheResult(dgFileDepartmentPermissionEntries);
	}

	/**
	 * Creates a new dg file department permission entry with the primary key. Does not add the dg file department permission entry to the database.
	 *
	 * @param fileDepartmentPermissionId the primary key for the new dg file department permission entry
	 * @return the new dg file department permission entry
	 */
	public static DGFileDepartmentPermissionEntry create(
		long fileDepartmentPermissionId) {

		return getPersistence().create(fileDepartmentPermissionId);
	}

	/**
	 * Removes the dg file department permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry that was removed
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry remove(
			long fileDepartmentPermissionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().remove(fileDepartmentPermissionId);
	}

	public static DGFileDepartmentPermissionEntry updateImpl(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		return getPersistence().updateImpl(dgFileDepartmentPermissionEntry);
	}

	/**
	 * Returns the dg file department permission entry with the primary key or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry findByPrimaryKey(
			long fileDepartmentPermissionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		return getPersistence().findByPrimaryKey(fileDepartmentPermissionId);
	}

	/**
	 * Returns the dg file department permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry, or <code>null</code> if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry fetchByPrimaryKey(
		long fileDepartmentPermissionId) {

		return getPersistence().fetchByPrimaryKey(fileDepartmentPermissionId);
	}

	/**
	 * Returns all the dg file department permission entries.
	 *
	 * @return the dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dg file department permission entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dg file department permission entries.
	 *
	 * @return the number of dg file department permission entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DGFileDepartmentPermissionEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DGFileDepartmentPermissionEntryPersistence
		_persistence;

}