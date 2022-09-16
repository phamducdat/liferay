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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileVersionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dg file version entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileVersionEntryUtil
 * @generated
 */
@ProviderType
public interface DGFileVersionEntryPersistence
	extends BasePersistence<DGFileVersionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGFileVersionEntryUtil} to access the dg file version entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dg file version entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
				orderByComparator)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator);

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
				orderByComparator)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator);

	/**
	 * Returns the dg file version entries before and after the current dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileVersionId the primary key of the current dg file version entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public DGFileVersionEntry[] findByUuid_PrevAndNext(
			long fileVersionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
				orderByComparator)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Removes all the dg file version entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dg file version entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file version entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dg file version entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file version entry that was removed
	 */
	public DGFileVersionEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the number of dg file version entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file version entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
				orderByComparator)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator);

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
				orderByComparator)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator);

	/**
	 * Returns the dg file version entries before and after the current dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileVersionId the primary key of the current dg file version entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public DGFileVersionEntry[] findByUuid_C_PrevAndNext(
			long fileVersionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
				orderByComparator)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Removes all the dg file version entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file version entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry findByC_FV(long customerId, long fileVersionId)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByC_FV(long customerId, long fileVersionId);

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByC_FV(
		long customerId, long fileVersionId, boolean useFinderCache);

	/**
	 * Removes the dg file version entry where customerId = &#63; and fileVersionId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the dg file version entry that was removed
	 */
	public DGFileVersionEntry removeByC_FV(long customerId, long fileVersionId)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the number of dg file version entries where customerId = &#63; and fileVersionId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the number of matching dg file version entries
	 */
	public int countByC_FV(long customerId, long fileVersionId);

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public DGFileVersionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file version entry that was removed
	 */
	public DGFileVersionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the number of dg file version entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file version entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dg file version entry in the entity cache if it is enabled.
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 */
	public void cacheResult(DGFileVersionEntry dgFileVersionEntry);

	/**
	 * Caches the dg file version entries in the entity cache if it is enabled.
	 *
	 * @param dgFileVersionEntries the dg file version entries
	 */
	public void cacheResult(
		java.util.List<DGFileVersionEntry> dgFileVersionEntries);

	/**
	 * Creates a new dg file version entry with the primary key. Does not add the dg file version entry to the database.
	 *
	 * @param fileVersionId the primary key for the new dg file version entry
	 * @return the new dg file version entry
	 */
	public DGFileVersionEntry create(long fileVersionId);

	/**
	 * Removes the dg file version entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry that was removed
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public DGFileVersionEntry remove(long fileVersionId)
		throws NoSuchDGFileVersionEntryException;

	public DGFileVersionEntry updateImpl(DGFileVersionEntry dgFileVersionEntry);

	/**
	 * Returns the dg file version entry with the primary key or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	public DGFileVersionEntry findByPrimaryKey(long fileVersionId)
		throws NoSuchDGFileVersionEntryException;

	/**
	 * Returns the dg file version entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry, or <code>null</code> if a dg file version entry with the primary key could not be found
	 */
	public DGFileVersionEntry fetchByPrimaryKey(long fileVersionId);

	/**
	 * Returns all the dg file version entries.
	 *
	 * @return the dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findAll();

	/**
	 * Returns a range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file version entries
	 */
	public java.util.List<DGFileVersionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFileVersionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dg file version entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dg file version entries.
	 *
	 * @return the number of dg file version entries
	 */
	public int countAll();

}