package com.dogoo.common.files.manager.rest.internal.mapper;

import com.dogoo.authz.account.service.model.AccountEntry;
import com.dogoo.authz.account.service.service.AccountEntryLocalService;
import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.dogoo.common.files.manager.rest.dto.v2_0.*;
import com.dogoo.common.files.manager.rest.internal.mapper.brief.SharedObjectMapper;
import com.dogoo.common.files.manager.rest.internal.util.DG_FileUtil;
import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.mapper.model.DocumentManagerMapperModel;
import com.dogoo.common.files.manager.service.model.*;
import com.dogoo.common.files.manager.service.retriver.DGDocumentManagerRetrieve;
import com.dogoo.common.files.manager.service.service.DGDocumentManagerEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileDepartmentPermissionEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileSettingPermissionEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileUserPermissionEntryLocalService;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.core.project.service.model.PhaseEntry;
import com.dogoo.core.project.service.model.ProjectEntry;
import com.dogoo.core.project.service.service.PhaseEntryLocalService;
import com.dogoo.core.project.service.service.ProjectEntryLocalService;
import com.dogoo.core.task.service.model.TaskEntry;
import com.dogoo.core.task.service.service.TaskEntryLocalService;
import com.dogoo.employee.career.service.retriever.EmployeeCareerEntryRetriever;
import com.dogoo.employee.service.mapper.model.EmployeeCurrentPositionMapperModel;
import com.dogoo.resource.action.service.model.ResourceActionEntry;
import com.dogoo.resource.action.service.service.ResourceActionEntryLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component(immediate = true, service = DGDocumentManagerMapper.class)
public class DGDocumentManagerMapper {

    public DGDocumentManager mapFromDGDocumentManagerToDGDocumentManagerEntryProject(
            DGDocumentManagerEntry from,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel) throws PortalException {

        DGDocumentManager to = mapFromDGDocumentManagerToDGDocumentManagerEntry(
                from,
                themeDisplay,
                userTokenModel
        );

        Metadata metadata = new Metadata();

        metadata.setAppId(from.getAppId());
        metadata.setModuleId(from.getModuleId());

        to.setMetadata(metadata);

        Task task = new Task();

        switch (from.getAppId()) {

            case "PROJECT":
                ProjectEntry projectEntry = projectEntryLocalService.
                        fetchProjectEntryByExternalReferenceCode(CompanyThreadLocal.getCompanyId(), from.getPkCode());
                task.setId(projectEntry.getProjectId());
                task.setExternalReferenceCode(from.getExternalReferenceCode());
                task.setName(projectEntry.getProjectName());
                break;
            case "NORMAL":
                TaskEntry taskEntry = taskEntryLocalService.
                        fetchTaskEntryByExternalReferenceCode(CompanyThreadLocal.getCompanyId(), from.getPkCode());
                task.setId(taskEntry.getTaskId());
                task.setExternalReferenceCode(from.getExternalReferenceCode());
                task.setName(taskEntry.getTaskName());
                break;
            case "PHASE":
                PhaseEntry phaseEntry = phaseEntryLocalService.
                        fetchPhaseEntryByExternalReferenceCode(CompanyThreadLocal.getCompanyId(), from.getPkCode());
                task.setId(phaseEntry.getPhaseId());
                task.setExternalReferenceCode(from.getExternalReferenceCode());
                task.setName(phaseEntry.getPhaseName());
                break;
        }

        to.setTask(task);

        return to;
    }

    public DGDocumentManager mapFromDGDocumentManagerToDGDocumentManagerEntry(String app) throws PortalException {
        DGDocumentManager to = new DGDocumentManager();

        to.setName(app);
        to.setType(DGDocumentManager.Type.FOLDER);
        to.setParentId(GetterUtil.DEFAULT_LONG);
        to.setCategory(DGDocumentManager.Category.ATTACHED);

        return to;
    }

    public DGDocumentManager mapFromDGFileManagerToDGDocumentManagerEntry(
            DGFileManagerEntry from,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel) throws PortalException {

        DGDocumentManager to = new DGDocumentManager();

        to.setId(from.getFileId());
        to.setPkCode(from.getParentCode());
        to.setName(from.getFileName());
        to.setType(DGDocumentManager.Type.FILE);
        to.setParentId(0L);
        to.setFileId(from.getFileId());
        to.setCategory(DGDocumentManager.Category.ATTACHED);
        to.setModifiedDate(from.getModifiedDate());
//        to.setSharedObjectBriefs(mapSharedObjectBriefsFromFileId(from.getCustomerId(), from.getFileId(), themeDisplay));
        EditorConfig.Mode permission = dg_fileUtil.getModeFile(userTokenModel, from.getFileId());
        to.setPermission(Validator.isNull(permission) ? "" : permission.getValue());
//        to.setRole(getSettingPermission(userTokenModel, from.getCreatorId(), from.getFileId()));

        to.setDownloadPath(_fileHelper.getDownloadUrl(from.getFileId(), themeDisplay));
        DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(from.getFileId());

        to.setModifiedDate(dlFileEntry.getModifiedDate());
        to.setFileSize(String.valueOf(dlFileEntry.getSize()));
        to.setExtension(dlFileEntry.getExtension());
        to.setMineType(dlFileEntry.getMimeType());

        AccountEntry accountEntry = _accountEntryLocalService.fetchAccountEntry(from.getCreatorId());

        to.setCreatorId(from.getCreatorId());
        to.setCreatorName(Validator.isNotNull(accountEntry) ? accountEntry.getFullName() : "admin");

        return to;
    }

    private Path[] getBreadCrumb(DGDocumentManagerEntry entry, long userId) {

        String[] pathArray = entry.getPath().split("/");

        boolean isGet = false;

        Path init = new Path();

        init.setId(0L);

        List<Path> breadCrumbList = new ArrayList<>();

        breadCrumbList.add(init);

        if (entry.getCategory().equalsIgnoreCase(DGDocumentManager.Category.ATTACHED.getValue())) {
            Path path = new Path();

            path.setId(0L);
            path.setName(entry.getAppId());

            breadCrumbList.add(path);
        }

        if (dg_fileUtil.checkOwner(entry.getDocumentManagerId(), userId)) {
            for (String path : pathArray) {

                long parentId = GetterUtil.getLong(path);

                Path breadCrumb = new Path();

                breadCrumb.setId(parentId);

                DGDocumentManagerEntry dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(parentId);

                if (Validator.isNotNull(dgDocumentManagerEntry)) {
                    breadCrumb.setName(dgDocumentManagerEntry.getName());
                }

                breadCrumbList.add(breadCrumb);
            }
        } else {
            for (String path : pathArray) {

                long parentId = GetterUtil.getLong(path);

                if (!isGet) {
                    DGFileUserPermissionEntry dgFileUserPermissionEntry = _dgFileUserPermissionEntryLocalService.
                            fetchByC_U_F(entry.getCustomerId(), userId, parentId);

                    if (Validator.isNotNull(dgFileUserPermissionEntry) &&
                            dgFileUserPermissionEntry.getStatus().equalsIgnoreCase("approved")) {
                        isGet = true;
                    }

                    AccountEntry accountEntry = _accountEntryLocalService.fetchAccountEntry(userId);

                    if (Validator.isNotNull(accountEntry)) {

                        EmployeeCurrentPositionMapperModel employee = _employeeCareerEntryRetriever.
                                getEmployeeCurrent(entry.getCustomerId(), accountEntry.getEmployeeId());

                        DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry = _dgFileDepartmentPermissionEntryLocalService.
                                fetchByC_D_F(entry.getCustomerId(), employee.getDepartmentId(), parentId);

                        if (Validator.isNotNull(dgFileDepartmentPermissionEntry)) {
                            isGet = true;
                        }
                    }
                }

                if (isGet) {
                    Path breadCrumb = new Path();

                    breadCrumb.setId(parentId);

                    DGDocumentManagerEntry dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(parentId);

                    if (Validator.isNotNull(dgDocumentManagerEntry)) {
                        breadCrumb.setName(dgDocumentManagerEntry.getName());
                    }

                    breadCrumbList.add(breadCrumb);
                }
            }
        }

        return breadCrumbList.toArray(new Path[]{});
    }

    public DGDocumentManager getDGDocumentManager(long customerId, long userId, String category, String appId) {

        Path breadCrumb = new Path();
        if (category.equalsIgnoreCase(DGDocumentManager.Category.ATTACHED.getValue())) {

            breadCrumb.setId(-1L);

            DGDocumentManager dto = new DGDocumentManager();

            dto.setPermission(EditorConfig.Mode.VIEW.getValue());

            if (Validator.isNotNull(appId)) {
                Path path = new Path();

                path.setName(appId);
                path.setId(0L);
                dto.setPaths(new Path[]{breadCrumb, path});
            } else {
                dto.setPaths(new Path[]{breadCrumb});
            }

            return dto;
        } else {

            breadCrumb.setId(0L);

            DGDocumentManager dto = new DGDocumentManager();

            if (category.equalsIgnoreCase(DGDocumentManager.Category.PERSONAL.getValue())) {
                dto.setPermission(EditorConfig.Mode.EDIT.getValue());
            } else {
                AccountEntry accountEntry = accountEntryLocalService.
                        fetchAccountEntry(userId);

                ResourceActionEntry resourceActionEntry =
                        _resourceActionLocalService.fetchResourceActionEntryByE_T_O_S(
                                customerId,
                                accountEntry.getEmployeeId(),
                                "/workplace",
                                "/document",
                                "/company"
                        );

                if (resourceActionEntry != null) {
                    dto.setPermission(resourceActionEntry.getAction() ? EditorConfig.Mode.EDIT.getValue() : EditorConfig.Mode.VIEW.getValue());
                }
            }

            dto.setPaths(new Path[]{breadCrumb});

            return dto;
        }
    }

    public DGDocumentManager mapFromDGDocumentManagerToDGDocumentManagerEntry(
            DGDocumentManagerEntry from,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel
    ) throws PortalException {

        DGDocumentManager to = new DGDocumentManager();

        to.setId(from.getDocumentManagerId());
        to.setPkCode(from.getPkCode());
        to.setName(from.getName());
        to.setType(DGDocumentManager.Type.create(from.getType()));
        to.setParentId(from.getParentId());
        to.setFileId(from.getFileId());
        to.setCategory(DGDocumentManager.Category.create(from.getCategory()));
        to.setModifiedDate(from.getModifiedDate());
        to.setIsPrivate(from.getIsPrivate());

        if (from.getType().equals(DGDocumentManager.Type.FILE.getValue())) {
            to.setDownloadPath(_fileHelper.getDownloadUrl(from.getFileId(), themeDisplay));
            DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(from.getFileId());

            EditorConfig.Mode permission = dg_fileUtil.getModeFile(userTokenModel, from.getFileId());
            to.setPermission(Validator.isNull(permission) ? "" : permission.getValue());

            to.setFileSize(String.valueOf(from.getFileSize()));
            to.setModifiedDate(dlFileEntry.getModifiedDate());
            to.setExtension(dlFileEntry.getExtension());
            to.setMineType(dlFileEntry.getMimeType());
        } else {
            HashMap<Long, EditorConfig.Mode> permission = dg_fileUtil.getModeFolder(userTokenModel, from.getDocumentManagerId());

            if (Validator.isNotNull(permission)) {

                Long parentId = permission.keySet().iterator().next();
                to.setPermission(permission.get(parentId).getValue());
                to.setFileSize(String.valueOf(from.getFileSize()));
                to.setPaths(getBreadCrumb(from, userTokenModel.getUserId()));
            }
//
//            mapFolderInfo(to, from.getCustomerId(), from.getDocumentManagerId());
        }
        to.setRole(getSettingPermission(userTokenModel, from.getCreatorId(), from.getDocumentManagerId()));
        to.setSharedObjectBriefs(mapSharedObjectBriefsFromFileId(from.getCustomerId(), from.getDocumentManagerId()));

        AccountEntry accountEntry = _accountEntryLocalService.fetchAccountEntry(from.getCreatorId());

        to.setCreatorId(from.getCreatorId());
        to.setCreatorName(Validator.isNotNull(accountEntry) ? accountEntry.getFullName() : "admin");

        return to;
    }

    private SharedObjectBrief[] mapSharedObjectBriefsFromFileId(long customerId, long documentId) {

        List<DGFileUserPermissionEntry> dgFileUserPermissionEntryList = _dgFileUserPermissionEntryLocalService.
                getAllByFileId(customerId, documentId);

        SharedObjectBrief[] accounts = dgFileUserPermissionEntryList.
                stream().
                map(dgFileUserPermissionEntry ->
                        _sharedObjectMapper.
                                mapSharedObjectFromAccountId(dgFileUserPermissionEntry.getUserAllowedId())).
                collect(Collectors.toList()).
                toArray(new SharedObjectBrief[]{});

        List<DGFileDepartmentPermissionEntry> dgFileDepartmentPermissionEntries = _dgFileDepartmentPermissionEntryLocalService.
                fetchByC_F(customerId, documentId);

        SharedObjectBrief[] departments = dgFileDepartmentPermissionEntries.
                stream().
                map(dgFileDepartmentPermissionEntry ->
                        _sharedObjectMapper.
                                mapSharedObjectFromDepartmentId(dgFileDepartmentPermissionEntry.getDepartmentId())).
                collect(Collectors.toList()).
                toArray(new SharedObjectBrief[]{});

        return ArrayUtil.append(accounts, departments);
    }

    private void mapFolderInfo(DGDocumentManager dto, long customerId, long documentId) {

        Document[] files = _dgDocumentManagerRetrieve.getAllFilesInFolder(customerId, documentId);

        AtomicLong total = new AtomicLong(0);
        AtomicLong size = new AtomicLong(0);

        AtomicLong mediaTotal = new AtomicLong(0);
        AtomicLong mediaSize = new AtomicLong(0);

        AtomicLong imageTotal = new AtomicLong(0);
        AtomicLong imageSize = new AtomicLong(0);

        AtomicLong textTotal = new AtomicLong(0);
        AtomicLong textSize = new AtomicLong(0);

        AtomicLong diffTotal = new AtomicLong(0);
        AtomicLong diffSize = new AtomicLong(0);

        Arrays.stream(files).forEach(file -> {

            DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(GetterUtil.getLong(file.get(SearchField.FILE_ID)));

            String type = dlFileEntry.getMimeType().split("/")[0];

            switch (type) {
                case "video":
                case "audio":
                    mediaTotal.set(mediaTotal.get() + 1);
                    mediaSize.set(mediaSize.get() + dlFileEntry.getSize());
                    break;
                case "image":
                    imageTotal.set(imageTotal.get() + 1);
                    imageSize.set(imageSize.get() + dlFileEntry.getSize());
                    break;
                default:
                    String extension = dlFileEntry.getExtension();

                    if (extension.equalsIgnoreCase("docx") ||
                            extension.equalsIgnoreCase("docxf") ||
                            extension.equalsIgnoreCase("doc") ||
                            extension.equalsIgnoreCase("odt") ||
                            extension.equalsIgnoreCase("txt")
                    ) {

                        textTotal.set(textTotal.get() + 1);
                        textSize.set(textSize.get() + dlFileEntry.getSize());
                    } else {
                        diffTotal.set(diffTotal.get() + 1);
                        diffSize.set(diffSize.get() + dlFileEntry.getSize());
                    }
            }

            total.set(mediaTotal.get() + imageTotal.get() + textTotal.get() + diffTotal.get());
            size.set(mediaSize.get() + imageSize.get() + textSize.get() + diffSize.get());
        });

        UploadFileInfo uploadFileInfo = new UploadFileInfo();

        uploadFileInfo.setSize(String.valueOf(size.get()));
        uploadFileInfo.setTotal(total.get());

        dto.setUploadFilesInfo(uploadFileInfo);

        UploadFileInfo uploadMediaInfo = new UploadFileInfo();

        uploadMediaInfo.setSize(String.valueOf(mediaSize.get()));
        uploadMediaInfo.setTotal(mediaTotal.get());

        dto.setUploadMediaInfo(uploadMediaInfo);

        UploadFileInfo uploadImageInfo = new UploadFileInfo();

        uploadImageInfo.setSize(String.valueOf(imageSize.get()));
        uploadImageInfo.setTotal(imageTotal.get());

        dto.setUploadImageInfo(uploadImageInfo);

        UploadFileInfo uploadTextInfo = new UploadFileInfo();

        uploadTextInfo.setSize(String.valueOf(textSize.get()));
        uploadTextInfo.setTotal(textTotal.get());

        dto.setUploadTextInfo(uploadTextInfo);

        UploadFileInfo uploadDiffInfo = new UploadFileInfo();

        uploadDiffInfo.setSize(String.valueOf(diffSize.get()));
        uploadDiffInfo.setTotal(diffTotal.get());

        dto.setUploadDiffInfo(uploadDiffInfo);
    }

    public DocumentManagerMapperModel mapFromFileManagerMapperModelToDGDocumentManager(DGDocumentManager from) {

        DocumentManagerMapperModel to = new DocumentManagerMapperModel();

        to.setPkCode(from.getPkCode());
        to.setName(from.getName());
        to.setType(from.getType().getValue());
        to.setParentId(from.getParentId());
        to.setCategory(from.getCategory().getValue());
        if (Validator.isNotNull(from.getMetadata())) {
            to.setModuleId(from.getMetadata().getModuleId());
            to.setAppId(from.getMetadata().getAppId());
        }

        to.setPrivate(Boolean.FALSE);

        if (from.getType().equals(DGDocumentManager.Type.FILE)) {
            DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(from.getFileId());

            to.setFileId(dlFileEntry.getFileEntryId());
            to.setFileSize(String.valueOf(dlFileEntry.getSize()));
            to.setFileExtension(dlFileEntry.getExtension());
            to.setMineType(dlFileEntry.getMimeType());
        } else {
            to.setFileId(from.getFileId());
        }

        return to;
    }

    public DocumentManagerMapperModel mapFromFileManagerMapperModelToDGDocumentManager(
            String moduleName,
            String appName,
            String pkCode,
            String category,
            Long parentId,
            FileEntry dlFileEntry) {

        DocumentManagerMapperModel to = new DocumentManagerMapperModel();

        to.setPkCode(pkCode);
        to.setName(dlFileEntry.getTitle());
        to.setType(DGDocumentManager.Type.FILE.getValue());
        to.setParentId(parentId);
        to.setCategory(category);
        to.setPrivate(Boolean.FALSE);

        to.setFileId(dlFileEntry.getFileEntryId());
        to.setFileSize(String.valueOf(dlFileEntry.getSize()));
        to.setFileExtension(dlFileEntry.getExtension());
        to.setMineType(dlFileEntry.getMimeType());

        to.setModuleId(moduleName);
        to.setAppId(appName);

        return to;
    }

    private SettingPermission getSettingPermission(UserTokenModel userTokenModel, long creatorId, long documentId) {

        SettingPermission dto = new SettingPermission();

        DGFileSettingPermissionEntry entry = _dgFileSettingPermissionEntryLocalService.
                fetchDGFileSettingPermissionEntry(userTokenModel.getCustomerId(), documentId);

        if (userTokenModel.getUserId() == creatorId || Validator.isNull(entry)) {

            dto.setPermissionEditor(true);
            dto.setPermissionViewer(true);

            return dto;
        }

        dto.setPermissionViewer(entry.getPermissionViewer());
        dto.setPermissionEditor(entry.getPermissionEditor());

        return dto;
    }

    @Reference
    private CommonFileHelper _fileHelper;
    @Reference
    private DLFileEntryLocalService _dlFileEntryLocalService;
    @Reference
    AccountEntryLocalService _accountEntryLocalService;
    @Reference
    DGDocumentManagerRetrieve _dgDocumentManagerRetrieve;
    @Reference
    DGFileUserPermissionEntryLocalService _dgFileUserPermissionEntryLocalService;
    @Reference
    DGFileDepartmentPermissionEntryLocalService _dgFileDepartmentPermissionEntryLocalService;
    @Reference
    SharedObjectMapper _sharedObjectMapper;

    @Reference
    EmployeeCareerEntryRetriever _employeeCareerEntryRetriever;
    @Reference
    DG_FileUtil dg_fileUtil;
    @Reference
    DGFileSettingPermissionEntryLocalService _dgFileSettingPermissionEntryLocalService;
    @Reference
    TaskEntryLocalService taskEntryLocalService;
    @Reference
    PhaseEntryLocalService phaseEntryLocalService;
    @Reference
    ProjectEntryLocalService projectEntryLocalService;
    @Reference
    DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;

    @Reference
    private ResourceActionEntryLocalService _resourceActionLocalService;

    @Reference
    AccountEntryLocalService accountEntryLocalService;

}
