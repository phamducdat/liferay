package com.dogoo.common.files.manager.service.internal.retriever;

import com.dogoo.common.files.manager.service.mapper.model.FileManagerMapperModel;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = DGFileManagerMapper.class)
public class DGFileManagerMapper {

    public FileManagerMapperModel mapperFileManagerMapperModel(long fileId,
                                                               String parentCode,
                                                               String fileType,
                                                               String type,
                                                               String pkType,
                                                               String fileName,
                                                               String fileSize){

        FileManagerMapperModel to = new FileManagerMapperModel();

        to.setFileId(fileId);
        to.setParentCode(parentCode);
        to.setFileType(fileType);
        to.setType(type);
        to.setPkType(pkType);
        to.setFileName(fileName);
        to.setFileSize(fileSize);

        return to ;
    }

}
