package com.dogoo.department.service.internal.search.indexer.contributor.department;

import com.dogoo.department.service.constant.SearchFields;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.DEPARTMENT_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class DepartmentEntryModelIndexerWriterContributor implements
        ModelIndexerWriterContributor<DepartmentEntry> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (DepartmentEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _departmentEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(DepartmentEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private DepartmentEntryLocalService _departmentEntryLocalService;
}
