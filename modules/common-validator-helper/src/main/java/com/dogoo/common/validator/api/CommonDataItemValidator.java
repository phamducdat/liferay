package com.dogoo.common.validator.api;

import com.dogoo.common.exception.model.DG_DataInputException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Locale;

@ProviderType
public interface CommonDataItemValidator {
    void validatorDataItemExist(long dataItemId, Locale locale) throws DG_NoSuchEntryException;

    void validatorDataItemExist(long dataItemId, String msg) throws DG_NoSuchEntryException;

    void validatorDataItemExist(long dataItemId,String type, String msg) throws DG_NoSuchEntryException, DG_DataInputException;
}
