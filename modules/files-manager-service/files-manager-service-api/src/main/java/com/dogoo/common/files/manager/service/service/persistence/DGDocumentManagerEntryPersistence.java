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

import com.dogoo.common.files.manager.service.exception.NoSuchDGDocumentManagerEntryException;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dg document manager entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGDocumentManagerEntryUtil
 * @generated
 */
@ProviderType
public interface DGDocumentManagerEntryPersistence
	extends BasePersistence<DGDocumentManagerEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DGDocumentManagerEntryUtil} to access the dg document manager entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dg document manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry[] findByUuid_PrevAndNext(
			long documentManagerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Removes all the dg document manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dg document manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg document manager entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dg document manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg document manager entry that was removed
	 */
	public DGDocumentManagerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the number of dg document manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg document manager entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry[] findByUuid_C_PrevAndNext(
			long documentManagerId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Removes all the dg document manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg document manager entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the dg document manager entries where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @return the matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_(String pkCode);

	/**
	 * Returns a range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end);

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByPC__First(
			String pkCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByPC__First(
		String pkCode,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByPC__Last(
			String pkCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByPC__Last(
		String pkCode,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry[] findByPC__PrevAndNext(
			long documentManagerId, String pkCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Removes all the dg document manager entries where pkCode = &#63; from the database.
	 *
	 * @param pkCode the pk code
	 */
	public void removeByPC_(String pkCode);

	/**
	 * Returns the number of dg document manager entries where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @return the number of matching dg document manager entries
	 */
	public int countByPC_(String pkCode);

	/**
	 * Returns all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @return the matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId);

	/**
	 * Returns a range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByPC_PI_First(
			String pkCode, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByPC_PI_First(
		String pkCode, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByPC_PI_Last(
			String pkCode, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByPC_PI_Last(
		String pkCode, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry[] findByPC_PI_PrevAndNext(
			long documentManagerId, String pkCode, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Removes all the dg document manager entries where pkCode = &#63; and parentId = &#63; from the database.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 */
	public void removeByPC_PI(String pkCode, long parentId);

	/**
	 * Returns the number of dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	public int countByPC_PI(String pkCode, long parentId);

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByN_T_PC_PI_C_CI(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId);

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId, boolean useFinderCache);

	/**
	 * Removes the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; from the database.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the dg document manager entry that was removed
	 */
	public DGDocumentManagerEntry removeByN_T_PC_PI_C_CI(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the number of dg document manager entries where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the number of matching dg document manager entries
	 */
	public int countByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId);

	/**
	 * Returns the dg document manager entry where fileId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByFI_(long fileId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the dg document manager entry where fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByFI_(long fileId);

	/**
	 * Returns the dg document manager entry where fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByFI_(
		long fileId, boolean useFinderCache);

	/**
	 * Removes the dg document manager entry where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @return the dg document manager entry that was removed
	 */
	public DGDocumentManagerEntry removeByFI_(long fileId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the number of dg document manager entries where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching dg document manager entries
	 */
	public int countByFI_(long fileId);

	/**
	 * Returns all the dg document manager entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPI_(long parentId);

	/**
	 * Returns a range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByPI__First(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the first dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByPI__First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the last dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByPI__Last(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the last dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByPI__Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry[] findByPI__PrevAndNext(
			long documentManagerId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Removes all the dg document manager entries where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public void removeByPI_(long parentId);

	/**
	 * Returns the number of dg document manager entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	public int countByPI_(long parentId);

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByN_PI(String name, long parentId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByN_PI(String name, long parentId);

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByN_PI(
		String name, long parentId, boolean useFinderCache);

	/**
	 * Removes the dg document manager entry where name = &#63; and parentId = &#63; from the database.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the dg document manager entry that was removed
	 */
	public DGDocumentManagerEntry removeByN_PI(String name, long parentId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the number of dg document manager entries where name = &#63; and parentId = &#63;.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	public int countByN_PI(String name, long parentId);

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByN_PI_FE_PC(
			String name, long parentId, String fileExtension, String pkCode)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode);

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode,
		boolean useFinderCache);

	/**
	 * Removes the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; from the database.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the dg document manager entry that was removed
	 */
	public DGDocumentManagerEntry removeByN_PI_FE_PC(
			String name, long parentId, String fileExtension, String pkCode)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the number of dg document manager entries where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63;.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the number of matching dg document manager entries
	 */
	public int countByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode);

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public DGDocumentManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg document manager entry that was removed
	 */
	public DGDocumentManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the number of dg document manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg document manager entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dg document manager entry in the entity cache if it is enabled.
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 */
	public void cacheResult(DGDocumentManagerEntry dgDocumentManagerEntry);

	/**
	 * Caches the dg document manager entries in the entity cache if it is enabled.
	 *
	 * @param dgDocumentManagerEntries the dg document manager entries
	 */
	public void cacheResult(
		java.util.List<DGDocumentManagerEntry> dgDocumentManagerEntries);

	/**
	 * Creates a new dg document manager entry with the primary key. Does not add the dg document manager entry to the database.
	 *
	 * @param documentManagerId the primary key for the new dg document manager entry
	 * @return the new dg document manager entry
	 */
	public DGDocumentManagerEntry create(long documentManagerId);

	/**
	 * Removes the dg document manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry that was removed
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry remove(long documentManagerId)
		throws NoSuchDGDocumentManagerEntryException;

	public DGDocumentManagerEntry updateImpl(
		DGDocumentManagerEntry dgDocumentManagerEntry);

	/**
	 * Returns the dg document manager entry with the primary key or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry findByPrimaryKey(long documentManagerId)
		throws NoSuchDGDocumentManagerEntryException;

	/**
	 * Returns the dg document manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry, or <code>null</code> if a dg document manager entry with the primary key could not be found
	 */
	public DGDocumentManagerEntry fetchByPrimaryKey(long documentManagerId);

	/**
	 * Returns all the dg document manager entries.
	 *
	 * @return the dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findAll();

	/**
	 * Returns a range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg document manager entries
	 */
	public java.util.List<DGDocumentManagerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DGDocumentManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dg document manager entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dg document manager entries.
	 *
	 * @return the number of dg document manager entries
	 */
	public int countAll();

}