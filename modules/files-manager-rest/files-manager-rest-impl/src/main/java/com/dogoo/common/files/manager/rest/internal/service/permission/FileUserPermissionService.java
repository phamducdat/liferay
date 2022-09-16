package com.dogoo.common.files.manager.rest.internal.service.permission;


import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermissionUser;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.attach.FileUserPermissionMapper;
import com.dogoo.common.files.manager.service.service.DGFileUserPermissionEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = FileUserPermissionService.class)
public class FileUserPermissionService {

    public void updateFileUserPermission(long customerId,
                                         long userId, long documentManagerFileId,
                                         FilePermissionUser from,
                                         ServiceContext serviceContext) {
        _localService.updateFileUserPermission(customerId, userId, documentManagerFileId,
                _fileUserPermissionMapper.mapToFileUserPermission(from), serviceContext);
    }


    @Reference
    FileUserPermissionMapper _fileUserPermissionMapper;

    @Reference
    DGFileUserPermissionEntryLocalService _localService;

}
