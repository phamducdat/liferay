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
 * Provides a wrapper for {@link DGFileDepartmentPermissionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileDepartmentPermissionEntryLocalService
 * @generated
 */
public class DGFileDepartmentPermissionEntryLocalServiceWrapper
	implements DGFileDepartmentPermissionEntryLocalService,
			   ServiceWrapper<DGFileDepartmentPermissionEntryLocalService> {

	public DGFileDepartmentPermissionEntryLocalServiceWrapper(
		DGFileDepartmentPermissionEntryLocalService
			dgFileDepartmentPermissionEntryLocalService) {

		_dgFileDepartmentPermissionEntryLocalService =
			dgFileDepartmentPermissionEntryLocalService;
	}

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
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry addDGFileDepartmentPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileDepartmentPermissionEntry
						dgFileDepartmentPermissionEntry) {

		return _dgFileDepartmentPermissionEntryLocalService.
			addDGFileDepartmentPermissionEntry(dgFileDepartmentPermissionEntry);
	}

	/**
	 * Creates a new dg file department permission entry with the primary key. Does not add the dg file department permission entry to the database.
	 *
	 * @param fileDepartmentPermissionId the primary key for the new dg file department permission entry
	 * @return the new dg file department permission entry
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
				createDGFileDepartmentPermissionEntry(
					long fileDepartmentPermissionId) {

		return _dgFileDepartmentPermissionEntryLocalService.
			createDGFileDepartmentPermissionEntry(fileDepartmentPermissionId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry createFileDepartmentPermission(
				long customerId, long userId, long documentManagerFileId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileDepartmentPermissionMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileDepartmentPermissionEntryLocalService.
			createFileDepartmentPermission(
				customerId, userId, documentManagerFileId, model,
				serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileDepartmentPermissionEntryLocalService.
			createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAllFileDepartmentPermissionByFileId(
		long customerId, long documentManagerFileId) {

		_dgFileDepartmentPermissionEntryLocalService.
			deleteAllFileDepartmentPermissionByFileId(
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
				deleteDGFileDepartmentPermissionEntry(
					com.dogoo.common.files.manager.service.model.
						DGFileDepartmentPermissionEntry
							dgFileDepartmentPermissionEntry) {

		return _dgFileDepartmentPermissionEntryLocalService.
			deleteDGFileDepartmentPermissionEntry(
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
					deleteDGFileDepartmentPermissionEntry(
						long fileDepartmentPermissionId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileDepartmentPermissionEntryLocalService.
			deleteDGFileDepartmentPermissionEntry(fileDepartmentPermissionId);
	}

	@Override
	public void deleteFileDepartmentPermission(
			long customerId, long departmentId, long documentManagerFileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileDepartmentPermissionEntryException {

		_dgFileDepartmentPermissionEntryLocalService.
			deleteFileDepartmentPermission(
				customerId, departmentId, documentManagerFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileDepartmentPermissionEntryLocalService.
			deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFileDepartmentPermissionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFileDepartmentPermissionEntryLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFileDepartmentPermissionEntryLocalService.dynamicQuery();
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

		return _dgFileDepartmentPermissionEntryLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgFileDepartmentPermissionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgFileDepartmentPermissionEntryLocalService.dynamicQuery(
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

		return _dgFileDepartmentPermissionEntryLocalService.dynamicQueryCount(
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

		return _dgFileDepartmentPermissionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry> fetchByC_D(
				long customerId, long departmentId) {

		return _dgFileDepartmentPermissionEntryLocalService.fetchByC_D(
			customerId, departmentId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry fetchByC_D_F(
				long customerId, long departmentId,
				long documentManagerFileId) {

		return _dgFileDepartmentPermissionEntryLocalService.fetchByC_D_F(
			customerId, departmentId, documentManagerFileId);
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry> fetchByC_F(
				long customerId, long documentManagerFileId) {

		return _dgFileDepartmentPermissionEntryLocalService.fetchByC_F(
			customerId, documentManagerFileId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
				fetchDGFileDepartmentPermissionEntry(
					long fileDepartmentPermissionId) {

		return _dgFileDepartmentPermissionEntryLocalService.
			fetchDGFileDepartmentPermissionEntry(fileDepartmentPermissionId);
	}

	/**
	 * Returns the dg file department permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file department permission entry's external reference code
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
				fetchDGFileDepartmentPermissionEntryByExternalReferenceCode(
					long companyId, String externalReferenceCode) {

		return _dgFileDepartmentPermissionEntryLocalService.
			fetchDGFileDepartmentPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileDepartmentPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
				fetchDGFileDepartmentPermissionEntryByReferenceCode(
					long companyId, String externalReferenceCode) {

		return _dgFileDepartmentPermissionEntryLocalService.
			fetchDGFileDepartmentPermissionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file department permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file department permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file department permission entry, or <code>null</code> if a matching dg file department permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
				fetchDGFileDepartmentPermissionEntryByUuidAndGroupId(
					String uuid, long groupId) {

		return _dgFileDepartmentPermissionEntryLocalService.
			fetchDGFileDepartmentPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFileDepartmentPermissionEntryLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry> getAllByFileId(
				long customerId, long documentManagerFileId) {

		return _dgFileDepartmentPermissionEntryLocalService.getAllByFileId(
			customerId, documentManagerFileId);
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry>
				getDGFileDepartmentPermissionEntries(int start, int end) {

		return _dgFileDepartmentPermissionEntryLocalService.
			getDGFileDepartmentPermissionEntries(start, end);
	}

	/**
	 * Returns all the dg file department permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file department permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file department permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry>
				getDGFileDepartmentPermissionEntriesByUuidAndCompanyId(
					String uuid, long companyId) {

		return _dgFileDepartmentPermissionEntryLocalService.
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
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry>
				getDGFileDepartmentPermissionEntriesByUuidAndCompanyId(
					String uuid, long companyId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.dogoo.common.files.manager.service.model.
							DGFileDepartmentPermissionEntry>
								orderByComparator) {

		return _dgFileDepartmentPermissionEntryLocalService.
			getDGFileDepartmentPermissionEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file department permission entries.
	 *
	 * @return the number of dg file department permission entries
	 */
	@Override
	public int getDGFileDepartmentPermissionEntriesCount() {
		return _dgFileDepartmentPermissionEntryLocalService.
			getDGFileDepartmentPermissionEntriesCount();
	}

	/**
	 * Returns the dg file department permission entry with the primary key.
	 *
	 * @param fileDepartmentPermissionId the primary key of the dg file department permission entry
	 * @return the dg file department permission entry
	 * @throws PortalException if a dg file department permission entry with the primary key could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry getDGFileDepartmentPermissionEntry(
					long fileDepartmentPermissionId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileDepartmentPermissionEntryLocalService.
			getDGFileDepartmentPermissionEntry(fileDepartmentPermissionId);
	}

	/**
	 * Returns the dg file department permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file department permission entry's external reference code
	 * @return the matching dg file department permission entry
	 * @throws PortalException if a matching dg file department permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
					getDGFileDepartmentPermissionEntryByExternalReferenceCode(
						long companyId, String externalReferenceCode)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileDepartmentPermissionEntryLocalService.
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
					getDGFileDepartmentPermissionEntryByUuidAndGroupId(
						String uuid, long groupId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileDepartmentPermissionEntryLocalService.
			getDGFileDepartmentPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFileDepartmentPermissionEntryLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFileDepartmentPermissionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFileDepartmentPermissionEntryLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileDepartmentPermissionEntryLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry
				updateDGFileDepartmentPermissionEntry(
					com.dogoo.common.files.manager.service.model.
						DGFileDepartmentPermissionEntry
							dgFileDepartmentPermissionEntry) {

		return _dgFileDepartmentPermissionEntryLocalService.
			updateDGFileDepartmentPermissionEntry(
				dgFileDepartmentPermissionEntry);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileDepartmentPermissionEntry updateRoleFileDepartmentPermission(
				long customerId, long userId, long departmentId,
				long documentManagerFileId, String role,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileDepartmentPermissionEntryLocalService.
			updateRoleFileDepartmentPermission(
				customerId, userId, departmentId, documentManagerFileId, role,
				serviceContext);
	}

	@Override
	public DGFileDepartmentPermissionEntryLocalService getWrappedService() {
		return _dgFileDepartmentPermissionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGFileDepartmentPermissionEntryLocalService
			dgFileDepartmentPermissionEntryLocalService) {

		_dgFileDepartmentPermissionEntryLocalService =
			dgFileDepartmentPermissionEntryLocalService;
	}

	private DGFileDepartmentPermissionEntryLocalService
		_dgFileDepartmentPermissionEntryLocalService;

}