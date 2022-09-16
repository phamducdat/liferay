package com.dogoo.common.files.manager.rest.internal.validator;

import com.dogoo.common.exception.model.DG_UnAuthorizationException;
import com.dogoo.common.files.manager.rest.dto.v2_0.GeneralPermission;
import com.dogoo.common.files.manager.rest.internal.service.permission.FileGeneralPermissionService;
import com.dogoo.common.files.manager.rest.internal.util.DG_FileUtil;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.service.*;
import com.dogoo.employee.service.model.EmployeeCurrentPositionEntry;
import com.dogoo.employee.service.service.EmployeeCurrentPositionEntryLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Objects;

@Component(
        immediate = true,
        service = FilePermissionValidator.class
)
public class FilePermissionValidator {

    public void validateForPermissionFile(long customerId,
                                          long userId,
                                          long fileId,
                                          long employeeId) throws DG_UnAuthorizationException {

        DGDocumentManagerEntry dgDocumentManagerEntry =
                _dgDocumentManagerEntryLocalService.fetchDgDocumentManagerEntryByFileId(fileId);

        if (dgDocumentManagerEntry == null) {
            return;
        }

        if (dgDocumentManagerEntry.getCreatorId() == userId) return;

        Long documentManagerId = dg_fileUtil.getDocumentManagerIdFromFileId(fileId);


        DGFileGeneralPermissionEntry fileGeneralPermissionEntry =
                _dgFileGeneralPermissionEntryLocalService.fetchDGFileGeneralPermissionEntry(customerId, documentManagerId);


        if (fileGeneralPermissionEntry != null) {
            if (StringUtil.equals(fileGeneralPermissionEntry.getAllowed(),
                    GeneralPermission.Allowed.LIMIT.toString())) {

                EmployeeCurrentPositionEntry employeeCurrentPositionEntry =
                        _employeeCurrentPositionEntryLocalService.fetchEmployeeCurrentPositionEntryByEmployeeId(employeeId);

                if (employeeCurrentPositionEntry != null) {
                    DGFileDepartmentPermissionEntry fileDepartmentPermissionEntry = _fileDepartmentPermissionEntryLocalService.fetchByC_D_F(
                            customerId,
                            employeeCurrentPositionEntry.getDepartmentId(),
                            documentManagerId
                    );

                    if (fileDepartmentPermissionEntry != null) return;
                }


                DGFileUserPermissionEntry fileUserPermissionEntry =
                        _dgFileUserPermissionEntryLocalService.fetchByC_U_F(customerId, userId, documentManagerId);
                if (fileUserPermissionEntry == null || Objects.equals(fileUserPermissionEntry.getStatus(), "trashed"))
                    throw new DG_UnAuthorizationException("Not allow");
            }
        }
    }

    @Reference
    DGFileSettingPermissionEntryLocalService _settingLocalService;

    @Reference
    FileGeneralPermissionService _generalPermissionService;

    @Reference
    DGFileGeneralPermissionEntryLocalService _dgFileGeneralPermissionEntryLocalService;

    @Reference
    DGFileUserPermissionEntryLocalService _dgFileUserPermissionEntryLocalService;


    @Reference
    DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;

    @Reference
    EmployeeCurrentPositionEntryLocalService _employeeCurrentPositionEntryLocalService;

    @Reference
    DGFileDepartmentPermissionEntryLocalService _fileDepartmentPermissionEntryLocalService;


    @Reference
    DG_FileUtil dg_fileUtil;
}
