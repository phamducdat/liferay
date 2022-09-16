package com.dogoo.common.files.manager.rest.internal.mapper.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermission;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.attach.AttachPermissionMapper;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.attach.FileUserPermissionMapper;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = FilePermissionMapper.class)
public class FilePermissionMapper {

    public FilePermission mapFilePermission(List<DGFileUserPermissionEntry> listFileUserPermissionEntry,
                                            List<DGFileDepartmentPermissionEntry> listFileDepartmentEntry,
                                            DGFileGeneralPermissionEntry fileGeneralPermissionEntry,
                                            DGFileSettingPermissionEntry fileSettingPermissionEntry,
                                            String type) {
        FilePermission to = new FilePermission();

        to.setAttachPermission(_attachPermissionMapper.mapToAttachPermission(listFileUserPermissionEntry, listFileDepartmentEntry));
        to.setGeneralPermission(_fileGeneralPermissionMapper.mapToGeneralPermission(fileGeneralPermissionEntry));
        to.setSettingPermission(_fileSettingPermissionMapper.mapToSettingPermission(fileSettingPermissionEntry));
        to.setType(type);

        return to;
    }


    @Reference
    AttachPermissionMapper _attachPermissionMapper;

    @Reference
    FileGeneralPermissionMapper _fileGeneralPermissionMapper;

    @Reference
    FileSettingPermissionMapper _fileSettingPermissionMapper;

    @Reference
    FileUserPermissionMapper _fileUserPermissionMapper;
}
