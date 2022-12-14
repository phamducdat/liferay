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

import com.dogoo.common.files.manager.service.model.DGFilePermissionEntry;
import com.dogoo.common.files.manager.service.service.DGFilePermissionEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFilePermissionEntryLocalServiceUtil;
import com.dogoo.common.files.manager.service.service.persistence.DGDocumentManagerEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileManagerEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFilePermissionEntryPersistence;
import com.dogoo.common.files.manager.service.service.persistence.DGFileSettingPermissionEntryPersistence;

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
 * Provides the base implementation for the dg file permission entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dogoo.common.files.manager.service.service.impl.DGFilePermissionEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dogoo.common.files.manager.service.service.impl.DGFilePermissionEntryLocalServiceImpl
 * @generated
 */
public abstract class DGFilePermissionEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DGFilePermissionEntryLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DGFilePermissionEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DGFilePermissionEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the dg file permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermissionEntry the dg file permission entry
	 * @return the dg file permission entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DGFilePermissionEntry addDGFilePermissionEntry(
		DGFilePermissionEntry dgFilePermissionEntry) {

		dgFilePermissionEntry.setNew(true);

		return dgFilePermissionEntryPersistence.update(dgFilePermissionEntry);
	}

	/**
	 * Creates a new dg file permission entry with the primary key. Does not add the dg file permission entry to the database.
	 *
	 * @param filePermissionId the primary key for the new dg file permission entry
	 * @return the new dg file permission entry
	 */
	@Override
	@Transactional(enabled = false)
	public DGFilePermissionEntry createDGFilePermissionEntry(
		long filePermissionId) {

		return dgFilePermissionEntryPersistence.create(filePermissionId);
	}

	/**
	 * Deletes the dg file permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param filePermissionId the primary key of the dg file permission entry
	 * @return the dg file permission entry that was removed
	 * @throws PortalException if a dg file permission entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DGFilePermissionEntry deleteDGFilePermissionEntry(
			long filePermissionId)
		throws PortalException {

		return dgFilePermissionEntryPersistence.remove(filePermissionId);
	}

	/**
	 * Deletes the dg file permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermissionEntry the dg file permission entry
	 * @return the dg file permission entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DGFilePermissionEntry deleteDGFilePermissionEntry(
		DGFilePermissionEntry dgFilePermissionEntry) {

		return dgFilePermissionEntryPersistence.remove(dgFilePermissionEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dgFilePermissionEntryPersistence.dslQuery(dslQuery);
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
			DGFilePermissionEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dgFilePermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryModelImpl</code>.
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

		return dgFilePermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryModelImpl</code>.
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

		return dgFilePermissionEntryPersistence.findWithDynamicQuery(
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
		return dgFilePermissionEntryPersistence.countWithDynamicQuery(
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

		return dgFilePermissionEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DGFilePermissionEntry fetchDGFilePermissionEntry(
		long filePermissionId) {

		return dgFilePermissionEntryPersistence.fetchByPrimaryKey(
			filePermissionId);
	}

	/**
	 * Returns the dg file permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file permission entry, or <code>null</code> if a matching dg file permission entry could not be found
	 */
	@Override
	public DGFilePermissionEntry fetchDGFilePermissionEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return dgFilePermissionEntryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dg file permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission entry's external reference code
	 * @return the matching dg file permission entry, or <code>null</code> if a matching dg file permission entry could not be found
	 */
	@Override
	public DGFilePermissionEntry
		fetchDGFilePermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return dgFilePermissionEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDGFilePermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public DGFilePermissionEntry fetchDGFilePermissionEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchDGFilePermissionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dg file permission entry's external reference code
	 * @return the matching dg file permission entry
	 * @throws PortalException if a matching dg file permission entry could not be found
	 */
	@Override
	public DGFilePermissionEntry
			getDGFilePermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return dgFilePermissionEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dg file permission entry with the primary key.
	 *
	 * @param filePermissionId the primary key of the dg file permission entry
	 * @return the dg file permission entry
	 * @throws PortalException if a dg file permission entry with the primary key could not be found
	 */
	@Override
	public DGFilePermissionEntry getDGFilePermissionEntry(long filePermissionId)
		throws PortalException {

		return dgFilePermissionEntryPersistence.findByPrimaryKey(
			filePermissionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			dgFilePermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DGFilePermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("filePermissionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dgFilePermissionEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			DGFilePermissionEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"filePermissionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			dgFilePermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DGFilePermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("filePermissionId");
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
				<DGFilePermissionEntry>() {

				@Override
				public void performAction(
						DGFilePermissionEntry dgFilePermissionEntry)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, dgFilePermissionEntry);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					DGFilePermissionEntry.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgFilePermissionEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dgFilePermissionEntryLocalService.deleteDGFilePermissionEntry(
			(DGFilePermissionEntry)persistedModel);
	}

	@Override
	public BasePersistence<DGFilePermissionEntry> getBasePersistence() {
		return dgFilePermissionEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgFilePermissionEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the dg file permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file permission entries
	 * @param companyId the primary key of the company
	 * @return the matching dg file permission entries, or an empty list if no matches were found
	 */
	@Override
	public List<DGFilePermissionEntry>
		getDGFilePermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return dgFilePermissionEntryPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of dg file permission entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dg file permission entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dg file permission entries
	 * @param end the upper bound of the range of dg file permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dg file permission entries, or an empty list if no matches were found
	 */
	@Override
	public List<DGFilePermissionEntry>
		getDGFilePermissionEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DGFilePermissionEntry> orderByComparator) {

		return dgFilePermissionEntryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the dg file permission entry matching the UUID and group.
	 *
	 * @param uuid the dg file permission entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dg file permission entry
	 * @throws PortalException if a matching dg file permission entry could not be found
	 */
	@Override
	public DGFilePermissionEntry getDGFilePermissionEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return dgFilePermissionEntryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the dg file permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.common.files.manager.service.model.impl.DGFilePermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dg file permission entries
	 * @param end the upper bound of the range of dg file permission entries (not inclusive)
	 * @return the range of dg file permission entries
	 */
	@Override
	public List<DGFilePermissionEntry> getDGFilePermissionEntries(
		int start, int end) {

		return dgFilePermissionEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dg file permission entries.
	 *
	 * @return the number of dg file permission entries
	 */
	@Override
	public int getDGFilePermissionEntriesCount() {
		return dgFilePermissionEntryPersistence.countAll();
	}

	/**
	 * Updates the dg file permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DGFilePermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgFilePermissionEntry the dg file permission entry
	 * @return the dg file permission entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DGFilePermissionEntry updateDGFilePermissionEntry(
		DGFilePermissionEntry dgFilePermissionEntry) {

		return dgFilePermissionEntryPersistence.update(dgFilePermissionEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DGFilePermissionEntryLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dgFilePermissionEntryLocalService =
			(DGFilePermissionEntryLocalService)aopProxy;

		_setLocalServiceUtilService(dgFilePermissionEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DGFilePermissionEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DGFilePermissionEntry.class;
	}

	protected String getModelClassName() {
		return DGFilePermissionEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				dgFilePermissionEntryPersistence.getDataSource();

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
		DGFilePermissionEntryLocalService dgFilePermissionEntryLocalService) {

		try {
			Field field =
				DGFilePermissionEntryLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, dgFilePermissionEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DGDocumentManagerEntryPersistence
		dgDocumentManagerEntryPersistence;

	@Reference
	protected DGFileManagerEntryPersistence dgFileManagerEntryPersistence;

	protected DGFilePermissionEntryLocalService
		dgFilePermissionEntryLocalService;

	@Reference
	protected DGFilePermissionEntryPersistence dgFilePermissionEntryPersistence;

	@Reference
	protected DGFileSettingPermissionEntryPersistence
		dgFileSettingPermissionEntryPersistence;

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