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

import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dg file manager entry service. This utility wraps <code>com.dogoo.common.files.manager.service.service.persistence.impl.DGFileManagerEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileManagerEntryPersistence
 * @generated
 */
public class DGFileManagerEntryUtil {

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
	public static void clearCache(DGFileManagerEntry dgFileManagerEntry) {
		getPersistence().clearCache(dgFileManagerEntry);
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
	public static Map<Serializable, DGFileManagerEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DGFileManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DGFileManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DGFileManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DGFileManagerEntry update(
		DGFileManagerEntry dgFileManagerEntry) {

		return getPersistence().update(dgFileManagerEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DGFileManagerEntry update(
		DGFileManagerEntry dgFileManagerEntry, ServiceContext serviceContext) {

		return getPersistence().update(dgFileManagerEntry, serviceContext);
	}

	/**
	 * Returns all the dg file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByUuid_First(
		String uuid, OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dg file manager entries before and after the current dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileManagerId the primary key of the current dg file manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public static DGFileManagerEntry[] findByUuid_PrevAndNext(
			long fileManagerId, String uuid,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			fileManagerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dg file manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dg file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file manager entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dg file manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file manager entry that was removed
	 */
	public static DGFileManagerEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dg file manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file manager entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file manager entries
	 */
	public static List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dg file manager entries before and after the current dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileManagerId the primary key of the current dg file manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public static DGFileManagerEntry[] findByUuid_C_PrevAndNext(
			long fileManagerId, String uuid, long companyId,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fileManagerId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dg file manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file manager entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry findByF_C(long fileId, long customerId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByF_C(fileId, customerId);
	}

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByF_C(long fileId, long customerId) {
		return getPersistence().fetchByF_C(fileId, customerId);
	}

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByF_C(
		long fileId, long customerId, boolean useFinderCache) {

		return getPersistence().fetchByF_C(fileId, customerId, useFinderCache);
	}

	/**
	 * Removes the dg file manager entry where fileId = &#63; and customerId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the dg file manager entry that was removed
	 */
	public static DGFileManagerEntry removeByF_C(long fileId, long customerId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().removeByF_C(fileId, customerId);
	}

	/**
	 * Returns the number of dg file manager entries where fileId = &#63; and customerId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the number of matching dg file manager entries
	 */
	public static int countByF_C(long fileId, long customerId) {
		return getPersistence().countByF_C(fileId, customerId);
	}

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file manager entry that was removed
	 */
	public static DGFileManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of dg file manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file manager entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the dg file manager entry in the entity cache if it is enabled.
	 *
	 * @param dgFileManagerEntry the dg file manager entry
	 */
	public static void cacheResult(DGFileManagerEntry dgFileManagerEntry) {
		getPersistence().cacheResult(dgFileManagerEntry);
	}

	/**
	 * Caches the dg file manager entries in the entity cache if it is enabled.
	 *
	 * @param dgFileManagerEntries the dg file manager entries
	 */
	public static void cacheResult(
		List<DGFileManagerEntry> dgFileManagerEntries) {

		getPersistence().cacheResult(dgFileManagerEntries);
	}

	/**
	 * Creates a new dg file manager entry with the primary key. Does not add the dg file manager entry to the database.
	 *
	 * @param fileManagerId the primary key for the new dg file manager entry
	 * @return the new dg file manager entry
	 */
	public static DGFileManagerEntry create(long fileManagerId) {
		return getPersistence().create(fileManagerId);
	}

	/**
	 * Removes the dg file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry that was removed
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public static DGFileManagerEntry remove(long fileManagerId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().remove(fileManagerId);
	}

	public static DGFileManagerEntry updateImpl(
		DGFileManagerEntry dgFileManagerEntry) {

		return getPersistence().updateImpl(dgFileManagerEntry);
	}

	/**
	 * Returns the dg file manager entry with the primary key or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public static DGFileManagerEntry findByPrimaryKey(long fileManagerId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getPersistence().findByPrimaryKey(fileManagerId);
	}

	/**
	 * Returns the dg file manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry, or <code>null</code> if a dg file manager entry with the primary key could not be found
	 */
	public static DGFileManagerEntry fetchByPrimaryKey(long fileManagerId) {
		return getPersistence().fetchByPrimaryKey(fileManagerId);
	}

	/**
	 * Returns all the dg file manager entries.
	 *
	 * @return the dg file manager entries
	 */
	public static List<DGFileManagerEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of dg file manager entries
	 */
	public static List<DGFileManagerEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file manager entries
	 */
	public static List<DGFileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file manager entries
	 */
	public static List<DGFileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dg file manager entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dg file manager entries.
	 *
	 * @return the number of dg file manager entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DGFileManagerEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DGFileManagerEntryPersistence _persistence;

}