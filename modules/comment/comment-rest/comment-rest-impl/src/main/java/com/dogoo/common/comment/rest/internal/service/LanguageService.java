package com.dogoo.common.comment.rest.internal.service;

import com.liferay.portal.kernel.language.LanguageUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component(
        immediate = true,
        service = LanguageService.class
)
public class LanguageService {
    private final String BASE_NAME = "content/Language";

    public String getMessage(Locale locale, String key) {
        return LanguageUtil.get(
                ResourceBundle.getBundle(BASE_NAME, locale), key);

    }
}
