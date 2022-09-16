package com.dogoo.common.validator.impl;

import com.dogoo.common.exception.model.DG_DataInputException;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.common.language.api.CommonLanguageHelper;
import com.dogoo.common.language.constant.LanguageKeys;
import com.dogoo.common.validator.api.CommonValidatorHelper;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.io.Serializable;
import java.util.Locale;

@Component(
        scope = ServiceScope.PROTOTYPE, service = CommonValidatorHelper.class
)
public class CommonValidatorHelperImpl extends BaseCommonValidatorImpl {


    @Override
    public void isNotPopulated(Boolean value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);
    }

    @Override
    public void isNotPopulated(Byte value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(char value, String errorMsgKey) throws DG_FieldRequiredException {

    }

    @Override
    public void isNotPopulated(Integer value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Long value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Float value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Double value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(String value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);

        if (Validator.isNotNull(value)) {
            return;
        }

        throw new DG_FieldRequiredException(errorMsgKey);
    }

    @Override
    public void isNotPopulated(Enum value, String errorMsgKey) throws DG_FieldRequiredException {
        baseIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Object value, String errorMsgKey) throws DG_FieldRequiredException {
        if (null != value) return;
        throw new DG_FieldRequiredException(errorMsgKey);
    }

    @Override
    public void isNotPopulated(Boolean[] value, String errorMsgKey) throws DG_FieldRequiredException {
        baseArrayIsNotPopulated(value, errorMsgKey);
    }

    @Override
    public void isNotPopulated(Byte[] value, String errorMsgKey) throws DG_FieldRequiredException {
        baseArrayIsNotPopulated(value, errorMsgKey);

    }


    @Override
    public void isNotPopulated(Integer[] value, String errorMsgKey) throws DG_FieldRequiredException {
        baseArrayIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Long[] value, String errorMsgKey) throws DG_FieldRequiredException {
        baseArrayIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Float[] value, String errorMsgKey) throws DG_FieldRequiredException {
        baseArrayIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Double[] value, String errorMsgKey) throws DG_FieldRequiredException {
        baseArrayIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(String[] value, String errorMsgKey) throws DG_FieldRequiredException {
        baseArrayIsNotPopulated(value, errorMsgKey);

    }

    @Override
    public void isNotPopulated(Object[] values, String errorMsgKey) throws DG_FieldRequiredException {
        if (values == null) throw new DG_FieldRequiredException(errorMsgKey);
    }

    @Override
    public void validateDataItemExist(long dataItemId, Locale locale) throws DG_NoSuchEntryException {
        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        if (Validator.isNotNull(entry)) { return; }

        throw new DG_NoSuchEntryException(_languageHelper.getMessage(locale, LanguageKeys.DATA_ITEM_NOT_FOUND));
    }

    @Override
    public void validateDataItemExist(long dataItemId, String msg) throws DG_NoSuchEntryException {
        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        if (Validator.isNotNull(entry)) { return; }

        throw new DG_NoSuchEntryException(msg);

    }

    @Override
    public void validateDepartmentExist(long departmentId, String msg) throws DG_NoSuchEntryException {
        DepartmentEntry entry = _departmentEntryLocalService.fetchDepartmentEntry(departmentId);

        if (Validator.isNotNull(entry)) { return; }

        throw new DG_NoSuchEntryException(msg);
    }

    @Override
    public void validateDepartmentExist(long departmentId, Locale locale) throws DG_NoSuchEntryException {
        DepartmentEntry entry = _departmentEntryLocalService.fetchDepartmentEntry(departmentId);

        if (Validator.isNotNull(entry)) { return; }

        throw new DG_NoSuchEntryException(_languageHelper.getMessage(locale, LanguageKeys.DEPARTMENT_NOT_FOUND));

    }
    @Override
    public void validatorDataItemExist(long dataItemId,
                                       String type,
                                       String msg) throws DG_NoSuchEntryException, DG_DataInputException {
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

    private void baseArrayIsNotPopulated(Serializable[] values, String errorMsgKey) throws DG_FieldRequiredException {
        if (null == values)
            throw new DG_FieldRequiredException(errorMsgKey);
    }

    private void baseIsNotPopulated(Serializable value,
                                    String errorMsgKey) throws DG_FieldRequiredException {
        if (null == value || value.toString().trim().isEmpty()) {
            throw new DG_FieldRequiredException(errorMsgKey);
        }
    }


    @Reference
    private DataItemEntryLocalService _dataItemEntryLocalService;

    @Reference
    private DepartmentEntryLocalService _departmentEntryLocalService;

    @Reference
    private CommonLanguageHelper _languageHelper;


}
