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

package com.dogoo.common.auditing.service.service.persistence;

import com.dogoo.common.auditing.service.exception.NoSuchAuditingEntryException;
import com.dogoo.common.auditing.service.model.AuditingEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the auditing entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditingEntryUtil
 * @generated
 */
@ProviderType
public interface AuditingEntryPersistence
	extends BasePersistence<AuditingEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditingEntryUtil} to access the auditing entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the auditing entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public AuditingEntry[] findByUuid_PrevAndNext(
			long auditingId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Removes all the auditing entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of auditing entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditing entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the auditing entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the auditing entry that was removed
	 */
	public AuditingEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the number of auditing entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching auditing entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public AuditingEntry[] findByUuid_C_PrevAndNext(
			long auditingId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Removes all the auditing entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching auditing entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName);

	/**
	 * Returns a range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end);

	/**
	 * Returns an ordered range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByPK_Name_First(
			long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the first auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByPK_Name_First(
		long classPkId, String classPkName,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the last auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByPK_Name_Last(
			long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the last auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByPK_Name_Last(
		long classPkId, String classPkName,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public AuditingEntry[] findByPK_Name_PrevAndNext(
			long auditingId, long classPkId, String classPkName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Removes all the auditing entries where classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	public void removeByPK_Name(long classPkId, String classPkName);

	/**
	 * Returns the number of auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching auditing entries
	 */
	public int countByPK_Name(long classPkId, String classPkName);

	/**
	 * Returns all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @return the matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName);

	/**
	 * Returns a range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end);

	/**
	 * Returns an ordered range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	public java.util.List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByParent_PK_Name_First(
			Long parentPkId, String parentPkName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the first auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByParent_PK_Name_First(
		Long parentPkId, String parentPkName,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the last auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByParent_PK_Name_Last(
			Long parentPkId, String parentPkName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the last auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByParent_PK_Name_Last(
		Long parentPkId, String parentPkName,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public AuditingEntry[] findByParent_PK_Name_PrevAndNext(
			long auditingId, Long parentPkId, String parentPkName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
				orderByComparator)
		throws NoSuchAuditingEntryException;

	/**
	 * Removes all the auditing entries where parentPkId = &#63; and parentPkName = &#63; from the database.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 */
	public void removeByParent_PK_Name(Long parentPkId, String parentPkName);

	/**
	 * Returns the number of auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @return the number of matching auditing entries
	 */
	public int countByParent_PK_Name(Long parentPkId, String parentPkName);

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	public AuditingEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	public AuditingEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the auditing entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the auditing entry that was removed
	 */
	public AuditingEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the number of auditing entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching auditing entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the auditing entry in the entity cache if it is enabled.
	 *
	 * @param auditingEntry the auditing entry
	 */
	public void cacheResult(AuditingEntry auditingEntry);

	/**
	 * Caches the auditing entries in the entity cache if it is enabled.
	 *
	 * @param auditingEntries the auditing entries
	 */
	public void cacheResult(java.util.List<AuditingEntry> auditingEntries);

	/**
	 * Creates a new auditing entry with the primary key. Does not add the auditing entry to the database.
	 *
	 * @param auditingId the primary key for the new auditing entry
	 * @return the new auditing entry
	 */
	public AuditingEntry create(long auditingId);

	/**
	 * Removes the auditing entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry that was removed
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public AuditingEntry remove(long auditingId)
		throws NoSuchAuditingEntryException;

	public AuditingEntry updateImpl(AuditingEntry auditingEntry);

	/**
	 * Returns the auditing entry with the primary key or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	public AuditingEntry findByPrimaryKey(long auditingId)
		throws NoSuchAuditingEntryException;

	/**
	 * Returns the auditing entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry, or <code>null</code> if a auditing entry with the primary key could not be found
	 */
	public AuditingEntry fetchByPrimaryKey(long auditingId);

	/**
	 * Returns all the auditing entries.
	 *
	 * @return the auditing entries
	 */
	public java.util.List<AuditingEntry> findAll();

	/**
	 * Returns a range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of auditing entries
	 */
	public java.util.List<AuditingEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditing entries
	 */
	public java.util.List<AuditingEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auditing entries
	 */
	public java.util.List<AuditingEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditingEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the auditing entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of auditing entries.
	 *
	 * @return the number of auditing entries
	 */
	public int countAll();

}