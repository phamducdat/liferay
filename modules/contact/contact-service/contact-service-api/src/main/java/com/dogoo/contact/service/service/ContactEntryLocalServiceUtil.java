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

import com.dogoo.contact.service.model.ContactEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ContactEntry. This utility wraps
 * <code>com.dogoo.contact.service.service.impl.ContactEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactEntryLocalService
 * @generated
 */
public class ContactEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.contact.service.service.impl.ContactEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ContactEntry addContactEntry(ContactEntry contactEntry) {
		return getService().addContactEntry(contactEntry);
	}

	public static ContactEntry addContactEntry(
		long customerId, long creatorId, String facebook, String twitter,
		String linkedin,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().addContactEntry(
			customerId, creatorId, facebook, twitter, linkedin, context);
	}

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param contactId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	public static ContactEntry createContactEntry(long contactId) {
		return getService().createContactEntry(contactId);
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
	 * Deletes the contact entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was removed
	 */
	public static ContactEntry deleteContactEntry(ContactEntry contactEntry) {
		return getService().deleteContactEntry(contactEntry);
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
	public static ContactEntry deleteContactEntry(long contactId)
		throws PortalException {

		return getService().deleteContactEntry(contactId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.ContactEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.ContactEntryModelImpl</code>.
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

	public static ContactEntry fetchContactEntry(long contactId) {
		return getService().fetchContactEntry(contactId);
	}

	/**
	 * Returns the contact entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the contact entry's external reference code
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public static ContactEntry fetchContactEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchContactEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchContactEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static ContactEntry fetchContactEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchContactEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the contact entry matching the UUID and group.
	 *
	 * @param uuid the contact entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public static ContactEntry fetchContactEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchContactEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<ContactEntry> getContactEntries(int start, int end) {
		return getService().getContactEntries(start, end);
	}

	/**
	 * Returns all the contact entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact entries
	 * @param companyId the primary key of the company
	 * @return the matching contact entries, or an empty list if no matches were found
	 */
	public static List<ContactEntry> getContactEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getContactEntriesByUuidAndCompanyId(
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
	public static List<ContactEntry> getContactEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactEntry> orderByComparator) {

		return getService().getContactEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 */
	public static int getContactEntriesCount() {
		return getService().getContactEntriesCount();
	}

	/**
	 * Returns the contact entry with the primary key.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry
	 * @throws PortalException if a contact entry with the primary key could not be found
	 */
	public static ContactEntry getContactEntry(long contactId)
		throws PortalException {

		return getService().getContactEntry(contactId);
	}

	/**
	 * Returns the contact entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the contact entry's external reference code
	 * @return the matching contact entry
	 * @throws PortalException if a matching contact entry could not be found
	 */
	public static ContactEntry getContactEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getContactEntryByExternalReferenceCode(
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
	public static ContactEntry getContactEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getContactEntryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was updated
	 */
	public static ContactEntry updateContactEntry(ContactEntry contactEntry) {
		return getService().updateContactEntry(contactEntry);
	}

	public static ContactEntry updateContactEntry(
			long creatorId, long entryId, String facebook, String twitter,
			String linkedin,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().updateContactEntry(
			creatorId, entryId, facebook, twitter, linkedin, context);
	}

	public static ContactEntryLocalService getService() {
		return _service;
	}

	private static volatile ContactEntryLocalService _service;

}