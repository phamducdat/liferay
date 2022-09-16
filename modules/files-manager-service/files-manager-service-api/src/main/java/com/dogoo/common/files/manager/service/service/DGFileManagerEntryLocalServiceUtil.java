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

import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DGFileManagerEntry. This utility wraps
 * <code>com.dogoo.common.files.manager.service.service.impl.DGFileManagerEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileManagerEntryLocalService
 * @generated
 */
public class DGFileManagerEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGFileManagerEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DGFileManagerEntry addDGFileManager(
		long customerId, long userId,
		com.dogoo.common.files.manager.service.mapper.model.
			FileManagerMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addDGFileManager(
			customerId, userId, model, serviceContext);
	}

	/**
	 * Adds the dg file manager entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileManagerEntry the dg file manager entry
	 * @return the dg file manager entry that was added
	 */
	public static DGFileManagerEntry addDGFileManagerEntry(
		DGFileManagerEntry dgFileManagerEntry) {

		return getService().addDGFileManagerEntry(dgFileManagerEntry);
	}

	/**
	 * Creates a new dg file manager entry with the primary key. Does not add the dg file manager entry to the database.
	 *
	 * @param fileManagerId the primary key for the new dg file manager entry
	 * @return the new dg file manager entry
	 */
	public static DGFileManagerEntry createDGFileManagerEntry(
		long fileManagerId) {

		return getService().createDGFileManagerEntry(fileManagerId);
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
	 * Deletes the dg file manager entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileManagerEntry the dg file manager entry
	 * @return the dg file manager entry that was removed
	 */
	public static DGFileManagerEntry deleteDGFileManagerEntry(
		DGFileManagerEntry dgFileManagerEntry) {

		return getService().deleteDGFileManagerEntry(dgFileManagerEntry);
	}

	/**
	 * Deletes the dg file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry that was removed
	 * @throws PortalException if a dg file manager entry with the primary key could not be found
	 */
	public static DGFileManagerEntry deleteDGFileManagerEntry(
			long fileManagerId)
		throws PortalException {

		return getService().deleteDGFileManagerEntry(fileManagerId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileManagerEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileManagerEntryModelImpl</code>.
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

	public static DGFileManagerEntry fetchDGFileManagerEntry(
		long fileManagerId) {

		return getService().fetchDGFileManagerEntry(fileManagerId);
	}

	/**
	 * Returns the dg file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file manager entry's external reference code
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry
		fetchDGFileManagerEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDGFileManagerEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileManagerEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DGFileManagerEntry fetchDGFileManagerEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDGFileManagerEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file manager entry matching the UUID and group.
	 *
	 * @param uuid the dg file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry fetchDGFileManagerEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDGFileManagerEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dg file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @return the range of dg file manager entries
	 */
	public static List<DGFileManagerEntry> getDGFileManagerEntries(
		int start, int end) {

		return getService().getDGFileManagerEntries(start, end);
	}

	/**
	 * Returns all the dg file manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file manager entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file manager entries, or an empty list if no matches were found
	 */
	public static List<DGFileManagerEntry>
		getDGFileManagerEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getDGFileManagerEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of dg file manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file manager entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file manager entries
	 * @param end the upper bound of the range of dg file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file manager entries, or an empty list if no matches were found
	 */
	public static List<DGFileManagerEntry>
		getDGFileManagerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFileManagerEntry> orderByComparator) {

		return getService().getDGFileManagerEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file manager entries.
	 *
	 * @return the number of dg file manager entries
	 */
	public static int getDGFileManagerEntriesCount() {
		return getService().getDGFileManagerEntriesCount();
	}

	/**
	 * Returns the dg file manager entry with the primary key.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry
	 * @throws PortalException if a dg file manager entry with the primary key could not be found
	 */
	public static DGFileManagerEntry getDGFileManagerEntry(long fileManagerId)
		throws PortalException {

		return getService().getDGFileManagerEntry(fileManagerId);
	}

	/**
	 * Returns the dg file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file manager entry's external reference code
	 * @return the matching dg file manager entry
	 * @throws PortalException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry
			getDGFileManagerEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDGFileManagerEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	public static DGFileManagerEntry getDGFileManagerEntryByFileId(
		long fileId, long customerId) {

		return getService().getDGFileManagerEntryByFileId(fileId, customerId);
	}

	/**
	 * Returns the dg file manager entry matching the UUID and group.
	 *
	 * @param uuid the dg file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file manager entry
	 * @throws PortalException if a matching dg file manager entry could not be found
	 */
	public static DGFileManagerEntry getDGFileManagerEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDGFileManagerEntryByUuidAndGroupId(
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

	public static DGFileManagerEntry updateDGFileManager(
			long fileManagerId,
			com.dogoo.common.files.manager.service.mapper.model.
				FileManagerMapperModel model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return getService().updateDGFileManager(
			fileManagerId, model, serviceContext);
	}

	/**
	 * Updates the dg file manager entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileManagerEntry the dg file manager entry
	 * @return the dg file manager entry that was updated
	 */
	public static DGFileManagerEntry updateDGFileManagerEntry(
		DGFileManagerEntry dgFileManagerEntry) {

		return getService().updateDGFileManagerEntry(dgFileManagerEntry);
	}

	public static DGFileManagerEntryLocalService getService() {
		return _service;
	}

	private static volatile DGFileManagerEntryLocalService _service;

}