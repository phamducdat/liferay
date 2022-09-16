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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileUserPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dg file user permission entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileUserPermissionEntryUtil
 * @generated
 */
@ProviderType
public interface DGFileUserPermissionEntryPersistence
	extends BasePersistence<DGFileUserPermissionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGFileUserPermissionEntryUtil} to access the dg file user permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dg file user permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByUuid_PrevAndNext(
			long fileUserPermissionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file user permission entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dg file user permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file user permission entry that was removed
	 */
	public DGFileUserPermissionEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file user permission entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileUserPermissionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file user permission entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_F(
			long customerId, long userAllowedId, long fileId)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_F(
		long customerId, long userAllowedId, long fileId);

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_F(
		long customerId, long userAllowedId, long fileId,
		boolean useFinderCache);

	/**
	 * Removes the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the dg file user permission entry that was removed
	 */
	public DGFileUserPermissionEntry removeByC_U_F(
			long customerId, long userAllowedId, long fileId)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_U_F(long customerId, long userAllowedId, long fileId);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_First(
			long customerId, long userAllowedId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_First(
		long customerId, long userAllowedId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_Last(
			long customerId, long userAllowedId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_Last(
		long customerId, long userAllowedId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_U_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 */
	public void removeByC_U(long customerId, long userAllowedId);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_U(long customerId, long userAllowedId);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_S_First(
			long customerId, long userAllowedId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_S_First(
		long customerId, long userAllowedId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_S_Last(
			long customerId, long userAllowedId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_S_Last(
		long customerId, long userAllowedId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_U_S_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 */
	public void removeByC_U_S(
		long customerId, long userAllowedId, String status);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_U_S(long customerId, long userAllowedId, String status);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_First(
			long customerId, long fileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_First(
		long customerId, long fileId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_Last(
			long customerId, long fileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_Last(
		long customerId, long fileId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_F_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 */
	public void removeByC_F(long customerId, long fileId);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_F(long customerId, long fileId);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_S_First(
			long customerId, long fileId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_S_First(
		long customerId, long fileId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_S_Last(
			long customerId, long fileId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_S_Last(
		long customerId, long fileId, String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_F_S_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 */
	public void removeByC_F_S(long customerId, long fileId, String status);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_F_S(long customerId, long fileId, String status);

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_F_T(
			long customerId, long userAllowedId, long fileId, String type)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type);

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type,
		boolean useFinderCache);

	/**
	 * Removes the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file user permission entry that was removed
	 */
	public DGFileUserPermissionEntry removeByC_U_F_T(
			long customerId, long userAllowedId, long fileId, String type)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_T_First(
			long customerId, long userAllowedId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_T_First(
		long customerId, long userAllowedId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_T_Last(
			long customerId, long userAllowedId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_T_Last(
		long customerId, long userAllowedId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_U_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 */
	public void removeByC_U_T(long customerId, long userAllowedId, String type);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_U_T(long customerId, long userAllowedId, String type);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_S_T_First(
			long customerId, long userAllowedId, String status, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_S_T_First(
		long customerId, long userAllowedId, String status, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_U_S_T_Last(
			long customerId, long userAllowedId, String status, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_U_S_T_Last(
		long customerId, long userAllowedId, String status, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_U_S_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String status, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 */
	public void removeByC_U_S_T(
		long customerId, long userAllowedId, String status, String type);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_U_S_T(
		long customerId, long userAllowedId, String status, String type);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_T_First(
			long customerId, long fileId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_T_First(
		long customerId, long fileId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_T_Last(
			long customerId, long fileId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_T_Last(
		long customerId, long fileId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_F_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 */
	public void removeByC_F_T(long customerId, long fileId, String type);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_F_T(long customerId, long fileId, String type);

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type);

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_S_T_First(
			long customerId, long fileId, String status, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_S_T_First(
		long customerId, long fileId, String status, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_F_S_T_Last(
			long customerId, long fileId, String status, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_F_S_T_Last(
		long customerId, long fileId, String status, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry[] findByC_F_S_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String status, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 */
	public void removeByC_F_S_T(
		long customerId, long fileId, String status, String type);

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_F_S_T(
		long customerId, long fileId, String status, String type);

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public DGFileUserPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file user permission entry that was removed
	 */
	public DGFileUserPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the number of dg file user permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file user permission entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dg file user permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileUserPermissionEntry the dg file user permission entry
	 */
	public void cacheResult(
		DGFileUserPermissionEntry dgFileUserPermissionEntry);

	/**
	 * Caches the dg file user permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileUserPermissionEntries the dg file user permission entries
	 */
	public void cacheResult(
		java.util.List<DGFileUserPermissionEntry> dgFileUserPermissionEntries);

	/**
	 * Creates a new dg file user permission entry with the primary key. Does not add the dg file user permission entry to the database.
	 *
	 * @param fileUserPermissionId the primary key for the new dg file user permission entry
	 * @return the new dg file user permission entry
	 */
	public DGFileUserPermissionEntry create(long fileUserPermissionId);

	/**
	 * Removes the dg file user permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry that was removed
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry remove(long fileUserPermissionId)
		throws NoSuchDGFileUserPermissionEntryException;

	public DGFileUserPermissionEntry updateImpl(
		DGFileUserPermissionEntry dgFileUserPermissionEntry);

	/**
	 * Returns the dg file user permission entry with the primary key or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry findByPrimaryKey(long fileUserPermissionId)
		throws NoSuchDGFileUserPermissionEntryException;

	/**
	 * Returns the dg file user permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry, or <code>null</code> if a dg file user permission entry with the primary key could not be found
	 */
	public DGFileUserPermissionEntry fetchByPrimaryKey(
		long fileUserPermissionId);

	/**
	 * Returns all the dg file user permission entries.
	 *
	 * @return the dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findAll();

	/**
	 * Returns a range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file user permission entries
	 */
	public java.util.List<DGFileUserPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dg file user permission entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dg file user permission entries.
	 *
	 * @return the number of dg file user permission entries
	 */
	public int countAll();

}