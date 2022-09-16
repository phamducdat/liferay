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

import com.dogoo.common.files.manager.service.exception.NoSuchDGFileDepartmentPermissionEntryException;
import com.dogoo.common.files.manager.service.mapper.model.FileDepartmentPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.service.base.DGFileDepartmentPermissionEntryLocalServiceBaseImpl;
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
        property = "model.class.name=com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry",
        service = AopService.class
)
public class DGFileDepartmentPermissionEntryLocalServiceImpl
        extends DGFileDepartmentPermissionEntryLocalServiceBaseImpl {

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileDepartmentPermissionEntry createFileDepartmentPermission(long customerId,
                                                                          long userId,
                                                                          long documentManagerFileId,
                                                                          FileDepartmentPermissionMapperModel model,
                                                                          ServiceContext serviceContext) {
        DGFileDepartmentPermissionEntry entry = createDGFileDepartmentPermissionEntry(
                counterLocalService.increment(DGFileDepartmentPermissionEntry.class.getName()));

        Date current = new Date();
        createModifierAudit(
                customerId,
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);
        entry.setFileId(documentManagerFileId);
        entry.setDepartmentId(model.getId());
        entry.setRole(model.getRole());
        entry.setType(model.getType());

        return addDGFileDepartmentPermissionEntry(entry);
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGFileDepartmentPermissionEntry updateRoleFileDepartmentPermission(long customerId,
                                                                              long userId,
                                                                              long departmentId,
                                                                              long documentManagerFileId,
                                                                              String role,
                                                                              ServiceContext serviceContext) {
        DGFileDepartmentPermissionEntry entry = dgFileDepartmentPermissionEntryPersistence.fetchByC_D_F(customerId,
                departmentId,
                documentManagerFileId);

        Date current = new Date();

        updateModifierAudit(
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setRole(role);

        return updateDGFileDepartmentPermissionEntry(entry);
    }

    public List<DGFileDepartmentPermissionEntry> getAllByFileId(long customerId, long documentManagerFileId) {
        return dgFileDepartmentPermissionEntryPersistence.findByC_F(customerId, documentManagerFileId);
    }

    public void deleteFileDepartmentPermission(long customerId, long departmentId, long documentManagerFileId) throws NoSuchDGFileDepartmentPermissionEntryException {
        dgFileDepartmentPermissionEntryPersistence.removeByC_D_F(customerId, departmentId, documentManagerFileId);
    }

    public void deleteAllFileDepartmentPermissionByFileId(long customerId, long documentManagerFileId) {
        dgFileDepartmentPermissionEntryPersistence.removeByC_F(customerId, documentManagerFileId);
    }

    public DGFileDepartmentPermissionEntry fetchByC_D_F(long customerId, long departmentId, long documentManagerFileId) {
        return dgFileDepartmentPermissionEntryPersistence.fetchByC_D_F(customerId, departmentId, documentManagerFileId);
    }

    public List<DGFileDepartmentPermissionEntry> fetchByC_D(long customerId, long departmentId) {

        return dgFileDepartmentPermissionEntryPersistence.findByC_D(customerId, departmentId);
    }

    public List<DGFileDepartmentPermissionEntry> fetchByC_F(long customerId, long documentManagerFileId) {
        return dgFileDepartmentPermissionEntryPersistence.findByC_F(customerId, documentManagerFileId);
    }


    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     DGFileDepartmentPermissionEntry entry,
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
                                     DGFileDepartmentPermissionEntry entry,
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