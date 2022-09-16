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
 * Provides a wrapper for {@link DGFileGeneralPermissionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileGeneralPermissionEntryLocalService
 * @generated
 */
public class DGFileGeneralPermissionEntryLocalServiceWrapper
	implements DGFileGeneralPermissionEntryLocalService,
			   ServiceWrapper<DGFileGeneralPermissionEntryLocalService> {

	public DGFileGeneralPermissionEntryLocalServiceWrapper(
		DGFileGeneralPermissionEntryLocalService
			dgFileGeneralPermissionEntryLocalService) {

		_dgFileGeneralPermissionEntryLocalService =
			dgFileGeneralPermissionEntryLocalService;
	}

	/**
	 * Adds the dg file general permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileGeneralPermissionEntry the dg file general permission entry
	 * @return the dg file general permission entry that was added
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry addDGFileGeneralPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		return _dgFileGeneralPermissionEntryLocalService.
			addDGFileGeneralPermissionEntry(dgFileGeneralPermissionEntry);
	}

	/**
	 * Creates a new dg file general permission entry with the primary key. Does not add the dg file general permission entry to the database.
	 *
	 * @param fileGeneralPermissionId the primary key for the new dg file general permission entry
	 * @return the new dg file general permission entry
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry createDGFileGeneralPermissionEntry(
				long fileGeneralPermissionId) {

		return _dgFileGeneralPermissionEntryLocalService.
			createDGFileGeneralPermissionEntry(fileGeneralPermissionId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry createDGFileGeneralPermissionEntry(
				long customerId, long userId, long documentManagerFileId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileGeneralPermissionMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileGeneralPermissionEntryLocalService.
			createDGFileGeneralPermissionEntry(
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

		return _dgFileGeneralPermissionEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dg file general permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileGeneralPermissionEntry the dg file general permission entry
	 * @return the dg file general permission entry that was removed
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry deleteDGFileGeneralPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		return _dgFileGeneralPermissionEntryLocalService.
			deleteDGFileGeneralPermissionEntry(dgFileGeneralPermissionEntry);
	}

	/**
	 * Deletes the dg file general permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileGeneralPermissionId the primary key of the dg file general permission entry
	 * @return the dg file general permission entry that was removed
	 * @throws PortalException if a dg file general permission entry with the primary key could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry deleteDGFileGeneralPermissionEntry(
					long fileGeneralPermissionId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileGeneralPermissionEntryLocalService.
			deleteDGFileGeneralPermissionEntry(fileGeneralPermissionId);
	}

	@Override
	public void deleteDGFileGeneralPermissionEntry(
			long customerId, long documentManagerFileId)
		throws com.dogoo.common.files.manager.service.exception.
			NoSuchDGFileGeneralPermissionEntryException {

		_dgFileGeneralPermissionEntryLocalService.
			deleteDGFileGeneralPermissionEntry(
				customerId, documentManagerFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileGeneralPermissionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFileGeneralPermissionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFileGeneralPermissionEntryLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFileGeneralPermissionEntryLocalService.dynamicQuery();
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

		return _dgFileGeneralPermissionEntryLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileGeneralPermissionEntryModelImpl</code>.
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

		return _dgFileGeneralPermissionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileGeneralPermissionEntryModelImpl</code>.
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

		return _dgFileGeneralPermissionEntryLocalService.dynamicQuery(
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

		return _dgFileGeneralPermissionEntryLocalService.dynamicQueryCount(
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

		return _dgFileGeneralPermissionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry fetchDGFileGeneralPermissionEntry(
				long fileGeneralPermissionId) {

		return _dgFileGeneralPermissionEntryLocalService.
			fetchDGFileGeneralPermissionEntry(fileGeneralPermissionId);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry fetchDGFileGeneralPermissionEntry(
				long customerId, long documentManagerFileId) {

		return _dgFileGeneralPermissionEntryLocalService.
			fetchDGFileGeneralPermissionEntry(
				customerId, documentManagerFileId);
	}

	/**
	 * Returns the dg file general permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file general permission entry's external reference code
	 * @return the matching dg file general permission entry, or <code>null</code> if a matching dg file general permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry
				fetchDGFileGeneralPermissionEntryByExternalReferenceCode(
					long companyId, String externalReferenceCode) {

		return _dgFileGeneralPermissionEntryLocalService.
			fetchDGFileGeneralPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileGeneralPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry
				fetchDGFileGeneralPermissionEntryByReferenceCode(
					long companyId, String externalReferenceCode) {

		return _dgFileGeneralPermissionEntryLocalService.
			fetchDGFileGeneralPermissionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file general permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file general permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file general permission entry, or <code>null</code> if a matching dg file general permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry
				fetchDGFileGeneralPermissionEntryByUuidAndGroupId(
					String uuid, long groupId) {

		return _dgFileGeneralPermissionEntryLocalService.
			fetchDGFileGeneralPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFileGeneralPermissionEntryLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dg file general permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileGeneralPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file general permission entries
	 * @param end the upper bound of the range of dg file general permission entries (not inclusive)
	 * @return the range of dg file general permission entries
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry> getDGFileGeneralPermissionEntries(
				int start, int end) {

		return _dgFileGeneralPermissionEntryLocalService.
			getDGFileGeneralPermissionEntries(start, end);
	}

	/**
	 * Returns all the dg file general permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file general permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file general permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry>
				getDGFileGeneralPermissionEntriesByUuidAndCompanyId(
					String uuid, long companyId) {

		return _dgFileGeneralPermissionEntryLocalService.
			getDGFileGeneralPermissionEntriesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of dg file general permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file general permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file general permission entries
	 * @param end the upper bound of the range of dg file general permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file general permission entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry>
				getDGFileGeneralPermissionEntriesByUuidAndCompanyId(
					String uuid, long companyId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.dogoo.common.files.manager.service.model.
							DGFileGeneralPermissionEntry> orderByComparator) {

		return _dgFileGeneralPermissionEntryLocalService.
			getDGFileGeneralPermissionEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file general permission entries.
	 *
	 * @return the number of dg file general permission entries
	 */
	@Override
	public int getDGFileGeneralPermissionEntriesCount() {
		return _dgFileGeneralPermissionEntryLocalService.
			getDGFileGeneralPermissionEntriesCount();
	}

	/**
	 * Returns the dg file general permission entry with the primary key.
	 *
	 * @param fileGeneralPermissionId the primary key of the dg file general permission entry
	 * @return the dg file general permission entry
	 * @throws PortalException if a dg file general permission entry with the primary key could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry getDGFileGeneralPermissionEntry(
					long fileGeneralPermissionId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileGeneralPermissionEntryLocalService.
			getDGFileGeneralPermissionEntry(fileGeneralPermissionId);
	}

	/**
	 * Returns the dg file general permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file general permission entry's external reference code
	 * @return the matching dg file general permission entry
	 * @throws PortalException if a matching dg file general permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry
					getDGFileGeneralPermissionEntryByExternalReferenceCode(
						long companyId, String externalReferenceCode)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileGeneralPermissionEntryLocalService.
			getDGFileGeneralPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file general permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file general permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file general permission entry
	 * @throws PortalException if a matching dg file general permission entry could not be found
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry
					getDGFileGeneralPermissionEntryByUuidAndGroupId(
						String uuid, long groupId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileGeneralPermissionEntryLocalService.
			getDGFileGeneralPermissionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFileGeneralPermissionEntryLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFileGeneralPermissionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFileGeneralPermissionEntryLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileGeneralPermissionEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dg file general permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileGeneralPermissionEntry the dg file general permission entry
	 * @return the dg file general permission entry that was updated
	 */
	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry updateDGFileGeneralPermissionEntry(
				com.dogoo.common.files.manager.service.model.
					DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		return _dgFileGeneralPermissionEntryLocalService.
			updateDGFileGeneralPermissionEntry(dgFileGeneralPermissionEntry);
	}

	@Override
	public
		com.dogoo.common.files.manager.service.model.
			DGFileGeneralPermissionEntry updateDGFileGeneralPermissionEntry(
				long customerId, long userId, long documentManagerFileId,
				com.dogoo.common.files.manager.service.mapper.model.
					FileGeneralPermissionMapperModel model,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _dgFileGeneralPermissionEntryLocalService.
			updateDGFileGeneralPermissionEntry(
				customerId, userId, documentManagerFileId, model,
				serviceContext);
	}

	@Override
	public DGFileGeneralPermissionEntryLocalService getWrappedService() {
		return _dgFileGeneralPermissionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGFileGeneralPermissionEntryLocalService
			dgFileGeneralPermissionEntryLocalService) {

		_dgFileGeneralPermissionEntryLocalService =
			dgFileGeneralPermissionEntryLocalService;
	}

	private DGFileGeneralPermissionEntryLocalService
		_dgFileGeneralPermissionEntryLocalService;

}