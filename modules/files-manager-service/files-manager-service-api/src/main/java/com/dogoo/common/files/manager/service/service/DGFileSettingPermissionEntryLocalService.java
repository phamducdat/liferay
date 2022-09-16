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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileSettingPermissionEntryException;
import com.dogoo.common.files.manager.service.mapper.model.FileSettingPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;

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
 * Provides the local service interface for DGFileSettingPermissionEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileSettingPermissionEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DGFileSettingPermissionEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.dogoo.common.files.manager.service.service.impl.DGFileSettingPermissionEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dg file setting permission entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DGFileSettingPermissionEntryLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the dg file setting permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 * @return the dg file setting permission entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DGFileSettingPermissionEntry addDGFileSettingPermissionEntry(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry);

	/**
	 * Creates a new dg file setting permission entry with the primary key. Does not add the dg file setting permission entry to the database.
	 *
	 * @param fileSettingPermissionId the primary key for the new dg file setting permission entry
	 * @return the new dg file setting permission entry
	 */
	@Transactional(enabled = false)
	public DGFileSettingPermissionEntry createDGFileSettingPermissionEntry(
		long fileSettingPermissionId);

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public DGFileSettingPermissionEntry createDGFileSettingPermissionEntry(
		long customerId, long userId, long documentManagerFileId,
		FileSettingPermissionMapperModel model, ServiceContext serviceContext);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the dg file setting permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 * @return the dg file setting permission entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DGFileSettingPermissionEntry deleteDGFileSettingPermissionEntry(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry);

	/**
	 * Deletes the dg file setting permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry that was removed
	 * @throws PortalException if a dg file setting permission entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DGFileSettingPermissionEntry deleteDGFileSettingPermissionEntry(
			long fileSettingPermissionId)
		throws PortalException;

	public void deleteDGFileSettingPermissionEntry(
			long customerId, long documentManagerFileId)
		throws NoSuchDGFileSettingPermissionEntryException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryModelImpl</code>.
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
	public DGFileSettingPermissionEntry fetchDGFileSettingPermissionEntry(
		long fileSettingPermissionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGFileSettingPermissionEntry fetchDGFileSettingPermissionEntry(
		long customerId, long documentManagerFileId);

	/**
	 * Returns the dg file setting permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file setting permission entry's external reference code
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGFileSettingPermissionEntry
		fetchDGFileSettingPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileSettingPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGFileSettingPermissionEntry
		fetchDGFileSettingPermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode);

	/**
	 * Returns the dg file setting permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file setting permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGFileSettingPermissionEntry
		fetchDGFileSettingPermissionEntryByUuidAndGroupId(
			String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns a range of all the dg file setting permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileSettingPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @return the range of dg file setting permission entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGFileSettingPermissionEntry> getDGFileSettingPermissionEntries(
		int start, int end);

	/**
	 * Returns all the dg file setting permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file setting permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file setting permission entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGFileSettingPermissionEntry>
		getDGFileSettingPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of dg file setting permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file setting permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file setting permission entries
	 * @param end the upper bound of the range of dg file setting permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file setting permission entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DGFileSettingPermissionEntry>
		getDGFileSettingPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator);

	/**
	 * Returns the number of dg file setting permission entries.
	 *
	 * @return the number of dg file setting permission entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDGFileSettingPermissionEntriesCount();

	/**
	 * Returns the dg file setting permission entry with the primary key.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry
	 * @throws PortalException if a dg file setting permission entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGFileSettingPermissionEntry getDGFileSettingPermissionEntry(
			long fileSettingPermissionId)
		throws PortalException;

	/**
	 * Returns the dg file setting permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file setting permission entry's external reference code
	 * @return the matching dg file setting permission entry
	 * @throws PortalException if a matching dg file setting permission entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGFileSettingPermissionEntry
			getDGFileSettingPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the dg file setting permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file setting permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file setting permission entry
	 * @throws PortalException if a matching dg file setting permission entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DGFileSettingPermissionEntry
			getDGFileSettingPermissionEntryByUuidAndGroupId(
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

	/**
	 * Updates the dg file setting permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileSettingPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileSettingPermissionEntry the dg file setting permission entry
	 * @return the dg file setting permission entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DGFileSettingPermissionEntry updateDGFileSettingPermissionEntry(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry);

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public DGFileSettingPermissionEntry updateDGFileSettingPermissionEntry(
		long customerId, long userId, long documentManagerFileId,
		FileSettingPermissionMapperModel model, ServiceContext serviceContext);

}