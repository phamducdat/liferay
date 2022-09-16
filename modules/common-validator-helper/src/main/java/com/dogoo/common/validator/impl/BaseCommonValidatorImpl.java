package com.dogoo.common.validator.impl;

import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.common.validator.api.CommonDataItemValidator;
import com.dogoo.common.validator.api.CommonValidatorHelper;

import java.util.Locale;

public abstract class BaseCommonValidatorImpl
        implements CommonValidatorHelper, CommonDataItemValidator {

    @Override
    public void isNotPopulated(Object value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void validatorDataItemExist(long dataItemId, Locale locale) throws DG_NoSuchEntryException {
        return;
    }

    @Override
    public void validatorDataItemExist(long dataItemId, String msg) throws DG_NoSuchEntryException { }

    @Override
    public void isNotPopulated(Boolean value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Byte value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(char value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Integer value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Long value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Float value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Double value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(String value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Enum value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Boolean[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Byte[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(char[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Integer[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Long[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Float[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Double[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(String[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Object[] value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void validateDataItemExist(long dataItemId, Locale locale) throws DG_NoSuchEntryException {

    }

    @Override
    public void validateDataItemExist(long dataItemId, String msg) throws DG_NoSuchEntryException {

    }

    @Override
    public void validateDepartmentExist(long departmentId, String msg) throws DG_NoSuchEntryException {

    }

    @Override
    public void validateDepartmentExist(long departmentId, Locale locale) throws DG_NoSuchEntryException {

    }
}
