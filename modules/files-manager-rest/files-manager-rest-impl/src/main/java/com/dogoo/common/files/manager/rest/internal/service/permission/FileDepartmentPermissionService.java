package com.dogoo.common.files.manager.rest.internal.service.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermissionDepartment;
import com.dogoo.common.files.manager.service.service.DGFileDepartmentPermissionEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = FileDepartmentPermissionService.class)
public class FileDepartmentPermissionService {

    public void updateFileDepartmentPermission(long customerId,
                                               long userId,
                                               long departmentId,
                                               long documentManagerFileId,
                                               FilePermissionDepartment from,
                                               ServiceContext serviceContext) {
        _localService.updateRoleFileDepartmentPermission(customerId,
                userId,
                departmentId,
                documentManagerFileId,
                from.getRole(),
                serviceContext);
    }

    @Reference
    DGFileDepartmentPermissionEntryLocalService _localService;
}
