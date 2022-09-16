package com.dogoo.department.rest.internal.service;

import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author khoavu
 */

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