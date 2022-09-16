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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileUserPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntryTable;
import com.dogoo.common.files.manager.service.model.impl.DGFileUserPermissionEntryImpl;
import com.dogoo.common.files.manager.service.model.impl.DGFileUserPermissionEntryModelImpl;
import com.dogoo.common.files.manager.service.service.persistence.DGFileUserPermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileUserPermissionEntryUtil;
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
 * The persistence implementation for the dg file user permission entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {
		DGFileUserPermissionEntryPersistence.class, BasePersistence.class
	}
)
public class DGFileUserPermissionEntryPersistenceImpl
	extends BasePersistenceImpl<DGFileUserPermissionEntry>
	implements DGFileUserPermissionEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGFileUserPermissionEntryUtil</code> to access the dg file user permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGFileUserPermissionEntryImpl.class.getName();

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
	 * Returns all the dg file user permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
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

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if (!uuid.equals(dgFileUserPermissionEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByUuid_PrevAndNext(
			long fileUserPermissionId, String uuid,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dgFileUserPermissionEntry, uuid, orderByComparator,
				true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dgFileUserPermissionEntry, uuid, orderByComparator,
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

	protected DGFileUserPermissionEntry getByUuid_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		String uuid,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
		"dgFileUserPermissionEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dgFileUserPermissionEntry.uuid IS NULL OR dgFileUserPermissionEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByUUID_G(
			uuid, groupId);

		if (dgFileUserPermissionEntry == null) {
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

			throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
		}

		return dgFileUserPermissionEntry;
	}

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dg file user permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByUUID_G(
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

		if (result instanceof DGFileUserPermissionEntry) {
			DGFileUserPermissionEntry dgFileUserPermissionEntry =
				(DGFileUserPermissionEntry)result;

			if (!Objects.equals(uuid, dgFileUserPermissionEntry.getUuid()) ||
				(groupId != dgFileUserPermissionEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

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

				List<DGFileUserPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DGFileUserPermissionEntry dgFileUserPermissionEntry =
						list.get(0);

					result = dgFileUserPermissionEntry;

					cacheResult(dgFileUserPermissionEntry);
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
			return (DGFileUserPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file user permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file user permission entry that was removed
	 */
	@Override
	public DGFileUserPermissionEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByUUID_G(
			uuid, groupId);

		return remove(dgFileUserPermissionEntry);
	}

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
		"dgFileUserPermissionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dgFileUserPermissionEntry.uuid IS NULL OR dgFileUserPermissionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dgFileUserPermissionEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
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

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if (!uuid.equals(dgFileUserPermissionEntry.getUuid()) ||
						(companyId !=
							dgFileUserPermissionEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileUserPermissionId, String uuid, long companyId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dgFileUserPermissionEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dgFileUserPermissionEntry, uuid, companyId,
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

	protected DGFileUserPermissionEntry getByUuid_C_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		String uuid, long companyId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
		"dgFileUserPermissionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dgFileUserPermissionEntry.uuid IS NULL OR dgFileUserPermissionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dgFileUserPermissionEntry.companyId = ?";

	private FinderPath _finderPathFetchByC_U_F;
	private FinderPath _finderPathCountByC_U_F;

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_F(
			long customerId, long userAllowedId, long fileId)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_U_F(
			customerId, userAllowedId, fileId);

		if (dgFileUserPermissionEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", userAllowedId=");
			sb.append(userAllowedId);

			sb.append(", fileId=");
			sb.append(fileId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
		}

		return dgFileUserPermissionEntry;
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_F(
		long customerId, long userAllowedId, long fileId) {

		return fetchByC_U_F(customerId, userAllowedId, fileId, true);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_F(
		long customerId, long userAllowedId, long fileId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, userAllowedId, fileId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_U_F, finderArgs);
		}

		if (result instanceof DGFileUserPermissionEntry) {
			DGFileUserPermissionEntry dgFileUserPermissionEntry =
				(DGFileUserPermissionEntry)result;

			if ((customerId != dgFileUserPermissionEntry.getCustomerId()) ||
				(userAllowedId !=
					dgFileUserPermissionEntry.getUserAllowedId()) ||
				(fileId != dgFileUserPermissionEntry.getFileId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_F_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_F_USERALLOWEDID_2);

			sb.append(_FINDER_COLUMN_C_U_F_FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				queryPos.add(fileId);

				List<DGFileUserPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_U_F, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, userAllowedId, fileId
								};
							}

							_log.warn(
								"DGFileUserPermissionEntryPersistenceImpl.fetchByC_U_F(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileUserPermissionEntry dgFileUserPermissionEntry =
						list.get(0);

					result = dgFileUserPermissionEntry;

					cacheResult(dgFileUserPermissionEntry);
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
			return (DGFileUserPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the dg file user permission entry that was removed
	 */
	@Override
	public DGFileUserPermissionEntry removeByC_U_F(
			long customerId, long userAllowedId, long fileId)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByC_U_F(
			customerId, userAllowedId, fileId);

		return remove(dgFileUserPermissionEntry);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_U_F(long customerId, long userAllowedId, long fileId) {
		FinderPath finderPath = _finderPathCountByC_U_F;

		Object[] finderArgs = new Object[] {customerId, userAllowedId, fileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_F_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_F_USERALLOWEDID_2);

			sb.append(_FINDER_COLUMN_C_U_F_FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				queryPos.add(fileId);

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

	private static final String _FINDER_COLUMN_C_U_F_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_F_USERALLOWEDID_2 =
		"dgFileUserPermissionEntry.userAllowedId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_F_FILEID_2 =
		"dgFileUserPermissionEntry.fileId = ?";

	private FinderPath _finderPathWithPaginationFindByC_U;
	private FinderPath _finderPathWithoutPaginationFindByC_U;
	private FinderPath _finderPathCountByC_U;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId) {

		return findByC_U(
			customerId, userAllowedId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end) {

		return findByC_U(customerId, userAllowedId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_U(
			customerId, userAllowedId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U(
		long customerId, long userAllowedId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U;
				finderArgs = new Object[] {customerId, userAllowedId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U;
			finderArgs = new Object[] {
				customerId, userAllowedId, start, end, orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(userAllowedId !=
							dgFileUserPermissionEntry.getUserAllowedId())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_USERALLOWEDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_First(
			long customerId, long userAllowedId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_U_First(
			customerId, userAllowedId, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_First(
		long customerId, long userAllowedId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_U(
			customerId, userAllowedId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_Last(
			long customerId, long userAllowedId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_U_Last(
			customerId, userAllowedId, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_Last(
		long customerId, long userAllowedId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_U(customerId, userAllowedId);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_U(
			customerId, userAllowedId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_U_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_U_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
				orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_U_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
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

	protected DGFileUserPermissionEntry getByC_U_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long userAllowedId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_U_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_U_USERALLOWEDID_2);

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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(userAllowedId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 */
	@Override
	public void removeByC_U(long customerId, long userAllowedId) {
		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_U(
					customerId, userAllowedId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_U(long customerId, long userAllowedId) {
		FinderPath finderPath = _finderPathCountByC_U;

		Object[] finderArgs = new Object[] {customerId, userAllowedId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_USERALLOWEDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

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

	private static final String _FINDER_COLUMN_C_U_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_USERALLOWEDID_2 =
		"dgFileUserPermissionEntry.userAllowedId = ?";

	private FinderPath _finderPathWithPaginationFindByC_U_S;
	private FinderPath _finderPathWithoutPaginationFindByC_U_S;
	private FinderPath _finderPathCountByC_U_S;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status) {

		return findByC_U_S(
			customerId, userAllowedId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start,
		int end) {

		return findByC_U_S(customerId, userAllowedId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_U_S(
			customerId, userAllowedId, status, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S(
		long customerId, long userAllowedId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U_S;
				finderArgs = new Object[] {customerId, userAllowedId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U_S;
			finderArgs = new Object[] {
				customerId, userAllowedId, status, start, end, orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(userAllowedId !=
							dgFileUserPermissionEntry.getUserAllowedId()) ||
						!status.equals(dgFileUserPermissionEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERALLOWEDID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_S_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_S_First(
			long customerId, long userAllowedId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_U_S_First(
				customerId, userAllowedId, status, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_S_First(
		long customerId, long userAllowedId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_U_S(
			customerId, userAllowedId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_S_Last(
			long customerId, long userAllowedId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_U_S_Last(
			customerId, userAllowedId, status, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_S_Last(
		long customerId, long userAllowedId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_U_S(customerId, userAllowedId, status);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_U_S(
			customerId, userAllowedId, status, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_U_S_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		status = Objects.toString(status, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_U_S_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
				status, orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_U_S_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
				status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileUserPermissionEntry getByC_U_S_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long userAllowedId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_U_S_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_U_S_USERALLOWEDID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_U_S_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);
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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(userAllowedId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 */
	@Override
	public void removeByC_U_S(
		long customerId, long userAllowedId, String status) {

		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_U_S(
					customerId, userAllowedId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_U_S(
		long customerId, long userAllowedId, String status) {

		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByC_U_S;

		Object[] finderArgs = new Object[] {customerId, userAllowedId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERALLOWEDID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_S_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_C_U_S_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_USERALLOWEDID_2 =
		"dgFileUserPermissionEntry.userAllowedId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_2 =
		"dgFileUserPermissionEntry.status = ?";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_3 =
		"(dgFileUserPermissionEntry.status IS NULL OR dgFileUserPermissionEntry.status = '')";

	private FinderPath _finderPathWithPaginationFindByC_F;
	private FinderPath _finderPathWithoutPaginationFindByC_F;
	private FinderPath _finderPathCountByC_F;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId) {

		return findByC_F(
			customerId, fileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end) {

		return findByC_F(customerId, fileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_F(
			customerId, fileId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_F;
				finderArgs = new Object[] {customerId, fileId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_F;
			finderArgs = new Object[] {
				customerId, fileId, start, end, orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(fileId != dgFileUserPermissionEntry.getFileId())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_FILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_First(
			long customerId, long fileId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_F_First(
			customerId, fileId, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_First(
		long customerId, long fileId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_F(
			customerId, fileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_Last(
			long customerId, long fileId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_F_Last(
			customerId, fileId, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_Last(
		long customerId, long fileId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_F(customerId, fileId);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_F(
			customerId, fileId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_F_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_F_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId,
				orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_F_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId,
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

	protected DGFileUserPermissionEntry getByC_F_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long fileId,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_F_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_F_FILEID_2);

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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(fileId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 */
	@Override
	public void removeByC_F(long customerId, long fileId) {
		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_F(
					customerId, fileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_F(long customerId, long fileId) {
		FinderPath finderPath = _finderPathCountByC_F;

		Object[] finderArgs = new Object[] {customerId, fileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

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

	private static final String _FINDER_COLUMN_C_F_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_FILEID_2 =
		"dgFileUserPermissionEntry.fileId = ?";

	private FinderPath _finderPathWithPaginationFindByC_F_S;
	private FinderPath _finderPathWithoutPaginationFindByC_F_S;
	private FinderPath _finderPathCountByC_F_S;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status) {

		return findByC_F_S(
			customerId, fileId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end) {

		return findByC_F_S(customerId, fileId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_F_S(
			customerId, fileId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S(
		long customerId, long fileId, String status, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_F_S;
				finderArgs = new Object[] {customerId, fileId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_F_S;
			finderArgs = new Object[] {
				customerId, fileId, status, start, end, orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(fileId != dgFileUserPermissionEntry.getFileId()) ||
						!status.equals(dgFileUserPermissionEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_S_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_S_FILEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_S_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_F_S_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_S_First(
			long customerId, long fileId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_F_S_First(customerId, fileId, status, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_S_First(
		long customerId, long fileId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_F_S(
			customerId, fileId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_S_Last(
			long customerId, long fileId, String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_F_S_Last(
			customerId, fileId, status, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_S_Last(
		long customerId, long fileId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_F_S(customerId, fileId, status);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_F_S(
			customerId, fileId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_F_S_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String status,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		status = Objects.toString(status, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_F_S_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId, status,
				orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_F_S_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId, status,
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

	protected DGFileUserPermissionEntry getByC_F_S_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long fileId, String status,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_F_S_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_F_S_FILEID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_F_S_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_C_F_S_STATUS_2);
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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(fileId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 */
	@Override
	public void removeByC_F_S(long customerId, long fileId, String status) {
		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_F_S(
					customerId, fileId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_F_S(long customerId, long fileId, String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByC_F_S;

		Object[] finderArgs = new Object[] {customerId, fileId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_S_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_S_FILEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_S_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_F_S_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_C_F_S_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_S_FILEID_2 =
		"dgFileUserPermissionEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_S_STATUS_2 =
		"dgFileUserPermissionEntry.status = ?";

	private static final String _FINDER_COLUMN_C_F_S_STATUS_3 =
		"(dgFileUserPermissionEntry.status IS NULL OR dgFileUserPermissionEntry.status = '')";

	private FinderPath _finderPathFetchByC_U_F_T;
	private FinderPath _finderPathCountByC_U_F_T;

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_F_T(
			long customerId, long userAllowedId, long fileId, String type)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_U_F_T(
			customerId, userAllowedId, fileId, type);

		if (dgFileUserPermissionEntry == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", userAllowedId=");
			sb.append(userAllowedId);

			sb.append(", fileId=");
			sb.append(fileId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
		}

		return dgFileUserPermissionEntry;
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type) {

		return fetchByC_U_F_T(customerId, userAllowedId, fileId, type, true);
	}

	/**
	 * Returns the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, userAllowedId, fileId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_U_F_T, finderArgs);
		}

		if (result instanceof DGFileUserPermissionEntry) {
			DGFileUserPermissionEntry dgFileUserPermissionEntry =
				(DGFileUserPermissionEntry)result;

			if ((customerId != dgFileUserPermissionEntry.getCustomerId()) ||
				(userAllowedId !=
					dgFileUserPermissionEntry.getUserAllowedId()) ||
				(fileId != dgFileUserPermissionEntry.getFileId()) ||
				!Objects.equals(type, dgFileUserPermissionEntry.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_F_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_F_T_USERALLOWEDID_2);

			sb.append(_FINDER_COLUMN_C_U_F_T_FILEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_F_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_U_F_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				queryPos.add(fileId);

				if (bindType) {
					queryPos.add(type);
				}

				List<DGFileUserPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_U_F_T, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, userAllowedId, fileId, type
								};
							}

							_log.warn(
								"DGFileUserPermissionEntryPersistenceImpl.fetchByC_U_F_T(long, long, long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileUserPermissionEntry dgFileUserPermissionEntry =
						list.get(0);

					result = dgFileUserPermissionEntry;

					cacheResult(dgFileUserPermissionEntry);
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
			return (DGFileUserPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file user permission entry where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file user permission entry that was removed
	 */
	@Override
	public DGFileUserPermissionEntry removeByC_U_F_T(
			long customerId, long userAllowedId, long fileId, String type)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByC_U_F_T(
			customerId, userAllowedId, fileId, type);

		return remove(dgFileUserPermissionEntry);
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_U_F_T(
		long customerId, long userAllowedId, long fileId, String type) {

		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_U_F_T;

		Object[] finderArgs = new Object[] {
			customerId, userAllowedId, fileId, type
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_F_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_F_T_USERALLOWEDID_2);

			sb.append(_FINDER_COLUMN_C_U_F_T_FILEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_F_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_U_F_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				queryPos.add(fileId);

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

	private static final String _FINDER_COLUMN_C_U_F_T_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_F_T_USERALLOWEDID_2 =
		"dgFileUserPermissionEntry.userAllowedId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_F_T_FILEID_2 =
		"dgFileUserPermissionEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_F_T_TYPE_2 =
		"dgFileUserPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_U_F_T_TYPE_3 =
		"(dgFileUserPermissionEntry.type IS NULL OR dgFileUserPermissionEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByC_U_T;
	private FinderPath _finderPathWithoutPaginationFindByC_U_T;
	private FinderPath _finderPathCountByC_U_T;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type) {

		return findByC_U_T(
			customerId, userAllowedId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end) {

		return findByC_U_T(customerId, userAllowedId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_U_T(
			customerId, userAllowedId, type, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_T(
		long customerId, long userAllowedId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U_T;
				finderArgs = new Object[] {customerId, userAllowedId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U_T;
			finderArgs = new Object[] {
				customerId, userAllowedId, type, start, end, orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(userAllowedId !=
							dgFileUserPermissionEntry.getUserAllowedId()) ||
						!type.equals(dgFileUserPermissionEntry.getType())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_T_USERALLOWEDID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_U_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_T_First(
			long customerId, long userAllowedId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_U_T_First(
				customerId, userAllowedId, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_T_First(
		long customerId, long userAllowedId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_U_T(
			customerId, userAllowedId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_T_Last(
			long customerId, long userAllowedId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_U_T_Last(
			customerId, userAllowedId, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_T_Last(
		long customerId, long userAllowedId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_U_T(customerId, userAllowedId, type);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_U_T(
			customerId, userAllowedId, type, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_U_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		type = Objects.toString(type, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_U_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
				type, orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_U_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
				type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileUserPermissionEntry getByC_U_T_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long userAllowedId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_U_T_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_U_T_USERALLOWEDID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_U_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_C_U_T_TYPE_2);
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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(userAllowedId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 */
	@Override
	public void removeByC_U_T(
		long customerId, long userAllowedId, String type) {

		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_U_T(
					customerId, userAllowedId, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_U_T(long customerId, long userAllowedId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_U_T;

		Object[] finderArgs = new Object[] {customerId, userAllowedId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_T_USERALLOWEDID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_U_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

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

	private static final String _FINDER_COLUMN_C_U_T_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_T_USERALLOWEDID_2 =
		"dgFileUserPermissionEntry.userAllowedId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_T_TYPE_2 =
		"dgFileUserPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_U_T_TYPE_3 =
		"(dgFileUserPermissionEntry.type IS NULL OR dgFileUserPermissionEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByC_U_S_T;
	private FinderPath _finderPathWithoutPaginationFindByC_U_S_T;
	private FinderPath _finderPathCountByC_U_S_T;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type) {

		return findByC_U_S_T(
			customerId, userAllowedId, status, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end) {

		return findByC_U_S_T(
			customerId, userAllowedId, status, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_U_S_T(
			customerId, userAllowedId, status, type, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_U_S_T(
		long customerId, long userAllowedId, String status, String type,
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U_S_T;
				finderArgs = new Object[] {
					customerId, userAllowedId, status, type
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U_S_T;
			finderArgs = new Object[] {
				customerId, userAllowedId, status, type, start, end,
				orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(userAllowedId !=
							dgFileUserPermissionEntry.getUserAllowedId()) ||
						!status.equals(dgFileUserPermissionEntry.getStatus()) ||
						!type.equals(dgFileUserPermissionEntry.getType())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_T_USERALLOWEDID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_S_T_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_U_S_T_STATUS_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_S_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_U_S_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				if (bindStatus) {
					queryPos.add(status);
				}

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_S_T_First(
			long customerId, long userAllowedId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_U_S_T_First(
				customerId, userAllowedId, status, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_S_T_First(
		long customerId, long userAllowedId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_U_S_T(
			customerId, userAllowedId, status, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_U_S_T_Last(
			long customerId, long userAllowedId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_U_S_T_Last(
				customerId, userAllowedId, status, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", userAllowedId=");
		sb.append(userAllowedId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_U_S_T_Last(
		long customerId, long userAllowedId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_U_S_T(customerId, userAllowedId, status, type);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_U_S_T(
			customerId, userAllowedId, status, type, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_U_S_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long userAllowedId,
			String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		status = Objects.toString(status, "");
		type = Objects.toString(type, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_U_S_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
				status, type, orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_U_S_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, userAllowedId,
				status, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileUserPermissionEntry getByC_U_S_T_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long userAllowedId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_U_S_T_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_U_S_T_USERALLOWEDID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_U_S_T_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_C_U_S_T_STATUS_2);
		}

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_U_S_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_C_U_S_T_TYPE_2);
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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(userAllowedId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 */
	@Override
	public void removeByC_U_S_T(
		long customerId, long userAllowedId, String status, String type) {

		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_U_S_T(
					customerId, userAllowedId, status, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and userAllowedId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param userAllowedId the user allowed ID
	 * @param status the status
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_U_S_T(
		long customerId, long userAllowedId, String status, String type) {

		status = Objects.toString(status, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_U_S_T;

		Object[] finderArgs = new Object[] {
			customerId, userAllowedId, status, type
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_T_USERALLOWEDID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_S_T_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_U_S_T_STATUS_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_U_S_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_U_S_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(userAllowedId);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_C_U_S_T_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_T_USERALLOWEDID_2 =
		"dgFileUserPermissionEntry.userAllowedId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_T_STATUS_2 =
		"dgFileUserPermissionEntry.status = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_T_STATUS_3 =
		"(dgFileUserPermissionEntry.status IS NULL OR dgFileUserPermissionEntry.status = '') AND ";

	private static final String _FINDER_COLUMN_C_U_S_T_TYPE_2 =
		"dgFileUserPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_U_S_T_TYPE_3 =
		"(dgFileUserPermissionEntry.type IS NULL OR dgFileUserPermissionEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByC_F_T;
	private FinderPath _finderPathWithoutPaginationFindByC_F_T;
	private FinderPath _finderPathCountByC_F_T;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type) {

		return findByC_F_T(
			customerId, fileId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end) {

		return findByC_F_T(customerId, fileId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_F_T(
			customerId, fileId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_F_T;
				finderArgs = new Object[] {customerId, fileId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_F_T;
			finderArgs = new Object[] {
				customerId, fileId, type, start, end, orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(fileId != dgFileUserPermissionEntry.getFileId()) ||
						!type.equals(dgFileUserPermissionEntry.getType())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_T_FILEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_F_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_T_First(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_F_T_First(customerId, fileId, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_T_First(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_F_T(
			customerId, fileId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_T_Last(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_F_T_Last(
			customerId, fileId, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_T_Last(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_F_T(customerId, fileId, type);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_F_T(
			customerId, fileId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_F_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		type = Objects.toString(type, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_F_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId, type,
				orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_F_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId, type,
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

	protected DGFileUserPermissionEntry getByC_F_T_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long fileId, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_F_T_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_F_T_FILEID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_F_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_C_F_T_TYPE_2);
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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(fileId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 */
	@Override
	public void removeByC_F_T(long customerId, long fileId, String type) {
		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_F_T(
					customerId, fileId, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_F_T(long customerId, long fileId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_F_T;

		Object[] finderArgs = new Object[] {customerId, fileId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_T_FILEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_F_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

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

	private static final String _FINDER_COLUMN_C_F_T_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_T_FILEID_2 =
		"dgFileUserPermissionEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_T_TYPE_2 =
		"dgFileUserPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_F_T_TYPE_3 =
		"(dgFileUserPermissionEntry.type IS NULL OR dgFileUserPermissionEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByC_F_S_T;
	private FinderPath _finderPathWithoutPaginationFindByC_F_S_T;
	private FinderPath _finderPathCountByC_F_S_T;

	/**
	 * Returns all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @return the matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type) {

		return findByC_F_S_T(
			customerId, fileId, status, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end) {

		return findByC_F_S_T(
			customerId, fileId, status, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findByC_F_S_T(
			customerId, fileId, status, type, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findByC_F_S_T(
		long customerId, long fileId, String status, String type, int start,
		int end, OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_F_S_T;
				finderArgs = new Object[] {customerId, fileId, status, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_F_S_T;
			finderArgs = new Object[] {
				customerId, fileId, status, type, start, end, orderByComparator
			};
		}

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
						list) {

					if ((customerId !=
							dgFileUserPermissionEntry.getCustomerId()) ||
						(fileId != dgFileUserPermissionEntry.getFileId()) ||
						!status.equals(dgFileUserPermissionEntry.getStatus()) ||
						!type.equals(dgFileUserPermissionEntry.getType())) {

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

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_S_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_S_T_FILEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_S_T_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_F_S_T_STATUS_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_S_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_F_S_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

				if (bindStatus) {
					queryPos.add(status);
				}

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_S_T_First(
			long customerId, long fileId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_F_S_T_First(
				customerId, fileId, status, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_S_T_First(
		long customerId, long fileId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		List<DGFileUserPermissionEntry> list = findByC_F_S_T(
			customerId, fileId, status, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_F_S_T_Last(
			long customerId, long fileId, String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			fetchByC_F_S_T_Last(
				customerId, fileId, status, type, orderByComparator);

		if (dgFileUserPermissionEntry != null) {
			return dgFileUserPermissionEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_F_S_T_Last(
		long customerId, long fileId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		int count = countByC_F_S_T(customerId, fileId, status, type);

		if (count == 0) {
			return null;
		}

		List<DGFileUserPermissionEntry> list = findByC_F_S_T(
			customerId, fileId, status, type, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file user permission entries before and after the current dg file user permission entry in the ordered set where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param fileUserPermissionId the primary key of the current dg file user permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry[] findByC_F_S_T_PrevAndNext(
			long fileUserPermissionId, long customerId, long fileId,
			String status, String type,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator)
		throws NoSuchDGFileUserPermissionEntryException {

		status = Objects.toString(status, "");
		type = Objects.toString(type, "");

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByPrimaryKey(
			fileUserPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry[] array =
				new DGFileUserPermissionEntryImpl[3];

			array[0] = getByC_F_S_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId, status,
				type, orderByComparator, true);

			array[1] = dgFileUserPermissionEntry;

			array[2] = getByC_F_S_T_PrevAndNext(
				session, dgFileUserPermissionEntry, customerId, fileId, status,
				type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileUserPermissionEntry getByC_F_S_T_PrevAndNext(
		Session session, DGFileUserPermissionEntry dgFileUserPermissionEntry,
		long customerId, long fileId, String status, String type,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_F_S_T_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_F_S_T_FILEID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_F_S_T_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_C_F_S_T_STATUS_2);
		}

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_F_S_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_C_F_S_T_TYPE_2);
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
			sb.append(DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(fileId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileUserPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileUserPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 */
	@Override
	public void removeByC_F_S_T(
		long customerId, long fileId, String status, String type) {

		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				findByC_F_S_T(
					customerId, fileId, status, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries where customerId = &#63; and fileId = &#63; and status = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param status the status
	 * @param type the type
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_F_S_T(
		long customerId, long fileId, String status, String type) {

		status = Objects.toString(status, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_F_S_T;

		Object[] finderArgs = new Object[] {customerId, fileId, status, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_S_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_S_T_FILEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_S_T_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_C_F_S_T_STATUS_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_F_S_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_F_S_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_C_F_S_T_CUSTOMERID_2 =
		"dgFileUserPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_S_T_FILEID_2 =
		"dgFileUserPermissionEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_S_T_STATUS_2 =
		"dgFileUserPermissionEntry.status = ? AND ";

	private static final String _FINDER_COLUMN_C_F_S_T_STATUS_3 =
		"(dgFileUserPermissionEntry.status IS NULL OR dgFileUserPermissionEntry.status = '') AND ";

	private static final String _FINDER_COLUMN_C_F_S_T_TYPE_2 =
		"dgFileUserPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_F_S_T_TYPE_3 =
		"(dgFileUserPermissionEntry.type IS NULL OR dgFileUserPermissionEntry.type = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (dgFileUserPermissionEntry == null) {
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

			throw new NoSuchDGFileUserPermissionEntryException(sb.toString());
		}

		return dgFileUserPermissionEntry;
	}

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByC_ERC(
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

		if (result instanceof DGFileUserPermissionEntry) {
			DGFileUserPermissionEntry dgFileUserPermissionEntry =
				(DGFileUserPermissionEntry)result;

			if ((companyId != dgFileUserPermissionEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dgFileUserPermissionEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE);

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

				List<DGFileUserPermissionEntry> list = query.list();

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
								"DGFileUserPermissionEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileUserPermissionEntry dgFileUserPermissionEntry =
						list.get(0);

					result = dgFileUserPermissionEntry;

					cacheResult(dgFileUserPermissionEntry);
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
			return (DGFileUserPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file user permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file user permission entry that was removed
	 */
	@Override
	public DGFileUserPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(dgFileUserPermissionEntry);
	}

	/**
	 * Returns the number of dg file user permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file user permission entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE);

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
		"dgFileUserPermissionEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dgFileUserPermissionEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dgFileUserPermissionEntry.externalReferenceCode IS NULL OR dgFileUserPermissionEntry.externalReferenceCode = '')";

	public DGFileUserPermissionEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("role", "role_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGFileUserPermissionEntry.class);

		setModelImplClass(DGFileUserPermissionEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DGFileUserPermissionEntryTable.INSTANCE);
	}

	/**
	 * Caches the dg file user permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileUserPermissionEntry the dg file user permission entry
	 */
	@Override
	public void cacheResult(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		entityCache.putResult(
			DGFileUserPermissionEntryImpl.class,
			dgFileUserPermissionEntry.getPrimaryKey(),
			dgFileUserPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dgFileUserPermissionEntry.getUuid(),
				dgFileUserPermissionEntry.getGroupId()
			},
			dgFileUserPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_U_F,
			new Object[] {
				dgFileUserPermissionEntry.getCustomerId(),
				dgFileUserPermissionEntry.getUserAllowedId(),
				dgFileUserPermissionEntry.getFileId()
			},
			dgFileUserPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_U_F_T,
			new Object[] {
				dgFileUserPermissionEntry.getCustomerId(),
				dgFileUserPermissionEntry.getUserAllowedId(),
				dgFileUserPermissionEntry.getFileId(),
				dgFileUserPermissionEntry.getType()
			},
			dgFileUserPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dgFileUserPermissionEntry.getCompanyId(),
				dgFileUserPermissionEntry.getExternalReferenceCode()
			},
			dgFileUserPermissionEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dg file user permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileUserPermissionEntries the dg file user permission entries
	 */
	@Override
	public void cacheResult(
		List<DGFileUserPermissionEntry> dgFileUserPermissionEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgFileUserPermissionEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				dgFileUserPermissionEntries) {

			if (entityCache.getResult(
					DGFileUserPermissionEntryImpl.class,
					dgFileUserPermissionEntry.getPrimaryKey()) == null) {

				cacheResult(dgFileUserPermissionEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dg file user permission entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGFileUserPermissionEntryImpl.class);

		finderCache.clearCache(DGFileUserPermissionEntryImpl.class);
	}

	/**
	 * Clears the cache for the dg file user permission entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		entityCache.removeResult(
			DGFileUserPermissionEntryImpl.class, dgFileUserPermissionEntry);
	}

	@Override
	public void clearCache(
		List<DGFileUserPermissionEntry> dgFileUserPermissionEntries) {

		for (DGFileUserPermissionEntry dgFileUserPermissionEntry :
				dgFileUserPermissionEntries) {

			entityCache.removeResult(
				DGFileUserPermissionEntryImpl.class, dgFileUserPermissionEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGFileUserPermissionEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DGFileUserPermissionEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGFileUserPermissionEntryModelImpl dgFileUserPermissionEntryModelImpl) {

		Object[] args = new Object[] {
			dgFileUserPermissionEntryModelImpl.getUuid(),
			dgFileUserPermissionEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dgFileUserPermissionEntryModelImpl);

		args = new Object[] {
			dgFileUserPermissionEntryModelImpl.getCustomerId(),
			dgFileUserPermissionEntryModelImpl.getUserAllowedId(),
			dgFileUserPermissionEntryModelImpl.getFileId()
		};

		finderCache.putResult(_finderPathCountByC_U_F, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_U_F, args, dgFileUserPermissionEntryModelImpl);

		args = new Object[] {
			dgFileUserPermissionEntryModelImpl.getCustomerId(),
			dgFileUserPermissionEntryModelImpl.getUserAllowedId(),
			dgFileUserPermissionEntryModelImpl.getFileId(),
			dgFileUserPermissionEntryModelImpl.getType()
		};

		finderCache.putResult(_finderPathCountByC_U_F_T, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_U_F_T, args,
			dgFileUserPermissionEntryModelImpl);

		args = new Object[] {
			dgFileUserPermissionEntryModelImpl.getCompanyId(),
			dgFileUserPermissionEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, dgFileUserPermissionEntryModelImpl);
	}

	/**
	 * Creates a new dg file user permission entry with the primary key. Does not add the dg file user permission entry to the database.
	 *
	 * @param fileUserPermissionId the primary key for the new dg file user permission entry
	 * @return the new dg file user permission entry
	 */
	@Override
	public DGFileUserPermissionEntry create(long fileUserPermissionId) {
		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			new DGFileUserPermissionEntryImpl();

		dgFileUserPermissionEntry.setNew(true);
		dgFileUserPermissionEntry.setPrimaryKey(fileUserPermissionId);

		String uuid = PortalUUIDUtil.generate();

		dgFileUserPermissionEntry.setUuid(uuid);

		dgFileUserPermissionEntry.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return dgFileUserPermissionEntry;
	}

	/**
	 * Removes the dg file user permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry that was removed
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry remove(long fileUserPermissionId)
		throws NoSuchDGFileUserPermissionEntryException {

		return remove((Serializable)fileUserPermissionId);
	}

	/**
	 * Removes the dg file user permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dg file user permission entry
	 * @return the dg file user permission entry that was removed
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry remove(Serializable primaryKey)
		throws NoSuchDGFileUserPermissionEntryException {

		Session session = null;

		try {
			session = openSession();

			DGFileUserPermissionEntry dgFileUserPermissionEntry =
				(DGFileUserPermissionEntry)session.get(
					DGFileUserPermissionEntryImpl.class, primaryKey);

			if (dgFileUserPermissionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGFileUserPermissionEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgFileUserPermissionEntry);
		}
		catch (NoSuchDGFileUserPermissionEntryException noSuchEntityException) {
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
	protected DGFileUserPermissionEntry removeImpl(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgFileUserPermissionEntry)) {
				dgFileUserPermissionEntry =
					(DGFileUserPermissionEntry)session.get(
						DGFileUserPermissionEntryImpl.class,
						dgFileUserPermissionEntry.getPrimaryKeyObj());
			}

			if (dgFileUserPermissionEntry != null) {
				session.delete(dgFileUserPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgFileUserPermissionEntry != null) {
			clearCache(dgFileUserPermissionEntry);
		}

		return dgFileUserPermissionEntry;
	}

	@Override
	public DGFileUserPermissionEntry updateImpl(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		boolean isNew = dgFileUserPermissionEntry.isNew();

		if (!(dgFileUserPermissionEntry instanceof
				DGFileUserPermissionEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgFileUserPermissionEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgFileUserPermissionEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgFileUserPermissionEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGFileUserPermissionEntry implementation " +
					dgFileUserPermissionEntry.getClass());
		}

		DGFileUserPermissionEntryModelImpl dgFileUserPermissionEntryModelImpl =
			(DGFileUserPermissionEntryModelImpl)dgFileUserPermissionEntry;

		if (Validator.isNull(dgFileUserPermissionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dgFileUserPermissionEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgFileUserPermissionEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgFileUserPermissionEntry.setCreateDate(date);
			}
			else {
				dgFileUserPermissionEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgFileUserPermissionEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgFileUserPermissionEntry.setModifiedDate(date);
			}
			else {
				dgFileUserPermissionEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgFileUserPermissionEntry);
			}
			else {
				dgFileUserPermissionEntry =
					(DGFileUserPermissionEntry)session.merge(
						dgFileUserPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGFileUserPermissionEntryImpl.class,
			dgFileUserPermissionEntryModelImpl, false, true);

		cacheUniqueFindersCache(dgFileUserPermissionEntryModelImpl);

		if (isNew) {
			dgFileUserPermissionEntry.setNew(false);
		}

		dgFileUserPermissionEntry.resetOriginalValues();

		return dgFileUserPermissionEntry;
	}

	/**
	 * Returns the dg file user permission entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dg file user permission entry
	 * @return the dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDGFileUserPermissionEntryException {

		DGFileUserPermissionEntry dgFileUserPermissionEntry = fetchByPrimaryKey(
			primaryKey);

		if (dgFileUserPermissionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGFileUserPermissionEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgFileUserPermissionEntry;
	}

	/**
	 * Returns the dg file user permission entry with the primary key or throws a <code>NoSuchDGFileUserPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry
	 * @throws NoSuchDGFileUserPermissionEntryException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry findByPrimaryKey(long fileUserPermissionId)
		throws NoSuchDGFileUserPermissionEntryException {

		return findByPrimaryKey((Serializable)fileUserPermissionId);
	}

	/**
	 * Returns the dg file user permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry, or <code>null</code> if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public DGFileUserPermissionEntry fetchByPrimaryKey(
		long fileUserPermissionId) {

		return fetchByPrimaryKey((Serializable)fileUserPermissionId);
	}

	/**
	 * Returns all the dg file user permission entries.
	 *
	 * @return the dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file user permission entries
	 */
	@Override
	public List<DGFileUserPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileUserPermissionEntry> orderByComparator,
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

		List<DGFileUserPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileUserPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFILEUSERPERMISSIONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFILEUSERPERMISSIONENTRY;

				sql = sql.concat(
					DGFileUserPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGFileUserPermissionEntry>)QueryUtil.list(
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
	 * Removes all the dg file user permission entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGFileUserPermissionEntry dgFileUserPermissionEntry : findAll()) {
			remove(dgFileUserPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file user permission entries.
	 *
	 * @return the number of dg file user permission entries
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
					_SQL_COUNT_DGFILEUSERPERMISSIONENTRY);

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
		return "fileUserPermissionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFILEUSERPERMISSIONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGFileUserPermissionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dg file user permission entry persistence.
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

		_finderPathFetchByC_U_F = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_U_F",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "fileId"}, true);

		_finderPathCountByC_U_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_F",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "fileId"}, false);

		_finderPathWithPaginationFindByC_U = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "userAllowedId"}, true);

		_finderPathWithoutPaginationFindByC_U = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "userAllowedId"}, true);

		_finderPathCountByC_U = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "userAllowedId"}, false);

		_finderPathWithPaginationFindByC_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "status"}, true);

		_finderPathWithoutPaginationFindByC_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "status"}, true);

		_finderPathCountByC_U_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "status"}, false);

		_finderPathWithPaginationFindByC_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "fileId"}, true);

		_finderPathWithoutPaginationFindByC_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_F",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "fileId"}, true);

		_finderPathCountByC_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_F",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "fileId"}, false);

		_finderPathWithPaginationFindByC_F_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_F_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId", "fileId", "status"}, true);

		_finderPathWithoutPaginationFindByC_F_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_F_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "fileId", "status"}, true);

		_finderPathCountByC_F_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_F_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "fileId", "status"}, false);

		_finderPathFetchByC_U_F_T = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_U_F_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "fileId", "type_"},
			true);

		_finderPathCountByC_U_F_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_F_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "fileId", "type_"},
			false);

		_finderPathWithPaginationFindByC_U_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "type_"}, true);

		_finderPathWithoutPaginationFindByC_U_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "type_"}, true);

		_finderPathCountByC_U_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "type_"}, false);

		_finderPathWithPaginationFindByC_U_S_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "status", "type_"},
			true);

		_finderPathWithoutPaginationFindByC_U_S_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "status", "type_"},
			true);

		_finderPathCountByC_U_S_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "userAllowedId", "status", "type_"},
			false);

		_finderPathWithPaginationFindByC_F_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_F_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId", "fileId", "type_"}, true);

		_finderPathWithoutPaginationFindByC_F_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_F_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "fileId", "type_"}, true);

		_finderPathCountByC_F_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_F_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "fileId", "type_"}, false);

		_finderPathWithPaginationFindByC_F_S_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_F_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "fileId", "status", "type_"}, true);

		_finderPathWithoutPaginationFindByC_F_S_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_F_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "fileId", "status", "type_"}, true);

		_finderPathCountByC_F_S_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_F_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "fileId", "status", "type_"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDGFileUserPermissionEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGFileUserPermissionEntryUtilPersistence(null);

		entityCache.removeCache(DGFileUserPermissionEntryImpl.class.getName());
	}

	private void _setDGFileUserPermissionEntryUtilPersistence(
		DGFileUserPermissionEntryPersistence
			dgFileUserPermissionEntryPersistence) {

		try {
			Field field = DGFileUserPermissionEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgFileUserPermissionEntryPersistence);
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

	private static final String _SQL_SELECT_DGFILEUSERPERMISSIONENTRY =
		"SELECT dgFileUserPermissionEntry FROM DGFileUserPermissionEntry dgFileUserPermissionEntry";

	private static final String _SQL_SELECT_DGFILEUSERPERMISSIONENTRY_WHERE =
		"SELECT dgFileUserPermissionEntry FROM DGFileUserPermissionEntry dgFileUserPermissionEntry WHERE ";

	private static final String _SQL_COUNT_DGFILEUSERPERMISSIONENTRY =
		"SELECT COUNT(dgFileUserPermissionEntry) FROM DGFileUserPermissionEntry dgFileUserPermissionEntry";

	private static final String _SQL_COUNT_DGFILEUSERPERMISSIONENTRY_WHERE =
		"SELECT COUNT(dgFileUserPermissionEntry) FROM DGFileUserPermissionEntry dgFileUserPermissionEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgFileUserPermissionEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGFileUserPermissionEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGFileUserPermissionEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGFileUserPermissionEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "role", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGFileUserPermissionEntryModelArgumentsResolver
		_dgFileUserPermissionEntryModelArgumentsResolver;

}