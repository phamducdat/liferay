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

package com.dogoo.common.auditing.service.service.persistence;

import com.dogoo.common.auditing.service.model.AuditingEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the auditing entry service. This utility wraps <code>com.dogoo.common.auditing.service.service.persistence.impl.AuditingEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditingEntryPersistence
 * @generated
 */
public class AuditingEntryUtil {

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
	public static void clearCache(AuditingEntry auditingEntry) {
		getPersistence().clearCache(auditingEntry);
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
	public static Map<Serializable, AuditingEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AuditingEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuditingEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuditingEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AuditingEntry update(AuditingEntry auditingEntry) {
		return getPersistence().update(auditingEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AuditingEntry update(
		AuditingEntry auditingEntry, ServiceContext serviceContext) {

		return getPersistence().update(auditingEntry, serviceContext);
	}

	/**
	 * Returns all the auditing entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByUuid_First(
			String uuid, OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByUuid_First(
		String uuid, OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByUuid_Last(
			String uuid, OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public static AuditingEntry[] findByUuid_PrevAndNext(
			long auditingId, String uuid,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			auditingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the auditing entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of auditing entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditing entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the auditing entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the auditing entry that was removed
	 */
	public static AuditingEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of auditing entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching auditing entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public static AuditingEntry[] findByUuid_C_PrevAndNext(
			long auditingId, String uuid, long companyId,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			auditingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the auditing entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching auditing entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching auditing entries
	 */
	public static List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName) {

		return getPersistence().findByPK_Name(classPkId, classPkName);
	}

	/**
	 * Returns a range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public static List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end) {

		return getPersistence().findByPK_Name(
			classPkId, classPkName, start, end);
	}

	/**
	 * Returns an ordered range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().findByPK_Name(
			classPkId, classPkName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPK_Name(
			classPkId, classPkName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByPK_Name_First(
			long classPkId, String classPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByPK_Name_First(
			classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the first auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByPK_Name_First(
		long classPkId, String classPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByPK_Name_First(
			classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByPK_Name_Last(
			long classPkId, String classPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByPK_Name_Last(
			classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByPK_Name_Last(
		long classPkId, String classPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByPK_Name_Last(
			classPkId, classPkName, orderByComparator);
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public static AuditingEntry[] findByPK_Name_PrevAndNext(
			long auditingId, long classPkId, String classPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByPK_Name_PrevAndNext(
			auditingId, classPkId, classPkName, orderByComparator);
	}

	/**
	 * Removes all the auditing entries where classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	public static void removeByPK_Name(long classPkId, String classPkName) {
		getPersistence().removeByPK_Name(classPkId, classPkName);
	}

	/**
	 * Returns the number of auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching auditing entries
	 */
	public static int countByPK_Name(long classPkId, String classPkName) {
		return getPersistence().countByPK_Name(classPkId, classPkName);
	}

	/**
	 * Returns all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @return the matching auditing entries
	 */
	public static List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName) {

		return getPersistence().findByParent_PK_Name(parentPkId, parentPkName);
	}

	/**
	 * Returns a range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public static List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end) {

		return getPersistence().findByParent_PK_Name(
			parentPkId, parentPkName, start, end);
	}

	/**
	 * Returns an ordered range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().findByParent_PK_Name(
			parentPkId, parentPkName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public static List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParent_PK_Name(
			parentPkId, parentPkName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByParent_PK_Name_First(
			Long parentPkId, String parentPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByParent_PK_Name_First(
			parentPkId, parentPkName, orderByComparator);
	}

	/**
	 * Returns the first auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByParent_PK_Name_First(
		Long parentPkId, String parentPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByParent_PK_Name_First(
			parentPkId, parentPkName, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByParent_PK_Name_Last(
			Long parentPkId, String parentPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByParent_PK_Name_Last(
			parentPkId, parentPkName, orderByComparator);
	}

	/**
	 * Returns the last auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByParent_PK_Name_Last(
		Long parentPkId, String parentPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().fetchByParent_PK_Name_Last(
			parentPkId, parentPkName, orderByComparator);
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public static AuditingEntry[] findByParent_PK_Name_PrevAndNext(
			long auditingId, Long parentPkId, String parentPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByParent_PK_Name_PrevAndNext(
			auditingId, parentPkId, parentPkName, orderByComparator);
	}

	/**
	 * Removes all the auditing entries where parentPkId = &#63; and parentPkName = &#63; from the database.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 */
	public static void removeByParent_PK_Name(
		Long parentPkId, String parentPkName) {

		getPersistence().removeByParent_PK_Name(parentPkId, parentPkName);
	}

	/**
	 * Returns the number of auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @return the number of matching auditing entries
	 */
	public static int countByParent_PK_Name(
		Long parentPkId, String parentPkName) {

		return getPersistence().countByParent_PK_Name(parentPkId, parentPkName);
	}

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public static AuditingEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public static AuditingEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the auditing entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the auditing entry that was removed
	 */
	public static AuditingEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of auditing entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching auditing entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the auditing entry in the entity cache if it is enabled.
	 *
	 * @param auditingEntry the auditing entry
	 */
	public static void cacheResult(AuditingEntry auditingEntry) {
		getPersistence().cacheResult(auditingEntry);
	}

	/**
	 * Caches the auditing entries in the entity cache if it is enabled.
	 *
	 * @param auditingEntries the auditing entries
	 */
	public static void cacheResult(List<AuditingEntry> auditingEntries) {
		getPersistence().cacheResult(auditingEntries);
	}

	/**
	 * Creates a new auditing entry with the primary key. Does not add the auditing entry to the database.
	 *
	 * @param auditingId the primary key for the new auditing entry
	 * @return the new auditing entry
	 */
	public static AuditingEntry create(long auditingId) {
		return getPersistence().create(auditingId);
	}

	/**
	 * Removes the auditing entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry that was removed
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public static AuditingEntry remove(long auditingId)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().remove(auditingId);
	}

	public static AuditingEntry updateImpl(AuditingEntry auditingEntry) {
		return getPersistence().updateImpl(auditingEntry);
	}

	/**
	 * Returns the auditing entry with the primary key or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public static AuditingEntry findByPrimaryKey(long auditingId)
		throws com.dogoo.common.auditing.service.exception.
			NoSuchAuditingEntryException {

		return getPersistence().findByPrimaryKey(auditingId);
	}

	/**
	 * Returns the auditing entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry, or <code>null</code> if a auditing entry with the primary key could not be found
	 */
	public static AuditingEntry fetchByPrimaryKey(long auditingId) {
		return getPersistence().fetchByPrimaryKey(auditingId);
	}

	/**
	 * Returns all the auditing entries.
	 *
	 * @return the auditing entries
	 */
	public static List<AuditingEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of auditing entries
	 */
	public static List<AuditingEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditing entries
	 */
	public static List<AuditingEntry> findAll(
		int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auditing entries
	 */
	public static List<AuditingEntry> findAll(
		int start, int end, OrderByComparator<AuditingEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the auditing entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of auditing entries.
	 *
	 * @return the number of auditing entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuditingEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AuditingEntryPersistence _persistence;

}