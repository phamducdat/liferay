package com.dogoo.common.auditing.rest.service.v2_0;

import com.dogoo.common.auditing.rest.dto.v2_0.Auditing;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface AuditingServiceUtil {
    Auditing addAuditing(long customerId,
                         long creatorId,
                         long classPkId,
                         String classPkName,
                         String name,
                         String eventType,
                         String message,
                         String payload,
                         ServiceContext serviceContext);
}
