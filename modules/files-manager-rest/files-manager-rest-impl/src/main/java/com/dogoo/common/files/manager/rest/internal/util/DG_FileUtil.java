package com.dogoo.common.files.manager.rest.internal.util;


import com.dogoo.authz.account.service.model.AccountEntry;
import com.dogoo.authz.account.service.service.AccountEntryLocalService;
import com.dogoo.common.files.manager.rest.dto.v2_0.*;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileGeneralPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.service.*;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.employee.career.service.retriever.EmployeeCareerEntryRetriever;
import com.dogoo.employee.service.mapper.model.EmployeeCurrentPositionMapperModel;
import com.dogoo.employee.service.model.EmployeeCurrentPositionEntry;
import com.dogoo.employee.service.service.EmployeeCurrentPositionEntryLocalService;
import com.dogoo.resource.action.service.model.ResourceActionEntry;
import com.dogoo.resource.action.service.service.ResourceActionEntryLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Component(immediate = true, service = DG_FileUtil.class)
public class DG_FileUtil {


    public Long getDocumentManagerIdFromFileId(long fileId) {
        DGDocumentManagerEntry dgDocumentManagerEntry =
                _dgDocumentManagerEntryLocalService.fetchDgDocumentManagerEntryByFileId(fileId);

        return Validator.isNotNull(dgDocumentManagerEntry) ? dgDocumentManagerEntry.getDocumentManagerId() : null;
    }

    public boolean checkOwner(long id, long userId) {

        DGDocumentManagerEntry entry = _dgDocumentManagerEntryLocalService.
                fetchDGDocumentManagerEntry(id);


        List<Long> pathArray = convertPathStringToListLong(entry.getPath());

        for (Long path : pathArray) {

            DGDocumentManagerEntry dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.
                    fetchDGDocumentManagerEntry(path);

            switch (dgDocumentManagerEntry.getCategory()) {
                case "company":
                    AccountEntry accountEntry = accountEntryLocalService.
                            fetchAccountEntry(userId);

                    ResourceActionEntry resourceActionEntry =
                            _resourceActionLocalService.fetchResourceActionEntryByE_T_O_S(
                                    entry.getCustomerId(),
                                    accountEntry.getEmployeeId(),
                                    "/workplace",
                                    "/document",
                                    "/company"
                            );

                    if (resourceActionEntry != null) {

                        if (resourceActionEntry.getAction()) {

                            if (dgDocumentManagerEntry.getIsPrivate()) {
                                if (Validator.isNotNull(accountEntry)) {
                                    EmployeeCurrentPositionMapperModel employee = employeeCareerEntryRetriever.
                                            getEmployeeCurrent(dgDocumentManagerEntry.getCustomerId(), accountEntry.getEmployeeId());

                                    return entry.getDepartmentId() == employee.getDepartmentId();
                                }
                            }
                        }
                    }

                    return true;
                case "personal":
                    return dgDocumentManagerEntry.getCreatorId() == userId;
            }
        }

        return true;
    }


    public HashMap<Long, EditorConfig.Mode> getModeFolder(UserTokenModel userTokenModel, long documentManagerFileId) {

        HashMap<Long, EditorConfig.Mode> permission = new HashMap<>();

        DGDocumentManagerEntry dgDocumentManagerEntry =
                _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(documentManagerFileId);
        if (dgDocumentManagerEntry != null) {

            ResourceActionEntry resourceActionEntry =
                    _resourceActionLocalService.fetchResourceActionEntryByE_T_O_S(
                            dgDocumentManagerEntry.getCustomerId(),
                            userTokenModel.getEmployeeId(),
                            "/workplace",
                            "/document",
                            "/company"
                    );

            if (Validator.isNotNull(resourceActionEntry)) {

                if (!resourceActionEntry.getAction() &&
                        dgDocumentManagerEntry.getCategory().equalsIgnoreCase(DGDocumentManager.Category.COMPANY.getValue())) {

                    permission.put(dgDocumentManagerEntry.getDocumentManagerId(), EditorConfig.Mode.VIEW);
                    return permission;
                }
            } else {
                return null;
            }

            if (checkOwner(documentManagerFileId, userTokenModel.getUserId())) {
                permission.put(dgDocumentManagerEntry.getDocumentManagerId(), EditorConfig.Mode.EDIT);
                return permission;
            }

            List<Long> path = convertPathStringToListLong(dgDocumentManagerEntry.getPath());

            Collections.reverse(path);

            for (Long pathId : path) {
                EditorConfig.Mode mode = getModeByDocumentManagerId(userTokenModel, pathId);
                if (mode != null) {
                    permission.put(pathId, mode);
                    return permission;
                }
            }
        }

        return null;
    }

    public EditorConfig.Mode getModeFile(UserTokenModel userTokenModel, long fileId) {

        DGDocumentManagerEntry dgDocumentManagerEntry =
                _dgDocumentManagerEntryLocalService.fetchDgDocumentManagerEntryByFileId(fileId);
        if (dgDocumentManagerEntry != null) {

            ResourceActionEntry resourceActionEntry =
                    _resourceActionLocalService.fetchResourceActionEntryByE_T_O_S(
                            dgDocumentManagerEntry.getCustomerId(),
                            userTokenModel.getEmployeeId(),
                            "/workplace",
                            "/document",
                            "/company"
                    );

            if (Validator.isNotNull(resourceActionEntry)) {

                if (!resourceActionEntry.getAction() &&
                        dgDocumentManagerEntry.getCategory().equalsIgnoreCase(DGDocumentManager.Category.COMPANY.getValue())) {

                    return EditorConfig.Mode.VIEW;
                }
            } else {
                return null;
            }

            if (checkOwner(dgDocumentManagerEntry.getDocumentManagerId(), userTokenModel.getUserId()))
                return EditorConfig.Mode.EDIT;
        }


        Long documentManagerId = Validator.isNotNull(dgDocumentManagerEntry) ? dgDocumentManagerEntry.getDocumentManagerId() : null;
        if (documentManagerId == null) return null;


        List<Long> path = convertPathStringToListLong(dgDocumentManagerEntry.getPath());
        Collections.reverse(path);

        for (Long pathId : path) {
            EditorConfig.Mode mode = getModeByDocumentManagerId(userTokenModel, pathId);
            if (mode != null) return mode;
        }

        return null;

    }

    private EditorConfig.Mode getModeByDocumentManagerId(UserTokenModel userTokenModel, Long documentManagerId) {
        EditorConfig.Mode userMode = getModeByUserId(userTokenModel.getCustomerId(),
                userTokenModel.getUserId(),
                documentManagerId);
        if (userMode != null) return userMode;


        EmployeeCurrentPositionEntry employeeCurrentPositionEntry =
                _employeeCurrentPositionEntryLocalService.fetchEmployeeCurrentPositionEntryByEmployeeId(userTokenModel.getEmployeeId());

        if (employeeCurrentPositionEntry != null) {
            EditorConfig.Mode departmentMode = getModeByDepartmentId(userTokenModel.getCustomerId(),
                    employeeCurrentPositionEntry.getDepartmentId(), documentManagerId);
            if (departmentMode != null) return departmentMode;
        }

        DGFileGeneralPermissionEntry fileGeneralPermissionEntry =
                _dgFileGeneralPermissionEntryLocalService.fetchDGFileGeneralPermissionEntry(
                        userTokenModel.getCustomerId(),
                        documentManagerId);
        if (fileGeneralPermissionEntry != null) {
            if (StringUtil.equals(fileGeneralPermissionEntry.getAllowed(), String.valueOf(GeneralPermission.Allowed.ALL))) {
                return convertToEditorConfigMode(GeneralPermission.Role.create(fileGeneralPermissionEntry.getRole()));
            }
        } else {
            return EditorConfig.Mode.VIEW;
        }

        return null;
    }

    private List<Long> convertPathStringToListLong(String path) {
        return TransformUtil.transformToList(
                StringUtil.split(path, "/"), Long::parseLong);
    }


    public EditorConfig.Mode getModeByDepartmentId(long customerId,
                                                   long departmentId,
                                                   long documentManagerId) {
        DGFileDepartmentPermissionEntry fileDepartmentPermissionEntry =
                _dgFileDepartmentPermissionEntryLocalService.fetchByC_D_F(customerId, departmentId, documentManagerId);

        if (fileDepartmentPermissionEntry != null)
            return convertToEditorConfigMode(Departments.Role.create(fileDepartmentPermissionEntry.getRole()));

        return null;
    }

    public EditorConfig.Mode getModeByUserId(long customerId,
                                             long userId,
                                             long documentManagerId) {

        DGFileUserPermissionEntry fileUserPermissionEntry =
                _dgFileUserPermissionEntryLocalService.fetchByC_U_F(customerId,
                        userId,
                        documentManagerId);
        if (fileUserPermissionEntry != null && Objects.equals(fileUserPermissionEntry.getStatus(), "approved"))
            return convertToEditorConfigMode(Users.Role.create(fileUserPermissionEntry.getRole()));

        return null;
    }


    private EditorConfig.Mode convertToEditorConfigMode(GeneralPermission.Role role) {
        if (GeneralPermission.Role.EDITOR.equals(role))
            return EditorConfig.Mode.EDIT;
        if (GeneralPermission.Role.VIEWER.equals(role))
            return EditorConfig.Mode.VIEW;
        return null;
    }

    private EditorConfig.Mode convertToEditorConfigMode(Users.Role role) {
        if (role == null) return null;
        if (Users.Role.EDITOR.equals(role))
            return EditorConfig.Mode.EDIT;
        if (Users.Role.VIEWER.equals(role))
            return EditorConfig.Mode.VIEW;
        return null;
    }

    private EditorConfig.Mode convertToEditorConfigMode(Departments.Role role) {
        if (role == null) return null;
        if (Departments.Role.EDITOR.equals(role))
            return EditorConfig.Mode.EDIT;
        if (Departments.Role.VIEWER.equals(role))
            return EditorConfig.Mode.VIEW;
        return null;
    }


    @Reference
    DGFileUserPermissionEntryLocalService _dgFileUserPermissionEntryLocalService;

    @Reference
    DGFileDepartmentPermissionEntryLocalService _dgFileDepartmentPermissionEntryLocalService;

    @Reference
    DGFileGeneralPermissionEntryLocalService _dgFileGeneralPermissionEntryLocalService;

    @Reference
    DGFileSettingPermissionEntryLocalService _dgFileSettingPermissionEntryLocalService;

    @Reference
    EmployeeCurrentPositionEntryLocalService _employeeCurrentPositionEntryLocalService;

    @Reference
    DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;

    @Reference
    AccountEntryLocalService accountEntryLocalService;

    @Reference
    EmployeeCareerEntryRetriever employeeCareerEntryRetriever;


    @Reference
    private ResourceActionEntryLocalService _resourceActionLocalService;


}
