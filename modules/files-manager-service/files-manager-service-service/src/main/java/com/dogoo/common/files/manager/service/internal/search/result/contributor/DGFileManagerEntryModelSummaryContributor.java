package com.dogoo.common.files.manager.service.internal.search.result.contributor;

import com.dogoo.common.files.manager.service.constant.SearchField;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchField.DGFILE_MANAGER_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class DGFileManagerEntryModelSummaryContributor implements ModelSummaryContributor{
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(SearchField.CUSTOMER_ID),
                document.get(SearchField.FILE_MANAGER_ID));

        summary.setMaxContentLength(200);

        return summary;
    }
}
