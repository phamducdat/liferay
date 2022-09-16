package com.dogoo.dataitems.rest.internal.service;

import com.dogoo.dataitems.rest.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.internal.mapper.DataItemMapper;
import com.dogoo.dataitems.service.constant.SearchFields;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component(immediate = true, service = DataItemService.class)
public class DataItemService {

    public Page<DataItem> getDataItemsByParentCodePage(Integer sibling,
                                                       long customerId,
                                                       String type,
                                                       long parentId,
                                                       ServiceContext serviceContext) throws Exception {

        return  getDataItemWithSibling(customerId,
                type,
                sibling,
                parentId,
                serviceContext);

    }

    public Page<DataItem>  getDataItemWithSibling(long customerId,
                                                  String type,
                                                  Integer sibling,
                                                  long parentId ,
                                                  ServiceContext serviceContext) throws Exception {
        Page<DataItem> page = searchAllByType(
                sibling,
                customerId,
                parentId,
                type,
                serviceContext);
        if(Validator.isNotNull(sibling)){
          page = Page.of(buildTree(page,GetterUtil.DEFAULT_LONG,sibling, GetterUtil.DEFAULT_INTEGER)) ;
        }

        return page ;
    }

    public List<DataItem> buildTree(Page<DataItem> page , long parentId, Integer sibling,Integer levelId){
        List<DataItem> list = new ArrayList<>();
        if(page.getTotalCount() != 0 && !page.getItems().isEmpty()) {
            page.getItems().stream().forEach(dataItem -> {
                if (Objects.equals(dataItem.getParentId(), parentId) && (levelId <= sibling )) {
                    list.add(dataItem);
                  List<DataItem> child =
                          buildTree(page, dataItem.getId() , sibling, (levelId +1));
                  dataItem.setDataItems(_dataItemMapper.mapListDataToArray(child));
                }

            });
        }
        return list ;

    }

    private final int CUSTOMER_GLOBAL = 0;

    private final String BONUS_METHOD = "BONUS_METHOD";

    private final String REPRIMAND_METHOD = "REPRIMAND_METHOD";

    private final String RECEIPT_PROCEDURES = "RECEIPT_PROCEDURES";

    private final String SEVERANCE_PROCEDURES = "SEVERANCE_PROCEDURES";


    private Page<DataItem> searchAllByType(Integer sibling,
                                           long customerId,
                                           long parentId,
                                           String type,
                                           ServiceContext serviceContext) throws Exception {


        String search = StringPool.BLANK;
        Sort[] sorts = new Sort[] {new Sort( SearchFields.getNumberSortable(SearchFields.ORDER), false)};
        Pagination pagination = Pagination.of(1, 2500);

        return  SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {

                    BooleanFilter booleanFilterCustomer = new BooleanFilter();

                    TermFilter customerIdFilter =
                            new TermFilter(SearchFields.CUSTOMER_ID, String.valueOf(customerId));

                    if (!type.equals(BONUS_METHOD) &&
                            !type.equals(REPRIMAND_METHOD) &&
                            !type.equals(RECEIPT_PROCEDURES) &&
                            !type.equals(SEVERANCE_PROCEDURES)) {

                        TermFilter customerIdGlobalFilter =
                                new TermFilter(SearchFields.CUSTOMER_ID, String.valueOf(CUSTOMER_GLOBAL));

                        booleanFilterCustomer.add(customerIdGlobalFilter, BooleanClauseOccur.SHOULD);
                    }

                    booleanFilterCustomer.add(customerIdFilter, BooleanClauseOccur.SHOULD);

                    TermFilter typeFilter =
                            new TermFilter(Field.TYPE, type);

                    TermFilter parentFilter =
                            new TermFilter(SearchFields.PARENT_ID, String.valueOf(parentId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(booleanFilterCustomer, BooleanClauseOccur.MUST);
                    booleanFilter.add(typeFilter, BooleanClauseOccur.MUST);

                    if(Validator.isNull(sibling) || sibling < GetterUtil.DEFAULT_INTEGER ) {
                        booleanFilter.add(parentFilter, BooleanClauseOccur.MUST);
                    }

                },
                null,
                DataItemEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long dataItemId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _dataItemMapper.mapDataItemFromDataItemEntry(
                            _dataItemEntryLocalService.getDataItemEntry(dataItemId));
                });
    }

    public DataItem addDataItem(long customerId,
                                long creatorId,
                                DataItem dataItem,
                                ServiceContext serviceContext) {

        DataItemEntry entry =
                _dataItemEntryLocalService.addDataItem(
                        customerId,
                        creatorId,
                        dataItem.getName(),
                        dataItem.getDescription(),
                        dataItem.getType(),
                        GetterUtil.getInteger(dataItem.getOrder(), GetterUtil.DEFAULT_INTEGER) ,
                        GetterUtil.getLong(dataItem.getParentId(), GetterUtil.DEFAULT_INTEGER),
                        serviceContext);

        return _dataItemMapper.mapDataItemFromDataItemEntry(entry);
    }

    public DataItem updateDataItem(long creatorId,
                                   long dataItemId,
                                   DataItem dataItem,
                                   ServiceContext serviceContext)
            throws PortalException {

        DataItemEntry entry =
                _dataItemEntryLocalService.updateDataItem(
                        creatorId,
                        dataItemId,
                        dataItem.getName(),
                        dataItem.getDescription(),
                        dataItem.getType(),
                        GetterUtil.getInteger(dataItem.getOrder(), 0) ,
                        GetterUtil.getLong(dataItem.getParentId(), 0),
                        serviceContext);

        return _dataItemMapper.mapDataItemFromDataItemEntry(entry);
    }

    public DataItem getDataItemById(long dataItemId) {
        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        return _dataItemMapper.mapDataItemFromDataItemEntry(entry);
    }

    public void deleteDataItemById(long dataItemId) throws PortalException {
        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        if (entry.isIsDefaultValue()) {
            return;
        }

        _dataItemEntryLocalService.deleteDataItemEntry(dataItemId);
    }

    @Reference
    DataItemMapper _dataItemMapper;

    @Reference
    DataItemEntryLocalService _dataItemEntryLocalService;
}
