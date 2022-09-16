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

import com.dogoo.contact.service.exception.NoSuchPhoneEntryException;
import com.dogoo.contact.service.model.PhoneEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the phone entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhoneEntryUtil
 * @generated
 */
@ProviderType
public interface PhoneEntryPersistence extends BasePersistence<PhoneEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhoneEntryUtil} to access the phone entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the phone entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public PhoneEntry[] findByUuid_PrevAndNext(
			long phoneId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Removes all the phone entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of phone entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching phone entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the phone entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the phone entry that was removed
	 */
	public PhoneEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the number of phone entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching phone entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public PhoneEntry[] findByUuid_C_PrevAndNext(
			long phoneId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Removes all the phone entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching phone entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the matching phone entries
	 */
	public java.util.List<PhoneEntry> findByC_C(
		long customerId, long contactId);

	/**
	 * Returns a range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end);

	/**
	 * Returns an ordered range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	public java.util.List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByC_C_First(
			long customerId, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the first phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_C_First(
		long customerId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns the last phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByC_C_Last(
			long customerId, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the last phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_C_Last(
		long customerId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public PhoneEntry[] findByC_C_PrevAndNext(
			long phoneId, long customerId, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
				orderByComparator)
		throws NoSuchPhoneEntryException;

	/**
	 * Removes all the phone entries where customerId = &#63; and contactId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 */
	public void removeByC_C(long customerId, long contactId);

	/**
	 * Returns the number of phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the number of matching phone entries
	 */
	public int countByC_C(long customerId, long contactId);

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByC_N(long customerId, String number)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_N(long customerId, String number);

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_N(
		long customerId, String number, boolean useFinderCache);

	/**
	 * Removes the phone entry where customerId = &#63; and number = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the phone entry that was removed
	 */
	public PhoneEntry removeByC_N(long customerId, String number)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the number of phone entries where customerId = &#63; and number = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the number of matching phone entries
	 */
	public int countByC_N(long customerId, String number);

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByC_I(long customerId, boolean isDefaulted)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_I(long customerId, boolean isDefaulted);

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_I(
		long customerId, boolean isDefaulted, boolean useFinderCache);

	/**
	 * Removes the phone entry where customerId = &#63; and isDefaulted = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the phone entry that was removed
	 */
	public PhoneEntry removeByC_I(long customerId, boolean isDefaulted)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the number of phone entries where customerId = &#63; and isDefaulted = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the number of matching phone entries
	 */
	public int countByC_I(long customerId, boolean isDefaulted);

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	public PhoneEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public PhoneEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the phone entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the phone entry that was removed
	 */
	public PhoneEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the number of phone entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching phone entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the phone entry in the entity cache if it is enabled.
	 *
	 * @param phoneEntry the phone entry
	 */
	public void cacheResult(PhoneEntry phoneEntry);

	/**
	 * Caches the phone entries in the entity cache if it is enabled.
	 *
	 * @param phoneEntries the phone entries
	 */
	public void cacheResult(java.util.List<PhoneEntry> phoneEntries);

	/**
	 * Creates a new phone entry with the primary key. Does not add the phone entry to the database.
	 *
	 * @param phoneId the primary key for the new phone entry
	 * @return the new phone entry
	 */
	public PhoneEntry create(long phoneId);

	/**
	 * Removes the phone entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry that was removed
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public PhoneEntry remove(long phoneId) throws NoSuchPhoneEntryException;

	public PhoneEntry updateImpl(PhoneEntry phoneEntry);

	/**
	 * Returns the phone entry with the primary key or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	public PhoneEntry findByPrimaryKey(long phoneId)
		throws NoSuchPhoneEntryException;

	/**
	 * Returns the phone entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry, or <code>null</code> if a phone entry with the primary key could not be found
	 */
	public PhoneEntry fetchByPrimaryKey(long phoneId);

	/**
	 * Returns all the phone entries.
	 *
	 * @return the phone entries
	 */
	public java.util.List<PhoneEntry> findAll();

	/**
	 * Returns a range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of phone entries
	 */
	public java.util.List<PhoneEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phone entries
	 */
	public java.util.List<PhoneEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phone entries
	 */
	public java.util.List<PhoneEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhoneEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the phone entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phone entries.
	 *
	 * @return the number of phone entries
	 */
	public int countAll();

}