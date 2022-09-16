package com.dogoo.dataitems.rest.internal.mapper;

import com.dogoo.dataitems.rest.dto.v2_0.Location;
import com.dogoo.dataitems.service.constant.SearchFields;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = LocationMapper.class)
public class LocationMapper {

    public Location mapLocationFromDocument(Document doc) {
        Location to = new Location();

        long id = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
        String ward = GetterUtil.getString(doc.get(SearchFields.LOCATION_WARD));
        String wardCode = GetterUtil.getString(doc.get(SearchFields.LOCATION_WARD_CODE));
        String district = GetterUtil.getString(doc.get(SearchFields.LOCATION_DISTRICT));
        String districtCode = GetterUtil.getString(doc.get(SearchFields.LOCATION_DISTRICT_CODE));
        String province = GetterUtil.getString(doc.get(SearchFields.LOCATION_PROVINCE));
        String provinceCode = GetterUtil.getString(doc.get(SearchFields.LOCATION_PROVINCE_CODE));
        String title = GetterUtil.getString(doc.get(SearchFields.LOCATION_TITLE));

        to.setId(id);
        to.setTitle(title);
        to.setWard(ward);
        to.setWardCode(wardCode);
        to.setDistrict(district);
        to.setDistrictCode(districtCode);
        to.setProvince(province);
        to.setProvinceCode(provinceCode);

        return to;
    }

    public List<Location> mapLocationListFromDocuments(Document[] from) {
        return Arrays.stream(from)
                .map(this::mapLocationFromDocument).collect(Collectors.toCollection(ArrayList::new));
    }


}
