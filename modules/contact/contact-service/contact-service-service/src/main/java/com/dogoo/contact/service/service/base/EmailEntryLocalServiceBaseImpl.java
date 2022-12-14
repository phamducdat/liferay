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

package com.dogoo.contact.service.service.base;

import com.dogoo.contact.service.model.EmailEntry;
import com.dogoo.contact.service.service.EmailEntryLocalService;
import com.dogoo.contact.service.service.EmailEntryLocalServiceUtil;
import com.dogoo.contact.service.service.persistence.ContactEntryPersistence;
import com.dogoo.contact.service.service.persistence.EmailEntryPersistence;
import com.dogoo.contact.service.service.persistence.PhoneEntryPersistence;

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
 * Provides the base implementation for the email entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dogoo.contact.service.service.impl.EmailEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dogoo.contact.service.service.impl.EmailEntryLocalServiceImpl
 * @generated
 */
public abstract class EmailEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EmailEntryLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmailEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EmailEntryLocalServiceUtil</code>.
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmailEntry addEmailEntry(EmailEntry emailEntry) {
		emailEntry.setNew(true);

		return emailEntryPersistence.update(emailEntry);
	}

	/**
	 * Creates a new email entry with the primary key. Does not add the email entry to the database.
	 *
	 * @param emailId the primary key for the new email entry
	 * @return the new email entry
	 */
	@Override
	@Transactional(enabled = false)
	public EmailEntry createEmailEntry(long emailId) {
		return emailEntryPersistence.create(emailId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmailEntry deleteEmailEntry(long emailId) throws PortalException {
		return emailEntryPersistence.remove(emailId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmailEntry deleteEmailEntry(EmailEntry emailEntry) {
		return emailEntryPersistence.remove(emailEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return emailEntryPersistence.dslQuery(dslQuery);
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
			EmailEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return emailEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return emailEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return emailEntryPersistence.findWithDynamicQuery(
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
		return emailEntryPersistence.countWithDynamicQuery(dynamicQuery);
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

		return emailEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EmailEntry fetchEmailEntry(long emailId) {
		return emailEntryPersistence.fetchByPrimaryKey(emailId);
	}

	/**
	 * Returns the email entry matching the UUID and group.
	 *
	 * @param uuid the email entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchEmailEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return emailEntryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the email entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the email entry's external reference code
	 * @return the matching email entry, or <code>null</code> if a matching email entry could not be found
	 */
	@Override
	public EmailEntry fetchEmailEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return emailEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchEmailEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public EmailEntry fetchEmailEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchEmailEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the email entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the email entry's external reference code
	 * @return the matching email entry
	 * @throws PortalException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry getEmailEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return emailEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the email entry with the primary key.
	 *
	 * @param emailId the primary key of the email entry
	 * @return the email entry
	 * @throws PortalException if a email entry with the primary key could not be found
	 */
	@Override
	public EmailEntry getEmailEntry(long emailId) throws PortalException {
		return emailEntryPersistence.findByPrimaryKey(emailId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(emailEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmailEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("emailId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			emailEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EmailEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("emailId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(emailEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmailEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("emailId");
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
			new ActionableDynamicQuery.PerformActionMethod<EmailEntry>() {

				@Override
				public void performAction(EmailEntry emailEntry)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, emailEntry);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(EmailEntry.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return emailEntryPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return emailEntryLocalService.deleteEmailEntry(
			(EmailEntry)persistedModel);
	}

	@Override
	public BasePersistence<EmailEntry> getBasePersistence() {
		return emailEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return emailEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the email entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the email entries
	 * @param companyId the primary key of the company
	 * @return the matching email entries, or an empty list if no matches were found
	 */
	@Override
	public List<EmailEntry> getEmailEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return emailEntryPersistence.findByUuid_C(uuid, companyId);
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
	@Override
	public List<EmailEntry> getEmailEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmailEntry> orderByComparator) {

		return emailEntryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the email entry matching the UUID and group.
	 *
	 * @param uuid the email entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching email entry
	 * @throws PortalException if a matching email entry could not be found
	 */
	@Override
	public EmailEntry getEmailEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return emailEntryPersistence.findByUUID_G(uuid, groupId);
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
	@Override
	public List<EmailEntry> getEmailEntries(int start, int end) {
		return emailEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of email entries.
	 *
	 * @return the number of email entries
	 */
	@Override
	public int getEmailEntriesCount() {
		return emailEntryPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmailEntry updateEmailEntry(EmailEntry emailEntry) {
		return emailEntryPersistence.update(emailEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmailEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		emailEntryLocalService = (EmailEntryLocalService)aopProxy;

		_setLocalServiceUtilService(emailEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmailEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmailEntry.class;
	}

	protected String getModelClassName() {
		return EmailEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = emailEntryPersistence.getDataSource();

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
		EmailEntryLocalService emailEntryLocalService) {

		try {
			Field field = EmailEntryLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, emailEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ContactEntryPersistence contactEntryPersistence;

	protected EmailEntryLocalService emailEntryLocalService;

	@Reference
	protected EmailEntryPersistence emailEntryPersistence;

	@Reference
	protected PhoneEntryPersistence phoneEntryPersistence;

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