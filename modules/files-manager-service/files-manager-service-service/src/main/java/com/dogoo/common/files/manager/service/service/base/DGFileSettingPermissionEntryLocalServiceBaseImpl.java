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

package com.dogoo.common.files.manager.service.service.base;

import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.service.DGFileSettingPermissionEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileSettingPermissionEntryLocalServiceUtil;
import com.dogoo.common.files.manager.service.service.persistence.DGDocumentManagerEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileDepartmentPermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileGeneralPermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileManagerEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileSettingPermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileUserPermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileVersionEntryPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the dg file setting permission entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dogoo.common.files.manager.service.service.impl.DGFileSettingPermissionEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dogoo.common.files.manager.service.service.impl.DGFileSettingPermissionEntryLocalServiceImpl
 * @generated
 */
public abstract class DGFileSettingPermissionEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DGFileSettingPermissionEntryLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DGFileSettingPermissionEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DGFileSettingPermissionEntryLocalServiceUtil</code>.
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
	@Override
	public DGFileSettingPermissionEntry addDGFileSettingPermissionEntry(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		dgFileSettingPermissionEntry.setNew(true);

		return dgFileSettingPermissionEntryPersistence.update(
			dgFileSettingPermissionEntry);
	}

	/**
	 * Creates a new dg file setting permission entry with the primary key. Does not add the dg file setting permission entry to the database.
	 *
	 * @param fileSettingPermissionId the primary key for the new dg file setting permission entry
	 * @return the new dg file setting permission entry
	 */
	@Override
	@Transactional(enabled = false)
	public DGFileSettingPermissionEntry createDGFileSettingPermissionEntry(
		long fileSettingPermissionId) {

		return dgFileSettingPermissionEntryPersistence.create(
			fileSettingPermissionId);
	}

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
	@Override
	public DGFileSettingPermissionEntry deleteDGFileSettingPermissionEntry(
			long fileSettingPermissionId)
		throws PortalException {

		return dgFileSettingPermissionEntryPersistence.remove(
			fileSettingPermissionId);
	}

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
	@Override
	public DGFileSettingPermissionEntry deleteDGFileSettingPermissionEntry(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		return dgFileSettingPermissionEntryPersistence.remove(
			dgFileSettingPermissionEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dgFileSettingPermissionEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DGFileSettingPermissionEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dgFileSettingPermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return dgFileSettingPermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return dgFileSettingPermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dgFileSettingPermissionEntryPersistence.countWithDynamicQuery(
			dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return dgFileSettingPermissionEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DGFileSettingPermissionEntry fetchDGFileSettingPermissionEntry(
		long fileSettingPermissionId) {

		return dgFileSettingPermissionEntryPersistence.fetchByPrimaryKey(
			fileSettingPermissionId);
	}

	/**
	 * Returns the dg file setting permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file setting permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry
		fetchDGFileSettingPermissionEntryByUuidAndGroupId(
			String uuid, long groupId) {

		return dgFileSettingPermissionEntryPersistence.fetchByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns the dg file setting permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file setting permission entry's external reference code
	 * @return the matching dg file setting permission entry, or <code>null</code> if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry
		fetchDGFileSettingPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return dgFileSettingPermissionEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileSettingPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public DGFileSettingPermissionEntry
		fetchDGFileSettingPermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return fetchDGFileSettingPermissionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file setting permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file setting permission entry's external reference code
	 * @return the matching dg file setting permission entry
	 * @throws PortalException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry
			getDGFileSettingPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return dgFileSettingPermissionEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file setting permission entry with the primary key.
	 *
	 * @param fileSettingPermissionId the primary key of the dg file setting permission entry
	 * @return the dg file setting permission entry
	 * @throws PortalException if a dg file setting permission entry with the primary key could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry getDGFileSettingPermissionEntry(
			long fileSettingPermissionId)
		throws PortalException {

		return dgFileSettingPermissionEntryPersistence.findByPrimaryKey(
			fileSettingPermissionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			dgFileSettingPermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			DGFileSettingPermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"fileSettingPermissionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dgFileSettingPermissionEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			DGFileSettingPermissionEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"fileSettingPermissionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			dgFileSettingPermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			DGFileSettingPermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"fileSettingPermissionId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<DGFileSettingPermissionEntry>() {

				@Override
				public void performAction(
						DGFileSettingPermissionEntry
							dgFileSettingPermissionEntry)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, dgFileSettingPermissionEntry);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					DGFileSettingPermissionEntry.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgFileSettingPermissionEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dgFileSettingPermissionEntryLocalService.
			deleteDGFileSettingPermissionEntry(
				(DGFileSettingPermissionEntry)persistedModel);
	}

	@Override
	public BasePersistence<DGFileSettingPermissionEntry> getBasePersistence() {
		return dgFileSettingPermissionEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgFileSettingPermissionEntryPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the dg file setting permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file setting permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file setting permission entries, or an empty list if no matches were found
	 */
	@Override
	public List<DGFileSettingPermissionEntry>
		getDGFileSettingPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return dgFileSettingPermissionEntryPersistence.findByUuid_C(
			uuid, companyId);
	}

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
	@Override
	public List<DGFileSettingPermissionEntry>
		getDGFileSettingPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFileSettingPermissionEntry> orderByComparator) {

		return dgFileSettingPermissionEntryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the dg file setting permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file setting permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file setting permission entry
	 * @throws PortalException if a matching dg file setting permission entry could not be found
	 */
	@Override
	public DGFileSettingPermissionEntry
			getDGFileSettingPermissionEntryByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return dgFileSettingPermissionEntryPersistence.findByUUID_G(
			uuid, groupId);
	}

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
	@Override
	public List<DGFileSettingPermissionEntry> getDGFileSettingPermissionEntries(
		int start, int end) {

		return dgFileSettingPermissionEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dg file setting permission entries.
	 *
	 * @return the number of dg file setting permission entries
	 */
	@Override
	public int getDGFileSettingPermissionEntriesCount() {
		return dgFileSettingPermissionEntryPersistence.countAll();
	}

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
	@Override
	public DGFileSettingPermissionEntry updateDGFileSettingPermissionEntry(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		return dgFileSettingPermissionEntryPersistence.update(
			dgFileSettingPermissionEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DGFileSettingPermissionEntryLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dgFileSettingPermissionEntryLocalService =
			(DGFileSettingPermissionEntryLocalService)aopProxy;

		_setLocalServiceUtilService(dgFileSettingPermissionEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DGFileSettingPermissionEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DGFileSettingPermissionEntry.class;
	}

	protected String getModelClassName() {
		return DGFileSettingPermissionEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				dgFileSettingPermissionEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		DGFileSettingPermissionEntryLocalService
			dgFileSettingPermissionEntryLocalService) {

		try {
			Field field =
				DGFileSettingPermissionEntryLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, dgFileSettingPermissionEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DGDocumentManagerEntryPersistence
		dgDocumentManagerEntryPersistence;

	@Reference
	protected DGFileDepartmentPermissionEntryPersistence
		dgFileDepartmentPermissionEntryPersistence;

	@Reference
	protected DGFileGeneralPermissionEntryPersistence
		dgFileGeneralPermissionEntryPersistence;

	@Reference
	protected DGFileManagerEntryPersistence dgFileManagerEntryPersistence;

	protected DGFileSettingPermissionEntryLocalService
		dgFileSettingPermissionEntryLocalService;

	@Reference
	protected DGFileSettingPermissionEntryPersistence
		dgFileSettingPermissionEntryPersistence;

	@Reference
	protected DGFileUserPermissionEntryPersistence
		dgFileUserPermissionEntryPersistence;

	@Reference
	protected DGFileVersionEntryPersistence dgFileVersionEntryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}