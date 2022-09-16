package com.dogoo.department.rest.internal.odata.v2_0;
import com.dogoo.department.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class DepartmentEntityModel implements EntityModel {

    public DepartmentEntityModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        SearchFields.NAME, locale -> Field.getSortableFieldName(SearchFields.NAME_STRING)),
                new StringEntityField(
                        SearchFields.CODE, locale -> Field.getSortableFieldName(SearchFields.CODE_STRING)),
                new StringEntityField(
                        SearchFields.DESCRIPTION, locale -> Field.getSortableFieldName(SearchFields.DESCRIPTION_STRING)),
                new StringEntityField(
                        SearchFields.TYPE, locale -> Field.getSortableFieldName(SearchFields.TYPE_STRING)),
                new StringEntityField(
                        SearchFields.ALIAS, locale -> Field.getSortableFieldName(SearchFields.ALIAS_STRING)),
                new StringEntityField(
                        SearchFields.TAX, locale -> Field.getSortableFieldName(SearchFields.TAX_STRING)),
                new StringEntityField(
                        SearchFields.ADDRESS, locale -> Field.getSortableFieldName(SearchFields.ADDRESS_STRING)),
                new StringEntityField(
                        SearchFields.HEAD_OFFICE, locale -> Field.getSortableFieldName(SearchFields.HEAD_OFFICE_STRING))

        );
    }
    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;
}
