package com.dogoo.common.files.manager.rest.internal.mapper.documentserver.document.permissions;

import com.dogoo.common.files.manager.rest.dto.v2_0.EditorConfig;
import com.dogoo.common.files.manager.rest.dto.v2_0.Permissions;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.service.DGFileSettingPermissionEntryLocalService;
import com.dogoo.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Objects;

@Component(immediate = true, service = PermissionsMapper.class)
public class PermissionsMapper {

    public Permissions mapPermissions(long fileId,
                                      UserTokenModel userTokenModel,
                                      EditorConfig.Mode mode) {
        Permissions to = new Permissions();

        DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
                _dgFileSettingPermissionEntryLocalService.fetchDGFileSettingPermissionEntry(
                        userTokenModel.getCustomerId(),
                        fileId
                );

        if (dgFileSettingPermissionEntry != null) {
            if (Objects.equals(String.valueOf(mode), "view")) {
                to.setPrint(dgFileSettingPermissionEntry.getPermissionViewer());
                to.setDownload(dgFileSettingPermissionEntry.getPermissionViewer());
            }
        }

        return to;
    }

    @Reference
    DGFileSettingPermissionEntryLocalService _dgFileSettingPermissionEntryLocalService;
}
