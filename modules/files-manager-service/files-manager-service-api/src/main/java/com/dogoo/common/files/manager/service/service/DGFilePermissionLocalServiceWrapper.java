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
 * Provides a wrapper for {@link DGFilePermissionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionLocalService
 * @generated
 */
public class DGFilePermissionLocalServiceWrapper
	implements DGFilePermissionLocalService,
			   ServiceWrapper<DGFilePermissionLocalService> {

	public DGFilePermissionLocalServiceWrapper(
		DGFilePermissionLocalService dgFilePermissionLocalService) {

		_dgFilePermissionLocalService = dgFilePermissionLocalService;
	}

	/**
	 * Adds the dg file permission to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermission the dg file permission
	 * @return the dg file permission that was added
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		addDGFilePermission(
			com.dogoo.common.files.manager.service.model.DGFilePermission
				dgFilePermission) {

		return _dgFilePermissionLocalService.addDGFilePermission(
			dgFilePermission);
	}

	/**
	 * Creates a new dg file permission with the primary key. Does not add the dg file permission to the database.
	 *
	 * @param filePermissionId the primary key for the new dg file permission
	 * @return the new dg file permission
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		createDGFilePermission(long filePermissionId) {

		return _dgFilePermissionLocalService.createDGFilePermission(
			filePermissionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dg file permission from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermission the dg file permission
	 * @return the dg file permission that was removed
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		deleteDGFilePermission(
			com.dogoo.common.files.manager.service.model.DGFilePermission
				dgFilePermission) {

		return _dgFilePermissionLocalService.deleteDGFilePermission(
			dgFilePermission);
	}

	/**
	 * Deletes the dg file permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission that was removed
	 * @throws PortalException if a dg file permission with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
			deleteDGFilePermission(long filePermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionLocalService.deleteDGFilePermission(
			filePermissionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgFilePermissionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgFilePermissionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgFilePermissionLocalService.dynamicQuery();
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

		return _dgFilePermissionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionModelImpl</code>.
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

		return _dgFilePermissionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionModelImpl</code>.
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

		return _dgFilePermissionLocalService.dynamicQuery(
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

		return _dgFilePermissionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgFilePermissionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		fetchDGFilePermission(long filePermissionId) {

		return _dgFilePermissionLocalService.fetchDGFilePermission(
			filePermissionId);
	}

	/**
	 * Returns the dg file permission with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission's external reference code
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		fetchDGFilePermissionByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFilePermissionLocalService.
			fetchDGFilePermissionByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFilePermissionByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		fetchDGFilePermissionByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dgFilePermissionLocalService.
			fetchDGFilePermissionByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file permission matching the UUID and group.
	 *
	 * @param uuid the dg file permission's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		fetchDGFilePermissionByUuidAndGroupId(String uuid, long groupId) {

		return _dgFilePermissionLocalService.
			fetchDGFilePermissionByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgFilePermissionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dg file permission with the primary key.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission
	 * @throws PortalException if a dg file permission with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
			getDGFilePermission(long filePermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionLocalService.getDGFilePermission(
			filePermissionId);
	}

	/**
	 * Returns the dg file permission with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission's external reference code
	 * @return the matching dg file permission
	 * @throws PortalException if a matching dg file permission could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
			getDGFilePermissionByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionLocalService.
			getDGFilePermissionByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file permission matching the UUID and group.
	 *
	 * @param uuid the dg file permission's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file permission
	 * @throws PortalException if a matching dg file permission could not be found
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
			getDGFilePermissionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionLocalService.
			getDGFilePermissionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the dg file permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @return the range of dg file permissions
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFilePermission>
			getDGFilePermissions(int start, int end) {

		return _dgFilePermissionLocalService.getDGFilePermissions(start, end);
	}

	/**
	 * Returns all the dg file permissions matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file permissions
	 * @param companyId the primary key of the company
	 * @return the matching dg file permissions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFilePermission>
			getDGFilePermissionsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _dgFilePermissionLocalService.
			getDGFilePermissionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dg file permissions matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file permissions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file permissions
	 * @param end the upper bound of the range of dg file permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file permissions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.dogoo.common.files.manager.service.model.DGFilePermission>
			getDGFilePermissionsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.dogoo.common.files.manager.service.model.
						DGFilePermission> orderByComparator) {

		return _dgFilePermissionLocalService.
			getDGFilePermissionsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file permissions.
	 *
	 * @return the number of dg file permissions
	 */
	@Override
	public int getDGFilePermissionsCount() {
		return _dgFilePermissionLocalService.getDGFilePermissionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dgFilePermissionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgFilePermissionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgFilePermissionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgFilePermissionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dg file permission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermission the dg file permission
	 * @return the dg file permission that was updated
	 */
	@Override
	public com.dogoo.common.files.manager.service.model.DGFilePermission
		updateDGFilePermission(
			com.dogoo.common.files.manager.service.model.DGFilePermission
				dgFilePermission) {

		return _dgFilePermissionLocalService.updateDGFilePermission(
			dgFilePermission);
	}

	@Override
	public DGFilePermissionLocalService getWrappedService() {
		return _dgFilePermissionLocalService;
	}

	@Override
	public void setWrappedService(
		DGFilePermissionLocalService dgFilePermissionLocalService) {

		_dgFilePermissionLocalService = dgFilePermissionLocalService;
	}

	private DGFilePermissionLocalService _dgFilePermissionLocalService;

}