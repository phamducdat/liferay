package com.dogoo.dataitems.service.internal.search.query.contributor;

import com.dogoo.dataitems.service.constant.SearchFields;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.DATA_ITEM_INDEXER_CLASS,
        service = KeywordQueryContributor.class
)
public class DataItemEntryKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(String keywords,
                           BooleanQuery booleanQuery,
                           KeywordQueryContributorHelper keywordQueryContributorHelper) {

        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.NAME, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.DESCRIPTION, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.LOCATION_TITLE, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.LOCATION_WARD, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.LOCATION_DISTRICT, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.LOCATION_PROVINCE, true);
    }

    @Reference
    protected QueryHelper queryHelper;

}
