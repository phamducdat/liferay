/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser Setting Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser Setting Public License for more
 * details.
 */

package com.dogoo.common.files.manager.service.service.impl;

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileSettingPermissionEntryException;
import com.dogoo.common.files.manager.service.mapper.model.FileSettingPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.service.base.DGFileSettingPermissionEntryLocalServiceBaseImpl;
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
        property = "model.class.name=com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry",
        service = AopService.class
)
public class DGFileSettingPermissionEntryLocalServiceImpl
        extends DGFileSettingPermissionEntryLocalServiceBaseImpl {

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileSettingPermissionEntry updateDGFileSettingPermissionEntry(long customerId, long userId, long documentManagerFileId,
                                                                           FileSettingPermissionMapperModel model,
                                                                           ServiceContext serviceContext) {
        DGFileSettingPermissionEntry entry = dgFileSettingPermissionEntryPersistence.fetchByC_F(customerId, documentManagerFileId);
        Date current = new Date();

        updateModifierAudit(userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setPermissionEditor(model.getPermissionEditor());
        entry.setPermissionViewer(model.getPermissionViewer());

        return updateDGFileSettingPermissionEntry(entry);
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileSettingPermissionEntry createDGFileSettingPermissionEntry(long customerId, long userId, long documentManagerFileId,
                                                                           FileSettingPermissionMapperModel model,
                                                                           ServiceContext serviceContext) {
        DGFileSettingPermissionEntry entry = createDGFileSettingPermissionEntry(
                counterLocalService.increment(DGFileSettingPermissionEntry.class.getName()));
        Date current = new Date();
        createModifierAudit(
                customerId,
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setPermissionViewer(model.getPermissionViewer());
        entry.setPermissionEditor(model.getPermissionEditor());
        entry.setFileId(documentManagerFileId);
        entry.setType(model.getType());

        return addDGFileSettingPermissionEntry(entry);
    }

    public void deleteDGFileSettingPermissionEntry(long customerId, long documentManagerFileId) throws NoSuchDGFileSettingPermissionEntryException {
        dgFileSettingPermissionEntryPersistence.removeByC_F(customerId, documentManagerFileId);
    }

    public DGFileSettingPermissionEntry fetchDGFileSettingPermissionEntry(long customerId, long documentManagerFileId) {
        return dgFileSettingPermissionEntryPersistence.fetchByC_F(customerId, documentManagerFileId);
    }

    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     DGFileSettingPermissionEntry entry,
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
                                     DGFileSettingPermissionEntry entry,
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