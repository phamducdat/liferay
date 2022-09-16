package com.dogoo.common.files.manager.service.internal.retriever;

import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.mapper.model.FileManagerMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.dogoo.common.files.manager.service.retriver.DGFileManagerRetriever;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.search.aggregation.Aggregations;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.searcher.*;
import com.liferay.portal.search.sort.FieldSort;
import com.liferay.portal.search.sort.SortOrder;
import com.liferay.portal.search.sort.Sorts;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component(
        scope = ServiceScope.PROTOTYPE, service = DGFileManagerRetriever.class
)
public class DGFileManagerRetrieverImpl implements DGFileManagerRetriever {

    private final String PATTERN = "yyyyMMddHHmmss";
    SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);

    @Override
    public List<FileManagerMapperModel> getAllDGFileManagerByPKType(long customerId,
                                                                    String parentCode,
                                                                    String pkType) {
        SearchResponse searchResponse = _searcher.search(
                _getSearchRequest(
                        customerId,
                        parentCode,
                        pkType));

        List<FileManagerMapperModel> list = new ArrayList<>();

        SearchHits searchHits = searchResponse.getSearchHits();

        searchHits.getSearchHits().stream().forEach(searchHit -> {
            list.add(_mapper.mapperFileManagerMapperModel(
                    Long.parseLong(searchHit.getDocument().getFields().get(SearchField.FILE_ID).getValue().toString()),
                    searchHit.getDocument().getFields().get(SearchField.PARENT_CODE).getValue().toString(),
                    searchHit.getDocument().getFields().get(SearchField.FILE_TYPE).getValue().toString(),
                    searchHit.getDocument().getFields().containsKey(SearchField.TYPE)?
                            searchHit.getDocument().getFields().get(SearchField.TYPE).getValue().toString() : "",
                    searchHit.getDocument().getFields().containsKey(SearchField.PK_TYPE) ?
                            searchHit.getDocument().getFields().get(SearchField.PK_TYPE).getValue().toString() : "",
                    searchHit.getDocument().getFields().get(SearchField.FILE_NAME).getValue().toString(),
                    searchHit.getDocument().getFields().get(SearchField.FILE_SIZE).getValue().toString()));
        });

        return list;
    }

    @Override
    public List<Long> getAllFileId(long customerId, String parentCode) {

        SearchResponse searchResponse = _searcher.search(
                _getSearchRequest(
                        customerId,
                        parentCode));

        List<Long> list = new ArrayList<>();

        SearchHits searchHits = searchResponse.getSearchHits();

        searchHits.getSearchHits().stream().forEach(searchHit -> {
            list.add(
                    Long.parseLong(searchHit.getDocument().getFields().get(SearchField.FILE_ID).getValue().toString()));
        });

        return list;

    }

    @Override
    public List<FileManagerMapperModel> getAllDGFileManager(long customerId, String parentCode) {

        SearchResponse searchResponse = _searcher.search(
                _getSearchRequest(
                        customerId,
                        parentCode));

        List<FileManagerMapperModel> list = new ArrayList<>();

        SearchHits searchHits = searchResponse.getSearchHits();

        searchHits.getSearchHits().stream().forEach(searchHit -> {
            list.add(_mapper.mapperFileManagerMapperModel(
                    Long.parseLong(searchHit.getDocument().getFields().get(SearchField.FILE_ID).getValue().toString()),
                    searchHit.getDocument().getFields().get(SearchField.PARENT_CODE).getValue().toString(),
                    searchHit.getDocument().getFields().get(SearchField.FILE_TYPE).getValue().toString(),
                    searchHit.getDocument().getFields().containsKey(SearchField.TYPE)?
                            searchHit.getDocument().getFields().get(SearchField.TYPE).getValue().toString() : "",
                    searchHit.getDocument().getFields().containsKey(SearchField.PK_TYPE) ?
                            searchHit.getDocument().getFields().get(SearchField.PK_TYPE).getValue().toString() : "",
                    searchHit.getDocument().getFields().get(SearchField.FILE_NAME).getValue().toString(),
                    searchHit.getDocument().getFields().get(SearchField.FILE_SIZE).getValue().toString()));
        });

        return list;

    }

    private SearchRequest _getSearchRequest(long customerId,
                                            String parentCode,
                                            String pkType) {

        SearchRequestBuilder searchRequestBuilder =
                _searchRequestBuilderFactory.builder();

        MatchQuery matchQuery = queries.match(Field.ENTRY_CLASS_NAME, DGFileManagerEntry.class.getName());

        MatchQuery matchQueryCustomer = queries.match(SearchField.CUSTOMER_ID,customerId);

        MatchQuery matchQueryParent= queries.match(SearchField.PARENT_CODE,parentCode);
        MatchQuery matchQueryPkType = queries.match(SearchField.PK_TYPE,pkType);

        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQuery , matchQueryCustomer , matchQueryParent , matchQueryPkType);

        SortOrder sortOrder = SortOrder.ASC;

        FieldSort fieldSort = _sorts.field(
                "createDate_sortable",
                sortOrder);

        searchRequestBuilder.entryClassNames(
                DGFileManagerEntry.class.getName()
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).sorts(fieldSort
        ).withSearchContext(
                searchContext -> _populateSearchContext(
                        searchContext)
        );

        return searchRequestBuilder.build();
    }

    private SearchRequest _getSearchRequest(long customerId,
                                            String parentCode) {

        SearchRequestBuilder searchRequestBuilder =
                _searchRequestBuilderFactory.builder();

        MatchQuery matchQuery = queries.match(Field.ENTRY_CLASS_NAME, DGFileManagerEntry.class.getName());

        MatchQuery matchQueryCustomer = queries.match(SearchField.CUSTOMER_ID,customerId);

        MatchQuery matchQueryParent = queries.match(SearchField.PARENT_CODE,parentCode);

        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQuery , matchQueryCustomer , matchQueryParent );

        SortOrder sortOrder = SortOrder.ASC;

        FieldSort fieldSort = _sorts.field(
                "createDate_sortable",
                sortOrder);

        searchRequestBuilder.entryClassNames(
                DGFileManagerEntry.class.getName()
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).sorts(fieldSort
        ).withSearchContext(
                searchContext -> _populateSearchContext(
                        searchContext)
        );

        return searchRequestBuilder.build();
    }

    private SearchRequest _getSearchRequestParent(long customerId,
                                            String parentCode) {

        SearchRequestBuilder searchRequestBuilder =
                _searchRequestBuilderFactory.builder();

        MatchQuery matchQuery = queries.match(Field.ENTRY_CLASS_NAME, DGFileManagerEntry.class.getName());

        MatchQuery matchQueryCustomer = queries.match(SearchField.CUSTOMER_ID,customerId);

        MatchQuery matchQueryParent = queries.match(SearchField.PARENT_CODE,parentCode);

        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQuery , matchQueryCustomer , matchQueryParent );

        SortOrder sortOrder = SortOrder.ASC;

        FieldSort fieldSort = _sorts.field(
                "createDate_sortable",
                sortOrder);

        searchRequestBuilder.entryClassNames(
                DGFileManagerEntry.class.getName()
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).sorts(fieldSort
        ).withSearchContext(
                searchContext -> _populateSearchContext(
                        searchContext)
        );

        return searchRequestBuilder.build();
    }

    private void _populateSearchContext(
            SearchContext searchContext) {

        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());

    }

    @Reference
    protected Queries queries;

    @Reference
    private Aggregations _aggregations;

    @Reference
    private Searcher _searcher;
    @Reference
    private SearchRequestBuilderFactory _searchRequestBuilderFactory;

    @Reference
    private Sorts _sorts;

    @Reference
    private DGFileManagerMapper _mapper;

}
