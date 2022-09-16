package com.dogoo.common.auditing.service.internal.search;

import com.dogoo.common.auditing.service.constant.SearchFields;
import com.dogoo.common.auditing.service.model.AuditingEntry;
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
        service = {AuditingEntrySearchRegistrar.class}
)
public class AuditingEntrySearchRegistrar {

    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = modelSearchRegistrarHelper.register(
                AuditingEntry.class, bundleContext,
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
                    + SearchFields.AUDITING_ENTRY_INDEXER_CLASS
                    + StringPool.CLOSE_PARENTHESIS
    )
    protected ModelIndexerWriterContributor<AuditingEntry>
            modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    private ServiceRegistration<?> _serviceRegistration;

}
