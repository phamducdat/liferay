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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileSettingPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dg file setting permission entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileSettingPermissionEntryUtil
 * @generated
 */
@ProviderType
public interface DGFileSettingPermissionEntryPersistence
	extends BasePersistence<DGFileSettingPermissionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGFileSettingPermissionEntryUtil} to access the dg file setting permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dg file setting permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the dg file setting permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file setting permission entries before and after the current dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileSettingPermissionId the primary key of the current dg file setting permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	public DGFileSettingPermissionEntry[] findByUuid_PrevAndNext(
			long fileSettingPermissionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Removes all the dg file setting permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dg file setting permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file setting permission entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dg file setting permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the dg file setting permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the dg file setting permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dg file setting permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file setting permission entry that was removed
	 */
	public DGFileSettingPermissionEntry removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the number of dg file setting permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file setting permission entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns the dg file setting permission entries before and after the current dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileSettingPermissionId the primary key of the current dg file setting permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	public DGFileSettingPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileSettingPermissionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Removes all the dg file setting permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file setting permission entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByC_F(long customerId, long fileId)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByC_F(
		long customerId, long fileId);

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByC_F(
		long customerId, long fileId, boolean useFinderCache);

	/**
	 * Removes the dg file setting permission entry where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the dg file setting permission entry that was removed
	 */
	public DGFileSettingPermissionEntry removeByC_F(
			long customerId, long fileId)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the number of dg file setting permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file setting permission entries
	 */
	public int countByC_F(long customerId, long fileId);

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByC_F_T(
			long customerId, long fileId, String type)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByC_F_T(
		long customerId, long fileId, String type);

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByC_F_T(
		long customerId, long fileId, String type, boolean useFinderCache);

	/**
	 * Removes the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file setting permission entry that was removed
	 */
	public DGFileSettingPermissionEntry removeByC_F_T(
			long customerId, long fileId, String type)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the number of dg file setting permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file setting permission entries
	 */
	public int countByC_F_T(long customerId, long fileId, String type);

	/**
	 * Returns the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	public DGFileSettingPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file setting permission entry that was removed
	 */
	public DGFileSettingPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the number of dg file setting permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file setting permission entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dg file setting permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 */
	public void cacheResult(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry);

	/**
	 * Caches the dg file setting permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileSettingPermissionEntries the dg file setting permission entries
	 */
	public void cacheResult(
		java.util.List<DGFileSettingPermissionEntry>
			dgFileSettingPermissionEntries);

	/**
	 * Creates a new dg file setting permission entry with the primary key. Does not add the dg file setting permission entry to the database.
	 *
	 * @param fileSettingPermissionId the primary key for the new dg file setting permission entry
	 * @return the new dg file setting permission entry
	 */
	public DGFileSettingPermissionEntry create(long fileSettingPermissionId);

	/**
	 * Removes the dg file setting permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry that was removed
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	public DGFileSettingPermissionEntry remove(long fileSettingPermissionId)
		throws NoSuchDGFileSettingPermissionEntryException;

	public DGFileSettingPermissionEntry updateImpl(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry);

	/**
	 * Returns the dg file setting permission entry with the primary key or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	public DGFileSettingPermissionEntry findByPrimaryKey(
			long fileSettingPermissionId)
		throws NoSuchDGFileSettingPermissionEntryException;

	/**
	 * Returns the dg file setting permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry, or <code>null</code> if a dg file setting permission entry with the primary key could not be found
	 */
	public DGFileSettingPermissionEntry fetchByPrimaryKey(
		long fileSettingPermissionId);

	/**
	 * Returns all the dg file setting permission entries.
	 *
	 * @return the dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findAll();

	/**
	 * Returns a range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file setting permission entries
	 */
	public java.util.List<DGFileSettingPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DGFileSettingPermissionEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dg file setting permission entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dg file setting permission entries.
	 *
	 * @return the number of dg file setting permission entries
	 */
	public int countAll();

}