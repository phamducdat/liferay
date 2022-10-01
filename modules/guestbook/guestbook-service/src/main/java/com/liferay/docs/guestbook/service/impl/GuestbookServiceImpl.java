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

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.base.GuestbookServiceBaseImpl;
import com.liferay.docs.guestbook.service.permission.GuestbookModelPermission;
import com.liferay.docs.guestbook.service.permission.GuestbookPermission;
import com.liferay.docs.guestbook.util.ActionKeys;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author liferay
 */
@Component(
        property = {
                "json.web.service.context.name=gb",
                "json.web.service.context.path=Guestbook"
        },
        service = AopService.class
)
public class GuestbookServiceImpl extends GuestbookServiceBaseImpl {

    public Guestbook addGuestbook(long userId, String name,
                                  ServiceContext serviceContext) throws PortalException {

        GuestbookModelPermission.check(getPermissionChecker(),
                serviceContext.getScopeGroupId(),
                ActionKeys.ADD_GUESTBOOK);

        return guestbookLocalService.addGuestbook(userId, name, serviceContext);
    }

    public List<Guestbook> getGuestbooks(long groupId) {

        return guestbookPersistence.filterFindByGroupId(groupId);
    }

    public List<Guestbook> getGuestbooks(long groupId, int start, int end) {
        return guestbookPersistence.filterFindByGroupId(groupId, start, end);
    }

    public int getGuestbooksCount(long groupId) {
        return guestbookPersistence.filterCountByGroupId(groupId);
    }

    public Guestbook updateGuestbook(long userId, long guestbookId,
                                     String name, ServiceContext serviceContext)
            throws PortalException {

        GuestbookPermission.check(getPermissionChecker(),
                guestbookId,
                ActionKeys.UPDATE);
        return guestbookLocalService.updateGuestbook(userId, guestbookId,
                name, serviceContext);
    }
}