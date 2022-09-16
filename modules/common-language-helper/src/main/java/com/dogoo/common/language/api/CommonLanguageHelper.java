package com.dogoo.common.language.api;

import org.osgi.annotation.versioning.ProviderType;

import java.util.Locale;

/**
 * @author khoa
 */

@ProviderType
public interface CommonLanguageHelper {
    String getMessage(Locale locale, String key);
}