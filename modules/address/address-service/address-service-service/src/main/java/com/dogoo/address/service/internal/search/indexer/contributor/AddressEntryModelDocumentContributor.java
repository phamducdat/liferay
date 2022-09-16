package com.dogoo.address.service.internal.search.indexer.contributor;

import com.dogoo.address.service.constant.SearchFields;
import com.dogoo.address.service.model.AddressEntry;
import com.dogoo.common.indexer.helper.api.CommonIndexerHelper;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.ADDRESS_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class AddressEntryModelDocumentContributor
        implements ModelDocumentContributor<AddressEntry>{
    @Override
    public void contribute(Document document, AddressEntry addressEntry) {
        _indexerHelper.commonIndexer(
                document,
                addressEntry.getCustomerId(),
                addressEntry.getCreatorId());

        document.addText(SearchFields.DETAIL, addressEntry.getDetail());
        document.addKeywordSortable(SearchFields.DETAIL, addressEntry.getDetail());

        document.addText(SearchFields.POSTAL_CODE, addressEntry.getPostalCode());
        document.addKeywordSortable(SearchFields.POSTAL_CODE, addressEntry.getPostalCode());

        document.addText(SearchFields.WARD, addressEntry.getWard());
        document.addKeywordSortable(SearchFields.WARD, addressEntry.getWard());

        document.addText(SearchFields.DISTRICT, addressEntry.getDistrict());
        document.addKeywordSortable(SearchFields.DISTRICT, addressEntry.getDistrict());

        document.addText(SearchFields.CITY, addressEntry.getProvince());
        document.addKeywordSortable(SearchFields.CITY, addressEntry.getProvince());

        document.addText(SearchFields.COUNTRY, addressEntry.getCountry());
        document.addKeywordSortable(SearchFields.COUNTRY, addressEntry.getCountry());

        document.addText(SearchFields.TITLE, addressEntry.getTitle());
        document.addKeywordSortable(SearchFields.TITLE, addressEntry.getTitle());
    }

    @Reference
    private CommonIndexerHelper _indexerHelper;

}
