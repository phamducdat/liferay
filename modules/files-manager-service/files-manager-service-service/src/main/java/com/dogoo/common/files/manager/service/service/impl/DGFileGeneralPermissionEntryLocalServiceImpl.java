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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileGeneralPermissionEntryException;
import com.dogoo.common.files.manager.service.mapper.model.FileGeneralPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.dogoo.common.files.manager.service.service.base.DGFileGeneralPermissionEntryLocalServiceBaseImpl;
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
        property = "model.class.name=com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry",
        service = AopService.class
)
public class DGFileGeneralPermissionEntryLocalServiceImpl
        extends DGFileGeneralPermissionEntryLocalServiceBaseImpl {


    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileGeneralPermissionEntry updateDGFileGeneralPermissionEntry(long customerId, long userId, long documentManagerFileId,
                                                                           FileGeneralPermissionMapperModel model,
                                                                           ServiceContext serviceContext) {
        DGFileGeneralPermissionEntry entry = dgFileGeneralPermissionEntryPersistence.fetchByC_F(customerId, documentManagerFileId);
        Date current = new Date();

        updateModifierAudit(userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setRole(model.getRole());
        entry.setAllowed(model.getAllowed());
        entry.setType(model.getType());

        return updateDGFileGeneralPermissionEntry(entry);
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileGeneralPermissionEntry createDGFileGeneralPermissionEntry(long customerId, long userId, long documentManagerFileId,
                                                                           FileGeneralPermissionMapperModel model,
                                                                           ServiceContext serviceContext) {
        DGFileGeneralPermissionEntry entry = createDGFileGeneralPermissionEntry(
                counterLocalService.increment(DGFileGeneralPermissionEntry.class.getName()));
        Date current = new Date();

        createModifierAudit(
                customerId,
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setFileId(documentManagerFileId);
        entry.setRole(model.getRole());
        entry.setAllowed(model.getAllowed());

        return addDGFileGeneralPermissionEntry(entry);
    }

    public void deleteDGFileGeneralPermissionEntry(long customerId, long documentManagerFileId) throws NoSuchDGFileGeneralPermissionEntryException {
        dgFileGeneralPermissionEntryPersistence.removeByC_F(customerId, documentManagerFileId);
    }

    public DGFileGeneralPermissionEntry fetchDGFileGeneralPermissionEntry(long customerId, long documentManagerFileId) {
        return dgFileGeneralPermissionEntryPersistence.fetchByC_F(customerId, documentManagerFileId);
    }

    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     DGFileGeneralPermissionEntry entry,
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
                                     DGFileGeneralPermissionEntry entry,
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