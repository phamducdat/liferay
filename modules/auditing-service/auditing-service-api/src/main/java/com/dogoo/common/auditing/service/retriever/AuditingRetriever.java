package com.dogoo.common.auditing.service.retriever;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;

@ProviderType
public interface AuditingRetriever {

    Document[] getAuditings(long customerId, long classPKId, String classPkName, Date startDate, Date endDate, Filter filter, ServiceContext serviceContext) throws SearchException, ParseException;
}
