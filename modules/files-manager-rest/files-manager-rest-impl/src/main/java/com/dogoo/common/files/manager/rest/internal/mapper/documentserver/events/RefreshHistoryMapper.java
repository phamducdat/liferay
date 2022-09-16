package com.dogoo.common.files.manager.rest.internal.mapper.documentserver.events;

import com.dogoo.authz.account.service.model.AccountEntry;
import com.dogoo.authz.account.service.service.AccountEntryLocalService;
import com.dogoo.common.files.manager.rest.dto.v2_0.History;
import com.dogoo.common.files.manager.rest.dto.v2_0.RefreshHistory;
import com.dogoo.common.files.manager.rest.dto.v2_0.User;
import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;
import com.dogoo.common.files.manager.service.service.DGFileVersionEntryLocalService;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

@Component(immediate = true, service = RefreshHistoryMapper.class)
public class RefreshHistoryMapper {


    public RefreshHistory mapRefreshHistoryFromFileEntry(FileEntry from, Locale locale) {
        RefreshHistory to = new RefreshHistory();

        to.setCurrentVersion(from.getVersion());
        to.setHistory(getHistories(from.getFileVersions(0), locale));

        return to;
    }

    private History[] getHistories(List<FileVersion> from, Locale locale) {
        return TransformUtil.transformToArray(from, element -> {
            return createHistory(element, locale);
        }, History.class);
    }

    private History createHistory(FileVersion from, Locale locale)
            throws ParseException {
        History to = new History();

        to.setKey(from.getUuid());
        to.setCreated(from.getCreateDate().toString());

        User user = new User();

        DGFileVersionEntry dgFileVersionEntry = _dgFileVersionEntryLocalService.fetchDGFileVersionEntry(from.getFileVersionId());
        if (dgFileVersionEntry != null) {
            AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(dgFileVersionEntry.getAccountId());
            if (accountEntry != null) {
                user.setId(accountEntry.getAccountId());
                user.setName(accountEntry.getFullName());
            }
        }

        to.setUser(user);
        to.setVersion(from.getVersion());

        return to;
    }

    @Reference
    AccountEntryLocalService accountEntryLocalService;

    @Reference
    DGFileVersionEntryLocalService _dgFileVersionEntryLocalService;


}
