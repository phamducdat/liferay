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

import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DGDocumentManagerEntry. This utility wraps
 * <code>com.dogoo.common.files.manager.service.service.impl.DGDocumentManagerEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGDocumentManagerEntryLocalService
 * @generated
 */
public class DGDocumentManagerEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGDocumentManagerEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DGDocumentManagerEntry addDGDocumentManager(
			long customerId, long userId, Long departmentId,
			com.dogoo.common.files.manager.service.mapper.model.
				DocumentManagerMapperModel model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().addDGDocumentManager(
			customerId, userId, departmentId, model, serviceContext);
	}

	public static DGDocumentManagerEntry addDGDocumentManager(
		long fileId, long parentId, String pkCode,
		DGDocumentManagerEntry dgDocumentManagerEntry,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addDGDocumentManager(
			fileId, parentId, pkCode, dgDocumentManagerEntry, serviceContext);
	}

	/**
	 * Adds the dg document manager entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 * @return the dg document manager entry that was added
	 */
	public static DGDocumentManagerEntry addDGDocumentManagerEntry(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		return getService().addDGDocumentManagerEntry(dgDocumentManagerEntry);
	}

	/**
	 * Creates a new dg document manager entry with the primary key. Does not add the dg document manager entry to the database.
	 *
	 * @param documentManagerId the primary key for the new dg document manager entry
	 * @return the new dg document manager entry
	 */
	public static DGDocumentManagerEntry createDGDocumentManagerEntry(
		long documentManagerId) {

		return getService().createDGDocumentManagerEntry(documentManagerId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteDgDocumentManagerEntriesByPkCode(String pkCode) {
		getService().deleteDgDocumentManagerEntriesByPkCode(pkCode);
	}

	/**
	 * Deletes the dg document manager entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 * @return the dg document manager entry that was removed
	 */
	public static DGDocumentManagerEntry deleteDGDocumentManagerEntry(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		return getService().deleteDGDocumentManagerEntry(
			dgDocumentManagerEntry);
	}

	/**
	 * Deletes the dg document manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry that was removed
	 * @throws PortalException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry deleteDGDocumentManagerEntry(
			long documentManagerId)
		throws PortalException {

		return getService().deleteDGDocumentManagerEntry(documentManagerId);
	}

	public static void deleteDgDocumentManagerEntryById(
			DGDocumentManagerEntry dgDocumentManagerEntry)
		throws PortalException {

		getService().deleteDgDocumentManagerEntryById(dgDocumentManagerEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryModelImpl</code>.
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

	public static DGDocumentManagerEntry fetchDGDocumentManagerEntry(
		long documentManagerId) {

		return getService().fetchDGDocumentManagerEntry(documentManagerId);
	}

	/**
	 * Returns the dg document manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg document manager entry's external reference code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry
		fetchDGDocumentManagerEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDGDocumentManagerEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	public static DGDocumentManagerEntry fetchDgDocumentManagerEntryByFileId(
		long fileId) {

		return getService().fetchDgDocumentManagerEntryByFileId(fileId);
	}

	public static DGDocumentManagerEntry
		fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
			String name, long parentId, String fileExtension, String pkCode) {

		return getService().
			fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
				name, parentId, fileExtension, pkCode);
	}

	public static DGDocumentManagerEntry
		fetchDgDocumentManagerEntryByNameAndTypeAndPkCodeAndParentIdAndCategoryAndCreatorId(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId) {

		return getService().
			fetchDgDocumentManagerEntryByNameAndTypeAndPkCodeAndParentIdAndCategoryAndCreatorId(
				name, type, pkCode, parentId, category, creatorId);
	}

	public static List<DGDocumentManagerEntry>
		fetchDgDocumentManagerEntryByPkCodeAndParentId(
			String pkCode, long parentId) {

		return getService().fetchDgDocumentManagerEntryByPkCodeAndParentId(
			pkCode, parentId);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGDocumentManagerEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DGDocumentManagerEntry
		fetchDGDocumentManagerEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDGDocumentManagerEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg document manager entry matching the UUID and group.
	 *
	 * @param uuid the dg document manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry
		fetchDGDocumentManagerEntryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchDGDocumentManagerEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<DGDocumentManagerEntry>
		fetchDgDocumentManagerEntryListByParentId(long parentId) {

		return getService().fetchDgDocumentManagerEntryListByParentId(parentId);
	}

	public static List<DGDocumentManagerEntry>
		fetchDgDocumentManagerEntryListByPkCode(String pkCode) {

		return getService().fetchDgDocumentManagerEntryListByPkCode(pkCode);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of dg document manager entries
	 */
	public static List<DGDocumentManagerEntry> getDGDocumentManagerEntries(
		int start, int end) {

		return getService().getDGDocumentManagerEntries(start, end);
	}

	/**
	 * Returns all the dg document manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg document manager entries
	 * @param companyId the primary key of the company
	 * @return the matching dg document manager entries, or an empty list if no matches were found
	 */
	public static List<DGDocumentManagerEntry>
		getDGDocumentManagerEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getDGDocumentManagerEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of dg document manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg document manager entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg document manager entries, or an empty list if no matches were found
	 */
	public static List<DGDocumentManagerEntry>
		getDGDocumentManagerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator) {

		return getService().getDGDocumentManagerEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg document manager entries.
	 *
	 * @return the number of dg document manager entries
	 */
	public static int getDGDocumentManagerEntriesCount() {
		return getService().getDGDocumentManagerEntriesCount();
	}

	/**
	 * Returns the dg document manager entry with the primary key.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry
	 * @throws PortalException if a dg document manager entry with the primary key could not be found
	 */
	public static DGDocumentManagerEntry getDGDocumentManagerEntry(
			long documentManagerId)
		throws PortalException {

		return getService().getDGDocumentManagerEntry(documentManagerId);
	}

	/**
	 * Returns the dg document manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg document manager entry's external reference code
	 * @return the matching dg document manager entry
	 * @throws PortalException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry
			getDGDocumentManagerEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDGDocumentManagerEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg document manager entry matching the UUID and group.
	 *
	 * @param uuid the dg document manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg document manager entry
	 * @throws PortalException if a matching dg document manager entry could not be found
	 */
	public static DGDocumentManagerEntry
			getDGDocumentManagerEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getDGDocumentManagerEntryByUuidAndGroupId(
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

	public static DGDocumentManagerEntry updateDGDocumentManager(
			long userId, long documentId,
			com.dogoo.common.files.manager.service.mapper.model.
				DocumentManagerMapperModel model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().updateDGDocumentManager(
			userId, documentId, model, serviceContext);
	}

	/**
	 * Updates the dg document manager entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 * @return the dg document manager entry that was updated
	 */
	public static DGDocumentManagerEntry updateDGDocumentManagerEntry(
		DGDocumentManagerEntry dgDocumentManagerEntry) {

		return getService().updateDGDocumentManagerEntry(
			dgDocumentManagerEntry);
	}

	public static DGDocumentManagerEntry updateDGDocumentManagerPublic(
			long userId, long documentId, Boolean isPrivate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().updateDGDocumentManagerPublic(
			userId, documentId, isPrivate, serviceContext);
	}

	public static DGDocumentManagerEntryLocalService getService() {
		return _service;
	}

	private static volatile DGDocumentManagerEntryLocalService _service;

}