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
 * Provides a wrapper for {@link DGFileVersionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileVersionEntryLocalService
 * @generated
 */
public class DGFileVersionEntryLocalServiceWrapper
	implements DGFileVersionEntryLocalService,
			   ServiceWrapper<DGFileVersionEntryLocalService> {

	public DGFileVersionEntryLocalServiceWrapper(
		DGFileVersionEntryLocalService dgFileVersionEntryLocalService) {

		_dgFileVersionEntryLocalService = dgFileVersionEntryLocalService;
	}

	/**
	 * Adds the dg file version entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 * @return the dg file version entry that was added
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		addDGFileVersionEntry(
			com.dogoo.common.files.manager.service.model.DGFileVersionEntry
				dgFileVersionEntry) {

		return _dgFileVersionEntryLocalService.addDGFileVersionEntry(
			dgFileVersionEntry);
	}

	/**
	 * Creates a new dg file version entry with the primary key. Does not add the dg file version entry to the database.
	 *
	 * @param fileVersionId the primary key for the new dg file version entry
	 * @return the new dg file version entry
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		createDGFileVersionEntry(long fileVersionId) {

		return _dgFileVersionEntryLocalService.createDGFileVersionEntry(
			fileVersionId);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		createDGFileVersionEntry(
			long customerId, long userId, long fileId, long fileVersionId,
			long accountId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _dgFileVersionEntryLocalService.createDGFileVersionEntry(
			customerId, userId, fileId, fileVersionId, accountId,
			serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileVersionEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dg file version entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 * @return the dg file version entry that was removed
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		deleteDGFileVersionEntry(
			com.dogoo.common.files.manager.service.model.DGFileVersionEntry
				dgFileVersionEntry) {

		return _dgFileVersionEntryLocalService.deleteDGFileVersionEntry(
			dgFileVersionEntry);
	}

	/**
	 * Deletes the dg file version entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry that was removed
	 * @throws PortalException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
			deleteDGFileVersionEntry(long fileVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileVersionEntryLocalService.deleteDGFileVersionEntry(
			fileVersionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileVersionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFileVersionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFileVersionEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFileVersionEntryLocalService.dynamicQuery();
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

		return _dgFileVersionEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryModelImpl</code>.
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

		return _dgFileVersionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryModelImpl</code>.
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

		return _dgFileVersionEntryLocalService.dynamicQuery(
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

		return _dgFileVersionEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgFileVersionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		fetchByC_FV(long customerId, long fileVersionId) {

		return _dgFileVersionEntryLocalService.fetchByC_FV(
			customerId, fileVersionId);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		fetchDGFileVersionEntry(long fileVersionId) {

		return _dgFileVersionEntryLocalService.fetchDGFileVersionEntry(
			fileVersionId);
	}

	/**
	 * Returns the dg file version entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file version entry's external reference code
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		fetchDGFileVersionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFileVersionEntryLocalService.
			fetchDGFileVersionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileVersionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		fetchDGFileVersionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFileVersionEntryLocalService.
			fetchDGFileVersionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file version entry matching the UUID and group.
	 *
	 * @param uuid the dg file version entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file version entry, or <code>null</code> if a matching dg file version entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		fetchDGFileVersionEntryByUuidAndGroupId(String uuid, long groupId) {

		return _dgFileVersionEntryLocalService.
			fetchDGFileVersionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFileVersionEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dg file version entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileVersionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @return the range of dg file version entries
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileVersionEntry>
			getDGFileVersionEntries(int start, int end) {

		return _dgFileVersionEntryLocalService.getDGFileVersionEntries(
			start, end);
	}

	/**
	 * Returns all the dg file version entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file version entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file version entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileVersionEntry>
			getDGFileVersionEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _dgFileVersionEntryLocalService.
			getDGFileVersionEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dg file version entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file version entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file version entries
	 * @param end the upper bound of the range of dg file version entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file version entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFileVersionEntry>
			getDGFileVersionEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.dogoo.common.files.manager.service.model.
						DGFileVersionEntry> orderByComparator) {

		return _dgFileVersionEntryLocalService.
			getDGFileVersionEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file version entries.
	 *
	 * @return the number of dg file version entries
	 */
	@Override
	public int getDGFileVersionEntriesCount() {
		return _dgFileVersionEntryLocalService.getDGFileVersionEntriesCount();
	}

	/**
	 * Returns the dg file version entry with the primary key.
	 *
	 * @param fileVersionId the primary key of the dg file version entry
	 * @return the dg file version entry
	 * @throws PortalException if a dg file version entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
			getDGFileVersionEntry(long fileVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileVersionEntryLocalService.getDGFileVersionEntry(
			fileVersionId);
	}

	/**
	 * Returns the dg file version entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file version entry's external reference code
	 * @return the matching dg file version entry
	 * @throws PortalException if a matching dg file version entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
			getDGFileVersionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileVersionEntryLocalService.
			getDGFileVersionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file version entry matching the UUID and group.
	 *
	 * @param uuid the dg file version entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file version entry
	 * @throws PortalException if a matching dg file version entry could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
			getDGFileVersionEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileVersionEntryLocalService.
			getDGFileVersionEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFileVersionEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFileVersionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFileVersionEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFileVersionEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dg file version entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileVersionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileVersionEntry the dg file version entry
	 * @return the dg file version entry that was updated
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFileVersionEntry
		updateDGFileVersionEntry(
			com.dogoo.common.files.manager.service.model.DGFileVersionEntry
				dgFileVersionEntry) {

		return _dgFileVersionEntryLocalService.updateDGFileVersionEntry(
			dgFileVersionEntry);
	}

	@Override
	public DGFileVersionEntryLocalService getWrappedService() {
		return _dgFileVersionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DGFileVersionEntryLocalService dgFileVersionEntryLocalService) {

		_dgFileVersionEntryLocalService = dgFileVersionEntryLocalService;
	}

	private DGFileVersionEntryLocalService _dgFileVersionEntryLocalService;

}