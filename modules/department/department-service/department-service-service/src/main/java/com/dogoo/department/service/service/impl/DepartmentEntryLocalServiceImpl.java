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

package com.dogoo.department.service.service.impl;

import com.dogoo.department.service.constant.Status;
import com.dogoo.department.service.mapper.model.DepartmentMapperModel;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.base.DepartmentEntryLocalServiceBaseImpl;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.*;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.dogoo.department.service.model.DepartmentEntry",
        service = AopService.class
)
public class DepartmentEntryLocalServiceImpl
        extends DepartmentEntryLocalServiceBaseImpl {


    @Indexable(type = IndexableType.REINDEX)
    public DepartmentEntry addDepartmentEntry(
            long customerId,
            long creatorId,
            DepartmentMapperModel model,
            ServiceContext context
    ) {
        DepartmentEntry entry =
                createDepartmentEntry(counterLocalService.increment(DepartmentEntry.class.getName()));
        Date currentDate = new Date();

        createModifierAudit(
                customerId,
                creatorId,
                entry,
                currentDate,
                userLocalService.fetchUser(context.getUserId()),
                context);
        setDepartmentEntry(entry, model);
        entry.setStatus("approved");
        entry.setStatusDate(currentDate);

        return addDepartmentEntry(entry);
    }


    @Indexable(type = IndexableType.REINDEX)
    public DepartmentEntry updateDepartmentEntry(
            long creatorId,
            long entryId,
            DepartmentMapperModel model,
            ServiceContext context
    ) throws PortalException {
        DepartmentEntry entry = getDepartmentEntry(entryId);
        model.setType(entry.getType());
        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                userLocalService.fetchUser(context.getUserId()),
                context);
        setDepartmentEntry(entry, model);
        return updateDepartmentEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public DepartmentEntry deleteDepartmentEntryById(long departmentId) throws PortalException {
        DepartmentEntry entry =
                getDepartmentEntry(departmentId);

        entry.setStatus(Status.TRASHED.getValue());
        entry.setStatusDate(new Date());

        return updateDepartmentEntry(entry);
    }

    public DepartmentEntry fetchDepartmentEntryByName(long customerId, String name) {
        return departmentEntryPersistence.fetchByC_N(customerId, name);
    }

    public DepartmentEntry fetchDepartmentEntryByTax(long customerId, String tax) {
        return departmentEntryPersistence.fetchByC_T(customerId, tax);
    }

    public DepartmentEntry fetchDepartmentEntryByCode(long customerId, String code) {
        return departmentEntryPersistence.fetchByC_C(customerId, code);
    }

    public List<DepartmentEntry> getDepartmentEntries(long customerId, long parentId) {
        return departmentEntryPersistence.findByC_P(customerId, parentId);
    }

    public List<DepartmentEntry> getDepartmentEntries(long customerId) {
        return departmentEntryPersistence.findByC_(customerId);
    }

    public String getDepartmentNameTree(long departmentId) {
        List<String> to = new ArrayList<>();
        DepartmentEntry entry = fetchDepartmentEntry(departmentId);
        if (Validator.isNull(entry)) return StringPool.BLANK;
        to.add(entry.getName());
        findString(entry.getParentId(), to);
        Collections.reverse(to);
        return StringUtil.merge(to,
                StringBundler.concat(StringPool.SPACE,
                        StringPool.GREATER_THAN,
                        StringPool.GREATER_THAN,
                        StringPool.SPACE));
    }

    private void findString(long parentDepartmentId, List<String> to) {

        if (parentDepartmentId == 0L) return;

        DepartmentEntry entry = fetchDepartmentEntry(parentDepartmentId);
        to.add(entry.getName());
        findString(entry.getParentId(), to);
    }

    private void setDepartmentEntry(DepartmentEntry entry,
                                    DepartmentMapperModel model) {
        entry.setName(model.getName());
        entry.setCode(model.getCode());
        entry.setParentId(model.getParentId());
        entry.setBusinessId(model.getBusinessId());
        entry.setType(model.getType());
        entry.setOrder(model.getOrder());
        entry.setTax(model.getTax());
        entry.setAddress(model.getAddress());
        entry.setHeadOffice(model.getHeadOffice());
        entry.setAlias(model.getAlias());
        entry.setDescription(model.getDescription());
    }


    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     DepartmentEntry entry,
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
                                     DepartmentEntry entry,
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
