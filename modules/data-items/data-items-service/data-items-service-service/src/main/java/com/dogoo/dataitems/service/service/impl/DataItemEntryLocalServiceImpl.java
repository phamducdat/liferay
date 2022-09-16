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

package com.dogoo.dataitems.service.service.impl;

import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.base.DataItemEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author nghiatt
 */
@Component(
	property = "model.class.name=com.dogoo.dataitems.service.model.DataItemEntry",
	service = AopService.class
)
public class DataItemEntryLocalServiceImpl
	extends DataItemEntryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public DataItemEntry addDataItem(long customerId,
									 long creatorId,
									 String name,
									 String desc,
									 String type,
									 int order,
									 long parentId,
									 ServiceContext context) {

		DataItemEntry entry =
				createDataItemEntry(counterLocalService.increment(DataItemEntry.class.getName()));

		Date current = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				entry,
				current,
				context);

		entry.setExternalReferenceCode(UUID.randomUUID().toString());
		entry.setName(name);
		entry.setDescription(desc);
		entry.setType(type);
		entry.setOrder_(order);
		entry.setParentId(parentId);

		return addDataItemEntry(entry);
	}

	@Indexable(type = IndexableType.REINDEX)
	public DataItemEntry updateDataItem(long creatorId,
										long dataItemId,
									 	String name,
									 	String desc,
									 	String type,
									 	int order,
									 	long parentId,
									 	ServiceContext context)
			throws PortalException {

		DataItemEntry entry =
				getDataItemEntry(dataItemId);

		Date current = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				current,
				context);

		entry.setName(name);
		entry.setDescription(desc);
		entry.setType(type);
		entry.setOrder_(order);
		entry.setParentId(parentId);

		return updateDataItemEntry(entry);
	}

	public List<DataItemEntry> findAllBy(long customerId,
										 long parentId,
										 String type) {

		return dataItemEntryPersistence.findByC_P_T(customerId, parentId, type);
	}

	public DataItemEntry fetchDataItemByName(long customerId,
											 long parentId,
											 String type,
											 String name) {
		return dataItemEntryPersistence.fetchByC_P_N_T(customerId, parentId, name, type);
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 DataItemEntry entry,
									 Date current,
									 ServiceContext serviceContext) {

		entry.setCustomerId(customerId);
		entry.setGroupId(serviceContext.getScopeGroupId());
		entry.setCompanyId(serviceContext.getCompanyId());
		entry.setCreateDate(serviceContext.getCreateDate(current));

		updateModifierAudit(creatorId, entry, current, serviceContext);
	}

	private void updateModifierAudit(long creatorId,
									 DataItemEntry entry,
									 Date current,
									 ServiceContext serviceContext) {

		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			entry.setUserName(user.getFullName());
			entry.setUserUuid(user.getUserUuid());
		}

		entry.setModifiedDate(serviceContext.getModifiedDate(current));
		entry.setUserId(serviceContext.getUserId());
		entry.setCreatorId(creatorId);
	}

}