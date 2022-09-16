package com.dogoo.contact.rest.internal.odata.v2_0;

import com.dogoo.contact.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class ContactEntryModel implements EntityModel {

    public ContactEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(Field.NAME)),
                new StringEntityField(
                        Field.STATUS, locale -> Field.getSortableFieldName(Field.STATUS)),
                new StringEntityField(
                        SearchFields.FACEBOOK, locale -> Field.getSortableFieldName(SearchFields.FACEBOOK_STRING)),
                new StringEntityField(
                        SearchFields.TWITTER, locale -> Field.getSortableFieldName(SearchFields.TWITTER_STRING)),
                new StringEntityField(
                        SearchFields.LINKEDIN, locale -> Field.getSortableFieldName(SearchFields.LINKEDIN_STRING))

        );
    }
    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;
}