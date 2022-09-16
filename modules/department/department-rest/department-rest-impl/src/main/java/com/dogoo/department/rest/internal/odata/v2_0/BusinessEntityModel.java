package com.dogoo.department.rest.internal.odata.v2_0;

import com.dogoo.department.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class BusinessEntityModel implements EntityModel {

    public BusinessEntityModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        SearchFields.NAME, locale -> Field.getSortableFieldName(SearchFields.NAME_STRING))

        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
