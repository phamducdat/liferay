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

package com.dogoo.common.files.manager.service.service;

import com.dogoo.common.files.manager.service.mapper.model.DocumentManagerMapperModel;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DGDocumentManagerEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGDocumentManagerEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DGDocumentManagerEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGDocumentManagerEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dg document manager entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DGDocumentManagerEntryLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public DGDocumentManagerEntry addDGDocumentManager(
			long customerId, long userId, Long departmentId,
			DocumentManagerMapperModel model, ServiceContext serviceContext)
		throws SearchException;

	public DGDocumentManagerEntry addDGDocumentManager(
		long fileId, long parentId, String pkCode,
		DGDocumentManagerEntry dgDocumentManagerEntry,
		ServiceContext serviceContext);

	/**
	 * Adds the dg document manager entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 * @return the dg document manager entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DGDocumentManagerEntry addDGDocumentManagerEntry(
		DGDocumentManagerEntry dgDocumentManagerEntry);

	/**
	 * Creates a new dg document manager entry with the primary key. Does not add the dg document manager entry to the database.
	 *
	 * @param documentManagerId the primary key for the new dg document manager entry
	 * @return the new dg document manager entry
	 */
	@Transactional(enabled = false)
	public DGDocumentManagerEntry createDGDocumentManagerEntry(
		long documentManagerId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteDgDocumentManagerEntriesByPkCode(String pkCode);

	/**
	 * Deletes the dg document manager entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 * @return the dg document manager entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DGDocumentManagerEntry deleteDGDocumentManagerEntry(
		DGDocumentManagerEntry dgDocumentManagerEntry);

	/**
	 * Deletes the dg document manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry that was removed
	 * @throws PortalException if a dg document manager entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DGDocumentManagerEntry deleteDGDocumentManagerEntry(
			long documentManagerId)
		throws PortalException;

	public void deleteDgDocumentManagerEntryById(
			DGDocumentManagerEntry dgDocumentManagerEntry)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry fetchDGDocumentManagerEntry(
		long documentManagerId);

	/**
	 * Returns the dg document manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg document manager entry's external reference code
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry
		fetchDGDocumentManagerEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry fetchDgDocumentManagerEntryByFileId(
		long fileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry
		fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
			String name, long parentId, String fileExtension, String pkCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry
		fetchDgDocumentManagerEntryByNameAndTypeAndPkCodeAndParentIdAndCategoryAndCreatorId(
			String name, String type, String pkCode, long parentId,
			String category, long creatorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGDocumentManagerEntry>
		fetchDgDocumentManagerEntryByPkCodeAndParentId(
			String pkCode, long parentId);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGDocumentManagerEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry fetchDGDocumentManagerEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dg document manager entry matching the UUID and group.
	 *
	 * @param uuid the dg document manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg document manager entry, or <code>null</code> if a matching dg document manager entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry fetchDGDocumentManagerEntryByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGDocumentManagerEntry>
		fetchDgDocumentManagerEntryListByParentId(long parentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGDocumentManagerEntry> fetchDgDocumentManagerEntryListByPkCode(
		String pkCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns a range of all the dg document manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGDocumentManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @return the range of dg document manager entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGDocumentManagerEntry> getDGDocumentManagerEntries(
		int start, int end);

	/**
	 * Returns all the dg document manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg document manager entries
	 * @param companyId the primary key of the company
	 * @return the matching dg document manager entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGDocumentManagerEntry>
		getDGDocumentManagerEntriesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of dg document manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg document manager entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg document manager entries
	 * @param end the upper bound of the range of dg document manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg document manager entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGDocumentManagerEntry>
		getDGDocumentManagerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGDocumentManagerEntry> orderByComparator);

	/**
	 * Returns the number of dg document manager entries.
	 *
	 * @return the number of dg document manager entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDGDocumentManagerEntriesCount();

	/**
	 * Returns the dg document manager entry with the primary key.
	 *
	 * @param documentManagerId the primary key of the dg document manager entry
	 * @return the dg document manager entry
	 * @throws PortalException if a dg document manager entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry getDGDocumentManagerEntry(
			long documentManagerId)
		throws PortalException;

	/**
	 * Returns the dg document manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg document manager entry's external reference code
	 * @return the matching dg document manager entry
	 * @throws PortalException if a matching dg document manager entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry
			getDGDocumentManagerEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the dg document manager entry matching the UUID and group.
	 *
	 * @param uuid the dg document manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg document manager entry
	 * @throws PortalException if a matching dg document manager entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGDocumentManagerEntry getDGDocumentManagerEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public DGDocumentManagerEntry updateDGDocumentManager(
			long userId, long documentId, DocumentManagerMapperModel model,
			ServiceContext serviceContext)
		throws SearchException;

	/**
	 * Updates the dg document manager entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGDocumentManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgDocumentManagerEntry the dg document manager entry
	 * @return the dg document manager entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DGDocumentManagerEntry updateDGDocumentManagerEntry(
		DGDocumentManagerEntry dgDocumentManagerEntry);

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public DGDocumentManagerEntry updateDGDocumentManagerPublic(
			long userId, long documentId, Boolean isPrivate,
			ServiceContext serviceContext)
		throws SearchException;

}