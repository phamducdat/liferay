package com.dogoo.common.comment.rest.internal.mapper;

import com.dogoo.common.comment.rest.dto.v2_0.Emoticon;
import com.dogoo.common.comment.service.mapper.model.EmoticonMapperModel;
import com.dogoo.common.comment.service.model.EmoticonEntry;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = EmoticonMapper.class)
public class EmoticonMapper {

    public Emoticon mapFromEmoticonToCommentEmoticon(EmoticonEntry from){
        Emoticon to = new Emoticon();

        to.setEmoticonId(from.getEmoticonId());
        to.setClassPkId(from.getClassPkId());
        to.setClassPkName(from.getClassPkName());
        to.setCretorUserId(from.getCreatorId());
        to.setCreatorUserName(from.getCreatorFullName());
        to.setEmoji(from.getEmoji());

        return to;
    }
    public Emoticon mapFromEmoticonToCommentEmoticonNull() {
        Emoticon to = new Emoticon();

        to.setEmoji("");
        return to;
    }

    public List<Emoticon> mapFromEmoticonToCommentEmoticonList(List<EmoticonEntry> from){
        List<Emoticon> to = new ArrayList<>();

        from.forEach(emoticonEntry -> {
            to.add(mapFromEmoticonToCommentEmoticon(emoticonEntry));
        });

        return to;
    }

    public EmoticonMapperModel mapEmoticonMapperModelFromEmoticon(Emoticon from) {
        EmoticonMapperModel model = new EmoticonMapperModel();
        model.setClassPkId(from.getClassPkId());
        model.setClassPkName(from.getClassPkName());
        model.setEmoji(from.getEmoji());
        model.setCreatorFullName(from.getCreatorUserName());

        return model ;
    }
}
