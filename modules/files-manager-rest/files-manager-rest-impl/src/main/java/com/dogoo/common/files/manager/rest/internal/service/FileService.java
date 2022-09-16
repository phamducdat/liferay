package com.dogoo.common.files.manager.rest.internal.service;

import com.dogoo.common.files.manager.rest.dto.v2_0.Config;
import com.dogoo.common.files.manager.rest.dto.v2_0.FilePreview;
import com.dogoo.common.files.manager.rest.internal.mapper.FilePreviewMapper;
import com.dogoo.common.files.manager.rest.internal.mapper.documentserver.ConfigMapper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Locale;

@Component(immediate = true, service = FileService.class)
public class FileService {


    public Page<FilePreview> getAllFilePreviewFromUserId(long userId, long groupId, ThemeDisplay themeDisplay) throws PortalException {
        List<FileEntry> filePreviews = dlAppService.getGroupFileEntries(groupId, userId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        return Page.of(_filePreviewMapper.mapFilePreviewFromFileEntry(filePreviews, themeDisplay));
    }

    public void updateFileByFileId(
            long customerId,
            long userId,
            long accountId,
            long fileId,
            byte[] bytes,
            ServiceContext serviceContext
    ) throws PortalException {

        FileEntry entry = dlAppService.getFileEntry(fileId);
        if (entry != null) {
            FileEntry fileEntry = dlAppService.updateFileEntry(
                    fileId,
                    entry.getFileName(),
                    entry.getMimeType(),
                    entry.getTitle(),
                    entry.getDescription(),
                    entry.getFileVersion().getChangeLog(),
                    DLVersionNumberIncrease.AUTOMATIC,
                    bytes,
                    null,
                    null,
                    serviceContext);
            _dgFileVersionService.createDGFileVersionEntry(
                    customerId,
                    userId,
                    fileId,
                    fileEntry.getFileVersion().getFileVersionId(),
                    accountId,
                    serviceContext
            );
        }
    }


    public Config getConfigByFileId(long fileId,
                                    ThemeDisplay themeDisplay,
                                    UserTokenModel userTokenModel,
                                    Locale locale
    ) throws PortalException {
        FileEntry fileEntry = dlAppService.getFileEntry(fileId);

        return _configMapper.mapConfigFromFileEntry(
                fileEntry,
                themeDisplay,
                userTokenModel,
                locale
        );
    }


    @Reference
    FilePreviewMapper _filePreviewMapper;

    @Reference
    ConfigMapper _configMapper;
    @Reference
    DLAppService dlAppService;


    @Reference
    DGFileVersionService _dgFileVersionService;
}
