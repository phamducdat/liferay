package com.dogoo.common.auditing.service.constant;

public class SearchFields {
    private SearchFields() {
    }

    public static final String AUDITING_ENTRY_INDEXER_CLASS =
            "indexer.class.name=com.dogoo.common.auditing.service.model.AuditingEntry";


    public static final String CUSTOMER_ID = "customerId";
    public static final String CREATOR_ID = "creatorId";

    public static final String NAME = "name";
    public static final String EVENT_TYPE = "eventType";
    public static final String MESSAGE = "message";
    public static final String PAYLOAD = "payload";
    public static final String CLASS_PK_ID = "classPkId";
    public static final String CLASS_PK_NAME = "classPkName";

    public static final String PARENT_PK_ID = "parentPkId";
    public static final String PARENT_PK_NAME = "parentPkName";
    public static final String CREATE_DATE = "createDate";
    public static final String CREATOR_NAME = "creatorName";

}
