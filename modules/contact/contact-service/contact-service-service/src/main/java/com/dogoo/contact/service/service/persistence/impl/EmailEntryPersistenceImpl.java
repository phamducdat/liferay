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

package com.dogoo.contact.service.service.persistence.impl;

import com.dogoo.contact.service.exception.NoSuchEmailEntryException;
import com.dogoo.contact.service.model.EmailEntry;
import com.dogoo.contact.service.model.EmailEntryTable;
import com.dogoo.contact.service.model.impl.EmailEntryImpl;
import com.dogoo.contact.service.model.impl.EmailEntryModelImpl;
import com.dogoo.contact.service.service.persistence.EmailEntryPersistence;
import com.dogoo.contact.service.service.persistence.EmailEntryUtil;
import com.dogoo.contact.service.service.persistence.impl.constants.CNTPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the email entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {EmailEntryPersistence.class, BasePersistence.class})
public class EmailEntryPersistenceImpl
	extends BasePersistenceImpl<EmailEntry> implements EmailEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmailEntryUtil</code> to access the email entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmailEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the email entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<EmailEntry> list = null;

		if (useFinderCache) {
			list = (List<EmailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmailEntry emailEntry : list) {
					if (!uuid.equals(emailEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<EmailEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByUuid_First(
			String uuid, OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByUuid_First(uuid, orderByComparator);

		if (emailEntry != null) {
			return emailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmailEntryException(sb.toString());
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByUuid_First(
		String uuid, OrderByComparator<EmailEntry> orderByComparator) {

		List<EmailEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByUuid_Last(
			String uuid, OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (emailEntry != null) {
			return emailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmailEntryException(sb.toString());
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByUuid_Last(
		String uuid, OrderByComparator<EmailEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmailEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the email entries before and after the current email entry in the ordered set where uuid = &#63;.
	 *
	 * @param emailId the primary key of the current email entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry[] findByUuid_PrevAndNext(
			long emailId, String uuid,
			OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		uuid = Objects.toString(uuid, "");

		EmailEntry emailEntry = findByPrimaryKey(emailId);

		Session session = null;

		try {
			session = openSession();

			EmailEntry[] array = new EmailEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, emailEntry, uuid, orderByComparator, true);

			array[1] = emailEntry;

			array[2] = getByUuid_PrevAndNext(
				session, emailEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmailEntry getByUuid_PrevAndNext(
		Session session, EmailEntry emailEntry, String uuid,
		OrderByComparator<EmailEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(emailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmailEntry emailEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(emailEntry);
		}
	}

	/**
	 * Returns the number of email entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching email entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMAILENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"emailEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(emailEntry.uuid IS NULL OR emailEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByUUID_G(uuid, groupId);

		if (emailEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmailEntryException(sb.toString());
		}

		return emailEntry;
	}

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the email entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof EmailEntry) {
			EmailEntry emailEntry = (EmailEntry)result;

			if (!Objects.equals(uuid, emailEntry.getUuid()) ||
				(groupId != emailEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<EmailEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmailEntry emailEntry = list.get(0);

					result = emailEntry;

					cacheResult(emailEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmailEntry)result;
		}
	}

	/**
	 * Removes the email entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the email entry that was removed
	 */
	@Override
	public EmailEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = findByUUID_G(uuid, groupId);

		return remove(emailEntry);
	}

	/**
	 * Returns the number of email entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching email entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAILENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"emailEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(emailEntry.uuid IS NULL OR emailEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"emailEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<EmailEntry> list = null;

		if (useFinderCache) {
			list = (List<EmailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmailEntry emailEntry : list) {
					if (!uuid.equals(emailEntry.getUuid()) ||
						(companyId != emailEntry.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<EmailEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (emailEntry != null) {
			return emailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmailEntryException(sb.toString());
	}

	/**
	 * Returns the first email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmailEntry> orderByComparator) {

		List<EmailEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (emailEntry != null) {
			return emailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmailEntryException(sb.toString());
	}

	/**
	 * Returns the last email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmailEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmailEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the email entries before and after the current email entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param emailId the primary key of the current email entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry[] findByUuid_C_PrevAndNext(
			long emailId, String uuid, long companyId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		uuid = Objects.toString(uuid, "");

		EmailEntry emailEntry = findByPrimaryKey(emailId);

		Session session = null;

		try {
			session = openSession();

			EmailEntry[] array = new EmailEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, emailEntry, uuid, companyId, orderByComparator, true);

			array[1] = emailEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, emailEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmailEntry getByUuid_C_PrevAndNext(
		Session session, EmailEntry emailEntry, String uuid, long companyId,
		OrderByComparator<EmailEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(emailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmailEntry emailEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(emailEntry);
		}
	}

	/**
	 * Returns the number of email entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching email entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAILENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"emailEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(emailEntry.uuid IS NULL OR emailEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"emailEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_C;
	private FinderPath _finderPathWithoutPaginationFindByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the matching email entries
	 */
	@Override
	public List<EmailEntry> findByC_C(long customerId, long contactId) {
		return findByC_C(
			customerId, contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end) {

		return findByC_C(customerId, contactId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return findByC_C(
			customerId, contactId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email entries
	 */
	@Override
	public List<EmailEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_C;
				finderArgs = new Object[] {customerId, contactId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_C;
			finderArgs = new Object[] {
				customerId, contactId, start, end, orderByComparator
			};
		}

		List<EmailEntry> list = null;

		if (useFinderCache) {
			list = (List<EmailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmailEntry emailEntry : list) {
					if ((customerId != emailEntry.getCustomerId()) ||
						(contactId != emailEntry.getContactId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmailEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(contactId);

				list = (List<EmailEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByC_C_First(
			long customerId, long contactId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByC_C_First(
			customerId, contactId, orderByComparator);

		if (emailEntry != null) {
			return emailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", contactId=");
		sb.append(contactId);

		sb.append("}");

		throw new NoSuchEmailEntryException(sb.toString());
	}

	/**
	 * Returns the first email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_C_First(
		long customerId, long contactId,
		OrderByComparator<EmailEntry> orderByComparator) {

		List<EmailEntry> list = findByC_C(
			customerId, contactId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByC_C_Last(
			long customerId, long contactId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByC_C_Last(
			customerId, contactId, orderByComparator);

		if (emailEntry != null) {
			return emailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", contactId=");
		sb.append(contactId);

		sb.append("}");

		throw new NoSuchEmailEntryException(sb.toString());
	}

	/**
	 * Returns the last email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_C_Last(
		long customerId, long contactId,
		OrderByComparator<EmailEntry> orderByComparator) {

		int count = countByC_C(customerId, contactId);

		if (count == 0) {
			return null;
		}

		List<EmailEntry> list = findByC_C(
			customerId, contactId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the email entries before and after the current email entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param emailId the primary key of the current email entry
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry[] findByC_C_PrevAndNext(
			long emailId, long customerId, long contactId,
			OrderByComparator<EmailEntry> orderByComparator)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = findByPrimaryKey(emailId);

		Session session = null;

		try {
			session = openSession();

			EmailEntry[] array = new EmailEntryImpl[3];

			array[0] = getByC_C_PrevAndNext(
				session, emailEntry, customerId, contactId, orderByComparator,
				true);

			array[1] = emailEntry;

			array[2] = getByC_C_PrevAndNext(
				session, emailEntry, customerId, contactId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmailEntry getByC_C_PrevAndNext(
		Session session, EmailEntry emailEntry, long customerId, long contactId,
		OrderByComparator<EmailEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_C_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_C_CONTACTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmailEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(contactId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(emailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email entries where customerId = &#63; and contactId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 */
	@Override
	public void removeByC_C(long customerId, long contactId) {
		for (EmailEntry emailEntry :
				findByC_C(
					customerId, contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(emailEntry);
		}
	}

	/**
	 * Returns the number of email entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the number of matching email entries
	 */
	@Override
	public int countByC_C(long customerId, long contactId) {
		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {customerId, contactId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_CONTACTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(contactId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_C_CUSTOMERID_2 =
		"emailEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_CONTACTID_2 =
		"emailEntry.contactId = ?";

	private FinderPath _finderPathFetchByC_E;
	private FinderPath _finderPathCountByC_E;

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByC_E(long customerId, String emailAddress)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByC_E(customerId, emailAddress);

		if (emailEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", emailAddress=");
			sb.append(emailAddress);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmailEntryException(sb.toString());
		}

		return emailEntry;
	}

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_E(long customerId, String emailAddress) {
		return fetchByC_E(customerId, emailAddress, true);
	}

	/**
	 * Returns the email entry where customerId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_E(
		long customerId, String emailAddress, boolean useFinderCache) {

		emailAddress = Objects.toString(emailAddress, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, emailAddress};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_E, finderArgs);
		}

		if (result instanceof EmailEntry) {
			EmailEntry emailEntry = (EmailEntry)result;

			if ((customerId != emailEntry.getCustomerId()) ||
				!Objects.equals(emailAddress, emailEntry.getEmailAddress())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_E_CUSTOMERID_2);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_E_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_C_E_EMAILADDRESS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
				}

				List<EmailEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_E, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, emailAddress
								};
							}

							_log.warn(
								"EmailEntryPersistenceImpl.fetchByC_E(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmailEntry emailEntry = list.get(0);

					result = emailEntry;

					cacheResult(emailEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmailEntry)result;
		}
	}

	/**
	 * Removes the email entry where customerId = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the email entry that was removed
	 */
	@Override
	public EmailEntry removeByC_E(long customerId, String emailAddress)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = findByC_E(customerId, emailAddress);

		return remove(emailEntry);
	}

	/**
	 * Returns the number of email entries where customerId = &#63; and emailAddress = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param emailAddress the email address
	 * @return the number of matching email entries
	 */
	@Override
	public int countByC_E(long customerId, String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByC_E;

		Object[] finderArgs = new Object[] {customerId, emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_E_CUSTOMERID_2);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_E_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_C_E_EMAILADDRESS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_E_CUSTOMERID_2 =
		"emailEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_E_EMAILADDRESS_2 =
		"emailEntry.emailAddress = ?";

	private static final String _FINDER_COLUMN_C_E_EMAILADDRESS_3 =
		"(emailEntry.emailAddress IS NULL OR emailEntry.emailAddress = '')";

	private FinderPath _finderPathFetchByC_I;
	private FinderPath _finderPathCountByC_I;

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByC_I(long customerId, boolean isDefaulted)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByC_I(customerId, isDefaulted);

		if (emailEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", isDefaulted=");
			sb.append(isDefaulted);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmailEntryException(sb.toString());
		}

		return emailEntry;
	}

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_I(long customerId, boolean isDefaulted) {
		return fetchByC_I(customerId, isDefaulted, true);
	}

	/**
	 * Returns the email entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_I(
		long customerId, boolean isDefaulted, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, isDefaulted};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_I, finderArgs);
		}

		if (result instanceof EmailEntry) {
			EmailEntry emailEntry = (EmailEntry)result;

			if ((customerId != emailEntry.getCustomerId()) ||
				(isDefaulted != emailEntry.isIsDefaulted())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_I_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_I_ISDEFAULTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(isDefaulted);

				List<EmailEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_I, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, isDefaulted
								};
							}

							_log.warn(
								"EmailEntryPersistenceImpl.fetchByC_I(long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmailEntry emailEntry = list.get(0);

					result = emailEntry;

					cacheResult(emailEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmailEntry)result;
		}
	}

	/**
	 * Removes the email entry where customerId = &#63; and isDefaulted = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the email entry that was removed
	 */
	@Override
	public EmailEntry removeByC_I(long customerId, boolean isDefaulted)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = findByC_I(customerId, isDefaulted);

		return remove(emailEntry);
	}

	/**
	 * Returns the number of email entries where customerId = &#63; and isDefaulted = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the number of matching email entries
	 */
	@Override
	public int countByC_I(long customerId, boolean isDefaulted) {
		FinderPath finderPath = _finderPathCountByC_I;

		Object[] finderArgs = new Object[] {customerId, isDefaulted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_I_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_I_ISDEFAULTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(isDefaulted);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_I_CUSTOMERID_2 =
		"emailEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_I_ISDEFAULTED_2 =
		"emailEntry.isDefaulted = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching email entry
	 * @throws NoSuchEmailEntryException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByC_ERC(companyId, externalReferenceCode);

		if (emailEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", externalReferenceCode=");
			sb.append(externalReferenceCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmailEntryException(sb.toString());
		}

		return emailEntry;
	}

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the email entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, externalReferenceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_ERC, finderArgs);
		}

		if (result instanceof EmailEntry) {
			EmailEntry emailEntry = (EmailEntry)result;

			if ((companyId != emailEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					emailEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				List<EmailEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_ERC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, externalReferenceCode
								};
							}

							_log.warn(
								"EmailEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmailEntry emailEntry = list.get(0);

					result = emailEntry;

					cacheResult(emailEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmailEntry)result;
		}
	}

	/**
	 * Removes the email entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the email entry that was removed
	 */
	@Override
	public EmailEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = findByC_ERC(companyId, externalReferenceCode);

		return remove(emailEntry);
	}

	/**
	 * Returns the number of email entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching email entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"emailEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"emailEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(emailEntry.externalReferenceCode IS NULL OR emailEntry.externalReferenceCode = '')";

	public EmailEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmailEntry.class);

		setModelImplClass(EmailEntryImpl.class);
		setModelPKClass(long.class);

		setTable(EmailEntryTable.INSTANCE);
	}

	/**
	 * Caches the email entry in the entity cache if it is enabled.
	 *
	 * @param emailEntry the email entry
	 */
	@Override
	public void cacheResult(EmailEntry emailEntry) {
		entityCache.putResult(
			EmailEntryImpl.class, emailEntry.getPrimaryKey(), emailEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {emailEntry.getUuid(), emailEntry.getGroupId()},
			emailEntry);

		finderCache.putResult(
			_finderPathFetchByC_E,
			new Object[] {
				emailEntry.getCustomerId(), emailEntry.getEmailAddress()
			},
			emailEntry);

		finderCache.putResult(
			_finderPathFetchByC_I,
			new Object[] {
				emailEntry.getCustomerId(), emailEntry.isIsDefaulted()
			},
			emailEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				emailEntry.getCompanyId(), emailEntry.getExternalReferenceCode()
			},
			emailEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the email entries in the entity cache if it is enabled.
	 *
	 * @param emailEntries the email entries
	 */
	@Override
	public void cacheResult(List<EmailEntry> emailEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (emailEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmailEntry emailEntry : emailEntries) {
			if (entityCache.getResult(
					EmailEntryImpl.class, emailEntry.getPrimaryKey()) == null) {

				cacheResult(emailEntry);
			}
		}
	}

	/**
	 * Clears the cache for all email entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmailEntryImpl.class);

		finderCache.clearCache(EmailEntryImpl.class);
	}

	/**
	 * Clears the cache for the email entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmailEntry emailEntry) {
		entityCache.removeResult(EmailEntryImpl.class, emailEntry);
	}

	@Override
	public void clearCache(List<EmailEntry> emailEntries) {
		for (EmailEntry emailEntry : emailEntries) {
			entityCache.removeResult(EmailEntryImpl.class, emailEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmailEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmailEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmailEntryModelImpl emailEntryModelImpl) {

		Object[] args = new Object[] {
			emailEntryModelImpl.getUuid(), emailEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, emailEntryModelImpl);

		args = new Object[] {
			emailEntryModelImpl.getCustomerId(),
			emailEntryModelImpl.getEmailAddress()
		};

		finderCache.putResult(_finderPathCountByC_E, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByC_E, args, emailEntryModelImpl);

		args = new Object[] {
			emailEntryModelImpl.getCustomerId(),
			emailEntryModelImpl.isIsDefaulted()
		};

		finderCache.putResult(_finderPathCountByC_I, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByC_I, args, emailEntryModelImpl);

		args = new Object[] {
			emailEntryModelImpl.getCompanyId(),
			emailEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, emailEntryModelImpl);
	}

	/**
	 * Creates a new email entry with the primary key. Does not add the email entry to the database.
	 *
	 * @param emailId the primary key for the new email entry
	 * @return the new email entry
	 */
	@Override
	public EmailEntry create(long emailId) {
		EmailEntry emailEntry = new EmailEntryImpl();

		emailEntry.setNew(true);
		emailEntry.setPrimaryKey(emailId);

		String uuid = PortalUUIDUtil.generate();

		emailEntry.setUuid(uuid);

		emailEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return emailEntry;
	}

	/**
	 * Removes the email entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry that was removed
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry remove(long emailId) throws NoSuchEmailEntryException {
		return remove((Serializable)emailId);
	}

	/**
	 * Removes the email entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email entry
	 * @return the email entry that was removed
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry remove(Serializable primaryKey)
		throws NoSuchEmailEntryException {

		Session session = null;

		try {
			session = openSession();

			EmailEntry emailEntry = (EmailEntry)session.get(
				EmailEntryImpl.class, primaryKey);

			if (emailEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(emailEntry);
		}
		catch (NoSuchEmailEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmailEntry removeImpl(EmailEntry emailEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailEntry)) {
				emailEntry = (EmailEntry)session.get(
					EmailEntryImpl.class, emailEntry.getPrimaryKeyObj());
			}

			if (emailEntry != null) {
				session.delete(emailEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (emailEntry != null) {
			clearCache(emailEntry);
		}

		return emailEntry;
	}

	@Override
	public EmailEntry updateImpl(EmailEntry emailEntry) {
		boolean isNew = emailEntry.isNew();

		if (!(emailEntry instanceof EmailEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(emailEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(emailEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in emailEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmailEntry implementation " +
					emailEntry.getClass());
		}

		EmailEntryModelImpl emailEntryModelImpl =
			(EmailEntryModelImpl)emailEntry;

		if (Validator.isNull(emailEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			emailEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (emailEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				emailEntry.setCreateDate(date);
			}
			else {
				emailEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!emailEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				emailEntry.setModifiedDate(date);
			}
			else {
				emailEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(emailEntry);
			}
			else {
				emailEntry = (EmailEntry)session.merge(emailEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmailEntryImpl.class, emailEntryModelImpl, false, true);

		cacheUniqueFindersCache(emailEntryModelImpl);

		if (isNew) {
			emailEntry.setNew(false);
		}

		emailEntry.resetOriginalValues();

		return emailEntry;
	}

	/**
	 * Returns the email entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email entry
	 * @return the email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailEntryException {

		EmailEntry emailEntry = fetchByPrimaryKey(primaryKey);

		if (emailEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return emailEntry;
	}

	/**
	 * Returns the email entry with the primary key or throws a <code>NoSuchEmailEntryException</code> if it could not be found.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry
	 * @throws NoSuchEmailEntryException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry findByPrimaryKey(long emailId)
		throws NoSuchEmailEntryException {

		return findByPrimaryKey((Serializable)emailId);
	}

	/**
	 * Returns the email entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry, or <code>null</code> if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry fetchByPrimaryKey(long emailId) {
		return fetchByPrimaryKey((Serializable)emailId);
	}

	/**
	 * Returns all the email entries.
	 *
	 * @return the email entries
	 */
	@Override
	public List<EmailEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of email entries
	 */
	@Override
	public List<EmailEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the email entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email entries
	 */
	@Override
	public List<EmailEntry> findAll(
		int start, int end, OrderByComparator<EmailEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of email entries
	 */
	@Override
	public List<EmailEntry> findAll(
		int start, int end, OrderByComparator<EmailEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EmailEntry> list = null;

		if (useFinderCache) {
			list = (List<EmailEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMAILENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILENTRY;

				sql = sql.concat(EmailEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmailEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the email entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmailEntry emailEntry : findAll()) {
			remove(emailEntry);
		}
	}

	/**
	 * Returns the number of email entries.
	 *
	 * @return the number of email entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMAILENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "emailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMAILENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmailEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "contactId"}, true);

		_finderPathWithoutPaginationFindByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "contactId"}, true);

		_finderPathCountByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "contactId"}, false);

		_finderPathFetchByC_E = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_E",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"customerId", "emailAddress"}, true);

		_finderPathCountByC_E = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_E",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"customerId", "emailAddress"}, false);

		_finderPathFetchByC_I = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_I",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"customerId", "isDefaulted"}, true);

		_finderPathCountByC_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_I",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"customerId", "isDefaulted"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setEmailEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEmailEntryUtilPersistence(null);

		entityCache.removeCache(EmailEntryImpl.class.getName());
	}

	private void _setEmailEntryUtilPersistence(
		EmailEntryPersistence emailEntryPersistence) {

		try {
			Field field = EmailEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, emailEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CNTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMAILENTRY =
		"SELECT emailEntry FROM EmailEntry emailEntry";

	private static final String _SQL_SELECT_EMAILENTRY_WHERE =
		"SELECT emailEntry FROM EmailEntry emailEntry WHERE ";

	private static final String _SQL_COUNT_EMAILENTRY =
		"SELECT COUNT(emailEntry) FROM EmailEntry emailEntry";

	private static final String _SQL_COUNT_EMAILENTRY_WHERE =
		"SELECT COUNT(emailEntry) FROM EmailEntry emailEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "emailEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmailEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmailEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmailEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private EmailEntryModelArgumentsResolver _emailEntryModelArgumentsResolver;

}