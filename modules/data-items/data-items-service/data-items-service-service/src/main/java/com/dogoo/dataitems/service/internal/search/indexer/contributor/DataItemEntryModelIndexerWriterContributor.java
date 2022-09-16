package com.dogoo.dataitems.service.internal.search.indexer.contributor;

import com.dogoo.dataitems.service.constant.SearchFields;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = SearchFields.DATA_ITEM_INDEXER_CLASS,
    service = ModelIndexerWriterContributor.class
)
public class DataItemEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<DataItemEntry> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (DataItemEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _dataItemEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(DataItemEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private DataItemEntryLocalService _dataItemEntryLocalService;
}
