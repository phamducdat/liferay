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

package com.dogoo.dataitems.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataItemEntryLocalService}.
 *
 * @author nghiatt
 * @see DataItemEntryLocalService
 * @generated
 */
public class DataItemEntryLocalServiceWrapper
	implements DataItemEntryLocalService,
			   ServiceWrapper<DataItemEntryLocalService> {

	public DataItemEntryLocalServiceWrapper(
		DataItemEntryLocalService dataItemEntryLocalService) {

		_dataItemEntryLocalService = dataItemEntryLocalService;
	}

	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry addDataItem(
		long customerId, long creatorId, String name, String desc, String type,
		int order, long parentId,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return _dataItemEntryLocalService.addDataItem(
			customerId, creatorId, name, desc, type, order, parentId, context);
	}

	/**
	 * Adds the data item entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataItemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataItemEntry the data item entry
	 * @return the data item entry that was added
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry addDataItemEntry(
		com.dogoo.dataitems.service.model.DataItemEntry dataItemEntry) {

		return _dataItemEntryLocalService.addDataItemEntry(dataItemEntry);
	}

	/**
	 * Creates a new data item entry with the primary key. Does not add the data item entry to the database.
	 *
	 * @param dataItemId the primary key for the new data item entry
	 * @return the new data item entry
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry createDataItemEntry(
		long dataItemId) {

		return _dataItemEntryLocalService.createDataItemEntry(dataItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the data item entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataItemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataItemEntry the data item entry
	 * @return the data item entry that was removed
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry deleteDataItemEntry(
		com.dogoo.dataitems.service.model.DataItemEntry dataItemEntry) {

		return _dataItemEntryLocalService.deleteDataItemEntry(dataItemEntry);
	}

	/**
	 * Deletes the data item entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataItemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry that was removed
	 * @throws PortalException if a data item entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry deleteDataItemEntry(
			long dataItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.deleteDataItemEntry(dataItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dataItemEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dataItemEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataItemEntryLocalService.dynamicQuery();
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

		return _dataItemEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.dataitems.service.model.impl.DataItemEntryModelImpl</code>.
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

		return _dataItemEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.dataitems.service.model.impl.DataItemEntryModelImpl</code>.
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

		return _dataItemEntryLocalService.dynamicQuery(
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

		return _dataItemEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataItemEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry fetchDataItemByName(
		long customerId, long parentId, String type, String name) {

		return _dataItemEntryLocalService.fetchDataItemByName(
			customerId, parentId, type, name);
	}

	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry fetchDataItemEntry(
		long dataItemId) {

		return _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);
	}

	/**
	 * Returns the data item entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the data item entry's external reference code
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry
		fetchDataItemEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dataItemEntryLocalService.
			fetchDataItemEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDataItemEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry
		fetchDataItemEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dataItemEntryLocalService.fetchDataItemEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the data item entry matching the UUID and group.
	 *
	 * @param uuid the data item entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry
		fetchDataItemEntryByUuidAndGroupId(String uuid, long groupId) {

		return _dataItemEntryLocalService.fetchDataItemEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.dogoo.dataitems.service.model.DataItemEntry>
		findAllBy(long customerId, long parentId, String type) {

		return _dataItemEntryLocalService.findAllBy(customerId, parentId, type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataItemEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the data item entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.dataitems.service.model.impl.DataItemEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @return the range of data item entries
	 */
	@Override
	public java.util.List<com.dogoo.dataitems.service.model.DataItemEntry>
		getDataItemEntries(int start, int end) {

		return _dataItemEntryLocalService.getDataItemEntries(start, end);
	}

	/**
	 * Returns all the data item entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data item entries
	 * @param companyId the primary key of the company
	 * @return the matching data item entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.dataitems.service.model.DataItemEntry>
		getDataItemEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _dataItemEntryLocalService.getDataItemEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data item entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data item entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data item entries
	 * @param end the upper bound of the range of data item entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data item entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.dataitems.service.model.DataItemEntry>
		getDataItemEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.dataitems.service.model.DataItemEntry>
					orderByComparator) {

		return _dataItemEntryLocalService.getDataItemEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data item entries.
	 *
	 * @return the number of data item entries
	 */
	@Override
	public int getDataItemEntriesCount() {
		return _dataItemEntryLocalService.getDataItemEntriesCount();
	}

	/**
	 * Returns the data item entry with the primary key.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry
	 * @throws PortalException if a data item entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry getDataItemEntry(
			long dataItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.getDataItemEntry(dataItemId);
	}

	/**
	 * Returns the data item entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the data item entry's external reference code
	 * @return the matching data item entry
	 * @throws PortalException if a matching data item entry could not be found
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry
			getDataItemEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.
			getDataItemEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the data item entry matching the UUID and group.
	 *
	 * @param uuid the data item entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data item entry
	 * @throws PortalException if a matching data item entry could not be found
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry
			getDataItemEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.getDataItemEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataItemEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataItemEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataItemEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry updateDataItem(
			long creatorId, long dataItemId, String name, String desc,
			String type, int order, long parentId,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataItemEntryLocalService.updateDataItem(
			creatorId, dataItemId, name, desc, type, order, parentId, context);
	}

	/**
	 * Updates the data item entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataItemEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataItemEntry the data item entry
	 * @return the data item entry that was updated
	 */
	@Override
	public com.dogoo.dataitems.service.model.DataItemEntry updateDataItemEntry(
		com.dogoo.dataitems.service.model.DataItemEntry dataItemEntry) {

		return _dataItemEntryLocalService.updateDataItemEntry(dataItemEntry);
	}

	@Override
	public DataItemEntryLocalService getWrappedService() {
		return _dataItemEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DataItemEntryLocalService dataItemEntryLocalService) {

		_dataItemEntryLocalService = dataItemEntryLocalService;
	}

	private DataItemEntryLocalService _dataItemEntryLocalService;

}