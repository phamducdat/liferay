package com.dogoo.common.auditing.service.internal.search.indexer.contributor;

import com.dogoo.common.auditing.service.constant.SearchFields;
import com.dogoo.common.auditing.service.model.AuditingEntry;
import com.dogoo.common.indexer.helper.api.CommonIndexerHelper;
import com.dogoo.common.util.api.CommonUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.AUDITING_ENTRY_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class AuditingEntryModelDocumentContributor
        implements ModelDocumentContributor<AuditingEntry> {

    @Override
    public void contribute(Document document, AuditingEntry baseModel) {

        _commonIndexerHelper.commonIndexer(
                document,
                baseModel.getCustomerId(),
                baseModel.getCreatorId()
        );

        document.addText(SearchFields.NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.NAME, baseModel.getName());
        document.addText(SearchFields.EVENT_TYPE, baseModel.getEventType());
        document.addText(SearchFields.MESSAGE, baseModel.getMessage());
        document.addText(SearchFields.PAYLOAD, baseModel.getPayload());
        document.addDate(SearchFields.CREATE_DATE, baseModel.getCreateDate());
        document.addText(SearchFields.CREATOR_NAME, baseModel.getCreatorName());

        document.addNumber(SearchFields.CLASS_PK_ID, baseModel.getClassPkId());
        document.addNumber(SearchFields.PARENT_PK_ID, baseModel.getParentPkId());
        document.addText(SearchFields.CLASS_PK_NAME, baseModel.getClassPkName());
        document.addText(SearchFields.PARENT_PK_NAME, baseModel.getParentPkName());

        document.addNumber(Field.COMPANY_ID , baseModel.getCompanyId());
        document.addNumberSortable(Field.COMPANY_ID , baseModel.getCompanyId());

    }

    @Reference
    CommonIndexerHelper _commonIndexerHelper;
}
