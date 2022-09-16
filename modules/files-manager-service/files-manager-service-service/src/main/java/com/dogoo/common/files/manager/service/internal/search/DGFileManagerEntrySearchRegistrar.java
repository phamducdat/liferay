package com.dogoo.common.files.manager.service.internal.search;

import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = DGFileManagerEntrySearchRegistrar.class
)
public class DGFileManagerEntrySearchRegistrar {
    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = modelSearchRegistrarHelper.register(
                DGFileManagerEntry.class, bundleContext,
                modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
                            Field.ENTRY_CLASS_PK, Field.UID);

                    modelSearchDefinition.setModelIndexWriteContributor(
                            modelIndexWriterContributor);
                    modelSearchDefinition.setSearchResultPermissionFilterSuppressed(
                            true);
                });
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference(
            target = StringPool.OPEN_PARENTHESIS
                    + SearchField.DGFILE_MANAGER_INDEXER_CLASS
                    + StringPool.CLOSE_PARENTHESIS
    )
    protected ModelIndexerWriterContributor<DGFileManagerEntry>
            modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    private ServiceRegistration<?> _serviceRegistration;

}
