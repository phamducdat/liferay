package com.dogoo.common.file.helper.impl;


import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFolderService;
import com.liferay.document.library.opener.upload.UniqueFileEntryTitleProvider;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

@Component(
        immediate = true, service = CommonFileHelper.class
)
public class CommonFileHelperImpl implements CommonFileHelper {

    private final long PARENT_FOLDER_ID = 0l;
    private final String FILE_KEY = "file";

    private static final Logger _logger = Logger.getLogger(
            CommonFileHelperImpl.class.getName());

    @Override
    public FileEntry uploadFile(long groupId,
                                long customerId,
                                String customerName,
                                String moduleName,
                                String appName,
                                MultipartBody multipartBody,
                                ServiceContext serviceContext) throws PortalException, IOException {

        FileEntry fileEntry = null;

        BinaryFile binaryFile = multipartBody.getBinaryFile(FILE_KEY);

        String fileName = binaryFile.getFileName();
        String contentType = binaryFile.getContentType();
        InputStream inputStream = binaryFile.getInputStream();

        if (Validator.isNotNull(inputStream)) {

            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(true);


            DLFolder dlFolder = getAppFolder(groupId, customerId, customerName, moduleName, appName,  serviceContext);

            String uniqueTitle = uniqueFileEntryTitleProvider.provide(
                    groupId,
                    dlFolder.getFolderId(),
                    contentType,
                    fileName);


            fileEntry = dlAppService.addFileEntry(
                    UUID.randomUUID().toString(),
                    groupId,
                    dlFolder.getFolderId(),
                    getFileName(fileName),
                    contentType,
                    uniqueTitle,
                    StringPool.BLANK,
                    StringPool.BLANK,
                    inputStream.readAllBytes(),
                    null,
                    null,
                    serviceContext);

        }

        return fileEntry;

    }

    @Override
    public String getPreviewUrl(long fileId, ThemeDisplay themeDisplay) throws PortalException {
        FileEntry fileEntry = dlAppService.getFileEntry(fileId);

        FileVersion fileVersion = fileEntry.getFileVersion();

        String queryString = "";

        return DLURLHelperUtil.getPreviewURL(
                fileEntry,
                fileVersion,
                themeDisplay,
                queryString,
                true,
                true);

    }

    @Override
    public String getDownloadUrl(long fileId, ThemeDisplay themeDisplay) throws PortalException {
        FileEntry fileEntry = dlAppService.getFileEntry(fileId);

        FileVersion fileVersion = fileEntry.getFileVersion();

        String queryString = "";

        return DLURLHelperUtil.getDownloadURL(
                fileEntry,
                fileVersion,
                themeDisplay,
                queryString,
                true,
                true);
    }

    public DLFolder getRootFolder(long groupId,
                                  long customerId,
                                  String customerName,
                                  ServiceContext serviceContext)
            throws PortalException {

        return getFolder(
                groupId,
                PARENT_FOLDER_ID,
                buildRootFolderName(customerId, customerName),
                serviceContext);

    }

    public DLFolder getModuleFolder(long groupId,
                                    long customerId,
                                    String customerName,
                                    String moduleName,
                                    ServiceContext serviceContext)
            throws PortalException {

        DLFolder rootFolder = getRootFolder(groupId, customerId, customerName, serviceContext);

        return getFolder(groupId, rootFolder.getFolderId(), moduleName, serviceContext);
    }

    public DLFolder getAppFolder(long groupId,
                                 long customerId,
                                 String customerName,
                                 String moduleName,
                                 String appName,
                                 ServiceContext serviceContext)
            throws PortalException {

        DLFolder moduleFolder = getModuleFolder(groupId, customerId, customerName, appName, serviceContext);

        DLFolder appFolder =  getFolder(groupId, moduleFolder.getFolderId(), moduleName, serviceContext);

        String folderByDay = StringPool.BLANK;

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());

        folderByDay += calendar.get(Calendar.YEAR) + StringPool.UNDERLINE;
        folderByDay += calendar.get(Calendar.MONTH) + StringPool.UNDERLINE;
        folderByDay += calendar.get(Calendar.DAY_OF_MONTH);

        return getFolder(groupId, appFolder.getFolderId(), folderByDay, serviceContext);

    }

    public DLFolder getFolder(long groupId,
                              long folderParentId,
                              String folderName,
                              ServiceContext serviceContext)
            throws PortalException {

        DLFolder dlFolder;

        try {
            dlFolder = dlFolderService.getFolder(
                    groupId,
                    folderParentId,
                    folderName);

            if (Validator.isNotNull(dlFolder)) {
                return dlFolder;
            }
        } catch (Exception e) {
            _logger.info("ERROR :" + e.getMessage());
        }

        return dlFolderService.addFolder(
                groupId,
                groupId,
                false,
                folderParentId,
                folderName,
                StringPool.BLANK,
                serviceContext);
    }

    private String buildRootFolderName(long customerId,
                                       String customerName) {
        return StringBundler.concat(customerId, StringPool.UNDERLINE, customerName);
    }

    public String getFileName(String fileName) {
        return StringBundler.concat(System.currentTimeMillis(), StringPool.UNDERLINE, fileName);
    }

    @Reference
    DLAppService dlAppService;

    @Reference
    DLFolderService dlFolderService;

    @Reference
    protected UniqueFileEntryTitleProvider uniqueFileEntryTitleProvider;

}
