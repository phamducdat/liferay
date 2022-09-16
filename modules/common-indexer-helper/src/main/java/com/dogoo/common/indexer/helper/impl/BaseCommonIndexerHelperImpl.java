package com.dogoo.common.indexer.helper.impl;

import com.dogoo.common.indexer.helper.api.CommonIndexerHelper;
import com.liferay.portal.kernel.search.Document;

import java.util.Date;

public class BaseCommonIndexerHelperImpl implements CommonIndexerHelper {
    @Override
    public Document commonIndexer(Document doc, long customerId, long creatorId, String name, String desc, String status, Date statusDate) {
        return null;
    }

    @Override
    public Document commonIndexer(Document doc, long customerId, long creatorId) {
        return null;
    }

    @Override
    public Document commonIndexer(Document doc, long customerId, long creatorId, String status, Date statusDate) {
        return null;
    }

    @Override
    public Document commonIndexer(Document doc, long customerId, long creatorId, String name, String desc) {
        return null;
    }

    @Override
    public String getSortableFieldNameString(String field) {
        return null;
    }

    @Override
    public String getSortableFieldNameNumber(String field) {
        return null;
    }

    @Override
    public String getSortableFieldNameDate(String field) {
        return null;
    }
}
