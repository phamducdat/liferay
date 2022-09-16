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

import com.dogoo.common.files.manager.service.mapper.model.FileUserPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.service.base.DGFileUserPermissionEntryLocalServiceBaseImpl;
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
        property = "model.class.name=com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry",
        service = AopService.class
)
public class DGFileUserPermissionEntryLocalServiceImpl
        extends DGFileUserPermissionEntryLocalServiceBaseImpl {

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileUserPermissionEntry createFileUserPermission(long customerId,
                                                              long userId,
                                                              long documentManagerFileId,
                                                              FileUserPermissionMapperModel model,
                                                              ServiceContext serviceContext) {
        DGFileUserPermissionEntry entry = createDGFileUserPermissionEntry(
                counterLocalService.increment(DGFileUserPermissionEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                customerId,
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setFileId(documentManagerFileId);
        entry.setUserAllowedId(model.getUserId());
        entry.setRole(model.getRole());
        entry.setStatus("approved");
        entry.setType(model.getType());

        return addDGFileUserPermissionEntry(entry);
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileUserPermissionEntry updateFileUserPermission(long customerId,
                                                              long userId,
                                                              long documentManagerFileId,
                                                              FileUserPermissionMapperModel model,
                                                              ServiceContext serviceContext) {
        DGFileUserPermissionEntry entry = dgFileUserPermissionEntryPersistence.fetchByC_U_F(customerId, userId, documentManagerFileId);

        Date current = new Date();

        updateModifierAudit(
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setRole(model.getRole());
        entry.setStatus("approved");


        return updateDGFileUserPermissionEntry(entry);
    }


    public List<DGFileUserPermissionEntry> getAllByFileId(long customerId, long documentManagerFileId) {
        return dgFileUserPermissionEntryPersistence.findByC_F_S(customerId, documentManagerFileId, "approved");
    }


    public void deleteFileUserPermission(long customerId,
                                         long userId,
                                         long documentManagerFileId,
                                         ServiceContext serviceContext) {

        DGFileUserPermissionEntry entry = dgFileUserPermissionEntryPersistence.fetchByC_U_F(customerId, userId, documentManagerFileId);
        Date current = new Date();

        if (entry == null) {
            DGFileUserPermissionEntry newEntry = createDGFileUserPermissionEntry(
                    counterLocalService.increment(DGFileUserPermissionEntry.class.getName()));

            createModifierAudit(
                    customerId,
                    userId,
                    newEntry,
                    current,
                    userLocalService.fetchUser(serviceContext.getUserId()),
                    serviceContext);
            newEntry.setFileId(documentManagerFileId);
            newEntry.setUserAllowedId(userId);
            newEntry.setRole("viewer");
            newEntry.setStatus("trashed");

            addDGFileUserPermissionEntry(newEntry);
            return;
        }

        updateModifierAudit(
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setStatus("trashed");

        updateDGFileUserPermissionEntry(entry);
    }

    public void deleteAllFileUserPermissionByFileId(long customerId, long documentManagerFileId) {
        dgFileUserPermissionEntryPersistence.removeByC_F(customerId, documentManagerFileId);
    }

    public DGFileUserPermissionEntry fetchByC_U_F(long customerId, long userId, long documentManagerFileId) {
        return dgFileUserPermissionEntryPersistence.fetchByC_U_F(customerId, userId, documentManagerFileId);
    }

    public List<DGFileUserPermissionEntry> fetchByC_F(long customerId, long documentManagerFileId) {
        return dgFileUserPermissionEntryPersistence.findByC_F(customerId, documentManagerFileId);
    }

    public List<DGFileUserPermissionEntry> fetchByC_U(long customerId, long userId) {

        return dgFileUserPermissionEntryPersistence.findByC_U(customerId,
                userId);
    }

    public List<DGFileUserPermissionEntry> fetchByC_U_S(long customerId, long userId, String status) {

        return dgFileUserPermissionEntryPersistence.findByC_U_S(customerId,
                userId,
                status);
    }


    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     DGFileUserPermissionEntry entry,
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
                                     DGFileUserPermissionEntry entry,
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