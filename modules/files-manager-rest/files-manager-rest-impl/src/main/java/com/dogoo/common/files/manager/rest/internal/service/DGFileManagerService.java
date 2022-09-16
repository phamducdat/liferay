package com.dogoo.common.files.manager.rest.internal.service;

import com.dogoo.common.files.manager.rest.dto.v2_0.DGFileManager;
import com.dogoo.common.files.manager.rest.internal.mapper.DGFileManagerMapper;
import com.dogoo.common.files.manager.service.mapper.model.FileManagerMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.dogoo.common.files.manager.service.retriver.DGFileManagerRetriever;
import com.dogoo.common.files.manager.service.service.DGFileManagerEntryLocalService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = DGFileManagerService.class)
public class DGFileManagerService {

    public DGFileManager postDGFileManager(long customerId,
                                           long userId,
                                           DGFileManager dgFileManager,
                                           ServiceContext serviceContext) throws Exception {

        DGFileManagerEntry entry =
                _dgFileManagerEntryLocalService.addDGFileManager(
                        customerId,
                        userId,
                        _mapper.mapFromFileManagerMapperModelToDGFileManager(dgFileManager),
                        serviceContext);


        return _mapper.mapFromDGFileManagerToDGFileManagerEntry(entry);
    }

    public List<DGFileManager> getAllDGFileManagerByPkType(long customerId,
                                                           String parentCode,
                                                           String pkType) {

        List<FileManagerMapperModel> fromList = _retriever.getAllDGFileManagerByPKType(
                customerId, parentCode, pkType);

        return _mapper.mapFromDGFileManagerToDGFileManagerMapperModelList(fromList);
    }

    public List<DGFileManager> getAllDGFileManager(long customerId,
                                                   String parentCode) {

        List<FileManagerMapperModel> fromList = _retriever.getAllDGFileManager(
                customerId, parentCode);

        return _mapper.mapFromDGFileManagerToDGFileManagerMapperModelList(fromList);
    }

    private List<Long> getAllFileId(long customerId,
                                    String parentCode) {

        return _retriever.getAllFileId(customerId, parentCode);
    }

    public DGFileManager getDgFileManagerByFileId(long fileId) {

        return _mapper.mapDgFileManagerFromDLFileEntry(
                _dlFileEntryLocalService.fetchDLFileEntry(fileId)
        );
    }

    public void deleteFileId(long fileId, long customerId) throws Exception {

        _dlFileEntryLocalService.deleteDLFileEntry(fileId);

        DGFileManagerEntry dgFileManagerEntry = _dgFileManagerEntryLocalService.
                getDGFileManagerEntryByFileId(fileId, customerId);

        if (dgFileManagerEntry == null) return;

        _dgFileManagerEntryLocalService.deleteDGFileManagerEntry(dgFileManagerEntry.getFileManagerId());

    }

    public void deleteFileManagerOfParent(long customerId,
                                          String parentCode) {
        List<Long> list = getAllFileId(customerId, parentCode);

        list.stream().forEach(l -> {
            DGFileManagerEntry dgFileManagerEntry = _dgFileManagerEntryLocalService.
                    getDGFileManagerEntryByFileId(l, customerId);

            try {
                _dgFileManagerEntryLocalService.deleteDGFileManagerEntry(dgFileManagerEntry.getFileManagerId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            try {
                _dlFileEntryLocalService.deleteDLFileEntry(l);
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Reference
    private DGFileManagerEntryLocalService _dgFileManagerEntryLocalService;

    @Reference
    private DGFileManagerMapper _mapper;

    @Reference
    private DGFileManagerRetriever _retriever;

    @Reference
    private DLFileEntryLocalService _dlFileEntryLocalService;


}
