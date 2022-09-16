package com.dogoo.common.files.manager.rest.internal.mapper;

import com.dogoo.common.files.manager.rest.dto.v2_0.DGFileManager;
import com.dogoo.common.files.manager.service.mapper.model.FileManagerMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true , service = DGFileManagerMapper.class)
public class DGFileManagerMapper {

    public DGFileManager mapFromDGFileManagerToDGFileManagerEntry(DGFileManagerEntry from){
        DGFileManager to = new DGFileManager();

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(from.getFileType());
        to.setType(from.getType());
        to.setPkType(from.getPkType());
        to.setFileName(from.getFileName());
        to.setFileSize(from.getFileSize());

        return to;
    }

    public DGFileManager mapDgFileManagerFromDLFileEntry(DLFileEntry entry) {
        DGFileManager to = new DGFileManager();

        to.setFileId(entry.getFileEntryId());
        to.setFileName(entry.getTitle());
        to.setMineType(entry.getMimeType());
        to.setFileType(entry.getExtension());
        to.setFileSize(String.valueOf(entry.getSize()));

        return to;
    }

    public FileManagerMapperModel mapFromFileManagerMapperModelToDGFileManager(DGFileManager from){
        FileManagerMapperModel to = new FileManagerMapperModel();

        DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(from.getFileId());

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(dlFileEntry.getExtension());
        to.setType(from.getType());
        to.setPkType(from.getPkType());
        to.setFileName(dlFileEntry.getTitle());
        to.setFileSize(String.valueOf(dlFileEntry.getSize()));
        to.setModuleId(from.getMetadata().getModuleId());
        to.setAppId(from.getMetadata().getAppId());

        return to;
    }

    public DGFileManager mapFromDGFileManagerToDGFileManagerMapperModel(FileManagerMapperModel from){

        DGFileManager to = new DGFileManager();

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(from.getFileType());
        to.setType(from.getType());
        to.setPkType(from.getPkType());
        to.setFileName(from.getFileName());
        to.setFileSize(from.getFileSize());

        return to;
    }

    public List<DGFileManager> mapFromDGFileManagerToDGFileManagerMapperModelList(List<FileManagerMapperModel> fromList){

        List<DGFileManager> to = new ArrayList<>();

        fromList.forEach(fileManagerMapperModel -> to.add(mapFromDGFileManagerToDGFileManagerMapperModel(fileManagerMapperModel)));

        return to;
    }

    @Reference
    private DLFileEntryLocalService _dlFileEntryLocalService ;
}
