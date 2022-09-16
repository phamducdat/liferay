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

import com.dogoo.contact.service.exception.NoSuchEmailEntryException;
import com.dogoo.contact.service.model.EmailEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the email entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailEntryUtil
 * @generated
 */
@ProviderType
public interface EmailEntryPersistence extends BasePersistence<EmailEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailEntryUtil} to access the email entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the email entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching email entries
	 */
	public java.util.List<EmailEntry> findByUuid(String uuid);

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
	public java.util.List<EmailEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<EmailEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

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
	public java.util.List<EmailEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

	/**
	 * Returns the email entries before and after the current email entry in the ordered set where uuid = &#63;.
	 *
	 * @param emailId the primary key of the current email entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public EmailEntry[] findByUuid_PrevAndNext(
			long emailId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Removes all the email entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of email entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching email entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the email entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the email entry that was removed
	 */
	public EmailEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the number of email entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching email entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching email entries
	 */
	public java.util.List<EmailEntry> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

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
	public java.util.List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

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
	public EmailEntry[] findByUuid_C_PrevAndNext(
			long emailId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Removes all the email entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching email entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the matching email entries
	 */
	public java.util.List<EmailEntry> findByC_C(
		long customerId, long contactId);

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
	public java.util.List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end);

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
	public java.util.List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

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
	public java.util.List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByC_C_First(
			long customerId, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the first email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_C_First(
		long customerId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

	/**
	 * Returns the last email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByC_C_Last(
			long customerId, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the last email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_C_Last(
		long customerId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

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
	public EmailEntry[] findByC_C_PrevAndNext(
			long emailId, long customerId, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
				orderByComparator)
		throws NoSuchEmailEntryException;

	/**
	 * Removes all the email entries where customerId = &#63; and contactId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 */
	public void removeByC_C(long customerId, long contactId);

	/**
	 * Returns the number of email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the number of matching email entries
	 */
	public int countByC_C(long customerId, long contactId);

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByC_E(long customerId, String emailAddress)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_E(long customerId, String emailAddress);

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_E(
		long customerId, String emailAddress, boolean useFinderCache);

	/**
	 * Removes the email entry where customerId = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the email entry that was removed
	 */
	public EmailEntry removeByC_E(long customerId, String emailAddress)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the number of email entries where customerId = &#63; and emailAddress = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the number of matching email entries
	 */
	public int countByC_E(long customerId, String emailAddress);

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByC_I(long customerId, boolean isDefaulted)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_I(long customerId, boolean isDefaulted);

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_I(
		long customerId, boolean isDefaulted, boolean useFinderCache);

	/**
	 * Removes the email entry where customerId = &#63; and isDefaulted = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the email entry that was removed
	 */
	public EmailEntry removeByC_I(long customerId, boolean isDefaulted)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the number of email entries where customerId = &#63; and isDefaulted = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the number of matching email entries
	 */
	public int countByC_I(long customerId, boolean isDefaulted);

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	public EmailEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public EmailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the email entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the email entry that was removed
	 */
	public EmailEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the number of email entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching email entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the email entry in the entity cache if it is enabled.
	 *
	 * @param emailEntry the email entry
	 */
	public void cacheResult(EmailEntry emailEntry);

	/**
	 * Caches the email entries in the entity cache if it is enabled.
	 *
	 * @param emailEntries the email entries
	 */
	public void cacheResult(java.util.List<EmailEntry> emailEntries);

	/**
	 * Creates a new email entry with the primary key. Does not add the email entry to the database.
	 *
	 * @param emailId the primary key for the new email entry
	 * @return the new email entry
	 */
	public EmailEntry create(long emailId);

	/**
	 * Removes the email entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry that was removed
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public EmailEntry remove(long emailId) throws NoSuchEmailEntryException;

	public EmailEntry updateImpl(EmailEntry emailEntry);

	/**
	 * Returns the email entry with the primary key or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	public EmailEntry findByPrimaryKey(long emailId)
		throws NoSuchEmailEntryException;

	/**
	 * Returns the email entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry, or <code>null</code> if a email entry with the primary key could not be found
	 */
	public EmailEntry fetchByPrimaryKey(long emailId);

	/**
	 * Returns all the email entries.
	 *
	 * @return the email entries
	 */
	public java.util.List<EmailEntry> findAll();

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
	public java.util.List<EmailEntry> findAll(int start, int end);

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
	public java.util.List<EmailEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator);

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
	public java.util.List<EmailEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the email entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of email entries.
	 *
	 * @return the number of email entries
	 */
	public int countAll();

}