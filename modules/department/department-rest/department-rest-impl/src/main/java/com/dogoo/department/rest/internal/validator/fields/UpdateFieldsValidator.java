package com.dogoo.department.rest.internal.validator.fields;

import com.dogoo.common.exception.model.DG_CodeDuplicateException;
import com.dogoo.common.exception.model.DG_FieldDuplicateException;
import com.dogoo.common.exception.model.DG_NameDuplicateException;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.internal.service.LanguageService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
        immediate = true,
        service = UpdateFieldsValidator.class)
public class UpdateFieldsValidator {

    public void validateForFieldsUpdate(long customerId, long entryId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_FieldDuplicateException, DG_CodeDuplicateException {

        String type = department.getType().toString();

        if (StringUtil.equals(type, "company")) validateForFieldsUpdateCompany(customerId, entryId, department, locale);
        if (StringUtil.equals(type, "branch")) validateForFieldsUpdateBranch(customerId, entryId, department, locale);
        if (StringUtil.equals(type, "unit")) validateForFieldsUpdateUnit(customerId, entryId, department, locale);
        if (StringUtil.equals(type, "department")) validateForFieldsUpdateDepartment(
                customerId,
                entryId,
                department,
                locale);
    }

    private void validateForFieldsUpdateCompany(long customerId, long entryId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_CodeDuplicateException, DG_FieldDuplicateException {
        validateForFieldsUpdateBaseCompanyAndBrand(customerId, entryId, department, locale);
    }

    private void validateForFieldsUpdateBranch(long customerId, long entryId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_CodeDuplicateException, DG_FieldDuplicateException {
        validateForFieldsUpdateBaseCompanyAndBrand(customerId, entryId, department, locale);

    }

    private void validateForFieldsUpdateUnit(long customerId, long entryId, Department department, Locale locale) throws DG_NameDuplicateException, DG_CodeDuplicateException {
//        validateForNameUpdate(customerId, entryId, department, locale);
        validateForCodeUpdate(customerId, entryId, department, locale);

    }

    private void validateForFieldsUpdateDepartment(long customerId, long entryId, Department department, Locale locale) throws DG_NameDuplicateException, DG_CodeDuplicateException {
//        validateForNameUpdate(customerId, entryId, department, locale);
        validateForCodeUpdate(customerId, entryId, department, locale);

    }

    private void validateForFieldsUpdateBaseCompanyAndBrand(long customerId, long entryId, Department department, Locale locale)
            throws DG_NameDuplicateException, DG_CodeDuplicateException, DG_FieldDuplicateException {
//        validateForNameUpdate(customerId, entryId, department, locale);
        validateForCodeUpdate(customerId, entryId, department, locale);
        validateForTaxUpdate(customerId, entryId, department, locale);
    }

//    private void validateForNameUpdate(long customerId, long entryId, Department department, Locale locale) throws DG_NameDuplicateException {
//        DepartmentEntry entry = _localService.fetchDepartmentEntryByName(customerId, department.getName());
//
//        if (Validator.isNull(entry)) return;
//        if (entry.getDepartmentId() == entryId) return;
//
//        throw new DG_NameDuplicateException(
//                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_NAME_DUPLICATE));
//    }

    private void validateForCodeUpdate(long customerId, long entryId, Department department, Locale locale)
            throws DG_CodeDuplicateException {
        DepartmentEntry entry = _localService.fetchDepartmentEntryByCode(customerId, department.getCode());

        if (Validator.isNull(entry)) return;
        if (entry.getDepartmentId() == entryId) return;

        throw new DG_CodeDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_CODE_DUPLICATE));
    }

    private void validateForTaxUpdate(long customerId, long entryId, Department department, Locale locale)
            throws DG_FieldDuplicateException {
        DepartmentEntry entry = _localService.fetchDepartmentEntryByTax(customerId, department.getTax());

        if (Validator.isNull(entry)) return;
        if (entry.getDepartmentId() == entryId) return;

        throw new DG_FieldDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_TAX_DUPLICATE));

    }

    @Reference
    private DepartmentEntryLocalService _localService;

    @Reference
    private LanguageService _languageService;

}