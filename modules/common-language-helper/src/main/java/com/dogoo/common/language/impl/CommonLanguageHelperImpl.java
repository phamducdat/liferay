package com.dogoo.common.language.impl;


import com.dogoo.common.language.api.CommonLanguageHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Locale;

@Component(
        scope = ServiceScope.PROTOTYPE, service = CommonLanguageHelper.class
)
public class CommonLanguageHelperImpl extends BaseCommonLanguageImpl {

    @Override
    public String getMessage(Locale locale, String key) {
        return _languageService.getMessage(locale, key);
    }

    @Reference
    private LanguageService _languageService;
}
