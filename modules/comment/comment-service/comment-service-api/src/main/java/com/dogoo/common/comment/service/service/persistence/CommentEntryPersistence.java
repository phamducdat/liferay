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

import com.dogoo.common.comment.service.exception.NoSuchCommentEntryException;
import com.dogoo.common.comment.service.model.CommentEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the comment entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentEntryUtil
 * @generated
 */
@ProviderType
public interface CommentEntryPersistence extends BasePersistence<CommentEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentEntryUtil} to access the comment entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the comment entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the comment entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public CommentEntry[] findByUuid_PrevAndNext(
			long commentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Removes all the comment entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of comment entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comment entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the comment entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comment entry that was removed
	 */
	public CommentEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the number of comment entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comment entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public CommentEntry[] findByUuid_C_PrevAndNext(
			long commentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Removes all the comment entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comment entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName);

	/**
	 * Returns a range of all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start,
		int end);

	/**
	 * Returns an ordered range of all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByC_C_C_First(
			long customerId, long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the first comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByC_C_C_First(
		long customerId, long classPkId, String classPkName,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the last comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByC_C_C_Last(
			long customerId, long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the last comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByC_C_C_Last(
		long customerId, long classPkId, String classPkName,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public CommentEntry[] findByC_C_C_PrevAndNext(
			long commentId, long customerId, long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Removes all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	public void removeByC_C_C(
		long customerId, long classPkId, String classPkName);

	/**
	 * Returns the number of comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching comment entries
	 */
	public int countByC_C_C(
		long customerId, long classPkId, String classPkName);

	/**
	 * Returns all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @return the matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId);

	/**
	 * Returns a range of all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId,
		int start, int end);

	/**
	 * Returns an ordered range of all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByC_C_C_P_First(
			long customerId, long classPkId, String classPkName, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the first comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByC_C_C_P_First(
		long customerId, long classPkId, String classPkName, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the last comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByC_C_C_P_Last(
			long customerId, long classPkId, String classPkName, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the last comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByC_C_C_P_Last(
		long customerId, long classPkId, String classPkName, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public CommentEntry[] findByC_C_C_P_PrevAndNext(
			long commentId, long customerId, long classPkId, String classPkName,
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Removes all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 */
	public void removeByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId);

	/**
	 * Returns the number of comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @return the number of matching comment entries
	 */
	public int countByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId);

	/**
	 * Returns all the comment entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching comment entries
	 */
	public java.util.List<CommentEntry> findByP_(long parentId);

	/**
	 * Returns a range of all the comment entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByP_(
		long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the comment entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByP_(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comment entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public java.util.List<CommentEntry> findByP_(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByP__First(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the first comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByP__First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the last comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByP__Last(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the last comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByP__Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public CommentEntry[] findByP__PrevAndNext(
			long commentId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
				orderByComparator)
		throws NoSuchCommentEntryException;

	/**
	 * Removes all the comment entries where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public void removeByP_(long parentId);

	/**
	 * Returns the number of comment entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching comment entries
	 */
	public int countByP_(long parentId);

	/**
	 * Returns the comment entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public CommentEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the comment entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the comment entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public CommentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the comment entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the comment entry that was removed
	 */
	public CommentEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the number of comment entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching comment entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the comment entry in the entity cache if it is enabled.
	 *
	 * @param commentEntry the comment entry
	 */
	public void cacheResult(CommentEntry commentEntry);

	/**
	 * Caches the comment entries in the entity cache if it is enabled.
	 *
	 * @param commentEntries the comment entries
	 */
	public void cacheResult(java.util.List<CommentEntry> commentEntries);

	/**
	 * Creates a new comment entry with the primary key. Does not add the comment entry to the database.
	 *
	 * @param commentId the primary key for the new comment entry
	 * @return the new comment entry
	 */
	public CommentEntry create(long commentId);

	/**
	 * Removes the comment entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry that was removed
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public CommentEntry remove(long commentId)
		throws NoSuchCommentEntryException;

	public CommentEntry updateImpl(CommentEntry commentEntry);

	/**
	 * Returns the comment entry with the primary key or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public CommentEntry findByPrimaryKey(long commentId)
		throws NoSuchCommentEntryException;

	/**
	 * Returns the comment entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry, or <code>null</code> if a comment entry with the primary key could not be found
	 */
	public CommentEntry fetchByPrimaryKey(long commentId);

	/**
	 * Returns all the comment entries.
	 *
	 * @return the comment entries
	 */
	public java.util.List<CommentEntry> findAll();

	/**
	 * Returns a range of all the comment entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of comment entries
	 */
	public java.util.List<CommentEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the comment entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comment entries
	 */
	public java.util.List<CommentEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comment entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comment entries
	 */
	public java.util.List<CommentEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the comment entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comment entries.
	 *
	 * @return the number of comment entries
	 */
	public int countAll();

}