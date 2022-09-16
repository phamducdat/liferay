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

import com.dogoo.common.auditing.service.interf.AuditingServiceUtil;
import com.dogoo.common.files.manager.service.mapper.model.DocumentManagerMapperModel;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.service.base.DGDocumentManagerEntryLocalServiceBaseImpl;
import com.dogoo.common.files.manager.service.service.log.AuditingUpdateFileService;
import com.dogoo.employee.career.service.retriever.EmployeeCareerEntryRetriever;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.GetterUtil;
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
        property = "model.class.name=com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry",
        service = AopService.class
)
public class DGDocumentManagerEntryLocalServiceImpl
        extends DGDocumentManagerEntryLocalServiceBaseImpl {

    private static final String FOLDER = "folder";
    private static final String FILE = "file";

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGDocumentManagerEntry addDGDocumentManager(
            long fileId,
            long parentId,
            String pkCode,
            DGDocumentManagerEntry dgDocumentManagerEntry,
            ServiceContext serviceContext
            ) {

        Date current = new Date();

        createModifierAudit(
                dgDocumentManagerEntry.getCustomerId(),
                dgDocumentManagerEntry.getCreatorId(),
                dgDocumentManagerEntry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        dgDocumentManagerEntry.setUuid(UUID.randomUUID().toString());
        dgDocumentManagerEntry.setExternalReferenceCode(UUID.randomUUID().toString());
        dgDocumentManagerEntry.setDocumentManagerId(counterLocalService.increment(DGDocumentManagerEntry.class.getName()));
        dgDocumentManagerEntry.setFileId(fileId);
        dgDocumentManagerEntry.setParentId(parentId);
        dgDocumentManagerEntry.setPkCode(pkCode);

        String path = "";

        if (parentId != 0) {

            DGDocumentManagerEntry entry = fetchDGDocumentManagerEntry(parentId);

            path = entry.getPath();
        }

        dgDocumentManagerEntry.setPath(path + dgDocumentManagerEntry.getDocumentManagerId() + StringPool.FORWARD_SLASH);


        return addDGDocumentManagerEntry(dgDocumentManagerEntry);
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGDocumentManagerEntry addDGDocumentManager(long customerId,
                                                       long userId,
                                                       Long departmentId,
                                                       DocumentManagerMapperModel model,
                                                       ServiceContext serviceContext) throws SearchException {

        DGDocumentManagerEntry entry = createDGDocumentManagerEntry(
                counterLocalService.increment(DGDocumentManagerEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                customerId,
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        addDGDocumentManagerData(entry, model);
        entry.setDepartmentId(departmentId);
        if (model.getType().equals("folder")) {
            entry.setFileSize(String.valueOf(GetterUtil.DEFAULT_LONG));
        }

        DGDocumentManagerEntry managerEntry = addDGDocumentManagerEntry(entry);

        if (Validator.isNotNull(managerEntry)) {
            auditingUpdateFileService.addAuditingFile(entry.getAppId(), entry, serviceContext, "Thêm ");
        }

        return managerEntry;
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGDocumentManagerEntry updateDGDocumentManager(long userId,
                                                          long documentId,
                                                          DocumentManagerMapperModel model,
                                                          ServiceContext serviceContext) throws SearchException {

        DGDocumentManagerEntry entry = fetchDGDocumentManagerEntry(documentId);

        Date current = new Date();

        updateModifierAudit(
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        addDGDocumentManagerData(entry, model);

        if (entry.getType().equals("file")) {
            DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(entry.getFileId());

            dlFileEntry.setTitle(model.getName());
            _dlFileEntryLocalService.updateDLFileEntry(dlFileEntry);
        }

        DGDocumentManagerEntry managerEntry = updateDGDocumentManagerEntry(entry);

        if (Validator.isNotNull(managerEntry)) {
            auditingUpdateFileService.addAuditingFile(entry.getAppId(), entry, serviceContext, "Cập nhập ");
        }

        return managerEntry;
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public DGDocumentManagerEntry updateDGDocumentManagerPublic(long userId,
                                                                long documentId,
                                                                Boolean isPrivate,
                                                                ServiceContext serviceContext) throws SearchException {

        DGDocumentManagerEntry entry = fetchDGDocumentManagerEntry(documentId);

        Date current = new Date();

        updateModifierAudit(
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        entry.setIsPrivate(isPrivate);

        DGDocumentManagerEntry managerEntry = updateDGDocumentManagerEntry(entry);

        if (Validator.isNotNull(managerEntry)) {
            auditingUpdateFileService.addAuditingFile(entry.getAppId(), entry, serviceContext, "Cập nhập ");
        }

        return managerEntry;
    }

    public void deleteDgDocumentManagerEntryById(DGDocumentManagerEntry dgDocumentManagerEntry) throws PortalException {


        switch (dgDocumentManagerEntry.getType()) {
            case FOLDER:
                deleteDocument(dgDocumentManagerEntry);
                break;
            case FILE:
                deleteFile(dgDocumentManagerEntry);
                break;
        }
        ServiceContext serviceContext = new ServiceContext();

        serviceContext.setCompanyId(dgDocumentManagerEntry.getCompanyId());
        serviceContext.setUserId(dgDocumentManagerEntry.getUserId());
        serviceContext.setScopeGroupId(dgDocumentManagerEntry.getGroupId());

        if (Validator.isNotNull(dgDocumentManagerEntry)) {
            auditingUpdateFileService.addAuditingFile(dgDocumentManagerEntry.getAppId(), dgDocumentManagerEntry, serviceContext, "Xóa ");
        }
    }

    private void deleteFile(DGDocumentManagerEntry entry) throws PortalException {

        _dlFileEntryLocalService.deleteDLFileEntry(entry.getFileId());
        dgDocumentManagerEntryLocalService.deleteDGDocumentManagerEntry(entry);
    }

    private void deleteDocument(DGDocumentManagerEntry entry) {

        List<DGDocumentManagerEntry> dgDocumentManagerEntries = fetchDgDocumentManagerEntryListByParentId(entry.getDocumentManagerId());

        dgDocumentManagerEntryLocalService.deleteDGDocumentManagerEntry(entry);

        if (dgDocumentManagerEntries.isEmpty()) return;

        dgDocumentManagerEntries.forEach(dgDocumentManagerEntry -> {

            try {
                deleteDgDocumentManagerEntryById(dgDocumentManagerEntry);
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void deleteDgDocumentManagerEntriesByPkCode(String pkCode) {

        List<DGDocumentManagerEntry> dgDocumentManagerEntries = fetchDgDocumentManagerEntryListByPkCode(pkCode);

        dgDocumentManagerEntries.forEach(entry -> {
            switch (entry.getType()) {
                case FOLDER:
                    dgDocumentManagerEntryLocalService.deleteDGDocumentManagerEntry(entry);
                    break;
                case FILE:
                    try {
                        deleteFile(entry);
                    } catch (PortalException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        });
    }

    public DGDocumentManagerEntry fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
            String name,
            long parentId,
            String fileExtension,
            String pkCode
    ) {

        return dgDocumentManagerEntryPersistence.fetchByN_PI_FE_PC(name, parentId, fileExtension, pkCode);
    }

    public List<DGDocumentManagerEntry> fetchDgDocumentManagerEntryListByPkCode(String pkCode) {

        return dgDocumentManagerEntryPersistence.findByPC_(pkCode);
    }

    public List<DGDocumentManagerEntry> fetchDgDocumentManagerEntryListByParentId(long parentId) {

        return dgDocumentManagerEntryPersistence.findByPI_(parentId);

    }

    public DGDocumentManagerEntry fetchDgDocumentManagerEntryByFileId(long fileId) {

        return dgDocumentManagerEntryPersistence.fetchByFI_(fileId);
    }

    public List<DGDocumentManagerEntry> fetchDgDocumentManagerEntryByPkCodeAndParentId(String pkCode, long parentId) {

        return dgDocumentManagerEntryPersistence.findByPC_PI(pkCode, parentId);
    }

    public DGDocumentManagerEntry fetchDgDocumentManagerEntryByNameAndTypeAndPkCodeAndParentIdAndCategoryAndCreatorId(
            String name,
            String type,
            String pkCode,
            long parentId,
            String category,
            long creatorId
    ) {

        return dgDocumentManagerEntryPersistence.fetchByN_T_PC_PI_C_CI(
                name,
                type,
                pkCode,
                parentId,
                category,
                creatorId
        );
    }

    private void addDGDocumentManagerData(DGDocumentManagerEntry entry,
                                          DocumentManagerMapperModel model) {

        entry.setPkCode(model.getPkCode());
        entry.setParentId(model.getParentId());
        entry.setName(model.getName());
        entry.setType(model.getType());
        entry.setFileId(model.getFileId());
        if (model.getType().equals("file")) {
            entry.setFileSize(model.getFileSize());
        }
        entry.setIsPrivate(GetterUtil.getBoolean(model.getPrivate()));
        entry.setFileExtension(model.getFileExtension());
        entry.setMineType(model.getMineType());
        entry.setCategory(model.getCategory());
        entry.setModuleId(model.getModuleId());
        entry.setAppId(model.getAppId());

        String path = "";

        if (model.getParentId() != 0) {

            DGDocumentManagerEntry dgDocumentManagerEntry = fetchDGDocumentManagerEntry(model.getParentId());

            path = dgDocumentManagerEntry.getPath();
        }

        entry.setPath(path + entry.getDocumentManagerId() + StringPool.FORWARD_SLASH);
    }

    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     DGDocumentManagerEntry entry,
                                     Date current,
                                     User user,
                                     ServiceContext serviceContext) {

        entry.setCustomerId(customerId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setExternalReferenceCode(UUID.randomUUID().toString());
        entry.setCreatorId(creatorId);

        updateModifierAudit(creatorId, entry, current, user, serviceContext);
    }

    private void updateModifierAudit(long creatorId,
                                     DGDocumentManagerEntry entry,
                                     Date current,
                                     User user,
                                     ServiceContext serviceContext) {

        if (user != null) {
            entry.setUserName(user.getFullName());
            entry.setUserUuid(user.getUserUuid());
        }

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setUserId(serviceContext.getUserId());
//        entry.setCreatorId(creatorId);
    }

    @Reference
    DLFileEntryLocalService _dlFileEntryLocalService;
    @Reference
    EmployeeCareerEntryRetriever _employeeCareerEntryRetriever;

    @Reference
    private AuditingUpdateFileService auditingUpdateFileService;

    @Reference
    DLFolderService dlFolderService;
}