package com.dogoo.common.files.manager.rest.internal.mapper;


import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.dogoo.common.files.manager.rest.dto.v2_0.FilePreview;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component(immediate = true, service = FilePreviewMapper.class)
public class FilePreviewMapper {

    public FilePreview mapFilePreviewFromFileEntry(FileEntry from, ThemeDisplay themeDisplay) throws PortalException {
        FilePreview to = new FilePreview();
        to.setId(from.getFileEntryId());
        to.setFileType(from.getExtension());
        to.setDocumentType(getDocumentType(from.getExtension()));
        to.setKey(String.valueOf(UUID.randomUUID()));
        to.setTitle(from.getTitle());
        to.setUrl(_fileHelper.getPreviewUrl(from.getFileEntryId(), themeDisplay));
        return to;

    }

    public List<FilePreview> mapFilePreviewFromFileEntry(List<FileEntry> from, ThemeDisplay themeDisplay) {
        List<FilePreview> to = new ArrayList<FilePreview>();
        from.forEach(element -> {
            try {
                to.add(mapFilePreviewFromFileEntry(element, themeDisplay));
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        });
        return to;
    }


    private String getDocumentType(String value) {
        switch ("." + value) {
            case ".doc":
            case ".docm":
            case ".docx":
            case ".docxf":
            case ".dot":
            case ".dotm":
            case ".fodt":
            case ".fb2":
            case ".htm":
            case ".html":
            case ".mht":
            case ".odt":
            case ".oform":
            case ".ott":
            case ".oxps":
            case ".pdf":
            case ".txt":
            case ".djvu":
            case ".xml":
            case ".xps":
                return "word";
            case ".csv":
            case ".fods":
            case ".xls":
            case ".ods":
            case ".ots":
            case ".xlsb":
            case ".xlsm":
            case ".xlt":
            case ".xltm":
            case ".xltx":
                return "cell";
            case ".fodp":
            case ".odp":
            case ".otp":
            case ".pot":
            case ".potm":
            case ".potx":
            case ".pps":
            case ".ppsm":
            case ".ppsx":
            case ".ppt":
            case ".pptm":
            case ".pptx":
                return "slide";
            default:
                return null;
        }
    }

    @Reference
    private CommonFileHelper _fileHelper;
}
