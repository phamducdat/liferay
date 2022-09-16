package com.dogoo.common.files.manager.rest.internal.mapper.brief;

import com.dogoo.authz.account.service.model.AccountEntry;
import com.dogoo.authz.account.service.service.AccountEntryLocalService;
import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.dogoo.common.files.manager.rest.dto.v2_0.SharedObjectBrief;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = SharedObjectMapper.class
)
public class SharedObjectMapper {

    public SharedObjectBrief mapSharedObjectFromAccountId(long accountId) {
        SharedObjectBrief dto = new SharedObjectBrief();

        AccountEntry entry = _accountEntryLocalService.fetchAccountEntry(accountId);

        if (Validator.isNotNull(entry)) {

            dto.setId(accountId);
            dto.setName(entry.getFullName());
            dto.setType(SharedObjectBrief.Type.ACCOUNT);
        }
        return dto;
    }

    public SharedObjectBrief mapSharedObjectFromDepartmentId(long departmentId) {
        SharedObjectBrief dto = new SharedObjectBrief();

        DepartmentEntry entry = _departmentEntryLocalService.fetchDepartmentEntry(departmentId);

        if (Validator.isNotNull(entry)) {

            dto.setName(entry.getName());
            dto.setId(departmentId);
            dto.setType(SharedObjectBrief.Type.DEPARMENT);
        }

        return dto;
    }

    @Reference
    DepartmentEntryLocalService _departmentEntryLocalService;

    @Reference
    AccountEntryLocalService _accountEntryLocalService;
    @Reference
    CommonFileHelper _fileHelper;
}
