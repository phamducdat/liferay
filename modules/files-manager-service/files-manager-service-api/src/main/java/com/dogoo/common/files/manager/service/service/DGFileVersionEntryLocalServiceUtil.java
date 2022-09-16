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

package com.dogoo.common.files.manager.service.service;

import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DGFileVersionEntry. This utility wraps
 * <code>com.dogoo.common.files.manager.service.service.impl.DGFileVersionEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileVersionEntryLocalService
 * @generated
 */
public class DGFileVersionEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGFileVersionEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dg file version entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 * @return the dg file version entry that was added
	 */
	public static DGFileVersionEntry addDGFileVersionEntry(
		DGFileVersionEntry dgFileVersionEntry) {

		return getService().addDGFileVersionEntry(dgFileVersionEntry);
	}

	/**
	 * Creates a new dg file version entry with the primary key. Does not add the dg file version entry to the database.
	 *
	 * @param fileVersionId the primary key for the new dg file version entry
	 * @return the new dg file version entry
	 */
	public static DGFileVersionEntry createDGFileVersionEntry(
		long fileVersionId) {

		return getService().createDGFileVersionEntry(fileVersionId);
	}

	public static DGFileVersionEntry createDGFileVersionEntry(
		long customerId, long userId, long fileId, long fileVersionId,
		long accountId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().createDGFileVersionEntry(
			customerId, userId, fileId, fileVersionId, accountId,
			serviceContext);
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
	 * Deletes the dg file version entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 * @return the dg file version entry that was removed
	 */
	public static DGFileVersionEntry deleteDGFileVersionEntry(
		DGFileVersionEntry dgFileVersionEntry) {

		return getService().deleteDGFileVersionEntry(dgFileVersionEntry);
	}

	/**
	 * Deletes the dg file version entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry that was removed
	 * @throws PortalException if a dg file version entry with the primary key could not be found
	 */
	public static DGFileVersionEntry deleteDGFileVersionEntry(
			long fileVersionId)
		throws PortalException {

		return getService().deleteDGFileVersionEntry(fileVersionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryModelImpl</code>.
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

	public static DGFileVersionEntry fetchByC_FV(
		long customerId, long fileVersionId) {

		return getService().fetchByC_FV(customerId, fileVersionId);
	}

	public static DGFileVersionEntry fetchDGFileVersionEntry(
		long fileVersionId) {

		return getService().fetchDGFileVersionEntry(fileVersionId);
	}

	/**
	 * Returns the dg file version entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file version entry's external reference code
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry
		fetchDGFileVersionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDGFileVersionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileVersionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DGFileVersionEntry fetchDGFileVersionEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDGFileVersionEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file version entry matching the UUID and group.
	 *
	 * @param uuid the dg file version entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry fetchDGFileVersionEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDGFileVersionEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of dg file version entries
	 */
	public static List<DGFileVersionEntry> getDGFileVersionEntries(
		int start, int end) {

		return getService().getDGFileVersionEntries(start, end);
	}

	/**
	 * Returns all the dg file version entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file version entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file version entries, or an empty list if no matches were found
	 */
	public static List<DGFileVersionEntry>
		getDGFileVersionEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getDGFileVersionEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of dg file version entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file version entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file version entries, or an empty list if no matches were found
	 */
	public static List<DGFileVersionEntry>
		getDGFileVersionEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFileVersionEntry> orderByComparator) {

		return getService().getDGFileVersionEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file version entries.
	 *
	 * @return the number of dg file version entries
	 */
	public static int getDGFileVersionEntriesCount() {
		return getService().getDGFileVersionEntriesCount();
	}

	/**
	 * Returns the dg file version entry with the primary key.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry
	 * @throws PortalException if a dg file version entry with the primary key could not be found
	 */
	public static DGFileVersionEntry getDGFileVersionEntry(long fileVersionId)
		throws PortalException {

		return getService().getDGFileVersionEntry(fileVersionId);
	}

	/**
	 * Returns the dg file version entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file version entry's external reference code
	 * @return the matching dg file version entry
	 * @throws PortalException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry
			getDGFileVersionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDGFileVersionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file version entry matching the UUID and group.
	 *
	 * @param uuid the dg file version entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file version entry
	 * @throws PortalException if a matching dg file version entry could not be found
	 */
	public static DGFileVersionEntry getDGFileVersionEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDGFileVersionEntryByUuidAndGroupId(
			uuid, groupId);
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

	/**
	 * Updates the dg file version entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 * @return the dg file version entry that was updated
	 */
	public static DGFileVersionEntry updateDGFileVersionEntry(
		DGFileVersionEntry dgFileVersionEntry) {

		return getService().updateDGFileVersionEntry(dgFileVersionEntry);
	}

	public static DGFileVersionEntryLocalService getService() {
		return _service;
	}

	private static volatile DGFileVersionEntryLocalService _service;

}