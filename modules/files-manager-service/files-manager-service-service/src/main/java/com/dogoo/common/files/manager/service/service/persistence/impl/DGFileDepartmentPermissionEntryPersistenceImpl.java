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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileDepartmentPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntryTable;
import com.dogoo.common.files.manager.service.model.impl.DGFileDepartmentPermissionEntryImpl;
import com.dogoo.common.files.manager.service.model.impl.DGFileDepartmentPermissionEntryModelImpl;
import com.dogoo.common.files.manager.service.service.persistence.DGFileDepartmentPermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileDepartmentPermissionEntryUtil;
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
 * The persistence implementation for the dg file department permission entry service.
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
		DGFileDepartmentPermissionEntryPersistence.class, BasePersistence.class
	}
)
public class DGFileDepartmentPermissionEntryPersistenceImpl
	extends BasePersistenceImpl<DGFileDepartmentPermissionEntry>
	implements DGFileDepartmentPermissionEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGFileDepartmentPermissionEntryUtil</code> to access the dg file department permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGFileDepartmentPermissionEntryImpl.class.getName();

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
	 * Returns all the dg file department permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		List<DGFileDepartmentPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileDepartmentPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry : list) {

					if (!uuid.equals(
							dgFileDepartmentPermissionEntry.getUuid())) {

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

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
				sb.append(
					DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileDepartmentPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByUuid_First(uuid, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		List<DGFileDepartmentPermissionEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByUuid_Last(uuid, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DGFileDepartmentPermissionEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry[] findByUuid_PrevAndNext(
			long fileDepartmentPermissionId, String uuid,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByPrimaryKey(fileDepartmentPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileDepartmentPermissionEntry[] array =
				new DGFileDepartmentPermissionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, uuid,
				orderByComparator, true);

			array[1] = dgFileDepartmentPermissionEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, uuid,
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

	protected DGFileDepartmentPermissionEntry getByUuid_PrevAndNext(
		Session session,
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry,
		String uuid,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileDepartmentPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileDepartmentPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file department permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgFileDepartmentPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
		"dgFileDepartmentPermissionEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dgFileDepartmentPermissionEntry.uuid IS NULL OR dgFileDepartmentPermissionEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByUUID_G(
			String uuid, long groupId)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByUUID_G(uuid, groupId);

		if (dgFileDepartmentPermissionEntry == null) {
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

			throw new NoSuchDGFileDepartmentPermissionEntryException(
				sb.toString());
		}

		return dgFileDepartmentPermissionEntry;
	}

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dg file department permission entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByUUID_G(
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

		if (result instanceof DGFileDepartmentPermissionEntry) {
			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
				(DGFileDepartmentPermissionEntry)result;

			if (!Objects.equals(
					uuid, dgFileDepartmentPermissionEntry.getUuid()) ||
				(groupId != dgFileDepartmentPermissionEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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

				List<DGFileDepartmentPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry = list.get(0);

					result = dgFileDepartmentPermissionEntry;

					cacheResult(dgFileDepartmentPermissionEntry);
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
			return (DGFileDepartmentPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file department permission entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file department permission entry that was removed
	 */
	@Override
	public DGFileDepartmentPermissionEntry removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByUUID_G(uuid, groupId);

		return remove(dgFileDepartmentPermissionEntry);
	}

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
		"dgFileDepartmentPermissionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dgFileDepartmentPermissionEntry.uuid IS NULL OR dgFileDepartmentPermissionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dgFileDepartmentPermissionEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		List<DGFileDepartmentPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileDepartmentPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry : list) {

					if (!uuid.equals(
							dgFileDepartmentPermissionEntry.getUuid()) ||
						(companyId !=
							dgFileDepartmentPermissionEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
				sb.append(
					DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileDepartmentPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		List<DGFileDepartmentPermissionEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DGFileDepartmentPermissionEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry[] findByUuid_C_PrevAndNext(
			long fileDepartmentPermissionId, String uuid, long companyId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByPrimaryKey(fileDepartmentPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileDepartmentPermissionEntry[] array =
				new DGFileDepartmentPermissionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = dgFileDepartmentPermissionEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, uuid, companyId,
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

	protected DGFileDepartmentPermissionEntry getByUuid_C_PrevAndNext(
		Session session,
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry,
		String uuid, long companyId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileDepartmentPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileDepartmentPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file department permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFileDepartmentPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file department permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
		"dgFileDepartmentPermissionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dgFileDepartmentPermissionEntry.uuid IS NULL OR dgFileDepartmentPermissionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dgFileDepartmentPermissionEntry.companyId = ?";

	private FinderPath _finderPathFetchByC_D_F;
	private FinderPath _finderPathCountByC_D_F;

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_D_F(
			long customerId, long departmentId, long fileId)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_D_F(customerId, departmentId, fileId);

		if (dgFileDepartmentPermissionEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", departmentId=");
			sb.append(departmentId);

			sb.append(", fileId=");
			sb.append(fileId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileDepartmentPermissionEntryException(
				sb.toString());
		}

		return dgFileDepartmentPermissionEntry;
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_F(
		long customerId, long departmentId, long fileId) {

		return fetchByC_D_F(customerId, departmentId, fileId, true);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_F(
		long customerId, long departmentId, long fileId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, departmentId, fileId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_D_F, finderArgs);
		}

		if (result instanceof DGFileDepartmentPermissionEntry) {
			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
				(DGFileDepartmentPermissionEntry)result;

			if ((customerId !=
					dgFileDepartmentPermissionEntry.getCustomerId()) ||
				(departmentId !=
					dgFileDepartmentPermissionEntry.getDepartmentId()) ||
				(fileId != dgFileDepartmentPermissionEntry.getFileId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_F_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_F_DEPARTMENTID_2);

			sb.append(_FINDER_COLUMN_C_D_F_FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

				queryPos.add(fileId);

				List<DGFileDepartmentPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_D_F, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, departmentId, fileId
								};
							}

							_log.warn(
								"DGFileDepartmentPermissionEntryPersistenceImpl.fetchByC_D_F(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry = list.get(0);

					result = dgFileDepartmentPermissionEntry;

					cacheResult(dgFileDepartmentPermissionEntry);
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
			return (DGFileDepartmentPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the dg file department permission entry that was removed
	 */
	@Override
	public DGFileDepartmentPermissionEntry removeByC_D_F(
			long customerId, long departmentId, long fileId)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByC_D_F(customerId, departmentId, fileId);

		return remove(dgFileDepartmentPermissionEntry);
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByC_D_F(long customerId, long departmentId, long fileId) {
		FinderPath finderPath = _finderPathCountByC_D_F;

		Object[] finderArgs = new Object[] {customerId, departmentId, fileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_F_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_F_DEPARTMENTID_2);

			sb.append(_FINDER_COLUMN_C_D_F_FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_C_D_F_CUSTOMERID_2 =
		"dgFileDepartmentPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_F_DEPARTMENTID_2 =
		"dgFileDepartmentPermissionEntry.departmentId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_F_FILEID_2 =
		"dgFileDepartmentPermissionEntry.fileId = ?";

	private FinderPath _finderPathWithPaginationFindByC_D;
	private FinderPath _finderPathWithoutPaginationFindByC_D;
	private FinderPath _finderPathCountByC_D;

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @return the matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId) {

		return findByC_D(
			customerId, departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end) {

		return findByC_D(customerId, departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return findByC_D(
			customerId, departmentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D(
		long customerId, long departmentId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_D;
				finderArgs = new Object[] {customerId, departmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_D;
			finderArgs = new Object[] {
				customerId, departmentId, start, end, orderByComparator
			};
		}

		List<DGFileDepartmentPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileDepartmentPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry : list) {

					if ((customerId !=
							dgFileDepartmentPermissionEntry.getCustomerId()) ||
						(departmentId !=
							dgFileDepartmentPermissionEntry.
								getDepartmentId())) {

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

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

				list = (List<DGFileDepartmentPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_D_First(
			long customerId, long departmentId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_D_First(customerId, departmentId, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", departmentId=");
		sb.append(departmentId);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_First(
		long customerId, long departmentId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		List<DGFileDepartmentPermissionEntry> list = findByC_D(
			customerId, departmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_D_Last(
			long customerId, long departmentId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_D_Last(customerId, departmentId, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", departmentId=");
		sb.append(departmentId);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_Last(
		long customerId, long departmentId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		int count = countByC_D(customerId, departmentId);

		if (count == 0) {
			return null;
		}

		List<DGFileDepartmentPermissionEntry> list = findByC_D(
			customerId, departmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry[] findByC_D_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long departmentId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByPrimaryKey(fileDepartmentPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileDepartmentPermissionEntry[] array =
				new DGFileDepartmentPermissionEntryImpl[3];

			array[0] = getByC_D_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId,
				departmentId, orderByComparator, true);

			array[1] = dgFileDepartmentPermissionEntry;

			array[2] = getByC_D_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId,
				departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileDepartmentPermissionEntry getByC_D_PrevAndNext(
		Session session,
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry,
		long customerId, long departmentId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_D_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_D_DEPARTMENTID_2);

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
			sb.append(DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(departmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileDepartmentPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileDepartmentPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and departmentId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 */
	@Override
	public void removeByC_D(long customerId, long departmentId) {
		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				findByC_D(
					customerId, departmentId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileDepartmentPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByC_D(long customerId, long departmentId) {
		FinderPath finderPath = _finderPathCountByC_D;

		Object[] finderArgs = new Object[] {customerId, departmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_DEPARTMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_C_D_CUSTOMERID_2 =
		"dgFileDepartmentPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_DEPARTMENTID_2 =
		"dgFileDepartmentPermissionEntry.departmentId = ?";

	private FinderPath _finderPathWithPaginationFindByC_F;
	private FinderPath _finderPathWithoutPaginationFindByC_F;
	private FinderPath _finderPathCountByC_F;

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId) {

		return findByC_F(
			customerId, fileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end) {

		return findByC_F(customerId, fileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return findByC_F(
			customerId, fileId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F(
		long customerId, long fileId, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		List<DGFileDepartmentPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileDepartmentPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry : list) {

					if ((customerId !=
							dgFileDepartmentPermissionEntry.getCustomerId()) ||
						(fileId !=
							dgFileDepartmentPermissionEntry.getFileId())) {

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

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_F_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_F_FILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(fileId);

				list = (List<DGFileDepartmentPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_F_First(
			long customerId, long fileId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_F_First(customerId, fileId, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_F_First(
		long customerId, long fileId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		List<DGFileDepartmentPermissionEntry> list = findByC_F(
			customerId, fileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_F_Last(
			long customerId, long fileId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_F_Last(customerId, fileId, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", fileId=");
		sb.append(fileId);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_F_Last(
		long customerId, long fileId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		int count = countByC_F(customerId, fileId);

		if (count == 0) {
			return null;
		}

		List<DGFileDepartmentPermissionEntry> list = findByC_F(
			customerId, fileId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry[] findByC_F_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long fileId,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByPrimaryKey(fileDepartmentPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileDepartmentPermissionEntry[] array =
				new DGFileDepartmentPermissionEntryImpl[3];

			array[0] = getByC_F_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId, fileId,
				orderByComparator, true);

			array[1] = dgFileDepartmentPermissionEntry;

			array[2] = getByC_F_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId, fileId,
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

	protected DGFileDepartmentPermissionEntry getByC_F_PrevAndNext(
		Session session,
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry,
		long customerId, long fileId,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileDepartmentPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileDepartmentPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and fileId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 */
	@Override
	public void removeByC_F(long customerId, long fileId) {
		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				findByC_F(
					customerId, fileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFileDepartmentPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and fileId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByC_F(long customerId, long fileId) {
		FinderPath finderPath = _finderPathCountByC_F;

		Object[] finderArgs = new Object[] {customerId, fileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
		"dgFileDepartmentPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_FILEID_2 =
		"dgFileDepartmentPermissionEntry.fileId = ?";

	private FinderPath _finderPathFetchByC_D_F_T;
	private FinderPath _finderPathCountByC_D_F_T;

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_D_F_T(
			long customerId, long departmentId, long fileId, String type)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_D_F_T(customerId, departmentId, fileId, type);

		if (dgFileDepartmentPermissionEntry == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", departmentId=");
			sb.append(departmentId);

			sb.append(", fileId=");
			sb.append(fileId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGFileDepartmentPermissionEntryException(
				sb.toString());
		}

		return dgFileDepartmentPermissionEntry;
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_F_T(
		long customerId, long departmentId, long fileId, String type) {

		return fetchByC_D_F_T(customerId, departmentId, fileId, type, true);
	}

	/**
	 * Returns the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_F_T(
		long customerId, long departmentId, long fileId, String type,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, departmentId, fileId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_D_F_T, finderArgs);
		}

		if (result instanceof DGFileDepartmentPermissionEntry) {
			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
				(DGFileDepartmentPermissionEntry)result;

			if ((customerId !=
					dgFileDepartmentPermissionEntry.getCustomerId()) ||
				(departmentId !=
					dgFileDepartmentPermissionEntry.getDepartmentId()) ||
				(fileId != dgFileDepartmentPermissionEntry.getFileId()) ||
				!Objects.equals(
					type, dgFileDepartmentPermissionEntry.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_F_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_F_T_DEPARTMENTID_2);

			sb.append(_FINDER_COLUMN_C_D_F_T_FILEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_D_F_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_D_F_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

				queryPos.add(fileId);

				if (bindType) {
					queryPos.add(type);
				}

				List<DGFileDepartmentPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_D_F_T, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, departmentId, fileId, type
								};
							}

							_log.warn(
								"DGFileDepartmentPermissionEntryPersistenceImpl.fetchByC_D_F_T(long, long, long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry = list.get(0);

					result = dgFileDepartmentPermissionEntry;

					cacheResult(dgFileDepartmentPermissionEntry);
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
			return (DGFileDepartmentPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file department permission entry where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the dg file department permission entry that was removed
	 */
	@Override
	public DGFileDepartmentPermissionEntry removeByC_D_F_T(
			long customerId, long departmentId, long fileId, String type)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByC_D_F_T(customerId, departmentId, fileId, type);

		return remove(dgFileDepartmentPermissionEntry);
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByC_D_F_T(
		long customerId, long departmentId, long fileId, String type) {

		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_D_F_T;

		Object[] finderArgs = new Object[] {
			customerId, departmentId, fileId, type
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_F_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_F_T_DEPARTMENTID_2);

			sb.append(_FINDER_COLUMN_C_D_F_T_FILEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_D_F_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_D_F_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_C_D_F_T_CUSTOMERID_2 =
		"dgFileDepartmentPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_F_T_DEPARTMENTID_2 =
		"dgFileDepartmentPermissionEntry.departmentId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_F_T_FILEID_2 =
		"dgFileDepartmentPermissionEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_F_T_TYPE_2 =
		"dgFileDepartmentPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_D_F_T_TYPE_3 =
		"(dgFileDepartmentPermissionEntry.type IS NULL OR dgFileDepartmentPermissionEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByC_D_T;
	private FinderPath _finderPathWithoutPaginationFindByC_D_T;
	private FinderPath _finderPathCountByC_D_T;

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @return the matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type) {

		return findByC_D_T(
			customerId, departmentId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end) {

		return findByC_D_T(customerId, departmentId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return findByC_D_T(
			customerId, departmentId, type, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_D_T(
		long customerId, long departmentId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_D_T;
				finderArgs = new Object[] {customerId, departmentId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_D_T;
			finderArgs = new Object[] {
				customerId, departmentId, type, start, end, orderByComparator
			};
		}

		List<DGFileDepartmentPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileDepartmentPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry : list) {

					if ((customerId !=
							dgFileDepartmentPermissionEntry.getCustomerId()) ||
						(departmentId !=
							dgFileDepartmentPermissionEntry.
								getDepartmentId()) ||
						!type.equals(
							dgFileDepartmentPermissionEntry.getType())) {

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

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_T_DEPARTMENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_D_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_D_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<DGFileDepartmentPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_D_T_First(
			long customerId, long departmentId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_D_T_First(
				customerId, departmentId, type, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", departmentId=");
		sb.append(departmentId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_T_First(
		long customerId, long departmentId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		List<DGFileDepartmentPermissionEntry> list = findByC_D_T(
			customerId, departmentId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_D_T_Last(
			long customerId, long departmentId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_D_T_Last(
				customerId, departmentId, type, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", departmentId=");
		sb.append(departmentId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_D_T_Last(
		long customerId, long departmentId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		int count = countByC_D_T(customerId, departmentId, type);

		if (count == 0) {
			return null;
		}

		List<DGFileDepartmentPermissionEntry> list = findByC_D_T(
			customerId, departmentId, type, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry[] findByC_D_T_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long departmentId,
			String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		type = Objects.toString(type, "");

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByPrimaryKey(fileDepartmentPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileDepartmentPermissionEntry[] array =
				new DGFileDepartmentPermissionEntryImpl[3];

			array[0] = getByC_D_T_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId,
				departmentId, type, orderByComparator, true);

			array[1] = dgFileDepartmentPermissionEntry;

			array[2] = getByC_D_T_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId,
				departmentId, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFileDepartmentPermissionEntry getByC_D_T_PrevAndNext(
		Session session,
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry,
		long customerId, long departmentId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_D_T_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_D_T_DEPARTMENTID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_D_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_C_D_T_TYPE_2);
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
			sb.append(DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(departmentId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgFileDepartmentPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileDepartmentPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 */
	@Override
	public void removeByC_D_T(long customerId, long departmentId, String type) {
		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				findByC_D_T(
					customerId, departmentId, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileDepartmentPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and departmentId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param departmentId the department ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByC_D_T(long customerId, long departmentId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_D_T;

		Object[] finderArgs = new Object[] {customerId, departmentId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_D_T_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_D_T_DEPARTMENTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_D_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_C_D_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_C_D_T_CUSTOMERID_2 =
		"dgFileDepartmentPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_T_DEPARTMENTID_2 =
		"dgFileDepartmentPermissionEntry.departmentId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_T_TYPE_2 =
		"dgFileDepartmentPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_D_T_TYPE_3 =
		"(dgFileDepartmentPermissionEntry.type IS NULL OR dgFileDepartmentPermissionEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByC_F_T;
	private FinderPath _finderPathWithoutPaginationFindByC_F_T;
	private FinderPath _finderPathCountByC_F_T;

	/**
	 * Returns all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type) {

		return findByC_F_T(
			customerId, fileId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end) {

		return findByC_F_T(customerId, fileId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return findByC_F_T(
			customerId, fileId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findByC_F_T(
		long customerId, long fileId, String type, int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		List<DGFileDepartmentPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileDepartmentPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry : list) {

					if ((customerId !=
							dgFileDepartmentPermissionEntry.getCustomerId()) ||
						(fileId !=
							dgFileDepartmentPermissionEntry.getFileId()) ||
						!type.equals(
							dgFileDepartmentPermissionEntry.getType())) {

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

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
				sb.append(
					DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFileDepartmentPermissionEntry>)QueryUtil.list(
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
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_F_T_First(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_F_T_First(customerId, fileId, type, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
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

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_F_T_First(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		List<DGFileDepartmentPermissionEntry> list = findByC_F_T(
			customerId, fileId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_F_T_Last(
			long customerId, long fileId, String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_F_T_Last(customerId, fileId, type, orderByComparator);

		if (dgFileDepartmentPermissionEntry != null) {
			return dgFileDepartmentPermissionEntry;
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

		throw new NoSuchDGFileDepartmentPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_F_T_Last(
		long customerId, long fileId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		int count = countByC_F_T(customerId, fileId, type);

		if (count == 0) {
			return null;
		}

		List<DGFileDepartmentPermissionEntry> list = findByC_F_T(
			customerId, fileId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file department permission entries before and after the current dg file department permission entry in the ordered set where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param fileDepartmentPermissionId the primary key of the current dg file department permission entry
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry[] findByC_F_T_PrevAndNext(
			long fileDepartmentPermissionId, long customerId, long fileId,
			String type,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		type = Objects.toString(type, "");

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByPrimaryKey(fileDepartmentPermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFileDepartmentPermissionEntry[] array =
				new DGFileDepartmentPermissionEntryImpl[3];

			array[0] = getByC_F_T_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId, fileId,
				type, orderByComparator, true);

			array[1] = dgFileDepartmentPermissionEntry;

			array[2] = getByC_F_T_PrevAndNext(
				session, dgFileDepartmentPermissionEntry, customerId, fileId,
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

	protected DGFileDepartmentPermissionEntry getByC_F_T_PrevAndNext(
		Session session,
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry,
		long customerId, long fileId, String type,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
			sb.append(DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						dgFileDepartmentPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFileDepartmentPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 */
	@Override
	public void removeByC_F_T(long customerId, long fileId, String type) {
		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				findByC_F_T(
					customerId, fileId, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgFileDepartmentPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file department permission entries where customerId = &#63; and fileId = &#63; and type = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param fileId the file ID
	 * @param type the type
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByC_F_T(long customerId, long fileId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByC_F_T;

		Object[] finderArgs = new Object[] {customerId, fileId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
		"dgFileDepartmentPermissionEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_T_FILEID_2 =
		"dgFileDepartmentPermissionEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_C_F_T_TYPE_2 =
		"dgFileDepartmentPermissionEntry.type = ?";

	private static final String _FINDER_COLUMN_C_F_T_TYPE_3 =
		"(dgFileDepartmentPermissionEntry.type IS NULL OR dgFileDepartmentPermissionEntry.type = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByC_ERC(companyId, externalReferenceCode);

		if (dgFileDepartmentPermissionEntry == null) {
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

			throw new NoSuchDGFileDepartmentPermissionEntryException(
				sb.toString());
		}

		return dgFileDepartmentPermissionEntry;
	}

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByC_ERC(
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

		if (result instanceof DGFileDepartmentPermissionEntry) {
			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
				(DGFileDepartmentPermissionEntry)result;

			if ((companyId != dgFileDepartmentPermissionEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dgFileDepartmentPermissionEntry.
						getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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

				List<DGFileDepartmentPermissionEntry> list = query.list();

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
								"DGFileDepartmentPermissionEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry = list.get(0);

					result = dgFileDepartmentPermissionEntry;

					cacheResult(dgFileDepartmentPermissionEntry);
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
			return (DGFileDepartmentPermissionEntry)result;
		}
	}

	/**
	 * Removes the dg file department permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file department permission entry that was removed
	 */
	@Override
	public DGFileDepartmentPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			findByC_ERC(companyId, externalReferenceCode);

		return remove(dgFileDepartmentPermissionEntry);
	}

	/**
	 * Returns the number of dg file department permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file department permission entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE);

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
		"dgFileDepartmentPermissionEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dgFileDepartmentPermissionEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dgFileDepartmentPermissionEntry.externalReferenceCode IS NULL OR dgFileDepartmentPermissionEntry.externalReferenceCode = '')";

	public DGFileDepartmentPermissionEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("role", "role_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGFileDepartmentPermissionEntry.class);

		setModelImplClass(DGFileDepartmentPermissionEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DGFileDepartmentPermissionEntryTable.INSTANCE);
	}

	/**
	 * Caches the dg file department permission entry in the entity cache if it is enabled.
	 *
	 * @param dgFileDepartmentPermissionEntry the dg file department permission entry
	 */
	@Override
	public void cacheResult(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		entityCache.putResult(
			DGFileDepartmentPermissionEntryImpl.class,
			dgFileDepartmentPermissionEntry.getPrimaryKey(),
			dgFileDepartmentPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dgFileDepartmentPermissionEntry.getUuid(),
				dgFileDepartmentPermissionEntry.getGroupId()
			},
			dgFileDepartmentPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_D_F,
			new Object[] {
				dgFileDepartmentPermissionEntry.getCustomerId(),
				dgFileDepartmentPermissionEntry.getDepartmentId(),
				dgFileDepartmentPermissionEntry.getFileId()
			},
			dgFileDepartmentPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_D_F_T,
			new Object[] {
				dgFileDepartmentPermissionEntry.getCustomerId(),
				dgFileDepartmentPermissionEntry.getDepartmentId(),
				dgFileDepartmentPermissionEntry.getFileId(),
				dgFileDepartmentPermissionEntry.getType()
			},
			dgFileDepartmentPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dgFileDepartmentPermissionEntry.getCompanyId(),
				dgFileDepartmentPermissionEntry.getExternalReferenceCode()
			},
			dgFileDepartmentPermissionEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dg file department permission entries in the entity cache if it is enabled.
	 *
	 * @param dgFileDepartmentPermissionEntries the dg file department permission entries
	 */
	@Override
	public void cacheResult(
		List<DGFileDepartmentPermissionEntry>
			dgFileDepartmentPermissionEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgFileDepartmentPermissionEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				dgFileDepartmentPermissionEntries) {

			if (entityCache.getResult(
					DGFileDepartmentPermissionEntryImpl.class,
					dgFileDepartmentPermissionEntry.getPrimaryKey()) == null) {

				cacheResult(dgFileDepartmentPermissionEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dg file department permission entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGFileDepartmentPermissionEntryImpl.class);

		finderCache.clearCache(DGFileDepartmentPermissionEntryImpl.class);
	}

	/**
	 * Clears the cache for the dg file department permission entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		entityCache.removeResult(
			DGFileDepartmentPermissionEntryImpl.class,
			dgFileDepartmentPermissionEntry);
	}

	@Override
	public void clearCache(
		List<DGFileDepartmentPermissionEntry>
			dgFileDepartmentPermissionEntries) {

		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				dgFileDepartmentPermissionEntries) {

			entityCache.removeResult(
				DGFileDepartmentPermissionEntryImpl.class,
				dgFileDepartmentPermissionEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGFileDepartmentPermissionEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DGFileDepartmentPermissionEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGFileDepartmentPermissionEntryModelImpl
			dgFileDepartmentPermissionEntryModelImpl) {

		Object[] args = new Object[] {
			dgFileDepartmentPermissionEntryModelImpl.getUuid(),
			dgFileDepartmentPermissionEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			dgFileDepartmentPermissionEntryModelImpl);

		args = new Object[] {
			dgFileDepartmentPermissionEntryModelImpl.getCustomerId(),
			dgFileDepartmentPermissionEntryModelImpl.getDepartmentId(),
			dgFileDepartmentPermissionEntryModelImpl.getFileId()
		};

		finderCache.putResult(_finderPathCountByC_D_F, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_D_F, args,
			dgFileDepartmentPermissionEntryModelImpl);

		args = new Object[] {
			dgFileDepartmentPermissionEntryModelImpl.getCustomerId(),
			dgFileDepartmentPermissionEntryModelImpl.getDepartmentId(),
			dgFileDepartmentPermissionEntryModelImpl.getFileId(),
			dgFileDepartmentPermissionEntryModelImpl.getType()
		};

		finderCache.putResult(_finderPathCountByC_D_F_T, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_D_F_T, args,
			dgFileDepartmentPermissionEntryModelImpl);

		args = new Object[] {
			dgFileDepartmentPermissionEntryModelImpl.getCompanyId(),
			dgFileDepartmentPermissionEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args,
			dgFileDepartmentPermissionEntryModelImpl);
	}

	/**
	 * Creates a new dg file department permission entry with the primary key. Does not add the dg file department permission entry to the database.
	 *
	 * @param fileDepartmentPermissionId the primary key for the new dg file department permission entry
	 * @return the new dg file department permission entry
	 */
	@Override
	public DGFileDepartmentPermissionEntry create(
		long fileDepartmentPermissionId) {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			new DGFileDepartmentPermissionEntryImpl();

		dgFileDepartmentPermissionEntry.setNew(true);
		dgFileDepartmentPermissionEntry.setPrimaryKey(
			fileDepartmentPermissionId);

		String uuid = PortalUUIDUtil.generate();

		dgFileDepartmentPermissionEntry.setUuid(uuid);

		dgFileDepartmentPermissionEntry.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return dgFileDepartmentPermissionEntry;
	}

	/**
	 * Removes the dg file department permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry that was removed
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry remove(
			long fileDepartmentPermissionId)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		return remove((Serializable)fileDepartmentPermissionId);
	}

	/**
	 * Removes the dg file department permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dg file department permission entry
	 * @return the dg file department permission entry that was removed
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry remove(Serializable primaryKey)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		Session session = null;

		try {
			session = openSession();

			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
				(DGFileDepartmentPermissionEntry)session.get(
					DGFileDepartmentPermissionEntryImpl.class, primaryKey);

			if (dgFileDepartmentPermissionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGFileDepartmentPermissionEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgFileDepartmentPermissionEntry);
		}
		catch (NoSuchDGFileDepartmentPermissionEntryException
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
	protected DGFileDepartmentPermissionEntry removeImpl(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgFileDepartmentPermissionEntry)) {
				dgFileDepartmentPermissionEntry =
					(DGFileDepartmentPermissionEntry)session.get(
						DGFileDepartmentPermissionEntryImpl.class,
						dgFileDepartmentPermissionEntry.getPrimaryKeyObj());
			}

			if (dgFileDepartmentPermissionEntry != null) {
				session.delete(dgFileDepartmentPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgFileDepartmentPermissionEntry != null) {
			clearCache(dgFileDepartmentPermissionEntry);
		}

		return dgFileDepartmentPermissionEntry;
	}

	@Override
	public DGFileDepartmentPermissionEntry updateImpl(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		boolean isNew = dgFileDepartmentPermissionEntry.isNew();

		if (!(dgFileDepartmentPermissionEntry instanceof
				DGFileDepartmentPermissionEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					dgFileDepartmentPermissionEntry.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					dgFileDepartmentPermissionEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgFileDepartmentPermissionEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGFileDepartmentPermissionEntry implementation " +
					dgFileDepartmentPermissionEntry.getClass());
		}

		DGFileDepartmentPermissionEntryModelImpl
			dgFileDepartmentPermissionEntryModelImpl =
				(DGFileDepartmentPermissionEntryModelImpl)
					dgFileDepartmentPermissionEntry;

		if (Validator.isNull(dgFileDepartmentPermissionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dgFileDepartmentPermissionEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(dgFileDepartmentPermissionEntry.getCreateDate() == null)) {

			if (serviceContext == null) {
				dgFileDepartmentPermissionEntry.setCreateDate(date);
			}
			else {
				dgFileDepartmentPermissionEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgFileDepartmentPermissionEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgFileDepartmentPermissionEntry.setModifiedDate(date);
			}
			else {
				dgFileDepartmentPermissionEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgFileDepartmentPermissionEntry);
			}
			else {
				dgFileDepartmentPermissionEntry =
					(DGFileDepartmentPermissionEntry)session.merge(
						dgFileDepartmentPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGFileDepartmentPermissionEntryImpl.class,
			dgFileDepartmentPermissionEntryModelImpl, false, true);

		cacheUniqueFindersCache(dgFileDepartmentPermissionEntryModelImpl);

		if (isNew) {
			dgFileDepartmentPermissionEntry.setNew(false);
		}

		dgFileDepartmentPermissionEntry.resetOriginalValues();

		return dgFileDepartmentPermissionEntry;
	}

	/**
	 * Returns the dg file department permission entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dg file department permission entry
	 * @return the dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			fetchByPrimaryKey(primaryKey);

		if (dgFileDepartmentPermissionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGFileDepartmentPermissionEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgFileDepartmentPermissionEntry;
	}

	/**
	 * Returns the dg file department permission entry with the primary key or throws a <code>NoSuchDGFileDepartmentPermissionEntryException</code> if it could not be found.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry
	 * @throws NoSuchDGFileDepartmentPermissionEntryException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry findByPrimaryKey(
			long fileDepartmentPermissionId)
		throws NoSuchDGFileDepartmentPermissionEntryException {

		return findByPrimaryKey((Serializable)fileDepartmentPermissionId);
	}

	/**
	 * Returns the dg file department permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry, or <code>null</code> if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public DGFileDepartmentPermissionEntry fetchByPrimaryKey(
		long fileDepartmentPermissionId) {

		return fetchByPrimaryKey((Serializable)fileDepartmentPermissionId);
	}

	/**
	 * Returns all the dg file department permission entries.
	 *
	 * @return the dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file department permission entries
	 */
	@Override
	public List<DGFileDepartmentPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<DGFileDepartmentPermissionEntry> orderByComparator,
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

		List<DGFileDepartmentPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<DGFileDepartmentPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY;

				sql = sql.concat(
					DGFileDepartmentPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGFileDepartmentPermissionEntry>)QueryUtil.list(
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
	 * Removes all the dg file department permission entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry :
				findAll()) {

			remove(dgFileDepartmentPermissionEntry);
		}
	}

	/**
	 * Returns the number of dg file department permission entries.
	 *
	 * @return the number of dg file department permission entries
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
					_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY);

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
		return "fileDepartmentPermissionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGFileDepartmentPermissionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dg file department permission entry persistence.
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

		_finderPathFetchByC_D_F = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_D_F",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"customerId", "departmentId", "fileId"}, true);

		_finderPathCountByC_D_F = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_D_F",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"customerId", "departmentId", "fileId"}, false);

		_finderPathWithPaginationFindByC_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_D",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "departmentId"}, true);

		_finderPathWithoutPaginationFindByC_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_D",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "departmentId"}, true);

		_finderPathCountByC_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_D",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "departmentId"}, false);

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

		_finderPathFetchByC_D_F_T = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_D_F_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "departmentId", "fileId", "type_"},
			true);

		_finderPathCountByC_D_F_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_D_F_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			new String[] {"customerId", "departmentId", "fileId", "type_"},
			false);

		_finderPathWithPaginationFindByC_D_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_D_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId", "departmentId", "type_"}, true);

		_finderPathWithoutPaginationFindByC_D_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_D_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "departmentId", "type_"}, true);

		_finderPathCountByC_D_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_D_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"customerId", "departmentId", "type_"}, false);

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

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDGFileDepartmentPermissionEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGFileDepartmentPermissionEntryUtilPersistence(null);

		entityCache.removeCache(
			DGFileDepartmentPermissionEntryImpl.class.getName());
	}

	private void _setDGFileDepartmentPermissionEntryUtilPersistence(
		DGFileDepartmentPermissionEntryPersistence
			dgFileDepartmentPermissionEntryPersistence) {

		try {
			Field field =
				DGFileDepartmentPermissionEntryUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, dgFileDepartmentPermissionEntryPersistence);
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

	private static final String _SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY =
		"SELECT dgFileDepartmentPermissionEntry FROM DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry";

	private static final String
		_SQL_SELECT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE =
			"SELECT dgFileDepartmentPermissionEntry FROM DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry WHERE ";

	private static final String _SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY =
		"SELECT COUNT(dgFileDepartmentPermissionEntry) FROM DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry";

	private static final String
		_SQL_COUNT_DGFILEDEPARTMENTPERMISSIONENTRY_WHERE =
			"SELECT COUNT(dgFileDepartmentPermissionEntry) FROM DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgFileDepartmentPermissionEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGFileDepartmentPermissionEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGFileDepartmentPermissionEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGFileDepartmentPermissionEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "role", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGFileDepartmentPermissionEntryModelArgumentsResolver
		_dgFileDepartmentPermissionEntryModelArgumentsResolver;

}