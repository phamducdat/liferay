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

package com.dogoo.common.comment.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmoticonEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmoticonEntryLocalService
 * @generated
 */
public class EmoticonEntryLocalServiceWrapper
	implements EmoticonEntryLocalService,
			   ServiceWrapper<EmoticonEntryLocalService> {

	public EmoticonEntryLocalServiceWrapper(
		EmoticonEntryLocalService emoticonEntryLocalService) {

		_emoticonEntryLocalService = emoticonEntryLocalService;
	}

	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry addEmoticon(
		long customerId, long creatorId,
		com.dogoo.common.comment.service.mapper.model.EmoticonMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _emoticonEntryLocalService.addEmoticon(
			customerId, creatorId, model, serviceContext);
	}

	/**
	 * Adds the emoticon entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonEntry the emoticon entry
	 * @return the emoticon entry that was added
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		addEmoticonEntry(
			com.dogoo.common.comment.service.model.EmoticonEntry
				emoticonEntry) {

		return _emoticonEntryLocalService.addEmoticonEntry(emoticonEntry);
	}

	/**
	 * Creates a new emoticon entry with the primary key. Does not add the emoticon entry to the database.
	 *
	 * @param emoticonId the primary key for the new emoticon entry
	 * @return the new emoticon entry
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		createEmoticonEntry(long emoticonId) {

		return _emoticonEntryLocalService.createEmoticonEntry(emoticonId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emoticonEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the emoticon entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonEntry the emoticon entry
	 * @return the emoticon entry that was removed
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		deleteEmoticonEntry(
			com.dogoo.common.comment.service.model.EmoticonEntry
				emoticonEntry) {

		return _emoticonEntryLocalService.deleteEmoticonEntry(emoticonEntry);
	}

	/**
	 * Deletes the emoticon entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry that was removed
	 * @throws PortalException if a emoticon entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
			deleteEmoticonEntry(long emoticonId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emoticonEntryLocalService.deleteEmoticonEntry(emoticonId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emoticonEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _emoticonEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _emoticonEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emoticonEntryLocalService.dynamicQuery();
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

		return _emoticonEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.comment.service.model.impl.EmoticonEntryModelImpl</code>.
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

		return _emoticonEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.comment.service.model.impl.EmoticonEntryModelImpl</code>.
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

		return _emoticonEntryLocalService.dynamicQuery(
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

		return _emoticonEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _emoticonEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		fetchEmoticonEntry(long emoticonId) {

		return _emoticonEntryLocalService.fetchEmoticonEntry(emoticonId);
	}

	/**
	 * Returns the emoticon entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the emoticon entry's external reference code
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		fetchEmoticonEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _emoticonEntryLocalService.
			fetchEmoticonEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchEmoticonEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		fetchEmoticonEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _emoticonEntryLocalService.fetchEmoticonEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the emoticon entry matching the UUID and group.
	 *
	 * @param uuid the emoticon entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emoticon entry, or <code>null</code> if a matching emoticon entry could not be found
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		fetchEmoticonEntryByUuidAndGroupId(String uuid, long groupId) {

		return _emoticonEntryLocalService.fetchEmoticonEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _emoticonEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the emoticon entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.comment.service.model.impl.EmoticonEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @return the range of emoticon entries
	 */
	@Override
	public java.util.List<com.dogoo.common.comment.service.model.EmoticonEntry>
		getEmoticonEntries(int start, int end) {

		return _emoticonEntryLocalService.getEmoticonEntries(start, end);
	}

	@Override
	public java.util.List<com.dogoo.common.comment.service.model.EmoticonEntry>
		getEmoticonEntriesByClassPkIdAndClassPkName(
			long customerId, long classPkId, String classPkName) {

		return _emoticonEntryLocalService.
			getEmoticonEntriesByClassPkIdAndClassPkName(
				customerId, classPkId, classPkName);
	}

	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
			getEmoticonEntriesByClassPkIdAndClassPkNameAndUser(
				long customerId, long classPkId, String classPkName,
				long creatorId)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return _emoticonEntryLocalService.
			getEmoticonEntriesByClassPkIdAndClassPkNameAndUser(
				customerId, classPkId, classPkName, creatorId);
	}

	/**
	 * Returns all the emoticon entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the emoticon entries
	 * @param companyId the primary key of the company
	 * @return the matching emoticon entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.common.comment.service.model.EmoticonEntry>
		getEmoticonEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _emoticonEntryLocalService.getEmoticonEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of emoticon entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the emoticon entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of emoticon entries
	 * @param end the upper bound of the range of emoticon entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching emoticon entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.common.comment.service.model.EmoticonEntry>
		getEmoticonEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.common.comment.service.model.EmoticonEntry>
					orderByComparator) {

		return _emoticonEntryLocalService.getEmoticonEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of emoticon entries.
	 *
	 * @return the number of emoticon entries
	 */
	@Override
	public int getEmoticonEntriesCount() {
		return _emoticonEntryLocalService.getEmoticonEntriesCount();
	}

	/**
	 * Returns the emoticon entry with the primary key.
	 *
	 * @param emoticonId the primary key of the emoticon entry
	 * @return the emoticon entry
	 * @throws PortalException if a emoticon entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
			getEmoticonEntry(long emoticonId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emoticonEntryLocalService.getEmoticonEntry(emoticonId);
	}

	/**
	 * Returns the emoticon entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the emoticon entry's external reference code
	 * @return the matching emoticon entry
	 * @throws PortalException if a matching emoticon entry could not be found
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
			getEmoticonEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emoticonEntryLocalService.
			getEmoticonEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the emoticon entry matching the UUID and group.
	 *
	 * @param uuid the emoticon entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emoticon entry
	 * @throws PortalException if a matching emoticon entry could not be found
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
			getEmoticonEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emoticonEntryLocalService.getEmoticonEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _emoticonEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _emoticonEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emoticonEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emoticonEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry updateEmoticon(
			long emoticonId,
			com.dogoo.common.comment.service.mapper.model.EmoticonMapperModel
				model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.dogoo.common.comment.service.exception.
			NoSuchEmoticonEntryException {

		return _emoticonEntryLocalService.updateEmoticon(
			emoticonId, model, serviceContext);
	}

	/**
	 * Updates the emoticon entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmoticonEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emoticonEntry the emoticon entry
	 * @return the emoticon entry that was updated
	 */
	@Override
	public com.dogoo.common.comment.service.model.EmoticonEntry
		updateEmoticonEntry(
			com.dogoo.common.comment.service.model.EmoticonEntry
				emoticonEntry) {

		return _emoticonEntryLocalService.updateEmoticonEntry(emoticonEntry);
	}

	@Override
	public EmoticonEntryLocalService getWrappedService() {
		return _emoticonEntryLocalService;
	}

	@Override
	public void setWrappedService(
		EmoticonEntryLocalService emoticonEntryLocalService) {

		_emoticonEntryLocalService = emoticonEntryLocalService;
	}

	private EmoticonEntryLocalService _emoticonEntryLocalService;

}