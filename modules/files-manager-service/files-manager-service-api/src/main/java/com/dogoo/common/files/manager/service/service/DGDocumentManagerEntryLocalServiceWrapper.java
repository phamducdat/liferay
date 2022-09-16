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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DGDocumentManagerEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGDocumentManagerEntryLocalService
 * @generated
 */
public class DGDocumentManagerEntryLocalServiceWrapper
	implements DGDocumentManagerEntryLocalService,
			   ServiceWrapper<DGDocumentManagerEntryLocalService> {

	public DGDocumentManagerEntryLocalServiceWrapper(
		DGDocumentManagerEntryLocalService dgDocumentManagerEntryLocalService) {

		_dgDocumentManagerEntryLocalService =
			dgDocumentManagerEntryLocalService;
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
			addDGDocumentManager(
				long customerId, long userId, Long departmentId,
				com.dogoo.common.files.manager.service.mapper.model.
					DocumentManagerMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _dgDocumentManagerEntryLocalService.addDGDocumentManager(
			customerId, userId, departmentId, model, serviceContext);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		addDGDocumentManager(
			long fileId, long parentId, String pkCode,
			com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
				dgDocumentManagerEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _dgDocumentManagerEntryLocalService.addDGDocumentManager(
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		addDGDocumentManagerEntry(
			com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
				dgDocumentManagerEntry) {

		return _dgDocumentManagerEntryLocalService.addDGDocumentManagerEntry(
			dgDocumentManagerEntry);
	}

	/**
	 * Creates a new dg document manager entry with the primary key. Does not add the dg document manager entry to the database.
	 *
	 * @param documentManagerId the primary key for the new dg document manager entry
	 * @return the new dg document manager entry
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		createDGDocumentManagerEntry(long documentManagerId) {

		return _dgDocumentManagerEntryLocalService.createDGDocumentManagerEntry(
			documentManagerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgDocumentManagerEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void deleteDgDocumentManagerEntriesByPkCode(String pkCode) {
		_dgDocumentManagerEntryLocalService.
			deleteDgDocumentManagerEntriesByPkCode(pkCode);
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		deleteDGDocumentManagerEntry(
			com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
				dgDocumentManagerEntry) {

		return _dgDocumentManagerEntryLocalService.deleteDGDocumentManagerEntry(
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
			deleteDGDocumentManagerEntry(long documentManagerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgDocumentManagerEntryLocalService.deleteDGDocumentManagerEntry(
			documentManagerId);
	}

	@Override
	public void deleteDgDocumentManagerEntryById(
			com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
				dgDocumentManagerEntry)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dgDocumentManagerEntryLocalService.deleteDgDocumentManagerEntryById(
			dgDocumentManagerEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgDocumentManagerEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgDocumentManagerEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgDocumentManagerEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgDocumentManagerEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dgDocumentManagerEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgDocumentManagerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgDocumentManagerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dgDocumentManagerEntryLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dgDocumentManagerEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		fetchDGDocumentManagerEntry(long documentManagerId) {

		return _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(
			documentManagerId);
	}

	/**
	 * Returns the dg document manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg document manager entry's external reference code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		fetchDGDocumentManagerEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgDocumentManagerEntryLocalService.
			fetchDGDocumentManagerEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		fetchDgDocumentManagerEntryByFileId(long fileId) {

		return _dgDocumentManagerEntryLocalService.
			fetchDgDocumentManagerEntryByFileId(fileId);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
			String name, long parentId, String fileExtension, String pkCode) {

		return _dgDocumentManagerEntryLocalService.
			fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
				name, parentId, fileExtension, pkCode);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		fetchDgDocumentManagerEntryByNameAndTypeAndPkCodeAndParentIdAndCategoryAndCreatorId(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId) {

		return _dgDocumentManagerEntryLocalService.
			fetchDgDocumentManagerEntryByNameAndTypeAndPkCodeAndParentIdAndCategoryAndCreatorId(
				name, type, pkCode, parentId, category, creatorId);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry>
			fetchDgDocumentManagerEntryByPkCodeAndParentId(
				String pkCode, long parentId) {

		return _dgDocumentManagerEntryLocalService.
			fetchDgDocumentManagerEntryByPkCodeAndParentId(pkCode, parentId);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGDocumentManagerEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		fetchDGDocumentManagerEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgDocumentManagerEntryLocalService.
			fetchDGDocumentManagerEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg document manager entry matching the UUID and group.
	 *
	 * @param uuid the dg document manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		fetchDGDocumentManagerEntryByUuidAndGroupId(String uuid, long groupId) {

		return _dgDocumentManagerEntryLocalService.
			fetchDGDocumentManagerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry>
			fetchDgDocumentManagerEntryListByParentId(long parentId) {

		return _dgDocumentManagerEntryLocalService.
			fetchDgDocumentManagerEntryListByParentId(parentId);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry>
			fetchDgDocumentManagerEntryListByPkCode(String pkCode) {

		return _dgDocumentManagerEntryLocalService.
			fetchDgDocumentManagerEntryListByPkCode(pkCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgDocumentManagerEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry>
			getDGDocumentManagerEntries(int start, int end) {

		return _dgDocumentManagerEntryLocalService.getDGDocumentManagerEntries(
			start, end);
	}

	/**
	 * Returns all the dg document manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg document manager entries
	 * @param companyId the primary key of the company
	 * @return the matching dg document manager entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry>
			getDGDocumentManagerEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _dgDocumentManagerEntryLocalService.
			getDGDocumentManagerEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry>
			getDGDocumentManagerEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.dogoo.common.files.manager.service.model.
						DGDocumentManagerEntry> orderByComparator) {

		return _dgDocumentManagerEntryLocalService.
			getDGDocumentManagerEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg document manager entries.
	 *
	 * @return the number of dg document manager entries
	 */
	@Override
	public int getDGDocumentManagerEntriesCount() {
		return _dgDocumentManagerEntryLocalService.
			getDGDocumentManagerEntriesCount();
	}

	/**
	 * Returns the dg document manager entry with the primary key.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry
	 * @throws PortalException if a dg document manager entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
			getDGDocumentManagerEntry(long documentManagerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgDocumentManagerEntryLocalService.getDGDocumentManagerEntry(
			documentManagerId);
	}

	/**
	 * Returns the dg document manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg document manager entry's external reference code
	 * @return the matching dg document manager entry
	 * @throws PortalException if a matching dg document manager entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
			getDGDocumentManagerEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgDocumentManagerEntryLocalService.
			getDGDocumentManagerEntryByExternalReferenceCode(
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
			getDGDocumentManagerEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgDocumentManagerEntryLocalService.
			getDGDocumentManagerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgDocumentManagerEntryLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgDocumentManagerEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgDocumentManagerEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgDocumentManagerEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
			updateDGDocumentManager(
				long userId, long documentId,
				com.dogoo.common.files.manager.service.mapper.model.
					DocumentManagerMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _dgDocumentManagerEntryLocalService.updateDGDocumentManager(
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
		updateDGDocumentManagerEntry(
			com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
				dgDocumentManagerEntry) {

		return _dgDocumentManagerEntryLocalService.updateDGDocumentManagerEntry(
			dgDocumentManagerEntry);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry
			updateDGDocumentManagerPublic(
				long userId, long documentId, Boolean isPrivate,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _dgDocumentManagerEntryLocalService.
			updateDGDocumentManagerPublic(
				userId, documentId, isPrivate, serviceContext);
	}

	@Override
	public DGDocumentManagerEntryLocalService getWrappedService() {
		return _dgDocumentManagerEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGDocumentManagerEntryLocalService dgDocumentManagerEntryLocalService) {

		_dgDocumentManagerEntryLocalService =
			dgDocumentManagerEntryLocalService;
	}

	private DGDocumentManagerEntryLocalService
		_dgDocumentManagerEntryLocalService;

}