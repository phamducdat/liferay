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

import com.dogoo.contact.service.exception.NoSuchContactEntryException;
import com.dogoo.contact.service.model.ContactEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactEntryUtil
 * @generated
 */
@ProviderType
public interface ContactEntryPersistence extends BasePersistence<ContactEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactEntryUtil} to access the contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the contact entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the contact entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the contact entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Returns the first contact entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns the last contact entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Returns the last contact entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns the contact entries before and after the current contact entry in the ordered set where uuid = &#63;.
	 *
	 * @param contactId the primary key of the current contact entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public ContactEntry[] findByUuid_PrevAndNext(
			long contactId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Removes all the contact entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of contact entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contact entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the contact entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchContactEntryException;

	/**
	 * Returns the contact entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the contact entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the contact entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the contact entry that was removed
	 */
	public ContactEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchContactEntryException;

	/**
	 * Returns the number of contact entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching contact entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the contact entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the contact entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the contact entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact entries
	 */
	public java.util.List<ContactEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Returns the first contact entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns the last contact entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Returns the last contact entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns the contact entries before and after the current contact entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param contactId the primary key of the current contact entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public ContactEntry[] findByUuid_C_PrevAndNext(
			long contactId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Removes all the contact entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of contact entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching contact entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the contact entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchContactEntryException;

	/**
	 * Returns the contact entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the contact entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the contact entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the contact entry that was removed
	 */
	public ContactEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchContactEntryException;

	/**
	 * Returns the number of contact entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching contact entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the contact entry in the entity cache if it is enabled.
	 *
	 * @param contactEntry the contact entry
	 */
	public void cacheResult(ContactEntry contactEntry);

	/**
	 * Caches the contact entries in the entity cache if it is enabled.
	 *
	 * @param contactEntries the contact entries
	 */
	public void cacheResult(java.util.List<ContactEntry> contactEntries);

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param contactId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	public ContactEntry create(long contactId);

	/**
	 * Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public ContactEntry remove(long contactId)
		throws NoSuchContactEntryException;

	public ContactEntry updateImpl(ContactEntry contactEntry);

	/**
	 * Returns the contact entry with the primary key or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public ContactEntry findByPrimaryKey(long contactId)
		throws NoSuchContactEntryException;

	/**
	 * Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	 */
	public ContactEntry fetchByPrimaryKey(long contactId);

	/**
	 * Returns all the contact entries.
	 *
	 * @return the contact entries
	 */
	public java.util.List<ContactEntry> findAll();

	/**
	 * Returns a range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of contact entries
	 */
	public java.util.List<ContactEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact entries
	 */
	public java.util.List<ContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contact entries
	 */
	public java.util.List<ContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the contact entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 */
	public int countAll();

}