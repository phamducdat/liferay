package com.dogoo.department.rest.internal.resource.v2_0;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.common.util.api.CommonUtil;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.internal.mapper.DepartmentMapper;
import com.dogoo.department.rest.internal.odata.v2_0.DepartmentEntityModel;
import com.dogoo.department.rest.internal.service.DepartmentService;
import com.dogoo.department.rest.internal.util.LanguageKeys;
import com.dogoo.department.rest.internal.validator.DepartmentValidator;
import com.dogoo.department.rest.resource.v2_0.DepartmentResource;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Locale;

/**
 * @author khoa
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/department.properties",
        scope = ServiceScope.PROTOTYPE, service = DepartmentResource.class
)
public class DepartmentResourceImpl extends BaseDepartmentResourceImpl {
    private final DepartmentEntityModel _departmentEntityModel = new DepartmentEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return _departmentEntityModel;
    }

    @Override
    public Page<Department> getDepartmentsPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {

        if (Validator.isNotNull(search)) {
            search = commonUtil.vnNormalize(search);
        }

        return _departmentService.getDepartmentsPage(
                getUserToken().getCustomerId(),
                search,
                filter,
                pagination,
                sorts,
                getServiceContext()
        );
    }


    @Override
    public Department postDepartment(Department department) throws Exception {
        _validator.validateForAdd(
                getUserToken().getCustomerId(),
                department,
                getLocale()
        );

        return _departmentService.addDepartment(
                getUserToken().getCustomerId(),
                getUserToken().getUserId(),
                department,
                getServiceContext());
    }

    @Override
    public void deleteDepartment(Long departmentId) throws Exception {
        _validator.validateForDelete(
                getUserToken().getCustomerId(),
                departmentId,
                getLocale()
        );
        _departmentService.deleteDepartment(departmentId);
    }

    @Override
    public Department putDepartment(Long departmentId, Department department) throws Exception {
        _validator.validateForUpdate(
                getUserToken().getCustomerId(),
                departmentId,
                department,
                getLocale()
        );
        return _departmentService.updateDepartment(getUserToken().getUserId(),
                departmentId, department, getServiceContext());
    }

    @Override
    public Department getDepartment(Long departmentId) throws Exception {
        _validator.validateDepartmentEntryExist(departmentId, getLocale());
        return _departmentService.getDepartmentById(departmentId);
    }

    @Override
    public void deleteDepartmentByExternalReferenceCode(String externalReferenceCode) throws Exception {
        long departmentId = _departmentMapper.getDepartmentEntryId(externalReferenceCode);
        deleteDepartment(departmentId);
    }

    @Override
    public Department putDepartmentByExternalReferenceCode(String externalReferenceCode, Department department) throws Exception {
        long departmentId = _departmentMapper.getDepartmentEntryId(externalReferenceCode);
        return putDepartment(departmentId, department);
    }

    @Override
    public Department getDepartmentByExternalReferenceCode(String externalReferenceCode) throws Exception {
        long departmentId = _departmentMapper.getDepartmentEntryId(externalReferenceCode);
        return getDepartment(departmentId);
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

        return serviceContext;
    }

    private UserTokenModel getUserToken() {
        return _tokenHelper.getUserToken(contextHttpServletRequest);
    }


    @Reference
    private DepartmentValidator _validator;

    @Reference
    private DepartmentService _departmentService;

    @Reference
    private DepartmentMapper _departmentMapper;

    @Reference
    private CommonTokenHelper _tokenHelper;

    @Reference
    private CommonUtil commonUtil;

}