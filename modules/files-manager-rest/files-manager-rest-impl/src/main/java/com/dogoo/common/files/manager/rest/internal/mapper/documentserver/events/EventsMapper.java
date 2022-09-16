package com.dogoo.common.files.manager.rest.internal.mapper.documentserver.events;

import com.dogoo.common.files.manager.rest.dto.v2_0.Events;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(immediate = true, service = EventsMapper.class)
public class EventsMapper {

    public Events mapEvents(FileEntry fileEntry, ThemeDisplay themeDisplay, Locale locale) {
        Events to = new Events();

        to.setSetHistoryData(_historyDataMapper.mapArrayHistoryDataFromFileEntry(fileEntry, themeDisplay));
        to.setRefreshHistory(_refreshHistoryMapper.mapRefreshHistoryFromFileEntry(fileEntry, locale));

        return to;
    }


    @Reference
    HistoryDataMapper _historyDataMapper;

    @Reference
    RefreshHistoryMapper _refreshHistoryMapper;
}
