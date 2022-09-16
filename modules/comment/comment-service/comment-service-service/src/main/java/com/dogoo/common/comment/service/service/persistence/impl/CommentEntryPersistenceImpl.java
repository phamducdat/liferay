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

import com.dogoo.common.comment.service.exception.NoSuchCommentEntryException;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.dogoo.common.comment.service.model.CommentEntryTable;
import com.dogoo.common.comment.service.model.impl.CommentEntryImpl;
import com.dogoo.common.comment.service.model.impl.CommentEntryModelImpl;
import com.dogoo.common.comment.service.service.persistence.CommentEntryPersistence;
import com.dogoo.common.comment.service.service.persistence.CommentEntryUtil;
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
 * The persistence implementation for the comment entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CommentEntryPersistence.class, BasePersistence.class})
public class CommentEntryPersistenceImpl
	extends BasePersistenceImpl<CommentEntry>
	implements CommentEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommentEntryUtil</code> to access the comment entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommentEntryImpl.class.getName();

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
	 * Returns all the comment entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comment entries
	 */
	@Override
	public List<CommentEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CommentEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<CommentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CommentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
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

		List<CommentEntry> list = null;

		if (useFinderCache) {
			list = (List<CommentEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentEntry commentEntry : list) {
					if (!uuid.equals(commentEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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
				sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommentEntry>)QueryUtil.list(
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
	 * Returns the first comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByUuid_First(
			String uuid, OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByUuid_First(uuid, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByUuid_First(
		String uuid, OrderByComparator<CommentEntry> orderByComparator) {

		List<CommentEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByUuid_Last(
			String uuid, OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByUuid_Last(
		String uuid, OrderByComparator<CommentEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommentEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	@Override
	public CommentEntry[] findByUuid_PrevAndNext(
			long commentId, String uuid,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		uuid = Objects.toString(uuid, "");

		CommentEntry commentEntry = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			CommentEntry[] array = new CommentEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, commentEntry, uuid, orderByComparator, true);

			array[1] = commentEntry;

			array[2] = getByUuid_PrevAndNext(
				session, commentEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentEntry getByUuid_PrevAndNext(
		Session session, CommentEntry commentEntry, String uuid,
		OrderByComparator<CommentEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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
			sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(commentEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommentEntry commentEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commentEntry);
		}
	}

	/**
	 * Returns the number of comment entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comment entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENTENTRY_WHERE);

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
		"commentEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(commentEntry.uuid IS NULL OR commentEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByUUID_G(uuid, groupId);

		if (commentEntry == null) {
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

			throw new NoSuchCommentEntryException(sb.toString());
		}

		return commentEntry;
	}

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByUUID_G(
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

		if (result instanceof CommentEntry) {
			CommentEntry commentEntry = (CommentEntry)result;

			if (!Objects.equals(uuid, commentEntry.getUuid()) ||
				(groupId != commentEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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

				List<CommentEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CommentEntry commentEntry = list.get(0);

					result = commentEntry;

					cacheResult(commentEntry);
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
			return (CommentEntry)result;
		}
	}

	/**
	 * Removes the comment entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comment entry that was removed
	 */
	@Override
	public CommentEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = findByUUID_G(uuid, groupId);

		return remove(commentEntry);
	}

	/**
	 * Returns the number of comment entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comment entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENTENTRY_WHERE);

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
		"commentEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(commentEntry.uuid IS NULL OR commentEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"commentEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comment entries
	 */
	@Override
	public List<CommentEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
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

		List<CommentEntry> list = null;

		if (useFinderCache) {
			list = (List<CommentEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentEntry commentEntry : list) {
					if (!uuid.equals(commentEntry.getUuid()) ||
						(companyId != commentEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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
				sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommentEntry>)QueryUtil.list(
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
	 * Returns the first comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommentEntry> orderByComparator) {

		List<CommentEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommentEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CommentEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CommentEntry[] findByUuid_C_PrevAndNext(
			long commentId, String uuid, long companyId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		uuid = Objects.toString(uuid, "");

		CommentEntry commentEntry = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			CommentEntry[] array = new CommentEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, commentEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = commentEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, commentEntry, uuid, companyId, orderByComparator,
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

	protected CommentEntry getByUuid_C_PrevAndNext(
		Session session, CommentEntry commentEntry, String uuid, long companyId,
		OrderByComparator<CommentEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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
			sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(commentEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CommentEntry commentEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commentEntry);
		}
	}

	/**
	 * Returns the number of comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comment entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENTENTRY_WHERE);

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
		"commentEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(commentEntry.uuid IS NULL OR commentEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"commentEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_C_C;
	private FinderPath _finderPathWithoutPaginationFindByC_C_C;
	private FinderPath _finderPathCountByC_C_C;

	/**
	 * Returns all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching comment entries
	 */
	@Override
	public List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName) {

		return findByC_C_C(
			customerId, classPkId, classPkName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start,
		int end) {

		return findByC_C_C(
			customerId, classPkId, classPkName, start, end, null);
	}

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
	@Override
	public List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return findByC_C_C(
			customerId, classPkId, classPkName, start, end, orderByComparator,
			true);
	}

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
	@Override
	public List<CommentEntry> findByC_C_C(
		long customerId, long classPkId, String classPkName, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
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

		List<CommentEntry> list = null;

		if (useFinderCache) {
			list = (List<CommentEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentEntry commentEntry : list) {
					if ((customerId != commentEntry.getCustomerId()) ||
						(classPkId != commentEntry.getClassPkId()) ||
						!classPkName.equals(commentEntry.getClassPkName())) {

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

			sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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
				sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommentEntry>)QueryUtil.list(
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
	 * Returns the first comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByC_C_C_First(
			long customerId, long classPkId, String classPkName,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByC_C_C_First(
			customerId, classPkId, classPkName, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
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

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the first comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByC_C_C_First(
		long customerId, long classPkId, String classPkName,
		OrderByComparator<CommentEntry> orderByComparator) {

		List<CommentEntry> list = findByC_C_C(
			customerId, classPkId, classPkName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CommentEntry findByC_C_C_Last(
			long customerId, long classPkId, String classPkName,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByC_C_C_Last(
			customerId, classPkId, classPkName, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
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

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the last comment entry in the ordered set where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByC_C_C_Last(
		long customerId, long classPkId, String classPkName,
		OrderByComparator<CommentEntry> orderByComparator) {

		int count = countByC_C_C(customerId, classPkId, classPkName);

		if (count == 0) {
			return null;
		}

		List<CommentEntry> list = findByC_C_C(
			customerId, classPkId, classPkName, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CommentEntry[] findByC_C_C_PrevAndNext(
			long commentId, long customerId, long classPkId, String classPkName,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		classPkName = Objects.toString(classPkName, "");

		CommentEntry commentEntry = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			CommentEntry[] array = new CommentEntryImpl[3];

			array[0] = getByC_C_C_PrevAndNext(
				session, commentEntry, customerId, classPkId, classPkName,
				orderByComparator, true);

			array[1] = commentEntry;

			array[2] = getByC_C_C_PrevAndNext(
				session, commentEntry, customerId, classPkId, classPkName,
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

	protected CommentEntry getByC_C_C_PrevAndNext(
		Session session, CommentEntry commentEntry, long customerId,
		long classPkId, String classPkName,
		OrderByComparator<CommentEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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
			sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(commentEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	@Override
	public void removeByC_C_C(
		long customerId, long classPkId, String classPkName) {

		for (CommentEntry commentEntry :
				findByC_C_C(
					customerId, classPkId, classPkName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commentEntry);
		}
	}

	/**
	 * Returns the number of comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching comment entries
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

			sb.append(_SQL_COUNT_COMMENTENTRY_WHERE);

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
		"commentEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_CLASSPKID_2 =
		"commentEntry.classPkId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_CLASSPKNAME_2 =
		"commentEntry.classPkName = ?";

	private static final String _FINDER_COLUMN_C_C_C_CLASSPKNAME_3 =
		"(commentEntry.classPkName IS NULL OR commentEntry.classPkName = '')";

	private FinderPath _finderPathWithPaginationFindByC_C_C_P;
	private FinderPath _finderPathWithoutPaginationFindByC_C_C_P;
	private FinderPath _finderPathCountByC_C_C_P;

	/**
	 * Returns all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @return the matching comment entries
	 */
	@Override
	public List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId) {

		return findByC_C_C_P(
			customerId, classPkId, classPkName, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId,
		int start, int end) {

		return findByC_C_C_P(
			customerId, classPkId, classPkName, parentId, start, end, null);
	}

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
	@Override
	public List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId,
		int start, int end, OrderByComparator<CommentEntry> orderByComparator) {

		return findByC_C_C_P(
			customerId, classPkId, classPkName, parentId, start, end,
			orderByComparator, true);
	}

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
	@Override
	public List<CommentEntry> findByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId,
		int start, int end, OrderByComparator<CommentEntry> orderByComparator,
		boolean useFinderCache) {

		classPkName = Objects.toString(classPkName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_C_C_P;
				finderArgs = new Object[] {
					customerId, classPkId, classPkName, parentId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_C_C_P;
			finderArgs = new Object[] {
				customerId, classPkId, classPkName, parentId, start, end,
				orderByComparator
			};
		}

		List<CommentEntry> list = null;

		if (useFinderCache) {
			list = (List<CommentEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentEntry commentEntry : list) {
					if ((customerId != commentEntry.getCustomerId()) ||
						(classPkId != commentEntry.getClassPkId()) ||
						!classPkName.equals(commentEntry.getClassPkName()) ||
						(parentId != commentEntry.getParentId())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_C_P_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_C_C_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(parentId);

				list = (List<CommentEntry>)QueryUtil.list(
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
	@Override
	public CommentEntry findByC_C_C_P_First(
			long customerId, long classPkId, String classPkName, long parentId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByC_C_C_P_First(
			customerId, classPkId, classPkName, parentId, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", classPkId=");
		sb.append(classPkId);

		sb.append(", classPkName=");
		sb.append(classPkName);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

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
	@Override
	public CommentEntry fetchByC_C_C_P_First(
		long customerId, long classPkId, String classPkName, long parentId,
		OrderByComparator<CommentEntry> orderByComparator) {

		List<CommentEntry> list = findByC_C_C_P(
			customerId, classPkId, classPkName, parentId, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CommentEntry findByC_C_C_P_Last(
			long customerId, long classPkId, String classPkName, long parentId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByC_C_C_P_Last(
			customerId, classPkId, classPkName, parentId, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", classPkId=");
		sb.append(classPkId);

		sb.append(", classPkName=");
		sb.append(classPkName);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

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
	@Override
	public CommentEntry fetchByC_C_C_P_Last(
		long customerId, long classPkId, String classPkName, long parentId,
		OrderByComparator<CommentEntry> orderByComparator) {

		int count = countByC_C_C_P(
			customerId, classPkId, classPkName, parentId);

		if (count == 0) {
			return null;
		}

		List<CommentEntry> list = findByC_C_C_P(
			customerId, classPkId, classPkName, parentId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CommentEntry[] findByC_C_C_P_PrevAndNext(
			long commentId, long customerId, long classPkId, String classPkName,
			long parentId, OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		classPkName = Objects.toString(classPkName, "");

		CommentEntry commentEntry = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			CommentEntry[] array = new CommentEntryImpl[3];

			array[0] = getByC_C_C_P_PrevAndNext(
				session, commentEntry, customerId, classPkId, classPkName,
				parentId, orderByComparator, true);

			array[1] = commentEntry;

			array[2] = getByC_C_C_P_PrevAndNext(
				session, commentEntry, customerId, classPkId, classPkName,
				parentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentEntry getByC_C_C_P_PrevAndNext(
		Session session, CommentEntry commentEntry, long customerId,
		long classPkId, String classPkName, long parentId,
		OrderByComparator<CommentEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_C_C_P_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKID_2);

		boolean bindClassPkName = false;

		if (classPkName.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKNAME_3);
		}
		else {
			bindClassPkName = true;

			sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKNAME_2);
		}

		sb.append(_FINDER_COLUMN_C_C_C_P_PARENTID_2);

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
			sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
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

		queryPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(commentEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId) {

		for (CommentEntry commentEntry :
				findByC_C_C_P(
					customerId, classPkId, classPkName, parentId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commentEntry);
		}
	}

	/**
	 * Returns the number of comment entries where customerId = &#63; and classPkId = &#63; and classPkName = &#63; and parentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param parentId the parent ID
	 * @return the number of matching comment entries
	 */
	@Override
	public int countByC_C_C_P(
		long customerId, long classPkId, String classPkName, long parentId) {

		classPkName = Objects.toString(classPkName, "");

		FinderPath finderPath = _finderPathCountByC_C_C_P;

		Object[] finderArgs = new Object[] {
			customerId, classPkId, classPkName, parentId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_COMMENTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_C_P_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_C_C_C_P_CLASSPKNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_C_C_P_PARENTID_2);

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

				queryPos.add(parentId);

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

	private static final String _FINDER_COLUMN_C_C_C_P_CUSTOMERID_2 =
		"commentEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_P_CLASSPKID_2 =
		"commentEntry.classPkId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_P_CLASSPKNAME_2 =
		"commentEntry.classPkName = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_P_CLASSPKNAME_3 =
		"(commentEntry.classPkName IS NULL OR commentEntry.classPkName = '') AND ";

	private static final String _FINDER_COLUMN_C_C_C_P_PARENTID_2 =
		"commentEntry.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByP_;
	private FinderPath _finderPathWithoutPaginationFindByP_;
	private FinderPath _finderPathCountByP_;

	/**
	 * Returns all the comment entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching comment entries
	 */
	@Override
	public List<CommentEntry> findByP_(long parentId) {
		return findByP_(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CommentEntry> findByP_(long parentId, int start, int end) {
		return findByP_(parentId, start, end, null);
	}

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
	@Override
	public List<CommentEntry> findByP_(
		long parentId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return findByP_(parentId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CommentEntry> findByP_(
		long parentId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_;
				finderArgs = new Object[] {parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_;
			finderArgs = new Object[] {parentId, start, end, orderByComparator};
		}

		List<CommentEntry> list = null;

		if (useFinderCache) {
			list = (List<CommentEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentEntry commentEntry : list) {
					if (parentId != commentEntry.getParentId()) {
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

			sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				list = (List<CommentEntry>)QueryUtil.list(
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
	 * Returns the first comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByP__First(
			long parentId, OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByP__First(
			parentId, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the first comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByP__First(
		long parentId, OrderByComparator<CommentEntry> orderByComparator) {

		List<CommentEntry> list = findByP_(parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByP__Last(
			long parentId, OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByP__Last(parentId, orderByComparator);

		if (commentEntry != null) {
			return commentEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchCommentEntryException(sb.toString());
	}

	/**
	 * Returns the last comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByP__Last(
		long parentId, OrderByComparator<CommentEntry> orderByComparator) {

		int count = countByP_(parentId);

		if (count == 0) {
			return null;
		}

		List<CommentEntry> list = findByP_(
			parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	@Override
	public CommentEntry[] findByP__PrevAndNext(
			long commentId, long parentId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			CommentEntry[] array = new CommentEntryImpl[3];

			array[0] = getByP__PrevAndNext(
				session, commentEntry, parentId, orderByComparator, true);

			array[1] = commentEntry;

			array[2] = getByP__PrevAndNext(
				session, commentEntry, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentEntry getByP__PrevAndNext(
		Session session, CommentEntry commentEntry, long parentId,
		OrderByComparator<CommentEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_P__PARENTID_2);

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
			sb.append(CommentEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(commentEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment entries where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByP_(long parentId) {
		for (CommentEntry commentEntry :
				findByP_(
					parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commentEntry);
		}
	}

	/**
	 * Returns the number of comment entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching comment entries
	 */
	@Override
	public int countByP_(long parentId) {
		FinderPath finderPath = _finderPathCountByP_;

		Object[] finderArgs = new Object[] {parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

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

	private static final String _FINDER_COLUMN_P__PARENTID_2 =
		"commentEntry.parentId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the comment entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (commentEntry == null) {
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

			throw new NoSuchCommentEntryException(sb.toString());
		}

		return commentEntry;
	}

	/**
	 * Returns the comment entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the comment entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public CommentEntry fetchByC_ERC(
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

		if (result instanceof CommentEntry) {
			CommentEntry commentEntry = (CommentEntry)result;

			if ((companyId != commentEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					commentEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMMENTENTRY_WHERE);

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

				List<CommentEntry> list = query.list();

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
								"CommentEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CommentEntry commentEntry = list.get(0);

					result = commentEntry;

					cacheResult(commentEntry);
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
			return (CommentEntry)result;
		}
	}

	/**
	 * Removes the comment entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the comment entry that was removed
	 */
	@Override
	public CommentEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(commentEntry);
	}

	/**
	 * Returns the number of comment entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching comment entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENTENTRY_WHERE);

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
		"commentEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"commentEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(commentEntry.externalReferenceCode IS NULL OR commentEntry.externalReferenceCode = '')";

	public CommentEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CommentEntry.class);

		setModelImplClass(CommentEntryImpl.class);
		setModelPKClass(long.class);

		setTable(CommentEntryTable.INSTANCE);
	}

	/**
	 * Caches the comment entry in the entity cache if it is enabled.
	 *
	 * @param commentEntry the comment entry
	 */
	@Override
	public void cacheResult(CommentEntry commentEntry) {
		entityCache.putResult(
			CommentEntryImpl.class, commentEntry.getPrimaryKey(), commentEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {commentEntry.getUuid(), commentEntry.getGroupId()},
			commentEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				commentEntry.getCompanyId(),
				commentEntry.getExternalReferenceCode()
			},
			commentEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the comment entries in the entity cache if it is enabled.
	 *
	 * @param commentEntries the comment entries
	 */
	@Override
	public void cacheResult(List<CommentEntry> commentEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (commentEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CommentEntry commentEntry : commentEntries) {
			if (entityCache.getResult(
					CommentEntryImpl.class, commentEntry.getPrimaryKey()) ==
						null) {

				cacheResult(commentEntry);
			}
		}
	}

	/**
	 * Clears the cache for all comment entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommentEntryImpl.class);

		finderCache.clearCache(CommentEntryImpl.class);
	}

	/**
	 * Clears the cache for the comment entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommentEntry commentEntry) {
		entityCache.removeResult(CommentEntryImpl.class, commentEntry);
	}

	@Override
	public void clearCache(List<CommentEntry> commentEntries) {
		for (CommentEntry commentEntry : commentEntries) {
			entityCache.removeResult(CommentEntryImpl.class, commentEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CommentEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CommentEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommentEntryModelImpl commentEntryModelImpl) {

		Object[] args = new Object[] {
			commentEntryModelImpl.getUuid(), commentEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, commentEntryModelImpl);

		args = new Object[] {
			commentEntryModelImpl.getCompanyId(),
			commentEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, commentEntryModelImpl);
	}

	/**
	 * Creates a new comment entry with the primary key. Does not add the comment entry to the database.
	 *
	 * @param commentId the primary key for the new comment entry
	 * @return the new comment entry
	 */
	@Override
	public CommentEntry create(long commentId) {
		CommentEntry commentEntry = new CommentEntryImpl();

		commentEntry.setNew(true);
		commentEntry.setPrimaryKey(commentId);

		String uuid = PortalUUIDUtil.generate();

		commentEntry.setUuid(uuid);

		commentEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return commentEntry;
	}

	/**
	 * Removes the comment entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry that was removed
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	@Override
	public CommentEntry remove(long commentId)
		throws NoSuchCommentEntryException {

		return remove((Serializable)commentId);
	}

	/**
	 * Removes the comment entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comment entry
	 * @return the comment entry that was removed
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	@Override
	public CommentEntry remove(Serializable primaryKey)
		throws NoSuchCommentEntryException {

		Session session = null;

		try {
			session = openSession();

			CommentEntry commentEntry = (CommentEntry)session.get(
				CommentEntryImpl.class, primaryKey);

			if (commentEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommentEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commentEntry);
		}
		catch (NoSuchCommentEntryException noSuchEntityException) {
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
	protected CommentEntry removeImpl(CommentEntry commentEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commentEntry)) {
				commentEntry = (CommentEntry)session.get(
					CommentEntryImpl.class, commentEntry.getPrimaryKeyObj());
			}

			if (commentEntry != null) {
				session.delete(commentEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (commentEntry != null) {
			clearCache(commentEntry);
		}

		return commentEntry;
	}

	@Override
	public CommentEntry updateImpl(CommentEntry commentEntry) {
		boolean isNew = commentEntry.isNew();

		if (!(commentEntry instanceof CommentEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commentEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					commentEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commentEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommentEntry implementation " +
					commentEntry.getClass());
		}

		CommentEntryModelImpl commentEntryModelImpl =
			(CommentEntryModelImpl)commentEntry;

		if (Validator.isNull(commentEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commentEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (commentEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				commentEntry.setCreateDate(date);
			}
			else {
				commentEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!commentEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commentEntry.setModifiedDate(date);
			}
			else {
				commentEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(commentEntry);
			}
			else {
				commentEntry = (CommentEntry)session.merge(commentEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CommentEntryImpl.class, commentEntryModelImpl, false, true);

		cacheUniqueFindersCache(commentEntryModelImpl);

		if (isNew) {
			commentEntry.setNew(false);
		}

		commentEntry.resetOriginalValues();

		return commentEntry;
	}

	/**
	 * Returns the comment entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment entry
	 * @return the comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	@Override
	public CommentEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommentEntryException {

		CommentEntry commentEntry = fetchByPrimaryKey(primaryKey);

		if (commentEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommentEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commentEntry;
	}

	/**
	 * Returns the comment entry with the primary key or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	@Override
	public CommentEntry findByPrimaryKey(long commentId)
		throws NoSuchCommentEntryException {

		return findByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns the comment entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry, or <code>null</code> if a comment entry with the primary key could not be found
	 */
	@Override
	public CommentEntry fetchByPrimaryKey(long commentId) {
		return fetchByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns all the comment entries.
	 *
	 * @return the comment entries
	 */
	@Override
	public List<CommentEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CommentEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CommentEntry> findAll(
		int start, int end, OrderByComparator<CommentEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<CommentEntry> findAll(
		int start, int end, OrderByComparator<CommentEntry> orderByComparator,
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

		List<CommentEntry> list = null;

		if (useFinderCache) {
			list = (List<CommentEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMMENTENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENTENTRY;

				sql = sql.concat(CommentEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CommentEntry>)QueryUtil.list(
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
	 * Removes all the comment entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommentEntry commentEntry : findAll()) {
			remove(commentEntry);
		}
	}

	/**
	 * Returns the number of comment entries.
	 *
	 * @return the number of comment entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMMENTENTRY);

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
		return "commentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMMENTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommentEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comment entry persistence.
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

		_finderPathWithPaginationFindByC_C_C_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "classPkId", "classPkName", "parentId"},
			true);

		_finderPathWithoutPaginationFindByC_C_C_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {"customerId", "classPkId", "classPkName", "parentId"},
			true);

		_finderPathCountByC_C_C_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {"customerId", "classPkId", "classPkName", "parentId"},
			false);

		_finderPathWithPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentId"}, true);

		_finderPathWithoutPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			true);

		_finderPathCountByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setCommentEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCommentEntryUtilPersistence(null);

		entityCache.removeCache(CommentEntryImpl.class.getName());
	}

	private void _setCommentEntryUtilPersistence(
		CommentEntryPersistence commentEntryPersistence) {

		try {
			Field field = CommentEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, commentEntryPersistence);
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

	private static final String _SQL_SELECT_COMMENTENTRY =
		"SELECT commentEntry FROM CommentEntry commentEntry";

	private static final String _SQL_SELECT_COMMENTENTRY_WHERE =
		"SELECT commentEntry FROM CommentEntry commentEntry WHERE ";

	private static final String _SQL_COUNT_COMMENTENTRY =
		"SELECT COUNT(commentEntry) FROM CommentEntry commentEntry";

	private static final String _SQL_COUNT_COMMENTENTRY_WHERE =
		"SELECT COUNT(commentEntry) FROM CommentEntry commentEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "commentEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommentEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommentEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommentEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CommentEntryModelArgumentsResolver
		_commentEntryModelArgumentsResolver;

}