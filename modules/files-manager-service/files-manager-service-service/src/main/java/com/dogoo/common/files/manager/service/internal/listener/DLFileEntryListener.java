package com.dogoo.common.files.manager.service.internal.listener;

import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.service.DGDocumentManagerEntryLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class DLFileEntryListener extends BaseModelListener<DLFileEntry> {

    @Override
    public void onAfterUpdate(DLFileEntry originalModel, DLFileEntry model) throws ModelListenerException {
        super.onAfterUpdate(originalModel, model);

        DGDocumentManagerEntry file = _dgDocumentManagerEntryLocalService.fetchDgDocumentManagerEntryByFileId(
                model.getFileEntryId()
        );

        if (Validator.isNotNull(file)) {
            file.setModifiedDate(model.getModifiedDate());
            file.setFileSize(String.valueOf(model.getSize()));

            _dgDocumentManagerEntryLocalService.updateDGDocumentManagerEntry(file);
        }
    }

    @Reference
    DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;
}
