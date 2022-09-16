package com.dogoo.common.files.manager.service.internal.search.indexer.contributor;

import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.dogoo.common.indexer.helper.api.CommonIndexerHelper;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.DGFILE_MANAGER_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class DGFileManagerEntryModelDocumentContributor implements  ModelDocumentContributor<DGFileManagerEntry>{

    @Override
    public void contribute(Document document, DGFileManagerEntry baseModel) {

        _indexerHelper.commonIndexer(
                document,
                baseModel.getCustomerId(),
                baseModel.getCreatorId());

        document.addNumber(SearchField.CUSTOMER_ID , baseModel.getCustomerId());
        document.addNumberSortable(SearchField.CUSTOMER_ID , baseModel.getCustomerId());

        document.addNumber(SearchField.FILE_MANAGER_ID , baseModel.getFileManagerId());
        document.addNumberSortable(SearchField.FILE_MANAGER_ID , baseModel.getFileManagerId());

        document.addNumber(SearchField.CREATOR_ID , baseModel.getCreatorId());
        document.addNumberSortable(SearchField.CREATOR_ID , baseModel.getCreatorId());

        document.addNumber(SearchField.FILE_ID , baseModel.getFileId());
        document.addNumberSortable(SearchField.FILE_ID , baseModel.getFileId());

        document.addKeyword(SearchField.PARENT_CODE , baseModel.getParentCode());
        document.addKeywordSortable(SearchField.PARENT_CODE , baseModel.getParentCode());

        document.addKeyword(SearchField.FILE_TYPE , baseModel.getFileType());
        document.addKeywordSortable(SearchField.FILE_TYPE , baseModel.getFileType());

        document.addKeyword(SearchField.TYPE , baseModel.getType());
        document.addKeywordSortable(SearchField.TYPE , baseModel.getType());

        document.addKeyword(SearchField.PK_TYPE , baseModel.getPkType());
        document.addKeywordSortable(SearchField.PK_TYPE , baseModel.getPkType());

        document.addKeyword(SearchField.FILE_NAME , baseModel.getFileName());
        document.addKeywordSortable(SearchField.FILE_NAME , baseModel.getFileName());

        document.addKeyword(SearchField.FILE_SIZE , baseModel.getFileSize());
        document.addKeywordSortable(SearchField.FILE_SIZE , baseModel.getFileSize());

        document.addKeywordSortable(SearchField.APP_ID, baseModel.getAppId());
    }

    @Reference
    private CommonIndexerHelper _indexerHelper;

}
