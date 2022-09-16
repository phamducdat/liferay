package com.dogoo.common.files.manager.service.internal.listener;

import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.service.DGDocumentManagerEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class DGDocumentManagerListener extends BaseModelListener<DGDocumentManagerEntry> {

    @Override
    public void onAfterCreate(DGDocumentManagerEntry model) throws ModelListenerException {

        String path = model.getPath();

        String[] pathArray = path.split(StringPool.FORWARD_SLASH);

        for (int i = 0; i < pathArray.length - 1; i++) {

            DGDocumentManagerEntry entry = _dgDocumentManagerEntryLocalService.
                    fetchDGDocumentManagerEntry(Long.parseLong(pathArray[i]));

            if (model.getType().equalsIgnoreCase("file")) {

                entry.setFileSize(String.valueOf(
                        Long.parseLong(entry.getFileSize()) +
                                Long.parseLong(model.getFileSize())));
            }

            entry.setModifiedDate(new Date());

            _dgDocumentManagerEntryLocalService.updateDGDocumentManagerEntry(entry);
        }
    }

    @Override
    public void onAfterUpdate(DGDocumentManagerEntry originalModel, DGDocumentManagerEntry model) throws ModelListenerException {

        if (model.getType().equalsIgnoreCase("file") || (!originalModel.getName().equals(model.getName()))) {
            String path = model.getPath();

            String[] pathArray = path.split(StringPool.FORWARD_SLASH);

            for (int i = 0; i < pathArray.length - 1; i++) {

                DGDocumentManagerEntry entry = _dgDocumentManagerEntryLocalService.
                        fetchDGDocumentManagerEntry(Long.parseLong(pathArray[i]));

                if (model.getType().equalsIgnoreCase("file")) {

                    entry.setFileSize(String.valueOf(
                            Long.parseLong(entry.getFileSize()) +
                                    Long.parseLong(model.getFileSize()) -
                                    Long.parseLong(originalModel.getFileSize())));
                }

                entry.setModifiedDate(new Date());

                _dgDocumentManagerEntryLocalService.updateDGDocumentManagerEntry(entry);
            }
        }
    }

    @Override
    public void onAfterRemove(DGDocumentManagerEntry model) throws ModelListenerException {

        String path = model.getPath();

        String[] pathArray = path.split(StringPool.FORWARD_SLASH);

        for (int i = 0; i < pathArray.length - 1; i++) {

            DGDocumentManagerEntry entry = _dgDocumentManagerEntryLocalService.
                    fetchDGDocumentManagerEntry(Long.parseLong(pathArray[i]));

            if (Validator.isNotNull(entry)) {
                entry.setFileSize(String.valueOf(
                        Long.parseLong(entry.getFileSize()) -
                                Long.parseLong(model.getFileSize())));
                entry.setModifiedDate(new Date());

                _dgDocumentManagerEntryLocalService.updateDGDocumentManagerEntry(entry);
            }
        }
    }

    private void updateModifiedDate(DGDocumentManagerEntry model) {

        if (model.getParentId() != 0) {
            DGDocumentManagerEntry document = _dgDocumentManagerEntryLocalService.
                    fetchDGDocumentManagerEntry(model.getParentId());

            if (Validator.isNotNull(document)) {
                document.setModifiedDate(new Date());

                _dgDocumentManagerEntryLocalService.updateDGDocumentManagerEntry(document);
            }
        }
    }

    @Reference
    DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;
}
