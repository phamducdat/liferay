package com.dogoo.common.util.api;

import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;

/**
 * @author khoavu
 */

@ProviderType
public interface CommonUtil {
    String vnNormalize(String value);

    Date getEndOfDate(Date date);
    Date getStartOfDate(Date date);

}