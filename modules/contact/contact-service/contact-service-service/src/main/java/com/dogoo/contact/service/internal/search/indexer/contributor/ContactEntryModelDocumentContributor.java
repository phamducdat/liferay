package com.dogoo.contact.service.internal.search.indexer.contributor;

import com.dogoo.contact.service.constant.SearchFields;
import com.dogoo.contact.service.model.ContactEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchFields.CONTACT_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class ContactEntryModelDocumentContributor implements
        ModelDocumentContributor<ContactEntry> {
    @Override
    public void contribute(Document document, ContactEntry baseModel) {
        document.addKeyword(SearchFields.CUSTOMER_ID, Long.toString(baseModel.getCustomerId()));
        document.addKeyword(SearchFields.CREATOR_ID, Long.toString(baseModel.getCreatorId()));


        document.addText(SearchFields.FACEBOOK, baseModel.getFacebook());
        document.addKeywordSortable(SearchFields.FACEBOOK, baseModel.getFacebook());

        document.addText(SearchFields.TWITTER, baseModel.getTwitter());
        document.addKeywordSortable(SearchFields.TWITTER, baseModel.getTwitter());

        document.addText(SearchFields.LINKEDIN, baseModel.getLinkedin());
        document.addKeywordSortable(SearchFields.LINKEDIN, baseModel.getLinkedin());


    }
}
