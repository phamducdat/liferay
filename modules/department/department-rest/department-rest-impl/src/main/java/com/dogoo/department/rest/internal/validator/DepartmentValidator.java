package com.dogoo.department.rest.internal.validator;


import com.dogoo.common.exception.model.*;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.internal.service.LanguageService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.dogoo.department.rest.internal.validator.fields.AddFieldsValidator;
import com.dogoo.department.rest.internal.validator.fields.UpdateFieldsValidator;
import com.dogoo.department.rest.internal.validator.provided.ProvidedValidator;
import com.dogoo.department.rest.internal.validator.structure.StructureValidator;
import com.dogoo.department.service.exception.NoSuchDepartmentEntryException;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

@Component(
        immediate = true,
        service = DepartmentValidator.class
)
public class DepartmentValidator {


    public void validateForAdd(long customerId,
                               Department department,
                               Locale locale) throws NoSuchDepartmentEntryException,
            DG_NameDuplicateException,
            DG_FieldRequiredException,
            DG_NoSuchEntryException,
            DG_FieldDuplicateException,
            DG_InvalidStructureException {
        _providedValidator.validateProvided(department, locale);
        validateDepartmentParentEntryExist(department.getParentId(), locale);
        _businessValidator.validateBusinessEntryExist(department.getBusinessId(), locale);
        _addFieldsValidator.validateForFieldsAdd(customerId, department, locale);
        validateForParentNotTrashed(department.getParentId(), locale);
        _structureValidator.validatorForStructure(customerId, department.getParentId(), department.getType(), locale);

    }


    public void validateForUpdate(long customerId,
                                  long departmentId,
                                  Department department,
                                  Locale locale)
            throws
            DG_FieldRequiredException,
            NoSuchDepartmentEntryException,
            DG_NameDuplicateException, DG_NoSuchEntryException,
            DG_FieldDuplicateException, DG_CodeDuplicateException, DG_InvalidStructureException {

        validateDepartmentEntryExist(departmentId, locale);
        _providedValidator.validateProvided(department, locale);
        validateDepartmentParentEntryExist(department.getParentId(), locale);
        _businessValidator.validateBusinessEntryExist(department.getBusinessId(), locale);
        _updateFieldsValidator.validateForFieldsUpdate(customerId, departmentId, department, locale);
        validateForParentNotTrashed(department.getParentId(), locale);
    }

    public void validateForDelete(long customerId, long departmentId, Locale locale)
            throws NoSuchDepartmentEntryException, DG_HaveChildException {
        validateDepartmentEntryExist(departmentId, locale);


        List<DepartmentEntry> childDepartmentEntries =
                _departmentEntryLocalService.getDepartmentEntries(customerId, departmentId);

        if (childDepartmentEntries.size() == 0) return;

        AtomicBoolean flag = new AtomicBoolean(false);

        childDepartmentEntries.forEach(item -> {
            if (StringUtil.equals("approved", item.getStatus()))
                flag.set(true);
        });

        if (flag.get()) {
            throw new DG_HaveChildException(
                    _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_HAS_CHILDREN)
            );
        }


    }


    public void validateDepartmentEntryExist(long departmentId, Locale locale)
            throws NoSuchDepartmentEntryException {

        DepartmentEntry entry = _departmentEntryLocalService.fetchDepartmentEntry(departmentId);

        if (Validator.isNotNull(entry)) {
            return;
        }
        throw new NoSuchDepartmentEntryException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_NOT_FOUND)
        );
    }

    public void validateDepartmentParentEntryExist(Long parentId, Locale locale)
            throws NoSuchDepartmentEntryException {
        if (parentId == null) return;
        DepartmentEntry entry = _departmentEntryLocalService.fetchDepartmentEntry(parentId);
        if (parentId == 0 || Validator.isNotNull(entry)) {
            return;
        }
        throw new NoSuchDepartmentEntryException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_PARENT_ENTRY_NOT_FOUND)
        );
    }

    public void validateForParentNotTrashed(Long parentId, Locale locale) throws DG_InvalidStructureException {
        if (parentId == null || parentId == 0) return;
        DepartmentEntry entry = _departmentEntryLocalService.fetchDepartmentEntry(parentId);
//        if (!StringUtil.equals(entry.getStatus(), "trashed")) return;
//        throw new DG_InvalidStructureException(
//                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_PARENT_TRASHED));
    }


    @Reference
    private LanguageService _languageService;

    @Reference
    private DepartmentEntryLocalService _departmentEntryLocalService;

    @Reference
    private BusinessValidator _businessValidator;

    @Reference
    private ProvidedValidator _providedValidator;

    @Reference
    private AddFieldsValidator _addFieldsValidator;

    @Reference
    private UpdateFieldsValidator _updateFieldsValidator;

    @Reference
    private StructureValidator _structureValidator;
}
