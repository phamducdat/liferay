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
 * Provides a wrapper for {@link EmailEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmailEntryLocalService
 * @generated
 */
public class EmailEntryLocalServiceWrapper
	implements EmailEntryLocalService, ServiceWrapper<EmailEntryLocalService> {

	public EmailEntryLocalServiceWrapper(
		EmailEntryLocalService emailEntryLocalService) {

		_emailEntryLocalService = emailEntryLocalService;
	}

	/**
	 * Adds the email entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailEntry the email entry
	 * @return the email entry that was added
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry addEmailEntry(
		com.dogoo.contact.service.model.EmailEntry emailEntry) {

		return _emailEntryLocalService.addEmailEntry(emailEntry);
	}

	@Override
	public com.dogoo.contact.service.model.EmailEntry addEmailEntry(
		long customerId, long creatorId, long contactId, String emailAddress,
		String description, boolean isDefaulted,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return _emailEntryLocalService.addEmailEntry(
			customerId, creatorId, contactId, emailAddress, description,
			isDefaulted, context);
	}

	/**
	 * Creates a new email entry with the primary key. Does not add the email entry to the database.
	 *
	 * @param emailId the primary key for the new email entry
	 * @return the new email entry
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry createEmailEntry(
		long emailId) {

		return _emailEntryLocalService.createEmailEntry(emailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the email entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailEntry the email entry
	 * @return the email entry that was removed
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry deleteEmailEntry(
		com.dogoo.contact.service.model.EmailEntry emailEntry) {

		return _emailEntryLocalService.deleteEmailEntry(emailEntry);
	}

	/**
	 * Deletes the email entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry that was removed
	 * @throws PortalException if a email entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry deleteEmailEntry(
			long emailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.deleteEmailEntry(emailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _emailEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _emailEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailEntryLocalService.dynamicQuery();
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

		return _emailEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.EmailEntryModelImpl</code>.
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

		return _emailEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.EmailEntryModelImpl</code>.
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

		return _emailEntryLocalService.dynamicQuery(
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

		return _emailEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _emailEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.contact.service.model.EmailEntry fetchEmailEntry(
		long emailId) {

		return _emailEntryLocalService.fetchEmailEntry(emailId);
	}

	@Override
	public com.dogoo.contact.service.model.EmailEntry
		fetchEmailEntryByEmailAddress(long customerId, String emailAddress) {

		return _emailEntryLocalService.fetchEmailEntryByEmailAddress(
			customerId, emailAddress);
	}

	/**
	 * Returns the email entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the email entry's external reference code
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry
		fetchEmailEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _emailEntryLocalService.fetchEmailEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	@Override
	public com.dogoo.contact.service.model.EmailEntry
		fetchEmailEntryByIsDefaulted(long customerId, boolean isDefaulted) {

		return _emailEntryLocalService.fetchEmailEntryByIsDefaulted(
			customerId, isDefaulted);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchEmailEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.contact.service.model.EmailEntry
		fetchEmailEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _emailEntryLocalService.fetchEmailEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the email entry matching the UUID and group.
	 *
	 * @param uuid the email entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry
		fetchEmailEntryByUuidAndGroupId(String uuid, long groupId) {

		return _emailEntryLocalService.fetchEmailEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _emailEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the email entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.EmailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @return the range of email entries
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.EmailEntry>
		getEmailEntries(int start, int end) {

		return _emailEntryLocalService.getEmailEntries(start, end);
	}

	@Override
	public java.util.List<com.dogoo.contact.service.model.EmailEntry>
		getEmailEntriesByContactId(long customerId, long contactId) {

		return _emailEntryLocalService.getEmailEntriesByContactId(
			customerId, contactId);
	}

	/**
	 * Returns all the email entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the email entries
	 * @param companyId the primary key of the company
	 * @return the matching email entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.EmailEntry>
		getEmailEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _emailEntryLocalService.getEmailEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of email entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the email entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of email entries
	 * @param end the upper bound of the range of email entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching email entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.EmailEntry>
		getEmailEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.contact.service.model.EmailEntry>
					orderByComparator) {

		return _emailEntryLocalService.getEmailEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of email entries.
	 *
	 * @return the number of email entries
	 */
	@Override
	public int getEmailEntriesCount() {
		return _emailEntryLocalService.getEmailEntriesCount();
	}

	/**
	 * Returns the email entry with the primary key.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry
	 * @throws PortalException if a email entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry getEmailEntry(
			long emailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.getEmailEntry(emailId);
	}

	/**
	 * Returns the email entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the email entry's external reference code
	 * @return the matching email entry
	 * @throws PortalException if a matching email entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry
			getEmailEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.getEmailEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the email entry matching the UUID and group.
	 *
	 * @param uuid the email entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching email entry
	 * @throws PortalException if a matching email entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry
			getEmailEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.getEmailEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _emailEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _emailEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emailEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the email entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailEntry the email entry
	 * @return the email entry that was updated
	 */
	@Override
	public com.dogoo.contact.service.model.EmailEntry updateEmailEntry(
		com.dogoo.contact.service.model.EmailEntry emailEntry) {

		return _emailEntryLocalService.updateEmailEntry(emailEntry);
	}

	@Override
	public com.dogoo.contact.service.model.EmailEntry updateEmailEntry(
			long creatorId, long entryId, long contactId, String emailAddress,
			String description, boolean isDefaulted,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailEntryLocalService.updateEmailEntry(
			creatorId, entryId, contactId, emailAddress, description,
			isDefaulted, context);
	}

	@Override
	public EmailEntryLocalService getWrappedService() {
		return _emailEntryLocalService;
	}

	@Override
	public void setWrappedService(
		EmailEntryLocalService emailEntryLocalService) {

		_emailEntryLocalService = emailEntryLocalService;
	}

	private EmailEntryLocalService _emailEntryLocalService;

}