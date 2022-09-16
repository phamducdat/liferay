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

import com.dogoo.common.files.manager.service.exception.NoSuchDGDocumentManagerEntryException;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntryTable;
import com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryImpl;
import com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryModelImpl;
import com.dogoo.common.files.manager.service.service.persistence.DGDocumentManagerEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGDocumentManagerEntryUtil;
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
 * The persistence implementation for the dg document manager entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {DGDocumentManagerEntryPersistence.class, BasePersistence.class}
)
public class DGDocumentManagerEntryPersistenceImpl
	extends BasePersistenceImpl<DGDocumentManagerEntry>
	implements DGDocumentManagerEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DGDocumentManagerEntryUtil</code> to access the dg document manager entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DGDocumentManagerEntryImpl.class.getName();

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
	 * Returns all the dg document manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		List<DGDocumentManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGDocumentManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGDocumentManagerEntry dgDocumentManagerEntry : list) {
					if (!uuid.equals(dgDocumentManagerEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

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
				sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGDocumentManagerEntry>)QueryUtil.list(
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
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByUuid_First(
			String uuid,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		List<DGDocumentManagerEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DGDocumentManagerEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry[] findByUuid_PrevAndNext(
			long documentManagerId, String uuid,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		uuid = Objects.toString(uuid, "");

		DGDocumentManagerEntry dgDocumentManagerEntry = findByPrimaryKey(
			documentManagerId);

		Session session = null;

		try {
			session = openSession();

			DGDocumentManagerEntry[] array = new DGDocumentManagerEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dgDocumentManagerEntry, uuid, orderByComparator, true);

			array[1] = dgDocumentManagerEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dgDocumentManagerEntry, uuid, orderByComparator,
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

	protected DGDocumentManagerEntry getByUuid_PrevAndNext(
		Session session, DGDocumentManagerEntry dgDocumentManagerEntry,
		String uuid,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

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
			sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
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
						dgDocumentManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGDocumentManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg document manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DGDocumentManagerEntry dgDocumentManagerEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgDocumentManagerEntry);
		}
	}

	/**
	 * Returns the number of dg document manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

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
		"dgDocumentManagerEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dgDocumentManagerEntry.uuid IS NULL OR dgDocumentManagerEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByUUID_G(
			uuid, groupId);

		if (dgDocumentManagerEntry == null) {
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

			throw new NoSuchDGDocumentManagerEntryException(sb.toString());
		}

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dg document manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByUUID_G(
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

		if (result instanceof DGDocumentManagerEntry) {
			DGDocumentManagerEntry dgDocumentManagerEntry =
				(DGDocumentManagerEntry)result;

			if (!Objects.equals(uuid, dgDocumentManagerEntry.getUuid()) ||
				(groupId != dgDocumentManagerEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

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

				List<DGDocumentManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DGDocumentManagerEntry dgDocumentManagerEntry = list.get(0);

					result = dgDocumentManagerEntry;

					cacheResult(dgDocumentManagerEntry);
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
			return (DGDocumentManagerEntry)result;
		}
	}

	/**
	 * Removes the dg document manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dg document manager entry that was removed
	 */
	@Override
	public DGDocumentManagerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = findByUUID_G(
			uuid, groupId);

		return remove(dgDocumentManagerEntry);
	}

	/**
	 * Returns the number of dg document manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

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
		"dgDocumentManagerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dgDocumentManagerEntry.uuid IS NULL OR dgDocumentManagerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dgDocumentManagerEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		List<DGDocumentManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGDocumentManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGDocumentManagerEntry dgDocumentManagerEntry : list) {
					if (!uuid.equals(dgDocumentManagerEntry.getUuid()) ||
						(companyId != dgDocumentManagerEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

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
				sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DGDocumentManagerEntry>)QueryUtil.list(
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
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		List<DGDocumentManagerEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DGDocumentManagerEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry[] findByUuid_C_PrevAndNext(
			long documentManagerId, String uuid, long companyId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		uuid = Objects.toString(uuid, "");

		DGDocumentManagerEntry dgDocumentManagerEntry = findByPrimaryKey(
			documentManagerId);

		Session session = null;

		try {
			session = openSession();

			DGDocumentManagerEntry[] array = new DGDocumentManagerEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dgDocumentManagerEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = dgDocumentManagerEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dgDocumentManagerEntry, uuid, companyId,
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

	protected DGDocumentManagerEntry getByUuid_C_PrevAndNext(
		Session session, DGDocumentManagerEntry dgDocumentManagerEntry,
		String uuid, long companyId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

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
			sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
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
						dgDocumentManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGDocumentManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg document manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DGDocumentManagerEntry dgDocumentManagerEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgDocumentManagerEntry);
		}
	}

	/**
	 * Returns the number of dg document manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

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
		"dgDocumentManagerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dgDocumentManagerEntry.uuid IS NULL OR dgDocumentManagerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dgDocumentManagerEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPC_;
	private FinderPath _finderPathWithoutPaginationFindByPC_;
	private FinderPath _finderPathCountByPC_;

	/**
	 * Returns all the dg document manager entries where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @return the matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_(String pkCode) {
		return findByPC_(pkCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end) {

		return findByPC_(pkCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return findByPC_(pkCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_(
		String pkCode, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		pkCode = Objects.toString(pkCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPC_;
				finderArgs = new Object[] {pkCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPC_;
			finderArgs = new Object[] {pkCode, start, end, orderByComparator};
		}

		List<DGDocumentManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGDocumentManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGDocumentManagerEntry dgDocumentManagerEntry : list) {
					if (!pkCode.equals(dgDocumentManagerEntry.getPkCode())) {
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

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PC__PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_PC__PKCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPkCode) {
					queryPos.add(pkCode);
				}

				list = (List<DGDocumentManagerEntry>)QueryUtil.list(
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
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPC__First(
			String pkCode,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByPC__First(
			pkCode, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pkCode=");
		sb.append(pkCode);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByPC__First(
		String pkCode,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		List<DGDocumentManagerEntry> list = findByPC_(
			pkCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPC__Last(
			String pkCode,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByPC__Last(
			pkCode, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pkCode=");
		sb.append(pkCode);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByPC__Last(
		String pkCode,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		int count = countByPC_(pkCode);

		if (count == 0) {
			return null;
		}

		List<DGDocumentManagerEntry> list = findByPC_(
			pkCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where pkCode = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param pkCode the pk code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry[] findByPC__PrevAndNext(
			long documentManagerId, String pkCode,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		pkCode = Objects.toString(pkCode, "");

		DGDocumentManagerEntry dgDocumentManagerEntry = findByPrimaryKey(
			documentManagerId);

		Session session = null;

		try {
			session = openSession();

			DGDocumentManagerEntry[] array = new DGDocumentManagerEntryImpl[3];

			array[0] = getByPC__PrevAndNext(
				session, dgDocumentManagerEntry, pkCode, orderByComparator,
				true);

			array[1] = dgDocumentManagerEntry;

			array[2] = getByPC__PrevAndNext(
				session, dgDocumentManagerEntry, pkCode, orderByComparator,
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

	protected DGDocumentManagerEntry getByPC__PrevAndNext(
		Session session, DGDocumentManagerEntry dgDocumentManagerEntry,
		String pkCode,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

		boolean bindPkCode = false;

		if (pkCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PC__PKCODE_3);
		}
		else {
			bindPkCode = true;

			sb.append(_FINDER_COLUMN_PC__PKCODE_2);
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
			sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPkCode) {
			queryPos.add(pkCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgDocumentManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGDocumentManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg document manager entries where pkCode = &#63; from the database.
	 *
	 * @param pkCode the pk code
	 */
	@Override
	public void removeByPC_(String pkCode) {
		for (DGDocumentManagerEntry dgDocumentManagerEntry :
				findByPC_(pkCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgDocumentManagerEntry);
		}
	}

	/**
	 * Returns the number of dg document manager entries where pkCode = &#63;.
	 *
	 * @param pkCode the pk code
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByPC_(String pkCode) {
		pkCode = Objects.toString(pkCode, "");

		FinderPath finderPath = _finderPathCountByPC_;

		Object[] finderArgs = new Object[] {pkCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PC__PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_PC__PKCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPkCode) {
					queryPos.add(pkCode);
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

	private static final String _FINDER_COLUMN_PC__PKCODE_2 =
		"dgDocumentManagerEntry.pkCode = ?";

	private static final String _FINDER_COLUMN_PC__PKCODE_3 =
		"(dgDocumentManagerEntry.pkCode IS NULL OR dgDocumentManagerEntry.pkCode = '')";

	private FinderPath _finderPathWithPaginationFindByPC_PI;
	private FinderPath _finderPathWithoutPaginationFindByPC_PI;
	private FinderPath _finderPathCountByPC_PI;

	/**
	 * Returns all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @return the matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId) {

		return findByPC_PI(
			pkCode, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end) {

		return findByPC_PI(pkCode, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return findByPC_PI(
			pkCode, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPC_PI(
		String pkCode, long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		pkCode = Objects.toString(pkCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPC_PI;
				finderArgs = new Object[] {pkCode, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPC_PI;
			finderArgs = new Object[] {
				pkCode, parentId, start, end, orderByComparator
			};
		}

		List<DGDocumentManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGDocumentManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGDocumentManagerEntry dgDocumentManagerEntry : list) {
					if (!pkCode.equals(dgDocumentManagerEntry.getPkCode()) ||
						(parentId != dgDocumentManagerEntry.getParentId())) {

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

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PC_PI_PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_PC_PI_PKCODE_2);
			}

			sb.append(_FINDER_COLUMN_PC_PI_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPkCode) {
					queryPos.add(pkCode);
				}

				queryPos.add(parentId);

				list = (List<DGDocumentManagerEntry>)QueryUtil.list(
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
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPC_PI_First(
			String pkCode, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByPC_PI_First(
			pkCode, parentId, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pkCode=");
		sb.append(pkCode);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByPC_PI_First(
		String pkCode, long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		List<DGDocumentManagerEntry> list = findByPC_PI(
			pkCode, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPC_PI_Last(
			String pkCode, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByPC_PI_Last(
			pkCode, parentId, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pkCode=");
		sb.append(pkCode);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByPC_PI_Last(
		String pkCode, long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		int count = countByPC_PI(pkCode, parentId);

		if (count == 0) {
			return null;
		}

		List<DGDocumentManagerEntry> list = findByPC_PI(
			pkCode, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry[] findByPC_PI_PrevAndNext(
			long documentManagerId, String pkCode, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		pkCode = Objects.toString(pkCode, "");

		DGDocumentManagerEntry dgDocumentManagerEntry = findByPrimaryKey(
			documentManagerId);

		Session session = null;

		try {
			session = openSession();

			DGDocumentManagerEntry[] array = new DGDocumentManagerEntryImpl[3];

			array[0] = getByPC_PI_PrevAndNext(
				session, dgDocumentManagerEntry, pkCode, parentId,
				orderByComparator, true);

			array[1] = dgDocumentManagerEntry;

			array[2] = getByPC_PI_PrevAndNext(
				session, dgDocumentManagerEntry, pkCode, parentId,
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

	protected DGDocumentManagerEntry getByPC_PI_PrevAndNext(
		Session session, DGDocumentManagerEntry dgDocumentManagerEntry,
		String pkCode, long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

		boolean bindPkCode = false;

		if (pkCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PC_PI_PKCODE_3);
		}
		else {
			bindPkCode = true;

			sb.append(_FINDER_COLUMN_PC_PI_PKCODE_2);
		}

		sb.append(_FINDER_COLUMN_PC_PI_PARENTID_2);

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
			sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPkCode) {
			queryPos.add(pkCode);
		}

		queryPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgDocumentManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGDocumentManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg document manager entries where pkCode = &#63; and parentId = &#63; from the database.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByPC_PI(String pkCode, long parentId) {
		for (DGDocumentManagerEntry dgDocumentManagerEntry :
				findByPC_PI(
					pkCode, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgDocumentManagerEntry);
		}
	}

	/**
	 * Returns the number of dg document manager entries where pkCode = &#63; and parentId = &#63;.
	 *
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByPC_PI(String pkCode, long parentId) {
		pkCode = Objects.toString(pkCode, "");

		FinderPath finderPath = _finderPathCountByPC_PI;

		Object[] finderArgs = new Object[] {pkCode, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PC_PI_PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_PC_PI_PKCODE_2);
			}

			sb.append(_FINDER_COLUMN_PC_PI_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPkCode) {
					queryPos.add(pkCode);
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

	private static final String _FINDER_COLUMN_PC_PI_PKCODE_2 =
		"dgDocumentManagerEntry.pkCode = ? AND ";

	private static final String _FINDER_COLUMN_PC_PI_PKCODE_3 =
		"(dgDocumentManagerEntry.pkCode IS NULL OR dgDocumentManagerEntry.pkCode = '') AND ";

	private static final String _FINDER_COLUMN_PC_PI_PARENTID_2 =
		"dgDocumentManagerEntry.parentId = ?";

	private FinderPath _finderPathFetchByN_T_PC_PI_C_CI;
	private FinderPath _finderPathCountByN_T_PC_PI_C_CI;

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByN_T_PC_PI_C_CI(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId);

		if (dgDocumentManagerEntry == null) {
			StringBundler sb = new StringBundler(14);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append(", type=");
			sb.append(type);

			sb.append(", pkCode=");
			sb.append(pkCode);

			sb.append(", parentId=");
			sb.append(parentId);

			sb.append(", category=");
			sb.append(category);

			sb.append(", creatorId=");
			sb.append(creatorId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGDocumentManagerEntryException(sb.toString());
		}

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId) {

		return fetchByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId, true);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId, boolean useFinderCache) {

		name = Objects.toString(name, "");
		type = Objects.toString(type, "");
		pkCode = Objects.toString(pkCode, "");
		category = Objects.toString(category, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				name, type, pkCode, parentId, category, creatorId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByN_T_PC_PI_C_CI, finderArgs);
		}

		if (result instanceof DGDocumentManagerEntry) {
			DGDocumentManagerEntry dgDocumentManagerEntry =
				(DGDocumentManagerEntry)result;

			if (!Objects.equals(name, dgDocumentManagerEntry.getName()) ||
				!Objects.equals(type, dgDocumentManagerEntry.getType()) ||
				!Objects.equals(pkCode, dgDocumentManagerEntry.getPkCode()) ||
				(parentId != dgDocumentManagerEntry.getParentId()) ||
				!Objects.equals(
					category, dgDocumentManagerEntry.getCategory()) ||
				(creatorId != dgDocumentManagerEntry.getCreatorId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_NAME_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_TYPE_2);
			}

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_PKCODE_2);
			}

			sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_PARENTID_2);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_CATEGORY_2);
			}

			sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindType) {
					queryPos.add(type);
				}

				if (bindPkCode) {
					queryPos.add(pkCode);
				}

				queryPos.add(parentId);

				if (bindCategory) {
					queryPos.add(category);
				}

				queryPos.add(creatorId);

				List<DGDocumentManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByN_T_PC_PI_C_CI, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									name, type, pkCode, parentId, category,
									creatorId
								};
							}

							_log.warn(
								"DGDocumentManagerEntryPersistenceImpl.fetchByN_T_PC_PI_C_CI(String, String, String, long, String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGDocumentManagerEntry dgDocumentManagerEntry = list.get(0);

					result = dgDocumentManagerEntry;

					cacheResult(dgDocumentManagerEntry);
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
			return (DGDocumentManagerEntry)result;
		}
	}

	/**
	 * Removes the dg document manager entry where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63; from the database.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the dg document manager entry that was removed
	 */
	@Override
	public DGDocumentManagerEntry removeByN_T_PC_PI_C_CI(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = findByN_T_PC_PI_C_CI(
			name, type, pkCode, parentId, category, creatorId);

		return remove(dgDocumentManagerEntry);
	}

	/**
	 * Returns the number of dg document manager entries where name = &#63; and type = &#63; and pkCode = &#63; and parentId = &#63; and category = &#63; and creatorId = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @param pkCode the pk code
	 * @param parentId the parent ID
	 * @param category the category
	 * @param creatorId the creator ID
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByN_T_PC_PI_C_CI(
		String name, String type, String pkCode, long parentId, String category,
		long creatorId) {

		name = Objects.toString(name, "");
		type = Objects.toString(type, "");
		pkCode = Objects.toString(pkCode, "");
		category = Objects.toString(category, "");

		FinderPath finderPath = _finderPathCountByN_T_PC_PI_C_CI;

		Object[] finderArgs = new Object[] {
			name, type, pkCode, parentId, category, creatorId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(7);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_NAME_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_TYPE_2);
			}

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_PKCODE_2);
			}

			sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_PARENTID_2);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_CATEGORY_2);
			}

			sb.append(_FINDER_COLUMN_N_T_PC_PI_C_CI_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindType) {
					queryPos.add(type);
				}

				if (bindPkCode) {
					queryPos.add(pkCode);
				}

				queryPos.add(parentId);

				if (bindCategory) {
					queryPos.add(category);
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

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_NAME_2 =
		"dgDocumentManagerEntry.name = ? AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_NAME_3 =
		"(dgDocumentManagerEntry.name IS NULL OR dgDocumentManagerEntry.name = '') AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_TYPE_2 =
		"dgDocumentManagerEntry.type = ? AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_TYPE_3 =
		"(dgDocumentManagerEntry.type IS NULL OR dgDocumentManagerEntry.type = '') AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_PKCODE_2 =
		"dgDocumentManagerEntry.pkCode = ? AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_PKCODE_3 =
		"(dgDocumentManagerEntry.pkCode IS NULL OR dgDocumentManagerEntry.pkCode = '') AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_PARENTID_2 =
		"dgDocumentManagerEntry.parentId = ? AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_CATEGORY_2 =
		"dgDocumentManagerEntry.category = ? AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_CATEGORY_3 =
		"(dgDocumentManagerEntry.category IS NULL OR dgDocumentManagerEntry.category = '') AND ";

	private static final String _FINDER_COLUMN_N_T_PC_PI_C_CI_CREATORID_2 =
		"dgDocumentManagerEntry.creatorId = ?";

	private FinderPath _finderPathFetchByFI_;
	private FinderPath _finderPathCountByFI_;

	/**
	 * Returns the dg document manager entry where fileId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByFI_(long fileId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByFI_(fileId);

		if (dgDocumentManagerEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fileId=");
			sb.append(fileId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGDocumentManagerEntryException(sb.toString());
		}

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry where fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByFI_(long fileId) {
		return fetchByFI_(fileId, true);
	}

	/**
	 * Returns the dg document manager entry where fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByFI_(
		long fileId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fileId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByFI_, finderArgs);
		}

		if (result instanceof DGDocumentManagerEntry) {
			DGDocumentManagerEntry dgDocumentManagerEntry =
				(DGDocumentManagerEntry)result;

			if (fileId != dgDocumentManagerEntry.getFileId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_FI__FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileId);

				List<DGDocumentManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFI_, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fileId};
							}

							_log.warn(
								"DGDocumentManagerEntryPersistenceImpl.fetchByFI_(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGDocumentManagerEntry dgDocumentManagerEntry = list.get(0);

					result = dgDocumentManagerEntry;

					cacheResult(dgDocumentManagerEntry);
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
			return (DGDocumentManagerEntry)result;
		}
	}

	/**
	 * Removes the dg document manager entry where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @return the dg document manager entry that was removed
	 */
	@Override
	public DGDocumentManagerEntry removeByFI_(long fileId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = findByFI_(fileId);

		return remove(dgDocumentManagerEntry);
	}

	/**
	 * Returns the number of dg document manager entries where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByFI_(long fileId) {
		FinderPath finderPath = _finderPathCountByFI_;

		Object[] finderArgs = new Object[] {fileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_FI__FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_FI__FILEID_2 =
		"dgDocumentManagerEntry.fileId = ?";

	private FinderPath _finderPathWithPaginationFindByPI_;
	private FinderPath _finderPathWithoutPaginationFindByPI_;
	private FinderPath _finderPathCountByPI_;

	/**
	 * Returns all the dg document manager entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPI_(long parentId) {
		return findByPI_(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end) {

		return findByPI_(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return findByPI_(parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findByPI_(
		long parentId, int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPI_;
				finderArgs = new Object[] {parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPI_;
			finderArgs = new Object[] {parentId, start, end, orderByComparator};
		}

		List<DGDocumentManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGDocumentManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DGDocumentManagerEntry dgDocumentManagerEntry : list) {
					if (parentId != dgDocumentManagerEntry.getParentId()) {
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

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PI__PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				list = (List<DGDocumentManagerEntry>)QueryUtil.list(
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
	 * Returns the first dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPI__First(
			long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByPI__First(
			parentId, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByPI__First(
		long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		List<DGDocumentManagerEntry> list = findByPI_(
			parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPI__Last(
			long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByPI__Last(
			parentId, orderByComparator);

		if (dgDocumentManagerEntry != null) {
			return dgDocumentManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchDGDocumentManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByPI__Last(
		long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		int count = countByPI_(parentId);

		if (count == 0) {
			return null;
		}

		List<DGDocumentManagerEntry> list = findByPI_(
			parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dg document manager entries before and after the current dg document manager entry in the ordered set where parentId = &#63;.
	 *
	 * @param documentManagerId the primary key of the current dg document manager entry
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry[] findByPI__PrevAndNext(
			long documentManagerId, long parentId,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = findByPrimaryKey(
			documentManagerId);

		Session session = null;

		try {
			session = openSession();

			DGDocumentManagerEntry[] array = new DGDocumentManagerEntryImpl[3];

			array[0] = getByPI__PrevAndNext(
				session, dgDocumentManagerEntry, parentId, orderByComparator,
				true);

			array[1] = dgDocumentManagerEntry;

			array[2] = getByPI__PrevAndNext(
				session, dgDocumentManagerEntry, parentId, orderByComparator,
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

	protected DGDocumentManagerEntry getByPI__PrevAndNext(
		Session session, DGDocumentManagerEntry dgDocumentManagerEntry,
		long parentId,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PI__PARENTID_2);

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
			sb.append(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgDocumentManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DGDocumentManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dg document manager entries where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByPI_(long parentId) {
		for (DGDocumentManagerEntry dgDocumentManagerEntry :
				findByPI_(
					parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgDocumentManagerEntry);
		}
	}

	/**
	 * Returns the number of dg document manager entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByPI_(long parentId) {
		FinderPath finderPath = _finderPathCountByPI_;

		Object[] finderArgs = new Object[] {parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PI__PARENTID_2);

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

	private static final String _FINDER_COLUMN_PI__PARENTID_2 =
		"dgDocumentManagerEntry.parentId = ?";

	private FinderPath _finderPathFetchByN_PI;
	private FinderPath _finderPathCountByN_PI;

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByN_PI(String name, long parentId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByN_PI(
			name, parentId);

		if (dgDocumentManagerEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append(", parentId=");
			sb.append(parentId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGDocumentManagerEntryException(sb.toString());
		}

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByN_PI(String name, long parentId) {
		return fetchByN_PI(name, parentId, true);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByN_PI(
		String name, long parentId, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name, parentId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByN_PI, finderArgs);
		}

		if (result instanceof DGDocumentManagerEntry) {
			DGDocumentManagerEntry dgDocumentManagerEntry =
				(DGDocumentManagerEntry)result;

			if (!Objects.equals(name, dgDocumentManagerEntry.getName()) ||
				(parentId != dgDocumentManagerEntry.getParentId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_N_PI_NAME_2);
			}

			sb.append(_FINDER_COLUMN_N_PI_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(parentId);

				List<DGDocumentManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByN_PI, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name, parentId};
							}

							_log.warn(
								"DGDocumentManagerEntryPersistenceImpl.fetchByN_PI(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGDocumentManagerEntry dgDocumentManagerEntry = list.get(0);

					result = dgDocumentManagerEntry;

					cacheResult(dgDocumentManagerEntry);
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
			return (DGDocumentManagerEntry)result;
		}
	}

	/**
	 * Removes the dg document manager entry where name = &#63; and parentId = &#63; from the database.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the dg document manager entry that was removed
	 */
	@Override
	public DGDocumentManagerEntry removeByN_PI(String name, long parentId)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = findByN_PI(
			name, parentId);

		return remove(dgDocumentManagerEntry);
	}

	/**
	 * Returns the number of dg document manager entries where name = &#63; and parentId = &#63;.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByN_PI(String name, long parentId) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByN_PI;

		Object[] finderArgs = new Object[] {name, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_N_PI_NAME_2);
			}

			sb.append(_FINDER_COLUMN_N_PI_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_N_PI_NAME_2 =
		"dgDocumentManagerEntry.name = ? AND ";

	private static final String _FINDER_COLUMN_N_PI_NAME_3 =
		"(dgDocumentManagerEntry.name IS NULL OR dgDocumentManagerEntry.name = '') AND ";

	private static final String _FINDER_COLUMN_N_PI_PARENTID_2 =
		"dgDocumentManagerEntry.parentId = ?";

	private FinderPath _finderPathFetchByN_PI_FE_PC;
	private FinderPath _finderPathCountByN_PI_FE_PC;

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByN_PI_FE_PC(
			String name, long parentId, String fileExtension, String pkCode)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByN_PI_FE_PC(
			name, parentId, fileExtension, pkCode);

		if (dgDocumentManagerEntry == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append(", parentId=");
			sb.append(parentId);

			sb.append(", fileExtension=");
			sb.append(fileExtension);

			sb.append(", pkCode=");
			sb.append(pkCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDGDocumentManagerEntryException(sb.toString());
		}

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode) {

		return fetchByN_PI_FE_PC(name, parentId, fileExtension, pkCode, true);
	}

	/**
	 * Returns the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode,
		boolean useFinderCache) {

		name = Objects.toString(name, "");
		fileExtension = Objects.toString(fileExtension, "");
		pkCode = Objects.toString(pkCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name, parentId, fileExtension, pkCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByN_PI_FE_PC, finderArgs);
		}

		if (result instanceof DGDocumentManagerEntry) {
			DGDocumentManagerEntry dgDocumentManagerEntry =
				(DGDocumentManagerEntry)result;

			if (!Objects.equals(name, dgDocumentManagerEntry.getName()) ||
				(parentId != dgDocumentManagerEntry.getParentId()) ||
				!Objects.equals(
					fileExtension, dgDocumentManagerEntry.getFileExtension()) ||
				!Objects.equals(pkCode, dgDocumentManagerEntry.getPkCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_FE_PC_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_N_PI_FE_PC_NAME_2);
			}

			sb.append(_FINDER_COLUMN_N_PI_FE_PC_PARENTID_2);

			boolean bindFileExtension = false;

			if (fileExtension.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_FE_PC_FILEEXTENSION_3);
			}
			else {
				bindFileExtension = true;

				sb.append(_FINDER_COLUMN_N_PI_FE_PC_FILEEXTENSION_2);
			}

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_FE_PC_PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_N_PI_FE_PC_PKCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(parentId);

				if (bindFileExtension) {
					queryPos.add(fileExtension);
				}

				if (bindPkCode) {
					queryPos.add(pkCode);
				}

				List<DGDocumentManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByN_PI_FE_PC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									name, parentId, fileExtension, pkCode
								};
							}

							_log.warn(
								"DGDocumentManagerEntryPersistenceImpl.fetchByN_PI_FE_PC(String, long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGDocumentManagerEntry dgDocumentManagerEntry = list.get(0);

					result = dgDocumentManagerEntry;

					cacheResult(dgDocumentManagerEntry);
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
			return (DGDocumentManagerEntry)result;
		}
	}

	/**
	 * Removes the dg document manager entry where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63; from the database.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the dg document manager entry that was removed
	 */
	@Override
	public DGDocumentManagerEntry removeByN_PI_FE_PC(
			String name, long parentId, String fileExtension, String pkCode)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = findByN_PI_FE_PC(
			name, parentId, fileExtension, pkCode);

		return remove(dgDocumentManagerEntry);
	}

	/**
	 * Returns the number of dg document manager entries where name = &#63; and parentId = &#63; and fileExtension = &#63; and pkCode = &#63;.
	 *
	 * @param name the name
	 * @param parentId the parent ID
	 * @param fileExtension the file extension
	 * @param pkCode the pk code
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByN_PI_FE_PC(
		String name, long parentId, String fileExtension, String pkCode) {

		name = Objects.toString(name, "");
		fileExtension = Objects.toString(fileExtension, "");
		pkCode = Objects.toString(pkCode, "");

		FinderPath finderPath = _finderPathCountByN_PI_FE_PC;

		Object[] finderArgs = new Object[] {
			name, parentId, fileExtension, pkCode
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_FE_PC_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_N_PI_FE_PC_NAME_2);
			}

			sb.append(_FINDER_COLUMN_N_PI_FE_PC_PARENTID_2);

			boolean bindFileExtension = false;

			if (fileExtension.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_FE_PC_FILEEXTENSION_3);
			}
			else {
				bindFileExtension = true;

				sb.append(_FINDER_COLUMN_N_PI_FE_PC_FILEEXTENSION_2);
			}

			boolean bindPkCode = false;

			if (pkCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_N_PI_FE_PC_PKCODE_3);
			}
			else {
				bindPkCode = true;

				sb.append(_FINDER_COLUMN_N_PI_FE_PC_PKCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(parentId);

				if (bindFileExtension) {
					queryPos.add(fileExtension);
				}

				if (bindPkCode) {
					queryPos.add(pkCode);
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

	private static final String _FINDER_COLUMN_N_PI_FE_PC_NAME_2 =
		"dgDocumentManagerEntry.name = ? AND ";

	private static final String _FINDER_COLUMN_N_PI_FE_PC_NAME_3 =
		"(dgDocumentManagerEntry.name IS NULL OR dgDocumentManagerEntry.name = '') AND ";

	private static final String _FINDER_COLUMN_N_PI_FE_PC_PARENTID_2 =
		"dgDocumentManagerEntry.parentId = ? AND ";

	private static final String _FINDER_COLUMN_N_PI_FE_PC_FILEEXTENSION_2 =
		"dgDocumentManagerEntry.fileExtension = ? AND ";

	private static final String _FINDER_COLUMN_N_PI_FE_PC_FILEEXTENSION_3 =
		"(dgDocumentManagerEntry.fileExtension IS NULL OR dgDocumentManagerEntry.fileExtension = '') AND ";

	private static final String _FINDER_COLUMN_N_PI_FE_PC_PKCODE_2 =
		"dgDocumentManagerEntry.pkCode = ?";

	private static final String _FINDER_COLUMN_N_PI_FE_PC_PKCODE_3 =
		"(dgDocumentManagerEntry.pkCode IS NULL OR dgDocumentManagerEntry.pkCode = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (dgDocumentManagerEntry == null) {
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

			throw new NoSuchDGDocumentManagerEntryException(sb.toString());
		}

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByC_ERC(
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

		if (result instanceof DGDocumentManagerEntry) {
			DGDocumentManagerEntry dgDocumentManagerEntry =
				(DGDocumentManagerEntry)result;

			if ((companyId != dgDocumentManagerEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dgDocumentManagerEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE);

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

				List<DGDocumentManagerEntry> list = query.list();

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
								"DGDocumentManagerEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DGDocumentManagerEntry dgDocumentManagerEntry = list.get(0);

					result = dgDocumentManagerEntry;

					cacheResult(dgDocumentManagerEntry);
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
			return (DGDocumentManagerEntry)result;
		}
	}

	/**
	 * Removes the dg document manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dg document manager entry that was removed
	 */
	@Override
	public DGDocumentManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(dgDocumentManagerEntry);
	}

	/**
	 * Returns the number of dg document manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dg document manager entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE);

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
		"dgDocumentManagerEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dgDocumentManagerEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dgDocumentManagerEntry.externalReferenceCode IS NULL OR dgDocumentManagerEntry.externalReferenceCode = '')";

	public DGDocumentManagerEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("path", "path_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DGDocumentManagerEntry.class);

		setModelImplClass(DGDocumentManagerEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DGDocumentManagerEntryTable.INSTANCE);
	}

	/**
	 * Caches the dg document manager entry in the entity cache if it is enabled.
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 */
	@Override
	public void cacheResult(DGDocumentManagerEntry dgDocumentManagerEntry) {
		entityCache.putResult(
			DGDocumentManagerEntryImpl.class,
			dgDocumentManagerEntry.getPrimaryKey(), dgDocumentManagerEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dgDocumentManagerEntry.getUuid(),
				dgDocumentManagerEntry.getGroupId()
			},
			dgDocumentManagerEntry);

		finderCache.putResult(
			_finderPathFetchByN_T_PC_PI_C_CI,
			new Object[] {
				dgDocumentManagerEntry.getName(),
				dgDocumentManagerEntry.getType(),
				dgDocumentManagerEntry.getPkCode(),
				dgDocumentManagerEntry.getParentId(),
				dgDocumentManagerEntry.getCategory(),
				dgDocumentManagerEntry.getCreatorId()
			},
			dgDocumentManagerEntry);

		finderCache.putResult(
			_finderPathFetchByFI_,
			new Object[] {dgDocumentManagerEntry.getFileId()},
			dgDocumentManagerEntry);

		finderCache.putResult(
			_finderPathFetchByN_PI,
			new Object[] {
				dgDocumentManagerEntry.getName(),
				dgDocumentManagerEntry.getParentId()
			},
			dgDocumentManagerEntry);

		finderCache.putResult(
			_finderPathFetchByN_PI_FE_PC,
			new Object[] {
				dgDocumentManagerEntry.getName(),
				dgDocumentManagerEntry.getParentId(),
				dgDocumentManagerEntry.getFileExtension(),
				dgDocumentManagerEntry.getPkCode()
			},
			dgDocumentManagerEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dgDocumentManagerEntry.getCompanyId(),
				dgDocumentManagerEntry.getExternalReferenceCode()
			},
			dgDocumentManagerEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dg document manager entries in the entity cache if it is enabled.
	 *
	 * @param dgDocumentManagerEntries the dg document manager entries
	 */
	@Override
	public void cacheResult(
		List<DGDocumentManagerEntry> dgDocumentManagerEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgDocumentManagerEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DGDocumentManagerEntry dgDocumentManagerEntry :
				dgDocumentManagerEntries) {

			if (entityCache.getResult(
					DGDocumentManagerEntryImpl.class,
					dgDocumentManagerEntry.getPrimaryKey()) == null) {

				cacheResult(dgDocumentManagerEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dg document manager entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DGDocumentManagerEntryImpl.class);

		finderCache.clearCache(DGDocumentManagerEntryImpl.class);
	}

	/**
	 * Clears the cache for the dg document manager entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DGDocumentManagerEntry dgDocumentManagerEntry) {
		entityCache.removeResult(
			DGDocumentManagerEntryImpl.class, dgDocumentManagerEntry);
	}

	@Override
	public void clearCache(
		List<DGDocumentManagerEntry> dgDocumentManagerEntries) {

		for (DGDocumentManagerEntry dgDocumentManagerEntry :
				dgDocumentManagerEntries) {

			entityCache.removeResult(
				DGDocumentManagerEntryImpl.class, dgDocumentManagerEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DGDocumentManagerEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DGDocumentManagerEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DGDocumentManagerEntryModelImpl dgDocumentManagerEntryModelImpl) {

		Object[] args = new Object[] {
			dgDocumentManagerEntryModelImpl.getUuid(),
			dgDocumentManagerEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dgDocumentManagerEntryModelImpl);

		args = new Object[] {
			dgDocumentManagerEntryModelImpl.getName(),
			dgDocumentManagerEntryModelImpl.getType(),
			dgDocumentManagerEntryModelImpl.getPkCode(),
			dgDocumentManagerEntryModelImpl.getParentId(),
			dgDocumentManagerEntryModelImpl.getCategory(),
			dgDocumentManagerEntryModelImpl.getCreatorId()
		};

		finderCache.putResult(
			_finderPathCountByN_T_PC_PI_C_CI, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByN_T_PC_PI_C_CI, args,
			dgDocumentManagerEntryModelImpl);

		args = new Object[] {dgDocumentManagerEntryModelImpl.getFileId()};

		finderCache.putResult(_finderPathCountByFI_, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFI_, args, dgDocumentManagerEntryModelImpl);

		args = new Object[] {
			dgDocumentManagerEntryModelImpl.getName(),
			dgDocumentManagerEntryModelImpl.getParentId()
		};

		finderCache.putResult(_finderPathCountByN_PI, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByN_PI, args, dgDocumentManagerEntryModelImpl);

		args = new Object[] {
			dgDocumentManagerEntryModelImpl.getName(),
			dgDocumentManagerEntryModelImpl.getParentId(),
			dgDocumentManagerEntryModelImpl.getFileExtension(),
			dgDocumentManagerEntryModelImpl.getPkCode()
		};

		finderCache.putResult(
			_finderPathCountByN_PI_FE_PC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByN_PI_FE_PC, args,
			dgDocumentManagerEntryModelImpl);

		args = new Object[] {
			dgDocumentManagerEntryModelImpl.getCompanyId(),
			dgDocumentManagerEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, dgDocumentManagerEntryModelImpl);
	}

	/**
	 * Creates a new dg document manager entry with the primary key. Does not add the dg document manager entry to the database.
	 *
	 * @param documentManagerId the primary key for the new dg document manager entry
	 * @return the new dg document manager entry
	 */
	@Override
	public DGDocumentManagerEntry create(long documentManagerId) {
		DGDocumentManagerEntry dgDocumentManagerEntry =
			new DGDocumentManagerEntryImpl();

		dgDocumentManagerEntry.setNew(true);
		dgDocumentManagerEntry.setPrimaryKey(documentManagerId);

		String uuid = PortalUUIDUtil.generate();

		dgDocumentManagerEntry.setUuid(uuid);

		dgDocumentManagerEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgDocumentManagerEntry;
	}

	/**
	 * Removes the dg document manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry that was removed
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry remove(long documentManagerId)
		throws NoSuchDGDocumentManagerEntryException {

		return remove((Serializable)documentManagerId);
	}

	/**
	 * Removes the dg document manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dg document manager entry
	 * @return the dg document manager entry that was removed
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry remove(Serializable primaryKey)
		throws NoSuchDGDocumentManagerEntryException {

		Session session = null;

		try {
			session = openSession();

			DGDocumentManagerEntry dgDocumentManagerEntry =
				(DGDocumentManagerEntry)session.get(
					DGDocumentManagerEntryImpl.class, primaryKey);

			if (dgDocumentManagerEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDGDocumentManagerEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgDocumentManagerEntry);
		}
		catch (NoSuchDGDocumentManagerEntryException noSuchEntityException) {
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
	protected DGDocumentManagerEntry removeImpl(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgDocumentManagerEntry)) {
				dgDocumentManagerEntry = (DGDocumentManagerEntry)session.get(
					DGDocumentManagerEntryImpl.class,
					dgDocumentManagerEntry.getPrimaryKeyObj());
			}

			if (dgDocumentManagerEntry != null) {
				session.delete(dgDocumentManagerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgDocumentManagerEntry != null) {
			clearCache(dgDocumentManagerEntry);
		}

		return dgDocumentManagerEntry;
	}

	@Override
	public DGDocumentManagerEntry updateImpl(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		boolean isNew = dgDocumentManagerEntry.isNew();

		if (!(dgDocumentManagerEntry instanceof
				DGDocumentManagerEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgDocumentManagerEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgDocumentManagerEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgDocumentManagerEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DGDocumentManagerEntry implementation " +
					dgDocumentManagerEntry.getClass());
		}

		DGDocumentManagerEntryModelImpl dgDocumentManagerEntryModelImpl =
			(DGDocumentManagerEntryModelImpl)dgDocumentManagerEntry;

		if (Validator.isNull(dgDocumentManagerEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dgDocumentManagerEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgDocumentManagerEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgDocumentManagerEntry.setCreateDate(date);
			}
			else {
				dgDocumentManagerEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgDocumentManagerEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgDocumentManagerEntry.setModifiedDate(date);
			}
			else {
				dgDocumentManagerEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgDocumentManagerEntry);
			}
			else {
				dgDocumentManagerEntry = (DGDocumentManagerEntry)session.merge(
					dgDocumentManagerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DGDocumentManagerEntryImpl.class, dgDocumentManagerEntryModelImpl,
			false, true);

		cacheUniqueFindersCache(dgDocumentManagerEntryModelImpl);

		if (isNew) {
			dgDocumentManagerEntry.setNew(false);
		}

		dgDocumentManagerEntry.resetOriginalValues();

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dg document manager entry
	 * @return the dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDGDocumentManagerEntryException {

		DGDocumentManagerEntry dgDocumentManagerEntry = fetchByPrimaryKey(
			primaryKey);

		if (dgDocumentManagerEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDGDocumentManagerEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgDocumentManagerEntry;
	}

	/**
	 * Returns the dg document manager entry with the primary key or throws a <code>NoSuchDGDocumentManagerEntryException</code> if it could not be found.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry
	 * @throws NoSuchDGDocumentManagerEntryException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry findByPrimaryKey(long documentManagerId)
		throws NoSuchDGDocumentManagerEntryException {

		return findByPrimaryKey((Serializable)documentManagerId);
	}

	/**
	 * Returns the dg document manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry, or <code>null</code> if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public DGDocumentManagerEntry fetchByPrimaryKey(long documentManagerId) {
		return fetchByPrimaryKey((Serializable)documentManagerId);
	}

	/**
	 * Returns all the dg document manager entries.
	 *
	 * @return the dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dg document manager entries
	 */
	@Override
	public List<DGDocumentManagerEntry> findAll(
		int start, int end,
		OrderByComparator<DGDocumentManagerEntry> orderByComparator,
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

		List<DGDocumentManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<DGDocumentManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGDOCUMENTMANAGERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGDOCUMENTMANAGERENTRY;

				sql = sql.concat(DGDocumentManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DGDocumentManagerEntry>)QueryUtil.list(
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
	 * Removes all the dg document manager entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DGDocumentManagerEntry dgDocumentManagerEntry : findAll()) {
			remove(dgDocumentManagerEntry);
		}
	}

	/**
	 * Returns the number of dg document manager entries.
	 *
	 * @return the number of dg document manager entries
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
					_SQL_COUNT_DGDOCUMENTMANAGERENTRY);

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
		return "documentManagerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGDOCUMENTMANAGERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DGDocumentManagerEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dg document manager entry persistence.
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

		_finderPathWithPaginationFindByPC_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPC_",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"pkCode"}, true);

		_finderPathWithoutPaginationFindByPC_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPC_",
			new String[] {String.class.getName()}, new String[] {"pkCode"},
			true);

		_finderPathCountByPC_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPC_",
			new String[] {String.class.getName()}, new String[] {"pkCode"},
			false);

		_finderPathWithPaginationFindByPC_PI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPC_PI",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"pkCode", "parentId"}, true);

		_finderPathWithoutPaginationFindByPC_PI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPC_PI",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"pkCode", "parentId"}, true);

		_finderPathCountByPC_PI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPC_PI",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"pkCode", "parentId"}, false);

		_finderPathFetchByN_T_PC_PI_C_CI = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByN_T_PC_PI_C_CI",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {
				"name", "type_", "pkCode", "parentId", "category", "creatorId"
			},
			true);

		_finderPathCountByN_T_PC_PI_C_CI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_T_PC_PI_C_CI",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {
				"name", "type_", "pkCode", "parentId", "category", "creatorId"
			},
			false);

		_finderPathFetchByFI_ = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFI_",
			new String[] {Long.class.getName()}, new String[] {"fileId"}, true);

		_finderPathCountByFI_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFI_",
			new String[] {Long.class.getName()}, new String[] {"fileId"},
			false);

		_finderPathWithPaginationFindByPI_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPI_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentId"}, true);

		_finderPathWithoutPaginationFindByPI_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPI_",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			true);

		_finderPathCountByPI_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPI_",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			false);

		_finderPathFetchByN_PI = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByN_PI",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"name", "parentId"}, true);

		_finderPathCountByN_PI = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_PI",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"name", "parentId"}, false);

		_finderPathFetchByN_PI_FE_PC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByN_PI_FE_PC",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"name", "parentId", "fileExtension", "pkCode"}, true);

		_finderPathCountByN_PI_FE_PC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_PI_FE_PC",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"name", "parentId", "fileExtension", "pkCode"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDGDocumentManagerEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDGDocumentManagerEntryUtilPersistence(null);

		entityCache.removeCache(DGDocumentManagerEntryImpl.class.getName());
	}

	private void _setDGDocumentManagerEntryUtilPersistence(
		DGDocumentManagerEntryPersistence dgDocumentManagerEntryPersistence) {

		try {
			Field field = DGDocumentManagerEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgDocumentManagerEntryPersistence);
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

	private static final String _SQL_SELECT_DGDOCUMENTMANAGERENTRY =
		"SELECT dgDocumentManagerEntry FROM DGDocumentManagerEntry dgDocumentManagerEntry";

	private static final String _SQL_SELECT_DGDOCUMENTMANAGERENTRY_WHERE =
		"SELECT dgDocumentManagerEntry FROM DGDocumentManagerEntry dgDocumentManagerEntry WHERE ";

	private static final String _SQL_COUNT_DGDOCUMENTMANAGERENTRY =
		"SELECT COUNT(dgDocumentManagerEntry) FROM DGDocumentManagerEntry dgDocumentManagerEntry";

	private static final String _SQL_COUNT_DGDOCUMENTMANAGERENTRY_WHERE =
		"SELECT COUNT(dgDocumentManagerEntry) FROM DGDocumentManagerEntry dgDocumentManagerEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgDocumentManagerEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DGDocumentManagerEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DGDocumentManagerEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DGDocumentManagerEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "path"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DGDocumentManagerEntryModelArgumentsResolver
		_dgDocumentManagerEntryModelArgumentsResolver;

}