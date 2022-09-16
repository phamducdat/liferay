package com.dogoo.common.files.manager.rest.internal.resource.v2_0;

import com.dogoo.common.files.manager.rest.dto.v2_0.DGAttachedDocumentManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.DGDocumentManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.Module;
import com.dogoo.common.files.manager.rest.internal.service.DGDocumentManagerService;
import com.dogoo.common.files.manager.rest.internal.util.LanguageKeys;
import com.dogoo.common.files.manager.rest.internal.validator.DGDocumentManagerValidator;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGDocumentManagerResource;
import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.employee.career.service.retriever.EmployeeCareerEntryRetriever;
import com.dogoo.employee.service.mapper.model.EmployeeCurrentPositionMapperModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Locale;

/**
 * @author khoa
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/dg-document-manager.properties",
        scope = ServiceScope.PROTOTYPE, service = DGDocumentManagerResource.class
)
public class DGDocumentManagerResourceImpl
        extends BaseDGDocumentManagerResourceImpl {

    @Override
    public Page<DGDocumentManager> getAllDGDocumentManagerAttachProject(String search, Long parentId, String pkCode, Pagination pagination) throws Exception {
        return _service.getAllDGDocumentManagerAttachProject(search, parentId, pkCode, pagination, getThemeDisplay(), getUserToken());
    }

    @Override
    public Page<DGDocumentManager> getAllDGDocumentManagerPersonalCompany(String search, Long parentId, Pagination pagination) throws Exception {
        return _service.getDgDocumentManagerCompanyPersonalPages(
                getUserToken().getCustomerId(),
                search,
                getUserToken().getUserId(),
                parentId,
                getThemeDisplay(),
                getUserToken(),
                pagination
        );
    }

    @Override
    public Page<DGDocumentManager> getAllDGDocumentManagerCompany(String search, Long parentId, Pagination pagination) throws Exception {

        return _service.getDgDocumentManagerCompanyPages(
                getUserToken().getCustomerId(),
                search,
                getUserToken().getUserId(),
                getDepartmentId(),
                parentId,
                getThemeDisplay(),
                getUserToken(),
                pagination
        );
    }

    @Override
    public Page<Module> getAllModules(String moduleId) throws Exception {

        return _service.getAllModules(moduleId);
    }

    @Override
    public Page<DGDocumentManager> getAllDGDocumentManagerPersonalAttach(String search, Long parentId, String app, Pagination pagination) throws Exception {
        return _service.getDgDocumentManagerAttachPersonalPages(
                getUserToken().getCustomerId(),
                app,
                search,
                getUserToken().getUserId(),
                parentId,
                getThemeDisplay(),
                getUserToken(),
                pagination
        );
    }

    @Override
    public Page<DGDocumentManager> getAllDGDocumentManager(String pkCode, String appId, String search, Long parentId, Pagination pagination) throws Exception {
        return _service.getDgDocumentManagerPages(
                getUserToken().getCustomerId(),
                appId,
                search,
                pkCode,
                parentId,
                getThemeDisplay(),
                getUserToken(),
                pagination
        );
    }

    @Override
    public Page<DGDocumentManager> getAllDGDocumentManagerPersonal(String search, Long parentId, Pagination pagination) throws Exception {

        return _service.getDgDocumentManagerPersonalPages(
                getUserToken().getCustomerId(),
                search,
                getUserToken().getUserId(),
                getDepartmentId(),
                parentId,
                getThemeDisplay(),
                getUserToken(),
                pagination
        );
    }

    @Override
    public void putDGDocumentManagerPublic(Long id, DGDocumentManager dgDocumentManager) throws Exception {
        _service.putDGDocumentManagerPublic(id, getUserToken().getUserId(), dgDocumentManager, getServiceContext());
    }

    @Override
    public void postDGDocumentManagerAttach(DGAttachedDocumentManager dgAttachedDocumentManager) throws Exception {
        _service.postDGDocumentManagerAttach(
                getServiceContext().getScopeGroupId(),
                getUserToken().getCustomerId(),
                getUserToken().getCustomer(),
                dgAttachedDocumentManager,
                getServiceContext()
        );
    }

    @Override
    public DGDocumentManager getDGDocumentManager(Long id, String category, String appId) throws Exception {
//        _validator.validateForExist(id, getLocale());
        return _service.getDgDocumentManager(id, category, appId, getThemeDisplay(), getUserToken());
    }


    @Override
    public DGDocumentManager putDGDocumentManager(Long id, DGDocumentManager dgDocumentManager) throws Exception {

        _validator.validateForUpdate(id, dgDocumentManager, getLocale());

        return _service.putDgDocumentManagerById(
                getUserToken().getUserId(),
                id,
                dgDocumentManager,
                getServiceContext(),
                getThemeDisplay(),
                getUserToken()
        );
    }

    @Override
    public DGDocumentManager postDGDocumentManager(DGDocumentManager dgDocumentManager) throws Exception {

        _validator.validateForCreate(dgDocumentManager, getLocale());

        return _service.postDgDocumentManager(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                getDepartmentId(),
                dgDocumentManager,
                getServiceContext(),
                getThemeDisplay(),
                getUserToken()
        );
    }

    @Override
    public void deleteDGDocumentManager(Long id) throws Exception {

        _validator.validateForExist(id, getLocale());

        _service.deleteDgDocumentManagerById(id,
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                getServiceContext());
    }

    @Override
    public void deleteDocuments(String pkCode) throws Exception {

        _service.deleteDgDocumentManagerByPkCode(pkCode);
    }

    public Long getDepartmentId() {
        EmployeeCurrentPositionMapperModel employee = _employeeCareerEntryRetriever.getEmployeeCurrent(
                getUserToken().getCustomerId(),
                getUserToken().getEmployeeId()
        );

        return employee.getDepartmentId();
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }

    public Locale getLocale() {

        Locale locale = contextHttpServletRequest.getLocale();

        if (locale.getLanguage().isEmpty()) {
            locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
        }

        return locale;
    }

    public ThemeDisplay getThemeDisplay() {

        ThemeDisplay themeDisplay = new ThemeDisplay();
        String remoteHost = contextHttpServletRequest.getServerName();
        String scheme = contextHttpServletRequest.getScheme();

        themeDisplay.setPortalURL("https" + "://" + remoteHost);

        return themeDisplay;
    }

    private UserTokenModel getUserToken() {
        return _tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper _tokenHelper;
    @Reference
    private DGDocumentManagerService _service;
    @Reference
    private DGDocumentManagerValidator _validator;
    @Reference
    private EmployeeCareerEntryRetriever _employeeCareerEntryRetriever;
}