package com.dogoo.common.files.manager.rest.internal.service;

import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;
import com.dogoo.common.files.manager.service.service.DGFileVersionEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = DGFileVersionService.class)
public class DGFileVersionService {

    public DGFileVersionEntry createDGFileVersionEntry(long customerId,
                                                       long userId,
                                                       long fileId,
                                                       long fileVersionId,
                                                       long accountId,
                                                       ServiceContext serviceContext
    ) {
        return _localService.createDGFileVersionEntry(
                customerId,
                userId,
                fileId,
                fileVersionId,
                accountId,
                serviceContext);
    }

    @Reference
    DGFileVersionEntryLocalService _localService;
}
