package com.dogoo.common.files.manager.service.internal.search.query.contributor;

import com.dogoo.common.files.manager.service.constant.SearchField;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.DGFILE_MANAGER_INDEXER_CLASS,
        service = KeywordQueryContributor.class
)
public class DGFileManagerEntryKeywordQueryContributor implements KeywordQueryContributor{
    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {

        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.CUSTOMER_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FILE_MANAGER_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FILE_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.CREATOR_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FILE_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.PARENT_CODE, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FILE_TYPE, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.TYPE, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.PK_TYPE, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FILE_NAME, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FILE_SIZE, true);
    }

    @Reference
    protected QueryHelper queryHelper;

}