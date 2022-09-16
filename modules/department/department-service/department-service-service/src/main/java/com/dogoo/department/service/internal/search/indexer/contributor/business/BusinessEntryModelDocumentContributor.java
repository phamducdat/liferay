package com.dogoo.department.service.internal.search.indexer.contributor.business;

import com.dogoo.department.service.constant.SearchFields;
import com.dogoo.department.service.model.BusinessEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchFields.BUSINESS_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class BusinessEntryModelDocumentContributor implements
        ModelDocumentContributor<BusinessEntry> {
    @Override
    public void contribute(Document document, BusinessEntry baseModel) {
        document.addKeyword(SearchFields.CUSTOMER_ID, Long.toString(baseModel.getCustomerId()));
        document.addKeyword(SearchFields.CREATOR_ID, Long.toString(baseModel.getCreatorId()));

        document.addText(SearchFields.NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.NAME, baseModel.getName());



    }
}
