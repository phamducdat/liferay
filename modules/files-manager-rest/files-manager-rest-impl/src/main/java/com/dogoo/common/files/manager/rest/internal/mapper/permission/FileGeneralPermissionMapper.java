package com.dogoo.common.files.manager.rest.internal.mapper.permission;

import com.dogoo.common.files.manager.rest.dto.v2_0.GeneralPermission;
import com.dogoo.common.files.manager.service.mapper.model.FileGeneralPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.liferay.portal.kernel.util.StringUtil;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = FileGeneralPermissionMapper.class)
public class FileGeneralPermissionMapper {


    public FileGeneralPermissionMapperModel mapFromGeneralPermissionToFileGeneralPermission(
            GeneralPermission from) {
        FileGeneralPermissionMapperModel to = new FileGeneralPermissionMapperModel();

        to.setAllowed(String.valueOf(from.getAllowed()));
        to.setRole(String.valueOf(from.getRole()));

        return to;
    }

    public GeneralPermission mapToGeneralPermission(DGFileGeneralPermissionEntry from) {

        GeneralPermission to = new GeneralPermission();

        to.setAllowed(GeneralPermission.Allowed.ALL);
        to.setRole(GeneralPermission.Role.VIEWER);

        if (from != null) {
            if (StringUtil.equals(from.getAllowed(), String.valueOf(GeneralPermission.Allowed.LIMIT))) {
                to.setAllowed(GeneralPermission.Allowed.LIMIT);
                to.setRole((GeneralPermission.Role) null);
                return to;
            } else {
                to.setRole(GeneralPermission.Role.create(from.getRole()));
            }
        }

        return to;
    }

}
