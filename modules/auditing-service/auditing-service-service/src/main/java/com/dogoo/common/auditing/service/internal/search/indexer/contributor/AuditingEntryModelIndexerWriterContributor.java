package com.dogoo.common.auditing.service.internal.search.indexer.contributor;

import com.dogoo.common.auditing.service.constant.SearchFields;
import com.dogoo.common.auditing.service.model.AuditingEntry;
import com.dogoo.common.auditing.service.service.AuditingEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.AUDITING_ENTRY_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class AuditingEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<AuditingEntry> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (AuditingEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _resourceTypeEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(AuditingEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private AuditingEntryLocalService _resourceTypeEntryLocalService;
}
