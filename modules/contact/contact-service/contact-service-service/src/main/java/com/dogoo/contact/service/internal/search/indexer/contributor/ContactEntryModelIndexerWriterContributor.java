
package com.dogoo.contact.service.internal.search.indexer.contributor;

import com.dogoo.contact.service.constant.SearchFields;
import com.dogoo.contact.service.model.ContactEntry;
import com.dogoo.contact.service.service.ContactEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.CONTACT_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class ContactEntryModelIndexerWriterContributor implements
        ModelIndexerWriterContributor<ContactEntry> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (ContactEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _contactEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(ContactEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private ContactEntryLocalService _contactEntryLocalService;
}
