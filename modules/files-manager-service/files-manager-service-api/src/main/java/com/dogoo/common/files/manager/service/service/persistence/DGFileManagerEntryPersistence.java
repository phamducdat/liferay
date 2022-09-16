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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileManagerEntryException;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dg file manager entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileManagerEntryUtil
 * @generated
 */
@ProviderType
public interface DGFileManagerEntryPersistence
	extends BasePersistence<DGFileManagerEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGFileManagerEntryUtil} to access the dg file manager entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dg file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
				orderByComparator)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator);

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
				orderByComparator)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator);

	/**
	 * Returns the dg file manager entries before and after the current dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileManagerId the primary key of the current dg file manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public DGFileManagerEntry[] findByUuid_PrevAndNext(
			long fileManagerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
				orderByComparator)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Removes all the dg file manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dg file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file manager entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dg file manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file manager entry that was removed
	 */
	public DGFileManagerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the number of dg file manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file manager entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
				orderByComparator)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator);

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
				orderByComparator)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator);

	/**
	 * Returns the dg file manager entries before and after the current dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileManagerId the primary key of the current dg file manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public DGFileManagerEntry[] findByUuid_C_PrevAndNext(
			long fileManagerId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
				orderByComparator)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Removes all the dg file manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file manager entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry findByF_C(long fileId, long customerId)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByF_C(long fileId, long customerId);

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByF_C(
		long fileId, long customerId, boolean useFinderCache);

	/**
	 * Removes the dg file manager entry where fileId = &#63; and customerId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the dg file manager entry that was removed
	 */
	public DGFileManagerEntry removeByF_C(long fileId, long customerId)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the number of dg file manager entries where fileId = &#63; and customerId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the number of matching dg file manager entries
	 */
	public int countByF_C(long fileId, long customerId);

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public DGFileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file manager entry that was removed
	 */
	public DGFileManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the number of dg file manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file manager entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dg file manager entry in the entity cache if it is enabled.
	 *
	 * @param dgFileManagerEntry the dg file manager entry
	 */
	public void cacheResult(DGFileManagerEntry dgFileManagerEntry);

	/**
	 * Caches the dg file manager entries in the entity cache if it is enabled.
	 *
	 * @param dgFileManagerEntries the dg file manager entries
	 */
	public void cacheResult(
		java.util.List<DGFileManagerEntry> dgFileManagerEntries);

	/**
	 * Creates a new dg file manager entry with the primary key. Does not add the dg file manager entry to the database.
	 *
	 * @param fileManagerId the primary key for the new dg file manager entry
	 * @return the new dg file manager entry
	 */
	public DGFileManagerEntry create(long fileManagerId);

	/**
	 * Removes the dg file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry that was removed
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public DGFileManagerEntry remove(long fileManagerId)
		throws NoSuchDGFileManagerEntryException;

	public DGFileManagerEntry updateImpl(DGFileManagerEntry dgFileManagerEntry);

	/**
	 * Returns the dg file manager entry with the primary key or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	public DGFileManagerEntry findByPrimaryKey(long fileManagerId)
		throws NoSuchDGFileManagerEntryException;

	/**
	 * Returns the dg file manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry, or <code>null</code> if a dg file manager entry with the primary key could not be found
	 */
	public DGFileManagerEntry fetchByPrimaryKey(long fileManagerId);

	/**
	 * Returns all the dg file manager entries.
	 *
	 * @return the dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findAll();

	/**
	 * Returns a range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file manager entries
	 */
	public java.util.List<DGFileManagerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dg file manager entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dg file manager entries.
	 *
	 * @return the number of dg file manager entries
	 */
	public int countAll();

}