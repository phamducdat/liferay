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

package com.dogoo.common.files.manager.service.service.persistence.impl;

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileVersionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;
import com.dogoo.common.files.manager.service.model.DGFileVersionEntryTable;
import com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryImpl;
import com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryModelImpl;
import com.dogoo.common.files.manager.service.service.persistence.DGFileVersionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileVersionEntryUtil;
import com.dogoo.common.files.manager.service.service.persistence.impl.constants.DG_FILE_MANAGERPersistenceConstants;

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
 * The persistence implementation for the dg file version entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {DGFileVersionEntryPersistence.class, BasePersistence.class}
)
public class DGFileVersionEntryPersistenceImpl
	extends BasePersistenceImpl<DGFileVersionEntry>
	implements DGFileVersionEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGFileVersionEntryUtil</code> to access the dg file version entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGFileVersionEntryImpl.class.getName();

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
	 * Returns all the dg file version entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator,
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

		List<DGFileVersionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileVersionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileVersionEntry dgFileVersionEntry : list) {
					if (!uuid.equals(dgFileVersionEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DGFILEVERSIONENTRY_WHERE);

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
				sb.append(DGFileVersionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileVersionEntry>)QueryUtil.list(
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
	 * Returns the first dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (dgFileVersionEntry != null) {
			return dgFileVersionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileVersionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByUuid_First(
		String uuid, OrderByComparator<DGFileVersionEntry> orderByComparator) {

		List<DGFileVersionEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dgFileVersionEntry != null) {
			return dgFileVersionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileVersionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DGFileVersionEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DGFileVersionEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file version entries before and after the current dg file version entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileVersionId the primary key of the current dg file version entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public DGFileVersionEntry[] findByUuid_PrevAndNext(
			long fileVersionId, String uuid,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws NoSuchDGFileVersionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileVersionEntry dgFileVersionEntry = findByPrimaryKey(fileVersionId);

		Session session = null;

		try {
			session = openSession();

			DGFileVersionEntry[] array = new DGFileVersionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dgFileVersionEntry, uuid, orderByComparator, true);

			array[1] = dgFileVersionEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dgFileVersionEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileVersionEntry getByUuid_PrevAndNext(
		Session session, DGFileVersionEntry dgFileVersionEntry, String uuid,
		OrderByComparator<DGFileVersionEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFILEVERSIONENTRY_WHERE);

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
			sb.append(DGFileVersionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileVersionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileVersionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file version entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DGFileVersionEntry dgFileVersionEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgFileVersionEntry);
		}
	}

	/**
	 * Returns the number of dg file version entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file version entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFILEVERSIONENTRY_WHERE);

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
		"dgFileVersionEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dgFileVersionEntry.uuid IS NULL OR dgFileVersionEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByUUID_G(uuid, groupId);

		if (dgFileVersionEntry == null) {
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

			throw new NoSuchDGFileVersionEntryException(sb.toString());
		}

		return dgFileVersionEntry;
	}

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dg file version entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByUUID_G(
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

		if (result instanceof DGFileVersionEntry) {
			DGFileVersionEntry dgFileVersionEntry = (DGFileVersionEntry)result;

			if (!Objects.equals(uuid, dgFileVersionEntry.getUuid()) ||
				(groupId != dgFileVersionEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEVERSIONENTRY_WHERE);

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

				List<DGFileVersionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DGFileVersionEntry dgFileVersionEntry = list.get(0);

					result = dgFileVersionEntry;

					cacheResult(dgFileVersionEntry);
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
			return (DGFileVersionEntry)result;
		}
	}

	/**
	 * Removes the dg file version entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file version entry that was removed
	 */
	@Override
	public DGFileVersionEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = findByUUID_G(uuid, groupId);

		return remove(dgFileVersionEntry);
	}

	/**
	 * Returns the number of dg file version entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file version entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEVERSIONENTRY_WHERE);

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
		"dgFileVersionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dgFileVersionEntry.uuid IS NULL OR dgFileVersionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dgFileVersionEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator,
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

		List<DGFileVersionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileVersionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileVersionEntry dgFileVersionEntry : list) {
					if (!uuid.equals(dgFileVersionEntry.getUuid()) ||
						(companyId != dgFileVersionEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DGFILEVERSIONENTRY_WHERE);

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
				sb.append(DGFileVersionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileVersionEntry>)QueryUtil.list(
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
	 * Returns the first dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dgFileVersionEntry != null) {
			return dgFileVersionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileVersionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		List<DGFileVersionEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dgFileVersionEntry != null) {
			return dgFileVersionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileVersionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DGFileVersionEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file version entries before and after the current dg file version entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileVersionId the primary key of the current dg file version entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public DGFileVersionEntry[] findByUuid_C_PrevAndNext(
			long fileVersionId, String uuid, long companyId,
			OrderByComparator<DGFileVersionEntry> orderByComparator)
		throws NoSuchDGFileVersionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileVersionEntry dgFileVersionEntry = findByPrimaryKey(fileVersionId);

		Session session = null;

		try {
			session = openSession();

			DGFileVersionEntry[] array = new DGFileVersionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dgFileVersionEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = dgFileVersionEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dgFileVersionEntry, uuid, companyId, orderByComparator,
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

	protected DGFileVersionEntry getByUuid_C_PrevAndNext(
		Session session, DGFileVersionEntry dgFileVersionEntry, String uuid,
		long companyId, OrderByComparator<DGFileVersionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEVERSIONENTRY_WHERE);

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
			sb.append(DGFileVersionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileVersionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileVersionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file version entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DGFileVersionEntry dgFileVersionEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFileVersionEntry);
		}
	}

	/**
	 * Returns the number of dg file version entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file version entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEVERSIONENTRY_WHERE);

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
		"dgFileVersionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dgFileVersionEntry.uuid IS NULL OR dgFileVersionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dgFileVersionEntry.companyId = ?";

	private FinderPath _finderPathFetchByC_FV;
	private FinderPath _finderPathCountByC_FV;

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry findByC_FV(long customerId, long fileVersionId)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByC_FV(
			customerId, fileVersionId);

		if (dgFileVersionEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", fileVersionId=");
			sb.append(fileVersionId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileVersionEntryException(sb.toString());
		}

		return dgFileVersionEntry;
	}

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByC_FV(long customerId, long fileVersionId) {
		return fetchByC_FV(customerId, fileVersionId, true);
	}

	/**
	 * Returns the dg file version entry where customerId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByC_FV(
		long customerId, long fileVersionId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, fileVersionId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_FV, finderArgs);
		}

		if (result instanceof DGFileVersionEntry) {
			DGFileVersionEntry dgFileVersionEntry = (DGFileVersionEntry)result;

			if ((customerId != dgFileVersionEntry.getCustomerId()) ||
				(fileVersionId != dgFileVersionEntry.getFileVersionId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEVERSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_FV_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_FV_FILEVERSIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileVersionId);

				List<DGFileVersionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_FV, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, fileVersionId
								};
							}

							_log.warn(
								"DGFileVersionEntryPersistenceImpl.fetchByC_FV(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileVersionEntry dgFileVersionEntry = list.get(0);

					result = dgFileVersionEntry;

					cacheResult(dgFileVersionEntry);
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
			return (DGFileVersionEntry)result;
		}
	}

	/**
	 * Removes the dg file version entry where customerId = &#63; and fileVersionId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the dg file version entry that was removed
	 */
	@Override
	public DGFileVersionEntry removeByC_FV(long customerId, long fileVersionId)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = findByC_FV(
			customerId, fileVersionId);

		return remove(dgFileVersionEntry);
	}

	/**
	 * Returns the number of dg file version entries where customerId = &#63; and fileVersionId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileVersionId the file version ID
	 * @return the number of matching dg file version entries
	 */
	@Override
	public int countByC_FV(long customerId, long fileVersionId) {
		FinderPath finderPath = _finderPathCountByC_FV;

		Object[] finderArgs = new Object[] {customerId, fileVersionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEVERSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_FV_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_FV_FILEVERSIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileVersionId);

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

	private static final String _FINDER_COLUMN_C_FV_CUSTOMERID_2 =
		"dgFileVersionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_FV_FILEVERSIONID_2 =
		"dgFileVersionEntry.fileVersionId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (dgFileVersionEntry == null) {
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

			throw new NoSuchDGFileVersionEntryException(sb.toString());
		}

		return dgFileVersionEntry;
	}

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByC_ERC(
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

		if (result instanceof DGFileVersionEntry) {
			DGFileVersionEntry dgFileVersionEntry = (DGFileVersionEntry)result;

			if ((companyId != dgFileVersionEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dgFileVersionEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEVERSIONENTRY_WHERE);

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

				List<DGFileVersionEntry> list = query.list();

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
								"DGFileVersionEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileVersionEntry dgFileVersionEntry = list.get(0);

					result = dgFileVersionEntry;

					cacheResult(dgFileVersionEntry);
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
			return (DGFileVersionEntry)result;
		}
	}

	/**
	 * Removes the dg file version entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file version entry that was removed
	 */
	@Override
	public DGFileVersionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(dgFileVersionEntry);
	}

	/**
	 * Returns the number of dg file version entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file version entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEVERSIONENTRY_WHERE);

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
		"dgFileVersionEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dgFileVersionEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dgFileVersionEntry.externalReferenceCode IS NULL OR dgFileVersionEntry.externalReferenceCode = '')";

	public DGFileVersionEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGFileVersionEntry.class);

		setModelImplClass(DGFileVersionEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DGFileVersionEntryTable.INSTANCE);
	}

	/**
	 * Caches the dg file version entry in the entity cache if it is enabled.
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 */
	@Override
	public void cacheResult(DGFileVersionEntry dgFileVersionEntry) {
		entityCache.putResult(
			DGFileVersionEntryImpl.class, dgFileVersionEntry.getPrimaryKey(),
			dgFileVersionEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dgFileVersionEntry.getUuid(), dgFileVersionEntry.getGroupId()
			},
			dgFileVersionEntry);

		finderCache.putResult(
			_finderPathFetchByC_FV,
			new Object[] {
				dgFileVersionEntry.getCustomerId(),
				dgFileVersionEntry.getFileVersionId()
			},
			dgFileVersionEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dgFileVersionEntry.getCompanyId(),
				dgFileVersionEntry.getExternalReferenceCode()
			},
			dgFileVersionEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dg file version entries in the entity cache if it is enabled.
	 *
	 * @param dgFileVersionEntries the dg file version entries
	 */
	@Override
	public void cacheResult(List<DGFileVersionEntry> dgFileVersionEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgFileVersionEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGFileVersionEntry dgFileVersionEntry : dgFileVersionEntries) {
			if (entityCache.getResult(
					DGFileVersionEntryImpl.class,
					dgFileVersionEntry.getPrimaryKey()) == null) {

				cacheResult(dgFileVersionEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dg file version entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGFileVersionEntryImpl.class);

		finderCache.clearCache(DGFileVersionEntryImpl.class);
	}

	/**
	 * Clears the cache for the dg file version entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DGFileVersionEntry dgFileVersionEntry) {
		entityCache.removeResult(
			DGFileVersionEntryImpl.class, dgFileVersionEntry);
	}

	@Override
	public void clearCache(List<DGFileVersionEntry> dgFileVersionEntries) {
		for (DGFileVersionEntry dgFileVersionEntry : dgFileVersionEntries) {
			entityCache.removeResult(
				DGFileVersionEntryImpl.class, dgFileVersionEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGFileVersionEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DGFileVersionEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGFileVersionEntryModelImpl dgFileVersionEntryModelImpl) {

		Object[] args = new Object[] {
			dgFileVersionEntryModelImpl.getUuid(),
			dgFileVersionEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dgFileVersionEntryModelImpl);

		args = new Object[] {
			dgFileVersionEntryModelImpl.getCustomerId(),
			dgFileVersionEntryModelImpl.getFileVersionId()
		};

		finderCache.putResult(_finderPathCountByC_FV, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_FV, args, dgFileVersionEntryModelImpl);

		args = new Object[] {
			dgFileVersionEntryModelImpl.getCompanyId(),
			dgFileVersionEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, dgFileVersionEntryModelImpl);
	}

	/**
	 * Creates a new dg file version entry with the primary key. Does not add the dg file version entry to the database.
	 *
	 * @param fileVersionId the primary key for the new dg file version entry
	 * @return the new dg file version entry
	 */
	@Override
	public DGFileVersionEntry create(long fileVersionId) {
		DGFileVersionEntry dgFileVersionEntry = new DGFileVersionEntryImpl();

		dgFileVersionEntry.setNew(true);
		dgFileVersionEntry.setPrimaryKey(fileVersionId);

		String uuid = PortalUUIDUtil.generate();

		dgFileVersionEntry.setUuid(uuid);

		dgFileVersionEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgFileVersionEntry;
	}

	/**
	 * Removes the dg file version entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry that was removed
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public DGFileVersionEntry remove(long fileVersionId)
		throws NoSuchDGFileVersionEntryException {

		return remove((Serializable)fileVersionId);
	}

	/**
	 * Removes the dg file version entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dg file version entry
	 * @return the dg file version entry that was removed
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public DGFileVersionEntry remove(Serializable primaryKey)
		throws NoSuchDGFileVersionEntryException {

		Session session = null;

		try {
			session = openSession();

			DGFileVersionEntry dgFileVersionEntry =
				(DGFileVersionEntry)session.get(
					DGFileVersionEntryImpl.class, primaryKey);

			if (dgFileVersionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGFileVersionEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgFileVersionEntry);
		}
		catch (NoSuchDGFileVersionEntryException noSuchEntityException) {
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
	protected DGFileVersionEntry removeImpl(
		DGFileVersionEntry dgFileVersionEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgFileVersionEntry)) {
				dgFileVersionEntry = (DGFileVersionEntry)session.get(
					DGFileVersionEntryImpl.class,
					dgFileVersionEntry.getPrimaryKeyObj());
			}

			if (dgFileVersionEntry != null) {
				session.delete(dgFileVersionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgFileVersionEntry != null) {
			clearCache(dgFileVersionEntry);
		}

		return dgFileVersionEntry;
	}

	@Override
	public DGFileVersionEntry updateImpl(
		DGFileVersionEntry dgFileVersionEntry) {

		boolean isNew = dgFileVersionEntry.isNew();

		if (!(dgFileVersionEntry instanceof DGFileVersionEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgFileVersionEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgFileVersionEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgFileVersionEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGFileVersionEntry implementation " +
					dgFileVersionEntry.getClass());
		}

		DGFileVersionEntryModelImpl dgFileVersionEntryModelImpl =
			(DGFileVersionEntryModelImpl)dgFileVersionEntry;

		if (Validator.isNull(dgFileVersionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dgFileVersionEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgFileVersionEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgFileVersionEntry.setCreateDate(date);
			}
			else {
				dgFileVersionEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgFileVersionEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgFileVersionEntry.setModifiedDate(date);
			}
			else {
				dgFileVersionEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgFileVersionEntry);
			}
			else {
				dgFileVersionEntry = (DGFileVersionEntry)session.merge(
					dgFileVersionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGFileVersionEntryImpl.class, dgFileVersionEntryModelImpl, false,
			true);

		cacheUniqueFindersCache(dgFileVersionEntryModelImpl);

		if (isNew) {
			dgFileVersionEntry.setNew(false);
		}

		dgFileVersionEntry.resetOriginalValues();

		return dgFileVersionEntry;
	}

	/**
	 * Returns the dg file version entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dg file version entry
	 * @return the dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public DGFileVersionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDGFileVersionEntryException {

		DGFileVersionEntry dgFileVersionEntry = fetchByPrimaryKey(primaryKey);

		if (dgFileVersionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGFileVersionEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgFileVersionEntry;
	}

	/**
	 * Returns the dg file version entry with the primary key or throws a <code>NoSuchDGFileVersionEntryException</code> if it could not be found.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry
	 * @throws NoSuchDGFileVersionEntryException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public DGFileVersionEntry findByPrimaryKey(long fileVersionId)
		throws NoSuchDGFileVersionEntryException {

		return findByPrimaryKey((Serializable)fileVersionId);
	}

	/**
	 * Returns the dg file version entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry, or <code>null</code> if a dg file version entry with the primary key could not be found
	 */
	@Override
	public DGFileVersionEntry fetchByPrimaryKey(long fileVersionId) {
		return fetchByPrimaryKey((Serializable)fileVersionId);
	}

	/**
	 * Returns all the dg file version entries.
	 *
	 * @return the dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file version entries
	 */
	@Override
	public List<DGFileVersionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileVersionEntry> orderByComparator,
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

		List<DGFileVersionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileVersionEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFILEVERSIONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFILEVERSIONENTRY;

				sql = sql.concat(DGFileVersionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGFileVersionEntry>)QueryUtil.list(
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
	 * Removes all the dg file version entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGFileVersionEntry dgFileVersionEntry : findAll()) {
			remove(dgFileVersionEntry);
		}
	}

	/**
	 * Returns the number of dg file version entries.
	 *
	 * @return the number of dg file version entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_DGFILEVERSIONENTRY);

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
		return "fileVersionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFILEVERSIONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGFileVersionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dg file version entry persistence.
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

		_finderPathFetchByC_FV = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_FV",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "fileVersionId"}, true);

		_finderPathCountByC_FV = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_FV",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "fileVersionId"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDGFileVersionEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGFileVersionEntryUtilPersistence(null);

		entityCache.removeCache(DGFileVersionEntryImpl.class.getName());
	}

	private void _setDGFileVersionEntryUtilPersistence(
		DGFileVersionEntryPersistence dgFileVersionEntryPersistence) {

		try {
			Field field = DGFileVersionEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgFileVersionEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DG_FILE_MANAGERPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DG_FILE_MANAGERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DG_FILE_MANAGERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DGFILEVERSIONENTRY =
		"SELECT dgFileVersionEntry FROM DGFileVersionEntry dgFileVersionEntry";

	private static final String _SQL_SELECT_DGFILEVERSIONENTRY_WHERE =
		"SELECT dgFileVersionEntry FROM DGFileVersionEntry dgFileVersionEntry WHERE ";

	private static final String _SQL_COUNT_DGFILEVERSIONENTRY =
		"SELECT COUNT(dgFileVersionEntry) FROM DGFileVersionEntry dgFileVersionEntry";

	private static final String _SQL_COUNT_DGFILEVERSIONENTRY_WHERE =
		"SELECT COUNT(dgFileVersionEntry) FROM DGFileVersionEntry dgFileVersionEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgFileVersionEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGFileVersionEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGFileVersionEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGFileVersionEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGFileVersionEntryModelArgumentsResolver
		_dgFileVersionEntryModelArgumentsResolver;

}