package com.dogoo.common.files.manager.rest.internal.service.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermission;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.FilePermissionMapper;
import com.dogoo.common.files.manager.service.exception.NoSuchDGFileDepartmentPermissionEntryException;
import com.dogoo.common.files.manager.service.exception.NoSuchDGFileUserPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.service.*;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = FilePermissionService.class)
public class FilePermissionService {

    public FilePermission getFilePermission(long customerId,
                                            long documentManagerFileId) {


        try {

            List<DGFileUserPermissionEntry> listFileUserPermissionEntry = _fileUserPermissionEntryLocalService.getAllByFileId(customerId, documentManagerFileId);
            List<DGFileDepartmentPermissionEntry> listFileDepartmentPermissionEntry = _fileDepartmentPermissionEntryLocalService.getAllByFileId(customerId, documentManagerFileId);
            DGFileGeneralPermissionEntry fileGeneralPermissionEntry = _fileGeneralPermissionEntryLocalService.fetchDGFileGeneralPermissionEntry(customerId, documentManagerFileId);
            DGFileSettingPermissionEntry fileSettingPermissionEntry = _fileSettingPermissionEntryLocalService.fetchDGFileSettingPermissionEntry(customerId, documentManagerFileId);


            return _filePermissionMapper.mapFilePermission(
                    listFileUserPermissionEntry,
                    listFileDepartmentPermissionEntry,
                    fileGeneralPermissionEntry,
                    fileSettingPermissionEntry,
                    documentManagerFileId == 0L ? "folder" : "file"
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteFilePermission(long customerId, long documentManagerFileId) {
        try {


            _fileUserPermissionEntryLocalService.deleteAllFileUserPermissionByFileId(customerId, documentManagerFileId);
            _fileDepartmentPermissionEntryLocalService.deleteAllFileDepartmentPermissionByFileId(customerId, documentManagerFileId);
            _fileGeneralPermissionEntryLocalService.deleteDGFileGeneralPermissionEntry(customerId, documentManagerFileId);
            _fileSettingPermissionEntryLocalService.deleteDGFileSettingPermissionEntry(customerId, documentManagerFileId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteFileUserPermission(long customerId,
                                         long userId,
                                         long documentManagerFileId,
                                         ServiceContext serviceContext)
            throws NoSuchDGFileUserPermissionEntryException {
        _fileUserPermissionEntryLocalService.deleteFileUserPermission(customerId,
                userId,
                documentManagerFileId,
                serviceContext);
    }

    public void deleteFileDepartmentPermission(long customerId, long departmentId, long documentManagerFileId)
            throws NoSuchDGFileDepartmentPermissionEntryException {
        _fileDepartmentPermissionEntryLocalService.deleteFileDepartmentPermission(customerId, departmentId, documentManagerFileId);
    }


    @Reference
    DGFileUserPermissionEntryLocalService _fileUserPermissionEntryLocalService;

    @Reference
    DGFileDepartmentPermissionEntryLocalService _fileDepartmentPermissionEntryLocalService;

    @Reference
    DGFileGeneralPermissionEntryLocalService _fileGeneralPermissionEntryLocalService;

    @Reference
    DGFileSettingPermissionEntryLocalService _fileSettingPermissionEntryLocalService;

    @Reference
    FilePermissionMapper _filePermissionMapper;

    @Reference
    DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;
}
