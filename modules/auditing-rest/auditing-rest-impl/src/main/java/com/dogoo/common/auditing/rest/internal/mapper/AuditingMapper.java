package com.dogoo.common.auditing.rest.internal.mapper;

import com.dogoo.common.auditing.rest.dto.v2_0.Auditing;
import com.dogoo.common.auditing.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component(
        immediate = true,
        service = AuditingMapper.class
)
public class AuditingMapper {
    public Auditing mapDocumentToDTO(Document from) {
        Auditing to = new Auditing();

        to.setId(GetterUtil.getLong(from.get(Field.ENTRY_CLASS_PK)));
        to.setName(GetterUtil.getString(from.get(SearchFields.NAME)));
        to.setEventType(GetterUtil.getString(from.get(SearchFields.EVENT_TYPE)));
        to.setMessage(GetterUtil.getString(from.get(SearchFields.MESSAGE)));
        to.setPayload(GetterUtil.getString(from.get(SearchFields.PAYLOAD)));
        try {
            to.setDate(from.getDate(SearchFields.CREATE_DATE));
        } catch (ParseException e) {
            to.setDate(DateUtil.newDate());
        }
        to.setCreator(GetterUtil.getString(from.get(SearchFields.CREATOR_NAME)));

        return to;
    }

    public List<Auditing> mapDocumentsToDTO(Document[] from) {
        return Arrays
                .stream(from)
                .map(this::mapDocumentToDTO)
                .sorted((a, b) -> DateUtil.compareTo(b.getDate(), a.getDate()))
                .collect(Collectors.toList());
    }


}
