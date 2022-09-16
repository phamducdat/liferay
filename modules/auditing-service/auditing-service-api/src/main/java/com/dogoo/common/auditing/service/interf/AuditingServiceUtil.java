package com.dogoo.common.auditing.service.interf;


import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.service.ServiceContext;

@ProviderType
public interface AuditingServiceUtil {
    void addAuditing(long customerId,
                     long creatorId,
                     long classPkId,
                     String classPkName,
                     String name,
                     String eventType,
                     String message,
                     ServiceContext serviceContext);

    void addAuditingAndStatus(long customerId,
                              long creatorId,
                              long classPkId,
                              String classPkName,
                              String name,
                              String eventType,
                              String message,
                              String status,
                              ServiceContext serviceContext);

    String insertTag(String tagName, String className, String value);

    void deleteAuditing(long classPkId, String classPkName);
}
