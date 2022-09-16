package com.dogoo.dataitems.service.constant;

import com.liferay.portal.kernel.util.StringBundler;

public class SearchFields {
    public static final String DATA_ITEM_INDEXER_CLASS =
            "indexer.class.name=com.dogoo.dataitems.service.model.DataItemEntry";

    public static final String LOCATION_TITLE_VN = "normalizeTitle";
    public static final String CUSTOMER_ID = "customerId";
    public static final String ORDER = "order";
    public static final String PARENT_ID = "parentId";
    public static final String NUMBER_SORTABLE = "_Number_sortable";
    public static final String STRING_SORTABLE = "_String_sortable";

    public static final String LOCATION_TYPE = "LOCAL";
    public static final String LOCATION_TITLE = "title";
    public static final String LOCATION_WARD = "ward";
    public static final String LOCATION_WARD_CODE = "wardCode";
    public static final String LOCATION_DISTRICT = "district";
    public static final String LOCATION_DISTRICT_CODE = "districtCode";
    public static final String LOCATION_PROVINCE = "province";
    public static final String LOCATION_PROVINCE_CODE = "provinceCode";


    public static String getNumberSortable(String field) {
        return StringBundler.concat(field, NUMBER_SORTABLE);
    }

    public static String getStringSortable(String field) {
        return StringBundler.concat(field, STRING_SORTABLE);
    }
}
