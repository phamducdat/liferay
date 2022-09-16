package com.dogoo.common.files.manager.rest.internal.mapper.documentserver;

import com.dogoo.common.files.manager.rest.dto.v2_0.Config;
import com.dogoo.common.files.manager.rest.internal.mapper.documentserver.document.DocumentMapper;
import com.dogoo.common.files.manager.rest.internal.mapper.documentserver.editorconfig.EditorConfigMapper;
import com.dogoo.common.files.manager.rest.internal.mapper.documentserver.events.EventsMapper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(immediate = true, service = ConfigMapper.class)
public class ConfigMapper {

    public Config mapConfigFromFileEntry(
            FileEntry from,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel,
            Locale locale
    ) throws PortalException {
        Config config = new Config();

        config.setEditorConfig(_editorConfigMapper.mapEditorConfig(from.getFileEntryId(), userTokenModel));
        config.setDocument(_documentMapper.mapDocumentFromFileEntry(from, themeDisplay, userTokenModel,
                config.getEditorConfig().getMode()));
        config.setDocumentType(getDocumentType(from.getExtension()));
        config.setEvents(_eventsMapper.mapEvents(from, themeDisplay, locale));

        return config;
    }

    @Reference
    DocumentMapper _documentMapper;

    @Reference
    EventsMapper _eventsMapper;

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
    private EditorConfigMapper _editorConfigMapper;


//    @Reference
}
