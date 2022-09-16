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

import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DGFileDepartmentPermissionEntry. This utility wraps
 * <code>com.dogoo.common.files.manager.service.service.impl.DGFileDepartmentPermissionEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileDepartmentPermissionEntryLocalService
 * @generated
 */
public class DGFileDepartmentPermissionEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGFileDepartmentPermissionEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dg file department permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileDepartmentPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileDepartmentPermissionEntry the dg file department permission entry
	 * @return the dg file department permission entry that was added
	 */
	public static DGFileDepartmentPermissionEntry
		addDGFileDepartmentPermissionEntry(
			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		return getService().addDGFileDepartmentPermissionEntry(
			dgFileDepartmentPermissionEntry);
	}

	/**
	 * Creates a new dg file department permission entry with the primary key. Does not add the dg file department permission entry to the database.
	 *
	 * @param fileDepartmentPermissionId the primary key for the new dg file department permission entry
	 * @return the new dg file department permission entry
	 */
	public static DGFileDepartmentPermissionEntry
		createDGFileDepartmentPermissionEntry(long fileDepartmentPermissionId) {

		return getService().createDGFileDepartmentPermissionEntry(
			fileDepartmentPermissionId);
	}

	public static DGFileDepartmentPermissionEntry
		createFileDepartmentPermission(
			long customerId, long userId, long documentManagerFileId,
			com.dogoo.common.files.manager.service.mapper.model.
				FileDepartmentPermissionMapperModel model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().createFileDepartmentPermission(
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

	public static void deleteAllFileDepartmentPermissionByFileId(
		long customerId, long documentManagerFileId) {

		getService().deleteAllFileDepartmentPermissionByFileId(
			customerId, documentManagerFileId);
	}

	/**
	 * Deletes the dg file department permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileDepartmentPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileDepartmentPermissionEntry the dg file department permission entry
	 * @return the dg file department permission entry that was removed
	 */
	public static DGFileDepartmentPermissionEntry
		deleteDGFileDepartmentPermissionEntry(
			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		return getService().deleteDGFileDepartmentPermissionEntry(
			dgFileDepartmentPermissionEntry);
	}

	/**
	 * Deletes the dg file department permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileDepartmentPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry that was removed
	 * @throws PortalException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry
			deleteDGFileDepartmentPermissionEntry(
				long fileDepartmentPermissionId)
		throws PortalException {

		return getService().deleteDGFileDepartmentPermissionEntry(
			fileDepartmentPermissionId);
	}

	public static void deleteFileDepartmentPermission(
			long customerId, long departmentId, long documentManagerFileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		getService().deleteFileDepartmentPermission(
			customerId, departmentId, documentManagerFileId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileDepartmentPermissionEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileDepartmentPermissionEntryModelImpl</code>.
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

	public static List<DGFileDepartmentPermissionEntry> fetchByC_D(
		long customerId, long departmentId) {

		return getService().fetchByC_D(customerId, departmentId);
	}

	public static DGFileDepartmentPermissionEntry fetchByC_D_F(
		long customerId, long departmentId, long documentManagerFileId) {

		return getService().fetchByC_D_F(
			customerId, departmentId, documentManagerFileId);
	}

	public static List<DGFileDepartmentPermissionEntry> fetchByC_F(
		long customerId, long documentManagerFileId) {

		return getService().fetchByC_F(customerId, documentManagerFileId);
	}

	public static DGFileDepartmentPermissionEntry
		fetchDGFileDepartmentPermissionEntry(long fileDepartmentPermissionId) {

		return getService().fetchDGFileDepartmentPermissionEntry(
			fileDepartmentPermissionId);
	}

	/**
	 * Returns the dg file department permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file department permission entry's external reference code
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry
		fetchDGFileDepartmentPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().
			fetchDGFileDepartmentPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileDepartmentPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DGFileDepartmentPermissionEntry
		fetchDGFileDepartmentPermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDGFileDepartmentPermissionEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file department permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file department permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry
		fetchDGFileDepartmentPermissionEntryByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchDGFileDepartmentPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DGFileDepartmentPermissionEntry> getAllByFileId(
		long customerId, long documentManagerFileId) {

		return getService().getAllByFileId(customerId, documentManagerFileId);
	}

	/**
	 * Returns a range of all the dg file department permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileDepartmentPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @return the range of dg file department permission entries
	 */
	public static List<DGFileDepartmentPermissionEntry>
		getDGFileDepartmentPermissionEntries(int start, int end) {

		return getService().getDGFileDepartmentPermissionEntries(start, end);
	}

	/**
	 * Returns all the dg file department permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file department permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file department permission entries, or an empty list if no matches were found
	 */
	public static List<DGFileDepartmentPermissionEntry>
		getDGFileDepartmentPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getDGFileDepartmentPermissionEntriesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of dg file department permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file department permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file department permission entries
	 * @param end the upper bound of the range of dg file department permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file department permission entries, or an empty list if no matches were found
	 */
	public static List<DGFileDepartmentPermissionEntry>
		getDGFileDepartmentPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFileDepartmentPermissionEntry>
				orderByComparator) {

		return getService().
			getDGFileDepartmentPermissionEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file department permission entries.
	 *
	 * @return the number of dg file department permission entries
	 */
	public static int getDGFileDepartmentPermissionEntriesCount() {
		return getService().getDGFileDepartmentPermissionEntriesCount();
	}

	/**
	 * Returns the dg file department permission entry with the primary key.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry
	 * @throws PortalException if a dg file department permission entry with the primary key could not be found
	 */
	public static DGFileDepartmentPermissionEntry
			getDGFileDepartmentPermissionEntry(long fileDepartmentPermissionId)
		throws PortalException {

		return getService().getDGFileDepartmentPermissionEntry(
			fileDepartmentPermissionId);
	}

	/**
	 * Returns the dg file department permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file department permission entry's external reference code
	 * @return the matching dg file department permission entry
	 * @throws PortalException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry
			getDGFileDepartmentPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().
			getDGFileDepartmentPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file department permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file department permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file department permission entry
	 * @throws PortalException if a matching dg file department permission entry could not be found
	 */
	public static DGFileDepartmentPermissionEntry
			getDGFileDepartmentPermissionEntryByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getDGFileDepartmentPermissionEntryByUuidAndGroupId(
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
	 * Updates the dg file department permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileDepartmentPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileDepartmentPermissionEntry the dg file department permission entry
	 * @return the dg file department permission entry that was updated
	 */
	public static DGFileDepartmentPermissionEntry
		updateDGFileDepartmentPermissionEntry(
			DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		return getService().updateDGFileDepartmentPermissionEntry(
			dgFileDepartmentPermissionEntry);
	}

	public static DGFileDepartmentPermissionEntry
		updateRoleFileDepartmentPermission(
			long customerId, long userId, long departmentId,
			long documentManagerFileId, String role,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateRoleFileDepartmentPermission(
			customerId, userId, departmentId, documentManagerFileId, role,
			serviceContext);
	}

	public static DGFileDepartmentPermissionEntryLocalService getService() {
		return _service;
	}

	private static volatile DGFileDepartmentPermissionEntryLocalService
		_service;

}