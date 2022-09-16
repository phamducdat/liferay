package com.dogoo.common.lib.api;

import org.osgi.service.component.annotations.Component;

/**
 * @author khoavu
 */

@Component (immediate = true, service = CommonConstants.class)
public class CommonConstants {
    public static final String TOKEN_HEADER_KEY = "dogoo-x-user-context-request";
    public static final String EXTERNAL_REFERENCE_CODE = "externalReferenceCode";
    public static final String CUSTOMER_ID = "customerId";
    public static final String CREATOR_ID = "creatorId";
}