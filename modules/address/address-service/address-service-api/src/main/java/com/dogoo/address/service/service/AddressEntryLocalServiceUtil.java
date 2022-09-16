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

package com.dogoo.address.service.service;

import com.dogoo.address.service.model.AddressEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AddressEntry. This utility wraps
 * <code>com.dogoo.address.service.service.impl.AddressEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AddressEntryLocalService
 * @generated
 */
public class AddressEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.address.service.service.impl.AddressEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static AddressEntry addAddress(
		String detail, String postalCode, String ward, String district,
		String province, String country, String wardCode, String districtCode,
		String provinceCode, String countryCode, String title, long customerId,
		long creatorId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addAddress(
			detail, postalCode, ward, district, province, country, wardCode,
			districtCode, provinceCode, countryCode, title, customerId,
			creatorId, serviceContext);
	}

	/**
	 * Adds the address entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressEntry the address entry
	 * @return the address entry that was added
	 */
	public static AddressEntry addAddressEntry(AddressEntry addressEntry) {
		return getService().addAddressEntry(addressEntry);
	}

	/**
	 * Creates a new address entry with the primary key. Does not add the address entry to the database.
	 *
	 * @param addressId the primary key for the new address entry
	 * @return the new address entry
	 */
	public static AddressEntry createAddressEntry(long addressId) {
		return getService().createAddressEntry(addressId);
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
	 * Deletes the address entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressEntry the address entry
	 * @return the address entry that was removed
	 */
	public static AddressEntry deleteAddressEntry(AddressEntry addressEntry) {
		return getService().deleteAddressEntry(addressEntry);
	}

	/**
	 * Deletes the address entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry that was removed
	 * @throws PortalException if a address entry with the primary key could not be found
	 */
	public static AddressEntry deleteAddressEntry(long addressId)
		throws PortalException {

		return getService().deleteAddressEntry(addressId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.address.service.model.impl.AddressEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.address.service.model.impl.AddressEntryModelImpl</code>.
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

	public static AddressEntry fetchAddressEntry(long addressId) {
		return getService().fetchAddressEntry(addressId);
	}

	/**
	 * Returns the address entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the address entry's external reference code
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchAddressEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchAddressEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAddressEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static AddressEntry fetchAddressEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchAddressEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the address entry matching the UUID and group.
	 *
	 * @param uuid the address entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	public static AddressEntry fetchAddressEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAddressEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the address entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.address.service.model.impl.AddressEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @return the range of address entries
	 */
	public static List<AddressEntry> getAddressEntries(int start, int end) {
		return getService().getAddressEntries(start, end);
	}

	/**
	 * Returns all the address entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the address entries
	 * @param companyId the primary key of the company
	 * @return the matching address entries, or an empty list if no matches were found
	 */
	public static List<AddressEntry> getAddressEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAddressEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of address entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the address entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of address entries
	 * @param end the upper bound of the range of address entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching address entries, or an empty list if no matches were found
	 */
	public static List<AddressEntry> getAddressEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AddressEntry> orderByComparator) {

		return getService().getAddressEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of address entries.
	 *
	 * @return the number of address entries
	 */
	public static int getAddressEntriesCount() {
		return getService().getAddressEntriesCount();
	}

	/**
	 * Returns the address entry with the primary key.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry
	 * @throws PortalException if a address entry with the primary key could not be found
	 */
	public static AddressEntry getAddressEntry(long addressId)
		throws PortalException {

		return getService().getAddressEntry(addressId);
	}

	/**
	 * Returns the address entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the address entry's external reference code
	 * @return the matching address entry
	 * @throws PortalException if a matching address entry could not be found
	 */
	public static AddressEntry getAddressEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getAddressEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the address entry matching the UUID and group.
	 *
	 * @param uuid the address entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching address entry
	 * @throws PortalException if a matching address entry could not be found
	 */
	public static AddressEntry getAddressEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAddressEntryByUuidAndGroupId(uuid, groupId);
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

	public static AddressEntry updateAddress(
			long addAddressId, String detail, String postalCode, String ward,
			String district, String province, String country, String wardCode,
			String districtCode, String provinceCode, String countryCode,
			String title, long creatorId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateAddress(
			addAddressId, detail, postalCode, ward, district, province, country,
			wardCode, districtCode, provinceCode, countryCode, title, creatorId,
			serviceContext);
	}

	/**
	 * Updates the address entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressEntry the address entry
	 * @return the address entry that was updated
	 */
	public static AddressEntry updateAddressEntry(AddressEntry addressEntry) {
		return getService().updateAddressEntry(addressEntry);
	}

	public static AddressEntryLocalService getService() {
		return _service;
	}

	private static volatile AddressEntryLocalService _service;

}