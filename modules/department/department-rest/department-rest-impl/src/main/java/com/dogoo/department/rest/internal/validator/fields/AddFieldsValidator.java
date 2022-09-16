package com.dogoo.department.rest.internal.validator.fields;

import com.dogoo.common.exception.model.DG_FieldDuplicateException;
import com.dogoo.common.exception.model.DG_NameDuplicateException;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.internal.service.LanguageService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;
import java.util.Objects;

@Component(
        immediate = true,
        service = AddFieldsValidator.class)
public class AddFieldsValidator {

    public void validateForFieldsAdd(long customerId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_FieldDuplicateException {
        String type = department.getType().toString();
        if (Objects.equals(type, "company")) validateForFieldsAddCompany(customerId, department, locale);
        if (Objects.equals(type, "branch")) validateForFieldsAddBranch(customerId, department, locale);
        if (Objects.equals(type, "unit")) validateForFieldsAddUnit(customerId, department, locale);
        if (Objects.equals(type, "department")) validateForFieldsAddDepartment(customerId, department, locale);
    }

    private void validateForFieldsAddCompany(long customerId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_FieldDuplicateException {
        validateForFieldsAddBaseCompanyAndBranch(customerId, department, locale);
    }

    private void validateForFieldsAddBranch(long customerId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_FieldDuplicateException {
        validateForFieldsAddBaseCompanyAndBranch(customerId, department, locale);

    }

    private void validateForFieldsAddUnit(long customerId, Department department, Locale locale)
            throws DG_FieldDuplicateException, DG_NameDuplicateException {

//        validateForNameAdd(customerId, department, locale);
        validateForCodeAdd(customerId, department, locale);


    }

    private void validateForFieldsAddDepartment(long customerId, Department department, Locale locale)
            throws DG_FieldDuplicateException, DG_NameDuplicateException {

//        validateForNameAdd(customerId, department, locale);
        validateForCodeAdd(customerId, department, locale);


    }

    private void validateForFieldsAddBaseCompanyAndBranch(long customerId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_FieldDuplicateException {
//        validateForNameAdd(customerId, department, locale);
        validateForTaxAdd(customerId, department, locale);
        validateForCodeAdd(customerId, department, locale);
    }

    private void validateForNameAdd(long customerId,
                                    Department department,
                                    Locale locale) throws DG_NameDuplicateException {
        DepartmentEntry entry = _localService.fetchDepartmentEntryByName(customerId, department.getName());

        if (Validator.isNull(entry)) return;

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_NAME_DUPLICATE));
    }


    private void validateForTaxAdd(long customerId,
                                   Department department,
                                   Locale locale) throws DG_FieldDuplicateException {
        DepartmentEntry entry = _localService.fetchDepartmentEntryByTax(customerId, department.getTax());

        if (Validator.isNull(entry)) return;

        throw new DG_FieldDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_TAX_DUPLICATE));
    }

    private void validateForCodeAdd(long customerId,
                                    Department department,
                                    Locale locale) throws DG_FieldDuplicateException {
        DepartmentEntry entry = _localService.fetchDepartmentEntryByCode(customerId, department.getCode());

        if (Validator.isNull(entry)) return;

        throw new DG_FieldDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_CODE_DUPLICATE));

    }

    @Reference
    private DepartmentEntryLocalService _localService;

    @Reference
    private LanguageService _languageService;

}
