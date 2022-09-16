package com.dogoo.dataitems.rest.internal.odata.v2_0;

import com.dogoo.dataitems.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class DataItemEntryModel implements EntityModel {

    public DataItemEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(Field.NAME)),
                new StringEntityField(
                        Field.STATUS, locale -> Field.getSortableFieldName(Field.STATUS)),
                new StringEntityField(
                        SearchFields.ORDER, locale -> Field.getSortableFieldName(SearchFields.ORDER)),
                new StringEntityField(
                        SearchFields.LOCATION_WARD_CODE,
                        locale -> SearchFields.getStringSortable(SearchFields.LOCATION_WARD_CODE)),
                new StringEntityField(
                        SearchFields.LOCATION_DISTRICT_CODE,
                        locale -> SearchFields.getStringSortable(SearchFields.LOCATION_DISTRICT_CODE)),
                new StringEntityField(
                        SearchFields.LOCATION_PROVINCE_CODE,
                        locale -> SearchFields.getStringSortable(SearchFields.LOCATION_PROVINCE_CODE))
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
