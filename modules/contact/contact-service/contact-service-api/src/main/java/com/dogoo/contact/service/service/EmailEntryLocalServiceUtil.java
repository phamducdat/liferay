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

import com.dogoo.contact.service.model.EmailEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmailEntry. This utility wraps
 * <code>com.dogoo.contact.service.service.impl.EmailEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmailEntryLocalService
 * @generated
 */
public class EmailEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.contact.service.service.impl.EmailEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static EmailEntry addEmailEntry(EmailEntry emailEntry) {
		return getService().addEmailEntry(emailEntry);
	}

	public static EmailEntry addEmailEntry(
		long customerId, long creatorId, long contactId, String emailAddress,
		String description, boolean isDefaulted,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().addEmailEntry(
			customerId, creatorId, contactId, emailAddress, description,
			isDefaulted, context);
	}

	/**
	 * Creates a new email entry with the primary key. Does not add the email entry to the database.
	 *
	 * @param emailId the primary key for the new email entry
	 * @return the new email entry
	 */
	public static EmailEntry createEmailEntry(long emailId) {
		return getService().createEmailEntry(emailId);
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
	 * Deletes the email entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailEntry the email entry
	 * @return the email entry that was removed
	 */
	public static EmailEntry deleteEmailEntry(EmailEntry emailEntry) {
		return getService().deleteEmailEntry(emailEntry);
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
	public static EmailEntry deleteEmailEntry(long emailId)
		throws PortalException {

		return getService().deleteEmailEntry(emailId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.EmailEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.EmailEntryModelImpl</code>.
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

	public static EmailEntry fetchEmailEntry(long emailId) {
		return getService().fetchEmailEntry(emailId);
	}

	public static EmailEntry fetchEmailEntryByEmailAddress(
		long customerId, String emailAddress) {

		return getService().fetchEmailEntryByEmailAddress(
			customerId, emailAddress);
	}

	/**
	 * Returns the email entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the email entry's external reference code
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchEmailEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchEmailEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	public static EmailEntry fetchEmailEntryByIsDefaulted(
		long customerId, boolean isDefaulted) {

		return getService().fetchEmailEntryByIsDefaulted(
			customerId, isDefaulted);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchEmailEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static EmailEntry fetchEmailEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchEmailEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the email entry matching the UUID and group.
	 *
	 * @param uuid the email entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	public static EmailEntry fetchEmailEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmailEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<EmailEntry> getEmailEntries(int start, int end) {
		return getService().getEmailEntries(start, end);
	}

	public static List<EmailEntry> getEmailEntriesByContactId(
		long customerId, long contactId) {

		return getService().getEmailEntriesByContactId(customerId, contactId);
	}

	/**
	 * Returns all the email entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the email entries
	 * @param companyId the primary key of the company
	 * @return the matching email entries, or an empty list if no matches were found
	 */
	public static List<EmailEntry> getEmailEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmailEntriesByUuidAndCompanyId(uuid, companyId);
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
	public static List<EmailEntry> getEmailEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return getService().getEmailEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of email entries.
	 *
	 * @return the number of email entries
	 */
	public static int getEmailEntriesCount() {
		return getService().getEmailEntriesCount();
	}

	/**
	 * Returns the email entry with the primary key.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry
	 * @throws PortalException if a email entry with the primary key could not be found
	 */
	public static EmailEntry getEmailEntry(long emailId)
		throws PortalException {

		return getService().getEmailEntry(emailId);
	}

	/**
	 * Returns the email entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the email entry's external reference code
	 * @return the matching email entry
	 * @throws PortalException if a matching email entry could not be found
	 */
	public static EmailEntry getEmailEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getEmailEntryByExternalReferenceCode(
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
	public static EmailEntry getEmailEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmailEntryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the email entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailEntry the email entry
	 * @return the email entry that was updated
	 */
	public static EmailEntry updateEmailEntry(EmailEntry emailEntry) {
		return getService().updateEmailEntry(emailEntry);
	}

	public static EmailEntry updateEmailEntry(
			long creatorId, long entryId, long contactId, String emailAddress,
			String description, boolean isDefaulted,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().updateEmailEntry(
			creatorId, entryId, contactId, emailAddress, description,
			isDefaulted, context);
	}

	public static EmailEntryLocalService getService() {
		return _service;
	}

	private static volatile EmailEntryLocalService _service;

}