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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFilePermissionException;
import com.dogoo.common.files.manager.service.model.DGFilePermission;
import com.dogoo.common.files.manager.service.model.DGFilePermissionTable;
import com.dogoo.common.files.manager.service.model.impl.DGFilePermissionImpl;
import com.dogoo.common.files.manager.service.model.impl.DGFilePermissionModelImpl;
import com.dogoo.common.files.manager.service.service.persistence.DGFilePermissionPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFilePermissionUtil;
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
 * The persistence implementation for the dg file permission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DGFilePermissionPersistence.class, BasePersistence.class})
public class DGFilePermissionPersistenceImpl
	extends BasePersistenceImpl<DGFilePermission>
	implements DGFilePermissionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGFilePermissionUtil</code> to access the dg file permission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGFilePermissionImpl.class.getName();

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
	 * Returns all the dg file permissions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file permissions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @return the range of matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFilePermission> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGFilePermission> orderByComparator,
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

		List<DGFilePermission> list = null;

		if (useFinderCache) {
			list = (List<DGFilePermission>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFilePermission dgFilePermission : list) {
					if (!uuid.equals(dgFilePermission.getUuid())) {
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

			sb.append(_SQL_SELECT_DGFILEPERMISSION_WHERE);

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
				sb.append(DGFilePermissionModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFilePermission>)QueryUtil.list(
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
	 * Returns the first dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission findByUuid_First(
			String uuid, OrderByComparator<DGFilePermission> orderByComparator)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = fetchByUuid_First(
			uuid, orderByComparator);

		if (dgFilePermission != null) {
			return dgFilePermission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFilePermissionException(sb.toString());
	}

	/**
	 * Returns the first dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByUuid_First(
		String uuid, OrderByComparator<DGFilePermission> orderByComparator) {

		List<DGFilePermission> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission findByUuid_Last(
			String uuid, OrderByComparator<DGFilePermission> orderByComparator)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dgFilePermission != null) {
			return dgFilePermission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGFilePermissionException(sb.toString());
	}

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByUuid_Last(
		String uuid, OrderByComparator<DGFilePermission> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DGFilePermission> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file permissions before and after the current dg file permission in the ordered set where uuid = &#63;.
	 *
	 * @param filePermissionId the primary key of the current dg file permission
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file permission
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	@Override
	public DGFilePermission[] findByUuid_PrevAndNext(
			long filePermissionId, String uuid,
			OrderByComparator<DGFilePermission> orderByComparator)
		throws NoSuchDGFilePermissionException {

		uuid = Objects.toString(uuid, "");

		DGFilePermission dgFilePermission = findByPrimaryKey(filePermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFilePermission[] array = new DGFilePermissionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dgFilePermission, uuid, orderByComparator, true);

			array[1] = dgFilePermission;

			array[2] = getByUuid_PrevAndNext(
				session, dgFilePermission, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DGFilePermission getByUuid_PrevAndNext(
		Session session, DGFilePermission dgFilePermission, String uuid,
		OrderByComparator<DGFilePermission> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEPERMISSION_WHERE);

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
			sb.append(DGFilePermissionModelImpl.ORDER_BY_JPQL);
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
						dgFilePermission)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFilePermission> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file permissions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DGFilePermission dgFilePermission :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgFilePermission);
		}
	}

	/**
	 * Returns the number of dg file permissions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg file permissions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFILEPERMISSION_WHERE);

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
		"dgFilePermission.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dgFilePermission.uuid IS NULL OR dgFilePermission.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dg file permission where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGFilePermissionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission findByUUID_G(String uuid, long groupId)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = fetchByUUID_G(uuid, groupId);

		if (dgFilePermission == null) {
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

			throw new NoSuchDGFilePermissionException(sb.toString());
		}

		return dgFilePermission;
	}

	/**
	 * Returns the dg file permission where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dg file permission where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByUUID_G(
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

		if (result instanceof DGFilePermission) {
			DGFilePermission dgFilePermission = (DGFilePermission)result;

			if (!Objects.equals(uuid, dgFilePermission.getUuid()) ||
				(groupId != dgFilePermission.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEPERMISSION_WHERE);

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

				List<DGFilePermission> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DGFilePermission dgFilePermission = list.get(0);

					result = dgFilePermission;

					cacheResult(dgFilePermission);
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
			return (DGFilePermission)result;
		}
	}

	/**
	 * Removes the dg file permission where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg file permission that was removed
	 */
	@Override
	public DGFilePermission removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = findByUUID_G(uuid, groupId);

		return remove(dgFilePermission);
	}

	/**
	 * Returns the number of dg file permissions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg file permissions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEPERMISSION_WHERE);

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
		"dgFilePermission.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dgFilePermission.uuid IS NULL OR dgFilePermission.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dgFilePermission.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @return the range of matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFilePermission> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg file permissions
	 */
	@Override
	public List<DGFilePermission> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFilePermission> orderByComparator,
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

		List<DGFilePermission> list = null;

		if (useFinderCache) {
			list = (List<DGFilePermission>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGFilePermission dgFilePermission : list) {
					if (!uuid.equals(dgFilePermission.getUuid()) ||
						(companyId != dgFilePermission.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DGFILEPERMISSION_WHERE);

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
				sb.append(DGFilePermissionModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGFilePermission>)QueryUtil.list(
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
	 * Returns the first dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGFilePermission> orderByComparator)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dgFilePermission != null) {
			return dgFilePermission;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFilePermissionException(sb.toString());
	}

	/**
	 * Returns the first dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGFilePermission> orderByComparator) {

		List<DGFilePermission> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGFilePermission> orderByComparator)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dgFilePermission != null) {
			return dgFilePermission;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGFilePermissionException(sb.toString());
	}

	/**
	 * Returns the last dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGFilePermission> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DGFilePermission> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg file permissions before and after the current dg file permission in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param filePermissionId the primary key of the current dg file permission
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg file permission
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	@Override
	public DGFilePermission[] findByUuid_C_PrevAndNext(
			long filePermissionId, String uuid, long companyId,
			OrderByComparator<DGFilePermission> orderByComparator)
		throws NoSuchDGFilePermissionException {

		uuid = Objects.toString(uuid, "");

		DGFilePermission dgFilePermission = findByPrimaryKey(filePermissionId);

		Session session = null;

		try {
			session = openSession();

			DGFilePermission[] array = new DGFilePermissionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dgFilePermission, uuid, companyId, orderByComparator,
				true);

			array[1] = dgFilePermission;

			array[2] = getByUuid_C_PrevAndNext(
				session, dgFilePermission, uuid, companyId, orderByComparator,
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

	protected DGFilePermission getByUuid_C_PrevAndNext(
		Session session, DGFilePermission dgFilePermission, String uuid,
		long companyId, OrderByComparator<DGFilePermission> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFILEPERMISSION_WHERE);

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
			sb.append(DGFilePermissionModelImpl.ORDER_BY_JPQL);
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
						dgFilePermission)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGFilePermission> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg file permissions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DGFilePermission dgFilePermission :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgFilePermission);
		}
	}

	/**
	 * Returns the number of dg file permissions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg file permissions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEPERMISSION_WHERE);

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
		"dgFilePermission.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dgFilePermission.uuid IS NULL OR dgFilePermission.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dgFilePermission.companyId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dg file permission where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGFilePermissionException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file permission
	 * @throws NoSuchDGFilePermissionException if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (dgFilePermission == null) {
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

			throw new NoSuchDGFilePermissionException(sb.toString());
		}

		return dgFilePermission;
	}

	/**
	 * Returns the dg file permission where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dg file permission where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public DGFilePermission fetchByC_ERC(
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

		if (result instanceof DGFilePermission) {
			DGFilePermission dgFilePermission = (DGFilePermission)result;

			if ((companyId != dgFilePermission.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dgFilePermission.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFILEPERMISSION_WHERE);

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

				List<DGFilePermission> list = query.list();

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
								"DGFilePermissionPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGFilePermission dgFilePermission = list.get(0);

					result = dgFilePermission;

					cacheResult(dgFilePermission);
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
			return (DGFilePermission)result;
		}
	}

	/**
	 * Removes the dg file permission where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg file permission that was removed
	 */
	@Override
	public DGFilePermission removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(dgFilePermission);
	}

	/**
	 * Returns the number of dg file permissions where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg file permissions
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFILEPERMISSION_WHERE);

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
		"dgFilePermission.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dgFilePermission.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dgFilePermission.externalReferenceCode IS NULL OR dgFilePermission.externalReferenceCode = '')";

	public DGFilePermissionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("role", "role_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGFilePermission.class);

		setModelImplClass(DGFilePermissionImpl.class);
		setModelPKClass(long.class);

		setTable(DGFilePermissionTable.INSTANCE);
	}

	/**
	 * Caches the dg file permission in the entity cache if it is enabled.
	 *
	 * @param dgFilePermission the dg file permission
	 */
	@Override
	public void cacheResult(DGFilePermission dgFilePermission) {
		entityCache.putResult(
			DGFilePermissionImpl.class, dgFilePermission.getPrimaryKey(),
			dgFilePermission);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dgFilePermission.getUuid(), dgFilePermission.getGroupId()
			},
			dgFilePermission);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dgFilePermission.getCompanyId(),
				dgFilePermission.getExternalReferenceCode()
			},
			dgFilePermission);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dg file permissions in the entity cache if it is enabled.
	 *
	 * @param dgFilePermissions the dg file permissions
	 */
	@Override
	public void cacheResult(List<DGFilePermission> dgFilePermissions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgFilePermissions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGFilePermission dgFilePermission : dgFilePermissions) {
			if (entityCache.getResult(
					DGFilePermissionImpl.class,
					dgFilePermission.getPrimaryKey()) == null) {

				cacheResult(dgFilePermission);
			}
		}
	}

	/**
	 * Clears the cache for all dg file permissions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGFilePermissionImpl.class);

		finderCache.clearCache(DGFilePermissionImpl.class);
	}

	/**
	 * Clears the cache for the dg file permission.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DGFilePermission dgFilePermission) {
		entityCache.removeResult(DGFilePermissionImpl.class, dgFilePermission);
	}

	@Override
	public void clearCache(List<DGFilePermission> dgFilePermissions) {
		for (DGFilePermission dgFilePermission : dgFilePermissions) {
			entityCache.removeResult(
				DGFilePermissionImpl.class, dgFilePermission);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGFilePermissionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DGFilePermissionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGFilePermissionModelImpl dgFilePermissionModelImpl) {

		Object[] args = new Object[] {
			dgFilePermissionModelImpl.getUuid(),
			dgFilePermissionModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dgFilePermissionModelImpl);

		args = new Object[] {
			dgFilePermissionModelImpl.getCompanyId(),
			dgFilePermissionModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, dgFilePermissionModelImpl);
	}

	/**
	 * Creates a new dg file permission with the primary key. Does not add the dg file permission to the database.
	 *
	 * @param filePermissionId the primary key for the new dg file permission
	 * @return the new dg file permission
	 */
	@Override
	public DGFilePermission create(long filePermissionId) {
		DGFilePermission dgFilePermission = new DGFilePermissionImpl();

		dgFilePermission.setNew(true);
		dgFilePermission.setPrimaryKey(filePermissionId);

		String uuid = PortalUUIDUtil.generate();

		dgFilePermission.setUuid(uuid);

		dgFilePermission.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgFilePermission;
	}

	/**
	 * Removes the dg file permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission that was removed
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	@Override
	public DGFilePermission remove(long filePermissionId)
		throws NoSuchDGFilePermissionException {

		return remove((Serializable)filePermissionId);
	}

	/**
	 * Removes the dg file permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dg file permission
	 * @return the dg file permission that was removed
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	@Override
	public DGFilePermission remove(Serializable primaryKey)
		throws NoSuchDGFilePermissionException {

		Session session = null;

		try {
			session = openSession();

			DGFilePermission dgFilePermission = (DGFilePermission)session.get(
				DGFilePermissionImpl.class, primaryKey);

			if (dgFilePermission == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGFilePermissionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgFilePermission);
		}
		catch (NoSuchDGFilePermissionException noSuchEntityException) {
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
	protected DGFilePermission removeImpl(DGFilePermission dgFilePermission) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgFilePermission)) {
				dgFilePermission = (DGFilePermission)session.get(
					DGFilePermissionImpl.class,
					dgFilePermission.getPrimaryKeyObj());
			}

			if (dgFilePermission != null) {
				session.delete(dgFilePermission);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgFilePermission != null) {
			clearCache(dgFilePermission);
		}

		return dgFilePermission;
	}

	@Override
	public DGFilePermission updateImpl(DGFilePermission dgFilePermission) {
		boolean isNew = dgFilePermission.isNew();

		if (!(dgFilePermission instanceof DGFilePermissionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgFilePermission.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgFilePermission);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgFilePermission proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGFilePermission implementation " +
					dgFilePermission.getClass());
		}

		DGFilePermissionModelImpl dgFilePermissionModelImpl =
			(DGFilePermissionModelImpl)dgFilePermission;

		if (Validator.isNull(dgFilePermission.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dgFilePermission.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgFilePermission.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgFilePermission.setCreateDate(date);
			}
			else {
				dgFilePermission.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgFilePermissionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgFilePermission.setModifiedDate(date);
			}
			else {
				dgFilePermission.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgFilePermission);
			}
			else {
				dgFilePermission = (DGFilePermission)session.merge(
					dgFilePermission);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGFilePermissionImpl.class, dgFilePermissionModelImpl, false, true);

		cacheUniqueFindersCache(dgFilePermissionModelImpl);

		if (isNew) {
			dgFilePermission.setNew(false);
		}

		dgFilePermission.resetOriginalValues();

		return dgFilePermission;
	}

	/**
	 * Returns the dg file permission with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dg file permission
	 * @return the dg file permission
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	@Override
	public DGFilePermission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDGFilePermissionException {

		DGFilePermission dgFilePermission = fetchByPrimaryKey(primaryKey);

		if (dgFilePermission == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGFilePermissionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgFilePermission;
	}

	/**
	 * Returns the dg file permission with the primary key or throws a <code>NoSuchDGFilePermissionException</code> if it could not be found.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission
	 * @throws NoSuchDGFilePermissionException if a dg file permission with the primary key could not be found
	 */
	@Override
	public DGFilePermission findByPrimaryKey(long filePermissionId)
		throws NoSuchDGFilePermissionException {

		return findByPrimaryKey((Serializable)filePermissionId);
	}

	/**
	 * Returns the dg file permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission, or <code>null</code> if a dg file permission with the primary key could not be found
	 */
	@Override
	public DGFilePermission fetchByPrimaryKey(long filePermissionId) {
		return fetchByPrimaryKey((Serializable)filePermissionId);
	}

	/**
	 * Returns all the dg file permissions.
	 *
	 * @return the dg file permissions
	 */
	@Override
	public List<DGFilePermission> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg file permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @return the range of dg file permissions
	 */
	@Override
	public List<DGFilePermission> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg file permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg file permissions
	 */
	@Override
	public List<DGFilePermission> findAll(
		int start, int end,
		OrderByComparator<DGFilePermission> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg file permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg file permissions
	 */
	@Override
	public List<DGFilePermission> findAll(
		int start, int end,
		OrderByComparator<DGFilePermission> orderByComparator,
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

		List<DGFilePermission> list = null;

		if (useFinderCache) {
			list = (List<DGFilePermission>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFILEPERMISSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFILEPERMISSION;

				sql = sql.concat(DGFilePermissionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGFilePermission>)QueryUtil.list(
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
	 * Removes all the dg file permissions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGFilePermission dgFilePermission : findAll()) {
			remove(dgFilePermission);
		}
	}

	/**
	 * Returns the number of dg file permissions.
	 *
	 * @return the number of dg file permissions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFILEPERMISSION);

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
		return "filePermissionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFILEPERMISSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGFilePermissionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dg file permission persistence.
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

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDGFilePermissionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGFilePermissionUtilPersistence(null);

		entityCache.removeCache(DGFilePermissionImpl.class.getName());
	}

	private void _setDGFilePermissionUtilPersistence(
		DGFilePermissionPersistence dgFilePermissionPersistence) {

		try {
			Field field = DGFilePermissionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgFilePermissionPersistence);
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

	private static final String _SQL_SELECT_DGFILEPERMISSION =
		"SELECT dgFilePermission FROM DGFilePermission dgFilePermission";

	private static final String _SQL_SELECT_DGFILEPERMISSION_WHERE =
		"SELECT dgFilePermission FROM DGFilePermission dgFilePermission WHERE ";

	private static final String _SQL_COUNT_DGFILEPERMISSION =
		"SELECT COUNT(dgFilePermission) FROM DGFilePermission dgFilePermission";

	private static final String _SQL_COUNT_DGFILEPERMISSION_WHERE =
		"SELECT COUNT(dgFilePermission) FROM DGFilePermission dgFilePermission WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgFilePermission.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGFilePermission exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGFilePermission exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGFilePermissionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "role"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGFilePermissionModelArgumentsResolver
		_dgFilePermissionModelArgumentsResolver;

}