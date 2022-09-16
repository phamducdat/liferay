package com.dogoo.dataitems.service.internal.search.indexer.contributor;

import com.dogoo.common.indexer.helper.api.CommonIndexerHelper;
import com.dogoo.common.util.api.CommonUtil;
import com.dogoo.dataitems.service.constant.LocationModel;
import com.dogoo.dataitems.service.constant.SearchFields;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.Normalizer;
import java.util.regex.Pattern;

@Component(
    immediate = true,
    property = SearchFields.DATA_ITEM_INDEXER_CLASS,
    service = ModelDocumentContributor.class
)
public class DataItemEntryModelDocumentContributor
        implements ModelDocumentContributor<DataItemEntry> {


    @Override
    public void contribute(Document document, DataItemEntry baseModel) {

        _indexerHelper.commonIndexer(
                document,
                baseModel.getCustomerId(),
                baseModel.getCreatorId(),
                baseModel.getName(),
                baseModel.getDescription());

        document.addKeyword(Field.TYPE, baseModel.getType());
        document.addNumberSortable(SearchFields.ORDER, baseModel.getOrder_());
        document.addKeyword(SearchFields.PARENT_ID, baseModel.getParentId());

        if (baseModel.getType().equalsIgnoreCase(SearchFields.LOCATION_TYPE)) {
            LocationModel location = buildLocationModel(baseModel.getDataItemId());

            document.addKeyword(Field.TITLE,
                    GetterUtil.getString(location.getTitle(), StringPool.BLANK));

            document.addKeyword(SearchFields.LOCATION_TITLE_VN,
                    GetterUtil.getString(location.getNormalizeTitle(), StringPool.BLANK));

            document.addKeyword(SearchFields.LOCATION_WARD,
                    GetterUtil.getString(location.getWard(), StringPool.BLANK));

            document.addKeyword(SearchFields.LOCATION_DISTRICT,
                    GetterUtil.getString(location.getDistrict(), StringPool.BLANK));

            document.addKeyword(SearchFields.LOCATION_PROVINCE,
                    GetterUtil.getString(location.getProvince(), StringPool.BLANK));

            document.addKeywordSortable(SearchFields.LOCATION_WARD_CODE,
                    GetterUtil.getString(location.getWardCode(), StringPool.BLANK));

            document.addKeywordSortable(SearchFields.LOCATION_DISTRICT_CODE,
                    GetterUtil.getString(location.getDistrictCode(), StringPool.BLANK));

            document.addKeywordSortable(SearchFields.LOCATION_PROVINCE_CODE,
                    GetterUtil.getString(location.getProvinceCode(), StringPool.BLANK));
        }

    }

    private LocationModel buildLocationModel(long dataItemId) {

        LocationModel location = new LocationModel();

        String title;

        DataItemEntry itemLevel0 = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        DataItemEntry itemLevel1 =
                _dataItemEntryLocalService.fetchDataItemEntry(
                        GetterUtil.getLong(itemLevel0.getParentId(), GetterUtil.DEFAULT_LONG));

        DataItemEntry itemLevel2 =
                _dataItemEntryLocalService.fetchDataItemEntry(
                        GetterUtil.getLong(Validator.isNotNull(itemLevel1) ? itemLevel1.getParentId() : GetterUtil.DEFAULT_LONG));

        if (Validator.isNotNull(itemLevel2)) {
            title = StringBundler.concat(
                    itemLevel0.getName(),
                    StringPool.COMMA,
                    StringPool.SPACE,
                    itemLevel1.getName(),
                    StringPool.COMMA,
                    StringPool.SPACE,
                    itemLevel2.getName());

            location.setNormalizeTitle(commonUtil.vnNormalize(title));
            location.setTitle(title);
            location.setProvince(itemLevel2.getName());
            location.setProvinceCode(itemLevel2.getExternalReferenceCode());
            location.setDistrict(itemLevel1.getName());
            location.setDistrictCode(itemLevel1.getExternalReferenceCode());
            location.setWard(itemLevel0.getName());
            location.setWardCode(itemLevel0.getExternalReferenceCode());

        } else if (Validator.isNotNull(itemLevel1)){
            title = StringBundler.concat(
                    itemLevel0.getName(),
                    StringPool.COMMA,
                    StringPool.SPACE,
                    itemLevel1.getName());

            location.setNormalizeTitle(commonUtil.vnNormalize(title));
            location.setTitle(title);
            location.setProvince(itemLevel1.getName());
            location.setProvinceCode(itemLevel1.getExternalReferenceCode());
            location.setDistrict(itemLevel0.getName());
            location.setDistrictCode(itemLevel0.getExternalReferenceCode());

        } else {
            title = itemLevel0.getName();

            location.setNormalizeTitle(commonUtil.vnNormalize(title));
            location.setTitle(title);
            location.setProvince(itemLevel0.getName());
            location.setProvinceCode(itemLevel0.getExternalReferenceCode());
        }

        return location;
    }

    @Reference
    private DataItemEntryLocalService _dataItemEntryLocalService;

    @Reference
    private CommonIndexerHelper _indexerHelper;

    @Reference
    private CommonUtil commonUtil;
}
