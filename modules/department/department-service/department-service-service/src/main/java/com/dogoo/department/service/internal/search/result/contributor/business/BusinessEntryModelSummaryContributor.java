package com.dogoo.department.service.internal.search.result.contributor.business;


import com.dogoo.department.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchFields.BUSINESS_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class BusinessEntryModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(Document document,
                              Locale locale,
                              String snippet) {

        Summary summary = new Summary(
                document.get(Field.NAME),
                document.get(Field.DESCRIPTION));

        summary.setMaxContentLength(200);

        return summary;
    }
}
