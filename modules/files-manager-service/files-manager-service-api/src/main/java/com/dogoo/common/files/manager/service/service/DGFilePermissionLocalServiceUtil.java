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

import com.dogoo.common.files.manager.service.model.DGFilePermission;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DGFilePermission. This utility wraps
 * <code>com.dogoo.common.files.manager.service.service.impl.DGFilePermissionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionLocalService
 * @generated
 */
public class DGFilePermissionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGFilePermissionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DGFilePermission addDGFilePermission(
		DGFilePermission dgFilePermission) {

		return getService().addDGFilePermission(dgFilePermission);
	}

	/**
	 * Creates a new dg file permission with the primary key. Does not add the dg file permission to the database.
	 *
	 * @param filePermissionId the primary key for the new dg file permission
	 * @return the new dg file permission
	 */
	public static DGFilePermission createDGFilePermission(
		long filePermissionId) {

		return getService().createDGFilePermission(filePermissionId);
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
	 * Deletes the dg file permission from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermission the dg file permission
	 * @return the dg file permission that was removed
	 */
	public static DGFilePermission deleteDGFilePermission(
		DGFilePermission dgFilePermission) {

		return getService().deleteDGFilePermission(dgFilePermission);
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
	public static DGFilePermission deleteDGFilePermission(long filePermissionId)
		throws PortalException {

		return getService().deleteDGFilePermission(filePermissionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionModelImpl</code>.
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

	public static DGFilePermission fetchDGFilePermission(
		long filePermissionId) {

		return getService().fetchDGFilePermission(filePermissionId);
	}

	/**
	 * Returns the dg file permission with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission's external reference code
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public static DGFilePermission fetchDGFilePermissionByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDGFilePermissionByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFilePermissionByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DGFilePermission fetchDGFilePermissionByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDGFilePermissionByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file permission matching the UUID and group.
	 *
	 * @param uuid the dg file permission's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file permission, or <code>null</code> if a matching dg file permission could not be found
	 */
	public static DGFilePermission fetchDGFilePermissionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDGFilePermissionByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dg file permission with the primary key.
	 *
	 * @param filePermissionId the primary key of the dg file permission
	 * @return the dg file permission
	 * @throws PortalException if a dg file permission with the primary key could not be found
	 */
	public static DGFilePermission getDGFilePermission(long filePermissionId)
		throws PortalException {

		return getService().getDGFilePermission(filePermissionId);
	}

	/**
	 * Returns the dg file permission with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission's external reference code
	 * @return the matching dg file permission
	 * @throws PortalException if a matching dg file permission could not be found
	 */
	public static DGFilePermission getDGFilePermissionByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDGFilePermissionByExternalReferenceCode(
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
	public static DGFilePermission getDGFilePermissionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDGFilePermissionByUuidAndGroupId(uuid, groupId);
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
	public static List<DGFilePermission> getDGFilePermissions(
		int start, int end) {

		return getService().getDGFilePermissions(start, end);
	}

	/**
	 * Returns all the dg file permissions matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file permissions
	 * @param companyId the primary key of the company
	 * @return the matching dg file permissions, or an empty list if no matches were found
	 */
	public static List<DGFilePermission> getDGFilePermissionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDGFilePermissionsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<DGFilePermission> getDGFilePermissionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DGFilePermission> orderByComparator) {

		return getService().getDGFilePermissionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dg file permissions.
	 *
	 * @return the number of dg file permissions
	 */
	public static int getDGFilePermissionsCount() {
		return getService().getDGFilePermissionsCount();
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
	public static DGFilePermission updateDGFilePermission(
		DGFilePermission dgFilePermission) {

		return getService().updateDGFilePermission(dgFilePermission);
	}

	public static DGFilePermissionLocalService getService() {
		return _service;
	}

	private static volatile DGFilePermissionLocalService _service;

}