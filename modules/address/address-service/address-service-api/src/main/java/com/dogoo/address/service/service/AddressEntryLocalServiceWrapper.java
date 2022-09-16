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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AddressEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressEntryLocalService
 * @generated
 */
public class AddressEntryLocalServiceWrapper
	implements AddressEntryLocalService,
			   ServiceWrapper<AddressEntryLocalService> {

	public AddressEntryLocalServiceWrapper(
		AddressEntryLocalService addressEntryLocalService) {

		_addressEntryLocalService = addressEntryLocalService;
	}

	@Override
	public com.dogoo.address.service.model.AddressEntry addAddress(
		String detail, String postalCode, String ward, String district,
		String province, String country, String wardCode, String districtCode,
		String provinceCode, String countryCode, String title, long customerId,
		long creatorId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _addressEntryLocalService.addAddress(
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
	@Override
	public com.dogoo.address.service.model.AddressEntry addAddressEntry(
		com.dogoo.address.service.model.AddressEntry addressEntry) {

		return _addressEntryLocalService.addAddressEntry(addressEntry);
	}

	/**
	 * Creates a new address entry with the primary key. Does not add the address entry to the database.
	 *
	 * @param addressId the primary key for the new address entry
	 * @return the new address entry
	 */
	@Override
	public com.dogoo.address.service.model.AddressEntry createAddressEntry(
		long addressId) {

		return _addressEntryLocalService.createAddressEntry(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.dogoo.address.service.model.AddressEntry deleteAddressEntry(
		com.dogoo.address.service.model.AddressEntry addressEntry) {

		return _addressEntryLocalService.deleteAddressEntry(addressEntry);
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
	@Override
	public com.dogoo.address.service.model.AddressEntry deleteAddressEntry(
			long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.deleteAddressEntry(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _addressEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _addressEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressEntryLocalService.dynamicQuery();
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

		return _addressEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _addressEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _addressEntryLocalService.dynamicQuery(
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

		return _addressEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _addressEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.address.service.model.AddressEntry fetchAddressEntry(
		long addressId) {

		return _addressEntryLocalService.fetchAddressEntry(addressId);
	}

	/**
	 * Returns the address entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the address entry's external reference code
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	@Override
	public com.dogoo.address.service.model.AddressEntry
		fetchAddressEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _addressEntryLocalService.
			fetchAddressEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAddressEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.address.service.model.AddressEntry
		fetchAddressEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _addressEntryLocalService.fetchAddressEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the address entry matching the UUID and group.
	 *
	 * @param uuid the address entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching address entry, or <code>null</code> if a matching address entry could not be found
	 */
	@Override
	public com.dogoo.address.service.model.AddressEntry
		fetchAddressEntryByUuidAndGroupId(String uuid, long groupId) {

		return _addressEntryLocalService.fetchAddressEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _addressEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.dogoo.address.service.model.AddressEntry>
		getAddressEntries(int start, int end) {

		return _addressEntryLocalService.getAddressEntries(start, end);
	}

	/**
	 * Returns all the address entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the address entries
	 * @param companyId the primary key of the company
	 * @return the matching address entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.address.service.model.AddressEntry>
		getAddressEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _addressEntryLocalService.getAddressEntriesByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.dogoo.address.service.model.AddressEntry>
		getAddressEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.address.service.model.AddressEntry>
					orderByComparator) {

		return _addressEntryLocalService.getAddressEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of address entries.
	 *
	 * @return the number of address entries
	 */
	@Override
	public int getAddressEntriesCount() {
		return _addressEntryLocalService.getAddressEntriesCount();
	}

	/**
	 * Returns the address entry with the primary key.
	 *
	 * @param addressId the primary key of the address entry
	 * @return the address entry
	 * @throws PortalException if a address entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.address.service.model.AddressEntry getAddressEntry(
			long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.getAddressEntry(addressId);
	}

	/**
	 * Returns the address entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the address entry's external reference code
	 * @return the matching address entry
	 * @throws PortalException if a matching address entry could not be found
	 */
	@Override
	public com.dogoo.address.service.model.AddressEntry
			getAddressEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.getAddressEntryByExternalReferenceCode(
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
	@Override
	public com.dogoo.address.service.model.AddressEntry
			getAddressEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.getAddressEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _addressEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _addressEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _addressEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.dogoo.address.service.model.AddressEntry updateAddress(
			long addAddressId, String detail, String postalCode, String ward,
			String district, String province, String country, String wardCode,
			String districtCode, String provinceCode, String countryCode,
			String title, long creatorId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressEntryLocalService.updateAddress(
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
	@Override
	public com.dogoo.address.service.model.AddressEntry updateAddressEntry(
		com.dogoo.address.service.model.AddressEntry addressEntry) {

		return _addressEntryLocalService.updateAddressEntry(addressEntry);
	}

	@Override
	public AddressEntryLocalService getWrappedService() {
		return _addressEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AddressEntryLocalService addressEntryLocalService) {

		_addressEntryLocalService = addressEntryLocalService;
	}

	private AddressEntryLocalService _addressEntryLocalService;

}