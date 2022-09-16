package com.dogoo.common.api.rest.internal.odata.v2_0;

import com.dogoo.common.lib.api.CommonConstants;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class ReferenceEntryModel implements EntityModel {

    public ReferenceEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(Field.NAME)),
                new StringEntityField(
                        CommonConstants.EXTERNAL_REFERENCE_CODE,
                        locale -> CommonConstants.EXTERNAL_REFERENCE_CODE + "_String_sortable")
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
