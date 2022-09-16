package com.dogoo.dataitems.rest.internal.mapper;

import com.dogoo.dataitems.rest.dto.v2_0.DataItem;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = DataItemMapper.class)
public class DataItemMapper {

    public DataItem mapDataItemFromDataItemEntry(DataItemEntry from) {
        DataItem to = new DataItem();

        to.setId(from.getDataItemId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setType(from.getType());
        to.setOrder(from.getOrder_());
        to.setParentId(from.getParentId());
        to.setIsDefault(from.getIsDefaultValue());

        return to;
    }

    public long getDataItemEntryId(String referenceCode) {
        DataItemEntry entry = getObject(referenceCode);

        if (Validator.isNull(entry)) {return 0l;}

        return entry.getDataItemId();
    }

    public DataItemEntry getObject(String referenceCode) {
        DataItemEntry entry =
                _dataItemEntryLocalService.fetchDataItemEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(), referenceCode);

        if (entry == null) {
            entry = _dataItemEntryLocalService.fetchDataItemEntry(GetterUtil.getLong(referenceCode));
        }

        return entry;
    }

    public DataItem[] mapListDataToArray(List<DataItem> from) {
        return TransformUtil.transformToArray(
                from,
                dataItem -> dataItem,
                DataItem.class
        );

    }

    @Reference
    private DataItemEntryLocalService _dataItemEntryLocalService;


}
