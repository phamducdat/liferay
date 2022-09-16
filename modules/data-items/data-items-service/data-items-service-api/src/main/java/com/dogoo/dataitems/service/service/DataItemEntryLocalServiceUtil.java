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

import com.dogoo.dataitems.service.model.DataItemEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DataItemEntry. This utility wraps
 * <code>com.dogoo.dataitems.service.service.impl.DataItemEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nghiatt
 * @see DataItemEntryLocalService
 * @generated
 */
public class DataItemEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.dataitems.service.service.impl.DataItemEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DataItemEntry addDataItem(
		long customerId, long creatorId, String name, String desc, String type,
		int order, long parentId,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().addDataItem(
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
	public static DataItemEntry addDataItemEntry(DataItemEntry dataItemEntry) {
		return getService().addDataItemEntry(dataItemEntry);
	}

	/**
	 * Creates a new data item entry with the primary key. Does not add the data item entry to the database.
	 *
	 * @param dataItemId the primary key for the new data item entry
	 * @return the new data item entry
	 */
	public static DataItemEntry createDataItemEntry(long dataItemId) {
		return getService().createDataItemEntry(dataItemId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static DataItemEntry deleteDataItemEntry(
		DataItemEntry dataItemEntry) {

		return getService().deleteDataItemEntry(dataItemEntry);
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
	public static DataItemEntry deleteDataItemEntry(long dataItemId)
		throws PortalException {

		return getService().deleteDataItemEntry(dataItemId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.dataitems.service.model.impl.DataItemEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.dataitems.service.model.impl.DataItemEntryModelImpl</code>.
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

	public static DataItemEntry fetchDataItemByName(
		long customerId, long parentId, String type, String name) {

		return getService().fetchDataItemByName(
			customerId, parentId, type, name);
	}

	public static DataItemEntry fetchDataItemEntry(long dataItemId) {
		return getService().fetchDataItemEntry(dataItemId);
	}

	/**
	 * Returns the data item entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the data item entry's external reference code
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchDataItemEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDataItemEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDataItemEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DataItemEntry fetchDataItemEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDataItemEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the data item entry matching the UUID and group.
	 *
	 * @param uuid the data item entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data item entry, or <code>null</code> if a matching data item entry could not be found
	 */
	public static DataItemEntry fetchDataItemEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataItemEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<DataItemEntry> findAllBy(
		long customerId, long parentId, String type) {

		return getService().findAllBy(customerId, parentId, type);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<DataItemEntry> getDataItemEntries(int start, int end) {
		return getService().getDataItemEntries(start, end);
	}

	/**
	 * Returns all the data item entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data item entries
	 * @param companyId the primary key of the company
	 * @return the matching data item entries, or an empty list if no matches were found
	 */
	public static List<DataItemEntry> getDataItemEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDataItemEntriesByUuidAndCompanyId(
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
	public static List<DataItemEntry> getDataItemEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataItemEntry> orderByComparator) {

		return getService().getDataItemEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data item entries.
	 *
	 * @return the number of data item entries
	 */
	public static int getDataItemEntriesCount() {
		return getService().getDataItemEntriesCount();
	}

	/**
	 * Returns the data item entry with the primary key.
	 *
	 * @param dataItemId the primary key of the data item entry
	 * @return the data item entry
	 * @throws PortalException if a data item entry with the primary key could not be found
	 */
	public static DataItemEntry getDataItemEntry(long dataItemId)
		throws PortalException {

		return getService().getDataItemEntry(dataItemId);
	}

	/**
	 * Returns the data item entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the data item entry's external reference code
	 * @return the matching data item entry
	 * @throws PortalException if a matching data item entry could not be found
	 */
	public static DataItemEntry getDataItemEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDataItemEntryByExternalReferenceCode(
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
	public static DataItemEntry getDataItemEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDataItemEntryByUuidAndGroupId(uuid, groupId);
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

	public static DataItemEntry updateDataItem(
			long creatorId, long dataItemId, String name, String desc,
			String type, int order, long parentId,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().updateDataItem(
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
	public static DataItemEntry updateDataItemEntry(
		DataItemEntry dataItemEntry) {

		return getService().updateDataItemEntry(dataItemEntry);
	}

	public static DataItemEntryLocalService getService() {
		return _service;
	}

	private static volatile DataItemEntryLocalService _service;

}