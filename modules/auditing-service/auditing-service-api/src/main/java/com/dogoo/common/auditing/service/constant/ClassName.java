package com.dogoo.common.auditing.service.constant;

import java.util.Objects;

public enum ClassName {
    AUDITING("com.dogoo.common.auditing.model.Auditing"),
    PROJECT("com.dogoo.core.project.service.model.ProjectEntry"),
    PHASE("com.dogoo.core.project.service.model.PhaseEntry"),
    TASK("com.dogoo.core.task.service.model.TaskEntry"),
    OBJECT_GROUP("com.dogoo.core.resource.service.model.ObjectGroupTaskEntry"),
    APP_ABSENCE("com.dogoo.application.absence.service.model.ApplicationAbsenceEntry"),
    APP_LATE("com.dogoo.application.late.service.model.ApplicationLateEntry"),
    APP_FLEXIBLE("com.dogoo.application.flexible.service.model.ApplicationFlexibleEntry"),
    APP_CHECK_INOUT("com.dogoo.application.inout.service.model.ApplicationInoutEntry"),
    APP_LEAVE("com.dogoo.application.leave.service.model.ApplicationLeaveEntry"),
    APP_MISSIONS("com.dogoo.application.mission.service.model.ApplicationMissionEntry"),
    APP_OVERTIME("com.dogoo.application.overtime.service.model.ApplicationOvertimeEntry"),
    APP_RESIGN("com.dogoo.application.resign.service.model.ApplicationResignEntry"),
    APP_SHIFT_MORE("com.dogoo.application.shiftmore.service.model.ApplicationShiftMoreEntry"),
    APP_SHIFT_REGISTRATION("com.dogoo.application.shift.service.model.ApplicationShiftEntry"),
    APP_SHIFT_SWAP("com.dogoo.application.shiftchange.service.model.ApplicationShiftChangeEntry"),
    SALARY_CONFIG("com.dogoo.salary.service.model.SalaryConfigEntry"),
    DECISION_ADMISSION("com.dogoo.decision.admission.service.model.DecisionAdmissionEntry"),
    DECISION_APPOINTMENT("com.dogoo.decision.appointment.service.model.DecisionAppointmentEntry"),
    DECISION_CONTRACT("com.dogoo.decision.contract.service.model.DecisionContractEntry"),
    DECISION_DISCIPLINE("com.dogoo.decision.discipline.service.model.DecisionDisciplineEntry"),
    DECISION_DISMISSAL(" com.dogoo.decision.dismissal.service.model.DecisionDismissalEntry"),
    DECISION_REWARD("com.dogoo.decision.reward.service.model.DecisionRewardEntry"),
    DECISION_SALARY("com.dogoo.decision.salary.service.model.DecisionSalaryEntry"),
    DECISION_TRANSFER("com.dogoo.decision.transfer.service.model.DecisionTransferEntry"),
    EMPLOYEE("com.dogoo.employee.service.model.EmployeeEntry"),
    EMPLOYEE_CONTRACT("com.dogoo.employee.contract.service.model.EmployeeContractEntry"),
    SALARY_TABLE("com.dogoo.salary.service.model.SalaryTableEntry"),
    ASSESSMENT_TEMPLATE("com.dogoo.assessment.template.service.model.AssessmentTemplateEntry"),
    ASSESSMENT_EMPLOYEE("com.dogoo.assessment.employee.service.model.AssessmentEmployeeEntry"),
    ASSESSMENT_ITEMS("com.dogoo.assessment.items.service.model.AssessmentItemsEntry");

    public static ClassName create(String value) {
        if ((value == null) || value.equals("")) {
            return null;
        }

        for (ClassName state : values()) {
            if (Objects.equals(state.getClassName(), value)) {
                return state;
            }
        }

        throw new IllegalArgumentException("Invalid enum value: " + value);
    }

    private final String _className;

    private ClassName(String className) {
        _className = className;
    }

    public String getClassName() {
        return _className;
    }
}
