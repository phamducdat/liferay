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
 * Provides a wrapper for {@link DGFileUserPermissionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileUserPermissionEntryLocalService
 * @generated
 */
public class DGFileUserPermissionEntryLocalServiceWrapper
	implements DGFileUserPermissionEntryLocalService,
			   ServiceWrapper<DGFileUserPermissionEntryLocalService> {

	public DGFileUserPermissionEntryLocalServiceWrapper(
		DGFileUserPermissionEntryLocalService
			dgFileUserPermissionEntryLocalService) {

		_dgFileUserPermissionEntryLocalService =
			dgFileUserPermissionEntryLocalService;
	}

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
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			addDGFileUserPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return _dgFileUserPermissionEntryLocalService.
			addDGFileUserPermissionEntry(dgFileUserPermissionEntry);
	}

	/**
	 * Creates a new dg file user permission entry with the primary key. Does not add the dg file user permission entry to the database.
	 *
	 * @param fileUserPermissionId the primary key for the new dg file user permission entry
	 * @return the new dg file user permission entry
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			createDGFileUserPermissionEntry(long fileUserPermissionId) {

		return _dgFileUserPermissionEntryLocalService.
			createDGFileUserPermissionEntry(fileUserPermissionId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			createFileUserPermission(
				long customerId, long userId, long documentManagerFileId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileUserPermissionMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileUserPermissionEntryLocalService.createFileUserPermission(
			customerId, userId, documentManagerFileId, model, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileUserPermissionEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void deleteAllFileUserPermissionByFileId(
		long customerId, long documentManagerFileId) {

		_dgFileUserPermissionEntryLocalService.
			deleteAllFileUserPermissionByFileId(
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			deleteDGFileUserPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return _dgFileUserPermissionEntryLocalService.
			deleteDGFileUserPermissionEntry(dgFileUserPermissionEntry);
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
				deleteDGFileUserPermissionEntry(long fileUserPermissionId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileUserPermissionEntryLocalService.
			deleteDGFileUserPermissionEntry(fileUserPermissionId);
	}

	@Override
	public void deleteFileUserPermission(
		long customerId, long userId, long documentManagerFileId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		_dgFileUserPermissionEntryLocalService.deleteFileUserPermission(
			customerId, userId, documentManagerFileId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileUserPermissionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFileUserPermissionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFileUserPermissionEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFileUserPermissionEntryLocalService.dynamicQuery();
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

		return _dgFileUserPermissionEntryLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgFileUserPermissionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgFileUserPermissionEntryLocalService.dynamicQuery(
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

		return _dgFileUserPermissionEntryLocalService.dynamicQueryCount(
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

		return _dgFileUserPermissionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry>
			fetchByC_F(long customerId, long documentManagerFileId) {

		return _dgFileUserPermissionEntryLocalService.fetchByC_F(
			customerId, documentManagerFileId);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry>
			fetchByC_U(long customerId, long userId) {

		return _dgFileUserPermissionEntryLocalService.fetchByC_U(
			customerId, userId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			fetchByC_U_F(
				long customerId, long userId, long documentManagerFileId) {

		return _dgFileUserPermissionEntryLocalService.fetchByC_U_F(
			customerId, userId, documentManagerFileId);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry>
			fetchByC_U_S(long customerId, long userId, String status) {

		return _dgFileUserPermissionEntryLocalService.fetchByC_U_S(
			customerId, userId, status);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			fetchDGFileUserPermissionEntry(long fileUserPermissionId) {

		return _dgFileUserPermissionEntryLocalService.
			fetchDGFileUserPermissionEntry(fileUserPermissionId);
	}

	/**
	 * Returns the dg file user permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file user permission entry's external reference code
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			fetchDGFileUserPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode) {

		return _dgFileUserPermissionEntryLocalService.
			fetchDGFileUserPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileUserPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			fetchDGFileUserPermissionEntryByReferenceCode(
				long companyId, String externalReferenceCode) {

		return _dgFileUserPermissionEntryLocalService.
			fetchDGFileUserPermissionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file user permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file user permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file user permission entry, or <code>null</code> if a matching dg file user permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			fetchDGFileUserPermissionEntryByUuidAndGroupId(
				String uuid, long groupId) {

		return _dgFileUserPermissionEntryLocalService.
			fetchDGFileUserPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFileUserPermissionEntryLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry>
			getAllByFileId(long customerId, long documentManagerFileId) {

		return _dgFileUserPermissionEntryLocalService.getAllByFileId(
			customerId, documentManagerFileId);
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry>
			getDGFileUserPermissionEntries(int start, int end) {

		return _dgFileUserPermissionEntryLocalService.
			getDGFileUserPermissionEntries(start, end);
	}

	/**
	 * Returns all the dg file user permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file user permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file user permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry>
			getDGFileUserPermissionEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _dgFileUserPermissionEntryLocalService.
			getDGFileUserPermissionEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry>
			getDGFileUserPermissionEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.dogoo.common.files.manager.service.model.
						DGFileUserPermissionEntry> orderByComparator) {

		return _dgFileUserPermissionEntryLocalService.
			getDGFileUserPermissionEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file user permission entries.
	 *
	 * @return the number of dg file user permission entries
	 */
	@Override
	public int getDGFileUserPermissionEntriesCount() {
		return _dgFileUserPermissionEntryLocalService.
			getDGFileUserPermissionEntriesCount();
	}

	/**
	 * Returns the dg file user permission entry with the primary key.
	 *
	 * @param fileUserPermissionId the primary key of the dg file user permission entry
	 * @return the dg file user permission entry
	 * @throws PortalException if a dg file user permission entry with the primary key could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
				getDGFileUserPermissionEntry(long fileUserPermissionId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileUserPermissionEntryLocalService.
			getDGFileUserPermissionEntry(fileUserPermissionId);
	}

	/**
	 * Returns the dg file user permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file user permission entry's external reference code
	 * @return the matching dg file user permission entry
	 * @throws PortalException if a matching dg file user permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
				getDGFileUserPermissionEntryByExternalReferenceCode(
					long companyId, String externalReferenceCode)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileUserPermissionEntryLocalService.
			getDGFileUserPermissionEntryByExternalReferenceCode(
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
				getDGFileUserPermissionEntryByUuidAndGroupId(
					String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileUserPermissionEntryLocalService.
			getDGFileUserPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFileUserPermissionEntryLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFileUserPermissionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFileUserPermissionEntryLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileUserPermissionEntryLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			updateDGFileUserPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileUserPermissionEntry dgFileUserPermissionEntry) {

		return _dgFileUserPermissionEntryLocalService.
			updateDGFileUserPermissionEntry(dgFileUserPermissionEntry);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry
			updateFileUserPermission(
				long customerId, long userId, long documentManagerFileId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileUserPermissionMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileUserPermissionEntryLocalService.updateFileUserPermission(
			customerId, userId, documentManagerFileId, model, serviceContext);
	}

	@Override
	public DGFileUserPermissionEntryLocalService getWrappedService() {
		return _dgFileUserPermissionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGFileUserPermissionEntryLocalService
			dgFileUserPermissionEntryLocalService) {

		_dgFileUserPermissionEntryLocalService =
			dgFileUserPermissionEntryLocalService;
	}

	private DGFileUserPermissionEntryLocalService
		_dgFileUserPermissionEntryLocalService;

}