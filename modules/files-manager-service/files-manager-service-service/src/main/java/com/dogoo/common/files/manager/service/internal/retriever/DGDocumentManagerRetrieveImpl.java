package com.dogoo.common.files.manager.service.internal.retriever;


import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.retriver.DGDocumentManagerRetrieve;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Component(
        scope = ServiceScope.PROTOTYPE,
        service = DGDocumentManagerRetrieve.class
)
public class DGDocumentManagerRetrieveImpl implements DGDocumentManagerRetrieve {

    public static final String FILE_TYPE = "file";

    @Override
    public long getFolderSize(long customerId, long documentId) {

        Document[] files = getAllFilesInFolder(customerId, documentId);

        AtomicLong size = new AtomicLong(0);

        Arrays.stream(files).forEach(file -> {

            DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(GetterUtil.getLong(file.get(SearchField.FILE_ID)));

            size.set(size.get() + dlFileEntry.getSize());
        });

        return size.get();
    }

    public Document[] getAllFilesInFolder(long customerId, long documentId) {

        SearchContext searchContext = getSearchContext();

        BooleanQuery booleanQuery = buildQuery(customerId);

        BooleanFilter booleanFilter = booleanQuery.getPreBooleanFilter();

        TermFilter typeTermFilter = new TermFilter(SearchField.TYPE, FILE_TYPE);

        TermFilter documentTermFilter = new TermFilter(SearchField.PATH, String.valueOf(documentId));

        booleanFilter.add(typeTermFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(documentTermFilter, BooleanClauseOccur.MUST);

        try {
            Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

            return hits.getDocs();
        } catch (SearchException e) {
            throw new RuntimeException(e);
        }
    }

    private BooleanQuery buildQuery(long customerId) {

        BooleanQuery booleanQuery = new BooleanQueryImpl();

        TermFilter customerIdFilter = new TermFilter(SearchField.CUSTOMER_ID, String.valueOf(customerId));

        TermFilter entryClassNameTermFilter = new TermFilter(Field.ENTRY_CLASS_NAME, DGDocumentManagerEntry.class.getName());

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);

        booleanFilter.add(entryClassNameTermFilter, BooleanClauseOccur.MUST);

        booleanQuery.setPreBooleanFilter(booleanFilter);

        return booleanQuery;
    }

    private SearchContext getSearchContext() {

        SearchContext searchContext = new SearchContext();

        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());

        return searchContext;
    }

    @Reference
    DLFileEntryLocalService _dlFileEntryLocalService;
}
