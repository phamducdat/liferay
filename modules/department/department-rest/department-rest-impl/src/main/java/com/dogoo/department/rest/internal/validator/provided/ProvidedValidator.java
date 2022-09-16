package com.dogoo.department.rest.internal.validator.provided;

import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.validator.api.CommonValidatorHelper;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.internal.service.LanguageService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;
import java.util.Objects;

@Component(
        immediate = true,
        service = ProvidedValidator.class
)
public class ProvidedValidator {
    public void validateProvided(Department department, Locale locale) throws DG_FieldRequiredException {
        _validatorHelper.isNotPopulated(department.getType(), _languageService.getMessage(
                locale,
                LanguageKeys.DEPARTMENT_ENTRY_TYPE_NOT_PROVIDED));
        String type = department.getType().toString();
        if (Objects.equals(type, "company")) validateProvidedForCompany(department, locale);
        if (Objects.equals(type, "branch")) validateProvidedForBranch(department, locale);
        if (Objects.equals(type, "unit")) validateProvidedForUnit(department, locale);
        if (Objects.equals(type, "department")) validateProvidedForDepartment(department, locale);
    }

    private void validateProvidedForCompany(Department department, Locale locale) throws DG_FieldRequiredException {
        validateProvidedForBaseCompanyAndBranch(department, locale);
    }

    private void validateProvidedForBranch(Department department, Locale locale) throws DG_FieldRequiredException {

        validateProvidedForBaseCompanyAndBranch(department, locale);

        _validatorHelper.isNotPopulated(department.getBusinessId(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_BUSINESS_NOT_PROVIDED));

        _validatorHelper.isNotPopulated(department.getParentId(),
                _languageService.getMessage(locale,
                        LanguageKeys.DEPARTMENT_ENTRY_PARENT_NOT_PROVIDED));

    }

    private void validateProvidedForUnit(Department department, Locale locale) throws
            DG_FieldRequiredException {
        _validatorHelper.isNotPopulated(department.getName(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_NAME_NOT_PROVIDED));
        _validatorHelper.isNotPopulated(department.getBusinessId(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_BUSINESS_NOT_PROVIDED));

        if (department.getParentId() == 0) return;
        _validatorHelper.isNotPopulated(department.getParentId(),
                _languageService.getMessage(locale,
                        LanguageKeys.DEPARTMENT_ENTRY_PARENT_NOT_PROVIDED));

    }

    private void validateProvidedForDepartment(Department department, Locale locale) throws DG_FieldRequiredException {
        _validatorHelper.isNotPopulated(department.getName(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_NAME_NOT_PROVIDED));

        _validatorHelper.isNotPopulated(department.getBusinessId(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_BUSINESS_NOT_PROVIDED));

        if (department.getParentId() == 0) return;
        _validatorHelper.isNotPopulated(department.getParentId(),
                _languageService.getMessage(locale,
                        LanguageKeys.DEPARTMENT_ENTRY_PARENT_NOT_PROVIDED));
    }


    private void validateProvidedForBaseCompanyAndBranch(Department department, Locale locale)
            throws DG_FieldRequiredException {

        _validatorHelper.isNotPopulated(department.getName(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_NAME_NOT_PROVIDED));
        _validatorHelper.isNotPopulated(department.getTax(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_TAX_NOT_PROVIDED));
        _validatorHelper.isNotPopulated(department.getAddress(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_ADDRESS_NOT_PROVIDED
                ));
        _validatorHelper.isNotPopulated(department.getHeadOffice(),
                _languageService.getMessage(
                        locale,
                        LanguageKeys.DEPARTMENT_ENTRY_HEAD_OFFICE_NOT_PROVIDED
                ));
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private CommonValidatorHelper _validatorHelper;
}
