package com.dogoo.common.auditing.rest.internal.resource.v2_0;

import com.dogoo.common.auditing.rest.dto.v2_0.Auditing;
import com.dogoo.common.auditing.rest.internal.service.AuditingService;
import com.dogoo.common.auditing.rest.internal.util.LanguageKeys;
import com.dogoo.common.auditing.rest.resource.v2_0.AuditingResource;
import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.common.util.api.CommonUtil;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Date;
import java.util.Locale;

/**
 * @author khoa
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/auditing.properties",
        scope = ServiceScope.PROTOTYPE, service = AuditingResource.class
)
public class AuditingResourceImpl extends BaseAuditingResourceImpl {

    @Override
    public Page<Auditing> getAuditings(Long classPkId, String classPkName, Date startDate, Date endDate, Filter filter) throws Exception {
        return _service.getAuditingPages(
                getUserToken().getCustomerId(),
                classPkId,
                classPkName,
                startDate,
                endDate,
                filter,
                getServiceContext());
    }

    public Locale getLocale() {

        Locale locale = contextHttpServletRequest.getLocale();

        if (locale.getLanguage().isEmpty()) {
            locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
        }

        return locale;
    }

    public ServiceContext getServiceContext() {

        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());
        serviceContext.setLanguageId(getLocale().getLanguage());

        return serviceContext;
    }

    private UserTokenModel getUserToken() {
        return _tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper _tokenHelper;


    @Reference
    private AuditingService _service;

    @Reference
    private CommonUtil commonUtil;

}