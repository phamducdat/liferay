/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.contact.service.service.impl;

import com.dogoo.contact.service.model.ContactEntry;
import com.dogoo.contact.service.service.base.ContactEntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.GroupedModel;
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
        property = "model.class.name=com.dogoo.contact.service.model.ContactEntry",
        service = AopService.class
)
public class ContactEntryLocalServiceImpl
        extends ContactEntryLocalServiceBaseImpl {

    public ContactEntry addContactEntry(
            long customerId,
            long creatorId,
            String facebook,
            String twitter,
            String linkedin,
            ServiceContext context
    ) {

        ContactEntry entry =
                createContactEntry(counterLocalService.increment(ContactEntry.class.getName()));
        Date currentDate = new Date();

        baseCreateModifierAudit(
                entry,
                currentDate,
                userLocalService.fetchUser(context.getUserId()),
                context
        );
        entry.setCreatorId(creatorId);
        entry.setCustomerId(customerId);
        entry.setExternalReferenceCode(UUID.randomUUID().toString());
        entry.setFacebook(facebook);
        entry.setTwitter(twitter);
        entry.setLinkedin(linkedin);
        return addContactEntry(entry);
    }

    public ContactEntry updateContactEntry(
            long creatorId,
            long entryId,
            String facebook,
            String twitter,
            String linkedin,
            ServiceContext context
    ) throws PortalException {
        ContactEntry entry = getContactEntry(entryId);
        Date currentDate = new Date();

        baseUpdateModifierAudit(
                entry,
                currentDate,
                userLocalService.fetchUser(context.getUserId()),
                context);

        entry.setCreatorId(creatorId);
        entry.setFacebook(facebook);
        entry.setTwitter(twitter);
        entry.setLinkedin(linkedin);
        return updateContactEntry(entry);
    }

//	private void createModifierAudit(long customerId,
//									 long creatorId,
//									 ContactEntry entry,
//									 Date current,
//									 User user,
//									 ServiceContext serviceContext) {
//
//		entry.setCustomerId(customerId);
//		entry.setGroupId(serviceContext.getScopeGroupId());
//		entry.setCompanyId(serviceContext.getCompanyId());
//		entry.setCreateDate(serviceContext.getCreateDate(current));
//		entry.setExternalReferenceCode(UUID.randomUUID().toString());
//
//		updateModifierAudit(creatorId, entry, current, user, serviceContext);
//	}

    private void baseCreateModifierAudit(
            GroupedModel entry,
            Date current,
            User user,
            ServiceContext context) {
//		entry.setCustomerId(customerId);
        entry.setGroupId(context.getScopeGroupId());
        entry.setCompanyId(context.getCompanyId());
        entry.setCreateDate(context.getCreateDate(current));
//		entry.setExternalReferenceCode(UUID.randomUUID().toString());

        baseUpdateModifierAudit(entry, current, user, context);
    }

    private void baseUpdateModifierAudit(
            GroupedModel entry,
            Date current,
            User user,
            ServiceContext serviceContext) {

        if (user != null) {
            entry.setUserName(user.getFullName());
            entry.setUserUuid(user.getUserUuid());
        }

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setUserId(serviceContext.getUserId());
    }

}