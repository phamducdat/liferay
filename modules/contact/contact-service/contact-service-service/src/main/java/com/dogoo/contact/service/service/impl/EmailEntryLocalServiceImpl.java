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

package com.dogoo.contact.service.service.impl;

import com.dogoo.contact.service.model.EmailEntry;
import com.dogoo.contact.service.service.base.EmailEntryLocalServiceBaseImpl;

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
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.dogoo.email.service.model.EmailEntry",
	service = AopService.class
)
public class EmailEntryLocalServiceImpl extends EmailEntryLocalServiceBaseImpl {

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor = {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public EmailEntry addEmailEntry(
			long customerId,
			long creatorId,
			long contactId,
			String emailAddress,
			String description,
			boolean isDefaulted,
			ServiceContext context
	) {
		if (isDefaulted) setAllFalseIsDefaulted(customerId, contactId);
		EmailEntry entry =
				createEmailEntry(counterLocalService.increment(EmailEntry.class.getName()));
		Date currentDate = new Date();
		createModifierAudit(
				customerId,
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);
		entry.setContactId(contactId);
		entry.setEmailAddress(emailAddress);
		entry.setIsDefaulted(isDefaulted);
		entry.setDescription(description);
		return  addEmailEntry(entry);
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor = {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public EmailEntry updateEmailEntry(
			long creatorId,
			long entryId,
			long contactId,
			String emailAddress,
			String description,
			boolean isDefaulted,
			ServiceContext context
	) throws PortalException {
		EmailEntry entry = getEmailEntry(entryId);
		if (isDefaulted) setAllFalseIsDefaulted(entry.getCustomerId(), contactId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);
		entry.setContactId(contactId);
		entry.setEmailAddress(emailAddress);
		entry.setIsDefaulted(isDefaulted);
		entry.setDescription(description);
		return  updateEmailEntry(entry);
	}

	public List<EmailEntry> getEmailEntriesByContactId(long customerId, long contactId) {
		return emailEntryPersistence.findByC_C(customerId, contactId);
	}

	public EmailEntry fetchEmailEntryByEmailAddress(long customerId, String emailAddress) {
		return emailEntryPersistence.fetchByC_E(customerId, emailAddress);
	}

	public EmailEntry fetchEmailEntryByIsDefaulted(long customerId, boolean isDefaulted) {
		return emailEntryPersistence.fetchByC_I(customerId, isDefaulted);
	}

	private void setAllFalseIsDefaulted(long customerId, long contactId)  {
		List<EmailEntry> emailEntries = emailEntryPersistence.findByC_C(customerId, contactId);
		emailEntries.forEach(emailEntry -> {
			try {
				setFalseIsDefaulted(emailEntry.getEmailId());
			} catch (PortalException e) {
				e.printStackTrace();
			}
		});
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor = {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	private void setFalseIsDefaulted(long emailId) throws PortalException {
		EmailEntry entry = getEmailEntry(emailId);
		entry.setIsDefaulted(false);
		updateEmailEntry(entry);

	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 EmailEntry entry,
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
									 EmailEntry entry,
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