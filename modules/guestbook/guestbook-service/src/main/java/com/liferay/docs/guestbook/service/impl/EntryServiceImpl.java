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

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.base.EntryServiceBaseImpl;
import com.liferay.docs.guestbook.service.permission.EntryPermission;
import com.liferay.docs.guestbook.service.permission.GuestbookModelPermission;
import com.liferay.docs.guestbook.util.ActionKeys;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author liferay
 */
@Component(
        property = {
                "json.web.service.context.name=gb",
                "json.web.service.context.path=Entry"
        },
        service = AopService.class
)
public class EntryServiceImpl extends EntryServiceBaseImpl {

    public Entry addEntry(long userId, long guestbookId, String name, String email,
                          String message, ServiceContext serviceContext) throws PortalException {

        GuestbookModelPermission.check(getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.ADD_ENTRY);

        return entryLocalService.addEntry(userId, guestbookId, name, email, message, serviceContext);
    }

    public List<Entry> getEntries(long groupId, long guestbookId) {
        return entryPersistence.filterFindByG_G(groupId, guestbookId);
    }

    public List<Entry> getEntries(long groupId, long guestbookId, int start, int end) {
        return entryPersistence.filterFindByG_G(groupId, guestbookId, start, end);
    }

    public int getEntriesCount(long groupId, long guestbookId) {
        return entryPersistence.filterCountByG_G(groupId, guestbookId);
    }

    public Entry updateEntry(long userId, long guestbookId, long entryId,
                             String name, String email, String message,
                             ServiceContext serviceContext) throws PortalException,
            SystemException {

        EntryPermission.check(getPermissionChecker(),
                entryId,
                ActionKeys.UPDATE);

        return entryLocalService.updateEntry(userId, guestbookId, entryId,
                name, email, message, serviceContext);
    }

}