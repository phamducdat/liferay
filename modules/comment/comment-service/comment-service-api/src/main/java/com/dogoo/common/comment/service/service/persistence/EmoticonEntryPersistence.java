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

package com.dogoo.common.comment.service.service.persistence;

import com.dogoo.common.comment.service.exception.NoSuchEmoticonEntryException;
import com.dogoo.common.comment.service.model.EmoticonEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the emoticon entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmoticonEntryUtil
 * @generated
 */
@ProviderType
public interface EmoticonEntryPersistence
	extends BasePersistence<EmoticonEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmoticonEntryUtil} to access the emoticon entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the emoticon entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the emoticon entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns the emoticon entries before and after the current emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param emoticonId the primary key of the current emoticon entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public EmoticonEntry[] findByUuid_PrevAndNext(
			long emoticonId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Removes all the emoticon entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of emoticon entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emoticon entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the emoticon entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the emoticon entry that was removed
	 */
	public EmoticonEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the number of emoticon entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching emoticon entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns the emoticon entries before and after the current emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param emoticonId the primary key of the current emoticon entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public EmoticonEntry[] findByUuid_C_PrevAndNext(
			long emoticonId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Removes all the emoticon entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emoticon entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName);

	/**
	 * Returns a range of all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start,
		int end);

	/**
	 * Returns an ordered range of all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emoticon entries
	 */
	public java.util.List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByC_C_C_First(
			long customerId, long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the first emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByC_C_C_First(
		long customerId, long classPkId, String classPkName,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns the last emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByC_C_C_Last(
			long customerId, long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the last emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByC_C_C_Last(
		long customerId, long classPkId, String classPkName,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns the emoticon entries before and after the current emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param emoticonId the primary key of the current emoticon entry
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public EmoticonEntry[] findByC_C_C_PrevAndNext(
			long emoticonId, long customerId, long classPkId,
			String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
				orderByComparator)
		throws NoSuchEmoticonEntryException;

	/**
	 * Removes all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	public void removeByC_C_C(
		long customerId, long classPkId, String classPkName);

	/**
	 * Returns the number of emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching emoticon entries
	 */
	public int countByC_C_C(
		long customerId, long classPkId, String classPkName);

	/**
	 * Returns the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByC_C_C_C(
			long customerId, long classPkId, String classPkName, long creatorId)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId);

	/**
	 * Returns the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId,
		boolean useFinderCache);

	/**
	 * Removes the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the emoticon entry that was removed
	 */
	public EmoticonEntry removeByC_C_C_C(
			long customerId, long classPkId, String classPkName, long creatorId)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the number of emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the number of matching emoticon entries
	 */
	public int countByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId);

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	public EmoticonEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public EmoticonEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the emoticon entry that was removed
	 */
	public EmoticonEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the number of emoticon entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching emoticon entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the emoticon entry in the entity cache if it is enabled.
	 *
	 * @param emoticonEntry the emoticon entry
	 */
	public void cacheResult(EmoticonEntry emoticonEntry);

	/**
	 * Caches the emoticon entries in the entity cache if it is enabled.
	 *
	 * @param emoticonEntries the emoticon entries
	 */
	public void cacheResult(java.util.List<EmoticonEntry> emoticonEntries);

	/**
	 * Creates a new emoticon entry with the primary key. Does not add the emoticon entry to the database.
	 *
	 * @param emoticonId the primary key for the new emoticon entry
	 * @return the new emoticon entry
	 */
	public EmoticonEntry create(long emoticonId);

	/**
	 * Removes the emoticon entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry that was removed
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public EmoticonEntry remove(long emoticonId)
		throws NoSuchEmoticonEntryException;

	public EmoticonEntry updateImpl(EmoticonEntry emoticonEntry);

	/**
	 * Returns the emoticon entry with the primary key or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	public EmoticonEntry findByPrimaryKey(long emoticonId)
		throws NoSuchEmoticonEntryException;

	/**
	 * Returns the emoticon entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry, or <code>null</code> if a emoticon entry with the primary key could not be found
	 */
	public EmoticonEntry fetchByPrimaryKey(long emoticonId);

	/**
	 * Returns all the emoticon entries.
	 *
	 * @return the emoticon entries
	 */
	public java.util.List<EmoticonEntry> findAll();

	/**
	 * Returns a range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of emoticon entries
	 */
	public java.util.List<EmoticonEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emoticon entries
	 */
	public java.util.List<EmoticonEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of emoticon entries
	 */
	public java.util.List<EmoticonEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmoticonEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the emoticon entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of emoticon entries.
	 *
	 * @return the number of emoticon entries
	 */
	public int countAll();

}