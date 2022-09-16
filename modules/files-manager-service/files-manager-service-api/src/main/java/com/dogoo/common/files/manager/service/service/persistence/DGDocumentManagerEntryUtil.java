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

import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dg document manager entry service. This utility wraps <code>com.dogoo.common.files.manager.service.service.persistence.impl.DGDocumentManagerEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGDocumentManagerEntryPersistence
 * @generated
 */
public class DGDocumentManagerEntryUtil {

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
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		getPersistence().clearCache(dgDocumentManagerEntry);
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
	public static Map<Serializable, DGDocumentManagerEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DGDocumentManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DGDocumentManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DGDocumentManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DGDocumentManagerEntry update(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		return getPersistence().update(dgDocumentManagerEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DGDocumentManagerEntry update(
		DGDocumentManagerEntry dgDocumentManagerEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(dgDocumentManagerEntry, serviceContext);
	}

	/**
	 * Returns all the dg document manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry[] findByUuid_PrevAndNext(
			long documentManagerId, String uuid,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			documentManagerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dg document manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dg document manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg document manager entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dg document manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg document manager entry that was removed
	 */
	public static DGDocumentManagerEntry removeByUUID_G(
			String uuid, long groupId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dg document manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg document manager entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry[] findByUuid_C_PrevAndNext(
			long documentManagerId, String uuid, long companyId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			documentManagerId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dg document manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg document manager entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the dg document manager entries where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @return the matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_(String pkCode) {
		return getPersistence().findByPC_(pkCode);
	}

	/**
	 * Returns a range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end) {

		return getPersistence().findByPC_(pkCode, start, end);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().findByPC_(
			pkCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPC_(
			pkCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByPC__First(
			String pkCode,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPC__First(pkCode, orderByComparator);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByPC__First(
		String pkCode,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByPC__First(pkCode, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByPC__Last(
			String pkCode,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPC__Last(pkCode, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByPC__Last(
		String pkCode,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByPC__Last(pkCode, orderByComparator);
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry[] findByPC__PrevAndNext(
			long documentManagerId, String pkCode,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPC__PrevAndNext(
			documentManagerId, pkCode, orderByComparator);
	}

	/**
	 * Removes all the dg document manager entries where pkCode = &#63; from the database.
	 *
	 * @param pkCode the pk code
	 */
	public static void removeByPC_(String pkCode) {
		getPersistence().removeByPC_(pkCode);
	}

	/**
	 * Returns the number of dg document manager entries where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @return the number of matching dg document manager entries
	 */
	public static int countByPC_(String pkCode) {
		return getPersistence().countByPC_(pkCode);
	}

	/**
	 * Returns all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @return the matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId) {

		return getPersistence().findByPC_PI(pkCode, parentId);
	}

	/**
	 * Returns a range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end) {

		return getPersistence().findByPC_PI(pkCode, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().findByPC_PI(
			pkCode, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPC_PI(
			pkCode, parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByPC_PI_First(
			String pkCode, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPC_PI_First(
			pkCode, parentId, orderByComparator);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByPC_PI_First(
		String pkCode, long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByPC_PI_First(
			pkCode, parentId, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByPC_PI_Last(
			String pkCode, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPC_PI_Last(
			pkCode, parentId, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByPC_PI_Last(
		String pkCode, long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByPC_PI_Last(
			pkCode, parentId, orderByComparator);
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry[] findByPC_PI_PrevAndNext(
			long documentManagerId, String pkCode, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPC_PI_PrevAndNext(
			documentManagerId, pkCode, parentId, orderByComparator);
	}

	/**
	 * Removes all the dg document manager entries where pkCode = &#63; and parentId = &#63; from the database.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 */
	public static void removeByPC_PI(String pkCode, long parentId) {
		getPersistence().removeByPC_PI(pkCode, parentId);
	}

	/**
	 * Returns the number of dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	public static int countByPC_PI(String pkCode, long parentId) {
		return getPersistence().countByPC_PI(pkCode, parentId);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByN_T_PC_PI_C_CI(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId) {

		return getPersistence().fetchByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId, boolean useFinderCache) {

		return getPersistence().fetchByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId, useFinderCache);
	}

	/**
	 * Removes the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; from the database.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the dg document manager entry that was removed
	 */
	public static DGDocumentManagerEntry removeByN_T_PC_PI_C_CI(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().removeByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId);
	}

	/**
	 * Returns the number of dg document manager entries where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the number of matching dg document manager entries
	 */
	public static int countByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId) {

		return getPersistence().countByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId);
	}

	/**
	 * Returns the dg document manager entry where fileId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByFI_(long fileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByFI_(fileId);
	}

	/**
	 * Returns the dg document manager entry where fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByFI_(long fileId) {
		return getPersistence().fetchByFI_(fileId);
	}

	/**
	 * Returns the dg document manager entry where fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByFI_(
		long fileId, boolean useFinderCache) {

		return getPersistence().fetchByFI_(fileId, useFinderCache);
	}

	/**
	 * Removes the dg document manager entry where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @return the dg document manager entry that was removed
	 */
	public static DGDocumentManagerEntry removeByFI_(long fileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().removeByFI_(fileId);
	}

	/**
	 * Returns the number of dg document manager entries where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching dg document manager entries
	 */
	public static int countByFI_(long fileId) {
		return getPersistence().countByFI_(fileId);
	}

	/**
	 * Returns all the dg document manager entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPI_(long parentId) {
		return getPersistence().findByPI_(parentId);
	}

	/**
	 * Returns a range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end) {

		return getPersistence().findByPI_(parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().findByPI_(
			parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPI_(
			parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByPI__First(
			long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPI__First(parentId, orderByComparator);
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByPI__First(
		long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByPI__First(parentId, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByPI__Last(
			long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPI__Last(parentId, orderByComparator);
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByPI__Last(
		long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().fetchByPI__Last(parentId, orderByComparator);
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry[] findByPI__PrevAndNext(
			long documentManagerId, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPI__PrevAndNext(
			documentManagerId, parentId, orderByComparator);
	}

	/**
	 * Removes all the dg document manager entries where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public static void removeByPI_(long parentId) {
		getPersistence().removeByPI_(parentId);
	}

	/**
	 * Returns the number of dg document manager entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	public static int countByPI_(long parentId) {
		return getPersistence().countByPI_(parentId);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByN_PI(String name, long parentId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByN_PI(name, parentId);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByN_PI(
		String name, long parentId) {

		return getPersistence().fetchByN_PI(name, parentId);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByN_PI(
		String name, long parentId, boolean useFinderCache) {

		return getPersistence().fetchByN_PI(name, parentId, useFinderCache);
	}

	/**
	 * Removes the dg document manager entry where name = &#63; and parentId = &#63; from the database.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the dg document manager entry that was removed
	 */
	public static DGDocumentManagerEntry removeByN_PI(
			String name, long parentId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().removeByN_PI(name, parentId);
	}

	/**
	 * Returns the number of dg document manager entries where name = &#63; and parentId = &#63;.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	public static int countByN_PI(String name, long parentId) {
		return getPersistence().countByN_PI(name, parentId);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByN_PI_FE_PC(
			String name, long parentId, String fileExtension, String pkCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByN_PI_FE_PC(
			name, parentId, fileExtension, pkCode);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode) {

		return getPersistence().fetchByN_PI_FE_PC(
			name, parentId, fileExtension, pkCode);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode,
		boolean useFinderCache) {

		return getPersistence().fetchByN_PI_FE_PC(
			name, parentId, fileExtension, pkCode, useFinderCache);
	}

	/**
	 * Removes the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; from the database.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the dg document manager entry that was removed
	 */
	public static DGDocumentManagerEntry removeByN_PI_FE_PC(
			String name, long parentId, String fileExtension, String pkCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().removeByN_PI_FE_PC(
			name, parentId, fileExtension, pkCode);
	}

	/**
	 * Returns the number of dg document manager entries where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63;.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the number of matching dg document manager entries
	 */
	public static int countByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode) {

		return getPersistence().countByN_PI_FE_PC(
			name, parentId, fileExtension, pkCode);
	}

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg document manager entry that was removed
	 */
	public static DGDocumentManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of dg document manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg document manager entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the dg document manager entry in the entity cache if it is enabled.
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 */
	public static void cacheResult(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		getPersistence().cacheResult(dgDocumentManagerEntry);
	}

	/**
	 * Caches the dg document manager entries in the entity cache if it is enabled.
	 *
	 * @param dgDocumentManagerEntries the dg document manager entries
	 */
	public static void cacheResult(
		List<DGDocumentManagerEntry> dgDocumentManagerEntries) {

		getPersistence().cacheResult(dgDocumentManagerEntries);
	}

	/**
	 * Creates a new dg document manager entry with the primary key. Does not add the dg document manager entry to the database.
	 *
	 * @param documentManagerId the primary key for the new dg document manager entry
	 * @return the new dg document manager entry
	 */
	public static DGDocumentManagerEntry create(long documentManagerId) {
		return getPersistence().create(documentManagerId);
	}

	/**
	 * Removes the dg document manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry that was removed
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry remove(long documentManagerId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().remove(documentManagerId);
	}

	public static DGDocumentManagerEntry updateImpl(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		return getPersistence().updateImpl(dgDocumentManagerEntry);
	}

	/**
	 * Returns the dg document manager entry with the primary key or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry findByPrimaryKey(
			long documentManagerId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGDocumentManagerEntryException {

		return getPersistence().findByPrimaryKey(documentManagerId);
	}

	/**
	 * Returns the dg document manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry, or <code>null</code> if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry fetchByPrimaryKey(
		long documentManagerId) {

		return getPersistence().fetchByPrimaryKey(documentManagerId);
	}

	/**
	 * Returns all the dg document manager entries.
	 *
	 * @return the dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dg document manager entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dg document manager entries.
	 *
	 * @return the number of dg document manager entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DGDocumentManagerEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DGDocumentManagerEntryPersistence _persistence;

}