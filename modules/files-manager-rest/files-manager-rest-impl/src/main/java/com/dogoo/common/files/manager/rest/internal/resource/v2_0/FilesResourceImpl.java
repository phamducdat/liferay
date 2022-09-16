package com.dogoo.common.files.manager.rest.internal.resource.v2_0;

import com.dogoo.common.exception.model.DG_DataInputException;
import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.dogoo.common.files.manager.rest.dto.v2_0.*;
import com.dogoo.common.files.manager.rest.internal.mapper.FilePreviewMapper;
import com.dogoo.common.files.manager.rest.internal.service.DGDocumentManagerService;
import com.dogoo.common.files.manager.rest.internal.service.FileService;
import com.dogoo.common.files.manager.rest.internal.service.permission.*;
import com.dogoo.common.files.manager.rest.internal.util.DG_FileUtil;
import com.dogoo.common.files.manager.rest.internal.util.LanguageKeys;
import com.dogoo.common.files.manager.rest.internal.validator.FilePermissionValidator;
import com.dogoo.common.files.manager.rest.resource.v2_0.FilesResource;
import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.employee.career.service.retriever.EmployeeCareerEntryRetriever;
import com.dogoo.employee.service.mapper.model.EmployeeCurrentPositionMapperModel;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author khoa
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/files.properties",
        scope = ServiceScope.PROTOTYPE, service = FilesResource.class
)
public class FilesResourceImpl extends BaseFilesResourceImpl {
    private static final String METADATA_KEY = "metadata";


    @Override
    public Config getConfigFileById(Long fileId) throws Exception {

        _permissionValidator.validateForPermissionFile(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                fileId,
                getUserToken().getEmployeeId()
        );
        return _fileService.getConfigByFileId(
                fileId,
                getThemeDisplay(),
                getUserToken(),
                getLocale()

        );

    }


    @Override
    public FilePermission getFilePermission(Long documentManagerFileId) throws Exception {
        return _filePermissionService.getFilePermission(
                getUserToken().getCustomerId(),
                documentManagerFileId);
    }

    @Override
    public void AttachPermission(Long documentManagerFileId, AttachPermission attachPermission) throws Exception {
        _attachPermissionService.attachPermission(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                documentManagerFileId,
                attachPermission,
                getServiceContext()
        );
    }


    @Override
    public void UpdateFilePermissionUser(Long documentManagerFileId, Long userId, FilePermissionUser filePermissionUser) throws Exception {
        _fileUserPermissionService.updateFileUserPermission(getUserToken().getCustomerId(),
                userId, documentManagerFileId, filePermissionUser, getServiceContext());
    }

    @Override
    public void DeleteFilePermissionDepartment(Long documentManagerFileId, Long departmentId) throws Exception {
        _filePermissionService.deleteFileDepartmentPermission(
                getUserToken().getCustomerId(),
                departmentId,
                documentManagerFileId
        );
    }

    @Override
    public void DeleteFileUserPermission(Long documentManagerFileId, Long userId) throws Exception {
        _filePermissionService.deleteFileUserPermission(
                getUserToken().getCustomerId(),
                userId, documentManagerFileId,
                getServiceContext());
    }

    @Override
    public void UpdateFilePermissionDepartment(Long documentManagerFileId, Long departmentId, FilePermissionDepartment filePermissionDepartment) throws Exception {
        _fileDepartmentPermissionService.updateFileDepartmentPermission(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                departmentId,
                documentManagerFileId,
                filePermissionDepartment,
                getServiceContext()
        );
    }

    @Override
    public void updateGeneralPermission(Long documentManagerFileId, GeneralPermission generalPermission) throws Exception {
        _generalPermissionService.updateGeneralPermission(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                documentManagerFileId,
                generalPermission,
                getServiceContext()
        );
    }


    @Override
    public void updateSettingPermission(Long documentManagerFileId, SettingPermission settingPermission) {
        _settingPermissionService.updateSettingPermission(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                documentManagerFileId,
                settingPermission,
                getServiceContext()
        );
    }

    @Override
    public Page<FilePreview> getAllFileByUserId(Long userId) throws Exception {
        return _fileService.getAllFilePreviewFromUserId(userId, getServiceContext().getScopeGroupId(), getThemeDisplay());
    }

    @Override
    public FileData getFileById(Long fileId) throws Exception {

        FileEntry entry = dlAppService.getFileEntry(fileId);
        FileData to = new FileData();

//        entry.getFileVersion()

        to.setData(Arrays.toString(entry.getContentStream().readAllBytes()));
        to.setFileType("." + entry.getExtension());
        to.setSize(entry.getSize());
        to.setTitle(entry.getTitle());

        return to;
    }

    private static final String PK_CODE_KEY = "pkCode";

    private static final String PARENT_ID_KEY = "parentId";

    @Override
    public FileRes postFile(MultipartBody multipartBody) throws Exception {

        Metadata metadata = multipartBody.getValueAsInstance(METADATA_KEY, Metadata.class);

        FileEntry fileEntry = _fileHelper.uploadFile(
                getServiceContext().getScopeGroupId(),
                getUserToken().getCustomerId(),
                getUserToken().getCustomer(),
                metadata.getModuleId(),
                metadata.getAppId(),
                multipartBody,
                getServiceContext());

        FileRes fileRes = new FileRes();

        fileRes.setId(fileEntry.getFileEntryId());
        fileRes.setFileName(fileEntry.getTitle());
        fileRes.setFileSize(String.valueOf(fileEntry.getSize()));
        fileRes.setMimeType(String.valueOf(fileEntry.getExtension()));
        fileRes.setMetadata(metadata);

        return fileRes;
    }

    @Override
    public FileUpdate updateFile(Long fileId, FileUpdate fileUpdate) throws Exception {
        FileUpdate to = new FileUpdate();
        URL uri = new URL(fileUpdate.getUrl());
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) uri.openConnection();
        InputStream stream = connection.getInputStream();

        if (stream != null) {
            _fileService.updateFileByFileId(
                    getUserToken().getCustomerId(),
                    getUserToken().getUserId(),
                    getUserToken().getAccountId(),
                    fileId,
                    stream.readAllBytes(),
                    getServiceContext());
        } else {
            throw new DG_DataInputException("Not found");
        }

        return to;

    }


    @Override
    public void postMultipleFiles(MultipartBody multipartBody) throws Exception {

        Metadata metadata = multipartBody.getValueAsInstance(METADATA_KEY, Metadata.class);

        String category = multipartBody.getValueAsString("category");

        String pkCode = multipartBody.getValueAsString(PK_CODE_KEY);

        long parentId = GetterUtil.getLong(multipartBody.getValueAsString(PARENT_ID_KEY));

        _dgDocumentManagerService.uploadMultipleFile(
                getServiceContext().getScopeGroupId(),
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                getDepartmentId(),
                getUserToken().getCustomer(),
                metadata.getModuleId(),
                metadata.getAppId(),
                multipartBody,
                category,
                pkCode,
                parentId,
                getServiceContext()
        );
    }

    @Override
    public FilePreview getFilePreview(Long fileId) throws Exception {
        FileEntry fileEntry = dlAppService.getFileEntry(fileId);

        return _mapper.mapFilePreviewFromFileEntry(fileEntry, getThemeDisplay());
    }

    @Override
    public String getFileDownload(Long fileId) throws Exception {
        return _fileHelper.getDownloadUrl(fileId, getThemeDisplay());
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(1L);
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }

    public ThemeDisplay getThemeDisplay() {

        ThemeDisplay themeDisplay = new ThemeDisplay();
        String remoteHost = contextHttpServletRequest.getServerName();
        String scheme = contextHttpServletRequest.getScheme();
        if (StringUtil.equals(remoteHost, "localhost"))
            themeDisplay.setPortalURL("http://localhost:8080");
        else

            themeDisplay.setPortalURL("https" + "://" + remoteHost);

        return themeDisplay;
    }

    public Long getDepartmentId() {
        EmployeeCurrentPositionMapperModel employee = _employeeCareerEntryRetriever.getEmployeeCurrent(
                getUserToken().getCustomerId(),
                getUserToken().getEmployeeId()
        );

        return employee.getDepartmentId();
    }

    public Locale getLocale() {

        Locale locale = contextHttpServletRequest.getLocale();

        if (locale.getLanguage().isEmpty()) {
            locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
        }

        return locale;
    }

    private UserTokenModel getUserToken() {
        return _tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper _tokenHelper;

    @Reference
    private CommonFileHelper _fileHelper;


    @Reference
    private FilePreviewMapper _mapper;

    @Reference
    DLAppService dlAppService;

    @Reference
    DGDocumentManagerService _dgDocumentManagerService;

    @Reference
    FileService _fileService;

    @Reference
    DLFileEntryLocalService _dlFileEntryLocalService;

    @Reference
    FileGeneralPermissionService _generalPermissionService;

    @Reference
    FileSettingPermissionService _settingPermissionService;

    @Reference
    FilePermissionValidator _permissionValidator;

    @Reference
    AttachPermissionService _attachPermissionService;

    @Reference
    FilePermissionService _filePermissionService;

    @Reference
    FileUserPermissionService _fileUserPermissionService;

    @Reference
    FileDepartmentPermissionService _fileDepartmentPermissionService;

    @Reference
    DG_FileUtil _dgFileUtil;

    @Reference
    EmployeeCareerEntryRetriever _employeeCareerEntryRetriever;

}