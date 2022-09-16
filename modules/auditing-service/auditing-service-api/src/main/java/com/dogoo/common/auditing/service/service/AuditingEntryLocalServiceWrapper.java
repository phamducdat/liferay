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

package com.dogoo.common.auditing.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditingEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditingEntryLocalService
 * @generated
 */
public class AuditingEntryLocalServiceWrapper
	implements AuditingEntryLocalService,
			   ServiceWrapper<AuditingEntryLocalService> {

	public AuditingEntryLocalServiceWrapper(
		AuditingEntryLocalService auditingEntryLocalService) {

		_auditingEntryLocalService = auditingEntryLocalService;
	}

	/**
	 * Adds the auditing entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditingEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditingEntry the auditing entry
	 * @return the auditing entry that was added
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		addAuditingEntry(
			com.dogoo.common.auditing.service.model.AuditingEntry
				auditingEntry) {

		return _auditingEntryLocalService.addAuditingEntry(auditingEntry);
	}

	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		addAuditingEntry(
			long customerId, long creatorId, long classPkId, String classPkName,
			com.dogoo.common.auditing.service.mapper.model.AuditingMapperModel
				model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _auditingEntryLocalService.addAuditingEntry(
			customerId, creatorId, classPkId, classPkName, model,
			serviceContext);
	}

	/**
	 * Creates a new auditing entry with the primary key. Does not add the auditing entry to the database.
	 *
	 * @param auditingId the primary key for the new auditing entry
	 * @return the new auditing entry
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		createAuditingEntry(long auditingId) {

		return _auditingEntryLocalService.createAuditingEntry(auditingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditingEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the auditing entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditingEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditingEntry the auditing entry
	 * @return the auditing entry that was removed
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		deleteAuditingEntry(
			com.dogoo.common.auditing.service.model.AuditingEntry
				auditingEntry) {

		return _auditingEntryLocalService.deleteAuditingEntry(auditingEntry);
	}

	/**
	 * Deletes the auditing entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditingEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry that was removed
	 * @throws PortalException if a auditing entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
			deleteAuditingEntry(long auditingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditingEntryLocalService.deleteAuditingEntry(auditingId);
	}

	@Override
	public void deleteByPkAndName(long classPkId, String classPkName) {
		_auditingEntryLocalService.deleteByPkAndName(classPkId, classPkName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditingEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _auditingEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _auditingEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _auditingEntryLocalService.dynamicQuery();
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

		return _auditingEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.auditing.service.model.impl.AuditingEntryModelImpl</code>.
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

		return _auditingEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.auditing.service.model.impl.AuditingEntryModelImpl</code>.
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

		return _auditingEntryLocalService.dynamicQuery(
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

		return _auditingEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _auditingEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		fetchAuditingEntry(long auditingId) {

		return _auditingEntryLocalService.fetchAuditingEntry(auditingId);
	}

	/**
	 * Returns the auditing entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the auditing entry's external reference code
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		fetchAuditingEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _auditingEntryLocalService.
			fetchAuditingEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAuditingEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		fetchAuditingEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _auditingEntryLocalService.fetchAuditingEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the auditing entry matching the UUID and group.
	 *
	 * @param uuid the auditing entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auditing entry, or <code>null</code> if a matching auditing entry could not be found
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		fetchAuditingEntryByUuidAndGroupId(String uuid, long groupId) {

		return _auditingEntryLocalService.fetchAuditingEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.dogoo.common.auditing.service.model.AuditingEntry>
		findByParentPKAndName(long parentPkId, String parentPkName) {

		return _auditingEntryLocalService.findByParentPKAndName(
			parentPkId, parentPkName);
	}

	@Override
	public java.util.List<com.dogoo.common.auditing.service.model.AuditingEntry>
		findByPKAndName(long classPkId, String classPkName) {

		return _auditingEntryLocalService.findByPKAndName(
			classPkId, classPkName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _auditingEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the auditing entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.auditing.service.model.impl.AuditingEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @return the range of auditing entries
	 */
	@Override
	public java.util.List<com.dogoo.common.auditing.service.model.AuditingEntry>
		getAuditingEntries(int start, int end) {

		return _auditingEntryLocalService.getAuditingEntries(start, end);
	}

	/**
	 * Returns all the auditing entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the auditing entries
	 * @param companyId the primary key of the company
	 * @return the matching auditing entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.common.auditing.service.model.AuditingEntry>
		getAuditingEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _auditingEntryLocalService.getAuditingEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of auditing entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the auditing entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of auditing entries
	 * @param end the upper bound of the range of auditing entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching auditing entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.common.auditing.service.model.AuditingEntry>
		getAuditingEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.common.auditing.service.model.AuditingEntry>
					orderByComparator) {

		return _auditingEntryLocalService.getAuditingEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of auditing entries.
	 *
	 * @return the number of auditing entries
	 */
	@Override
	public int getAuditingEntriesCount() {
		return _auditingEntryLocalService.getAuditingEntriesCount();
	}

	/**
	 * Returns the auditing entry with the primary key.
	 *
	 * @param auditingId the primary key of the auditing entry
	 * @return the auditing entry
	 * @throws PortalException if a auditing entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
			getAuditingEntry(long auditingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditingEntryLocalService.getAuditingEntry(auditingId);
	}

	/**
	 * Returns the auditing entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the auditing entry's external reference code
	 * @return the matching auditing entry
	 * @throws PortalException if a matching auditing entry could not be found
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
			getAuditingEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditingEntryLocalService.
			getAuditingEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the auditing entry matching the UUID and group.
	 *
	 * @param uuid the auditing entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auditing entry
	 * @throws PortalException if a matching auditing entry could not be found
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
			getAuditingEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditingEntryLocalService.getAuditingEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _auditingEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditingEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditingEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the auditing entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditingEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditingEntry the auditing entry
	 * @return the auditing entry that was updated
	 */
	@Override
	public com.dogoo.common.auditing.service.model.AuditingEntry
		updateAuditingEntry(
			com.dogoo.common.auditing.service.model.AuditingEntry
				auditingEntry) {

		return _auditingEntryLocalService.updateAuditingEntry(auditingEntry);
	}

	@Override
	public AuditingEntryLocalService getWrappedService() {
		return _auditingEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AuditingEntryLocalService auditingEntryLocalService) {

		_auditingEntryLocalService = auditingEntryLocalService;
	}

	private AuditingEntryLocalService _auditingEntryLocalService;

}