package com.dogoo.dataitems.rest.internal.validator;

import com.dogoo.common.exception.model.DG_EntryAssociatedException;
import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.DG_NameDuplicateException;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.dataitems.rest.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.internal.service.LanguageService;
import com.dogoo.dataitems.rest.internal.util.LanguageKeys;
import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.service.DataItemEntryLocalService;
import com.dogoo.decision.discipline.service.model.DecisionDisciplineEntry;
import com.dogoo.decision.discipline.service.service.DecisionDisciplineEntryLocalService;
import com.dogoo.decision.reward.service.model.DecisionRewardEntry;
import com.dogoo.decision.reward.service.service.DecisionRewardEntryLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(immediate = true, service = DataItemValidator.class)
public class DataItemValidator {

    public void validateForAdd(long customerId,
                               DataItem dataItem,
                               Locale locale)
            throws DG_FieldRequiredException, DG_NameDuplicateException {

        isNotPopulated(dataItem.getName(),
                LanguageKeys.DATA_ITEM_NAME_IS_REQUIRED, locale);

        isNotPopulated(dataItem.getType(),
                LanguageKeys.DATA_ITEM_TYPE_IS_REQUIRED, locale);

        validateNameForAdd(
                customerId,
                GetterUtil.getLong(dataItem.getParentId(), 0),
                dataItem.getType(),
                dataItem.getName(),
                locale);
    }


    public void validateForUpdate(long customerId,
                                  long dataItemId,
                                  DataItem dataItem,
                                  Locale locale)
            throws DG_NoSuchEntryException, DG_FieldRequiredException, DG_NameDuplicateException {

        validateDataItemExist(dataItemId, locale);

        isNotPopulated(dataItem.getName(),
                LanguageKeys.DATA_ITEM_NAME_IS_REQUIRED, locale);

        validateNameForUpdate(
                customerId,
                GetterUtil.getLong(dataItem.getParentId(), 0),
                dataItemId,
                dataItem.getType(),
                dataItem.getName(),
                locale);
    }

    public void validateForDelete(long id, Locale locale) throws DG_EntryAssociatedException {

        DataItemEntry entry = _dataItemEntryLocalService.fetchDataItemEntry(id);

        if (Validator.isNotNull(entry)) {
            _languageService.getMessage(
                    locale,
                    LanguageKeys.DATA_ITEM_DOES_NOT_EXIST
            );
        }

        switch (entry.getType()) {
            case "BONUS_METHOD":
                DecisionRewardEntry decisionRewardEntry = _decisionRewardEntryLocalService.fetchByRewardType(id);

                if (Validator.isNotNull(decisionRewardEntry)) {

                    throw new DG_EntryAssociatedException(
                            _languageService.getMessage(
                                    locale,
                                    LanguageKeys.DATA_ITEM_CAN_NOT_REMOVE
                            )
                    );
                }
                break;
            case "REPRIMAND_METHOD":
                DecisionDisciplineEntry decisionDisciplineEntry = _decisionDisciplineEntryLocalService.fetchByReprimandMethodId(id);

                if (Validator.isNotNull(decisionDisciplineEntry)) {

                    throw new DG_EntryAssociatedException(
                            _languageService.getMessage(
                                    locale,
                                    LanguageKeys.DATA_ITEM_CAN_NOT_REMOVE
                            )
                    );
                }
                break;
            default:
        }
    }

    public void validateDataItemExist(long dataItemId,
                                      Locale locale)
            throws DG_NoSuchEntryException {

        DataItemEntry entry =
                _dataItemEntryLocalService.fetchDataItemEntry(dataItemId);

        if (Validator.isNotNull(entry)) {
            return;
        }

        throw new DG_NoSuchEntryException(
                _languageService.getMessage(locale, LanguageKeys.DATA_ITEM_DOES_NOT_EXIST));
    }

    private void validateNameForUpdate(long customerId,
                                       long parentId,
                                       long dataItemId,
                                       String type,
                                       String name,
                                       Locale locale)
            throws DG_NameDuplicateException {

                DataItemEntry dataItem =
                _dataItemEntryLocalService
                        .fetchDataItemByName(customerId, parentId, type, name);

        if (Validator.isNull(dataItem)) {return;}

        if (dataItem.getDataItemId() != dataItemId) {
            throw new DG_NameDuplicateException(
                    _languageService.getMessage(locale, LanguageKeys.DATA_ITEM_NAME_IS_USED));
        }
    }

    private void validateNameForAdd(long customerId,
                                    long parentId,
                                    String type,
                                    String name,
                                    Locale locale) throws DG_NameDuplicateException {
        DataItemEntry dataItem =
                _dataItemEntryLocalService
                        .fetchDataItemByName(customerId, parentId, type, name);

        if (Validator.isNull(dataItem)) {
            return;
        }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DATA_ITEM_NAME_IS_USED));
    }

    private void isNotPopulated(String value,
                                String errorMsgKey,
                                Locale locale) throws DG_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private DataItemEntryLocalService _dataItemEntryLocalService;

    @Reference
    private DecisionRewardEntryLocalService _decisionRewardEntryLocalService;

    @Reference
    private DecisionDisciplineEntryLocalService _decisionDisciplineEntryLocalService;
}
