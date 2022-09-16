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

package com.dogoo.dataitems.service.service.persistence.impl;

import com.dogoo.dataitems.service.exception.NoSuchDataItemEntryException;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.model.DataItemEntryTable;
import com.dogoo.dataitems.service.model.impl.DataItemEntryImpl;
import com.dogoo.dataitems.service.model.impl.DataItemEntryModelImpl;
import com.dogoo.dataitems.service.service.persistence.DataItemEntryPersistence;
import com.dogoo.dataitems.service.service.persistence.DataItemEntryUtil;
import com.dogoo.dataitems.service.service.persistence.impl.constants.DG_DATAITEMSPersistenceConstants;

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
 * The persistence implementation for the data item entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nghiatt
 * @generated
 */
@Component(service = {DataItemEntryPersistence.class, BasePersistence.class})
public class DataItemEntryPersistenceImpl
	extends BasePersistenceImpl<DataItemEntry>
	implements DataItemEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataItemEntryUtil</code> to access the data item entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataItemEntryImpl.class.getName();

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
	 * Returns all the data item entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator,
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

		List<DataItemEntry> list = null;

		if (useFinderCache) {
			list = (List<DataItemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DataItemEntry dataItemEntry : list) {
					if (!uuid.equals(dataItemEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

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
				sb.append(DataItemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DataItemEntry>)QueryUtil.list(
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
	 * Returns the first data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByUuid_First(
			String uuid, OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (dataItemEntry != null) {
			return dataItemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDataItemEntryException(sb.toString());
	}

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByUuid_First(
		String uuid, OrderByComparator<DataItemEntry> orderByComparator) {

		List<DataItemEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByUuid_Last(
			String uuid, OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (dataItemEntry != null) {
			return dataItemEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDataItemEntryException(sb.toString());
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DataItemEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DataItemEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where uuid = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry[] findByUuid_PrevAndNext(
			long dataItemId, String uuid,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		uuid = Objects.toString(uuid, "");

		DataItemEntry dataItemEntry = findByPrimaryKey(dataItemId);

		Session session = null;

		try {
			session = openSession();

			DataItemEntry[] array = new DataItemEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dataItemEntry, uuid, orderByComparator, true);

			array[1] = dataItemEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dataItemEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataItemEntry getByUuid_PrevAndNext(
		Session session, DataItemEntry dataItemEntry, String uuid,
		OrderByComparator<DataItemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

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
			sb.append(DataItemEntryModelImpl.ORDER_BY_JPQL);
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
						dataItemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataItemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data item entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DataItemEntry dataItemEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataItemEntry);
		}
	}

	/**
	 * Returns the number of data item entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data item entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATAITEMENTRY_WHERE);

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
		"dataItemEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dataItemEntry.uuid IS NULL OR dataItemEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByUUID_G(uuid, groupId);

		if (dataItemEntry == null) {
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

			throw new NoSuchDataItemEntryException(sb.toString());
		}

		return dataItemEntry;
	}

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the data item entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByUUID_G(
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

		if (result instanceof DataItemEntry) {
			DataItemEntry dataItemEntry = (DataItemEntry)result;

			if (!Objects.equals(uuid, dataItemEntry.getUuid()) ||
				(groupId != dataItemEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

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

				List<DataItemEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DataItemEntry dataItemEntry = list.get(0);

					result = dataItemEntry;

					cacheResult(dataItemEntry);
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
			return (DataItemEntry)result;
		}
	}

	/**
	 * Removes the data item entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data item entry that was removed
	 */
	@Override
	public DataItemEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = findByUUID_G(uuid, groupId);

		return remove(dataItemEntry);
	}

	/**
	 * Returns the number of data item entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data item entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATAITEMENTRY_WHERE);

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
		"dataItemEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dataItemEntry.uuid IS NULL OR dataItemEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dataItemEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator,
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

		List<DataItemEntry> list = null;

		if (useFinderCache) {
			list = (List<DataItemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DataItemEntry dataItemEntry : list) {
					if (!uuid.equals(dataItemEntry.getUuid()) ||
						(companyId != dataItemEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

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
				sb.append(DataItemEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DataItemEntry>)QueryUtil.list(
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
	 * Returns the first data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dataItemEntry != null) {
			return dataItemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDataItemEntryException(sb.toString());
	}

	/**
	 * Returns the first data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataItemEntry> orderByComparator) {

		List<DataItemEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dataItemEntry != null) {
			return dataItemEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDataItemEntryException(sb.toString());
	}

	/**
	 * Returns the last data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataItemEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DataItemEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry[] findByUuid_C_PrevAndNext(
			long dataItemId, String uuid, long companyId,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		uuid = Objects.toString(uuid, "");

		DataItemEntry dataItemEntry = findByPrimaryKey(dataItemId);

		Session session = null;

		try {
			session = openSession();

			DataItemEntry[] array = new DataItemEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dataItemEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = dataItemEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dataItemEntry, uuid, companyId, orderByComparator,
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

	protected DataItemEntry getByUuid_C_PrevAndNext(
		Session session, DataItemEntry dataItemEntry, String uuid,
		long companyId, OrderByComparator<DataItemEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

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
			sb.append(DataItemEntryModelImpl.ORDER_BY_JPQL);
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
						dataItemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataItemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data item entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DataItemEntry dataItemEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataItemEntry);
		}
	}

	/**
	 * Returns the number of data item entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data item entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATAITEMENTRY_WHERE);

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
		"dataItemEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dataItemEntry.uuid IS NULL OR dataItemEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dataItemEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_P_T;
	private FinderPath _finderPathWithoutPaginationFindByC_P_T;
	private FinderPath _finderPathCountByC_P_T;

	/**
	 * Returns all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type) {

		return findByC_P_T(
			customerId, parentId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end) {

		return findByC_P_T(customerId, parentId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return findByC_P_T(
			customerId, parentId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data item entries
	 */
	@Override
	public List<DataItemEntry> findByC_P_T(
		long customerId, long parentId, String type, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_P_T;
				finderArgs = new Object[] {customerId, parentId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_P_T;
			finderArgs = new Object[] {
				customerId, parentId, type, start, end, orderByComparator
			};
		}

		List<DataItemEntry> list = null;

		if (useFinderCache) {
			list = (List<DataItemEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DataItemEntry dataItemEntry : list) {
					if ((customerId != dataItemEntry.getCustomerId()) ||
						(parentId != dataItemEntry.getParentId()) ||
						!type.equals(dataItemEntry.getType())) {

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

			sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_P_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_P_T_PARENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_P_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_P_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataItemEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(parentId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<DataItemEntry>)QueryUtil.list(
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
	 * Returns the first data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByC_P_T_First(
			long customerId, long parentId, String type,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByC_P_T_First(
			customerId, parentId, type, orderByComparator);

		if (dataItemEntry != null) {
			return dataItemEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDataItemEntryException(sb.toString());
	}

	/**
	 * Returns the first data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByC_P_T_First(
		long customerId, long parentId, String type,
		OrderByComparator<DataItemEntry> orderByComparator) {

		List<DataItemEntry> list = findByC_P_T(
			customerId, parentId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByC_P_T_Last(
			long customerId, long parentId, String type,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByC_P_T_Last(
			customerId, parentId, type, orderByComparator);

		if (dataItemEntry != null) {
			return dataItemEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDataItemEntryException(sb.toString());
	}

	/**
	 * Returns the last data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByC_P_T_Last(
		long customerId, long parentId, String type,
		OrderByComparator<DataItemEntry> orderByComparator) {

		int count = countByC_P_T(customerId, parentId, type);

		if (count == 0) {
			return null;
		}

		List<DataItemEntry> list = findByC_P_T(
			customerId, parentId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data item entries before and after the current data item entry in the ordered set where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param dataItemId the primary key of the current data item entry
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry[] findByC_P_T_PrevAndNext(
			long dataItemId, long customerId, long parentId, String type,
			OrderByComparator<DataItemEntry> orderByComparator)
		throws NoSuchDataItemEntryException {

		type = Objects.toString(type, "");

		DataItemEntry dataItemEntry = findByPrimaryKey(dataItemId);

		Session session = null;

		try {
			session = openSession();

			DataItemEntry[] array = new DataItemEntryImpl[3];

			array[0] = getByC_P_T_PrevAndNext(
				session, dataItemEntry, customerId, parentId, type,
				orderByComparator, true);

			array[1] = dataItemEntry;

			array[2] = getByC_P_T_PrevAndNext(
				session, dataItemEntry, customerId, parentId, type,
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

	protected DataItemEntry getByC_P_T_PrevAndNext(
		Session session, DataItemEntry dataItemEntry, long customerId,
		long parentId, String type,
		OrderByComparator<DataItemEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_P_T_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_P_T_PARENTID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_P_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_C_P_T_TYPE_2);
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
			sb.append(DataItemEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(parentId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataItemEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataItemEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data item entries where customerId = &#63; and parentId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 */
	@Override
	public void removeByC_P_T(long customerId, long parentId, String type) {
		for (DataItemEntry dataItemEntry :
				findByC_P_T(
					customerId, parentId, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataItemEntry);
		}
	}

	/**
	 * Returns the number of data item entries where customerId = &#63; and parentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the number of matching data item entries
	 */
	@Override
	public int countByC_P_T(long customerId, long parentId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_P_T;

		Object[] finderArgs = new Object[] {customerId, parentId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DATAITEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_P_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_P_T_PARENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_P_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_P_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(parentId);

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_C_P_T_CUSTOMERID_2 =
		"dataItemEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_P_T_PARENTID_2 =
		"dataItemEntry.parentId = ? AND ";

	private static final String _FINDER_COLUMN_C_P_T_TYPE_2 =
		"dataItemEntry.type = ?";

	private static final String _FINDER_COLUMN_C_P_T_TYPE_3 =
		"(dataItemEntry.type IS NULL OR dataItemEntry.type = '')";

	private FinderPath _finderPathFetchByC_P_N_T;
	private FinderPath _finderPathCountByC_P_N_T;

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByC_P_N_T(
			long customerId, long parentId, String name, String type)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByC_P_N_T(
			customerId, parentId, name, type);

		if (dataItemEntry == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", parentId=");
			sb.append(parentId);

			sb.append(", name=");
			sb.append(name);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDataItemEntryException(sb.toString());
		}

		return dataItemEntry;
	}

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByC_P_N_T(
		long customerId, long parentId, String name, String type) {

		return fetchByC_P_N_T(customerId, parentId, name, type, true);
	}

	/**
	 * Returns the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByC_P_N_T(
		long customerId, long parentId, String name, String type,
		boolean useFinderCache) {

		name = Objects.toString(name, "");
		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, parentId, name, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_P_N_T, finderArgs);
		}

		if (result instanceof DataItemEntry) {
			DataItemEntry dataItemEntry = (DataItemEntry)result;

			if ((customerId != dataItemEntry.getCustomerId()) ||
				(parentId != dataItemEntry.getParentId()) ||
				!Objects.equals(name, dataItemEntry.getName()) ||
				!Objects.equals(type, dataItemEntry.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_P_N_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_P_N_T_PARENTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_P_N_T_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_C_P_N_T_NAME_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_P_N_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_P_N_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(parentId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindType) {
					queryPos.add(type);
				}

				List<DataItemEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_P_N_T, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, parentId, name, type
								};
							}

							_log.warn(
								"DataItemEntryPersistenceImpl.fetchByC_P_N_T(long, long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataItemEntry dataItemEntry = list.get(0);

					result = dataItemEntry;

					cacheResult(dataItemEntry);
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
			return (DataItemEntry)result;
		}
	}

	/**
	 * Removes the data item entry where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the data item entry that was removed
	 */
	@Override
	public DataItemEntry removeByC_P_N_T(
			long customerId, long parentId, String name, String type)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = findByC_P_N_T(
			customerId, parentId, name, type);

		return remove(dataItemEntry);
	}

	/**
	 * Returns the number of data item entries where customerId = &#63; and parentId = &#63; and name = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param type the type
	 * @return the number of matching data item entries
	 */
	@Override
	public int countByC_P_N_T(
		long customerId, long parentId, String name, String type) {

		name = Objects.toString(name, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_P_N_T;

		Object[] finderArgs = new Object[] {customerId, parentId, name, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DATAITEMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_P_N_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_P_N_T_PARENTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_P_N_T_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_C_P_N_T_NAME_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_P_N_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_P_N_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(parentId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_C_P_N_T_CUSTOMERID_2 =
		"dataItemEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_P_N_T_PARENTID_2 =
		"dataItemEntry.parentId = ? AND ";

	private static final String _FINDER_COLUMN_C_P_N_T_NAME_2 =
		"dataItemEntry.name = ? AND ";

	private static final String _FINDER_COLUMN_C_P_N_T_NAME_3 =
		"(dataItemEntry.name IS NULL OR dataItemEntry.name = '') AND ";

	private static final String _FINDER_COLUMN_C_P_N_T_TYPE_2 =
		"dataItemEntry.type = ?";

	private static final String _FINDER_COLUMN_C_P_N_T_TYPE_3 =
		"(dataItemEntry.type IS NULL OR dataItemEntry.type = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching data item entry
	 * @throws NoSuchDataItemEntryException if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (dataItemEntry == null) {
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

			throw new NoSuchDataItemEntryException(sb.toString());
		}

		return dataItemEntry;
	}

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the data item entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public DataItemEntry fetchByC_ERC(
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

		if (result instanceof DataItemEntry) {
			DataItemEntry dataItemEntry = (DataItemEntry)result;

			if ((companyId != dataItemEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dataItemEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATAITEMENTRY_WHERE);

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

				List<DataItemEntry> list = query.list();

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
								"DataItemEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataItemEntry dataItemEntry = list.get(0);

					result = dataItemEntry;

					cacheResult(dataItemEntry);
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
			return (DataItemEntry)result;
		}
	}

	/**
	 * Removes the data item entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the data item entry that was removed
	 */
	@Override
	public DataItemEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(dataItemEntry);
	}

	/**
	 * Returns the number of data item entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching data item entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATAITEMENTRY_WHERE);

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
		"dataItemEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dataItemEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dataItemEntry.externalReferenceCode IS NULL OR dataItemEntry.externalReferenceCode = '')";

	public DataItemEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DataItemEntry.class);

		setModelImplClass(DataItemEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DataItemEntryTable.INSTANCE);
	}

	/**
	 * Caches the data item entry in the entity cache if it is enabled.
	 *
	 * @param dataItemEntry the data item entry
	 */
	@Override
	public void cacheResult(DataItemEntry dataItemEntry) {
		entityCache.putResult(
			DataItemEntryImpl.class, dataItemEntry.getPrimaryKey(),
			dataItemEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {dataItemEntry.getUuid(), dataItemEntry.getGroupId()},
			dataItemEntry);

		finderCache.putResult(
			_finderPathFetchByC_P_N_T,
			new Object[] {
				dataItemEntry.getCustomerId(), dataItemEntry.getParentId(),
				dataItemEntry.getName(), dataItemEntry.getType()
			},
			dataItemEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dataItemEntry.getCompanyId(),
				dataItemEntry.getExternalReferenceCode()
			},
			dataItemEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the data item entries in the entity cache if it is enabled.
	 *
	 * @param dataItemEntries the data item entries
	 */
	@Override
	public void cacheResult(List<DataItemEntry> dataItemEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dataItemEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DataItemEntry dataItemEntry : dataItemEntries) {
			if (entityCache.getResult(
					DataItemEntryImpl.class, dataItemEntry.getPrimaryKey()) ==
						null) {

				cacheResult(dataItemEntry);
			}
		}
	}

	/**
	 * Clears the cache for all data item entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataItemEntryImpl.class);

		finderCache.clearCache(DataItemEntryImpl.class);
	}

	/**
	 * Clears the cache for the data item entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataItemEntry dataItemEntry) {
		entityCache.removeResult(DataItemEntryImpl.class, dataItemEntry);
	}

	@Override
	public void clearCache(List<DataItemEntry> dataItemEntries) {
		for (DataItemEntry dataItemEntry : dataItemEntries) {
			entityCache.removeResult(DataItemEntryImpl.class, dataItemEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DataItemEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DataItemEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DataItemEntryModelImpl dataItemEntryModelImpl) {

		Object[] args = new Object[] {
			dataItemEntryModelImpl.getUuid(),
			dataItemEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dataItemEntryModelImpl);

		args = new Object[] {
			dataItemEntryModelImpl.getCustomerId(),
			dataItemEntryModelImpl.getParentId(),
			dataItemEntryModelImpl.getName(), dataItemEntryModelImpl.getType()
		};

		finderCache.putResult(_finderPathCountByC_P_N_T, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_P_N_T, args, dataItemEntryModelImpl);

		args = new Object[] {
			dataItemEntryModelImpl.getCompanyId(),
			dataItemEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, dataItemEntryModelImpl);
	}

	/**
	 * Creates a new data item entry with the primary key. Does not add the data item entry to the database.
	 *
	 * @param dataItemId the primary key for the new data item entry
	 * @return the new data item entry
	 */
	@Override
	public DataItemEntry create(long dataItemId) {
		DataItemEntry dataItemEntry = new DataItemEntryImpl();

		dataItemEntry.setNew(true);
		dataItemEntry.setPrimaryKey(dataItemId);

		String uuid = PortalUUIDUtil.generate();

		dataItemEntry.setUuid(uuid);

		dataItemEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dataItemEntry;
	}

	/**
	 * Removes the data item entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry that was removed
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry remove(long dataItemId)
		throws NoSuchDataItemEntryException {

		return remove((Serializable)dataItemId);
	}

	/**
	 * Removes the data item entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data item entry
	 * @return the data item entry that was removed
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry remove(Serializable primaryKey)
		throws NoSuchDataItemEntryException {

		Session session = null;

		try {
			session = openSession();

			DataItemEntry dataItemEntry = (DataItemEntry)session.get(
				DataItemEntryImpl.class, primaryKey);

			if (dataItemEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataItemEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataItemEntry);
		}
		catch (NoSuchDataItemEntryException noSuchEntityException) {
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
	protected DataItemEntry removeImpl(DataItemEntry dataItemEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataItemEntry)) {
				dataItemEntry = (DataItemEntry)session.get(
					DataItemEntryImpl.class, dataItemEntry.getPrimaryKeyObj());
			}

			if (dataItemEntry != null) {
				session.delete(dataItemEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataItemEntry != null) {
			clearCache(dataItemEntry);
		}

		return dataItemEntry;
	}

	@Override
	public DataItemEntry updateImpl(DataItemEntry dataItemEntry) {
		boolean isNew = dataItemEntry.isNew();

		if (!(dataItemEntry instanceof DataItemEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataItemEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dataItemEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataItemEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataItemEntry implementation " +
					dataItemEntry.getClass());
		}

		DataItemEntryModelImpl dataItemEntryModelImpl =
			(DataItemEntryModelImpl)dataItemEntry;

		if (Validator.isNull(dataItemEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dataItemEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dataItemEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dataItemEntry.setCreateDate(date);
			}
			else {
				dataItemEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!dataItemEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dataItemEntry.setModifiedDate(date);
			}
			else {
				dataItemEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dataItemEntry);
			}
			else {
				dataItemEntry = (DataItemEntry)session.merge(dataItemEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DataItemEntryImpl.class, dataItemEntryModelImpl, false, true);

		cacheUniqueFindersCache(dataItemEntryModelImpl);

		if (isNew) {
			dataItemEntry.setNew(false);
		}

		dataItemEntry.resetOriginalValues();

		return dataItemEntry;
	}

	/**
	 * Returns the data item entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data item entry
	 * @return the data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataItemEntryException {

		DataItemEntry dataItemEntry = fetchByPrimaryKey(primaryKey);

		if (dataItemEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataItemEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataItemEntry;
	}

	/**
	 * Returns the data item entry with the primary key or throws a <code>NoSuchDataItemEntryException</code> if it could not be found.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry
	 * @throws NoSuchDataItemEntryException if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry findByPrimaryKey(long dataItemId)
		throws NoSuchDataItemEntryException {

		return findByPrimaryKey((Serializable)dataItemId);
	}

	/**
	 * Returns the data item entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry, or <code>null</code> if a data item entry with the primary key could not be found
	 */
	@Override
	public DataItemEntry fetchByPrimaryKey(long dataItemId) {
		return fetchByPrimaryKey((Serializable)dataItemId);
	}

	/**
	 * Returns all the data item entries.
	 *
	 * @return the data item entries
	 */
	@Override
	public List<DataItemEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of data item entries
	 */
	@Override
	public List<DataItemEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data item entries
	 */
	@Override
	public List<DataItemEntry> findAll(
		int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data item entries
	 */
	@Override
	public List<DataItemEntry> findAll(
		int start, int end, OrderByComparator<DataItemEntry> orderByComparator,
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

		List<DataItemEntry> list = null;

		if (useFinderCache) {
			list = (List<DataItemEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATAITEMENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATAITEMENTRY;

				sql = sql.concat(DataItemEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataItemEntry>)QueryUtil.list(
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
	 * Removes all the data item entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataItemEntry dataItemEntry : findAll()) {
			remove(dataItemEntry);
		}
	}

	/**
	 * Returns the number of data item entries.
	 *
	 * @return the number of data item entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATAITEMENTRY);

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
		return "dataItemId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATAITEMENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataItemEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data item entry persistence.
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

		_finderPathWithPaginationFindByC_P_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_P_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId", "parentId", "type_"}, true);

		_finderPathWithoutPaginationFindByC_P_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_P_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "parentId", "type_"}, true);

		_finderPathCountByC_P_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "parentId", "type_"}, false);

		_finderPathFetchByC_P_N_T = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_P_N_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "parentId", "name", "type_"}, true);

		_finderPathCountByC_P_N_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P_N_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "parentId", "name", "type_"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDataItemEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDataItemEntryUtilPersistence(null);

		entityCache.removeCache(DataItemEntryImpl.class.getName());
	}

	private void _setDataItemEntryUtilPersistence(
		DataItemEntryPersistence dataItemEntryPersistence) {

		try {
			Field field = DataItemEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dataItemEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DG_DATAITEMSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DG_DATAITEMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DG_DATAITEMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DATAITEMENTRY =
		"SELECT dataItemEntry FROM DataItemEntry dataItemEntry";

	private static final String _SQL_SELECT_DATAITEMENTRY_WHERE =
		"SELECT dataItemEntry FROM DataItemEntry dataItemEntry WHERE ";

	private static final String _SQL_COUNT_DATAITEMENTRY =
		"SELECT COUNT(dataItemEntry) FROM DataItemEntry dataItemEntry";

	private static final String _SQL_COUNT_DATAITEMENTRY_WHERE =
		"SELECT COUNT(dataItemEntry) FROM DataItemEntry dataItemEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataItemEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataItemEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataItemEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataItemEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DataItemEntryModelArgumentsResolver
		_dataItemEntryModelArgumentsResolver;

}