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

package com.dogoo.dataitems.service.service.persistence;

import com.dogoo.dataitems.service.model.DataItemEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the data item entry service. This utility wraps <code>com.dogoo.dataitems.service.service.persistence.impl.DataItemEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nghiatt
 * @see DataItemEntryPersistence
 * @generated
 */
public class DataItemEntryUtil {

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
	public static void clearCache(DataItemEntry dataItemEntry) {
		getPersistence().clearCache(dataItemEntry);
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
	public static Map<Serializable, DataItemEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataItemEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataItemEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataItemEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataItemEntry update(DataItemEntry dataItemEntry) {
		return getPersistence().update(dataItemEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataItemEntry update(
		DataItemEntry dataItemEntry, ServiceContext serviceContext) {

		return getPersistence().update(dataItemEntry, serviceContext);
	}

	/**
	 * Returns all the data item entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data item entries
	 */
	public static List<DataItemEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	public static List<DataItemEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	public static List<DataItemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	public static List<DataItemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByUuid_First(
			String uuid, OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByUuid_First(
		String uuid, OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByUuid_Last(
			String uuid, OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public static DataItemEntry[] findByUuid_PrevAndNext(
			long dataItemId, String uuid,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			dataItemId, uuid, orderByComparator);
	}

	/**
	 * Removes all the data item entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of data item entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data item entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the data item entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data item entry that was removed
	 */
	public static DataItemEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of data item entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data item entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data item entries
	 */
	public static List<DataItemEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	public static List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	public static List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	public static List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public static DataItemEntry[] findByUuid_C_PrevAndNext(
			long dataItemId, String uuid, long companyId,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dataItemId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the data item entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data item entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the matching data item entries
	 */
	public static List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type) {

		return getPersistence().findByC_P_T(customerId, parentId, type);
	}

	/**
	 * Returns a range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	public static List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end) {

		return getPersistence().findByC_P_T(
			customerId, parentId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	public static List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().findByC_P_T(
			customerId, parentId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	public static List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_P_T(
			customerId, parentId, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByC_P_T_First(
			long customerId, long parentId, String type,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByC_P_T_First(
			customerId, parentId, type, orderByComparator);
	}

	/**
	 * Returns the first data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByC_P_T_First(
		long customerId, long parentId, String type,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().fetchByC_P_T_First(
			customerId, parentId, type, orderByComparator);
	}

	/**
	 * Returns the last data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByC_P_T_Last(
			long customerId, long parentId, String type,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByC_P_T_Last(
			customerId, parentId, type, orderByComparator);
	}

	/**
	 * Returns the last data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByC_P_T_Last(
		long customerId, long parentId, String type,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().fetchByC_P_T_Last(
			customerId, parentId, type, orderByComparator);
	}

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public static DataItemEntry[] findByC_P_T_PrevAndNext(
			long dataItemId, long customerId, long parentId, String type,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByC_P_T_PrevAndNext(
			dataItemId, customerId, parentId, type, orderByComparator);
	}

	/**
	 * Removes all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 */
	public static void removeByC_P_T(
		long customerId, long parentId, String type) {

		getPersistence().removeByC_P_T(customerId, parentId, type);
	}

	/**
	 * Returns the number of data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the number of matching data item entries
	 */
	public static int countByC_P_T(
		long customerId, long parentId, String type) {

		return getPersistence().countByC_P_T(customerId, parentId, type);
	}

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByC_P_N_T(
			long customerId, long parentId, String name, String type)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByC_P_N_T(customerId, parentId, name, type);
	}

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByC_P_N_T(
		long customerId, long parentId, String name, String type) {

		return getPersistence().fetchByC_P_N_T(
			customerId, parentId, name, type);
	}

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByC_P_N_T(
		long customerId, long parentId, String name, String type,
		boolean useFinderCache) {

		return getPersistence().fetchByC_P_N_T(
			customerId, parentId, name, type, useFinderCache);
	}

	/**
	 * Removes the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the data item entry that was removed
	 */
	public static DataItemEntry removeByC_P_N_T(
			long customerId, long parentId, String name, String type)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().removeByC_P_N_T(
			customerId, parentId, name, type);
	}

	/**
	 * Returns the number of data item entries where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the number of matching data item entries
	 */
	public static int countByC_P_N_T(
		long customerId, long parentId, String name, String type) {

		return getPersistence().countByC_P_N_T(
			customerId, parentId, name, type);
	}

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public static DataItemEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the data item entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the data item entry that was removed
	 */
	public static DataItemEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of data item entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching data item entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the data item entry in the entity cache if it is enabled.
	 *
	 * @param dataItemEntry the data item entry
	 */
	public static void cacheResult(DataItemEntry dataItemEntry) {
		getPersistence().cacheResult(dataItemEntry);
	}

	/**
	 * Caches the data item entries in the entity cache if it is enabled.
	 *
	 * @param dataItemEntries the data item entries
	 */
	public static void cacheResult(List<DataItemEntry> dataItemEntries) {
		getPersistence().cacheResult(dataItemEntries);
	}

	/**
	 * Creates a new data item entry with the primary key. Does not add the data item entry to the database.
	 *
	 * @param dataItemId the primary key for the new data item entry
	 * @return the new data item entry
	 */
	public static DataItemEntry create(long dataItemId) {
		return getPersistence().create(dataItemId);
	}

	/**
	 * Removes the data item entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry that was removed
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public static DataItemEntry remove(long dataItemId)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().remove(dataItemId);
	}

	public static DataItemEntry updateImpl(DataItemEntry dataItemEntry) {
		return getPersistence().updateImpl(dataItemEntry);
	}

	/**
	 * Returns the data item entry with the primary key or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public static DataItemEntry findByPrimaryKey(long dataItemId)
		throws com.dogoo.dataitems.service.exception.
			NoSuchDataItemEntryException {

		return getPersistence().findByPrimaryKey(dataItemId);
	}

	/**
	 * Returns the data item entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry, or <code>null</code> if a data item entry with the primary key could not be found
	 */
	public static DataItemEntry fetchByPrimaryKey(long dataItemId) {
		return getPersistence().fetchByPrimaryKey(dataItemId);
	}

	/**
	 * Returns all the data item entries.
	 *
	 * @return the data item entries
	 */
	public static List<DataItemEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of data item entries
	 */
	public static List<DataItemEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data item entries
	 */
	public static List<DataItemEntry> findAll(
		int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data item entries
	 */
	public static List<DataItemEntry> findAll(
		int start, int end, OrderByComparator<DataItemEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data item entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data item entries.
	 *
	 * @return the number of data item entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataItemEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DataItemEntryPersistence _persistence;

}