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

package com.dogoo.department.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DepartmentEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntryLocalService
 * @generated
 */
public class DepartmentEntryLocalServiceWrapper
	implements DepartmentEntryLocalService,
			   ServiceWrapper<DepartmentEntryLocalService> {

	public DepartmentEntryLocalServiceWrapper(
		DepartmentEntryLocalService departmentEntryLocalService) {

		_departmentEntryLocalService = departmentEntryLocalService;
	}

	/**
	 * Adds the department entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentEntry the department entry
	 * @return the department entry that was added
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		addDepartmentEntry(
			com.dogoo.department.service.model.DepartmentEntry
				departmentEntry) {

		return _departmentEntryLocalService.addDepartmentEntry(departmentEntry);
	}

	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		addDepartmentEntry(
			long customerId, long creatorId,
			com.dogoo.department.service.mapper.model.DepartmentMapperModel
				model,
			com.liferay.portal.kernel.service.ServiceContext context) {

		return _departmentEntryLocalService.addDepartmentEntry(
			customerId, creatorId, model, context);
	}

	/**
	 * Creates a new department entry with the primary key. Does not add the department entry to the database.
	 *
	 * @param departmentId the primary key for the new department entry
	 * @return the new department entry
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		createDepartmentEntry(long departmentId) {

		return _departmentEntryLocalService.createDepartmentEntry(departmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the department entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentEntry the department entry
	 * @return the department entry that was removed
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		deleteDepartmentEntry(
			com.dogoo.department.service.model.DepartmentEntry
				departmentEntry) {

		return _departmentEntryLocalService.deleteDepartmentEntry(
			departmentEntry);
	}

	/**
	 * Deletes the department entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry that was removed
	 * @throws PortalException if a department entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
			deleteDepartmentEntry(long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.deleteDepartmentEntry(departmentId);
	}

	@Override
	public com.dogoo.department.service.model.DepartmentEntry
			deleteDepartmentEntryById(long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.deleteDepartmentEntryById(
			departmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _departmentEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _departmentEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _departmentEntryLocalService.dynamicQuery();
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

		return _departmentEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.department.service.model.impl.DepartmentEntryModelImpl</code>.
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

		return _departmentEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.department.service.model.impl.DepartmentEntryModelImpl</code>.
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

		return _departmentEntryLocalService.dynamicQuery(
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

		return _departmentEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _departmentEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		fetchDepartmentEntry(long departmentId) {

		return _departmentEntryLocalService.fetchDepartmentEntry(departmentId);
	}

	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		fetchDepartmentEntryByCode(long customerId, String code) {

		return _departmentEntryLocalService.fetchDepartmentEntryByCode(
			customerId, code);
	}

	/**
	 * Returns the department entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department entry's external reference code
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		fetchDepartmentEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _departmentEntryLocalService.
			fetchDepartmentEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		fetchDepartmentEntryByName(long customerId, String name) {

		return _departmentEntryLocalService.fetchDepartmentEntryByName(
			customerId, name);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDepartmentEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		fetchDepartmentEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _departmentEntryLocalService.fetchDepartmentEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		fetchDepartmentEntryByTax(long customerId, String tax) {

		return _departmentEntryLocalService.fetchDepartmentEntryByTax(
			customerId, tax);
	}

	/**
	 * Returns the department entry matching the UUID and group.
	 *
	 * @param uuid the department entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		fetchDepartmentEntryByUuidAndGroupId(String uuid, long groupId) {

		return _departmentEntryLocalService.
			fetchDepartmentEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _departmentEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.department.service.model.impl.DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of department entries
	 */
	@Override
	public java.util.List<com.dogoo.department.service.model.DepartmentEntry>
		getDepartmentEntries(int start, int end) {

		return _departmentEntryLocalService.getDepartmentEntries(start, end);
	}

	@Override
	public java.util.List<com.dogoo.department.service.model.DepartmentEntry>
		getDepartmentEntries(long customerId) {

		return _departmentEntryLocalService.getDepartmentEntries(customerId);
	}

	@Override
	public java.util.List<com.dogoo.department.service.model.DepartmentEntry>
		getDepartmentEntries(long customerId, long parentId) {

		return _departmentEntryLocalService.getDepartmentEntries(
			customerId, parentId);
	}

	/**
	 * Returns all the department entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the department entries
	 * @param companyId the primary key of the company
	 * @return the matching department entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.department.service.model.DepartmentEntry>
		getDepartmentEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _departmentEntryLocalService.
			getDepartmentEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of department entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the department entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching department entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.department.service.model.DepartmentEntry>
		getDepartmentEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.department.service.model.DepartmentEntry>
					orderByComparator) {

		return _departmentEntryLocalService.
			getDepartmentEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of department entries.
	 *
	 * @return the number of department entries
	 */
	@Override
	public int getDepartmentEntriesCount() {
		return _departmentEntryLocalService.getDepartmentEntriesCount();
	}

	/**
	 * Returns the department entry with the primary key.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry
	 * @throws PortalException if a department entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
			getDepartmentEntry(long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.getDepartmentEntry(departmentId);
	}

	/**
	 * Returns the department entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department entry's external reference code
	 * @return the matching department entry
	 * @throws PortalException if a matching department entry could not be found
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
			getDepartmentEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.
			getDepartmentEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the department entry matching the UUID and group.
	 *
	 * @param uuid the department entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching department entry
	 * @throws PortalException if a matching department entry could not be found
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
			getDepartmentEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.getDepartmentEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public String getDepartmentNameTree(long departmentId) {
		return _departmentEntryLocalService.getDepartmentNameTree(departmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _departmentEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _departmentEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _departmentEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the department entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentEntry the department entry
	 * @return the department entry that was updated
	 */
	@Override
	public com.dogoo.department.service.model.DepartmentEntry
		updateDepartmentEntry(
			com.dogoo.department.service.model.DepartmentEntry
				departmentEntry) {

		return _departmentEntryLocalService.updateDepartmentEntry(
			departmentEntry);
	}

	@Override
	public com.dogoo.department.service.model.DepartmentEntry
			updateDepartmentEntry(
				long creatorId, long entryId,
				com.dogoo.department.service.mapper.model.DepartmentMapperModel
					model,
				com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentEntryLocalService.updateDepartmentEntry(
			creatorId, entryId, model, context);
	}

	@Override
	public DepartmentEntryLocalService getWrappedService() {
		return _departmentEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DepartmentEntryLocalService departmentEntryLocalService) {

		_departmentEntryLocalService = departmentEntryLocalService;
	}

	private DepartmentEntryLocalService _departmentEntryLocalService;

}