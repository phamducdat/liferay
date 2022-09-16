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

package com.dogoo.dataitems.service.service.persistence;

import com.dogoo.dataitems.service.exception.NoSuchDataItemEntryException;
import com.dogoo.dataitems.service.model.DataItemEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data item entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nghiatt
 * @see DataItemEntryUtil
 * @generated
 */
@ProviderType
public interface DataItemEntryPersistence
	extends BasePersistence<DataItemEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataItemEntryUtil} to access the data item entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data item entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public DataItemEntry[] findByUuid_PrevAndNext(
			long dataItemId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Removes all the data item entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data item entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data item entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the data item entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data item entry that was removed
	 */
	public DataItemEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the number of data item entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data item entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public DataItemEntry[] findByUuid_C_PrevAndNext(
			long dataItemId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Removes all the data item entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data item entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the matching data item entries
	 */
	public java.util.List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type);

	/**
	 * Returns a range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	public java.util.List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByC_P_T_First(
			long customerId, long parentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the first data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByC_P_T_First(
		long customerId, long parentId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns the last data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByC_P_T_Last(
			long customerId, long parentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the last data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByC_P_T_Last(
		long customerId, long parentId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public DataItemEntry[] findByC_P_T_PrevAndNext(
			long dataItemId, long customerId, long parentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
				orderByComparator)
		throws NoSuchDataItemEntryException;

	/**
	 * Removes all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 */
	public void removeByC_P_T(long customerId, long parentId, String type);

	/**
	 * Returns the number of data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the number of matching data item entries
	 */
	public int countByC_P_T(long customerId, long parentId, String type);

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByC_P_N_T(
			long customerId, long parentId, String name, String type)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByC_P_N_T(
		long customerId, long parentId, String name, String type);

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByC_P_N_T(
		long customerId, long parentId, String name, String type,
		boolean useFinderCache);

	/**
	 * Removes the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the data item entry that was removed
	 */
	public DataItemEntry removeByC_P_N_T(
			long customerId, long parentId, String name, String type)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the number of data item entries where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the number of matching data item entries
	 */
	public int countByC_P_N_T(
		long customerId, long parentId, String name, String type);

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	public DataItemEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public DataItemEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the data item entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the data item entry that was removed
	 */
	public DataItemEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the number of data item entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching data item entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the data item entry in the entity cache if it is enabled.
	 *
	 * @param dataItemEntry the data item entry
	 */
	public void cacheResult(DataItemEntry dataItemEntry);

	/**
	 * Caches the data item entries in the entity cache if it is enabled.
	 *
	 * @param dataItemEntries the data item entries
	 */
	public void cacheResult(java.util.List<DataItemEntry> dataItemEntries);

	/**
	 * Creates a new data item entry with the primary key. Does not add the data item entry to the database.
	 *
	 * @param dataItemId the primary key for the new data item entry
	 * @return the new data item entry
	 */
	public DataItemEntry create(long dataItemId);

	/**
	 * Removes the data item entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry that was removed
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public DataItemEntry remove(long dataItemId)
		throws NoSuchDataItemEntryException;

	public DataItemEntry updateImpl(DataItemEntry dataItemEntry);

	/**
	 * Returns the data item entry with the primary key or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	public DataItemEntry findByPrimaryKey(long dataItemId)
		throws NoSuchDataItemEntryException;

	/**
	 * Returns the data item entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry, or <code>null</code> if a data item entry with the primary key could not be found
	 */
	public DataItemEntry fetchByPrimaryKey(long dataItemId);

	/**
	 * Returns all the data item entries.
	 *
	 * @return the data item entries
	 */
	public java.util.List<DataItemEntry> findAll();

	/**
	 * Returns a range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of data item entries
	 */
	public java.util.List<DataItemEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data item entries
	 */
	public java.util.List<DataItemEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data item entries
	 */
	public java.util.List<DataItemEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataItemEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data item entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data item entries.
	 *
	 * @return the number of data item entries
	 */
	public int countAll();

}