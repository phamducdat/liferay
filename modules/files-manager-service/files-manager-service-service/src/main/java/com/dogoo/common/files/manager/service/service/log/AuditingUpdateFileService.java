package com.dogoo.common.files.manager.service.service.log;

import com.dogoo.common.auditing.service.interf.AuditingServiceUtil;
import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AuditingUpdateFileService.class)
public class AuditingUpdateFileService {
    String classNameAbsence = "com.dogoo.application.absence.service.model.ApplicationAbsenceEntry";
    String classNameInOut = "com.dogoo.application.inout.service.model.ApplicationInoutEntry";
    String classNameResign = "com.dogoo.application.resign.service.model.ApplicationResignEntry";
    String classNameShiftSwap = "com.dogoo.application.shiftchange.service.model.ApplicationShiftChangeEntry";
    String classNameMission = "com.dogoo.application.mission.service.model.ApplicationMissionEntry";
    String classNameOvertime = "com.dogoo.application.overtime.service.model.ApplicationOvertimeEntry";
    String classNameShiftMore = "com.dogoo.application.shiftmore.service.model.ApplicationShiftMoreEntry";
    String classNameFlexible = "com.dogoo.application.flexible.service.model.ApplicationFlexibleEntry";
    String classNameLeave = "com.dogoo.application.leave.service.model.ApplicationLeaveEntry";
    String classShiftRegisTration = "com.dogoo.application.shift.service.model.ApplicationShiftEntry";
    String classLate = "com.dogoo.application.late.service.model.ApplicationLateEntry";
    String classEmployeeConTract = "com.dogoo.employee.contract.service.model.EmployeeContractEntry";
    String classDismissal = "com.dogoo.decision.dismissal.service.model.DecisionDismissalEntry";
    String classDecisionContract = "com.dogoo.decision.contract.service.model.DecisionContractEntry";
    String classDecisionSalary = "com.dogoo.decision.salary.service.model.DecisionSalaryEntry";
    String classDecisionReward = "com.dogoo.decision.reward.service.model.DecisionRewardEntry";
    String classDecisionDiscipline = "com.dogoo.decision.discipline.service.model.DecisionDisciplineEntry";
    String classDecisionTransfer = "com.dogoo.decision.transfer.service.model.DecisionTransferEntry";
    String classDecisionAdmission = "com.dogoo.decision.admission.service.model.DecisionAdmissionEntry";
    String classDecisionAppointment = "com.dogoo.decision.appointment.service.model.DecisionAppointmentEntry";

    public void addAuditingFile(String name, DGDocumentManagerEntry entry, ServiceContext serviceContext , String event) throws SearchException {

        switch (name) {
            case "ABSENCE":
                long idAbsence =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameAbsence);
                if (idAbsence > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idAbsence,
                            classNameAbsence,
                            event + " file đính kèm đơn vắng mặt",
                            "UPDATE_APPLICATION_ABSENCE_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "INOUT":
                long idInout =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameInOut);
                if (idInout > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idInout,
                            classNameInOut,
                            event +" file đính kèm đơn Check Inout",
                            "UPDATE_APPLICATION_INOUT_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "RESIGN":
                long idResign =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameResign);
                if (idResign > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idResign,
                            classNameResign,
                            event +" file đính kèm đơn thôi việc",
                            "UPDATE_APPLICATION_RESIGN_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "SHIFT_SWAP":
                long idShiftSwap =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameShiftSwap);
                if (idShiftSwap > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idShiftSwap,
                            classNameShiftSwap,
                            event +" file đính kèm đơn đổi ca",
                            "UPDATE_APPLICATION_SHIFT_SWAP_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "MISSION":
                long idMission =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameMission);
                if (idMission > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idMission,
                            classNameMission,
                            event +" file đính kèm đơn công tác",
                            "UPDATE_APPLICATION_MISSION_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "OVERTIME":
                long idOvertime =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameOvertime);
                if (idOvertime > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idOvertime,
                            classNameOvertime,
                            event +" file đính kèm đơn làm thêm",
                            "UPDATE_APPLICATION_OVERTIME_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "SHIFT_MORE":
                long idShiftMore =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameShiftMore);
                if (idShiftMore > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idShiftMore,
                            classNameShiftMore,
                            event +" file đính kèm đơn tăng ca",
                            "UPDATE_APPLICATION_MORE_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "FLEXIBLE":
                long idFlexible =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameFlexible);
                if (idFlexible > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idFlexible,
                            classNameFlexible,
                            event +" file đính kèm đơn làm theo chế độ",
                            "UPDATE_APPLICATION_FLEXIBLE_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "LEAVE":
                long idLeave =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classNameLeave);
                if (idLeave > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idLeave,
                            classNameLeave,
                            event +" file đính kèm đơn xin nghỉ",
                            "UPDATE_APPLICATION_LEAVE_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "SHIFT_REGISTRATION":
                long idShiftRegisTration =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classShiftRegisTration);
                if (idShiftRegisTration > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idShiftRegisTration,
                            classShiftRegisTration,
                            event +" file đính kèm đơn đăng ký ca",
                            "UPDATE_APPLICATION_SHIFT_REGISTRATION_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "LATE_EARLY":
                long idLate =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classLate);
                if (idLate > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idLate,
                            classLate,
                            event +" file đính kèm đơn đi muộn về sớm",
                            "UPDATE_APPLICATION_LATE_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "LABEL_CONTRACT":
                long idEmployeeContract =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classEmployeeConTract);
                if (idEmployeeContract > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idEmployeeContract,
                            classEmployeeConTract,
                            event +" file đính kèm hợp đồng nhân sự",
                            "UPDATE_EMPLOYEE_CONTRACT_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "DISMISSAL":
                long idDismissal =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDismissal);
                if (idDismissal > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDismissal,
                            classDismissal,
                            event +" file đính kèm quyết định miễn nhiệm",
                            "UPDATE_DECISION_DISMISSAL_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "DECISION_CONTRACT":
                long idDecisionContract =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDecisionContract);
                if (idDecisionContract > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDecisionContract,
                            classDecisionContract,
                            event +" file đính kèm quyết định chấm dứt hợp đồng",
                            "UPDATE_DECISION_CONTRACT_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "SALARY":
                long idDecisionSalary =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDecisionSalary);
                if (idDecisionSalary > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDecisionSalary,
                            classDecisionSalary,
                            event +" file đính kèm quyết định điều chỉnh lương",
                            "UPDATE_DECISION_SALARY_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "REWARD":
                long idDecisionReward =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDecisionReward);
                if (idDecisionReward > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDecisionReward,
                            classDecisionReward,
                            event +" file đính kèm quyết định khen thưởng",
                            "UPDATE_DECISION_REWARD_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "DISCIPLINE":
                long idDecisionDiscipline =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDecisionDiscipline);
                if (idDecisionDiscipline > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDecisionDiscipline,
                            classDecisionDiscipline,
                            event +" file đính kèm quyết định kỷ luật",
                            "UPDATE_DECISION_DISCIPLINE_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "TRANSFER":
                long idDecisionTransfer =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDecisionTransfer);
                if (idDecisionTransfer > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDecisionTransfer,
                            classDecisionTransfer,
                            event +" file đính kèm quyết định điều chuyển",
                            "UPDATE_DECISION_TRANSFER_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "ADMISSION":
                long idDecisionAdmission =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDecisionAdmission);
                if (idDecisionAdmission > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDecisionAdmission,
                            classDecisionAdmission,
                            event +" file đính kèm quyết định tiếp nhận",
                            "UPDATE_DECISION_ADMISSION_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
            case "APPOINTMENT":
                long idDecisionAppointment =
                        searchEntry(
                                entry.getCustomerId(),
                                entry.getCompanyId(),
                                entry.getPkCode(),
                                classDecisionAppointment);
                if (idDecisionAppointment > 0) {
                    auditingServiceUtil.addAuditing(
                            entry.getCustomerId(),
                            entry.getCreatorId(),
                            idDecisionAppointment,
                            classDecisionAppointment,
                            event +" file đính kèm quyết định bổ nhiệm",
                            "UPDATE_DECISION_APPOINTMENT_FILE",
                            StringPool.BLANK,
                            serviceContext);
                }
                break;
        }
    }

    private long searchEntry(long customerId, long companyId, String code, String entryName) throws SearchException {

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);


        TermFilter customerFilter = new TermFilter(SearchField.CUSTOMER_ID, Long.toString(customerId));
        TermFilter codeFilter = new TermFilter(SearchField.CODE + "_String_sortable", code);

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(codeFilter, BooleanClauseOccur.MUST);

        BooleanQuery booleanQuery = new BooleanQueryImpl();
        booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, entryName);
        booleanQuery.setPreBooleanFilter(booleanFilter);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        if (hits.getDocs().length != 0) {
            Document document = hits.getDocs()[0];
            return GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
        } else {
            return 0;
        }
    }

    @Reference
    private AuditingServiceUtil auditingServiceUtil;
}
