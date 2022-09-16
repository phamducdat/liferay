package com.dogoo.department.service.internal.search.indexer.contributor.department;

import com.dogoo.common.lib.api.CommonConstants;
import com.dogoo.common.util.api.CommonUtil;
import com.dogoo.department.service.constant.SearchFields;
import com.dogoo.department.service.model.DepartmentEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.DEPARTMENT_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class DepartmentEntryModelDocumentContributor implements
        ModelDocumentContributor<DepartmentEntry> {
    @Override
    public void contribute(Document document, DepartmentEntry baseModel) {
        document.addKeyword(SearchFields.CUSTOMER_ID, Long.toString(baseModel.getCustomerId()));
        document.addKeyword(SearchFields.CREATOR_ID, Long.toString(baseModel.getCreatorId()));

        document.addText(SearchFields.TYPE, baseModel.getType());
        document.addKeywordSortable(SearchFields.TYPE, baseModel.getType());

        document.addText(SearchFields.NAME, commonUtil.vnNormalize(baseModel.getName()));
        document.addKeywordSortable(SearchFields.NAME, commonUtil.vnNormalize(baseModel.getName()));

        document.addText(SearchFields.DESCRIPTION, baseModel.getDescription());
        document.addKeywordSortable(SearchFields.DESCRIPTION, baseModel.getDescription());

        document.addText(SearchFields.CODE, baseModel.getCode());
        document.addKeywordSortable(SearchFields.CODE, baseModel.getCode());

        document.addText(SearchFields.ALIAS, baseModel.getAlias());
        document.addKeywordSortable(SearchFields.ALIAS, baseModel.getAlias());

        document.addText(SearchFields.ADDRESS, baseModel.getAlias());
        document.addKeywordSortable(SearchFields.ADDRESS, baseModel.getAlias());

        document.addText(SearchFields.TAX, baseModel.getTax());
        document.addKeywordSortable(SearchFields.TAX, baseModel.getTax());

        document.addText(SearchFields.HEAD_OFFICE, baseModel.getHeadOffice());
        document.addKeywordSortable(SearchFields.HEAD_OFFICE, baseModel.getHeadOffice());

        document.addKeywordSortable(CommonConstants.EXTERNAL_REFERENCE_CODE, baseModel.getExternalReferenceCode());

        document.addNumberSortable(SearchFields.PARENT_ID, baseModel.getParentId());

    }

    @Reference
    CommonUtil commonUtil;
}
