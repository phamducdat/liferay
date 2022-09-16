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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileSettingPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntryTable;
import com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryImpl;
import com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryModelImpl;
import com.dogoo.common.files.manager.service.service.persistence.DGFileSettingPermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileSettingPermissionEntryUtil;
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
 * The persistence implementation for the dg file setting permission entry service.
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
		DGFileSettingPermissionEntryPersistence.class, BasePersistence.class
	}
)
public class DGFileSettingPermissionEntryPersistenceImpl
	extends BasePersistenceImpl<DGFileSettingPermissionEntry>
	implements DGFileSettingPermissionEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGFileSettingPermissionEntryUtil</code> to access the dg file setting permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGFileSettingPermissionEntryImpl.class.getName();

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
	 * Returns all the dg file setting permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file setting permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator,
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

		List<DGFileSettingPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileSettingPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileSettingPermissionEntry dgFileSettingPermissionEntry :
						list) {

					if (!uuid.equals(dgFileSettingPermissionEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
				sb.append(DGFileSettingPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileSettingPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByUuid_First(uuid, orderByComparator);

		if (dgFileSettingPermissionEntry != null) {
			return dgFileSettingPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileSettingPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		List<DGFileSettingPermissionEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByUuid_Last(uuid, orderByComparator);

		if (dgFileSettingPermissionEntry != null) {
			return dgFileSettingPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileSettingPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DGFileSettingPermissionEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file setting permission entries before and after the current dg file setting permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileSettingPermissionId the primary key of the current dg file setting permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry[] findByUuid_PrevAndNext(
			long fileSettingPermissionId, String uuid,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			findByPrimaryKey(fileSettingPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileSettingPermissionEntry[] array =
				new DGFileSettingPermissionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dgFileSettingPermissionEntry, uuid, orderByComparator,
				true);

			array[1] = dgFileSettingPermissionEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dgFileSettingPermissionEntry, uuid, orderByComparator,
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

	protected DGFileSettingPermissionEntry getByUuid_PrevAndNext(
		Session session,
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry, String uuid,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileSettingPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileSettingPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileSettingPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file setting permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DGFileSettingPermissionEntry dgFileSettingPermissionEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgFileSettingPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file setting permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file setting permission entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
		"dgFileSettingPermissionEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dgFileSettingPermissionEntry.uuid IS NULL OR dgFileSettingPermissionEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dg file setting permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByUUID_G(uuid, groupId);

		if (dgFileSettingPermissionEntry == null) {
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

			throw new NoSuchDGFileSettingPermissionEntryException(
				sb.toString());
		}

		return dgFileSettingPermissionEntry;
	}

	/**
	 * Returns the dg file setting permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dg file setting permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByUUID_G(
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

		if (result instanceof DGFileSettingPermissionEntry) {
			DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
				(DGFileSettingPermissionEntry)result;

			if (!Objects.equals(uuid, dgFileSettingPermissionEntry.getUuid()) ||
				(groupId != dgFileSettingPermissionEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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

				List<DGFileSettingPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
						list.get(0);

					result = dgFileSettingPermissionEntry;

					cacheResult(dgFileSettingPermissionEntry);
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
			return (DGFileSettingPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file setting permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file setting permission entry that was removed
	 */
	@Override
	public DGFileSettingPermissionEntry removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			findByUUID_G(uuid, groupId);

		return remove(dgFileSettingPermissionEntry);
	}

	/**
	 * Returns the number of dg file setting permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file setting permission entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
		"dgFileSettingPermissionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dgFileSettingPermissionEntry.uuid IS NULL OR dgFileSettingPermissionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dgFileSettingPermissionEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator,
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

		List<DGFileSettingPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileSettingPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileSettingPermissionEntry dgFileSettingPermissionEntry :
						list) {

					if (!uuid.equals(dgFileSettingPermissionEntry.getUuid()) ||
						(companyId !=
							dgFileSettingPermissionEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
				sb.append(DGFileSettingPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileSettingPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (dgFileSettingPermissionEntry != null) {
			return dgFileSettingPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileSettingPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		List<DGFileSettingPermissionEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (dgFileSettingPermissionEntry != null) {
			return dgFileSettingPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileSettingPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DGFileSettingPermissionEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file setting permission entries before and after the current dg file setting permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileSettingPermissionId the primary key of the current dg file setting permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileSettingPermissionId, String uuid, long companyId,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator)
		throws NoSuchDGFileSettingPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			findByPrimaryKey(fileSettingPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileSettingPermissionEntry[] array =
				new DGFileSettingPermissionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dgFileSettingPermissionEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = dgFileSettingPermissionEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dgFileSettingPermissionEntry, uuid, companyId,
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

	protected DGFileSettingPermissionEntry getByUuid_C_PrevAndNext(
		Session session,
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry, String uuid,
		long companyId,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileSettingPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileSettingPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileSettingPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file setting permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DGFileSettingPermissionEntry dgFileSettingPermissionEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFileSettingPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file setting permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file setting permission entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
		"dgFileSettingPermissionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dgFileSettingPermissionEntry.uuid IS NULL OR dgFileSettingPermissionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dgFileSettingPermissionEntry.companyId = ?";

	private FinderPath _finderPathFetchByC_F;
	private FinderPath _finderPathCountByC_F;

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByC_F(long customerId, long fileId)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry = fetchByC_F(
			customerId, fileId);

		if (dgFileSettingPermissionEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", fileId=");
			sb.append(fileId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileSettingPermissionEntryException(
				sb.toString());
		}

		return dgFileSettingPermissionEntry;
	}

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByC_F(
		long customerId, long fileId) {

		return fetchByC_F(customerId, fileId, true);
	}

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByC_F(
		long customerId, long fileId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, fileId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_F, finderArgs);
		}

		if (result instanceof DGFileSettingPermissionEntry) {
			DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
				(DGFileSettingPermissionEntry)result;

			if ((customerId != dgFileSettingPermissionEntry.getCustomerId()) ||
				(fileId != dgFileSettingPermissionEntry.getFileId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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

				List<DGFileSettingPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_F, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {customerId, fileId};
							}

							_log.warn(
								"DGFileSettingPermissionEntryPersistenceImpl.fetchByC_F(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
						list.get(0);

					result = dgFileSettingPermissionEntry;

					cacheResult(dgFileSettingPermissionEntry);
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
			return (DGFileSettingPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file setting permission entry where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the dg file setting permission entry that was removed
	 */
	@Override
	public DGFileSettingPermissionEntry removeByC_F(
			long customerId, long fileId)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry = findByC_F(
			customerId, fileId);

		return remove(dgFileSettingPermissionEntry);
	}

	/**
	 * Returns the number of dg file setting permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file setting permission entries
	 */
	@Override
	public int countByC_F(long customerId, long fileId) {
		FinderPath finderPath = _finderPathCountByC_F;

		Object[] finderArgs = new Object[] {customerId, fileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
		"dgFileSettingPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_FILEID_2 =
		"dgFileSettingPermissionEntry.fileId = ?";

	private FinderPath _finderPathFetchByC_F_T;
	private FinderPath _finderPathCountByC_F_T;

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByC_F_T(
			long customerId, long fileId, String type)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByC_F_T(customerId, fileId, type);

		if (dgFileSettingPermissionEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", fileId=");
			sb.append(fileId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileSettingPermissionEntryException(
				sb.toString());
		}

		return dgFileSettingPermissionEntry;
	}

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByC_F_T(
		long customerId, long fileId, String type) {

		return fetchByC_F_T(customerId, fileId, type, true);
	}

	/**
	 * Returns the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByC_F_T(
		long customerId, long fileId, String type, boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, fileId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_F_T, finderArgs);
		}

		if (result instanceof DGFileSettingPermissionEntry) {
			DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
				(DGFileSettingPermissionEntry)result;

			if ((customerId != dgFileSettingPermissionEntry.getCustomerId()) ||
				(fileId != dgFileSettingPermissionEntry.getFileId()) ||
				!Objects.equals(type, dgFileSettingPermissionEntry.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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

				List<DGFileSettingPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_F_T, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, fileId, type
								};
							}

							_log.warn(
								"DGFileSettingPermissionEntryPersistenceImpl.fetchByC_F_T(long, long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
						list.get(0);

					result = dgFileSettingPermissionEntry;

					cacheResult(dgFileSettingPermissionEntry);
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
			return (DGFileSettingPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file setting permission entry where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file setting permission entry that was removed
	 */
	@Override
	public DGFileSettingPermissionEntry removeByC_F_T(
			long customerId, long fileId, String type)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry = findByC_F_T(
			customerId, fileId, type);

		return remove(dgFileSettingPermissionEntry);
	}

	/**
	 * Returns the number of dg file setting permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file setting permission entries
	 */
	@Override
	public int countByC_F_T(long customerId, long fileId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_F_T;

		Object[] finderArgs = new Object[] {customerId, fileId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
		"dgFileSettingPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_T_FILEID_2 =
		"dgFileSettingPermissionEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_T_TYPE_2 =
		"dgFileSettingPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_F_T_TYPE_3 =
		"(dgFileSettingPermissionEntry.type IS NULL OR dgFileSettingPermissionEntry.type = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByC_ERC(companyId, externalReferenceCode);

		if (dgFileSettingPermissionEntry == null) {
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

			throw new NoSuchDGFileSettingPermissionEntryException(
				sb.toString());
		}

		return dgFileSettingPermissionEntry;
	}

	/**
	 * Returns the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByC_ERC(
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

		if (result instanceof DGFileSettingPermissionEntry) {
			DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
				(DGFileSettingPermissionEntry)result;

			if ((companyId != dgFileSettingPermissionEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dgFileSettingPermissionEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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

				List<DGFileSettingPermissionEntry> list = query.list();

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
								"DGFileSettingPermissionEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
						list.get(0);

					result = dgFileSettingPermissionEntry;

					cacheResult(dgFileSettingPermissionEntry);
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
			return (DGFileSettingPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file setting permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file setting permission entry that was removed
	 */
	@Override
	public DGFileSettingPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(dgFileSettingPermissionEntry);
	}

	/**
	 * Returns the number of dg file setting permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file setting permission entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILESETTINGPERMISSIONENTRY_WHERE);

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
		"dgFileSettingPermissionEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dgFileSettingPermissionEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dgFileSettingPermissionEntry.externalReferenceCode IS NULL OR dgFileSettingPermissionEntry.externalReferenceCode = '')";

	public DGFileSettingPermissionEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGFileSettingPermissionEntry.class);

		setModelImplClass(DGFileSettingPermissionEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DGFileSettingPermissionEntryTable.INSTANCE);
	}

	/**
	 * Caches the dg file setting permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 */
	@Override
	public void cacheResult(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		entityCache.putResult(
			DGFileSettingPermissionEntryImpl.class,
			dgFileSettingPermissionEntry.getPrimaryKey(),
			dgFileSettingPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dgFileSettingPermissionEntry.getUuid(),
				dgFileSettingPermissionEntry.getGroupId()
			},
			dgFileSettingPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_F,
			new Object[] {
				dgFileSettingPermissionEntry.getCustomerId(),
				dgFileSettingPermissionEntry.getFileId()
			},
			dgFileSettingPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_F_T,
			new Object[] {
				dgFileSettingPermissionEntry.getCustomerId(),
				dgFileSettingPermissionEntry.getFileId(),
				dgFileSettingPermissionEntry.getType()
			},
			dgFileSettingPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dgFileSettingPermissionEntry.getCompanyId(),
				dgFileSettingPermissionEntry.getExternalReferenceCode()
			},
			dgFileSettingPermissionEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dg file setting permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileSettingPermissionEntries the dg file setting permission entries
	 */
	@Override
	public void cacheResult(
		List<DGFileSettingPermissionEntry> dgFileSettingPermissionEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgFileSettingPermissionEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGFileSettingPermissionEntry dgFileSettingPermissionEntry :
				dgFileSettingPermissionEntries) {

			if (entityCache.getResult(
					DGFileSettingPermissionEntryImpl.class,
					dgFileSettingPermissionEntry.getPrimaryKey()) == null) {

				cacheResult(dgFileSettingPermissionEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dg file setting permission entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGFileSettingPermissionEntryImpl.class);

		finderCache.clearCache(DGFileSettingPermissionEntryImpl.class);
	}

	/**
	 * Clears the cache for the dg file setting permission entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		entityCache.removeResult(
			DGFileSettingPermissionEntryImpl.class,
			dgFileSettingPermissionEntry);
	}

	@Override
	public void clearCache(
		List<DGFileSettingPermissionEntry> dgFileSettingPermissionEntries) {

		for (DGFileSettingPermissionEntry dgFileSettingPermissionEntry :
				dgFileSettingPermissionEntries) {

			entityCache.removeResult(
				DGFileSettingPermissionEntryImpl.class,
				dgFileSettingPermissionEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGFileSettingPermissionEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DGFileSettingPermissionEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGFileSettingPermissionEntryModelImpl
			dgFileSettingPermissionEntryModelImpl) {

		Object[] args = new Object[] {
			dgFileSettingPermissionEntryModelImpl.getUuid(),
			dgFileSettingPermissionEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			dgFileSettingPermissionEntryModelImpl);

		args = new Object[] {
			dgFileSettingPermissionEntryModelImpl.getCustomerId(),
			dgFileSettingPermissionEntryModelImpl.getFileId()
		};

		finderCache.putResult(_finderPathCountByC_F, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_F, args, dgFileSettingPermissionEntryModelImpl);

		args = new Object[] {
			dgFileSettingPermissionEntryModelImpl.getCustomerId(),
			dgFileSettingPermissionEntryModelImpl.getFileId(),
			dgFileSettingPermissionEntryModelImpl.getType()
		};

		finderCache.putResult(_finderPathCountByC_F_T, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_F_T, args,
			dgFileSettingPermissionEntryModelImpl);

		args = new Object[] {
			dgFileSettingPermissionEntryModelImpl.getCompanyId(),
			dgFileSettingPermissionEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args,
			dgFileSettingPermissionEntryModelImpl);
	}

	/**
	 * Creates a new dg file setting permission entry with the primary key. Does not add the dg file setting permission entry to the database.
	 *
	 * @param fileSettingPermissionId the primary key for the new dg file setting permission entry
	 * @return the new dg file setting permission entry
	 */
	@Override
	public DGFileSettingPermissionEntry create(long fileSettingPermissionId) {
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			new DGFileSettingPermissionEntryImpl();

		dgFileSettingPermissionEntry.setNew(true);
		dgFileSettingPermissionEntry.setPrimaryKey(fileSettingPermissionId);

		String uuid = PortalUUIDUtil.generate();

		dgFileSettingPermissionEntry.setUuid(uuid);

		dgFileSettingPermissionEntry.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return dgFileSettingPermissionEntry;
	}

	/**
	 * Removes the dg file setting permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry that was removed
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry remove(long fileSettingPermissionId)
		throws NoSuchDGFileSettingPermissionEntryException {

		return remove((Serializable)fileSettingPermissionId);
	}

	/**
	 * Removes the dg file setting permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry that was removed
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry remove(Serializable primaryKey)
		throws NoSuchDGFileSettingPermissionEntryException {

		Session session = null;

		try {
			session = openSession();

			DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
				(DGFileSettingPermissionEntry)session.get(
					DGFileSettingPermissionEntryImpl.class, primaryKey);

			if (dgFileSettingPermissionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGFileSettingPermissionEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgFileSettingPermissionEntry);
		}
		catch (NoSuchDGFileSettingPermissionEntryException
					noSuchEntityException) {

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
	protected DGFileSettingPermissionEntry removeImpl(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgFileSettingPermissionEntry)) {
				dgFileSettingPermissionEntry =
					(DGFileSettingPermissionEntry)session.get(
						DGFileSettingPermissionEntryImpl.class,
						dgFileSettingPermissionEntry.getPrimaryKeyObj());
			}

			if (dgFileSettingPermissionEntry != null) {
				session.delete(dgFileSettingPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgFileSettingPermissionEntry != null) {
			clearCache(dgFileSettingPermissionEntry);
		}

		return dgFileSettingPermissionEntry;
	}

	@Override
	public DGFileSettingPermissionEntry updateImpl(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		boolean isNew = dgFileSettingPermissionEntry.isNew();

		if (!(dgFileSettingPermissionEntry instanceof
				DGFileSettingPermissionEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					dgFileSettingPermissionEntry.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					dgFileSettingPermissionEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgFileSettingPermissionEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGFileSettingPermissionEntry implementation " +
					dgFileSettingPermissionEntry.getClass());
		}

		DGFileSettingPermissionEntryModelImpl
			dgFileSettingPermissionEntryModelImpl =
				(DGFileSettingPermissionEntryModelImpl)
					dgFileSettingPermissionEntry;

		if (Validator.isNull(dgFileSettingPermissionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dgFileSettingPermissionEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgFileSettingPermissionEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgFileSettingPermissionEntry.setCreateDate(date);
			}
			else {
				dgFileSettingPermissionEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgFileSettingPermissionEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgFileSettingPermissionEntry.setModifiedDate(date);
			}
			else {
				dgFileSettingPermissionEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgFileSettingPermissionEntry);
			}
			else {
				dgFileSettingPermissionEntry =
					(DGFileSettingPermissionEntry)session.merge(
						dgFileSettingPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGFileSettingPermissionEntryImpl.class,
			dgFileSettingPermissionEntryModelImpl, false, true);

		cacheUniqueFindersCache(dgFileSettingPermissionEntryModelImpl);

		if (isNew) {
			dgFileSettingPermissionEntry.setNew(false);
		}

		dgFileSettingPermissionEntry.resetOriginalValues();

		return dgFileSettingPermissionEntry;
	}

	/**
	 * Returns the dg file setting permission entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchDGFileSettingPermissionEntryException {

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			fetchByPrimaryKey(primaryKey);

		if (dgFileSettingPermissionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGFileSettingPermissionEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgFileSettingPermissionEntry;
	}

	/**
	 * Returns the dg file setting permission entry with the primary key or throws a <code>NoSuchDGFileSettingPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry
	 * @throws NoSuchDGFileSettingPermissionEntryException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry findByPrimaryKey(
			long fileSettingPermissionId)
		throws NoSuchDGFileSettingPermissionEntryException {

		return findByPrimaryKey((Serializable)fileSettingPermissionId);
	}

	/**
	 * Returns the dg file setting permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry, or <code>null</code> if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry fetchByPrimaryKey(
		long fileSettingPermissionId) {

		return fetchByPrimaryKey((Serializable)fileSettingPermissionId);
	}

	/**
	 * Returns all the dg file setting permission entries.
	 *
	 * @return the dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file setting permission entries
	 */
	@Override
	public List<DGFileSettingPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileSettingPermissionEntry> orderByComparator,
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

		List<DGFileSettingPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileSettingPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFILESETTINGPERMISSIONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFILESETTINGPERMISSIONENTRY;

				sql = sql.concat(
					DGFileSettingPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGFileSettingPermissionEntry>)QueryUtil.list(
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
	 * Removes all the dg file setting permission entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGFileSettingPermissionEntry dgFileSettingPermissionEntry :
				findAll()) {

			remove(dgFileSettingPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file setting permission entries.
	 *
	 * @return the number of dg file setting permission entries
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
					_SQL_COUNT_DGFILESETTINGPERMISSIONENTRY);

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
		return "fileSettingPermissionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFILESETTINGPERMISSIONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGFileSettingPermissionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dg file setting permission entry persistence.
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

		_finderPathFetchByC_F = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_F",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "fileId"}, true);

		_finderPathCountByC_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_F",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "fileId"}, false);

		_finderPathFetchByC_F_T = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_F_T",
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

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDGFileSettingPermissionEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGFileSettingPermissionEntryUtilPersistence(null);

		entityCache.removeCache(
			DGFileSettingPermissionEntryImpl.class.getName());
	}

	private void _setDGFileSettingPermissionEntryUtilPersistence(
		DGFileSettingPermissionEntryPersistence
			dgFileSettingPermissionEntryPersistence) {

		try {
			Field field =
				DGFileSettingPermissionEntryUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, dgFileSettingPermissionEntryPersistence);
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

	private static final String _SQL_SELECT_DGFILESETTINGPERMISSIONENTRY =
		"SELECT dgFileSettingPermissionEntry FROM DGFileSettingPermissionEntry dgFileSettingPermissionEntry";

	private static final String _SQL_SELECT_DGFILESETTINGPERMISSIONENTRY_WHERE =
		"SELECT dgFileSettingPermissionEntry FROM DGFileSettingPermissionEntry dgFileSettingPermissionEntry WHERE ";

	private static final String _SQL_COUNT_DGFILESETTINGPERMISSIONENTRY =
		"SELECT COUNT(dgFileSettingPermissionEntry) FROM DGFileSettingPermissionEntry dgFileSettingPermissionEntry";

	private static final String _SQL_COUNT_DGFILESETTINGPERMISSIONENTRY_WHERE =
		"SELECT COUNT(dgFileSettingPermissionEntry) FROM DGFileSettingPermissionEntry dgFileSettingPermissionEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgFileSettingPermissionEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGFileSettingPermissionEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGFileSettingPermissionEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGFileSettingPermissionEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGFileSettingPermissionEntryModelArgumentsResolver
		_dgFileSettingPermissionEntryModelArgumentsResolver;

}