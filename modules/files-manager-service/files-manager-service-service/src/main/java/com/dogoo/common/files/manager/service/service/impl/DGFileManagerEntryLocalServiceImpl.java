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

package com.dogoo.common.files.manager.service.service.impl;

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileManagerEntryException;
import com.dogoo.common.files.manager.service.mapper.model.FileManagerMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.dogoo.common.files.manager.service.service.base.DGFileManagerEntryLocalServiceBaseImpl;

import com.dogoo.common.files.manager.service.service.log.AuditingUpdateFileService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.dogoo.common.files.manager.service.model.DGFileManagerEntry",
	service = AopService.class
)
public class DGFileManagerEntryLocalServiceImpl
	extends DGFileManagerEntryLocalServiceBaseImpl {

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor = {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public DGFileManagerEntry addDGFileManager(long customerId,
											   long userId,
											   FileManagerMapperModel model,
											   ServiceContext serviceContext){

		DGFileManagerEntry entry = createDGFileManagerEntry(
				counterLocalService.increment(DGFileManagerEntry.class.getName()));

		Date current = new Date();

		createModifierAudit(
				customerId,
				userId,
				entry,
				current,
				userLocalService.fetchUser(serviceContext.getUserId()),
				serviceContext);

		addDGFileManagerData(entry , model);

		return addDGFileManagerEntry(entry);
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor = {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public DGFileManagerEntry updateDGFileManager(long fileManagerId,
												   FileManagerMapperModel model,
													ServiceContext serviceContext) throws NoSuchDGFileManagerEntryException {

		DGFileManagerEntry entry = dgFileManagerEntryPersistence.
				findByPrimaryKey(fileManagerId);

		addDGFileManagerData(entry , model);

		return updateDGFileManagerEntry(entry);

	}

	public DGFileManagerEntry getDGFileManagerEntryByFileId(long fileId ,
															long customerId){

		return dgFileManagerEntryPersistence.fetchByF_C(fileId , customerId);
	}

	private void addDGFileManagerData(DGFileManagerEntry entry,
									   FileManagerMapperModel model) {

		entry.setFileId(model.getFileId());
		entry.setParentCode(model.getParentCode());
		entry.setFileType(model.getFileType());
		entry.setType(model.getType());
		entry.setPkType(model.getPkType());
		entry.setFileName(model.getFileName());
		entry.setFileSize(model.getFileSize());
		entry.setModuleId(model.getModuleId());
		entry.setAppId(model.getAppId());
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 DGFileManagerEntry entry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		entry.setCustomerId(customerId);
		entry.setGroupId(serviceContext.getScopeGroupId());
		entry.setCompanyId(serviceContext.getCompanyId());
		entry.setCreateDate(serviceContext.getCreateDate(current));
		entry.setExternalReferenceCode(UUID.randomUUID().toString());

		updateModifierAudit(creatorId, entry, current, user, serviceContext);
	}

	private void updateModifierAudit(long creatorId,
									 DGFileManagerEntry entry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		if (user != null) {
			entry.setUserName(user.getFullName());
			entry.setUserUuid(user.getUserUuid());
		}

		entry.setModifiedDate(serviceContext.getModifiedDate(current));
		entry.setUserId(serviceContext.getUserId());
		entry.setCreatorId(creatorId);
	}

}