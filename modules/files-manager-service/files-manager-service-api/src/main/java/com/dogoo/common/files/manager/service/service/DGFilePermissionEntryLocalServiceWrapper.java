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
 * Provides a wrapper for {@link DGFilePermissionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionEntryLocalService
 * @generated
 */
public class DGFilePermissionEntryLocalServiceWrapper
	implements DGFilePermissionEntryLocalService,
			   ServiceWrapper<DGFilePermissionEntryLocalService> {

	public DGFilePermissionEntryLocalServiceWrapper(
		DGFilePermissionEntryLocalService dgFilePermissionEntryLocalService) {

		_dgFilePermissionEntryLocalService = dgFilePermissionEntryLocalService;
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		addDGFilePermission(
			long customerId, long userId,
			com.dogoo.common.files.manager.service.mapper.model.
				FilePermissionMapperModel model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _dgFilePermissionEntryLocalService.addDGFilePermission(
			customerId, userId, model, serviceContext);
	}

	/**
	 * Adds the dg file permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermissionEntry the dg file permission entry
	 * @return the dg file permission entry that was added
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		addDGFilePermissionEntry(
			com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
				dgFilePermissionEntry) {

		return _dgFilePermissionEntryLocalService.addDGFilePermissionEntry(
			dgFilePermissionEntry);
	}

	/**
	 * Creates a new dg file permission entry with the primary key. Does not add the dg file permission entry to the database.
	 *
	 * @param filePermissionId the primary key for the new dg file permission entry
	 * @return the new dg file permission entry
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		createDGFilePermissionEntry(long filePermissionId) {

		return _dgFilePermissionEntryLocalService.createDGFilePermissionEntry(
			filePermissionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dg file permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermissionEntry the dg file permission entry
	 * @return the dg file permission entry that was removed
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		deleteDGFilePermissionEntry(
			com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
				dgFilePermissionEntry) {

		return _dgFilePermissionEntryLocalService.deleteDGFilePermissionEntry(
			dgFilePermissionEntry);
	}

	/**
	 * Deletes the dg file permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param filePermissionId the primary key of the dg file permission entry
	 * @return the dg file permission entry that was removed
	 * @throws PortalException if a dg file permission entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
			deleteDGFilePermissionEntry(long filePermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionEntryLocalService.deleteDGFilePermissionEntry(
			filePermissionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFilePermissionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFilePermissionEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFilePermissionEntryLocalService.dynamicQuery();
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

		return _dgFilePermissionEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryModelImpl</code>.
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

		return _dgFilePermissionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryModelImpl</code>.
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

		return _dgFilePermissionEntryLocalService.dynamicQuery(
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

		return _dgFilePermissionEntryLocalService.dynamicQueryCount(
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

		return _dgFilePermissionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		fetchDGFilePermissionEntry(long filePermissionId) {

		return _dgFilePermissionEntryLocalService.fetchDGFilePermissionEntry(
			filePermissionId);
	}

	/**
	 * Returns the dg file permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission entry's external reference code
	 * @return the matching dg file permission entry, or <code>null</code> if a matching dg file permission entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		fetchDGFilePermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFilePermissionEntryLocalService.
			fetchDGFilePermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFilePermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		fetchDGFilePermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFilePermissionEntryLocalService.
			fetchDGFilePermissionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file permission entry, or <code>null</code> if a matching dg file permission entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		fetchDGFilePermissionEntryByUuidAndGroupId(String uuid, long groupId) {

		return _dgFilePermissionEntryLocalService.
			fetchDGFilePermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFilePermissionEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dg file permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permission entries
	 * @param end the upper bound of the range of dg file permission entries (not inclusive)
	 * @return the range of dg file permission entries
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFilePermissionEntry>
			getDGFilePermissionEntries(int start, int end) {

		return _dgFilePermissionEntryLocalService.getDGFilePermissionEntries(
			start, end);
	}

	/**
	 * Returns all the dg file permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFilePermissionEntry>
			getDGFilePermissionEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _dgFilePermissionEntryLocalService.
			getDGFilePermissionEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dg file permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file permission entries
	 * @param end the upper bound of the range of dg file permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFilePermissionEntry>
			getDGFilePermissionEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.dogoo.common.files.manager.service.model.
						DGFilePermissionEntry> orderByComparator) {

		return _dgFilePermissionEntryLocalService.
			getDGFilePermissionEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file permission entries.
	 *
	 * @return the number of dg file permission entries
	 */
	@Override
	public int getDGFilePermissionEntriesCount() {
		return _dgFilePermissionEntryLocalService.
			getDGFilePermissionEntriesCount();
	}

	/**
	 * Returns the dg file permission entry with the primary key.
	 *
	 * @param filePermissionId the primary key of the dg file permission entry
	 * @return the dg file permission entry
	 * @throws PortalException if a dg file permission entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
			getDGFilePermissionEntry(long filePermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionEntryLocalService.getDGFilePermissionEntry(
			filePermissionId);
	}

	/**
	 * Returns the dg file permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission entry's external reference code
	 * @return the matching dg file permission entry
	 * @throws PortalException if a matching dg file permission entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
			getDGFilePermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionEntryLocalService.
			getDGFilePermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file permission entry
	 * @throws PortalException if a matching dg file permission entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
			getDGFilePermissionEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionEntryLocalService.
			getDGFilePermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFilePermissionEntryLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFilePermissionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFilePermissionEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dg file permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermissionEntry the dg file permission entry
	 * @return the dg file permission entry that was updated
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
		updateDGFilePermissionEntry(
			com.dogoo.common.files.manager.service.model.DGFilePermissionEntry
				dgFilePermissionEntry) {

		return _dgFilePermissionEntryLocalService.updateDGFilePermissionEntry(
			dgFilePermissionEntry);
	}

	@Override
	public DGFilePermissionEntryLocalService getWrappedService() {
		return _dgFilePermissionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGFilePermissionEntryLocalService dgFilePermissionEntryLocalService) {

		_dgFilePermissionEntryLocalService = dgFilePermissionEntryLocalService;
	}

	private DGFilePermissionEntryLocalService
		_dgFilePermissionEntryLocalService;

}