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

package com.dogoo.department.service.service.persistence;

import com.dogoo.department.service.model.DepartmentEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the department entry service. This utility wraps <code>com.dogoo.department.service.service.persistence.impl.DepartmentEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntryPersistence
 * @generated
 */
public class DepartmentEntryUtil {

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
	public static void clearCache(DepartmentEntry departmentEntry) {
		getPersistence().clearCache(departmentEntry);
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
	public static Map<Serializable, DepartmentEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DepartmentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DepartmentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DepartmentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DepartmentEntry update(DepartmentEntry departmentEntry) {
		return getPersistence().update(departmentEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DepartmentEntry update(
		DepartmentEntry departmentEntry, ServiceContext serviceContext) {

		return getPersistence().update(departmentEntry, serviceContext);
	}

	/**
	 * Returns all the department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_First(
			String uuid, OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_First(
		String uuid, OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_Last(
			String uuid, OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry[] findByUuid_PrevAndNext(
			long departmentId, String uuid,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			departmentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the department entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching department entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the department entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of department entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching department entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry[] findByUuid_C_PrevAndNext(
			long departmentId, String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			departmentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the department entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching department entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the department entries where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching department entries
	 */
	public static List<DepartmentEntry> findByC_(long customerId) {
		return getPersistence().findByC_(customerId);
	}

	/**
	 * Returns a range of all the department entries where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_(
		long customerId, int start, int end) {

		return getPersistence().findByC_(customerId, start, end);
	}

	/**
	 * Returns an ordered range of all the department entries where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_(
		long customerId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findByC_(
			customerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_(
		long customerId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_(
			customerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department entry in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC__First(
			long customerId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC__First(customerId, orderByComparator);
	}

	/**
	 * Returns the first department entry in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC__First(
		long customerId, OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByC__First(customerId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC__Last(
			long customerId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC__Last(customerId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC__Last(
		long customerId, OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByC__Last(customerId, orderByComparator);
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where customerId = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry[] findByC__PrevAndNext(
			long departmentId, long customerId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC__PrevAndNext(
			departmentId, customerId, orderByComparator);
	}

	/**
	 * Removes all the department entries where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 */
	public static void removeByC_(long customerId) {
		getPersistence().removeByC_(customerId);
	}

	/**
	 * Returns the number of department entries where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching department entries
	 */
	public static int countByC_(long customerId) {
		return getPersistence().countByC_(customerId);
	}

	/**
	 * Returns the department entry where customerId = &#63; and name = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_N(long customerId, String name)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_N(customerId, name);
	}

	/**
	 * Returns the department entry where customerId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_N(long customerId, String name) {
		return getPersistence().fetchByC_N(customerId, name);
	}

	/**
	 * Returns the department entry where customerId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_N(
		long customerId, String name, boolean useFinderCache) {

		return getPersistence().fetchByC_N(customerId, name, useFinderCache);
	}

	/**
	 * Removes the department entry where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByC_N(long customerId, String name)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByC_N(customerId, name);
	}

	/**
	 * Returns the number of department entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching department entries
	 */
	public static int countByC_N(long customerId, String name) {
		return getPersistence().countByC_N(customerId, name);
	}

	/**
	 * Returns the department entry where customerId = &#63; and name = &#63; and parentId = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_N_P(
			long customerId, String name, long parentId)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_N_P(customerId, name, parentId);
	}

	/**
	 * Returns the department entry where customerId = &#63; and name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_N_P(
		long customerId, String name, long parentId) {

		return getPersistence().fetchByC_N_P(customerId, name, parentId);
	}

	/**
	 * Returns the department entry where customerId = &#63; and name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param parentId the parent ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_N_P(
		long customerId, String name, long parentId, boolean useFinderCache) {

		return getPersistence().fetchByC_N_P(
			customerId, name, parentId, useFinderCache);
	}

	/**
	 * Removes the department entry where customerId = &#63; and name = &#63; and parentId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByC_N_P(
			long customerId, String name, long parentId)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByC_N_P(customerId, name, parentId);
	}

	/**
	 * Returns the number of department entries where customerId = &#63; and name = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the number of matching department entries
	 */
	public static int countByC_N_P(
		long customerId, String name, long parentId) {

		return getPersistence().countByC_N_P(customerId, name, parentId);
	}

	/**
	 * Returns the department entry where customerId = &#63; and code = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param code the code
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_C(long customerId, String code)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_C(customerId, code);
	}

	/**
	 * Returns the department entry where customerId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param code the code
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_C(long customerId, String code) {
		return getPersistence().fetchByC_C(customerId, code);
	}

	/**
	 * Returns the department entry where customerId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_C(
		long customerId, String code, boolean useFinderCache) {

		return getPersistence().fetchByC_C(customerId, code, useFinderCache);
	}

	/**
	 * Removes the department entry where customerId = &#63; and code = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param code the code
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByC_C(long customerId, String code)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByC_C(customerId, code);
	}

	/**
	 * Returns the number of department entries where customerId = &#63; and code = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param code the code
	 * @return the number of matching department entries
	 */
	public static int countByC_C(long customerId, String code) {
		return getPersistence().countByC_C(customerId, code);
	}

	/**
	 * Returns the department entry where customerId = &#63; and tax = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param tax the tax
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_T(long customerId, String tax)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_T(customerId, tax);
	}

	/**
	 * Returns the department entry where customerId = &#63; and tax = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param tax the tax
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_T(long customerId, String tax) {
		return getPersistence().fetchByC_T(customerId, tax);
	}

	/**
	 * Returns the department entry where customerId = &#63; and tax = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param tax the tax
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_T(
		long customerId, String tax, boolean useFinderCache) {

		return getPersistence().fetchByC_T(customerId, tax, useFinderCache);
	}

	/**
	 * Removes the department entry where customerId = &#63; and tax = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param tax the tax
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByC_T(long customerId, String tax)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByC_T(customerId, tax);
	}

	/**
	 * Returns the number of department entries where customerId = &#63; and tax = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param tax the tax
	 * @return the number of matching department entries
	 */
	public static int countByC_T(long customerId, String tax) {
		return getPersistence().countByC_T(customerId, tax);
	}

	/**
	 * Returns all the department entries where customerId = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @return the matching department entries
	 */
	public static List<DepartmentEntry> findByC_P(
		long customerId, long parentId) {

		return getPersistence().findByC_P(customerId, parentId);
	}

	/**
	 * Returns a range of all the department entries where customerId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_P(
		long customerId, long parentId, int start, int end) {

		return getPersistence().findByC_P(customerId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the department entries where customerId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_P(
		long customerId, long parentId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findByC_P(
			customerId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries where customerId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_P(
		long customerId, long parentId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_P(
			customerId, parentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first department entry in the ordered set where customerId = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_P_First(
			long customerId, long parentId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_P_First(
			customerId, parentId, orderByComparator);
	}

	/**
	 * Returns the first department entry in the ordered set where customerId = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_P_First(
		long customerId, long parentId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByC_P_First(
			customerId, parentId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where customerId = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_P_Last(
			long customerId, long parentId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_P_Last(
			customerId, parentId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where customerId = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_P_Last(
		long customerId, long parentId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByC_P_Last(
			customerId, parentId, orderByComparator);
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where customerId = &#63; and parentId = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry[] findByC_P_PrevAndNext(
			long departmentId, long customerId, long parentId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_P_PrevAndNext(
			departmentId, customerId, parentId, orderByComparator);
	}

	/**
	 * Removes all the department entries where customerId = &#63; and parentId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 */
	public static void removeByC_P(long customerId, long parentId) {
		getPersistence().removeByC_P(customerId, parentId);
	}

	/**
	 * Returns the number of department entries where customerId = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @return the number of matching department entries
	 */
	public static int countByC_P(long customerId, long parentId) {
		return getPersistence().countByC_P(customerId, parentId);
	}

	/**
	 * Returns all the department entries where customerId = &#63; and businessId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @return the matching department entries
	 */
	public static List<DepartmentEntry> findByC_B(
		long customerId, long businessId) {

		return getPersistence().findByC_B(customerId, businessId);
	}

	/**
	 * Returns a range of all the department entries where customerId = &#63; and businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_B(
		long customerId, long businessId, int start, int end) {

		return getPersistence().findByC_B(customerId, businessId, start, end);
	}

	/**
	 * Returns an ordered range of all the department entries where customerId = &#63; and businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_B(
		long customerId, long businessId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findByC_B(
			customerId, businessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries where customerId = &#63; and businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByC_B(
		long customerId, long businessId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_B(
			customerId, businessId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first department entry in the ordered set where customerId = &#63; and businessId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_B_First(
			long customerId, long businessId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_B_First(
			customerId, businessId, orderByComparator);
	}

	/**
	 * Returns the first department entry in the ordered set where customerId = &#63; and businessId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_B_First(
		long customerId, long businessId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByC_B_First(
			customerId, businessId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where customerId = &#63; and businessId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_B_Last(
			long customerId, long businessId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_B_Last(
			customerId, businessId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where customerId = &#63; and businessId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_B_Last(
		long customerId, long businessId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByC_B_Last(
			customerId, businessId, orderByComparator);
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where customerId = &#63; and businessId = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry[] findByC_B_PrevAndNext(
			long departmentId, long customerId, long businessId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_B_PrevAndNext(
			departmentId, customerId, businessId, orderByComparator);
	}

	/**
	 * Removes all the department entries where customerId = &#63; and businessId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 */
	public static void removeByC_B(long customerId, long businessId) {
		getPersistence().removeByC_B(customerId, businessId);
	}

	/**
	 * Returns the number of department entries where customerId = &#63; and businessId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param businessId the business ID
	 * @return the number of matching department entries
	 */
	public static int countByC_B(long customerId, long businessId) {
		return getPersistence().countByC_B(customerId, businessId);
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the department entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of department entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching department entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the department entry in the entity cache if it is enabled.
	 *
	 * @param departmentEntry the department entry
	 */
	public static void cacheResult(DepartmentEntry departmentEntry) {
		getPersistence().cacheResult(departmentEntry);
	}

	/**
	 * Caches the department entries in the entity cache if it is enabled.
	 *
	 * @param departmentEntries the department entries
	 */
	public static void cacheResult(List<DepartmentEntry> departmentEntries) {
		getPersistence().cacheResult(departmentEntries);
	}

	/**
	 * Creates a new department entry with the primary key. Does not add the department entry to the database.
	 *
	 * @param departmentId the primary key for the new department entry
	 * @return the new department entry
	 */
	public static DepartmentEntry create(long departmentId) {
		return getPersistence().create(departmentId);
	}

	/**
	 * Removes the department entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry that was removed
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry remove(long departmentId)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().remove(departmentId);
	}

	public static DepartmentEntry updateImpl(DepartmentEntry departmentEntry) {
		return getPersistence().updateImpl(departmentEntry);
	}

	/**
	 * Returns the department entry with the primary key or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry findByPrimaryKey(long departmentId)
		throws com.dogoo.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByPrimaryKey(departmentId);
	}

	/**
	 * Returns the department entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry, or <code>null</code> if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry fetchByPrimaryKey(long departmentId) {
		return getPersistence().fetchByPrimaryKey(departmentId);
	}

	/**
	 * Returns all the department entries.
	 *
	 * @return the department entries
	 */
	public static List<DepartmentEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of department entries
	 */
	public static List<DepartmentEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department entries
	 */
	public static List<DepartmentEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department entries
	 */
	public static List<DepartmentEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the department entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of department entries.
	 *
	 * @return the number of department entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DepartmentEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DepartmentEntryPersistence _persistence;

}