package com.dogoo.common.indexer.helper.impl;

import com.dogoo.common.indexer.helper.api.CommonIndexerHelper;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.StringBundler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Date;


/**
 * @author khoa
 */

@Component(
        scope = ServiceScope.PROTOTYPE, service = CommonIndexerHelper.class
)
public class CommonIndexerHelperImpl extends BaseCommonIndexerHelperImpl {

    private final String CUSTOMER_ID = "customerId";
    private final String CREATOR_ID = "creatorId";
    private final String STATUS = "status";
    private final String STATUS_DATE = "statusDate";

    private final String STRING_SORTABLE = "_String_sortable";
    private final String NUMBER_SORTABLE = "_Number_sortable";
    private final String DATE_SORTABLE = "_Date_sortable";


    @Override
    public Document commonIndexer(Document doc,
                                  long customerId,
                                  long creatorId,
                                  String name,
                                  String desc,
                                  String status,
                                  Date statusDate) {

        doc.addKeyword(CUSTOMER_ID, customerId);
        doc.addKeyword(CREATOR_ID, creatorId);
        doc.addText(Field.NAME, name);
        doc.addText(Field.DESCRIPTION, desc);
        doc.addKeywordSortable(STATUS, status);
        doc.addDateSortable(STATUS_DATE, statusDate);

        return doc;
    }

    @Override
    public Document commonIndexer(Document doc,
                                  long customerId,
                                  long creatorId) {

        doc.addKeyword(CUSTOMER_ID, customerId);
        doc.addKeyword(CREATOR_ID, creatorId);

        return doc;
    }

    @Override
    public Document commonIndexer(Document doc,
                                  long customerId,
                                  long creatorId,
                                  String status,
                                  Date statusDate) {

        doc.addKeyword(CUSTOMER_ID, customerId);
        doc.addKeyword(CREATOR_ID, creatorId);
        doc.addKeywordSortable(STATUS, status);
        doc.addDateSortable(STATUS_DATE, statusDate);

        return doc;
    }

    @Override
    public Document commonIndexer(Document doc,
                                  long customerId,
                                  long creatorId,
                                  String name,
                                  String desc) {

        doc.addKeyword(CUSTOMER_ID, customerId);
        doc.addKeyword(CREATOR_ID, creatorId);
        doc.addText(Field.NAME, name);
        doc.addText(Field.DESCRIPTION, desc);

        return doc;
    }

    @Override
    public String getSortableFieldNameString(String field) {
        return StringBundler.concat(field, STRING_SORTABLE);
    }

    @Override
    public String getSortableFieldNameNumber(String field) {
        return StringBundler.concat(field, NUMBER_SORTABLE);
    }

    @Override
    public String getSortableFieldNameDate(String field) {
        return StringBundler.concat(field, DATE_SORTABLE);
    }
}