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

package com.dogoo.contact.service.service.persistence.impl;

import com.dogoo.contact.service.exception.NoSuchPhoneEntryException;
import com.dogoo.contact.service.model.PhoneEntry;
import com.dogoo.contact.service.model.PhoneEntryTable;
import com.dogoo.contact.service.model.impl.PhoneEntryImpl;
import com.dogoo.contact.service.model.impl.PhoneEntryModelImpl;
import com.dogoo.contact.service.service.persistence.PhoneEntryPersistence;
import com.dogoo.contact.service.service.persistence.PhoneEntryUtil;
import com.dogoo.contact.service.service.persistence.impl.constants.CNTPersistenceConstants;

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
 * The persistence implementation for the phone entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PhoneEntryPersistence.class, BasePersistence.class})
public class PhoneEntryPersistenceImpl
	extends BasePersistenceImpl<PhoneEntry> implements PhoneEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhoneEntryUtil</code> to access the phone entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhoneEntryImpl.class.getName();

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
	 * Returns all the phone entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator,
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

		List<PhoneEntry> list = null;

		if (useFinderCache) {
			list = (List<PhoneEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PhoneEntry phoneEntry : list) {
					if (!uuid.equals(phoneEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

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
				sb.append(PhoneEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PhoneEntry>)QueryUtil.list(
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
	 * Returns the first phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByUuid_First(
			String uuid, OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByUuid_First(uuid, orderByComparator);

		if (phoneEntry != null) {
			return phoneEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPhoneEntryException(sb.toString());
	}

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByUuid_First(
		String uuid, OrderByComparator<PhoneEntry> orderByComparator) {

		List<PhoneEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByUuid_Last(
			String uuid, OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (phoneEntry != null) {
			return phoneEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPhoneEntryException(sb.toString());
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByUuid_Last(
		String uuid, OrderByComparator<PhoneEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PhoneEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where uuid = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry[] findByUuid_PrevAndNext(
			long phoneId, String uuid,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		uuid = Objects.toString(uuid, "");

		PhoneEntry phoneEntry = findByPrimaryKey(phoneId);

		Session session = null;

		try {
			session = openSession();

			PhoneEntry[] array = new PhoneEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, phoneEntry, uuid, orderByComparator, true);

			array[1] = phoneEntry;

			array[2] = getByUuid_PrevAndNext(
				session, phoneEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhoneEntry getByUuid_PrevAndNext(
		Session session, PhoneEntry phoneEntry, String uuid,
		OrderByComparator<PhoneEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

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
			sb.append(PhoneEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(phoneEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhoneEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phone entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PhoneEntry phoneEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(phoneEntry);
		}
	}

	/**
	 * Returns the number of phone entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching phone entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PHONEENTRY_WHERE);

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
		"phoneEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(phoneEntry.uuid IS NULL OR phoneEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByUUID_G(uuid, groupId);

		if (phoneEntry == null) {
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

			throw new NoSuchPhoneEntryException(sb.toString());
		}

		return phoneEntry;
	}

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the phone entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByUUID_G(
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

		if (result instanceof PhoneEntry) {
			PhoneEntry phoneEntry = (PhoneEntry)result;

			if (!Objects.equals(uuid, phoneEntry.getUuid()) ||
				(groupId != phoneEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

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

				List<PhoneEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PhoneEntry phoneEntry = list.get(0);

					result = phoneEntry;

					cacheResult(phoneEntry);
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
			return (PhoneEntry)result;
		}
	}

	/**
	 * Removes the phone entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the phone entry that was removed
	 */
	@Override
	public PhoneEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = findByUUID_G(uuid, groupId);

		return remove(phoneEntry);
	}

	/**
	 * Returns the number of phone entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching phone entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHONEENTRY_WHERE);

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
		"phoneEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(phoneEntry.uuid IS NULL OR phoneEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"phoneEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator,
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

		List<PhoneEntry> list = null;

		if (useFinderCache) {
			list = (List<PhoneEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PhoneEntry phoneEntry : list) {
					if (!uuid.equals(phoneEntry.getUuid()) ||
						(companyId != phoneEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

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
				sb.append(PhoneEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PhoneEntry>)QueryUtil.list(
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
	 * Returns the first phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (phoneEntry != null) {
			return phoneEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPhoneEntryException(sb.toString());
	}

	/**
	 * Returns the first phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		List<PhoneEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (phoneEntry != null) {
			return phoneEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPhoneEntryException(sb.toString());
	}

	/**
	 * Returns the last phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PhoneEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry[] findByUuid_C_PrevAndNext(
			long phoneId, String uuid, long companyId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		uuid = Objects.toString(uuid, "");

		PhoneEntry phoneEntry = findByPrimaryKey(phoneId);

		Session session = null;

		try {
			session = openSession();

			PhoneEntry[] array = new PhoneEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, phoneEntry, uuid, companyId, orderByComparator, true);

			array[1] = phoneEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, phoneEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhoneEntry getByUuid_C_PrevAndNext(
		Session session, PhoneEntry phoneEntry, String uuid, long companyId,
		OrderByComparator<PhoneEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

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
			sb.append(PhoneEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(phoneEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhoneEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phone entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PhoneEntry phoneEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(phoneEntry);
		}
	}

	/**
	 * Returns the number of phone entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching phone entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHONEENTRY_WHERE);

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
		"phoneEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(phoneEntry.uuid IS NULL OR phoneEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"phoneEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_C;
	private FinderPath _finderPathWithoutPaginationFindByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByC_C(long customerId, long contactId) {
		return findByC_C(
			customerId, contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end) {

		return findByC_C(customerId, contactId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return findByC_C(
			customerId, contactId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phone entries
	 */
	@Override
	public List<PhoneEntry> findByC_C(
		long customerId, long contactId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_C;
				finderArgs = new Object[] {customerId, contactId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_C;
			finderArgs = new Object[] {
				customerId, contactId, start, end, orderByComparator
			};
		}

		List<PhoneEntry> list = null;

		if (useFinderCache) {
			list = (List<PhoneEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PhoneEntry phoneEntry : list) {
					if ((customerId != phoneEntry.getCustomerId()) ||
						(contactId != phoneEntry.getContactId())) {

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

			sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PhoneEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(contactId);

				list = (List<PhoneEntry>)QueryUtil.list(
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
	 * Returns the first phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByC_C_First(
			long customerId, long contactId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByC_C_First(
			customerId, contactId, orderByComparator);

		if (phoneEntry != null) {
			return phoneEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", contactId=");
		sb.append(contactId);

		sb.append("}");

		throw new NoSuchPhoneEntryException(sb.toString());
	}

	/**
	 * Returns the first phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_C_First(
		long customerId, long contactId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		List<PhoneEntry> list = findByC_C(
			customerId, contactId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByC_C_Last(
			long customerId, long contactId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByC_C_Last(
			customerId, contactId, orderByComparator);

		if (phoneEntry != null) {
			return phoneEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", contactId=");
		sb.append(contactId);

		sb.append("}");

		throw new NoSuchPhoneEntryException(sb.toString());
	}

	/**
	 * Returns the last phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_C_Last(
		long customerId, long contactId,
		OrderByComparator<PhoneEntry> orderByComparator) {

		int count = countByC_C(customerId, contactId);

		if (count == 0) {
			return null;
		}

		List<PhoneEntry> list = findByC_C(
			customerId, contactId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phone entries before and after the current phone entry in the ordered set where customerId = &#63; and contactId = &#63;.
	 *
	 * @param phoneId the primary key of the current phone entry
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry[] findByC_C_PrevAndNext(
			long phoneId, long customerId, long contactId,
			OrderByComparator<PhoneEntry> orderByComparator)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = findByPrimaryKey(phoneId);

		Session session = null;

		try {
			session = openSession();

			PhoneEntry[] array = new PhoneEntryImpl[3];

			array[0] = getByC_C_PrevAndNext(
				session, phoneEntry, customerId, contactId, orderByComparator,
				true);

			array[1] = phoneEntry;

			array[2] = getByC_C_PrevAndNext(
				session, phoneEntry, customerId, contactId, orderByComparator,
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

	protected PhoneEntry getByC_C_PrevAndNext(
		Session session, PhoneEntry phoneEntry, long customerId, long contactId,
		OrderByComparator<PhoneEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_C_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_C_CONTACTID_2);

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
			sb.append(PhoneEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(contactId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(phoneEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhoneEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phone entries where customerId = &#63; and contactId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 */
	@Override
	public void removeByC_C(long customerId, long contactId) {
		for (PhoneEntry phoneEntry :
				findByC_C(
					customerId, contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(phoneEntry);
		}
	}

	/**
	 * Returns the number of phone entries where customerId = &#63; and contactId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param contactId the contact ID
	 * @return the number of matching phone entries
	 */
	@Override
	public int countByC_C(long customerId, long contactId) {
		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {customerId, contactId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHONEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_C_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_C_CONTACTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(contactId);

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

	private static final String _FINDER_COLUMN_C_C_CUSTOMERID_2 =
		"phoneEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_CONTACTID_2 =
		"phoneEntry.contactId = ?";

	private FinderPath _finderPathFetchByC_N;
	private FinderPath _finderPathCountByC_N;

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByC_N(long customerId, String number)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByC_N(customerId, number);

		if (phoneEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", number=");
			sb.append(number);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPhoneEntryException(sb.toString());
		}

		return phoneEntry;
	}

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_N(long customerId, String number) {
		return fetchByC_N(customerId, number, true);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_N(
		long customerId, String number, boolean useFinderCache) {

		number = Objects.toString(number, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, number};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_N, finderArgs);
		}

		if (result instanceof PhoneEntry) {
			PhoneEntry phoneEntry = (PhoneEntry)result;

			if ((customerId != phoneEntry.getCustomerId()) ||
				!Objects.equals(number, phoneEntry.getNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_N_CUSTOMERID_2);

			boolean bindNumber = false;

			if (number.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_N_NUMBER_3);
			}
			else {
				bindNumber = true;

				sb.append(_FINDER_COLUMN_C_N_NUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				if (bindNumber) {
					queryPos.add(number);
				}

				List<PhoneEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {customerId, number};
							}

							_log.warn(
								"PhoneEntryPersistenceImpl.fetchByC_N(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PhoneEntry phoneEntry = list.get(0);

					result = phoneEntry;

					cacheResult(phoneEntry);
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
			return (PhoneEntry)result;
		}
	}

	/**
	 * Removes the phone entry where customerId = &#63; and number = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the phone entry that was removed
	 */
	@Override
	public PhoneEntry removeByC_N(long customerId, String number)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = findByC_N(customerId, number);

		return remove(phoneEntry);
	}

	/**
	 * Returns the number of phone entries where customerId = &#63; and number = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param number the number
	 * @return the number of matching phone entries
	 */
	@Override
	public int countByC_N(long customerId, String number) {
		number = Objects.toString(number, "");

		FinderPath finderPath = _finderPathCountByC_N;

		Object[] finderArgs = new Object[] {customerId, number};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHONEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_N_CUSTOMERID_2);

			boolean bindNumber = false;

			if (number.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_N_NUMBER_3);
			}
			else {
				bindNumber = true;

				sb.append(_FINDER_COLUMN_C_N_NUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				if (bindNumber) {
					queryPos.add(number);
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

	private static final String _FINDER_COLUMN_C_N_CUSTOMERID_2 =
		"phoneEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_N_NUMBER_2 =
		"phoneEntry.number = ?";

	private static final String _FINDER_COLUMN_C_N_NUMBER_3 =
		"(phoneEntry.number IS NULL OR phoneEntry.number = '')";

	private FinderPath _finderPathFetchByC_I;
	private FinderPath _finderPathCountByC_I;

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByC_I(long customerId, boolean isDefaulted)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByC_I(customerId, isDefaulted);

		if (phoneEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("customerId=");
			sb.append(customerId);

			sb.append(", isDefaulted=");
			sb.append(isDefaulted);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPhoneEntryException(sb.toString());
		}

		return phoneEntry;
	}

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_I(long customerId, boolean isDefaulted) {
		return fetchByC_I(customerId, isDefaulted, true);
	}

	/**
	 * Returns the phone entry where customerId = &#63; and isDefaulted = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_I(
		long customerId, boolean isDefaulted, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {customerId, isDefaulted};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_I, finderArgs);
		}

		if (result instanceof PhoneEntry) {
			PhoneEntry phoneEntry = (PhoneEntry)result;

			if ((customerId != phoneEntry.getCustomerId()) ||
				(isDefaulted != phoneEntry.isIsDefaulted())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_I_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_I_ISDEFAULTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(isDefaulted);

				List<PhoneEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_I, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									customerId, isDefaulted
								};
							}

							_log.warn(
								"PhoneEntryPersistenceImpl.fetchByC_I(long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PhoneEntry phoneEntry = list.get(0);

					result = phoneEntry;

					cacheResult(phoneEntry);
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
			return (PhoneEntry)result;
		}
	}

	/**
	 * Removes the phone entry where customerId = &#63; and isDefaulted = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the phone entry that was removed
	 */
	@Override
	public PhoneEntry removeByC_I(long customerId, boolean isDefaulted)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = findByC_I(customerId, isDefaulted);

		return remove(phoneEntry);
	}

	/**
	 * Returns the number of phone entries where customerId = &#63; and isDefaulted = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param isDefaulted the is defaulted
	 * @return the number of matching phone entries
	 */
	@Override
	public int countByC_I(long customerId, boolean isDefaulted) {
		FinderPath finderPath = _finderPathCountByC_I;

		Object[] finderArgs = new Object[] {customerId, isDefaulted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHONEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_I_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_I_ISDEFAULTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(isDefaulted);

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

	private static final String _FINDER_COLUMN_C_I_CUSTOMERID_2 =
		"phoneEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_I_ISDEFAULTED_2 =
		"phoneEntry.isDefaulted = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phone entry
	 * @throws NoSuchPhoneEntryException if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByC_ERC(companyId, externalReferenceCode);

		if (phoneEntry == null) {
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

			throw new NoSuchPhoneEntryException(sb.toString());
		}

		return phoneEntry;
	}

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the phone entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public PhoneEntry fetchByC_ERC(
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

		if (result instanceof PhoneEntry) {
			PhoneEntry phoneEntry = (PhoneEntry)result;

			if ((companyId != phoneEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					phoneEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PHONEENTRY_WHERE);

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

				List<PhoneEntry> list = query.list();

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
								"PhoneEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PhoneEntry phoneEntry = list.get(0);

					result = phoneEntry;

					cacheResult(phoneEntry);
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
			return (PhoneEntry)result;
		}
	}

	/**
	 * Removes the phone entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the phone entry that was removed
	 */
	@Override
	public PhoneEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = findByC_ERC(companyId, externalReferenceCode);

		return remove(phoneEntry);
	}

	/**
	 * Returns the number of phone entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching phone entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHONEENTRY_WHERE);

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
		"phoneEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"phoneEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(phoneEntry.externalReferenceCode IS NULL OR phoneEntry.externalReferenceCode = '')";

	public PhoneEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("number", "number_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PhoneEntry.class);

		setModelImplClass(PhoneEntryImpl.class);
		setModelPKClass(long.class);

		setTable(PhoneEntryTable.INSTANCE);
	}

	/**
	 * Caches the phone entry in the entity cache if it is enabled.
	 *
	 * @param phoneEntry the phone entry
	 */
	@Override
	public void cacheResult(PhoneEntry phoneEntry) {
		entityCache.putResult(
			PhoneEntryImpl.class, phoneEntry.getPrimaryKey(), phoneEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {phoneEntry.getUuid(), phoneEntry.getGroupId()},
			phoneEntry);

		finderCache.putResult(
			_finderPathFetchByC_N,
			new Object[] {phoneEntry.getCustomerId(), phoneEntry.getNumber()},
			phoneEntry);

		finderCache.putResult(
			_finderPathFetchByC_I,
			new Object[] {
				phoneEntry.getCustomerId(), phoneEntry.isIsDefaulted()
			},
			phoneEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				phoneEntry.getCompanyId(), phoneEntry.getExternalReferenceCode()
			},
			phoneEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the phone entries in the entity cache if it is enabled.
	 *
	 * @param phoneEntries the phone entries
	 */
	@Override
	public void cacheResult(List<PhoneEntry> phoneEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (phoneEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PhoneEntry phoneEntry : phoneEntries) {
			if (entityCache.getResult(
					PhoneEntryImpl.class, phoneEntry.getPrimaryKey()) == null) {

				cacheResult(phoneEntry);
			}
		}
	}

	/**
	 * Clears the cache for all phone entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhoneEntryImpl.class);

		finderCache.clearCache(PhoneEntryImpl.class);
	}

	/**
	 * Clears the cache for the phone entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhoneEntry phoneEntry) {
		entityCache.removeResult(PhoneEntryImpl.class, phoneEntry);
	}

	@Override
	public void clearCache(List<PhoneEntry> phoneEntries) {
		for (PhoneEntry phoneEntry : phoneEntries) {
			entityCache.removeResult(PhoneEntryImpl.class, phoneEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PhoneEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhoneEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PhoneEntryModelImpl phoneEntryModelImpl) {

		Object[] args = new Object[] {
			phoneEntryModelImpl.getUuid(), phoneEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, phoneEntryModelImpl);

		args = new Object[] {
			phoneEntryModelImpl.getCustomerId(), phoneEntryModelImpl.getNumber()
		};

		finderCache.putResult(_finderPathCountByC_N, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByC_N, args, phoneEntryModelImpl);

		args = new Object[] {
			phoneEntryModelImpl.getCustomerId(),
			phoneEntryModelImpl.isIsDefaulted()
		};

		finderCache.putResult(_finderPathCountByC_I, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByC_I, args, phoneEntryModelImpl);

		args = new Object[] {
			phoneEntryModelImpl.getCompanyId(),
			phoneEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, phoneEntryModelImpl);
	}

	/**
	 * Creates a new phone entry with the primary key. Does not add the phone entry to the database.
	 *
	 * @param phoneId the primary key for the new phone entry
	 * @return the new phone entry
	 */
	@Override
	public PhoneEntry create(long phoneId) {
		PhoneEntry phoneEntry = new PhoneEntryImpl();

		phoneEntry.setNew(true);
		phoneEntry.setPrimaryKey(phoneId);

		String uuid = PortalUUIDUtil.generate();

		phoneEntry.setUuid(uuid);

		phoneEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return phoneEntry;
	}

	/**
	 * Removes the phone entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry that was removed
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry remove(long phoneId) throws NoSuchPhoneEntryException {
		return remove((Serializable)phoneId);
	}

	/**
	 * Removes the phone entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phone entry
	 * @return the phone entry that was removed
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry remove(Serializable primaryKey)
		throws NoSuchPhoneEntryException {

		Session session = null;

		try {
			session = openSession();

			PhoneEntry phoneEntry = (PhoneEntry)session.get(
				PhoneEntryImpl.class, primaryKey);

			if (phoneEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhoneEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phoneEntry);
		}
		catch (NoSuchPhoneEntryException noSuchEntityException) {
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
	protected PhoneEntry removeImpl(PhoneEntry phoneEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phoneEntry)) {
				phoneEntry = (PhoneEntry)session.get(
					PhoneEntryImpl.class, phoneEntry.getPrimaryKeyObj());
			}

			if (phoneEntry != null) {
				session.delete(phoneEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phoneEntry != null) {
			clearCache(phoneEntry);
		}

		return phoneEntry;
	}

	@Override
	public PhoneEntry updateImpl(PhoneEntry phoneEntry) {
		boolean isNew = phoneEntry.isNew();

		if (!(phoneEntry instanceof PhoneEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phoneEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phoneEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phoneEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhoneEntry implementation " +
					phoneEntry.getClass());
		}

		PhoneEntryModelImpl phoneEntryModelImpl =
			(PhoneEntryModelImpl)phoneEntry;

		if (Validator.isNull(phoneEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			phoneEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (phoneEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				phoneEntry.setCreateDate(date);
			}
			else {
				phoneEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!phoneEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				phoneEntry.setModifiedDate(date);
			}
			else {
				phoneEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phoneEntry);
			}
			else {
				phoneEntry = (PhoneEntry)session.merge(phoneEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PhoneEntryImpl.class, phoneEntryModelImpl, false, true);

		cacheUniqueFindersCache(phoneEntryModelImpl);

		if (isNew) {
			phoneEntry.setNew(false);
		}

		phoneEntry.resetOriginalValues();

		return phoneEntry;
	}

	/**
	 * Returns the phone entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phone entry
	 * @return the phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhoneEntryException {

		PhoneEntry phoneEntry = fetchByPrimaryKey(primaryKey);

		if (phoneEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhoneEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phoneEntry;
	}

	/**
	 * Returns the phone entry with the primary key or throws a <code>NoSuchPhoneEntryException</code> if it could not be found.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry
	 * @throws NoSuchPhoneEntryException if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry findByPrimaryKey(long phoneId)
		throws NoSuchPhoneEntryException {

		return findByPrimaryKey((Serializable)phoneId);
	}

	/**
	 * Returns the phone entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry, or <code>null</code> if a phone entry with the primary key could not be found
	 */
	@Override
	public PhoneEntry fetchByPrimaryKey(long phoneId) {
		return fetchByPrimaryKey((Serializable)phoneId);
	}

	/**
	 * Returns all the phone entries.
	 *
	 * @return the phone entries
	 */
	@Override
	public List<PhoneEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of phone entries
	 */
	@Override
	public List<PhoneEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phone entries
	 */
	@Override
	public List<PhoneEntry> findAll(
		int start, int end, OrderByComparator<PhoneEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phone entries
	 */
	@Override
	public List<PhoneEntry> findAll(
		int start, int end, OrderByComparator<PhoneEntry> orderByComparator,
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

		List<PhoneEntry> list = null;

		if (useFinderCache) {
			list = (List<PhoneEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHONEENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHONEENTRY;

				sql = sql.concat(PhoneEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PhoneEntry>)QueryUtil.list(
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
	 * Removes all the phone entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhoneEntry phoneEntry : findAll()) {
			remove(phoneEntry);
		}
	}

	/**
	 * Returns the number of phone entries.
	 *
	 * @return the number of phone entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHONEENTRY);

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
		return "phoneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHONEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhoneEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phone entry persistence.
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

		_finderPathWithPaginationFindByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "contactId"}, true);

		_finderPathWithoutPaginationFindByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "contactId"}, true);

		_finderPathCountByC_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"customerId", "contactId"}, false);

		_finderPathFetchByC_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"customerId", "number_"}, true);

		_finderPathCountByC_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"customerId", "number_"}, false);

		_finderPathFetchByC_I = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_I",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"customerId", "isDefaulted"}, true);

		_finderPathCountByC_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_I",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"customerId", "isDefaulted"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setPhoneEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPhoneEntryUtilPersistence(null);

		entityCache.removeCache(PhoneEntryImpl.class.getName());
	}

	private void _setPhoneEntryUtilPersistence(
		PhoneEntryPersistence phoneEntryPersistence) {

		try {
			Field field = PhoneEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, phoneEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CNTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PHONEENTRY =
		"SELECT phoneEntry FROM PhoneEntry phoneEntry";

	private static final String _SQL_SELECT_PHONEENTRY_WHERE =
		"SELECT phoneEntry FROM PhoneEntry phoneEntry WHERE ";

	private static final String _SQL_COUNT_PHONEENTRY =
		"SELECT COUNT(phoneEntry) FROM PhoneEntry phoneEntry";

	private static final String _SQL_COUNT_PHONEENTRY_WHERE =
		"SELECT COUNT(phoneEntry) FROM PhoneEntry phoneEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phoneEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhoneEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PhoneEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhoneEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "number"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PhoneEntryModelArgumentsResolver _phoneEntryModelArgumentsResolver;

}