package com.dogoo.common.files.manager.service.internal.search.indexer.contributor;

import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.indexer.helper.api.CommonIndexerHelper;
import com.dogoo.common.util.api.CommonUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.DGDOCUMENT_MANAGER_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class DGDocumentManagerEntryModelDocumentContributor implements  ModelDocumentContributor<DGDocumentManagerEntry>{

    @Override
    public void contribute(Document document, DGDocumentManagerEntry baseModel) {

        _indexerHelper.commonIndexer(
                document,
                baseModel.getCustomerId(),
                baseModel.getCreatorId());

        document.addNumber(SearchField.CUSTOMER_ID , baseModel.getCustomerId());
        document.addNumberSortable(SearchField.CUSTOMER_ID , baseModel.getCustomerId());

        document.addNumber(SearchField.CREATOR_ID , baseModel.getCreatorId());
        document.addNumberSortable(SearchField.CREATOR_ID , baseModel.getCreatorId());

        document.addTextSortable(SearchField.PK_CODE , baseModel.getPkCode());

        document.addKeywordSortable(SearchField.TYPE , baseModel.getType());

        document.addNumberSortable(SearchField.PARENT_ID, baseModel.getParentId());

        document.addKeywordSortable(Field.NAME , _commonUtil.vnNormalize(baseModel.getName()));

        document.addDateSortable(Field.CREATE_DATE, baseModel.getCreateDate());
        document.addKeywordSortable(SearchField.CATEGORY, baseModel.getCategory());

        document.addKeyword(SearchField.PATH, baseModel.getPath().split("/"));

        document.addKeyword(SearchField.FILE_SIZE , baseModel.getFileSize());
        document.addKeywordSortable(SearchField.FILE_SIZE , baseModel.getFileSize());

        document.addNumber(SearchField.FILE_ID , baseModel.getFileId());
        document.addNumberSortable(SearchField.FILE_ID , baseModel.getFileId());

        document.addKeywordSortable(SearchField.APP_ID, baseModel.getAppId());
        document.addNumberSortable(SearchField.DEPARTMENT_ID, baseModel.getDepartmentId());

        document.addKeywordSortable(SearchField.IS_PRIVATE, baseModel.getIsPrivate());

        document.addKeywordSortable(SearchField.MODULE_ID, baseModel.getModuleId());
    }

    @Reference
    private CommonIndexerHelper _indexerHelper;

    @Reference
    private CommonUtil _commonUtil;
}
