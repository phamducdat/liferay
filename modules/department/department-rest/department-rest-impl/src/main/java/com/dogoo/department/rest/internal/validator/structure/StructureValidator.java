package com.dogoo.department.rest.internal.validator.structure;


import com.dogoo.common.exception.model.DG_InvalidStructureException;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.internal.service.LanguageService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
        immediate = true,
        service = StructureValidator.class
)
public class StructureValidator {

    public void validatorForStructure(long customerId, Long parentId, Department.Type childType, Locale locale)
            throws DG_InvalidStructureException {
        String type = childType.toString();
        if (StringUtil.equals(type, "company")) validatorForStructureCompany(customerId, parentId, locale);
        if (StringUtil.equals(type, "branch")) validatorForStructureBranch(customerId, parentId, locale);
        if (StringUtil.equals(type, "unit")) validatorForStructureUnit(customerId, parentId, locale);
        if (StringUtil.equals(type, "department")) validatorForStructureDepartment(customerId, parentId, locale);
    }

    private void validatorForStructureCompany(long customerId, Long parentId, Locale locale)
            throws DG_InvalidStructureException {

        if (parentId == null || parentId == 0) return;

        DepartmentEntry parent = _localService.fetchDepartmentEntry(parentId);

        if (StringUtil.equals(parent.getType(), "company")) return;
        throw new DG_InvalidStructureException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_INVALID_STRUCTURE)
        );

    }

    private void validatorForStructureBranch(long customerId, long parentId, Locale locale)
            throws DG_InvalidStructureException {

        if (parentId == 0) throw new DG_InvalidStructureException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_INVALID_STRUCTURE)
        );
        DepartmentEntry parent = _localService.fetchDepartmentEntry(parentId);

        if (StringUtil.equals(parent.getType(), "company")) return;
        if (StringUtil.equals(parent.getType(), "branch")) return;

        throw new DG_InvalidStructureException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_INVALID_STRUCTURE)
        );
    }

    private void validatorForStructureUnit(long customerId, long parentId, Locale locale)
            throws DG_InvalidStructureException {

        if (parentId == 0) throw new DG_InvalidStructureException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_INVALID_STRUCTURE)
        );
        DepartmentEntry parent = _localService.fetchDepartmentEntry(parentId);

        if (!StringUtil.equals(parent.getType(), "department")) return;

        throw new DG_InvalidStructureException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_INVALID_STRUCTURE)
        );
    }

    private void validatorForStructureDepartment(long customerId, long parentId, Locale locale)
            throws DG_InvalidStructureException {
        if (parentId == 0) throw new DG_InvalidStructureException(
                _languageService.getMessage(locale, LanguageKeys.DEPARTMENT_ENTRY_INVALID_STRUCTURE)
        );
    }


    @Reference
    private DepartmentEntryLocalService _localService;

    @Reference
    private LanguageService _languageService;

}
