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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileDepartmentPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dg file department permission entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileDepartmentPermissionEntryUtil
 * @generated
 */
@ProviderType
public interface DGFileDepartmentPermissionEntryPersistence
	extends BasePersistence<DGFileDepartmentPermissionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGFileDepartmentPermissionEntryUtil} to access the dg file department permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dg file department permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry[] findByUuid_PrevAndNext(
			long fileDepartmentPermissionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Removes all the dg file department permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file department permission entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByUUID_G(
			String uuid, long groupId)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dg file department permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file department permission entry that was removed
	 */
	public DGFileDepartmentPermissionEntry removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file department permission entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileDepartmentPermissionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Removes all the dg file department permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file department permission entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_D_F(
			long customerId, long departmentId, long fileId)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_F(
		long customerId, long departmentId, long fileId);

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_F(
		long customerId, long departmentId, long fileId,
		boolean useFinderCache);

	/**
	 * Removes the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the dg file department permission entry that was removed
	 */
	public DGFileDepartmentPermissionEntry removeByC_D_F(
			long customerId, long departmentId, long fileId)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the number of matching dg file department permission entries
	 */
	public int countByC_D_F(long customerId, long departmentId, long fileId);

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @return the matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId);

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_D_First(
			long customerId, long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_First(
		long customerId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_D_Last(
			long customerId, long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_Last(
		long customerId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry[] findByC_D_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and departmentId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 */
	public void removeByC_D(long customerId, long departmentId);

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @return the number of matching dg file department permission entries
	 */
	public int countByC_D(long customerId, long departmentId);

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId);

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_F_First(
			long customerId, long fileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_F_First(
		long customerId, long fileId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_F_Last(
			long customerId, long fileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_F_Last(
		long customerId, long fileId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry[] findByC_F_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long fileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 */
	public void removeByC_F(long customerId, long fileId);

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file department permission entries
	 */
	public int countByC_F(long customerId, long fileId);

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_D_F_T(
			long customerId, long departmentId, long fileId, String type)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_F_T(
		long customerId, long departmentId, long fileId, String type);

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_F_T(
		long customerId, long departmentId, long fileId, String type,
		boolean useFinderCache);

	/**
	 * Removes the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file department permission entry that was removed
	 */
	public DGFileDepartmentPermissionEntry removeByC_D_F_T(
			long customerId, long departmentId, long fileId, String type)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	public int countByC_D_F_T(
		long customerId, long departmentId, long fileId, String type);

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @return the matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type);

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_D_T_First(
			long customerId, long departmentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_T_First(
		long customerId, long departmentId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_D_T_Last(
			long customerId, long departmentId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_D_T_Last(
		long customerId, long departmentId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry[] findByC_D_T_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long departmentId,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 */
	public void removeByC_D_T(long customerId, long departmentId, String type);

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	public int countByC_D_T(long customerId, long departmentId, String type);

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type);

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_F_T_First(
			long customerId, long fileId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_F_T_First(
		long customerId, long fileId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_F_T_Last(
			long customerId, long fileId, String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_F_T_Last(
		long customerId, long fileId, String type,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry[] findByC_F_T_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long fileId,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileDepartmentPermissionEntry> orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 */
	public void removeByC_F_T(long customerId, long fileId, String type);

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	public int countByC_F_T(long customerId, long fileId, String type);

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file department permission entry that was removed
	 */
	public DGFileDepartmentPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the number of dg file department permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file department permission entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dg file department permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileDepartmentPermissionEntry the dg file department permission entry
	 */
	public void cacheResult(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry);

	/**
	 * Caches the dg file department permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileDepartmentPermissionEntries the dg file department permission entries
	 */
	public void cacheResult(
		java.util.List<DGFileDepartmentPermissionEntry>
			dgFileDepartmentPermissionEntries);

	/**
	 * Creates a new dg file department permission entry with the primary key. Does not add the dg file department permission entry to the database.
	 *
	 * @param fileDepartmentPermissionId the primary key for the new dg file department permission entry
	 * @return the new dg file department permission entry
	 */
	public DGFileDepartmentPermissionEntry create(
		long fileDepartmentPermissionId);

	/**
	 * Removes the dg file department permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry that was removed
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry remove(
			long fileDepartmentPermissionId)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	public DGFileDepartmentPermissionEntry updateImpl(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry);

	/**
	 * Returns the dg file department permission entry with the primary key or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry findByPrimaryKey(
			long fileDepartmentPermissionId)
		throws NoSuchDGFileDepartmentPermissionEntryException;

	/**
	 * Returns the dg file department permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry, or <code>null</code> if a dg file department permission entry with the primary key could not be found
	 */
	public DGFileDepartmentPermissionEntry fetchByPrimaryKey(
		long fileDepartmentPermissionId);

	/**
	 * Returns all the dg file department permission entries.
	 *
	 * @return the dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findAll();

	/**
	 * Returns a range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file department permission entries
	 */
	public java.util.List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dg file department permission entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dg file department permission entries.
	 *
	 * @return the number of dg file department permission entries
	 */
	public int countAll();

}