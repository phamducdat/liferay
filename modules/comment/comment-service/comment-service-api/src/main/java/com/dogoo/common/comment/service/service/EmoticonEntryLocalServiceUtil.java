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

package com.dogoo.common.comment.service.service;

import com.dogoo.common.comment.service.model.EmoticonEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmoticonEntry. This utility wraps
 * <code>com.dogoo.common.comment.service.service.impl.EmoticonEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmoticonEntryLocalService
 * @generated
 */
public class EmoticonEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.common.comment.service.service.impl.EmoticonEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static EmoticonEntry addEmoticon(
		long customerId, long creatorId,
		com.dogoo.common.comment.service.mapper.model.EmoticonMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addEmoticon(
			customerId, creatorId, model, serviceContext);
	}

	/**
	 * Adds the emoticon entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonEntry the emoticon entry
	 * @return the emoticon entry that was added
	 */
	public static EmoticonEntry addEmoticonEntry(EmoticonEntry emoticonEntry) {
		return getService().addEmoticonEntry(emoticonEntry);
	}

	/**
	 * Creates a new emoticon entry with the primary key. Does not add the emoticon entry to the database.
	 *
	 * @param emoticonId the primary key for the new emoticon entry
	 * @return the new emoticon entry
	 */
	public static EmoticonEntry createEmoticonEntry(long emoticonId) {
		return getService().createEmoticonEntry(emoticonId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the emoticon entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonEntry the emoticon entry
	 * @return the emoticon entry that was removed
	 */
	public static EmoticonEntry deleteEmoticonEntry(
		EmoticonEntry emoticonEntry) {

		return getService().deleteEmoticonEntry(emoticonEntry);
	}

	/**
	 * Deletes the emoticon entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry that was removed
	 * @throws PortalException if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry deleteEmoticonEntry(long emoticonId)
		throws PortalException {

		return getService().deleteEmoticonEntry(emoticonId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.comment.service.model.impl.EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.comment.service.model.impl.EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EmoticonEntry fetchEmoticonEntry(long emoticonId) {
		return getService().fetchEmoticonEntry(emoticonId);
	}

	/**
	 * Returns the emoticon entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the emoticon entry's external reference code
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchEmoticonEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchEmoticonEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchEmoticonEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static EmoticonEntry fetchEmoticonEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchEmoticonEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the emoticon entry matching the UUID and group.
	 *
	 * @param uuid the emoticon entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry fetchEmoticonEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmoticonEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.comment.service.model.impl.EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of emoticon entries
	 */
	public static List<EmoticonEntry> getEmoticonEntries(int start, int end) {
		return getService().getEmoticonEntries(start, end);
	}

	public static List<EmoticonEntry>
		getEmoticonEntriesByClassPkIdAndClassPkName(
			long customerId, long classPkId, String classPkName) {

		return getService().getEmoticonEntriesByClassPkIdAndClassPkName(
			customerId, classPkId, classPkName);
	}

	public static EmoticonEntry
			getEmoticonEntriesByClassPkIdAndClassPkNameAndUser(
				long customerId, long classPkId, String classPkName,
				long creatorId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getService().getEmoticonEntriesByClassPkIdAndClassPkNameAndUser(
			customerId, classPkId, classPkName, creatorId);
	}

	/**
	 * Returns all the emoticon entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the emoticon entries
	 * @param companyId the primary key of the company
	 * @return the matching emoticon entries, or an empty list if no matches were found
	 */
	public static List<EmoticonEntry> getEmoticonEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmoticonEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of emoticon entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the emoticon entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching emoticon entries, or an empty list if no matches were found
	 */
	public static List<EmoticonEntry> getEmoticonEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmoticonEntry> orderByComparator) {

		return getService().getEmoticonEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of emoticon entries.
	 *
	 * @return the number of emoticon entries
	 */
	public static int getEmoticonEntriesCount() {
		return getService().getEmoticonEntriesCount();
	}

	/**
	 * Returns the emoticon entry with the primary key.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry
	 * @throws PortalException if a emoticon entry with the primary key could not be found
	 */
	public static EmoticonEntry getEmoticonEntry(long emoticonId)
		throws PortalException {

		return getService().getEmoticonEntry(emoticonId);
	}

	/**
	 * Returns the emoticon entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the emoticon entry's external reference code
	 * @return the matching emoticon entry
	 * @throws PortalException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry getEmoticonEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getEmoticonEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the emoticon entry matching the UUID and group.
	 *
	 * @param uuid the emoticon entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emoticon entry
	 * @throws PortalException if a matching emoticon entry could not be found
	 */
	public static EmoticonEntry getEmoticonEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmoticonEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static EmoticonEntry updateEmoticon(
			long emoticonId,
			com.dogoo.common.comment.service.mapper.model.EmoticonMapperModel
				model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return getService().updateEmoticon(emoticonId, model, serviceContext);
	}

	/**
	 * Updates the emoticon entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonEntry the emoticon entry
	 * @return the emoticon entry that was updated
	 */
	public static EmoticonEntry updateEmoticonEntry(
		EmoticonEntry emoticonEntry) {

		return getService().updateEmoticonEntry(emoticonEntry);
	}

	public static EmoticonEntryLocalService getService() {
		return _service;
	}

	private static volatile EmoticonEntryLocalService _service;

}