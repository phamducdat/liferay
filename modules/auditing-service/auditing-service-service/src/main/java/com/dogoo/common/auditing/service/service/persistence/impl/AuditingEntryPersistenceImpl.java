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

package com.dogoo.common.auditing.service.service.persistence.impl;

import com.dogoo.common.auditing.service.exception.NoSuchAuditingEntryException;
import com.dogoo.common.auditing.service.model.AuditingEntry;
import com.dogoo.common.auditing.service.model.AuditingEntryTable;
import com.dogoo.common.auditing.service.model.impl.AuditingEntryImpl;
import com.dogoo.common.auditing.service.model.impl.AuditingEntryModelImpl;
import com.dogoo.common.auditing.service.service.persistence.AuditingEntryPersistence;
import com.dogoo.common.auditing.service.service.persistence.AuditingEntryUtil;
import com.dogoo.common.auditing.service.service.persistence.impl.constants.DG_AUDITINGPersistenceConstants;

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
 * The persistence implementation for the auditing entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AuditingEntryPersistence.class, BasePersistence.class})
public class AuditingEntryPersistenceImpl
	extends BasePersistenceImpl<AuditingEntry>
	implements AuditingEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuditingEntryUtil</code> to access the auditing entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuditingEntryImpl.class.getName();

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
	 * Returns all the auditing entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
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

		List<AuditingEntry> list = null;

		if (useFinderCache) {
			list = (List<AuditingEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AuditingEntry auditingEntry : list) {
					if (!uuid.equals(auditingEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

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
				sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AuditingEntry>)QueryUtil.list(
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
	 * Returns the first auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByUuid_First(
			String uuid, OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByUuid_First(
		String uuid, OrderByComparator<AuditingEntry> orderByComparator) {

		List<AuditingEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByUuid_Last(
			String uuid, OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AuditingEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AuditingEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where uuid = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry[] findByUuid_PrevAndNext(
			long auditingId, String uuid,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		uuid = Objects.toString(uuid, "");

		AuditingEntry auditingEntry = findByPrimaryKey(auditingId);

		Session session = null;

		try {
			session = openSession();

			AuditingEntry[] array = new AuditingEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, auditingEntry, uuid, orderByComparator, true);

			array[1] = auditingEntry;

			array[2] = getByUuid_PrevAndNext(
				session, auditingEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditingEntry getByUuid_PrevAndNext(
		Session session, AuditingEntry auditingEntry, String uuid,
		OrderByComparator<AuditingEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

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
			sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
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
						auditingEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditingEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auditing entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AuditingEntry auditingEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(auditingEntry);
		}
	}

	/**
	 * Returns the number of auditing entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditing entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUDITINGENTRY_WHERE);

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
		"auditingEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(auditingEntry.uuid IS NULL OR auditingEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByUUID_G(uuid, groupId);

		if (auditingEntry == null) {
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

			throw new NoSuchAuditingEntryException(sb.toString());
		}

		return auditingEntry;
	}

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the auditing entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByUUID_G(
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

		if (result instanceof AuditingEntry) {
			AuditingEntry auditingEntry = (AuditingEntry)result;

			if (!Objects.equals(uuid, auditingEntry.getUuid()) ||
				(groupId != auditingEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

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

				List<AuditingEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AuditingEntry auditingEntry = list.get(0);

					result = auditingEntry;

					cacheResult(auditingEntry);
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
			return (AuditingEntry)result;
		}
	}

	/**
	 * Removes the auditing entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the auditing entry that was removed
	 */
	@Override
	public AuditingEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = findByUUID_G(uuid, groupId);

		return remove(auditingEntry);
	}

	/**
	 * Returns the number of auditing entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching auditing entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUDITINGENTRY_WHERE);

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
		"auditingEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(auditingEntry.uuid IS NULL OR auditingEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"auditingEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
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

		List<AuditingEntry> list = null;

		if (useFinderCache) {
			list = (List<AuditingEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AuditingEntry auditingEntry : list) {
					if (!uuid.equals(auditingEntry.getUuid()) ||
						(companyId != auditingEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

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
				sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AuditingEntry>)QueryUtil.list(
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
	 * Returns the first auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the first auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AuditingEntry> orderByComparator) {

		List<AuditingEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the last auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AuditingEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AuditingEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry[] findByUuid_C_PrevAndNext(
			long auditingId, String uuid, long companyId,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		uuid = Objects.toString(uuid, "");

		AuditingEntry auditingEntry = findByPrimaryKey(auditingId);

		Session session = null;

		try {
			session = openSession();

			AuditingEntry[] array = new AuditingEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, auditingEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = auditingEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, auditingEntry, uuid, companyId, orderByComparator,
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

	protected AuditingEntry getByUuid_C_PrevAndNext(
		Session session, AuditingEntry auditingEntry, String uuid,
		long companyId, OrderByComparator<AuditingEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

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
			sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
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
						auditingEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditingEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auditing entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AuditingEntry auditingEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(auditingEntry);
		}
	}

	/**
	 * Returns the number of auditing entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching auditing entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUDITINGENTRY_WHERE);

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
		"auditingEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(auditingEntry.uuid IS NULL OR auditingEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"auditingEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPK_Name;
	private FinderPath _finderPathWithoutPaginationFindByPK_Name;
	private FinderPath _finderPathCountByPK_Name;

	/**
	 * Returns all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName) {

		return findByPK_Name(
			classPkId, classPkName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end) {

		return findByPK_Name(classPkId, classPkName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return findByPK_Name(
			classPkId, classPkName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByPK_Name(
		long classPkId, String classPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
		boolean useFinderCache) {

		classPkName = Objects.toString(classPkName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPK_Name;
				finderArgs = new Object[] {classPkId, classPkName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPK_Name;
			finderArgs = new Object[] {
				classPkId, classPkName, start, end, orderByComparator
			};
		}

		List<AuditingEntry> list = null;

		if (useFinderCache) {
			list = (List<AuditingEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AuditingEntry auditingEntry : list) {
					if ((classPkId != auditingEntry.getClassPkId()) ||
						!classPkName.equals(auditingEntry.getClassPkName())) {

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

			sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPkId);

				if (bindClassPkName) {
					queryPos.add(classPkName);
				}

				list = (List<AuditingEntry>)QueryUtil.list(
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
	 * Returns the first auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByPK_Name_First(
			long classPkId, String classPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByPK_Name_First(
			classPkId, classPkName, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPkId=");
		sb.append(classPkId);

		sb.append(", classPkName=");
		sb.append(classPkName);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the first auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByPK_Name_First(
		long classPkId, String classPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		List<AuditingEntry> list = findByPK_Name(
			classPkId, classPkName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByPK_Name_Last(
			long classPkId, String classPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByPK_Name_Last(
			classPkId, classPkName, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classPkId=");
		sb.append(classPkId);

		sb.append(", classPkName=");
		sb.append(classPkName);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the last auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByPK_Name_Last(
		long classPkId, String classPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		int count = countByPK_Name(classPkId, classPkName);

		if (count == 0) {
			return null;
		}

		List<AuditingEntry> list = findByPK_Name(
			classPkId, classPkName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry[] findByPK_Name_PrevAndNext(
			long auditingId, long classPkId, String classPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		classPkName = Objects.toString(classPkName, "");

		AuditingEntry auditingEntry = findByPrimaryKey(auditingId);

		Session session = null;

		try {
			session = openSession();

			AuditingEntry[] array = new AuditingEntryImpl[3];

			array[0] = getByPK_Name_PrevAndNext(
				session, auditingEntry, classPkId, classPkName,
				orderByComparator, true);

			array[1] = auditingEntry;

			array[2] = getByPK_Name_PrevAndNext(
				session, auditingEntry, classPkId, classPkName,
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

	protected AuditingEntry getByPK_Name_PrevAndNext(
		Session session, AuditingEntry auditingEntry, long classPkId,
		String classPkName, OrderByComparator<AuditingEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKID_2);

		boolean bindClassPkName = false;

		if (classPkName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKNAME_3);
		}
		else {
			bindClassPkName = true;

			sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKNAME_2);
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
			sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(classPkId);

		if (bindClassPkName) {
			queryPos.add(classPkName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						auditingEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditingEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auditing entries where classPkId = &#63; and classPkName = &#63; from the database.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 */
	@Override
	public void removeByPK_Name(long classPkId, String classPkName) {
		for (AuditingEntry auditingEntry :
				findByPK_Name(
					classPkId, classPkName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(auditingEntry);
		}
	}

	/**
	 * Returns the number of auditing entries where classPkId = &#63; and classPkName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPkName the class pk name
	 * @return the number of matching auditing entries
	 */
	@Override
	public int countByPK_Name(long classPkId, String classPkName) {
		classPkName = Objects.toString(classPkName, "");

		FinderPath finderPath = _finderPathCountByPK_Name;

		Object[] finderArgs = new Object[] {classPkId, classPkName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUDITINGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKID_2);

			boolean bindClassPkName = false;

			if (classPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKNAME_3);
			}
			else {
				bindClassPkName = true;

				sb.append(_FINDER_COLUMN_PK_NAME_CLASSPKNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_PK_NAME_CLASSPKID_2 =
		"auditingEntry.classPkId = ? AND ";

	private static final String _FINDER_COLUMN_PK_NAME_CLASSPKNAME_2 =
		"auditingEntry.classPkName = ?";

	private static final String _FINDER_COLUMN_PK_NAME_CLASSPKNAME_3 =
		"(auditingEntry.classPkName IS NULL OR auditingEntry.classPkName = '')";

	private FinderPath _finderPathWithPaginationFindByParent_PK_Name;
	private FinderPath _finderPathWithoutPaginationFindByParent_PK_Name;
	private FinderPath _finderPathCountByParent_PK_Name;

	/**
	 * Returns all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @return the matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName) {

		return findByParent_PK_Name(
			parentPkId, parentPkName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end) {

		return findByParent_PK_Name(parentPkId, parentPkName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return findByParent_PK_Name(
			parentPkId, parentPkName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditing entries
	 */
	@Override
	public List<AuditingEntry> findByParent_PK_Name(
		Long parentPkId, String parentPkName, int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator,
		boolean useFinderCache) {

		parentPkName = Objects.toString(parentPkName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParent_PK_Name;
				finderArgs = new Object[] {parentPkId, parentPkName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParent_PK_Name;
			finderArgs = new Object[] {
				parentPkId, parentPkName, start, end, orderByComparator
			};
		}

		List<AuditingEntry> list = null;

		if (useFinderCache) {
			list = (List<AuditingEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AuditingEntry auditingEntry : list) {
					if (!Objects.equals(
							parentPkId, auditingEntry.getParentPkId()) ||
						!parentPkName.equals(auditingEntry.getParentPkName())) {

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

			sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKID_2);

			boolean bindParentPkName = false;

			if (parentPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_3);
			}
			else {
				bindParentPkName = true;

				sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentPkId.longValue());

				if (bindParentPkName) {
					queryPos.add(parentPkName);
				}

				list = (List<AuditingEntry>)QueryUtil.list(
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
	 * Returns the first auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByParent_PK_Name_First(
			Long parentPkId, String parentPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByParent_PK_Name_First(
			parentPkId, parentPkName, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentPkId=");
		sb.append(parentPkId);

		sb.append(", parentPkName=");
		sb.append(parentPkName);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the first auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByParent_PK_Name_First(
		Long parentPkId, String parentPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		List<AuditingEntry> list = findByParent_PK_Name(
			parentPkId, parentPkName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByParent_PK_Name_Last(
			Long parentPkId, String parentPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByParent_PK_Name_Last(
			parentPkId, parentPkName, orderByComparator);

		if (auditingEntry != null) {
			return auditingEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentPkId=");
		sb.append(parentPkId);

		sb.append(", parentPkName=");
		sb.append(parentPkName);

		sb.append("}");

		throw new NoSuchAuditingEntryException(sb.toString());
	}

	/**
	 * Returns the last auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByParent_PK_Name_Last(
		Long parentPkId, String parentPkName,
		OrderByComparator<AuditingEntry> orderByComparator) {

		int count = countByParent_PK_Name(parentPkId, parentPkName);

		if (count == 0) {
			return null;
		}

		List<AuditingEntry> list = findByParent_PK_Name(
			parentPkId, parentPkName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auditing entries before and after the current auditing entry in the ordered set where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param auditingId the primary key of the current auditing entry
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry[] findByParent_PK_Name_PrevAndNext(
			long auditingId, Long parentPkId, String parentPkName,
			OrderByComparator<AuditingEntry> orderByComparator)
		throws NoSuchAuditingEntryException {

		parentPkName = Objects.toString(parentPkName, "");

		AuditingEntry auditingEntry = findByPrimaryKey(auditingId);

		Session session = null;

		try {
			session = openSession();

			AuditingEntry[] array = new AuditingEntryImpl[3];

			array[0] = getByParent_PK_Name_PrevAndNext(
				session, auditingEntry, parentPkId, parentPkName,
				orderByComparator, true);

			array[1] = auditingEntry;

			array[2] = getByParent_PK_Name_PrevAndNext(
				session, auditingEntry, parentPkId, parentPkName,
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

	protected AuditingEntry getByParent_PK_Name_PrevAndNext(
		Session session, AuditingEntry auditingEntry, Long parentPkId,
		String parentPkName, OrderByComparator<AuditingEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKID_2);

		boolean bindParentPkName = false;

		if (parentPkName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_3);
		}
		else {
			bindParentPkName = true;

			sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_2);
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
			sb.append(AuditingEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentPkId.longValue());

		if (bindParentPkName) {
			queryPos.add(parentPkName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						auditingEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditingEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auditing entries where parentPkId = &#63; and parentPkName = &#63; from the database.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 */
	@Override
	public void removeByParent_PK_Name(Long parentPkId, String parentPkName) {
		for (AuditingEntry auditingEntry :
				findByParent_PK_Name(
					parentPkId, parentPkName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(auditingEntry);
		}
	}

	/**
	 * Returns the number of auditing entries where parentPkId = &#63; and parentPkName = &#63;.
	 *
	 * @param parentPkId the parent pk ID
	 * @param parentPkName the parent pk name
	 * @return the number of matching auditing entries
	 */
	@Override
	public int countByParent_PK_Name(Long parentPkId, String parentPkName) {
		parentPkName = Objects.toString(parentPkName, "");

		FinderPath finderPath = _finderPathCountByParent_PK_Name;

		Object[] finderArgs = new Object[] {parentPkId, parentPkName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUDITINGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKID_2);

			boolean bindParentPkName = false;

			if (parentPkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_3);
			}
			else {
				bindParentPkName = true;

				sb.append(_FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentPkId.longValue());

				if (bindParentPkName) {
					queryPos.add(parentPkName);
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

	private static final String _FINDER_COLUMN_PARENT_PK_NAME_PARENTPKID_2 =
		"auditingEntry.parentPkId = ? AND ";

	private static final String _FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_2 =
		"auditingEntry.parentPkName = ?";

	private static final String _FINDER_COLUMN_PARENT_PK_NAME_PARENTPKNAME_3 =
		"(auditingEntry.parentPkName IS NULL OR auditingEntry.parentPkName = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching auditing entry
	 * @throws NoSuchAuditingEntryException if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (auditingEntry == null) {
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

			throw new NoSuchAuditingEntryException(sb.toString());
		}

		return auditingEntry;
	}

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the auditing entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public AuditingEntry fetchByC_ERC(
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

		if (result instanceof AuditingEntry) {
			AuditingEntry auditingEntry = (AuditingEntry)result;

			if ((companyId != auditingEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					auditingEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AUDITINGENTRY_WHERE);

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

				List<AuditingEntry> list = query.list();

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
								"AuditingEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AuditingEntry auditingEntry = list.get(0);

					result = auditingEntry;

					cacheResult(auditingEntry);
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
			return (AuditingEntry)result;
		}
	}

	/**
	 * Removes the auditing entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the auditing entry that was removed
	 */
	@Override
	public AuditingEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(auditingEntry);
	}

	/**
	 * Returns the number of auditing entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching auditing entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUDITINGENTRY_WHERE);

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
		"auditingEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"auditingEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(auditingEntry.externalReferenceCode IS NULL OR auditingEntry.externalReferenceCode = '')";

	public AuditingEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AuditingEntry.class);

		setModelImplClass(AuditingEntryImpl.class);
		setModelPKClass(long.class);

		setTable(AuditingEntryTable.INSTANCE);
	}

	/**
	 * Caches the auditing entry in the entity cache if it is enabled.
	 *
	 * @param auditingEntry the auditing entry
	 */
	@Override
	public void cacheResult(AuditingEntry auditingEntry) {
		entityCache.putResult(
			AuditingEntryImpl.class, auditingEntry.getPrimaryKey(),
			auditingEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {auditingEntry.getUuid(), auditingEntry.getGroupId()},
			auditingEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				auditingEntry.getCompanyId(),
				auditingEntry.getExternalReferenceCode()
			},
			auditingEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the auditing entries in the entity cache if it is enabled.
	 *
	 * @param auditingEntries the auditing entries
	 */
	@Override
	public void cacheResult(List<AuditingEntry> auditingEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (auditingEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AuditingEntry auditingEntry : auditingEntries) {
			if (entityCache.getResult(
					AuditingEntryImpl.class, auditingEntry.getPrimaryKey()) ==
						null) {

				cacheResult(auditingEntry);
			}
		}
	}

	/**
	 * Clears the cache for all auditing entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuditingEntryImpl.class);

		finderCache.clearCache(AuditingEntryImpl.class);
	}

	/**
	 * Clears the cache for the auditing entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditingEntry auditingEntry) {
		entityCache.removeResult(AuditingEntryImpl.class, auditingEntry);
	}

	@Override
	public void clearCache(List<AuditingEntry> auditingEntries) {
		for (AuditingEntry auditingEntry : auditingEntries) {
			entityCache.removeResult(AuditingEntryImpl.class, auditingEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AuditingEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuditingEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AuditingEntryModelImpl auditingEntryModelImpl) {

		Object[] args = new Object[] {
			auditingEntryModelImpl.getUuid(),
			auditingEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, auditingEntryModelImpl);

		args = new Object[] {
			auditingEntryModelImpl.getCompanyId(),
			auditingEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, auditingEntryModelImpl);
	}

	/**
	 * Creates a new auditing entry with the primary key. Does not add the auditing entry to the database.
	 *
	 * @param auditingId the primary key for the new auditing entry
	 * @return the new auditing entry
	 */
	@Override
	public AuditingEntry create(long auditingId) {
		AuditingEntry auditingEntry = new AuditingEntryImpl();

		auditingEntry.setNew(true);
		auditingEntry.setPrimaryKey(auditingId);

		String uuid = PortalUUIDUtil.generate();

		auditingEntry.setUuid(uuid);

		auditingEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return auditingEntry;
	}

	/**
	 * Removes the auditing entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry that was removed
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry remove(long auditingId)
		throws NoSuchAuditingEntryException {

		return remove((Serializable)auditingId);
	}

	/**
	 * Removes the auditing entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auditing entry
	 * @return the auditing entry that was removed
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry remove(Serializable primaryKey)
		throws NoSuchAuditingEntryException {

		Session session = null;

		try {
			session = openSession();

			AuditingEntry auditingEntry = (AuditingEntry)session.get(
				AuditingEntryImpl.class, primaryKey);

			if (auditingEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditingEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auditingEntry);
		}
		catch (NoSuchAuditingEntryException noSuchEntityException) {
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
	protected AuditingEntry removeImpl(AuditingEntry auditingEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auditingEntry)) {
				auditingEntry = (AuditingEntry)session.get(
					AuditingEntryImpl.class, auditingEntry.getPrimaryKeyObj());
			}

			if (auditingEntry != null) {
				session.delete(auditingEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (auditingEntry != null) {
			clearCache(auditingEntry);
		}

		return auditingEntry;
	}

	@Override
	public AuditingEntry updateImpl(AuditingEntry auditingEntry) {
		boolean isNew = auditingEntry.isNew();

		if (!(auditingEntry instanceof AuditingEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(auditingEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					auditingEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in auditingEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AuditingEntry implementation " +
					auditingEntry.getClass());
		}

		AuditingEntryModelImpl auditingEntryModelImpl =
			(AuditingEntryModelImpl)auditingEntry;

		if (Validator.isNull(auditingEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			auditingEntry.setUuid(uuid);
		}

		if (isNew && (auditingEntry.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				auditingEntry.setCreateDate(date);
			}
			else {
				auditingEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(auditingEntry);
			}
			else {
				auditingEntry = (AuditingEntry)session.merge(auditingEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AuditingEntryImpl.class, auditingEntryModelImpl, false, true);

		cacheUniqueFindersCache(auditingEntryModelImpl);

		if (isNew) {
			auditingEntry.setNew(false);
		}

		auditingEntry.resetOriginalValues();

		return auditingEntry;
	}

	/**
	 * Returns the auditing entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditing entry
	 * @return the auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuditingEntryException {

		AuditingEntry auditingEntry = fetchByPrimaryKey(primaryKey);

		if (auditingEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuditingEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auditingEntry;
	}

	/**
	 * Returns the auditing entry with the primary key or throws a <code>NoSuchAuditingEntryException</code> if it could not be found.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry
	 * @throws NoSuchAuditingEntryException if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry findByPrimaryKey(long auditingId)
		throws NoSuchAuditingEntryException {

		return findByPrimaryKey((Serializable)auditingId);
	}

	/**
	 * Returns the auditing entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry, or <code>null</code> if a auditing entry with the primary key could not be found
	 */
	@Override
	public AuditingEntry fetchByPrimaryKey(long auditingId) {
		return fetchByPrimaryKey((Serializable)auditingId);
	}

	/**
	 * Returns all the auditing entries.
	 *
	 * @return the auditing entries
	 */
	@Override
	public List<AuditingEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of auditing entries
	 */
	@Override
	public List<AuditingEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditing entries
	 */
	@Override
	public List<AuditingEntry> findAll(
		int start, int end,
		OrderByComparator<AuditingEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auditing entries
	 */
	@Override
	public List<AuditingEntry> findAll(
		int start, int end, OrderByComparator<AuditingEntry> orderByComparator,
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

		List<AuditingEntry> list = null;

		if (useFinderCache) {
			list = (List<AuditingEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUDITINGENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITINGENTRY;

				sql = sql.concat(AuditingEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AuditingEntry>)QueryUtil.list(
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
	 * Removes all the auditing entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AuditingEntry auditingEntry : findAll()) {
			remove(auditingEntry);
		}
	}

	/**
	 * Returns the number of auditing entries.
	 *
	 * @return the number of auditing entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUDITINGENTRY);

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
		return "auditingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUDITINGENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuditingEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the auditing entry persistence.
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

		_finderPathWithPaginationFindByPK_Name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPK_Name",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"classPkId", "classPkName"}, true);

		_finderPathWithoutPaginationFindByPK_Name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPK_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"classPkId", "classPkName"}, true);

		_finderPathCountByPK_Name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPK_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"classPkId", "classPkName"}, false);

		_finderPathWithPaginationFindByParent_PK_Name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParent_PK_Name",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"parentPkId", "parentPkName"}, true);

		_finderPathWithoutPaginationFindByParent_PK_Name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent_PK_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parentPkId", "parentPkName"}, true);

		_finderPathCountByParent_PK_Name = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent_PK_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parentPkId", "parentPkName"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setAuditingEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAuditingEntryUtilPersistence(null);

		entityCache.removeCache(AuditingEntryImpl.class.getName());
	}

	private void _setAuditingEntryUtilPersistence(
		AuditingEntryPersistence auditingEntryPersistence) {

		try {
			Field field = AuditingEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, auditingEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DG_AUDITINGPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DG_AUDITINGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DG_AUDITINGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AUDITINGENTRY =
		"SELECT auditingEntry FROM AuditingEntry auditingEntry";

	private static final String _SQL_SELECT_AUDITINGENTRY_WHERE =
		"SELECT auditingEntry FROM AuditingEntry auditingEntry WHERE ";

	private static final String _SQL_COUNT_AUDITINGENTRY =
		"SELECT COUNT(auditingEntry) FROM AuditingEntry auditingEntry";

	private static final String _SQL_COUNT_AUDITINGENTRY_WHERE =
		"SELECT COUNT(auditingEntry) FROM AuditingEntry auditingEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auditingEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AuditingEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AuditingEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuditingEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AuditingEntryModelArgumentsResolver
		_auditingEntryModelArgumentsResolver;

}