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

package com.liferay.docs.guestbook.service.impl;

import com.liferay.docs.guestbook.exception.GuestbookNameException;
import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.base.GuestbookLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author liferay
 */
@Component(
        property = "model.class.name=com.liferay.docs.guestbook.model.Guestbook",
        service = AopService.class
)
public class GuestbookLocalServiceImpl extends GuestbookLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public Guestbook addGuestbook(
            long userId, String name, ServiceContext serviceContext)
            throws PortalException {

        long groupId = serviceContext.getScopeGroupId();

        User user = userLocalService.getUserById(userId);

        Date now = new Date();

        validate(name);

        long guestbookId = counterLocalService.increment();

        Guestbook guestbook = guestbookPersistence.create(guestbookId);

        guestbook.setUuid(serviceContext.getUuid());
        guestbook.setUserId(userId);
        guestbook.setGroupId(groupId);
        guestbook.setCompanyId(user.getCompanyId());
        guestbook.setUserName(user.getFullName());
        guestbook.setCreateDate(serviceContext.getCreateDate(now));
        guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
        guestbook.setName(name);
        guestbook.setExpandoBridgeAttributes(serviceContext);

        resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
                Guestbook.class.getName(), guestbookId, false, true, true);

        guestbookPersistence.update(guestbook);

        return guestbook;

    }

    @Indexable(type = IndexableType.REINDEX)
    public Guestbook updateGuestbook(long userId, long guestbookId,
                                     String name, ServiceContext serviceContext) throws PortalException {
        Date now = new Date();

        validate(name);

        Guestbook guestbook = getGuestbook(guestbookId);

        User user = userLocalService.getUser(userId);

        guestbook.setUserId(userId);
        guestbook.setUserName(user.getFullName());
        guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
        guestbook.setName(name);
        guestbook.setExpandoBridgeAttributes(serviceContext);

        guestbookPersistence.update(guestbook);

        resourceLocalService.updateResources(serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(),
                Guestbook.class.getName(), guestbookId,
                serviceContext.getModelPermissions());

        return guestbook;
    }

//    public Guestbook deleteGuestbook(long guestbookId,
//                                     ServiceContext serviceContext) throws PortalException,
//            SystemException {
//
//        Guestbook guestbook = getGuestbook(guestbookId);
//
//        List<Entry> entries = entryPersistence.de
//
//        for (Entry entry : entries) {
//            entryLocalService.deleteEntry(entry.getEntryId());
//        }
//
//        guestbook = deleteGuestbook(guestbook);
//
//        return guestbook;
//    }

    public List<Guestbook> getGuestbooks(long groupId) {

        return guestbookPersistence.findByGroupId(groupId);
    }

    public List<Guestbook> getGuestbooks(long groupId, int start, int end,
                                         OrderByComparator<Guestbook> obc) {

        return guestbookPersistence.findByGroupId(groupId, start, end, obc);
    }

    public List<Guestbook> getGuestbooks(long groupId, int start, int end) {

        return guestbookPersistence.findByGroupId(groupId, start, end);
    }

    public int getGuestbooksCount(long groupId) {

        return guestbookPersistence.countByGroupId(groupId);
    }

    protected void validate(String name) throws PortalException {
        if (Validator.isNull(name)) {
            throw new GuestbookNameException();
        }
    }
}