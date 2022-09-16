package com.dogoo.common.files.manager.service.internal.search.indexer.contributor;

import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.dogoo.common.files.manager.service.service.DGFileManagerEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.DGFILE_MANAGER_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class DGFileManagerEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<DGFileManagerEntry>{
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
                (DGFileManagerEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));

    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _dgFileManagerEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(DGFileManagerEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private DGFileManagerEntryLocalService _dgFileManagerEntryLocalService;
}
