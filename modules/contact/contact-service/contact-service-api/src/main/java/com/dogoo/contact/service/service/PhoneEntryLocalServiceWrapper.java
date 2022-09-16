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

package com.dogoo.contact.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhoneEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhoneEntryLocalService
 * @generated
 */
public class PhoneEntryLocalServiceWrapper
	implements PhoneEntryLocalService, ServiceWrapper<PhoneEntryLocalService> {

	public PhoneEntryLocalServiceWrapper(
		PhoneEntryLocalService phoneEntryLocalService) {

		_phoneEntryLocalService = phoneEntryLocalService;
	}

	@Override
	public com.dogoo.contact.service.model.PhoneEntry addPhoneEntry(
		long customerId, long creatorId, long contactId, String number,
		String description, boolean isDefaulted,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return _phoneEntryLocalService.addPhoneEntry(
			customerId, creatorId, contactId, number, description, isDefaulted,
			context);
	}

	/**
	 * Adds the phone entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhoneEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phoneEntry the phone entry
	 * @return the phone entry that was added
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry addPhoneEntry(
		com.dogoo.contact.service.model.PhoneEntry phoneEntry) {

		return _phoneEntryLocalService.addPhoneEntry(phoneEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new phone entry with the primary key. Does not add the phone entry to the database.
	 *
	 * @param phoneId the primary key for the new phone entry
	 * @return the new phone entry
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry createPhoneEntry(
		long phoneId) {

		return _phoneEntryLocalService.createPhoneEntry(phoneId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phone entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhoneEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry that was removed
	 * @throws PortalException if a phone entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry deletePhoneEntry(
			long phoneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.deletePhoneEntry(phoneId);
	}

	/**
	 * Deletes the phone entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhoneEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phoneEntry the phone entry
	 * @return the phone entry that was removed
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry deletePhoneEntry(
		com.dogoo.contact.service.model.PhoneEntry phoneEntry) {

		return _phoneEntryLocalService.deletePhoneEntry(phoneEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _phoneEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _phoneEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phoneEntryLocalService.dynamicQuery();
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

		return _phoneEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.PhoneEntryModelImpl</code>.
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

		return _phoneEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.PhoneEntryModelImpl</code>.
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

		return _phoneEntryLocalService.dynamicQuery(
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

		return _phoneEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phoneEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.contact.service.model.PhoneEntry fetchPhoneEntry(
		long phoneId) {

		return _phoneEntryLocalService.fetchPhoneEntry(phoneId);
	}

	/**
	 * Returns the phone entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phone entry's external reference code
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry
		fetchPhoneEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _phoneEntryLocalService.fetchPhoneEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	@Override
	public com.dogoo.contact.service.model.PhoneEntry
		fetchPhoneEntryByIsDefaulted(long customerId, boolean isDefaulted) {

		return _phoneEntryLocalService.fetchPhoneEntryByIsDefaulted(
			customerId, isDefaulted);
	}

	@Override
	public com.dogoo.contact.service.model.PhoneEntry fetchPhoneEntryByNumber(
		long customerId, String number) {

		return _phoneEntryLocalService.fetchPhoneEntryByNumber(
			customerId, number);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPhoneEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.contact.service.model.PhoneEntry
		fetchPhoneEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _phoneEntryLocalService.fetchPhoneEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the phone entry matching the UUID and group.
	 *
	 * @param uuid the phone entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry
		fetchPhoneEntryByUuidAndGroupId(String uuid, long groupId) {

		return _phoneEntryLocalService.fetchPhoneEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phoneEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _phoneEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phoneEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phoneEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the phone entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.PhoneEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @return the range of phone entries
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.PhoneEntry>
		getPhoneEntries(int start, int end) {

		return _phoneEntryLocalService.getPhoneEntries(start, end);
	}

	@Override
	public java.util.List<com.dogoo.contact.service.model.PhoneEntry>
		getPhoneEntriesByContactId(long customerId, long contactId) {

		return _phoneEntryLocalService.getPhoneEntriesByContactId(
			customerId, contactId);
	}

	/**
	 * Returns all the phone entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the phone entries
	 * @param companyId the primary key of the company
	 * @return the matching phone entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.PhoneEntry>
		getPhoneEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _phoneEntryLocalService.getPhoneEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of phone entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the phone entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of phone entries
	 * @param end the upper bound of the range of phone entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching phone entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.PhoneEntry>
		getPhoneEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.contact.service.model.PhoneEntry>
					orderByComparator) {

		return _phoneEntryLocalService.getPhoneEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of phone entries.
	 *
	 * @return the number of phone entries
	 */
	@Override
	public int getPhoneEntriesCount() {
		return _phoneEntryLocalService.getPhoneEntriesCount();
	}

	/**
	 * Returns the phone entry with the primary key.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry
	 * @throws PortalException if a phone entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry getPhoneEntry(
			long phoneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.getPhoneEntry(phoneId);
	}

	/**
	 * Returns the phone entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phone entry's external reference code
	 * @return the matching phone entry
	 * @throws PortalException if a matching phone entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry
			getPhoneEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.getPhoneEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the phone entry matching the UUID and group.
	 *
	 * @param uuid the phone entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching phone entry
	 * @throws PortalException if a matching phone entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry
			getPhoneEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.getPhoneEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.dogoo.contact.service.model.PhoneEntry updatePhoneEntry(
			long creatorId, long entryId, long contactId, String number,
			String description, boolean isDefaulted,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phoneEntryLocalService.updatePhoneEntry(
			creatorId, entryId, contactId, number, description, isDefaulted,
			context);
	}

	/**
	 * Updates the phone entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhoneEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phoneEntry the phone entry
	 * @return the phone entry that was updated
	 */
	@Override
	public com.dogoo.contact.service.model.PhoneEntry updatePhoneEntry(
		com.dogoo.contact.service.model.PhoneEntry phoneEntry) {

		return _phoneEntryLocalService.updatePhoneEntry(phoneEntry);
	}

	@Override
	public PhoneEntryLocalService getWrappedService() {
		return _phoneEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PhoneEntryLocalService phoneEntryLocalService) {

		_phoneEntryLocalService = phoneEntryLocalService;
	}

	private PhoneEntryLocalService _phoneEntryLocalService;

}