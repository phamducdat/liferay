package com.dogoo.common.files.manager.rest.internal.mapper.documentserver.events;

import com.dogoo.common.files.manager.rest.dto.v2_0.SetHistoryData;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = HistoryDataMapper.class)
public class HistoryDataMapper {

    public SetHistoryData[] mapArrayHistoryDataFromFileEntry(FileEntry fileEntry, ThemeDisplay themeDisplay) {

        List<FileVersion> fileVersions = fileEntry.getFileVersions(0);

        List<SetHistoryData> to = new ArrayList<SetHistoryData>();
        fileVersions.forEach(element -> to.add(getSetHistoryDataByFileId(fileEntry, element, themeDisplay)));

        SetHistoryData[] result = new SetHistoryData[to.size()];
        to.toArray(result);

        return result;
    }

    private SetHistoryData getSetHistoryDataByFileId(FileEntry fileEntry,
                                                     FileVersion fileVersion,
                                                     ThemeDisplay themeDisplay) {
        SetHistoryData to = new SetHistoryData();

        to.setUrl(DLURLHelperUtil.getDownloadURL(
                fileEntry,
                fileVersion,
                themeDisplay,
                "",
                true,
                true));
        to.setKey(fileVersion.getUuid());
        to.setVersion(fileVersion.getVersion());


        return to;
    }
}
