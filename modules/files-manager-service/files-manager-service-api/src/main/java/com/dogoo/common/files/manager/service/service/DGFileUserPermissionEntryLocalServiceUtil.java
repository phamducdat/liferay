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

import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DGFileUserPermissionEntry. This utility wraps
 * <code>com.dogoo.common.files.manager.service.service.impl.DGFileUserPermissionEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileUserPermissionEntryLocalService
 * @generated
 */
public class DGFileUserPermissionEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGFileUserPermissionEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dg file user permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileUserPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileUserPermissionEntry the dg file user permission entry
	 * @return the dg file user permission entry that was added
	 */
	public static DGFileUserPermissionEntry addDGFileUserPermissionEntry(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return getService().addDGFileUserPermissionEntry(
			dgFileUserPermissionEntry);
	}

	/**
	 * Creates a new dg file user permission entry with the primary key. Does not add the dg file user permission entry to the database.
	 *
	 * @param fileUserPermissionId the primary key for the new dg file user permission entry
	 * @return the new dg file user permission entry
	 */
	public static DGFileUserPermissionEntry createDGFileUserPermissionEntry(
		long fileUserPermissionId) {

		return getService().createDGFileUserPermissionEntry(
			fileUserPermissionId);
	}

	public static DGFileUserPermissionEntry createFileUserPermission(
		long customerId, long userId, long documentManagerFileId,
		com.dogoo.common.files.manager.service.mapper.model.
			FileUserPermissionMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().createFileUserPermission(
			customerId, userId, documentManagerFileId, model, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAllFileUserPermissionByFileId(
		long customerId, long documentManagerFileId) {

		getService().deleteAllFileUserPermissionByFileId(
			customerId, documentManagerFileId);
	}

	/**
	 * Deletes the dg file user permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileUserPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileUserPermissionEntry the dg file user permission entry
	 * @return the dg file user permission entry that was removed
	 */
	public static DGFileUserPermissionEntry deleteDGFileUserPermissionEntry(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return getService().deleteDGFileUserPermissionEntry(
			dgFileUserPermissionEntry);
	}

	/**
	 * Deletes the dg file user permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileUserPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry that was removed
	 * @throws PortalException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry deleteDGFileUserPermissionEntry(
			long fileUserPermissionId)
		throws PortalException {

		return getService().deleteDGFileUserPermissionEntry(
			fileUserPermissionId);
	}

	public static void deleteFileUserPermission(
		long customerId, long userId, long documentManagerFileId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		getService().deleteFileUserPermission(
			customerId, userId, documentManagerFileId, serviceContext);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileUserPermissionEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileUserPermissionEntryModelImpl</code>.
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

	public static List<DGFileUserPermissionEntry> fetchByC_F(
		long customerId, long documentManagerFileId) {

		return getService().fetchByC_F(customerId, documentManagerFileId);
	}

	public static List<DGFileUserPermissionEntry> fetchByC_U(
		long customerId, long userId) {

		return getService().fetchByC_U(customerId, userId);
	}

	public static DGFileUserPermissionEntry fetchByC_U_F(
		long customerId, long userId, long documentManagerFileId) {

		return getService().fetchByC_U_F(
			customerId, userId, documentManagerFileId);
	}

	public static List<DGFileUserPermissionEntry> fetchByC_U_S(
		long customerId, long userId, String status) {

		return getService().fetchByC_U_S(customerId, userId, status);
	}

	public static DGFileUserPermissionEntry fetchDGFileUserPermissionEntry(
		long fileUserPermissionId) {

		return getService().fetchDGFileUserPermissionEntry(
			fileUserPermissionId);
	}

	/**
	 * Returns the dg file user permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file user permission entry's external reference code
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry
		fetchDGFileUserPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().
			fetchDGFileUserPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileUserPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DGFileUserPermissionEntry
		fetchDGFileUserPermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDGFileUserPermissionEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file user permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file user permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry
		fetchDGFileUserPermissionEntryByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchDGFileUserPermissionEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DGFileUserPermissionEntry> getAllByFileId(
		long customerId, long documentManagerFileId) {

		return getService().getAllByFileId(customerId, documentManagerFileId);
	}

	/**
	 * Returns a range of all the dg file user permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileUserPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @return the range of dg file user permission entries
	 */
	public static List<DGFileUserPermissionEntry>
		getDGFileUserPermissionEntries(int start, int end) {

		return getService().getDGFileUserPermissionEntries(start, end);
	}

	/**
	 * Returns all the dg file user permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file user permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file user permission entries, or an empty list if no matches were found
	 */
	public static List<DGFileUserPermissionEntry>
		getDGFileUserPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getDGFileUserPermissionEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of dg file user permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file user permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file user permission entries
	 * @param end the upper bound of the range of dg file user permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file user permission entries, or an empty list if no matches were found
	 */
	public static List<DGFileUserPermissionEntry>
		getDGFileUserPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFileUserPermissionEntry> orderByComparator) {

		return getService().getDGFileUserPermissionEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file user permission entries.
	 *
	 * @return the number of dg file user permission entries
	 */
	public static int getDGFileUserPermissionEntriesCount() {
		return getService().getDGFileUserPermissionEntriesCount();
	}

	/**
	 * Returns the dg file user permission entry with the primary key.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry
	 * @throws PortalException if a dg file user permission entry with the primary key could not be found
	 */
	public static DGFileUserPermissionEntry getDGFileUserPermissionEntry(
			long fileUserPermissionId)
		throws PortalException {

		return getService().getDGFileUserPermissionEntry(fileUserPermissionId);
	}

	/**
	 * Returns the dg file user permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file user permission entry's external reference code
	 * @return the matching dg file user permission entry
	 * @throws PortalException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry
			getDGFileUserPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDGFileUserPermissionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file user permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file user permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file user permission entry
	 * @throws PortalException if a matching dg file user permission entry could not be found
	 */
	public static DGFileUserPermissionEntry
			getDGFileUserPermissionEntryByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getDGFileUserPermissionEntryByUuidAndGroupId(
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
	 * Updates the dg file user permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileUserPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileUserPermissionEntry the dg file user permission entry
	 * @return the dg file user permission entry that was updated
	 */
	public static DGFileUserPermissionEntry updateDGFileUserPermissionEntry(
		DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return getService().updateDGFileUserPermissionEntry(
			dgFileUserPermissionEntry);
	}

	public static DGFileUserPermissionEntry updateFileUserPermission(
		long customerId, long userId, long documentManagerFileId,
		com.dogoo.common.files.manager.service.mapper.model.
			FileUserPermissionMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateFileUserPermission(
			customerId, userId, documentManagerFileId, model, serviceContext);
	}

	public static DGFileUserPermissionEntryLocalService getService() {
		return _service;
	}

	private static volatile DGFileUserPermissionEntryLocalService _service;

}