package com.dogoo.common.files.manager.rest.internal.mapper.documentserver.document;

import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.dogoo.common.files.manager.rest.dto.v2_0.Document;
import com.dogoo.common.files.manager.rest.dto.v2_0.EditorConfig;
import com.dogoo.common.files.manager.rest.internal.mapper.documentserver.document.permissions.PermissionsMapper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.UUID;

@Component(immediate = true, service = DocumentMapper.class)
public class DocumentMapper {

    public Document mapDocumentFromFileEntry(FileEntry from,
                                             ThemeDisplay themeDisplay,
                                             UserTokenModel userTokenModel,
                                             EditorConfig.Mode mode) throws PortalException {
        Document to = new Document();

        to.setFileType(from.getExtension());
        to.setKey(String.valueOf(UUID.randomUUID()));
        to.setTitle(from.getTitle());
        to.setUrl(_fileHelper.getDownloadUrl(from.getFileEntryId(), themeDisplay));

        to.setPermissions(_permissionsMapper.mapPermissions(from.getFileEntryId(),
                userTokenModel, mode));


        return to;
    }


    @Reference
    private CommonFileHelper _fileHelper;

    @Reference
    private PermissionsMapper _permissionsMapper;


}
