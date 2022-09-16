package com.dogoo.department.rest.internal.mapper;

import com.dogoo.department.rest.dto.v2_0.Business;
import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.service.mapper.model.DepartmentMapperModel;
import com.dogoo.department.service.model.BusinessEntry;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.BusinessEntryLocalService;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        service = DepartmentMapper.class
)
public class DepartmentMapper {

    public Department mapDepartmentFromDepartmentEntry(DepartmentEntry from) {
        Department to = new Department();


        to.setId(from.getDepartmentId());
        to.setParentId(from.getParentId());
        to.setBusiness(getBusiness(from));
        to.setType(Department.Type.create(from.getType()));
        to.setName(from.getName());
        to.setAddress(from.getAddress());
        to.setTax(from.getTax());
        to.setOrder(from.getOrder());
        to.setHeadOffice(from.getHeadOffice());
        to.setAlias(from.getAlias());
        to.setCode(from.getCode());
        to.setDescription(from.getDescription());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setStatus(Department.Status.create(from.getStatus()));
        to.setStatusDate(from.getStatusDate());

        return to;
    }

    private Business getBusiness(DepartmentEntry from) {

        BusinessEntry entry = _businessEntryLocalService.fetchBusinessEntry(from.getBusinessId());
        if (Validator.isNull(entry)) return new Business();
        return _businessMapper.mapBusinessFromBusinessEntry(entry);
    }

    public long getDepartmentEntryId(String referenceCode) {
        DepartmentEntry entry = getObject(referenceCode);
        if (Validator.isNull(entry)) {
            return 0l;
        }

        return entry.getDepartmentId();
    }

    public DepartmentEntry getObject(String referenceCode) {
        DepartmentEntry departmentEntry =
                _departmentEntryLocalService.fetchDepartmentEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(),
                        referenceCode
                );
        if (departmentEntry == null) {
            departmentEntry = _departmentEntryLocalService.fetchDepartmentEntry(
                    GetterUtil.getLong(referenceCode)
            );
        }
        return departmentEntry;
    }

    public DepartmentMapperModel mapDepartmentMapperModelFromDepartment(Department from) {
        DepartmentMapperModel to = new DepartmentMapperModel();

        to.setName(from.getName());
        to.setCode(from.getCode());
        to.setParentId(from.getParentId());
        to.setOrder(from.getOrder());
        to.setType(String.valueOf(from.getType()));
        to.setBusinessId(from.getBusinessId());
        to.setTax(from.getTax());
        to.setAddress(from.getAddress());
        to.setHeadOffice(from.getHeadOffice());
        to.setAlias(from.getAlias());
        to.setDescription(from.getDescription());

        return to;
    }

    @Reference
    private BusinessEntryLocalService _businessEntryLocalService;

    @Reference
    private DepartmentEntryLocalService _departmentEntryLocalService;

    @Reference
    private BusinessMapper _businessMapper;


}
