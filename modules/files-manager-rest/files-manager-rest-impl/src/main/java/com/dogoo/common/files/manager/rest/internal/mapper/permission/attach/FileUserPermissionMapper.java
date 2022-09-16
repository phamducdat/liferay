package com.dogoo.common.files.manager.rest.internal.mapper.permission.attach;

import com.dogoo.authz.account.service.model.AccountEntry;
import com.dogoo.authz.account.service.service.AccountEntryLocalService;
import com.dogoo.common.files.manager.rest.dto.v2_0.AttachPermission;
import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermissionUser;
import com.dogoo.common.files.manager.rest.dto.v2_0.Users;
import com.dogoo.common.files.manager.rest.dto.v2_0.UsersResponse;
import com.dogoo.common.files.manager.service.mapper.model.FileUserPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = FileUserPermissionMapper.class)
public class FileUserPermissionMapper {

    public List<FileUserPermissionMapperModel> mapFileUserPermissionFromAttachPermission(AttachPermission from) {
        List<FileUserPermissionMapperModel> to = new ArrayList<>();

        Users users = from.getUsers();
        if (users != null) {
            for (Long id : users.getIds()) {
                FileUserPermissionMapperModel model = new FileUserPermissionMapperModel();

                model.setUserId(id);
                model.setRole(String.valueOf(users.getRole()));
                to.add(model);
            }
        }
        return to;
    }

    public FileUserPermissionMapperModel mapToFileUserPermission(FilePermissionUser from) {

        FileUserPermissionMapperModel to = new FileUserPermissionMapperModel();

        to.setRole(from.getRole());

        return to;
    }


    public UsersResponse[] mapToUsersResponse(List<DGFileUserPermissionEntry> listFileUserPermissionEntry) {

        return TransformUtil.transformToArray(listFileUserPermissionEntry, element -> {

            UsersResponse to = new UsersResponse();
            AccountEntry accountEntry = _accountEntryLocalService.fetchAccountEntry(element.getUserAllowedId());


            to.setId(element.getUserAllowedId());
            to.setRole(element.getRole());
            to.setName(Validator.isNotNull(accountEntry) ? accountEntry.getFullName() : "admin");


            return to;
        }, UsersResponse.class);
    }

    @Reference
    AccountEntryLocalService _accountEntryLocalService;
}
