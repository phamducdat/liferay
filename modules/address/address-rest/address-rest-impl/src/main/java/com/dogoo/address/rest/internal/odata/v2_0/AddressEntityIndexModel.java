package com.dogoo.address.rest.internal.odata.v2_0;

import com.dogoo.address.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressEntityIndexModel implements EntityModel {
    public AddressEntityIndexModel() {
        _entityFieldMap = Stream.of(
                new StringEntityField(
                        SearchFields.POSTAL_CODE, locale -> Field.getSortableFieldName(SearchFields.POSTAL_CODE_STRING)
                ),
                new StringEntityField(
                        SearchFields.DETAIL, locale -> Field.getSortableFieldName(SearchFields.DETAIL_STRING)
                ),
                new StringEntityField(
                        SearchFields.WARD, locale -> Field.getSortableFieldName(SearchFields.WARD_STRING)
                ),
                new StringEntityField(
                        SearchFields.DISTRICT, locale -> Field.getSortableFieldName(SearchFields.DISTRICT_STRING)
                ),
                new StringEntityField(
                        SearchFields.CITY, locale -> Field.getSortableFieldName(SearchFields.CITY_STRING)
                ),
                new StringEntityField(
                        SearchFields.COUNTRY, locale -> Field.getSortableFieldName(SearchFields.COUNTRY_STRING)
                ),
                new StringEntityField(
                        SearchFields.TITLE, locale -> Field.getSortableFieldName(SearchFields.TITLE_STRING)
                )
        ).collect(
                Collectors.toMap(EntityField::getName, Function.identity())
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldMap;
    }

    private final Map<String, EntityField> _entityFieldMap;
}
