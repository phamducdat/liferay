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

package com.dogoo.department.service.service.impl;

import com.dogoo.department.service.model.BusinessEntry;
import com.dogoo.department.service.service.base.BusinessEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.dogoo.department.service.model.BusinessEntry",
	service = AopService.class
)
public class BusinessEntryLocalServiceImpl
	extends BusinessEntryLocalServiceBaseImpl {

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor = {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public BusinessEntry addBusinessEntry(
			long customerId,
			long creatorId,
			String name,
			ServiceContext context
	) {
		BusinessEntry entry =
				createBusinessEntry(counterLocalService.increment(BusinessEntry.class.getName()));
		Date currentDate = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);
		entry.setName(name);
		return addBusinessEntry(entry);
	}


	@Indexable(type = IndexableType.REINDEX)
	public BusinessEntry updateBusinessEntry(
			long creatorId,
			long entryId,
			String name,
			ServiceContext context
	) throws PortalException {
		BusinessEntry entry = getBusinessEntry(entryId);
		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);
		entry.setName(name);
		return updateBusinessEntry(entry);
	}


	public BusinessEntry fetchBusinessEntry(long customerId, String name) throws PortalException {
		return businessEntryPersistence.fetchByC_N(customerId, name);
	}


	private void createModifierAudit(long customerId,
									 long creatorId,
									 BusinessEntry entry,
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
									 BusinessEntry entry,
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