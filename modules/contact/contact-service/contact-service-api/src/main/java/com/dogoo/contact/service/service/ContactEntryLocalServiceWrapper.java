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
 * Provides a wrapper for {@link ContactEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactEntryLocalService
 * @generated
 */
public class ContactEntryLocalServiceWrapper
	implements ContactEntryLocalService,
			   ServiceWrapper<ContactEntryLocalService> {

	public ContactEntryLocalServiceWrapper(
		ContactEntryLocalService contactEntryLocalService) {

		_contactEntryLocalService = contactEntryLocalService;
	}

	/**
	 * Adds the contact entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was added
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry addContactEntry(
		com.dogoo.contact.service.model.ContactEntry contactEntry) {

		return _contactEntryLocalService.addContactEntry(contactEntry);
	}

	@Override
	public com.dogoo.contact.service.model.ContactEntry addContactEntry(
		long customerId, long creatorId, String facebook, String twitter,
		String linkedin,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return _contactEntryLocalService.addContactEntry(
			customerId, creatorId, facebook, twitter, linkedin, context);
	}

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param contactId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry createContactEntry(
		long contactId) {

		return _contactEntryLocalService.createContactEntry(contactId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the contact entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was removed
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry deleteContactEntry(
		com.dogoo.contact.service.model.ContactEntry contactEntry) {

		return _contactEntryLocalService.deleteContactEntry(contactEntry);
	}

	/**
	 * Deletes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws PortalException if a contact entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry deleteContactEntry(
			long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.deleteContactEntry(contactId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _contactEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _contactEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactEntryLocalService.dynamicQuery();
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

		return _contactEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.ContactEntryModelImpl</code>.
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

		return _contactEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.ContactEntryModelImpl</code>.
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

		return _contactEntryLocalService.dynamicQuery(
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

		return _contactEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _contactEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.contact.service.model.ContactEntry fetchContactEntry(
		long contactId) {

		return _contactEntryLocalService.fetchContactEntry(contactId);
	}

	/**
	 * Returns the contact entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the contact entry's external reference code
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry
		fetchContactEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _contactEntryLocalService.
			fetchContactEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchContactEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.contact.service.model.ContactEntry
		fetchContactEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _contactEntryLocalService.fetchContactEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the contact entry matching the UUID and group.
	 *
	 * @param uuid the contact entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry
		fetchContactEntryByUuidAndGroupId(String uuid, long groupId) {

		return _contactEntryLocalService.fetchContactEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _contactEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of contact entries
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.ContactEntry>
		getContactEntries(int start, int end) {

		return _contactEntryLocalService.getContactEntries(start, end);
	}

	/**
	 * Returns all the contact entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact entries
	 * @param companyId the primary key of the company
	 * @return the matching contact entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.ContactEntry>
		getContactEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _contactEntryLocalService.getContactEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of contact entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching contact entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.contact.service.model.ContactEntry>
		getContactEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.contact.service.model.ContactEntry>
					orderByComparator) {

		return _contactEntryLocalService.getContactEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 */
	@Override
	public int getContactEntriesCount() {
		return _contactEntryLocalService.getContactEntriesCount();
	}

	/**
	 * Returns the contact entry with the primary key.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry
	 * @throws PortalException if a contact entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry getContactEntry(
			long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.getContactEntry(contactId);
	}

	/**
	 * Returns the contact entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the contact entry's external reference code
	 * @return the matching contact entry
	 * @throws PortalException if a matching contact entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry
			getContactEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.getContactEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the contact entry matching the UUID and group.
	 *
	 * @param uuid the contact entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact entry
	 * @throws PortalException if a matching contact entry could not be found
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry
			getContactEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.getContactEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _contactEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _contactEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was updated
	 */
	@Override
	public com.dogoo.contact.service.model.ContactEntry updateContactEntry(
		com.dogoo.contact.service.model.ContactEntry contactEntry) {

		return _contactEntryLocalService.updateContactEntry(contactEntry);
	}

	@Override
	public com.dogoo.contact.service.model.ContactEntry updateContactEntry(
			long creatorId, long entryId, String facebook, String twitter,
			String linkedin,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.updateContactEntry(
			creatorId, entryId, facebook, twitter, linkedin, context);
	}

	@Override
	public ContactEntryLocalService getWrappedService() {
		return _contactEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ContactEntryLocalService contactEntryLocalService) {

		_contactEntryLocalService = contactEntryLocalService;
	}

	private ContactEntryLocalService _contactEntryLocalService;

}