package com.dogoo.common.files.manager.rest.internal.engine;


import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.InputStream;

@Component(immediate = true,
        service = FilesResourceEngine.class)

public class FilesResourceEngine {

    public void test(Long fileId) throws PortalException, IOException {

        FileEntry fileEntry = dlAppService.getFileEntry(fileId);
//
//
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("templates/template_engine.xlsx");
//        InputStream inputStream = classLoader.getResourceAsStream("templates/test-doc.docx");

//        FileInputStream in = new FileInputStream("templates/test-doc.docx");
//        XWPFDocument document = new XWPFDocument(in);

//        POIFSFileSystem fs = null;
//        fs = new POIFSFileSystem(fileEntry.getContentStream());
//        Document document = new Document();

    }

    @Reference
    DLAppService dlAppService;

}
