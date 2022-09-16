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
 * Provides a wrapper for {@link DGFileManagerEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileManagerEntryLocalService
 * @generated
 */
public class DGFileManagerEntryLocalServiceWrapper
	implements DGFileManagerEntryLocalService,
			   ServiceWrapper<DGFileManagerEntryLocalService> {

	public DGFileManagerEntryLocalServiceWrapper(
		DGFileManagerEntryLocalService dgFileManagerEntryLocalService) {

		_dgFileManagerEntryLocalService = dgFileManagerEntryLocalService;
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		addDGFileManager(
			long customerId, long userId,
			com.dogoo.common.files.manager.service.mapper.model.
				FileManagerMapperModel model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _dgFileManagerEntryLocalService.addDGFileManager(
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		addDGFileManagerEntry(
			com.dogoo.common.files.manager.service.model.DGFileManagerEntry
				dgFileManagerEntry) {

		return _dgFileManagerEntryLocalService.addDGFileManagerEntry(
			dgFileManagerEntry);
	}

	/**
	 * Creates a new dg file manager entry with the primary key. Does not add the dg file manager entry to the database.
	 *
	 * @param fileManagerId the primary key for the new dg file manager entry
	 * @return the new dg file manager entry
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		createDGFileManagerEntry(long fileManagerId) {

		return _dgFileManagerEntryLocalService.createDGFileManagerEntry(
			fileManagerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileManagerEntryLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		deleteDGFileManagerEntry(
			com.dogoo.common.files.manager.service.model.DGFileManagerEntry
				dgFileManagerEntry) {

		return _dgFileManagerEntryLocalService.deleteDGFileManagerEntry(
			dgFileManagerEntry);
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
			deleteDGFileManagerEntry(long fileManagerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileManagerEntryLocalService.deleteDGFileManagerEntry(
			fileManagerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileManagerEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFileManagerEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFileManagerEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFileManagerEntryLocalService.dynamicQuery();
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

		return _dgFileManagerEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgFileManagerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgFileManagerEntryLocalService.dynamicQuery(
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

		return _dgFileManagerEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgFileManagerEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		fetchDGFileManagerEntry(long fileManagerId) {

		return _dgFileManagerEntryLocalService.fetchDGFileManagerEntry(
			fileManagerId);
	}

	/**
	 * Returns the dg file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file manager entry's external reference code
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		fetchDGFileManagerEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFileManagerEntryLocalService.
			fetchDGFileManagerEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileManagerEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		fetchDGFileManagerEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFileManagerEntryLocalService.
			fetchDGFileManagerEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file manager entry matching the UUID and group.
	 *
	 * @param uuid the dg file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file manager entry, or <code>null</code> if a matching dg file manager entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		fetchDGFileManagerEntryByUuidAndGroupId(String uuid, long groupId) {

		return _dgFileManagerEntryLocalService.
			fetchDGFileManagerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFileManagerEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileManagerEntry>
			getDGFileManagerEntries(int start, int end) {

		return _dgFileManagerEntryLocalService.getDGFileManagerEntries(
			start, end);
	}

	/**
	 * Returns all the dg file manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file manager entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file manager entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileManagerEntry>
			getDGFileManagerEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _dgFileManagerEntryLocalService.
			getDGFileManagerEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileManagerEntry>
			getDGFileManagerEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.dogoo.common.files.manager.service.model.
						DGFileManagerEntry> orderByComparator) {

		return _dgFileManagerEntryLocalService.
			getDGFileManagerEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file manager entries.
	 *
	 * @return the number of dg file manager entries
	 */
	@Override
	public int getDGFileManagerEntriesCount() {
		return _dgFileManagerEntryLocalService.getDGFileManagerEntriesCount();
	}

	/**
	 * Returns the dg file manager entry with the primary key.
	 *
	 * @param fileManagerId the primary key of the dg file manager entry
	 * @return the dg file manager entry
	 * @throws PortalException if a dg file manager entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
			getDGFileManagerEntry(long fileManagerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileManagerEntryLocalService.getDGFileManagerEntry(
			fileManagerId);
	}

	/**
	 * Returns the dg file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file manager entry's external reference code
	 * @return the matching dg file manager entry
	 * @throws PortalException if a matching dg file manager entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
			getDGFileManagerEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileManagerEntryLocalService.
			getDGFileManagerEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		getDGFileManagerEntryByFileId(long fileId, long customerId) {

		return _dgFileManagerEntryLocalService.getDGFileManagerEntryByFileId(
			fileId, customerId);
	}

	/**
	 * Returns the dg file manager entry matching the UUID and group.
	 *
	 * @param uuid the dg file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file manager entry
	 * @throws PortalException if a matching dg file manager entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
			getDGFileManagerEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileManagerEntryLocalService.
			getDGFileManagerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFileManagerEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFileManagerEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFileManagerEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileManagerEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
			updateDGFileManager(
				long fileManagerId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileManagerMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileManagerEntryException {

		return _dgFileManagerEntryLocalService.updateDGFileManager(
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
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileManagerEntry
		updateDGFileManagerEntry(
			com.dogoo.common.files.manager.service.model.DGFileManagerEntry
				dgFileManagerEntry) {

		return _dgFileManagerEntryLocalService.updateDGFileManagerEntry(
			dgFileManagerEntry);
	}

	@Override
	public DGFileManagerEntryLocalService getWrappedService() {
		return _dgFileManagerEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGFileManagerEntryLocalService dgFileManagerEntryLocalService) {

		_dgFileManagerEntryLocalService = dgFileManagerEntryLocalService;
	}

	private DGFileManagerEntryLocalService _dgFileManagerEntryLocalService;

}