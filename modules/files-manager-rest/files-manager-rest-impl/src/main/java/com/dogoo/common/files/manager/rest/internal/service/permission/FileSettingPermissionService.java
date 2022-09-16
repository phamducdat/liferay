package com.dogoo.common.files.manager.rest.internal.service.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.SettingPermission;
import com.dogoo.common.files.manager.rest.internal.mapper.permission.FileSettingPermissionMapper;
import com.dogoo.common.files.manager.service.exception.NoSuchDGFileSettingPermissionEntryException;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.service.DGFileSettingPermissionEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = FileSettingPermissionService.class)
public class FileSettingPermissionService {

    public void updateSettingPermission(long customerId,
                                        long userId,
                                        long documentManagerFileId,
                                        SettingPermission from,
                                        ServiceContext serviceContext) {
        DGFileSettingPermissionEntry entry = _localService.fetchDGFileSettingPermissionEntry(customerId, documentManagerFileId);

//        if (from.getPermissionEditor() && from.getPermissionViewer() && entry != null)
//            _localService.deleteDGFileSettingPermissionEntry(customerId, documentManagerFileId);
        if (entry == null)
            _localService.createDGFileSettingPermissionEntry(customerId,
                    userId, documentManagerFileId,
                    _mapper.mapFromSettingPermissionToFileSettingPermission(from),
                    serviceContext);
        else
            _localService.updateDGFileSettingPermissionEntry(customerId,
                    userId, documentManagerFileId,
                    _mapper.mapFromSettingPermissionToFileSettingPermission(from),
                    serviceContext);

    }


    @Reference
    DGFileSettingPermissionEntryLocalService _localService;

    @Reference
    FileSettingPermissionMapper _mapper;


}
