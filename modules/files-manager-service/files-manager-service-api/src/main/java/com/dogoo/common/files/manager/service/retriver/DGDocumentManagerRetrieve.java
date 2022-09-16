package com.dogoo.common.files.manager.service.retriver;

import com.liferay.portal.kernel.search.Document;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface DGDocumentManagerRetrieve {

    Document[] getAllFilesInFolder(long customerId, long documentId);

    long getFolderSize(long customerId, long documentId);
}
