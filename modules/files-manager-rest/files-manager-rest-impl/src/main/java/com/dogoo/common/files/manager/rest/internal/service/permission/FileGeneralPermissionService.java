package com.dogoo.common.files.manager.rest.internal.service.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.GeneralPermission;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.FileGeneralPermissionMapper;
import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.dogoo.common.files.manager.service.service.DGFileGeneralPermissionEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = FileGeneralPermissionService.class)
public class FileGeneralPermissionService {

    public void updateGeneralPermission(long customerId,
                                        long userId,
                                        long documentManagerFileId,
                                        GeneralPermission from,
                                        ServiceContext serviceContext) {
        DGFileGeneralPermissionEntry entry = _localService.fetchDGFileGeneralPermissionEntry(customerId, documentManagerFileId);

        if (entry == null)
            _localService.createDGFileGeneralPermissionEntry(customerId,
                    userId, documentManagerFileId,
                    _mapper.mapFromGeneralPermissionToFileGeneralPermission(from),
                    serviceContext);
        else
            _localService.updateDGFileGeneralPermissionEntry(customerId,
                    userId, documentManagerFileId,
                    _mapper.mapFromGeneralPermissionToFileGeneralPermission(from),
                    serviceContext);
    }

    @Reference
    DGFileGeneralPermissionEntryLocalService _localService;

    @Reference
    FileGeneralPermissionMapper _mapper;
}
