package com.dogoo.common.files.manager.rest.internal.mapper.permission.attach;

import com.dogoo.common.files.manager.rest.dto.v2_0.AttachPermission;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = AttachPermissionMapper.class)
public class AttachPermissionMapper {


    public AttachPermission mapToAttachPermission(List<DGFileUserPermissionEntry> listFileUserPermissionEntry,
                                                  List<DGFileDepartmentPermissionEntry> listFileDepartmentEntry) {
        AttachPermission to = new AttachPermission();

        to.setUsersResponse(_fileUserPermissionMapper.mapToUsersResponse(listFileUserPermissionEntry));
        to.setDepartmentsResponse(_fileDepartmentPermissionMapper.mapToDepartmentsResponse(listFileDepartmentEntry));

        return to;
    }

    @Reference
    FileDepartmentPermissionMapper _fileDepartmentPermissionMapper;

    @Reference
    FileUserPermissionMapper _fileUserPermissionMapper;
}
