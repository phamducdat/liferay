package com.dogoo.common.indexer.helper.api;

import com.liferay.portal.kernel.search.Document;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;


/**
 * @author khoa
 */

@ProviderType
public interface CommonIndexerHelper {

    Document commonIndexer(Document doc,
                           long customerId,
                           long creatorId,
                           String name,
                           String desc,
                           String status,
                           Date statusDate);

    Document commonIndexer(Document doc,
                           long customerId,
                           long creatorId);

    Document commonIndexer(Document doc,
                           long customerId,
                           long creatorId,
                           String status,
                           Date statusDate);

    Document commonIndexer(Document doc,
                           long customerId,
                           long creatorId,
                           String name,
                           String desc);

    String getSortableFieldNameString(String field);

    String getSortableFieldNameNumber(String field);

    String getSortableFieldNameDate(String field);


}