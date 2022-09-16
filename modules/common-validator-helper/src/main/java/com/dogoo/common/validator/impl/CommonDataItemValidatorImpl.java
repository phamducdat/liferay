package com.dogoo.common.validator.impl;

import com.dogoo.common.exception.model.DG_DataInputException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.common.language.api.CommonLanguageHelper;
import com.dogoo.common.validator.api.CommonDataItemValidator;
import com.dogoo.common.validator.util.LanguageKeys;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Locale;

@Component(
        scope = ServiceScope.PROTOTYPE, service = CommonDataItemValidator.class
)
public class CommonDataItemValidatorImpl extends BaseCommonValidatorImpl {

    @Override
    public void validatorDataItemExist(long dataItemId, Locale locale) throws DG_NoSuchEntryException {

        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        if (Validator.isNotNull(entry)) { return; }

        throw new DG_NoSuchEntryException(_languageHelper.getMessage(locale, LanguageKeys.DATA_ITEM_NOT_FOUND));
    }

    @Override
    public void validatorDataItemExist(long dataItemId, String msg) throws DG_NoSuchEntryException {
        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        if (Validator.isNotNull(entry)) { return; }

        throw new DG_NoSuchEntryException(msg);
    }

    @Override
    public void validatorDataItemExist(long dataItemId, String type, String msg)
            throws DG_DataInputException,
            DG_NoSuchEntryException {
        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        if(Validator.isNull(entry))
        {
            throw new DG_NoSuchEntryException(msg);
        }
        else {
            if ( !entry.getType().equals(type)) {
                throw new DG_DataInputException(msg);
            }
        }

    }

    @Reference
    private DataItemEntryLocalService _dataItemEntryLocalService;

    @Reference
    private CommonLanguageHelper _languageHelper;

}
