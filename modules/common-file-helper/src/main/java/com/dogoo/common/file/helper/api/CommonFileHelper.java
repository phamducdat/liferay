package com.dogoo.common.file.helper.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.annotation.versioning.ProviderType;

import java.io.IOException;

/**
 * @author khoa
 */

@ProviderType
public interface CommonFileHelper {

    FileEntry uploadFile(long groupId,
                         long customerId,
                         String customerName,
                         String moduleName,
                         String appName,
                         MultipartBody multipartBody,
                         ServiceContext serviceContext) throws PortalException, IOException;

    String getPreviewUrl(long fileId, ThemeDisplay themeDisplay) throws PortalException;

    String getDownloadUrl(long fileId, ThemeDisplay themeDisplay) throws PortalException;
}