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

import com.dogoo.contact.service.model.EmailEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the email entry service. This utility wraps <code>com.dogoo.contact.service.service.persistence.impl.EmailEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailEntryPersistence
 * @generated
 */
public class EmailEntryUtil {

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
	public static void clearCache(EmailEntry emailEntry) {
		getPersistence().clearCache(emailEntry);
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
	public static Map<Serializable, EmailEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmailEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmailEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmailEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmailEntry update(EmailEntry emailEntry) {
		return getPersistence().update(emailEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmailEntry update(
		EmailEntry emailEntry, ServiceContext serviceContext) {

		return getPersistence().update(emailEntry, serviceContext);
	}

	/**
	 * Returns all the email entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching email entries
	 */
	public static List<EmailEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the email entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of matching email entries
	 */
	public static List<EmailEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email entries
	 */
	public static List<EmailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email entries
	 */
	public static List<EmailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByUuid_First(
			String uuid, OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByUuid_First(
		String uuid, OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByUuid_Last(
			String uuid, OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByUuid_Last(
		String uuid, OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the email entries before and after the current email entry in the ordered set where uuid = &#63;.
	 *
	 * @param emailId the primary key of the current email entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public static EmailEntry[] findByUuid_PrevAndNext(
			long emailId, String uuid,
			OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			emailId, uuid, orderByComparator);
	}

	/**
	 * Removes all the email entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of email entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching email entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the email entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the email entry that was removed
	 */
	public static EmailEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of email entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching email entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching email entries
	 */
	public static List<EmailEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of matching email entries
	 */
	public static List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email entries
	 */
	public static List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email entries
	 */
	public static List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the email entries before and after the current email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param emailId the primary key of the current email entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public static EmailEntry[] findByUuid_C_PrevAndNext(
			long emailId, String uuid, long companyId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			emailId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the email entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching email entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the matching email entries
	 */
	public static List<EmailEntry> findByC_C(long customerId, long contactId) {
		return getPersistence().findByC_C(customerId, contactId);
	}

	/**
	 * Returns a range of all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of matching email entries
	 */
	public static List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end) {

		return getPersistence().findByC_C(customerId, contactId, start, end);
	}

	/**
	 * Returns an ordered range of all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email entries
	 */
	public static List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().findByC_C(
			customerId, contactId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email entries
	 */
	public static List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_C(
			customerId, contactId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByC_C_First(
			long customerId, long contactId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByC_C_First(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the first email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_C_First(
		long customerId, long contactId,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().fetchByC_C_First(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the last email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByC_C_Last(
			long customerId, long contactId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByC_C_Last(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the last email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_C_Last(
		long customerId, long contactId,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().fetchByC_C_Last(
			customerId, contactId, orderByComparator);
	}

	/**
	 * Returns the email entries before and after the current email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param emailId the primary key of the current email entry
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public static EmailEntry[] findByC_C_PrevAndNext(
			long emailId, long customerId, long contactId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByC_C_PrevAndNext(
			emailId, customerId, contactId, orderByComparator);
	}

	/**
	 * Removes all the email entries where customerId = &#63; and contactId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 */
	public static void removeByC_C(long customerId, long contactId) {
		getPersistence().removeByC_C(customerId, contactId);
	}

	/**
	 * Returns the number of email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the number of matching email entries
	 */
	public static int countByC_C(long customerId, long contactId) {
		return getPersistence().countByC_C(customerId, contactId);
	}

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByC_E(long customerId, String emailAddress)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByC_E(customerId, emailAddress);
	}

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_E(long customerId, String emailAddress) {
		return getPersistence().fetchByC_E(customerId, emailAddress);
	}

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_E(
		long customerId, String emailAddress, boolean useFinderCache) {

		return getPersistence().fetchByC_E(
			customerId, emailAddress, useFinderCache);
	}

	/**
	 * Removes the email entry where customerId = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the email entry that was removed
	 */
	public static EmailEntry removeByC_E(long customerId, String emailAddress)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().removeByC_E(customerId, emailAddress);
	}

	/**
	 * Returns the number of email entries where customerId = &#63; and emailAddress = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the number of matching email entries
	 */
	public static int countByC_E(long customerId, String emailAddress) {
		return getPersistence().countByC_E(customerId, emailAddress);
	}

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByC_I(long customerId, boolean isDefaulted)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_I(long customerId, boolean isDefaulted) {
		return getPersistence().fetchByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_I(
		long customerId, boolean isDefaulted, boolean useFinderCache) {

		return getPersistence().fetchByC_I(
			customerId, isDefaulted, useFinderCache);
	}

	/**
	 * Removes the email entry where customerId = &#63; and isDefaulted = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the email entry that was removed
	 */
	public static EmailEntry removeByC_I(long customerId, boolean isDefaulted)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().removeByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the number of email entries where customerId = &#63; and isDefaulted = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the number of matching email entries
	 */
	public static int countByC_I(long customerId, boolean isDefaulted) {
		return getPersistence().countByC_I(customerId, isDefaulted);
	}

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public static EmailEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the email entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the email entry that was removed
	 */
	public static EmailEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of email entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching email entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the email entry in the entity cache if it is enabled.
	 *
	 * @param emailEntry the email entry
	 */
	public static void cacheResult(EmailEntry emailEntry) {
		getPersistence().cacheResult(emailEntry);
	}

	/**
	 * Caches the email entries in the entity cache if it is enabled.
	 *
	 * @param emailEntries the email entries
	 */
	public static void cacheResult(List<EmailEntry> emailEntries) {
		getPersistence().cacheResult(emailEntries);
	}

	/**
	 * Creates a new email entry with the primary key. Does not add the email entry to the database.
	 *
	 * @param emailId the primary key for the new email entry
	 * @return the new email entry
	 */
	public static EmailEntry create(long emailId) {
		return getPersistence().create(emailId);
	}

	/**
	 * Removes the email entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry that was removed
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public static EmailEntry remove(long emailId)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().remove(emailId);
	}

	public static EmailEntry updateImpl(EmailEntry emailEntry) {
		return getPersistence().updateImpl(emailEntry);
	}

	/**
	 * Returns the email entry with the primary key or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public static EmailEntry findByPrimaryKey(long emailId)
		throws com.dogoo.contact.service.exception.NoSuchEmailEntryException {

		return getPersistence().findByPrimaryKey(emailId);
	}

	/**
	 * Returns the email entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry, or <code>null</code> if a email entry with the primary key could not be found
	 */
	public static EmailEntry fetchByPrimaryKey(long emailId) {
		return getPersistence().fetchByPrimaryKey(emailId);
	}

	/**
	 * Returns all the email entries.
	 *
	 * @return the email entries
	 */
	public static List<EmailEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the email entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of email entries
	 */
	public static List<EmailEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the email entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email entries
	 */
	public static List<EmailEntry> findAll(
		int start, int end, OrderByComparator<EmailEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the email entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of email entries
	 */
	public static List<EmailEntry> findAll(
		int start, int end, OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the email entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of email entries.
	 *
	 * @return the number of email entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmailEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EmailEntryPersistence _persistence;

}