package com.dogoo.common.files.manager.rest.internal.service.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.AttachPermission;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.attach.FileDepartmentPermissionMapper;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.attach.FileUserPermissionMapper;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.service.DGFileDepartmentPermissionEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileUserPermissionEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AttachPermissionService.class)
public class AttachPermissionService {

    public void attachPermission(long customerId,
                                 long userId,
                                 long fileId,
                                 AttachPermission attachPermission,
                                 ServiceContext serviceContext) {
        _fileUserPermissionMapper.mapFileUserPermissionFromAttachPermission(attachPermission).forEach(element -> {

            DGFileUserPermissionEntry fileUserPermissionEntry =
                    _fileUserPermissionEntryLocalService.fetchByC_U_F(customerId, element.getUserId(), fileId);
            if (fileUserPermissionEntry != null)
                _fileUserPermissionEntryLocalService.updateFileUserPermission(
                        customerId,
                        element.getUserId(),
                        fileId,
                        element,
                        serviceContext
                );
            else
                _fileUserPermissionEntryLocalService.createFileUserPermission(
                        customerId,
                        userId,
                        fileId,
                        element,
                        serviceContext
                );
        });

        _fileDepartmentPermissionMapper.mapFileUserPermissionFromAttachPermission(attachPermission).forEach(element -> {

            DGFileDepartmentPermissionEntry fileDepartmentPermissionEntry =
                    _fileDepartmentPermissionEntryLocalService.fetchByC_D_F(customerId, element.getId(), fileId);

            if (fileDepartmentPermissionEntry != null)
                _fileDepartmentPermissionEntryLocalService.updateRoleFileDepartmentPermission(
                        customerId,
                        userId,
                        element.getId(),
                        fileId,
                        element.getRole(),
                        serviceContext
                );
            else
                _fileDepartmentPermissionEntryLocalService.createFileDepartmentPermission(
                        customerId,
                        userId,
                        fileId,
                        element,
                        serviceContext
                );
        });
    }


    @Reference
    FileDepartmentPermissionMapper _fileDepartmentPermissionMapper;

    @Reference
    DGFileDepartmentPermissionEntryLocalService _fileDepartmentPermissionEntryLocalService;

    @Reference
    FileUserPermissionMapper _fileUserPermissionMapper;

    @Reference
    DGFileUserPermissionEntryLocalService _fileUserPermissionEntryLocalService;
}
