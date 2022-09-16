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

import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dg file version entry service. This utility wraps <code>com.dogoo.common.files.manager.service.service.persistence.impl.DGFileVersionEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileVersionEntryPersistence
 * @generated
 */
public class DGFileVersionEntryUtil {

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
	public static void clearCache(DGFileVersionEntry dgFileVersionEntry) {
		getPersistence().clearCache(dgFileVersionEntry);
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
	public static Map<Serializable, DGFileVersionEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DGFileVersionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DGFileVersionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DGFileVersionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DGFileVersionEntry update(
		DGFileVersionEntry dgFileVersionEntry) {

		return getPersistence().update(dgFileVersionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DGFileVersionEntry update(
		DGFileVersionEntry dgFileVersionEntry, ServiceContext serviceContext) {

		return getPersistence().update(dgFileVersionEntry, serviceContext);
	}

	/**
	 * Returns all the dg file version entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByUuid_First(
		String uuid, OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dg file version entries before and after the current dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileVersionId the primary key of the current dg file version entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public static DGFileVersionEntry[] findByUuid_PrevAndNext(
			long fileVersionId, String uuid,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			fileVersionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dg file version entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dg file version entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file version entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dg file version entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file version entry that was removed
	 */
	public static DGFileVersionEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dg file version entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file version entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file version entries
	 */
	public static List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dg file version entries before and after the current dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileVersionId the primary key of the current dg file version entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public static DGFileVersionEntry[] findByUuid_C_PrevAndNext(
			long fileVersionId, String uuid, long companyId,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fileVersionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dg file version entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file version entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry findByC_FV(
			long customerId, long fileVersionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByC_FV(customerId, fileVersionId);
	}

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByC_FV(
		long customerId, long fileVersionId) {

		return getPersistence().fetchByC_FV(customerId, fileVersionId);
	}

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByC_FV(
		long customerId, long fileVersionId, boolean useFinderCache) {

		return getPersistence().fetchByC_FV(
			customerId, fileVersionId, useFinderCache);
	}

	/**
	 * Removes the dg file version entry where customerId = &#63; and fileVersionId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the dg file version entry that was removed
	 */
	public static DGFileVersionEntry removeByC_FV(
			long customerId, long fileVersionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().removeByC_FV(customerId, fileVersionId);
	}

	/**
	 * Returns the number of dg file version entries where customerId = &#63; and fileVersionId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the number of matching dg file version entries
	 */
	public static int countByC_FV(long customerId, long fileVersionId) {
		return getPersistence().countByC_FV(customerId, fileVersionId);
	}

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file version entry that was removed
	 */
	public static DGFileVersionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of dg file version entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file version entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the dg file version entry in the entity cache if it is enabled.
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 */
	public static void cacheResult(DGFileVersionEntry dgFileVersionEntry) {
		getPersistence().cacheResult(dgFileVersionEntry);
	}

	/**
	 * Caches the dg file version entries in the entity cache if it is enabled.
	 *
	 * @param dgFileVersionEntries the dg file version entries
	 */
	public static void cacheResult(
		List<DGFileVersionEntry> dgFileVersionEntries) {

		getPersistence().cacheResult(dgFileVersionEntries);
	}

	/**
	 * Creates a new dg file version entry with the primary key. Does not add the dg file version entry to the database.
	 *
	 * @param fileVersionId the primary key for the new dg file version entry
	 * @return the new dg file version entry
	 */
	public static DGFileVersionEntry create(long fileVersionId) {
		return getPersistence().create(fileVersionId);
	}

	/**
	 * Removes the dg file version entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry that was removed
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public static DGFileVersionEntry remove(long fileVersionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().remove(fileVersionId);
	}

	public static DGFileVersionEntry updateImpl(
		DGFileVersionEntry dgFileVersionEntry) {

		return getPersistence().updateImpl(dgFileVersionEntry);
	}

	/**
	 * Returns the dg file version entry with the primary key or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public static DGFileVersionEntry findByPrimaryKey(long fileVersionId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileVersionEntryException {

		return getPersistence().findByPrimaryKey(fileVersionId);
	}

	/**
	 * Returns the dg file version entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry, or <code>null</code> if a dg file version entry with the primary key could not be found
	 */
	public static DGFileVersionEntry fetchByPrimaryKey(long fileVersionId) {
		return getPersistence().fetchByPrimaryKey(fileVersionId);
	}

	/**
	 * Returns all the dg file version entries.
	 *
	 * @return the dg file version entries
	 */
	public static List<DGFileVersionEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of dg file version entries
	 */
	public static List<DGFileVersionEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file version entries
	 */
	public static List<DGFileVersionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file version entries
	 */
	public static List<DGFileVersionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dg file version entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dg file version entries.
	 *
	 * @return the number of dg file version entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DGFileVersionEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DGFileVersionEntryPersistence _persistence;

}