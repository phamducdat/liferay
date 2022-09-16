package com.dogoo.department.rest.internal.service;

import com.dogoo.department.rest.dto.v2_0.Department;
import com.dogoo.department.rest.internal.mapper.DepartmentMapper;
import com.dogoo.department.service.constant.SearchFields;
import com.dogoo.department.service.model.DepartmentEntry;
import com.dogoo.department.service.service.DepartmentEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(
        immediate = true,
        service = DepartmentService.class
)
public class DepartmentService {

    public Page<Department> getDepartmentsPage(long customerId,
                                               String search,
                                               Filter filter,
                                               Pagination pagination,
                                               Sort[] sorts,
                                               ServiceContext serviceContext) throws Exception {
        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    TermFilter customerIdFilter =
                            new TermFilter(SearchFields.CUSTOMER_ID, String.valueOf(customerId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                DepartmentEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long departmentId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _mapper.mapDepartmentFromDepartmentEntry(
                            _departmentEntryLocalService.getDepartmentEntry(departmentId));
                });

    }

    public Department addDepartment(long customerId,
                                    long creatorId,
                                    Department department,
                                    ServiceContext context) {

        DepartmentEntry entry = _departmentEntryLocalService.addDepartmentEntry(
                customerId,
                creatorId,
                _mapper.mapDepartmentMapperModelFromDepartment(department),
                context
        );

        return _mapper.mapDepartmentFromDepartmentEntry(entry);
    }

    public Department updateDepartment(long creatorId,
                                       long departmentId,
                                       Department department,
                                       ServiceContext context) throws PortalException {

        DepartmentEntry entry = _departmentEntryLocalService.updateDepartmentEntry(
                creatorId,
                departmentId,
                _mapper.mapDepartmentMapperModelFromDepartment(department),
                context
        );

        return _mapper.mapDepartmentFromDepartmentEntry(entry);
    }

    public Department getDepartmentById(long departmentId) throws PortalException {

        DepartmentEntry entry = _departmentEntryLocalService.getDepartmentEntry(departmentId);
        return _mapper.mapDepartmentFromDepartmentEntry(entry);
    }


    public void deleteDepartment(long departmentId) throws PortalException {

        _departmentEntryLocalService.deleteDepartmentEntryById(departmentId);
    }

    @Reference
    private DepartmentEntryLocalService _departmentEntryLocalService;

    @Reference
    private DepartmentMapper _mapper;
}
