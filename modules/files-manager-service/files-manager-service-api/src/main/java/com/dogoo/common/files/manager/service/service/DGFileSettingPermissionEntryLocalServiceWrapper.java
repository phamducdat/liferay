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
 * Provides a wrapper for {@link DGFileSettingPermissionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileSettingPermissionEntryLocalService
 * @generated
 */
public class DGFileSettingPermissionEntryLocalServiceWrapper
	implements DGFileSettingPermissionEntryLocalService,
			   ServiceWrapper<DGFileSettingPermissionEntryLocalService> {

	public DGFileSettingPermissionEntryLocalServiceWrapper(
		DGFileSettingPermissionEntryLocalService
			dgFileSettingPermissionEntryLocalService) {

		_dgFileSettingPermissionEntryLocalService =
			dgFileSettingPermissionEntryLocalService;
	}

	/**
	 * Adds the dg file setting permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 * @return the dg file setting permission entry that was added
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry addDGFileSettingPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		return _dgFileSettingPermissionEntryLocalService.
			addDGFileSettingPermissionEntry(dgFileSettingPermissionEntry);
	}

	/**
	 * Creates a new dg file setting permission entry with the primary key. Does not add the dg file setting permission entry to the database.
	 *
	 * @param fileSettingPermissionId the primary key for the new dg file setting permission entry
	 * @return the new dg file setting permission entry
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry createDGFileSettingPermissionEntry(
				long fileSettingPermissionId) {

		return _dgFileSettingPermissionEntryLocalService.
			createDGFileSettingPermissionEntry(fileSettingPermissionId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry createDGFileSettingPermissionEntry(
				long customerId, long userId, long documentManagerFileId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileSettingPermissionMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileSettingPermissionEntryLocalService.
			createDGFileSettingPermissionEntry(
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

		return _dgFileSettingPermissionEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dg file setting permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 * @return the dg file setting permission entry that was removed
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry deleteDGFileSettingPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		return _dgFileSettingPermissionEntryLocalService.
			deleteDGFileSettingPermissionEntry(dgFileSettingPermissionEntry);
	}

	/**
	 * Deletes the dg file setting permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry that was removed
	 * @throws PortalException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry deleteDGFileSettingPermissionEntry(
					long fileSettingPermissionId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileSettingPermissionEntryLocalService.
			deleteDGFileSettingPermissionEntry(fileSettingPermissionId);
	}

	@Override
	public void deleteDGFileSettingPermissionEntry(
			long customerId, long documentManagerFileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileSettingPermissionEntryException {

		_dgFileSettingPermissionEntryLocalService.
			deleteDGFileSettingPermissionEntry(
				customerId, documentManagerFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileSettingPermissionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFileSettingPermissionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFileSettingPermissionEntryLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFileSettingPermissionEntryLocalService.dynamicQuery();
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

		return _dgFileSettingPermissionEntryLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryModelImpl</code>.
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

		return _dgFileSettingPermissionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryModelImpl</code>.
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

		return _dgFileSettingPermissionEntryLocalService.dynamicQuery(
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

		return _dgFileSettingPermissionEntryLocalService.dynamicQueryCount(
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

		return _dgFileSettingPermissionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry fetchDGFileSettingPermissionEntry(
				long fileSettingPermissionId) {

		return _dgFileSettingPermissionEntryLocalService.
			fetchDGFileSettingPermissionEntry(fileSettingPermissionId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry fetchDGFileSettingPermissionEntry(
				long customerId, long documentManagerFileId) {

		return _dgFileSettingPermissionEntryLocalService.
			fetchDGFileSettingPermissionEntry(
				customerId, documentManagerFileId);
	}

	/**
	 * Returns the dg file setting permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file setting permission entry's external reference code
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry
				fetchDGFileSettingPermissionEntryByExternalReferenceCode(
					long companyId, String externalReferenceCode) {

		return _dgFileSettingPermissionEntryLocalService.
			fetchDGFileSettingPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileSettingPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry
				fetchDGFileSettingPermissionEntryByReferenceCode(
					long companyId, String externalReferenceCode) {

		return _dgFileSettingPermissionEntryLocalService.
			fetchDGFileSettingPermissionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file setting permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file setting permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry
				fetchDGFileSettingPermissionEntryByUuidAndGroupId(
					String uuid, long groupId) {

		return _dgFileSettingPermissionEntryLocalService.
			fetchDGFileSettingPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFileSettingPermissionEntryLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of dg file setting permission entries
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry> getDGFileSettingPermissionEntries(
				int start, int end) {

		return _dgFileSettingPermissionEntryLocalService.
			getDGFileSettingPermissionEntries(start, end);
	}

	/**
	 * Returns all the dg file setting permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file setting permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file setting permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry>
				getDGFileSettingPermissionEntriesByUuidAndCompanyId(
					String uuid, long companyId) {

		return _dgFileSettingPermissionEntryLocalService.
			getDGFileSettingPermissionEntriesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of dg file setting permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file setting permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file setting permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry>
				getDGFileSettingPermissionEntriesByUuidAndCompanyId(
					String uuid, long companyId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.dogoo.common.files.manager.service.model.
							DGFileSettingPermissionEntry> orderByComparator) {

		return _dgFileSettingPermissionEntryLocalService.
			getDGFileSettingPermissionEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file setting permission entries.
	 *
	 * @return the number of dg file setting permission entries
	 */
	@Override
	public int getDGFileSettingPermissionEntriesCount() {
		return _dgFileSettingPermissionEntryLocalService.
			getDGFileSettingPermissionEntriesCount();
	}

	/**
	 * Returns the dg file setting permission entry with the primary key.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry
	 * @throws PortalException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry getDGFileSettingPermissionEntry(
					long fileSettingPermissionId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileSettingPermissionEntryLocalService.
			getDGFileSettingPermissionEntry(fileSettingPermissionId);
	}

	/**
	 * Returns the dg file setting permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file setting permission entry's external reference code
	 * @return the matching dg file setting permission entry
	 * @throws PortalException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry
					getDGFileSettingPermissionEntryByExternalReferenceCode(
						long companyId, String externalReferenceCode)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileSettingPermissionEntryLocalService.
			getDGFileSettingPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file setting permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file setting permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file setting permission entry
	 * @throws PortalException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry
					getDGFileSettingPermissionEntryByUuidAndGroupId(
						String uuid, long groupId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileSettingPermissionEntryLocalService.
			getDGFileSettingPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFileSettingPermissionEntryLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFileSettingPermissionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFileSettingPermissionEntryLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileSettingPermissionEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dg file setting permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 * @return the dg file setting permission entry that was updated
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry updateDGFileSettingPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		return _dgFileSettingPermissionEntryLocalService.
			updateDGFileSettingPermissionEntry(dgFileSettingPermissionEntry);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileSettingPermissionEntry updateDGFileSettingPermissionEntry(
				long customerId, long userId, long documentManagerFileId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileSettingPermissionMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileSettingPermissionEntryLocalService.
			updateDGFileSettingPermissionEntry(
				customerId, userId, documentManagerFileId, model,
				serviceContext);
	}

	@Override
	public DGFileSettingPermissionEntryLocalService getWrappedService() {
		return _dgFileSettingPermissionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGFileSettingPermissionEntryLocalService
			dgFileSettingPermissionEntryLocalService) {

		_dgFileSettingPermissionEntryLocalService =
			dgFileSettingPermissionEntryLocalService;
	}

	private DGFileSettingPermissionEntryLocalService
		_dgFileSettingPermissionEntryLocalService;

}