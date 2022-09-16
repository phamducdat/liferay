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

package com.dogoo.common.files.manager.service.service.impl;

import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;
import com.dogoo.common.files.manager.service.service.base.DGFileVersionEntryLocalServiceBaseImpl;
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
        property = "model.class.name=com.dogoo.common.files.manager.service.model.DGFileVersionEntry",
        service = AopService.class
)
public class DGFileVersionEntryLocalServiceImpl
        extends DGFileVersionEntryLocalServiceBaseImpl {


    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileVersionEntry createDGFileVersionEntry(long customerId,
                                                       long userId,
                                                       long fileId,
                                                       long fileVersionId,
                                                       long accountId,
                                                       ServiceContext serviceContext) {
        DGFileVersionEntry entry = createDGFileVersionEntry(fileVersionId);

        Date current = new Date();

        createModifierAudit(
                customerId,
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext
        );
        entry.setFileId(fileId);
        entry.setAccountId(accountId);

        return addDGFileVersionEntry(entry);
    }

    public DGFileVersionEntry fetchByC_FV(long customerId, long fileVersionId) {
        return dgFileVersionEntryPersistence.fetchByC_FV(customerId, fileVersionId);
    }


    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     DGFileVersionEntry entry,
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
                                     DGFileVersionEntry entry,
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