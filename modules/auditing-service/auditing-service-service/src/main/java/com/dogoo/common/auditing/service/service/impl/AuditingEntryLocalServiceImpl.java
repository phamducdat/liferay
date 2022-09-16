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

package com.dogoo.common.auditing.service.service.impl;

import com.dogoo.common.auditing.service.mapper.model.AuditingMapperModel;
import com.dogoo.common.auditing.service.model.AuditingEntry;
import com.dogoo.common.auditing.service.service.base.AuditingEntryLocalServiceBaseImpl;
import com.dogoo.employee.service.model.EmployeeEntry;
import com.dogoo.employee.service.service.EmployeeEntryLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.dogoo.common.auditing.service.model.AuditingEntry",
        service = AopService.class
)
public class AuditingEntryLocalServiceImpl
        extends AuditingEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public AuditingEntry addAuditingEntry(long customerId,
                                          long creatorId,
                                          long classPkId,
                                          String classPkName,
                                          AuditingMapperModel model,
                                          ServiceContext serviceContext) {
        AuditingEntry entry =
                createAuditingEntry(counterLocalService.increment(AuditingEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                customerId,
                creatorId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setClassPkId(classPkId);
        entry.setClassPkName(classPkName);
        entry.setName(model.getName());
        entry.setEventType(model.getEventType());
        entry.setMessage(model.getMessage());
        entry.setPayload(model.getPayload());
        entry.setParentPkId(model.getParentPkId());
        entry.setParentPkName(model.getParentPkName());

        return addAuditingEntry(entry);
    }

    public List<AuditingEntry> findByPKAndName(long classPkId, String classPkName) {
        return auditingEntryPersistence.findByPK_Name(classPkId, classPkName);
    }

    public List<AuditingEntry> findByParentPKAndName(long parentPkId, String parentPkName) {
        return auditingEntryPersistence.findByParent_PK_Name(parentPkId, parentPkName);
    }

    public void deleteByPkAndName(long classPkId, String classPkName) {
        findByPKAndName(classPkId, classPkName).forEach(this::deleteAuditingEntry);
        findByParentPKAndName(classPkId, classPkName).forEach(auditingEntry -> deleteByPkAndName(auditingEntry.getClassPkId(), auditingEntry.getClassPkName()));
    }

    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     AuditingEntry entry,
                                     Date current,
                                     User user,
                                     ServiceContext serviceContext) {

        entry.setCustomerId(customerId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setExternalReferenceCode(UUID.randomUUID().toString());

        updateModifierAudit(creatorId, entry, user, serviceContext);
    }

    private void updateModifierAudit(long creatorId,
                                     AuditingEntry entry,
                                     User user,
                                     ServiceContext serviceContext) {

        if (user != null) {
            entry.setUserName(user.getFullName());
            entry.setUserUuid(user.getUserUuid());
        }

        entry.setUserId(serviceContext.getUserId());
        entry.setCreatorId(creatorId);
        EmployeeEntry employeeEntry = _employeeEntryLocalService.fetchEmployeeEntry(creatorId);

        if (Validator.isNotNull(employeeEntry)) {
            entry.setCreatorName(employeeEntry.getName());
        } else {
            entry.setCreatorName("ADMIN");
        }
    }

    @Reference
    private EmployeeEntryLocalService _employeeEntryLocalService;
}