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

import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.dogoo.common.files.manager.service.service.DGFileGeneralPermissionEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileGeneralPermissionEntryLocalServiceUtil;
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
 * Provides the base implementation for the dg file general permission entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dogoo.common.files.manager.service.service.impl.DGFileGeneralPermissionEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dogoo.common.files.manager.service.service.impl.DGFileGeneralPermissionEntryLocalServiceImpl
 * @generated
 */
public abstract class DGFileGeneralPermissionEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DGFileGeneralPermissionEntryLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DGFileGeneralPermissionEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DGFileGeneralPermissionEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the dg file general permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileGeneralPermissionEntry the dg file general permission entry
	 * @return the dg file general permission entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DGFileGeneralPermissionEntry addDGFileGeneralPermissionEntry(
		DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		dgFileGeneralPermissionEntry.setNew(true);

		return dgFileGeneralPermissionEntryPersistence.update(
			dgFileGeneralPermissionEntry);
	}

	/**
	 * Creates a new dg file general permission entry with the primary key. Does not add the dg file general permission entry to the database.
	 *
	 * @param fileGeneralPermissionId the primary key for the new dg file general permission entry
	 * @return the new dg file general permission entry
	 */
	@Override
	@Transactional(enabled = false)
	public DGFileGeneralPermissionEntry createDGFileGeneralPermissionEntry(
		long fileGeneralPermissionId) {

		return dgFileGeneralPermissionEntryPersistence.create(
			fileGeneralPermissionId);
	}

	/**
	 * Deletes the dg file general permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileGeneralPermissionId the primary key of the dg file general permission entry
	 * @return the dg file general permission entry that was removed
	 * @throws PortalException if a dg file general permission entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DGFileGeneralPermissionEntry deleteDGFileGeneralPermissionEntry(
			long fileGeneralPermissionId)
		throws PortalException {

		return dgFileGeneralPermissionEntryPersistence.remove(
			fileGeneralPermissionId);
	}

	/**
	 * Deletes the dg file general permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileGeneralPermissionEntry the dg file general permission entry
	 * @return the dg file general permission entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DGFileGeneralPermissionEntry deleteDGFileGeneralPermissionEntry(
		DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		return dgFileGeneralPermissionEntryPersistence.remove(
			dgFileGeneralPermissionEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dgFileGeneralPermissionEntryPersistence.dslQuery(dslQuery);
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
			DGFileGeneralPermissionEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dgFileGeneralPermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileGeneralPermissionEntryModelImpl</code>.
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

		return dgFileGeneralPermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileGeneralPermissionEntryModelImpl</code>.
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

		return dgFileGeneralPermissionEntryPersistence.findWithDynamicQuery(
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
		return dgFileGeneralPermissionEntryPersistence.countWithDynamicQuery(
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

		return dgFileGeneralPermissionEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DGFileGeneralPermissionEntry fetchDGFileGeneralPermissionEntry(
		long fileGeneralPermissionId) {

		return dgFileGeneralPermissionEntryPersistence.fetchByPrimaryKey(
			fileGeneralPermissionId);
	}

	/**
	 * Returns the dg file general permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file general permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file general permission entry, or <code>null</code> if a matching dg file general permission entry could not be found
	 */
	@Override
	public DGFileGeneralPermissionEntry
		fetchDGFileGeneralPermissionEntryByUuidAndGroupId(
			String uuid, long groupId) {

		return dgFileGeneralPermissionEntryPersistence.fetchByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns the dg file general permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file general permission entry's external reference code
	 * @return the matching dg file general permission entry, or <code>null</code> if a matching dg file general permission entry could not be found
	 */
	@Override
	public DGFileGeneralPermissionEntry
		fetchDGFileGeneralPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return dgFileGeneralPermissionEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFileGeneralPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public DGFileGeneralPermissionEntry
		fetchDGFileGeneralPermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return fetchDGFileGeneralPermissionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file general permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file general permission entry's external reference code
	 * @return the matching dg file general permission entry
	 * @throws PortalException if a matching dg file general permission entry could not be found
	 */
	@Override
	public DGFileGeneralPermissionEntry
			getDGFileGeneralPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return dgFileGeneralPermissionEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file general permission entry with the primary key.
	 *
	 * @param fileGeneralPermissionId the primary key of the dg file general permission entry
	 * @return the dg file general permission entry
	 * @throws PortalException if a dg file general permission entry with the primary key could not be found
	 */
	@Override
	public DGFileGeneralPermissionEntry getDGFileGeneralPermissionEntry(
			long fileGeneralPermissionId)
		throws PortalException {

		return dgFileGeneralPermissionEntryPersistence.findByPrimaryKey(
			fileGeneralPermissionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			dgFileGeneralPermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			DGFileGeneralPermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"fileGeneralPermissionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dgFileGeneralPermissionEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			DGFileGeneralPermissionEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"fileGeneralPermissionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			dgFileGeneralPermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			DGFileGeneralPermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"fileGeneralPermissionId");
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
				<DGFileGeneralPermissionEntry>() {

				@Override
				public void performAction(
						DGFileGeneralPermissionEntry
							dgFileGeneralPermissionEntry)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, dgFileGeneralPermissionEntry);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					DGFileGeneralPermissionEntry.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgFileGeneralPermissionEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dgFileGeneralPermissionEntryLocalService.
			deleteDGFileGeneralPermissionEntry(
				(DGFileGeneralPermissionEntry)persistedModel);
	}

	@Override
	public BasePersistence<DGFileGeneralPermissionEntry> getBasePersistence() {
		return dgFileGeneralPermissionEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgFileGeneralPermissionEntryPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the dg file general permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file general permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file general permission entries, or an empty list if no matches were found
	 */
	@Override
	public List<DGFileGeneralPermissionEntry>
		getDGFileGeneralPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return dgFileGeneralPermissionEntryPersistence.findByUuid_C(
			uuid, companyId);
	}

	/**
	 * Returns a range of dg file general permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file general permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file general permission entries
	 * @param end the upper bound of the range of dg file general permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file general permission entries, or an empty list if no matches were found
	 */
	@Override
	public List<DGFileGeneralPermissionEntry>
		getDGFileGeneralPermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFileGeneralPermissionEntry> orderByComparator) {

		return dgFileGeneralPermissionEntryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the dg file general permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file general permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file general permission entry
	 * @throws PortalException if a matching dg file general permission entry could not be found
	 */
	@Override
	public DGFileGeneralPermissionEntry
			getDGFileGeneralPermissionEntryByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return dgFileGeneralPermissionEntryPersistence.findByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the dg file general permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFileGeneralPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file general permission entries
	 * @param end the upper bound of the range of dg file general permission entries (not inclusive)
	 * @return the range of dg file general permission entries
	 */
	@Override
	public List<DGFileGeneralPermissionEntry> getDGFileGeneralPermissionEntries(
		int start, int end) {

		return dgFileGeneralPermissionEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dg file general permission entries.
	 *
	 * @return the number of dg file general permission entries
	 */
	@Override
	public int getDGFileGeneralPermissionEntriesCount() {
		return dgFileGeneralPermissionEntryPersistence.countAll();
	}

	/**
	 * Updates the dg file general permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFileGeneralPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFileGeneralPermissionEntry the dg file general permission entry
	 * @return the dg file general permission entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DGFileGeneralPermissionEntry updateDGFileGeneralPermissionEntry(
		DGFileGeneralPermissionEntry dgFileGeneralPermissionEntry) {

		return dgFileGeneralPermissionEntryPersistence.update(
			dgFileGeneralPermissionEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DGFileGeneralPermissionEntryLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dgFileGeneralPermissionEntryLocalService =
			(DGFileGeneralPermissionEntryLocalService)aopProxy;

		_setLocalServiceUtilService(dgFileGeneralPermissionEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DGFileGeneralPermissionEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DGFileGeneralPermissionEntry.class;
	}

	protected String getModelClassName() {
		return DGFileGeneralPermissionEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				dgFileGeneralPermissionEntryPersistence.getDataSource();

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
		DGFileGeneralPermissionEntryLocalService
			dgFileGeneralPermissionEntryLocalService) {

		try {
			Field field =
				DGFileGeneralPermissionEntryLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, dgFileGeneralPermissionEntryLocalService);
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

	protected DGFileGeneralPermissionEntryLocalService
		dgFileGeneralPermissionEntryLocalService;

	@Reference
	protected DGFileGeneralPermissionEntryPersistence
		dgFileGeneralPermissionEntryPersistence;

	@Reference
	protected DGFileManagerEntryPersistence dgFileManagerEntryPersistence;

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