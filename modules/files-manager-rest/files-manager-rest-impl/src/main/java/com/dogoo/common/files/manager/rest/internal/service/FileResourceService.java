package com.dogoo.common.files.manager.rest.internal.service;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component(
        immediate = true,
        service = FileResourceService.class
)
public class FileResourceService {

    public JSONObject convertFileJsonToJsonObject(String path) throws JSONException {
        StringBuilder stringBuilder = new StringBuilder();

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);

        try {
            assert inputStream != null;
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }

                inputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return JSONFactoryUtil.createJSONObject(stringBuilder.toString());
    }
}
