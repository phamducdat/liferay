package com.dogoo.department.service.internal.search.indexer.contributor.business;

import com.dogoo.department.service.constant.SearchFields;
import com.dogoo.department.service.model.BusinessEntry;
import com.dogoo.department.service.service.BusinessEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.BUSINESS_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class BusinessEntryModelIndexerWriterContributor implements
        ModelIndexerWriterContributor<BusinessEntry> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (BusinessEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _businessEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(BusinessEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private BusinessEntryLocalService _businessEntryLocalService;
}
