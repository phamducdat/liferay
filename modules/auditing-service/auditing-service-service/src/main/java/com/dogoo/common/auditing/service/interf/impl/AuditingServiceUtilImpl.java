package com.dogoo.common.auditing.service.interf.impl;

import com.dogoo.common.auditing.service.constant.EnumType;
import com.dogoo.common.auditing.service.interf.AuditingServiceUtil;
import com.dogoo.common.auditing.service.mapper.model.AuditingMapperModel;
import com.dogoo.common.auditing.service.service.AuditingEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
        scope = ServiceScope.PROTOTYPE,
        service = AuditingServiceUtil.class
)
public class AuditingServiceUtilImpl implements AuditingServiceUtil {
    @Override
    public void addAuditing(long customerId,
                            long creatorId,
                            long classPkId,
                            String classPkName,
                            String name,
                            String eventType,
                            String message,
                            ServiceContext serviceContext) {
        AuditingMapperModel model = new AuditingMapperModel();

        model.setName(name);
        model.setEventType(eventType);
        model.setMessage(message);

        AuditingEntryLocalServiceUtil.addAuditingEntry(
                customerId,
                creatorId,
                classPkId,
                classPkName,
                model,
                serviceContext);
    }

    @Override
    public void addAuditingAndStatus(long customerId,
                                     long creatorId,
                                     long classPkId,
                                     String classPkName,
                                     String name,
                                     String eventType,
                                     String message,
                                     String status,
                                     ServiceContext serviceContext) {

        AuditingMapperModel model = new AuditingMapperModel();

        model.setName(name);
        model.setEventType(eventType);
        model.setMessage(message + renderStatus(status));

        AuditingEntryLocalServiceUtil.addAuditingEntry(
                customerId,
                creatorId,
                classPkId,
                classPkName,
                model,
                serviceContext);
    }

    @Override
    public String insertTag(String tagName, String className, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(tagName);
        sb.append(StringPool.SPACE);
        if (!className.isBlank()) {
            sb.append("class=\"");
            sb.append(className);
            sb.append("\"");
        }

        sb.append(">");
        sb.append(value);
        sb.append("</");
        sb.append(tagName);
        sb.append(">");

        return sb.toString();
    }

    @Override
    public void deleteAuditing(long classPkId, String classPkName) {
        AuditingEntryLocalServiceUtil.deleteByPkAndName(classPkId, classPkName);
    }

    public String renderStatus(String status) {
        switch (status) {
            case EnumType.APPROVED:
                return "???? duy???t";
            case EnumType.PENDING:
                return "Ch??? duy???t";
            case EnumType.DRAFT:
                return "B???n nh??p";
            case EnumType.EXPIRED:
                return "H???t h???n";
            case EnumType.INACTIVE:
                return "Kh??ng ho???t ?????ng";
            case EnumType.INCOMPLETE:
                return "Ch??a ho??n thi???n";
            case EnumType.DENIED:
                return "T??? ch???i";
            default:
                return "";
        }
    }
}
