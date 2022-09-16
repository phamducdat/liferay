package com.dogoo.common.auditing.rest.internal.service;

import com.dogoo.common.auditing.rest.dto.v2_0.Auditing;
import com.dogoo.common.auditing.rest.internal.mapper.AuditingMapper;
import com.dogoo.common.auditing.service.constant.ClassName;
import com.dogoo.common.auditing.service.retriever.AuditingRetriever;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

@Component(
        immediate = true,
        service = AuditingService.class
)
public class AuditingService {
    public Page<Auditing> getAuditingPages(long customerId,
                                           Long classPkId,
                                           String classPkName,
                                           Date startDate,
                                           Date endDate,
                                           Filter filter,
                                           ServiceContext serviceContext) throws SearchException, ParseException {

        Document[] documents = _retriever.getAuditings(
                customerId,
                classPkId,
                ClassName.valueOf(classPkName.toUpperCase()).getClassName(),
                startDate,
                endDate,
                filter,
                serviceContext);


        List<Auditing> results = _mapper.mapDocumentsToDTO(documents);

        return Page.of(results, Pagination.of(1, results.size()), results.size());
    }

    @Reference
    private AuditingMapper _mapper;

    @Reference
    private AuditingRetriever _retriever;
}
