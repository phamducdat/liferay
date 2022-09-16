package com.dogoo.common.validator.api;

import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Locale;

/**
 * @author khoa
 */

@ProviderType
public interface CommonValidatorHelper {

    void isNotPopulated(Boolean value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Byte value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(char value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Integer value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Long value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Float value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Double value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(String value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Enum value, String errorMsgKey) throws DG_FieldRequiredException;


    void isNotPopulated(Object value, String errorMsgKey) throws DG_FieldRequiredException;





    void isNotPopulated(Boolean[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Byte[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(char[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Integer[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Long[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Float[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Double[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(String[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void isNotPopulated(Object[] value, String errorMsgKey) throws DG_FieldRequiredException;

    void validateDataItemExist(long dataItemId, Locale locale) throws DG_NoSuchEntryException;

    void validateDataItemExist(long dataItemId, String msg) throws DG_NoSuchEntryException;

    void validateDepartmentExist(long departmentId, String msg) throws DG_NoSuchEntryException;

    void validateDepartmentExist(long departmentId, Locale locale) throws DG_NoSuchEntryException;




}