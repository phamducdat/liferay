package com.dogoo.common.files.manager.rest.internal.mapper.permission.attach;

import com.dogoo.common.files.manager.rest.dto.v2_0.AttachPermission;
import com.dogoo.common.files.manager.rest.dto.v2_0.Departments;
import com.dogoo.common.files.manager.rest.dto.v2_0.DepartmentsResponse;
import com.dogoo.common.files.manager.service.mapper.model.FileDepartmentPermissionMapperModel;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = FileDepartmentPermissionMapper.class)
public class FileDepartmentPermissionMapper {

    public List<FileDepartmentPermissionMapperModel> mapFileUserPermissionFromAttachPermission(AttachPermission from) {
        List<FileDepartmentPermissionMapperModel> to = new ArrayList<>();

        Departments departments = from.getDepartments();

        if (departments != null) {
            for (Long id : departments.getIds()) {
                FileDepartmentPermissionMapperModel model = new FileDepartmentPermissionMapperModel();

                model.setId(id);
                model.setRole(String.valueOf(departments.getRole()));
                to.add(model);
            }

        }
        return to;
    }


    public DepartmentsResponse[] mapToDepartmentsResponse(List<DGFileDepartmentPermissionEntry> listFileDepartmentPermissionEntry) {

        return TransformUtil.transformToArray(listFileDepartmentPermissionEntry, element -> {
            DepartmentsResponse to = new DepartmentsResponse();

            to.setId(element.getDepartmentId());
            to.setRole(element.getRole());

            DepartmentEntry departmentEntry = _departmentEntryLocalService.getDepartmentEntry(element.getDepartmentId());
            to.setName(Validator.isNotNull(departmentEntry) ? departmentEntry.getName() : "Not found");

            return to;
        }, DepartmentsResponse.class);
    }

    @Reference
    DepartmentEntryLocalService _departmentEntryLocalService;

}
