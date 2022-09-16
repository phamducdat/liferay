package com.dogoo.address.service.internal.search.indexer.contributor;

import com.dogoo.address.service.constant.SearchFields;
import com.dogoo.address.service.model.AddressEntry;
import com.dogoo.address.service.service.AddressEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.ADDRESS_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)

public class AddressEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<AddressEntry>{
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (AddressEntry addressEntry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(addressEntry)
                )
        );
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _addressEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(AddressEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private AddressEntryLocalService _addressEntryLocalService;
}
