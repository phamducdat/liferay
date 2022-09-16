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

package com.dogoo.address.service.service.persistence;

import com.dogoo.address.service.exception.NoSuchAddressEntryException;
import com.dogoo.address.service.model.AddressEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the address entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressEntryUtil
 * @generated
 */
@ProviderType
public interface AddressEntryPersistence extends BasePersistence<AddressEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressEntryUtil} to access the address entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the address entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the address entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @return the range of matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public AddressEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
				orderByComparator)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator);

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public AddressEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
				orderByComparator)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator);

	/**
	 * Returns the address entries before and after the current address entry in the ordered set where uuid = &#63;.
	 *
	 * @param addressId the primary key of the current address entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address entry
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public AddressEntry[] findByUuid_PrevAndNext(
			long addressId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
				orderByComparator)
		throws NoSuchAddressEntryException;

	/**
	 * Removes all the address entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of address entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching address entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the address entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAddressEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public AddressEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the address entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the address entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the address entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the address entry that was removed
	 */
	public AddressEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the number of address entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching address entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @return the range of matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching address entries
	 */
	public java.util.List<AddressEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public AddressEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
				orderByComparator)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the first address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator);

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public AddressEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
				orderByComparator)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the last address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator);

	/**
	 * Returns the address entries before and after the current address entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param addressId the primary key of the current address entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address entry
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public AddressEntry[] findByUuid_C_PrevAndNext(
			long addressId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
				orderByComparator)
		throws NoSuchAddressEntryException;

	/**
	 * Removes all the address entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of address entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching address entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the address entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAddressEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching address entry
	 * @throws NoSuchAddressEntryException if a matching address entry could not be found
	 */
	public AddressEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the address entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the address entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public AddressEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the address entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the address entry that was removed
	 */
	public AddressEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the number of address entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching address entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the address entry in the entity cache if it is enabled.
	 *
	 * @param addressEntry the address entry
	 */
	public void cacheResult(AddressEntry addressEntry);

	/**
	 * Caches the address entries in the entity cache if it is enabled.
	 *
	 * @param addressEntries the address entries
	 */
	public void cacheResult(java.util.List<AddressEntry> addressEntries);

	/**
	 * Creates a new address entry with the primary key. Does not add the address entry to the database.
	 *
	 * @param addressId the primary key for the new address entry
	 * @return the new address entry
	 */
	public AddressEntry create(long addressId);

	/**
	 * Removes the address entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry that was removed
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public AddressEntry remove(long addressId)
		throws NoSuchAddressEntryException;

	public AddressEntry updateImpl(AddressEntry addressEntry);

	/**
	 * Returns the address entry with the primary key or throws a <code>NoSuchAddressEntryException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry
	 * @throws NoSuchAddressEntryException if a address entry with the primary key could not be found
	 */
	public AddressEntry findByPrimaryKey(long addressId)
		throws NoSuchAddressEntryException;

	/**
	 * Returns the address entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry, or <code>null</code> if a address entry with the primary key could not be found
	 */
	public AddressEntry fetchByPrimaryKey(long addressId);

	/**
	 * Returns all the address entries.
	 *
	 * @return the address entries
	 */
	public java.util.List<AddressEntry> findAll();

	/**
	 * Returns a range of all the address entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @return the range of address entries
	 */
	public java.util.List<AddressEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the address entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of address entries
	 */
	public java.util.List<AddressEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the address entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of address entries
	 */
	public java.util.List<AddressEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AddressEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the address entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of address entries.
	 *
	 * @return the number of address entries
	 */
	public int countAll();

}