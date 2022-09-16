package com.dogoo.common.api.rest.internal.mapper;

import com.dogoo.common.api.rest.dto.v2_0.EmployeeReference;
import com.dogoo.common.api.rest.internal.util.EmployeeIndexerKeys;
import com.dogoo.common.lib.api.CommonConstants;
import com.dogoo.employee.service.model.EmployeeEntry;
import com.dogoo.employee.service.service.EmployeeEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = EmployeeReferenceMapper.class)
public class EmployeeReferenceMapper {

    public List<EmployeeReference> mapEmployeeReferencesFromDocuments(Document [] documents) {
        return Arrays.stream(documents)
                .map(this::mapEmployeeReferenceFromDocument)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public EmployeeReference mapEmployeeReferenceFromDocument(Document doc) {

        EmployeeReference ref = new EmployeeReference();

        ref.setId(GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK)));
        ref.setName(getEmployeeName(doc));
        ref.setType(getReferenceType(doc));
        ref.setExternalReferenceCode(GetterUtil.getString(doc.get(CommonConstants.EXTERNAL_REFERENCE_CODE)));

        return ref;
    }

    private EmployeeReference.Type getReferenceType(Document doc) {

        String contentType = GetterUtil.getString(doc.get(Field.ENTRY_CLASS_NAME));

        if (contentType.equalsIgnoreCase(EmployeeIndexerKeys.EMPLOYEE_CLASS_NAME)) {
            return EmployeeReference.Type.EMPLOYEE;
        } else if (contentType.equalsIgnoreCase(EmployeeIndexerKeys.DEPARTMENT_CLASS_NAME)) {
            return EmployeeReference.Type.DEPARTMENT;
        } else if (contentType.equalsIgnoreCase(EmployeeIndexerKeys.POSITION_CLASS_NAME)) {
            return EmployeeReference.Type.POSITION;
        } else {
            return EmployeeReference.Type.TITLE;
        }
    }

    private String getEmployeeName(Document doc){
        EmployeeReference.Type type = getReferenceType(doc) ;
        long id = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

        if (type == EmployeeReference.Type.EMPLOYEE){
            EmployeeEntry employeeEntry =
                    _employeeEntryLocalService.fetchEmployeeEntry(id);
            return employeeEntry != null ? employeeEntry.getName() : GetterUtil.getString(doc.get(Field.NAME)) ;
        }else{
            return GetterUtil.getString(doc.get(Field.NAME));
        }
    }


    @Reference
    private EmployeeEntryLocalService _employeeEntryLocalService;
}
