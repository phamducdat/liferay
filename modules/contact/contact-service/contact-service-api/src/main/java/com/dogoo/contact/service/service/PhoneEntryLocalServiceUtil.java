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

import com.dogoo.contact.service.model.PhoneEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PhoneEntry. This utility wraps
 * <code>com.dogoo.contact.service.service.impl.PhoneEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhoneEntryLocalService
 * @generated
 */
public class PhoneEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.contact.service.service.impl.PhoneEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PhoneEntry addPhoneEntry(
		long customerId, long creatorId, long contactId, String number,
		String description, boolean isDefaulted,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().addPhoneEntry(
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
	public static PhoneEntry addPhoneEntry(PhoneEntry phoneEntry) {
		return getService().addPhoneEntry(phoneEntry);
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
	 * Creates a new phone entry with the primary key. Does not add the phone entry to the database.
	 *
	 * @param phoneId the primary key for the new phone entry
	 * @return the new phone entry
	 */
	public static PhoneEntry createPhoneEntry(long phoneId) {
		return getService().createPhoneEntry(phoneId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static PhoneEntry deletePhoneEntry(long phoneId)
		throws PortalException {

		return getService().deletePhoneEntry(phoneId);
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
	public static PhoneEntry deletePhoneEntry(PhoneEntry phoneEntry) {
		return getService().deletePhoneEntry(phoneEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.PhoneEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.contact.service.model.impl.PhoneEntryModelImpl</code>.
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

	public static PhoneEntry fetchPhoneEntry(long phoneId) {
		return getService().fetchPhoneEntry(phoneId);
	}

	/**
	 * Returns the phone entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phone entry's external reference code
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchPhoneEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchPhoneEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	public static PhoneEntry fetchPhoneEntryByIsDefaulted(
		long customerId, boolean isDefaulted) {

		return getService().fetchPhoneEntryByIsDefaulted(
			customerId, isDefaulted);
	}

	public static PhoneEntry fetchPhoneEntryByNumber(
		long customerId, String number) {

		return getService().fetchPhoneEntryByNumber(customerId, number);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPhoneEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static PhoneEntry fetchPhoneEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchPhoneEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the phone entry matching the UUID and group.
	 *
	 * @param uuid the phone entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching phone entry, or <code>null</code> if a matching phone entry could not be found
	 */
	public static PhoneEntry fetchPhoneEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPhoneEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<PhoneEntry> getPhoneEntries(int start, int end) {
		return getService().getPhoneEntries(start, end);
	}

	public static List<PhoneEntry> getPhoneEntriesByContactId(
		long customerId, long contactId) {

		return getService().getPhoneEntriesByContactId(customerId, contactId);
	}

	/**
	 * Returns all the phone entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the phone entries
	 * @param companyId the primary key of the company
	 * @return the matching phone entries, or an empty list if no matches were found
	 */
	public static List<PhoneEntry> getPhoneEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPhoneEntriesByUuidAndCompanyId(uuid, companyId);
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
	public static List<PhoneEntry> getPhoneEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhoneEntry> orderByComparator) {

		return getService().getPhoneEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of phone entries.
	 *
	 * @return the number of phone entries
	 */
	public static int getPhoneEntriesCount() {
		return getService().getPhoneEntriesCount();
	}

	/**
	 * Returns the phone entry with the primary key.
	 *
	 * @param phoneId the primary key of the phone entry
	 * @return the phone entry
	 * @throws PortalException if a phone entry with the primary key could not be found
	 */
	public static PhoneEntry getPhoneEntry(long phoneId)
		throws PortalException {

		return getService().getPhoneEntry(phoneId);
	}

	/**
	 * Returns the phone entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phone entry's external reference code
	 * @return the matching phone entry
	 * @throws PortalException if a matching phone entry could not be found
	 */
	public static PhoneEntry getPhoneEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getPhoneEntryByExternalReferenceCode(
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
	public static PhoneEntry getPhoneEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPhoneEntryByUuidAndGroupId(uuid, groupId);
	}

	public static PhoneEntry updatePhoneEntry(
			long creatorId, long entryId, long contactId, String number,
			String description, boolean isDefaulted,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().updatePhoneEntry(
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
	public static PhoneEntry updatePhoneEntry(PhoneEntry phoneEntry) {
		return getService().updatePhoneEntry(phoneEntry);
	}

	public static PhoneEntryLocalService getService() {
		return _service;
	}

	private static volatile PhoneEntryLocalService _service;

}