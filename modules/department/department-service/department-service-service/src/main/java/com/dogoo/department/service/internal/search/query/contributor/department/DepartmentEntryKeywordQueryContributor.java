package com.dogoo.department.service.internal.search.query.contributor.department;


import com.dogoo.department.service.constant.SearchFields;
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
        property = SearchFields.DEPARTMENT_INDEXER_CLASS,
        service = KeywordQueryContributor.class
)
public class DepartmentEntryKeywordQueryContributor implements KeywordQueryContributor{
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
                booleanQuery, searchContext, SearchFields.TYPE, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.DESCRIPTION, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.CODE, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.ALIAS, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.TAX, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.ADDRESS, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.HEAD_OFFICE, true);


    }


    @Reference
    protected QueryHelper queryHelper;
}
