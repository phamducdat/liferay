package com.dogoo.common.files.manager.rest.internal.mapper.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.SettingPermission;
import com.dogoo.common.files.manager.service.mapper.model.FileSettingPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = FileSettingPermissionMapper.class)
public class FileSettingPermissionMapper {

    public FileSettingPermissionMapperModel mapFromSettingPermissionToFileSettingPermission(
            SettingPermission from
    ) {
        FileSettingPermissionMapperModel to = new FileSettingPermissionMapperModel();

        to.setPermissionViewer(GetterUtil.get(from.getPermissionViewer(), true));
        to.setPermissionEditor(GetterUtil.get(from.getPermissionEditor(), true));

        return to;
    }

    public SettingPermission mapToSettingPermission(DGFileSettingPermissionEntry from) {
        SettingPermission to = new SettingPermission();
        if (from == null) {
            to.setPermissionViewer(true);
            to.setPermissionEditor(true);
            return to;
        }
        to.setPermissionEditor(GetterUtil.get(from.getPermissionEditor(), true));
        to.setPermissionViewer(GetterUtil.get(from.getPermissionViewer(), true));

        return to;
    }
}
