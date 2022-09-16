package com.dogoo.address.rest.internal.validator;

import com.dogoo.address.rest.dto.v2_0.Address;
import com.dogoo.address.rest.internal.service.LanguageService;
import com.dogoo.address.rest.internal.util.LanguageKeys;
import com.dogoo.address.service.model.AddressEntry;
import com.dogoo.address.service.service.AddressEntryLocalService;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.BadRequestException;
import java.util.Locale;

@Component(immediate = true, service = com.dogoo.address.rest.internal.validator.AddressValidator.class)
public class AddressValidator {
    public void validatorForSearch(Pagination pagination) {
        if (pagination.getPageSize() > 250) {
            throw new BadRequestException(String.format(LanguageKeys.PAGE_SIZE_MAX, 250));
        }
    }

    public void validatorForAddAddress(Address address,
                                       Locale locale) throws DG_FieldRequiredException {

        checkRequiredField(address.getProvince(),LanguageKeys.PROVINCE_REQUEST, locale);
        checkRequiredField(address.getTitle(),LanguageKeys.TITLE_REQUEST, locale);

    }

    public void validatorForUpdateAddress(long addressId,
                                          Address address,
                                          Locale locale) throws DG_NoSuchEntryException, DG_FieldRequiredException {
        validatorAddressIsExists(addressId, locale);

        checkRequiredField(address.getProvince(),LanguageKeys.PROVINCE_REQUEST, locale);
        checkRequiredField(address.getTitle(),LanguageKeys.TITLE_REQUEST, locale);

    }

    public void validatorAddressIsExists(long addressId,
                                         Locale locale) throws DG_NoSuchEntryException {
        AddressEntry addressEntry = _addressEntryLocalService.fetchAddressEntry(addressId);

        if(Validator.isNotNull(addressEntry)){
            return;
        }

        throw new DG_NoSuchEntryException(
                _languageService.getMessage(
                        locale, LanguageKeys.ADDRESS_NOT_FOUND
                )
        );
    }

    private void checkRequiredField(String value,
                                    String errorMsg,
                                    Locale locale) throws DG_FieldRequiredException {
        if (null == value || value.trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsg));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private AddressEntryLocalService _addressEntryLocalService;
}
