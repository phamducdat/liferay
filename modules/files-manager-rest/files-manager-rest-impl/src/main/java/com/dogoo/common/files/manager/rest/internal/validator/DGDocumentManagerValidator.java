package com.dogoo.common.files.manager.rest.internal.validator;

import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NameDuplicateException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.common.files.manager.rest.dto.v2_0.DGDocumentManager;
import com.dogoo.common.files.manager.rest.internal.service.LanguageService;
import com.dogoo.common.files.manager.rest.internal.service.permission.FilePermissionService;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.service.DGDocumentManagerEntryLocalService;
import com.dogoo.common.validator.api.CommonValidatorHelper;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
        immediate = true,
        service = DGDocumentManagerValidator.class
)
public class DGDocumentManagerValidator {

    public void validateForCreate(DGDocumentManager dto, Locale locale) throws DG_FieldRequiredException, DG_NameDuplicateException {

        validateRequired(dto, locale);

        validateNameDuplicateForCreate(dto, locale);
    }

    public void validateForUpdate(long id, DGDocumentManager dto, Locale locale)
            throws DG_FieldRequiredException, DG_NameDuplicateException, DG_NoSuchEntryException {

        validateForExist(id, locale);

        validateRequired(dto, locale);

        validateNameDuplicateForUpdate(id, dto, locale);
    }

    public void validateForExist(long id, Locale locale) throws DG_NoSuchEntryException {

        DGDocumentManagerEntry entry = _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id);

        if (Validator.isNotNull(entry)) return;

        throw new DG_NoSuchEntryException(
                _languageService.getMessage(
                        locale,
                        "document.does.not.exist"
                )
        );
    }

    private void validateRequired(DGDocumentManager dto, Locale locale) throws DG_FieldRequiredException {

        if (dto.getCategory().equals(DGDocumentManager.Category.ATTACHED)) {
            _commonValidatorHelper.isNotPopulated(
                    dto.getPkCode(),
                    _languageService.getMessage(
                            locale,
                            "pk.code.is.required"
                    ));
        }

        _commonValidatorHelper.isNotPopulated(
                dto.getParentId(),
                _languageService.getMessage(
                        locale,
                        "parent.id.is.required"
                ));

        _commonValidatorHelper.isNotPopulated(
                dto.getType(),
                _languageService.getMessage(
                        locale,
                        "type.is.required"
                ));

        _commonValidatorHelper.isNotPopulated(
                dto.getName(),
                _languageService.getMessage(
                        locale,
                        "name.is.required"
                ));

        if (dto.getType().equals(DGDocumentManager.Type.FILE)) {

            _commonValidatorHelper.isNotPopulated(
                    dto.getFileId(),
                    _languageService.getMessage(
                            locale,
                            "file.id.is.required"
                    ));
        }
    }

    private void validateNameDuplicateForCreate(DGDocumentManager dto, Locale locale) throws DG_NameDuplicateException {

        DGDocumentManagerEntry entry = null;

        if (dto.getCategory().equals(DGDocumentManager.Category.ATTACHED)) {
            entry = _dgDocumentManagerEntryLocalService.
                    fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
                            dto.getName(),
                            dto.getParentId(),
                            dto.getExtension(),
                            dto.getPkCode()
                    );
        }


        if (Validator.isNull(entry)) return;

        throw new DG_NameDuplicateException(
                _languageService.getMessage(
                        locale,
                        "name.duplicate"
                )
        );

    }

    private void validateNameDuplicateForUpdate(long id, DGDocumentManager dto, Locale locale) throws DG_NameDuplicateException {

        DGDocumentManagerEntry entry = null;

        if (dto.getCategory().equals(DGDocumentManager.Category.ATTACHED)) {
            entry = _dgDocumentManagerEntryLocalService.
                    fetchDgDocumentManagerEntryByNameAndParentIdAndExtensionAndPkCode(
                            dto.getName(),
                            dto.getParentId(),
                            dto.getExtension(),
                            dto.getPkCode()
                    );
        }

        if (Validator.isNull(entry)) return;

        if (entry.getDocumentManagerId() == id) return;

        throw new DG_NameDuplicateException(
                _languageService.getMessage(
                        locale,
                        "name.duplicate"
                )
        );

    }

    @Reference
    DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;

    @Reference
    LanguageService _languageService;

    @Reference
    CommonValidatorHelper _commonValidatorHelper;
}
