package com.dogoo.common.files.manager.rest.internal.mapper.documentserver.editorconfig;

import com.dogoo.common.files.manager.rest.dto.v2_0.EditorConfig;
import com.dogoo.common.files.manager.rest.dto.v2_0.User;
import com.dogoo.common.files.manager.rest.internal.util.DG_FileUtil;
import com.dogoo.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = EditorConfigMapper.class)
public class EditorConfigMapper {

    public EditorConfig mapEditorConfig(long fileId, UserTokenModel userTokenModel) {

        EditorConfig to = new EditorConfig();

        to.setMode(EditorConfig.Mode.VIEW);
        to.setMode(_dgFileUtil.getModeFile(userTokenModel, fileId));
        User user = new User();
        user.setId(userTokenModel.getUserId());
        user.setName(userTokenModel.getFullName());

        to.setUser(user);

        return to;
    }

    @Reference
    DG_FileUtil _dgFileUtil;

}
