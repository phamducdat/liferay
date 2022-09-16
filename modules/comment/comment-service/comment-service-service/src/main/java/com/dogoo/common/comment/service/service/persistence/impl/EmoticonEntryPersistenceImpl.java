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

package com.dogoo.common.comment.service.service.persistence.impl;

import com.dogoo.common.comment.service.exception.NoSuchEmoticonEntryException;
import com.dogoo.common.comment.service.model.EmoticonEntry;
import com.dogoo.common.comment.service.model.EmoticonEntryTable;
import com.dogoo.common.comment.service.model.impl.EmoticonEntryImpl;
import com.dogoo.common.comment.service.model.impl.EmoticonEntryModelImpl;
import com.dogoo.common.comment.service.service.persistence.EmoticonEntryPersistence;
import com.dogoo.common.comment.service.service.persistence.EmoticonEntryUtil;
import com.dogoo.common.comment.service.service.persistence.impl.constants.DG_COMMENTPersistenceConstants;

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
 * The persistence implementation for the emoticon entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {EmoticonEntryPersistence.class, BasePersistence.class})
public class EmoticonEntryPersistenceImpl
	extends BasePersistenceImpl<EmoticonEntry>
	implements EmoticonEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmoticonEntryUtil</code> to access the emoticon entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmoticonEntryImpl.class.getName();

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
	 * Returns all the emoticon entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emoticon entries
	 */
	@Override
	public List<EmoticonEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<EmoticonEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<EmoticonEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<EmoticonEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator,
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

		List<EmoticonEntry> list = null;

		if (useFinderCache) {
			list = (List<EmoticonEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmoticonEntry emoticonEntry : list) {
					if (!uuid.equals(emoticonEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

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
				sb.append(EmoticonEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmoticonEntry>)QueryUtil.list(
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
	 * Returns the first emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry findByUuid_First(
			String uuid, OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (emoticonEntry != null) {
			return emoticonEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmoticonEntryException(sb.toString());
	}

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByUuid_First(
		String uuid, OrderByComparator<EmoticonEntry> orderByComparator) {

		List<EmoticonEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry findByUuid_Last(
			String uuid, OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (emoticonEntry != null) {
			return emoticonEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmoticonEntryException(sb.toString());
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByUuid_Last(
		String uuid, OrderByComparator<EmoticonEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmoticonEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emoticon entries before and after the current emoticon entry in the ordered set where uuid = &#63;.
	 *
	 * @param emoticonId the primary key of the current emoticon entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	@Override
	public EmoticonEntry[] findByUuid_PrevAndNext(
			long emoticonId, String uuid,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		uuid = Objects.toString(uuid, "");

		EmoticonEntry emoticonEntry = findByPrimaryKey(emoticonId);

		Session session = null;

		try {
			session = openSession();

			EmoticonEntry[] array = new EmoticonEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, emoticonEntry, uuid, orderByComparator, true);

			array[1] = emoticonEntry;

			array[2] = getByUuid_PrevAndNext(
				session, emoticonEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmoticonEntry getByUuid_PrevAndNext(
		Session session, EmoticonEntry emoticonEntry, String uuid,
		OrderByComparator<EmoticonEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

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
			sb.append(EmoticonEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						emoticonEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmoticonEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emoticon entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmoticonEntry emoticonEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(emoticonEntry);
		}
	}

	/**
	 * Returns the number of emoticon entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emoticon entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMOTICONENTRY_WHERE);

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
		"emoticonEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(emoticonEntry.uuid IS NULL OR emoticonEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByUUID_G(uuid, groupId);

		if (emoticonEntry == null) {
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

			throw new NoSuchEmoticonEntryException(sb.toString());
		}

		return emoticonEntry;
	}

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the emoticon entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByUUID_G(
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

		if (result instanceof EmoticonEntry) {
			EmoticonEntry emoticonEntry = (EmoticonEntry)result;

			if (!Objects.equals(uuid, emoticonEntry.getUuid()) ||
				(groupId != emoticonEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

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

				List<EmoticonEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmoticonEntry emoticonEntry = list.get(0);

					result = emoticonEntry;

					cacheResult(emoticonEntry);
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
			return (EmoticonEntry)result;
		}
	}

	/**
	 * Removes the emoticon entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the emoticon entry that was removed
	 */
	@Override
	public EmoticonEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = findByUUID_G(uuid, groupId);

		return remove(emoticonEntry);
	}

	/**
	 * Returns the number of emoticon entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching emoticon entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMOTICONENTRY_WHERE);

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
		"emoticonEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(emoticonEntry.uuid IS NULL OR emoticonEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"emoticonEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emoticon entries
	 */
	@Override
	public List<EmoticonEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<EmoticonEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator,
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

		List<EmoticonEntry> list = null;

		if (useFinderCache) {
			list = (List<EmoticonEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmoticonEntry emoticonEntry : list) {
					if (!uuid.equals(emoticonEntry.getUuid()) ||
						(companyId != emoticonEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

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
				sb.append(EmoticonEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmoticonEntry>)QueryUtil.list(
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
	 * Returns the first emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (emoticonEntry != null) {
			return emoticonEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmoticonEntryException(sb.toString());
	}

	/**
	 * Returns the first emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		List<EmoticonEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (emoticonEntry != null) {
			return emoticonEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmoticonEntryException(sb.toString());
	}

	/**
	 * Returns the last emoticon entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmoticonEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public EmoticonEntry[] findByUuid_C_PrevAndNext(
			long emoticonId, String uuid, long companyId,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		uuid = Objects.toString(uuid, "");

		EmoticonEntry emoticonEntry = findByPrimaryKey(emoticonId);

		Session session = null;

		try {
			session = openSession();

			EmoticonEntry[] array = new EmoticonEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, emoticonEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = emoticonEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, emoticonEntry, uuid, companyId, orderByComparator,
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

	protected EmoticonEntry getByUuid_C_PrevAndNext(
		Session session, EmoticonEntry emoticonEntry, String uuid,
		long companyId, OrderByComparator<EmoticonEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

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
			sb.append(EmoticonEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						emoticonEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmoticonEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emoticon entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmoticonEntry emoticonEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(emoticonEntry);
		}
	}

	/**
	 * Returns the number of emoticon entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emoticon entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMOTICONENTRY_WHERE);

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
		"emoticonEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(emoticonEntry.uuid IS NULL OR emoticonEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"emoticonEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_C_C;
	private FinderPath _finderPathWithoutPaginationFindByC_C_C;
	private FinderPath _finderPathCountByC_C_C;

	/**
	 * Returns all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching emoticon entries
	 */
	@Override
	public List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName) {

		return findByC_C_C(
			customerId, classPkId, classPkName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start,
		int end) {

		return findByC_C_C(
			customerId, classPkId, classPkName, start, end, null);
	}

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
	@Override
	public List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return findByC_C_C(
			customerId, classPkId, classPkName, start, end, orderByComparator,
			true);
	}

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
	@Override
	public List<EmoticonEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator,
		boolean useFinderCache) {

		classPkName = Objects.toString(classPkName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_C_C;
				finderArgs = new Object[] {customerId, classPkId, classPkName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_C_C;
			finderArgs = new Object[] {
				customerId, classPkId, classPkName, start, end,
				orderByComparator
			};
		}

		List<EmoticonEntry> list = null;

		if (useFinderCache) {
			list = (List<EmoticonEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmoticonEntry emoticonEntry : list) {
					if ((customerId != emoticonEntry.getCustomerId()) ||
						(classPkId != emoticonEntry.getClassPkId()) ||
						!classPkName.equals(emoticonEntry.getClassPkName())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_C_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_C_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_C_C_C_CLASSPKNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmoticonEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(classPkId);

				if (bindClassPkName) {
					queryPos.add(classPkName);
				}

				list = (List<EmoticonEntry>)QueryUtil.list(
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
	 * Returns the first emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry findByC_C_C_First(
			long customerId, long classPkId, String classPkName,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByC_C_C_First(
			customerId, classPkId, classPkName, orderByComparator);

		if (emoticonEntry != null) {
			return emoticonEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", classPkId=");
		sb.append(classPkId);

		sb.append(", classPkName=");
		sb.append(classPkName);

		sb.append("}");

		throw new NoSuchEmoticonEntryException(sb.toString());
	}

	/**
	 * Returns the first emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByC_C_C_First(
		long customerId, long classPkId, String classPkName,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		List<EmoticonEntry> list = findByC_C_C(
			customerId, classPkId, classPkName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public EmoticonEntry findByC_C_C_Last(
			long customerId, long classPkId, String classPkName,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByC_C_C_Last(
			customerId, classPkId, classPkName, orderByComparator);

		if (emoticonEntry != null) {
			return emoticonEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", classPkId=");
		sb.append(classPkId);

		sb.append(", classPkName=");
		sb.append(classPkName);

		sb.append("}");

		throw new NoSuchEmoticonEntryException(sb.toString());
	}

	/**
	 * Returns the last emoticon entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByC_C_C_Last(
		long customerId, long classPkId, String classPkName,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		int count = countByC_C_C(customerId, classPkId, classPkName);

		if (count == 0) {
			return null;
		}

		List<EmoticonEntry> list = findByC_C_C(
			customerId, classPkId, classPkName, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public EmoticonEntry[] findByC_C_C_PrevAndNext(
			long emoticonId, long customerId, long classPkId,
			String classPkName,
			OrderByComparator<EmoticonEntry> orderByComparator)
		throws NoSuchEmoticonEntryException {

		classPkName = Objects.toString(classPkName, "");

		EmoticonEntry emoticonEntry = findByPrimaryKey(emoticonId);

		Session session = null;

		try {
			session = openSession();

			EmoticonEntry[] array = new EmoticonEntryImpl[3];

			array[0] = getByC_C_C_PrevAndNext(
				session, emoticonEntry, customerId, classPkId, classPkName,
				orderByComparator, true);

			array[1] = emoticonEntry;

			array[2] = getByC_C_C_PrevAndNext(
				session, emoticonEntry, customerId, classPkId, classPkName,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmoticonEntry getByC_C_C_PrevAndNext(
		Session session, EmoticonEntry emoticonEntry, long customerId,
		long classPkId, String classPkName,
		OrderByComparator<EmoticonEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_C_C_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_C_C_CLASSPKID_2);

		boolean bindClassPkName = false;

		if (classPkName.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_C_C_CLASSPKNAME_3);
		}
		else {
			bindClassPkName = true;

			sb.append(_FINDER_COLUMN_C_C_C_CLASSPKNAME_2);
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
			sb.append(EmoticonEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(classPkId);

		if (bindClassPkName) {
			queryPos.add(classPkName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						emoticonEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmoticonEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	@Override
	public void removeByC_C_C(
		long customerId, long classPkId, String classPkName) {

		for (EmoticonEntry emoticonEntry :
				findByC_C_C(
					customerId, classPkId, classPkName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(emoticonEntry);
		}
	}

	/**
	 * Returns the number of emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching emoticon entries
	 */
	@Override
	public int countByC_C_C(
		long customerId, long classPkId, String classPkName) {

		classPkName = Objects.toString(classPkName, "");

		FinderPath finderPath = _finderPathCountByC_C_C;

		Object[] finderArgs = new Object[] {customerId, classPkId, classPkName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_EMOTICONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_C_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_C_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_C_C_C_CLASSPKNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(classPkId);

				if (bindClassPkName) {
					queryPos.add(classPkName);
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

	private static final String _FINDER_COLUMN_C_C_C_CUSTOMERID_2 =
		"emoticonEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_CLASSPKID_2 =
		"emoticonEntry.classPkId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_CLASSPKNAME_2 =
		"emoticonEntry.classPkName = ?";

	private static final String _FINDER_COLUMN_C_C_C_CLASSPKNAME_3 =
		"(emoticonEntry.classPkName IS NULL OR emoticonEntry.classPkName = '')";

	private FinderPath _finderPathFetchByC_C_C_C;
	private FinderPath _finderPathCountByC_C_C_C;

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
	@Override
	public EmoticonEntry findByC_C_C_C(
			long customerId, long classPkId, String classPkName, long creatorId)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByC_C_C_C(
			customerId, classPkId, classPkName, creatorId);

		if (emoticonEntry == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", classPkId=");
			sb.append(classPkId);

			sb.append(", classPkName=");
			sb.append(classPkName);

			sb.append(", creatorId=");
			sb.append(creatorId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmoticonEntryException(sb.toString());
		}

		return emoticonEntry;
	}

	/**
	 * Returns the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId) {

		return fetchByC_C_C_C(
			customerId, classPkId, classPkName, creatorId, true);
	}

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
	@Override
	public EmoticonEntry fetchByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId,
		boolean useFinderCache) {

		classPkName = Objects.toString(classPkName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				customerId, classPkId, classPkName, creatorId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_C_C_C, finderArgs);
		}

		if (result instanceof EmoticonEntry) {
			EmoticonEntry emoticonEntry = (EmoticonEntry)result;

			if ((customerId != emoticonEntry.getCustomerId()) ||
				(classPkId != emoticonEntry.getClassPkId()) ||
				!Objects.equals(classPkName, emoticonEntry.getClassPkName()) ||
				(creatorId != emoticonEntry.getCreatorId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_C_C_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_C_C_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_C_C_C_C_CLASSPKNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_C_C_C_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(classPkId);

				if (bindClassPkName) {
					queryPos.add(classPkName);
				}

				queryPos.add(creatorId);

				List<EmoticonEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_C_C_C, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, classPkId, classPkName,
									creatorId
								};
							}

							_log.warn(
								"EmoticonEntryPersistenceImpl.fetchByC_C_C_C(long, long, String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmoticonEntry emoticonEntry = list.get(0);

					result = emoticonEntry;

					cacheResult(emoticonEntry);
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
			return (EmoticonEntry)result;
		}
	}

	/**
	 * Removes the emoticon entry where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the emoticon entry that was removed
	 */
	@Override
	public EmoticonEntry removeByC_C_C_C(
			long customerId, long classPkId, String classPkName, long creatorId)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = findByC_C_C_C(
			customerId, classPkId, classPkName, creatorId);

		return remove(emoticonEntry);
	}

	/**
	 * Returns the number of emoticon entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and creatorId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param creatorId the creator ID
	 * @return the number of matching emoticon entries
	 */
	@Override
	public int countByC_C_C_C(
		long customerId, long classPkId, String classPkName, long creatorId) {

		classPkName = Objects.toString(classPkName, "");

		FinderPath finderPath = _finderPathCountByC_C_C_C;

		Object[] finderArgs = new Object[] {
			customerId, classPkId, classPkName, creatorId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_EMOTICONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_C_C_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_C_C_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_C_C_C_C_CLASSPKNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_C_C_C_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(classPkId);

				if (bindClassPkName) {
					queryPos.add(classPkName);
				}

				queryPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_C_C_C_C_CUSTOMERID_2 =
		"emoticonEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_C_CLASSPKID_2 =
		"emoticonEntry.classPkId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_C_CLASSPKNAME_2 =
		"emoticonEntry.classPkName = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_C_CLASSPKNAME_3 =
		"(emoticonEntry.classPkName IS NULL OR emoticonEntry.classPkName = '') AND ";

	private static final String _FINDER_COLUMN_C_C_C_C_CREATORID_2 =
		"emoticonEntry.creatorId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching emoticon entry
	 * @throws NoSuchEmoticonEntryException if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (emoticonEntry == null) {
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

			throw new NoSuchEmoticonEntryException(sb.toString());
		}

		return emoticonEntry;
	}

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public EmoticonEntry fetchByC_ERC(
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

		if (result instanceof EmoticonEntry) {
			EmoticonEntry emoticonEntry = (EmoticonEntry)result;

			if ((companyId != emoticonEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					emoticonEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMOTICONENTRY_WHERE);

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

				List<EmoticonEntry> list = query.list();

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
								"EmoticonEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmoticonEntry emoticonEntry = list.get(0);

					result = emoticonEntry;

					cacheResult(emoticonEntry);
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
			return (EmoticonEntry)result;
		}
	}

	/**
	 * Removes the emoticon entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the emoticon entry that was removed
	 */
	@Override
	public EmoticonEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(emoticonEntry);
	}

	/**
	 * Returns the number of emoticon entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching emoticon entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMOTICONENTRY_WHERE);

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
		"emoticonEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"emoticonEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(emoticonEntry.externalReferenceCode IS NULL OR emoticonEntry.externalReferenceCode = '')";

	public EmoticonEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmoticonEntry.class);

		setModelImplClass(EmoticonEntryImpl.class);
		setModelPKClass(long.class);

		setTable(EmoticonEntryTable.INSTANCE);
	}

	/**
	 * Caches the emoticon entry in the entity cache if it is enabled.
	 *
	 * @param emoticonEntry the emoticon entry
	 */
	@Override
	public void cacheResult(EmoticonEntry emoticonEntry) {
		entityCache.putResult(
			EmoticonEntryImpl.class, emoticonEntry.getPrimaryKey(),
			emoticonEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {emoticonEntry.getUuid(), emoticonEntry.getGroupId()},
			emoticonEntry);

		finderCache.putResult(
			_finderPathFetchByC_C_C_C,
			new Object[] {
				emoticonEntry.getCustomerId(), emoticonEntry.getClassPkId(),
				emoticonEntry.getClassPkName(), emoticonEntry.getCreatorId()
			},
			emoticonEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				emoticonEntry.getCompanyId(),
				emoticonEntry.getExternalReferenceCode()
			},
			emoticonEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the emoticon entries in the entity cache if it is enabled.
	 *
	 * @param emoticonEntries the emoticon entries
	 */
	@Override
	public void cacheResult(List<EmoticonEntry> emoticonEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (emoticonEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmoticonEntry emoticonEntry : emoticonEntries) {
			if (entityCache.getResult(
					EmoticonEntryImpl.class, emoticonEntry.getPrimaryKey()) ==
						null) {

				cacheResult(emoticonEntry);
			}
		}
	}

	/**
	 * Clears the cache for all emoticon entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmoticonEntryImpl.class);

		finderCache.clearCache(EmoticonEntryImpl.class);
	}

	/**
	 * Clears the cache for the emoticon entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmoticonEntry emoticonEntry) {
		entityCache.removeResult(EmoticonEntryImpl.class, emoticonEntry);
	}

	@Override
	public void clearCache(List<EmoticonEntry> emoticonEntries) {
		for (EmoticonEntry emoticonEntry : emoticonEntries) {
			entityCache.removeResult(EmoticonEntryImpl.class, emoticonEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmoticonEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmoticonEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmoticonEntryModelImpl emoticonEntryModelImpl) {

		Object[] args = new Object[] {
			emoticonEntryModelImpl.getUuid(),
			emoticonEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, emoticonEntryModelImpl);

		args = new Object[] {
			emoticonEntryModelImpl.getCustomerId(),
			emoticonEntryModelImpl.getClassPkId(),
			emoticonEntryModelImpl.getClassPkName(),
			emoticonEntryModelImpl.getCreatorId()
		};

		finderCache.putResult(_finderPathCountByC_C_C_C, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_C_C_C, args, emoticonEntryModelImpl);

		args = new Object[] {
			emoticonEntryModelImpl.getCompanyId(),
			emoticonEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, emoticonEntryModelImpl);
	}

	/**
	 * Creates a new emoticon entry with the primary key. Does not add the emoticon entry to the database.
	 *
	 * @param emoticonId the primary key for the new emoticon entry
	 * @return the new emoticon entry
	 */
	@Override
	public EmoticonEntry create(long emoticonId) {
		EmoticonEntry emoticonEntry = new EmoticonEntryImpl();

		emoticonEntry.setNew(true);
		emoticonEntry.setPrimaryKey(emoticonId);

		String uuid = PortalUUIDUtil.generate();

		emoticonEntry.setUuid(uuid);

		emoticonEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return emoticonEntry;
	}

	/**
	 * Removes the emoticon entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry that was removed
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	@Override
	public EmoticonEntry remove(long emoticonId)
		throws NoSuchEmoticonEntryException {

		return remove((Serializable)emoticonId);
	}

	/**
	 * Removes the emoticon entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emoticon entry
	 * @return the emoticon entry that was removed
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	@Override
	public EmoticonEntry remove(Serializable primaryKey)
		throws NoSuchEmoticonEntryException {

		Session session = null;

		try {
			session = openSession();

			EmoticonEntry emoticonEntry = (EmoticonEntry)session.get(
				EmoticonEntryImpl.class, primaryKey);

			if (emoticonEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmoticonEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(emoticonEntry);
		}
		catch (NoSuchEmoticonEntryException noSuchEntityException) {
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
	protected EmoticonEntry removeImpl(EmoticonEntry emoticonEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emoticonEntry)) {
				emoticonEntry = (EmoticonEntry)session.get(
					EmoticonEntryImpl.class, emoticonEntry.getPrimaryKeyObj());
			}

			if (emoticonEntry != null) {
				session.delete(emoticonEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (emoticonEntry != null) {
			clearCache(emoticonEntry);
		}

		return emoticonEntry;
	}

	@Override
	public EmoticonEntry updateImpl(EmoticonEntry emoticonEntry) {
		boolean isNew = emoticonEntry.isNew();

		if (!(emoticonEntry instanceof EmoticonEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(emoticonEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					emoticonEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in emoticonEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmoticonEntry implementation " +
					emoticonEntry.getClass());
		}

		EmoticonEntryModelImpl emoticonEntryModelImpl =
			(EmoticonEntryModelImpl)emoticonEntry;

		if (Validator.isNull(emoticonEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			emoticonEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (emoticonEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				emoticonEntry.setCreateDate(date);
			}
			else {
				emoticonEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!emoticonEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				emoticonEntry.setModifiedDate(date);
			}
			else {
				emoticonEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(emoticonEntry);
			}
			else {
				emoticonEntry = (EmoticonEntry)session.merge(emoticonEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmoticonEntryImpl.class, emoticonEntryModelImpl, false, true);

		cacheUniqueFindersCache(emoticonEntryModelImpl);

		if (isNew) {
			emoticonEntry.setNew(false);
		}

		emoticonEntry.resetOriginalValues();

		return emoticonEntry;
	}

	/**
	 * Returns the emoticon entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emoticon entry
	 * @return the emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	@Override
	public EmoticonEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = fetchByPrimaryKey(primaryKey);

		if (emoticonEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmoticonEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return emoticonEntry;
	}

	/**
	 * Returns the emoticon entry with the primary key or throws a <code>NoSuchEmoticonEntryException</code> if it could not be found.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry
	 * @throws NoSuchEmoticonEntryException if a emoticon entry with the primary key could not be found
	 */
	@Override
	public EmoticonEntry findByPrimaryKey(long emoticonId)
		throws NoSuchEmoticonEntryException {

		return findByPrimaryKey((Serializable)emoticonId);
	}

	/**
	 * Returns the emoticon entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry, or <code>null</code> if a emoticon entry with the primary key could not be found
	 */
	@Override
	public EmoticonEntry fetchByPrimaryKey(long emoticonId) {
		return fetchByPrimaryKey((Serializable)emoticonId);
	}

	/**
	 * Returns all the emoticon entries.
	 *
	 * @return the emoticon entries
	 */
	@Override
	public List<EmoticonEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<EmoticonEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<EmoticonEntry> findAll(
		int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<EmoticonEntry> findAll(
		int start, int end, OrderByComparator<EmoticonEntry> orderByComparator,
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

		List<EmoticonEntry> list = null;

		if (useFinderCache) {
			list = (List<EmoticonEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMOTICONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMOTICONENTRY;

				sql = sql.concat(EmoticonEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmoticonEntry>)QueryUtil.list(
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
	 * Removes all the emoticon entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmoticonEntry emoticonEntry : findAll()) {
			remove(emoticonEntry);
		}
	}

	/**
	 * Returns the number of emoticon entries.
	 *
	 * @return the number of emoticon entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMOTICONENTRY);

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
		return "emoticonId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMOTICONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmoticonEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the emoticon entry persistence.
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

		_finderPathWithPaginationFindByC_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId", "classPkId", "classPkName"}, true);

		_finderPathWithoutPaginationFindByC_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "classPkId", "classPkName"}, true);

		_finderPathCountByC_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "classPkId", "classPkName"}, false);

		_finderPathFetchByC_C_C_C = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {
				"customerId", "classPkId", "classPkName", "creatorId"
			},
			true);

		_finderPathCountByC_C_C_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {
				"customerId", "classPkId", "classPkName", "creatorId"
			},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setEmoticonEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEmoticonEntryUtilPersistence(null);

		entityCache.removeCache(EmoticonEntryImpl.class.getName());
	}

	private void _setEmoticonEntryUtilPersistence(
		EmoticonEntryPersistence emoticonEntryPersistence) {

		try {
			Field field = EmoticonEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, emoticonEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DG_COMMENTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DG_COMMENTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DG_COMMENTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMOTICONENTRY =
		"SELECT emoticonEntry FROM EmoticonEntry emoticonEntry";

	private static final String _SQL_SELECT_EMOTICONENTRY_WHERE =
		"SELECT emoticonEntry FROM EmoticonEntry emoticonEntry WHERE ";

	private static final String _SQL_COUNT_EMOTICONENTRY =
		"SELECT COUNT(emoticonEntry) FROM EmoticonEntry emoticonEntry";

	private static final String _SQL_COUNT_EMOTICONENTRY_WHERE =
		"SELECT COUNT(emoticonEntry) FROM EmoticonEntry emoticonEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "emoticonEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmoticonEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmoticonEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmoticonEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private EmoticonEntryModelArgumentsResolver
		_emoticonEntryModelArgumentsResolver;

}