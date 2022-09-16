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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFilePermissionException;
import com.dogoo.common.files.manager.service.model.DGFilePermission;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dg file permission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionUtil
 * @generated
 */
@ProviderType
public interface DGFilePermissionPersistence
	extends BasePersistence<DGFilePermission> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGFilePermissionUtil} to access the dg file permission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dg file permissions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid(String uuid);

	/**
	 * Returns a range of all the dg file permissions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @return the range of matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	public DGFilePermission findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
				orderByComparator)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the first dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator);

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	public DGFilePermission findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
				orderByComparator)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator);

	/**
	 * Returns the dg file permissions before and after the current dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param filePermissionId the primary key of the current dg file permission
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file permission
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	public DGFilePermission[] findByUuid_PrevAndNext(
			long filePermissionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
				orderByComparator)
		throws NoSuchDGFilePermissionException;

	/**
	 * Removes all the dg file permissions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dg file permissions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file permissions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dg file permission where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFilePermissionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	public DGFilePermission findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the dg file permission where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dg file permission where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dg file permission where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file permission that was removed
	 */
	public DGFilePermission removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the number of dg file permissions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file permissions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @return the range of matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file permissions
	 */
	public java.util.List<DGFilePermission> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	public DGFilePermission findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
				orderByComparator)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the first dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator);

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	public DGFilePermission findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
				orderByComparator)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator);

	/**
	 * Returns the dg file permissions before and after the current dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param filePermissionId the primary key of the current dg file permission
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file permission
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	public DGFilePermission[] findByUuid_C_PrevAndNext(
			long filePermissionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
				orderByComparator)
		throws NoSuchDGFilePermissionException;

	/**
	 * Removes all the dg file permissions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file permissions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the dg file permission where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFilePermissionException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	public DGFilePermission findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the dg file permission where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg file permission where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public DGFilePermission fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dg file permission where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file permission that was removed
	 */
	public DGFilePermission removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the number of dg file permissions where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file permissions
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dg file permission in the entity cache if it is enabled.
	 *
	 * @param dgFilePermission the dg file permission
	 */
	public void cacheResult(DGFilePermission dgFilePermission);

	/**
	 * Caches the dg file permissions in the entity cache if it is enabled.
	 *
	 * @param dgFilePermissions the dg file permissions
	 */
	public void cacheResult(java.util.List<DGFilePermission> dgFilePermissions);

	/**
	 * Creates a new dg file permission with the primary key. Does not add the dg file permission to the database.
	 *
	 * @param filePermissionId the primary key for the new dg file permission
	 * @return the new dg file permission
	 */
	public DGFilePermission create(long filePermissionId);

	/**
	 * Removes the dg file permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission that was removed
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	public DGFilePermission remove(long filePermissionId)
		throws NoSuchDGFilePermissionException;

	public DGFilePermission updateImpl(DGFilePermission dgFilePermission);

	/**
	 * Returns the dg file permission with the primary key or throws a <code>NoSuchDGFilePermissionException</code> if it could not be found.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	public DGFilePermission findByPrimaryKey(long filePermissionId)
		throws NoSuchDGFilePermissionException;

	/**
	 * Returns the dg file permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission, or <code>null</code> if a dg file permission with the primary key could not be found
	 */
	public DGFilePermission fetchByPrimaryKey(long filePermissionId);

	/**
	 * Returns all the dg file permissions.
	 *
	 * @return the dg file permissions
	 */
	public java.util.List<DGFilePermission> findAll();

	/**
	 * Returns a range of all the dg file permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @return the range of dg file permissions
	 */
	public java.util.List<DGFilePermission> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dg file permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file permissions
	 */
	public java.util.List<DGFilePermission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg file permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file permissions
	 */
	public java.util.List<DGFilePermission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGFilePermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dg file permissions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dg file permissions.
	 *
	 * @return the number of dg file permissions
	 */
	public int countAll();

}