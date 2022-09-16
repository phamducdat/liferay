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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileManagerEntryException;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntryTable;
import com.dogoo.common.files.manager.service.model.impl.DGFileManagerEntryImpl;
import com.dogoo.common.files.manager.service.model.impl.DGFileManagerEntryModelImpl;
import com.dogoo.common.files.manager.service.service.persistence.DGFileManagerEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileManagerEntryUtil;
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
 * The persistence implementation for the dg file manager entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {DGFileManagerEntryPersistence.class, BasePersistence.class}
)
public class DGFileManagerEntryPersistenceImpl
	extends BasePersistenceImpl<DGFileManagerEntry>
	implements DGFileManagerEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGFileManagerEntryUtil</code> to access the dg file manager entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGFileManagerEntryImpl.class.getName();

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
	 * Returns all the dg file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator,
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

		List<DGFileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileManagerEntry dgFileManagerEntry : list) {
					if (!uuid.equals(dgFileManagerEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DGFILEMANAGERENTRY_WHERE);

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
				sb.append(DGFileManagerEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileManagerEntry>)QueryUtil.list(
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
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (dgFileManagerEntry != null) {
			return dgFileManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByUuid_First(
		String uuid, OrderByComparator<DGFileManagerEntry> orderByComparator) {

		List<DGFileManagerEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dgFileManagerEntry != null) {
			return dgFileManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DGFileManagerEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DGFileManagerEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file manager entries before and after the current dg file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileManagerId the primary key of the current dg file manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public DGFileManagerEntry[] findByUuid_PrevAndNext(
			long fileManagerId, String uuid,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws NoSuchDGFileManagerEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileManagerEntry dgFileManagerEntry = findByPrimaryKey(fileManagerId);

		Session session = null;

		try {
			session = openSession();

			DGFileManagerEntry[] array = new DGFileManagerEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dgFileManagerEntry, uuid, orderByComparator, true);

			array[1] = dgFileManagerEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dgFileManagerEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileManagerEntry getByUuid_PrevAndNext(
		Session session, DGFileManagerEntry dgFileManagerEntry, String uuid,
		OrderByComparator<DGFileManagerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEMANAGERENTRY_WHERE);

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
			sb.append(DGFileManagerEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DGFileManagerEntry dgFileManagerEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgFileManagerEntry);
		}
	}

	/**
	 * Returns the number of dg file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file manager entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFILEMANAGERENTRY_WHERE);

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
		"dgFileManagerEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dgFileManagerEntry.uuid IS NULL OR dgFileManagerEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByUUID_G(uuid, groupId);

		if (dgFileManagerEntry == null) {
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

			throw new NoSuchDGFileManagerEntryException(sb.toString());
		}

		return dgFileManagerEntry;
	}

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dg file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByUUID_G(
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

		if (result instanceof DGFileManagerEntry) {
			DGFileManagerEntry dgFileManagerEntry = (DGFileManagerEntry)result;

			if (!Objects.equals(uuid, dgFileManagerEntry.getUuid()) ||
				(groupId != dgFileManagerEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEMANAGERENTRY_WHERE);

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

				List<DGFileManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DGFileManagerEntry dgFileManagerEntry = list.get(0);

					result = dgFileManagerEntry;

					cacheResult(dgFileManagerEntry);
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
			return (DGFileManagerEntry)result;
		}
	}

	/**
	 * Removes the dg file manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file manager entry that was removed
	 */
	@Override
	public DGFileManagerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = findByUUID_G(uuid, groupId);

		return remove(dgFileManagerEntry);
	}

	/**
	 * Returns the number of dg file manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file manager entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEMANAGERENTRY_WHERE);

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
		"dgFileManagerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dgFileManagerEntry.uuid IS NULL OR dgFileManagerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dgFileManagerEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator,
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

		List<DGFileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileManagerEntry dgFileManagerEntry : list) {
					if (!uuid.equals(dgFileManagerEntry.getUuid()) ||
						(companyId != dgFileManagerEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DGFILEMANAGERENTRY_WHERE);

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
				sb.append(DGFileManagerEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileManagerEntry>)QueryUtil.list(
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
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dgFileManagerEntry != null) {
			return dgFileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		List<DGFileManagerEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dgFileManagerEntry != null) {
			return dgFileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DGFileManagerEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file manager entries before and after the current dg file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileManagerId the primary key of the current dg file manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public DGFileManagerEntry[] findByUuid_C_PrevAndNext(
			long fileManagerId, String uuid, long companyId,
			OrderByComparator<DGFileManagerEntry> orderByComparator)
		throws NoSuchDGFileManagerEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileManagerEntry dgFileManagerEntry = findByPrimaryKey(fileManagerId);

		Session session = null;

		try {
			session = openSession();

			DGFileManagerEntry[] array = new DGFileManagerEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dgFileManagerEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = dgFileManagerEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dgFileManagerEntry, uuid, companyId, orderByComparator,
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

	protected DGFileManagerEntry getByUuid_C_PrevAndNext(
		Session session, DGFileManagerEntry dgFileManagerEntry, String uuid,
		long companyId, OrderByComparator<DGFileManagerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEMANAGERENTRY_WHERE);

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
			sb.append(DGFileManagerEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DGFileManagerEntry dgFileManagerEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFileManagerEntry);
		}
	}

	/**
	 * Returns the number of dg file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file manager entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEMANAGERENTRY_WHERE);

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
		"dgFileManagerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dgFileManagerEntry.uuid IS NULL OR dgFileManagerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dgFileManagerEntry.companyId = ?";

	private FinderPath _finderPathFetchByF_C;
	private FinderPath _finderPathCountByF_C;

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry findByF_C(long fileId, long customerId)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByF_C(fileId, customerId);

		if (dgFileManagerEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fileId=");
			sb.append(fileId);

			sb.append(", customerId=");
			sb.append(customerId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileManagerEntryException(sb.toString());
		}

		return dgFileManagerEntry;
	}

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByF_C(long fileId, long customerId) {
		return fetchByF_C(fileId, customerId, true);
	}

	/**
	 * Returns the dg file manager entry where fileId = &#63; and customerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByF_C(
		long fileId, long customerId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fileId, customerId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByF_C, finderArgs);
		}

		if (result instanceof DGFileManagerEntry) {
			DGFileManagerEntry dgFileManagerEntry = (DGFileManagerEntry)result;

			if ((fileId != dgFileManagerEntry.getFileId()) ||
				(customerId != dgFileManagerEntry.getCustomerId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_F_C_FILEID_2);

			sb.append(_FINDER_COLUMN_F_C_CUSTOMERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileId);

				queryPos.add(customerId);

				List<DGFileManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByF_C, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fileId, customerId};
							}

							_log.warn(
								"DGFileManagerEntryPersistenceImpl.fetchByF_C(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileManagerEntry dgFileManagerEntry = list.get(0);

					result = dgFileManagerEntry;

					cacheResult(dgFileManagerEntry);
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
			return (DGFileManagerEntry)result;
		}
	}

	/**
	 * Removes the dg file manager entry where fileId = &#63; and customerId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the dg file manager entry that was removed
	 */
	@Override
	public DGFileManagerEntry removeByF_C(long fileId, long customerId)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = findByF_C(fileId, customerId);

		return remove(dgFileManagerEntry);
	}

	/**
	 * Returns the number of dg file manager entries where fileId = &#63; and customerId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param customerId the customer ID
	 * @return the number of matching dg file manager entries
	 */
	@Override
	public int countByF_C(long fileId, long customerId) {
		FinderPath finderPath = _finderPathCountByF_C;

		Object[] finderArgs = new Object[] {fileId, customerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_F_C_FILEID_2);

			sb.append(_FINDER_COLUMN_F_C_CUSTOMERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileId);

				queryPos.add(customerId);

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

	private static final String _FINDER_COLUMN_F_C_FILEID_2 =
		"dgFileManagerEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_F_C_CUSTOMERID_2 =
		"dgFileManagerEntry.customerId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (dgFileManagerEntry == null) {
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

			throw new NoSuchDGFileManagerEntryException(sb.toString());
		}

		return dgFileManagerEntry;
	}

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByC_ERC(
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

		if (result instanceof DGFileManagerEntry) {
			DGFileManagerEntry dgFileManagerEntry = (DGFileManagerEntry)result;

			if ((companyId != dgFileManagerEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dgFileManagerEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEMANAGERENTRY_WHERE);

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

				List<DGFileManagerEntry> list = query.list();

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
								"DGFileManagerEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileManagerEntry dgFileManagerEntry = list.get(0);

					result = dgFileManagerEntry;

					cacheResult(dgFileManagerEntry);
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
			return (DGFileManagerEntry)result;
		}
	}

	/**
	 * Removes the dg file manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file manager entry that was removed
	 */
	@Override
	public DGFileManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(dgFileManagerEntry);
	}

	/**
	 * Returns the number of dg file manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file manager entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEMANAGERENTRY_WHERE);

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
		"dgFileManagerEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dgFileManagerEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dgFileManagerEntry.externalReferenceCode IS NULL OR dgFileManagerEntry.externalReferenceCode = '')";

	public DGFileManagerEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGFileManagerEntry.class);

		setModelImplClass(DGFileManagerEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DGFileManagerEntryTable.INSTANCE);
	}

	/**
	 * Caches the dg file manager entry in the entity cache if it is enabled.
	 *
	 * @param dgFileManagerEntry the dg file manager entry
	 */
	@Override
	public void cacheResult(DGFileManagerEntry dgFileManagerEntry) {
		entityCache.putResult(
			DGFileManagerEntryImpl.class, dgFileManagerEntry.getPrimaryKey(),
			dgFileManagerEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dgFileManagerEntry.getUuid(), dgFileManagerEntry.getGroupId()
			},
			dgFileManagerEntry);

		finderCache.putResult(
			_finderPathFetchByF_C,
			new Object[] {
				dgFileManagerEntry.getFileId(),
				dgFileManagerEntry.getCustomerId()
			},
			dgFileManagerEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dgFileManagerEntry.getCompanyId(),
				dgFileManagerEntry.getExternalReferenceCode()
			},
			dgFileManagerEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dg file manager entries in the entity cache if it is enabled.
	 *
	 * @param dgFileManagerEntries the dg file manager entries
	 */
	@Override
	public void cacheResult(List<DGFileManagerEntry> dgFileManagerEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgFileManagerEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGFileManagerEntry dgFileManagerEntry : dgFileManagerEntries) {
			if (entityCache.getResult(
					DGFileManagerEntryImpl.class,
					dgFileManagerEntry.getPrimaryKey()) == null) {

				cacheResult(dgFileManagerEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dg file manager entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGFileManagerEntryImpl.class);

		finderCache.clearCache(DGFileManagerEntryImpl.class);
	}

	/**
	 * Clears the cache for the dg file manager entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DGFileManagerEntry dgFileManagerEntry) {
		entityCache.removeResult(
			DGFileManagerEntryImpl.class, dgFileManagerEntry);
	}

	@Override
	public void clearCache(List<DGFileManagerEntry> dgFileManagerEntries) {
		for (DGFileManagerEntry dgFileManagerEntry : dgFileManagerEntries) {
			entityCache.removeResult(
				DGFileManagerEntryImpl.class, dgFileManagerEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGFileManagerEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DGFileManagerEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGFileManagerEntryModelImpl dgFileManagerEntryModelImpl) {

		Object[] args = new Object[] {
			dgFileManagerEntryModelImpl.getUuid(),
			dgFileManagerEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dgFileManagerEntryModelImpl);

		args = new Object[] {
			dgFileManagerEntryModelImpl.getFileId(),
			dgFileManagerEntryModelImpl.getCustomerId()
		};

		finderCache.putResult(_finderPathCountByF_C, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByF_C, args, dgFileManagerEntryModelImpl);

		args = new Object[] {
			dgFileManagerEntryModelImpl.getCompanyId(),
			dgFileManagerEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, dgFileManagerEntryModelImpl);
	}

	/**
	 * Creates a new dg file manager entry with the primary key. Does not add the dg file manager entry to the database.
	 *
	 * @param fileManagerId the primary key for the new dg file manager entry
	 * @return the new dg file manager entry
	 */
	@Override
	public DGFileManagerEntry create(long fileManagerId) {
		DGFileManagerEntry dgFileManagerEntry = new DGFileManagerEntryImpl();

		dgFileManagerEntry.setNew(true);
		dgFileManagerEntry.setPrimaryKey(fileManagerId);

		String uuid = PortalUUIDUtil.generate();

		dgFileManagerEntry.setUuid(uuid);

		dgFileManagerEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgFileManagerEntry;
	}

	/**
	 * Removes the dg file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry that was removed
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public DGFileManagerEntry remove(long fileManagerId)
		throws NoSuchDGFileManagerEntryException {

		return remove((Serializable)fileManagerId);
	}

	/**
	 * Removes the dg file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dg file manager entry
	 * @return the dg file manager entry that was removed
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public DGFileManagerEntry remove(Serializable primaryKey)
		throws NoSuchDGFileManagerEntryException {

		Session session = null;

		try {
			session = openSession();

			DGFileManagerEntry dgFileManagerEntry =
				(DGFileManagerEntry)session.get(
					DGFileManagerEntryImpl.class, primaryKey);

			if (dgFileManagerEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGFileManagerEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgFileManagerEntry);
		}
		catch (NoSuchDGFileManagerEntryException noSuchEntityException) {
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
	protected DGFileManagerEntry removeImpl(
		DGFileManagerEntry dgFileManagerEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgFileManagerEntry)) {
				dgFileManagerEntry = (DGFileManagerEntry)session.get(
					DGFileManagerEntryImpl.class,
					dgFileManagerEntry.getPrimaryKeyObj());
			}

			if (dgFileManagerEntry != null) {
				session.delete(dgFileManagerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgFileManagerEntry != null) {
			clearCache(dgFileManagerEntry);
		}

		return dgFileManagerEntry;
	}

	@Override
	public DGFileManagerEntry updateImpl(
		DGFileManagerEntry dgFileManagerEntry) {

		boolean isNew = dgFileManagerEntry.isNew();

		if (!(dgFileManagerEntry instanceof DGFileManagerEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgFileManagerEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgFileManagerEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgFileManagerEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGFileManagerEntry implementation " +
					dgFileManagerEntry.getClass());
		}

		DGFileManagerEntryModelImpl dgFileManagerEntryModelImpl =
			(DGFileManagerEntryModelImpl)dgFileManagerEntry;

		if (Validator.isNull(dgFileManagerEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dgFileManagerEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgFileManagerEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgFileManagerEntry.setCreateDate(date);
			}
			else {
				dgFileManagerEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgFileManagerEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgFileManagerEntry.setModifiedDate(date);
			}
			else {
				dgFileManagerEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgFileManagerEntry);
			}
			else {
				dgFileManagerEntry = (DGFileManagerEntry)session.merge(
					dgFileManagerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGFileManagerEntryImpl.class, dgFileManagerEntryModelImpl, false,
			true);

		cacheUniqueFindersCache(dgFileManagerEntryModelImpl);

		if (isNew) {
			dgFileManagerEntry.setNew(false);
		}

		dgFileManagerEntry.resetOriginalValues();

		return dgFileManagerEntry;
	}

	/**
	 * Returns the dg file manager entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dg file manager entry
	 * @return the dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public DGFileManagerEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry dgFileManagerEntry = fetchByPrimaryKey(primaryKey);

		if (dgFileManagerEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGFileManagerEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgFileManagerEntry;
	}

	/**
	 * Returns the dg file manager entry with the primary key or throws a <code>NoSuchDGFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry
	 * @throws NoSuchDGFileManagerEntryException if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public DGFileManagerEntry findByPrimaryKey(long fileManagerId)
		throws NoSuchDGFileManagerEntryException {

		return findByPrimaryKey((Serializable)fileManagerId);
	}

	/**
	 * Returns the dg file manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry, or <code>null</code> if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public DGFileManagerEntry fetchByPrimaryKey(long fileManagerId) {
		return fetchByPrimaryKey((Serializable)fileManagerId);
	}

	/**
	 * Returns all the dg file manager entries.
	 *
	 * @return the dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file manager entries
	 */
	@Override
	public List<DGFileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileManagerEntry> orderByComparator,
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

		List<DGFileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFILEMANAGERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFILEMANAGERENTRY;

				sql = sql.concat(DGFileManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGFileManagerEntry>)QueryUtil.list(
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
	 * Removes all the dg file manager entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGFileManagerEntry dgFileManagerEntry : findAll()) {
			remove(dgFileManagerEntry);
		}
	}

	/**
	 * Returns the number of dg file manager entries.
	 *
	 * @return the number of dg file manager entries
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
					_SQL_COUNT_DGFILEMANAGERENTRY);

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
		return "fileManagerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFILEMANAGERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGFileManagerEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dg file manager entry persistence.
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

		_finderPathFetchByF_C = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByF_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"fileId", "customerId"}, true);

		_finderPathCountByF_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByF_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"fileId", "customerId"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDGFileManagerEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGFileManagerEntryUtilPersistence(null);

		entityCache.removeCache(DGFileManagerEntryImpl.class.getName());
	}

	private void _setDGFileManagerEntryUtilPersistence(
		DGFileManagerEntryPersistence dgFileManagerEntryPersistence) {

		try {
			Field field = DGFileManagerEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgFileManagerEntryPersistence);
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

	private static final String _SQL_SELECT_DGFILEMANAGERENTRY =
		"SELECT dgFileManagerEntry FROM DGFileManagerEntry dgFileManagerEntry";

	private static final String _SQL_SELECT_DGFILEMANAGERENTRY_WHERE =
		"SELECT dgFileManagerEntry FROM DGFileManagerEntry dgFileManagerEntry WHERE ";

	private static final String _SQL_COUNT_DGFILEMANAGERENTRY =
		"SELECT COUNT(dgFileManagerEntry) FROM DGFileManagerEntry dgFileManagerEntry";

	private static final String _SQL_COUNT_DGFILEMANAGERENTRY_WHERE =
		"SELECT COUNT(dgFileManagerEntry) FROM DGFileManagerEntry dgFileManagerEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgFileManagerEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGFileManagerEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGFileManagerEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGFileManagerEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGFileManagerEntryModelArgumentsResolver
		_dgFileManagerEntryModelArgumentsResolver;

}