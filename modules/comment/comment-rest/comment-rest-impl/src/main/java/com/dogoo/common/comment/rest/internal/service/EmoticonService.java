package com.dogoo.common.comment.rest.internal.service;

import com.dogoo.common.comment.rest.dto.v2_0.Emoticon;
import com.dogoo.common.comment.rest.internal.mapper.EmoticonMapper;
import com.dogoo.common.comment.service.mapper.model.EmoticonMapperModel;
import com.dogoo.common.comment.service.model.EmoticonEntry;
import com.dogoo.common.comment.service.service.EmoticonEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = EmoticonService.class)
public class EmoticonService {

    public Emoticon postEmoticon(long customerId,
                                 long userId,
                                 String fullName,
                                 Emoticon emoticon ,
                                 ServiceContext serviceContext){

        Emoticon comment1 = emoticon;
        comment1.setCreatorUserName(fullName);

        EmoticonMapperModel model = _mapper.mapEmoticonMapperModelFromEmoticon(comment1);

        EmoticonEntry emoticonEntry = _emoticonEntryLocalService.
                addEmoticon(customerId, userId , model , serviceContext );
        return _mapper.mapFromEmoticonToCommentEmoticon(emoticonEntry);
    }

    public List<Emoticon> getEmoticonByClassPkIdAndClassPkName(long customerId,
                                                 long classPKId,
                                                 String classPKName){
        List<EmoticonEntry> emoticonEntries = _emoticonEntryLocalService.
                getEmoticonEntriesByClassPkIdAndClassPkName(customerId,classPKId,classPKName);
        return _mapper.mapFromEmoticonToCommentEmoticonList(emoticonEntries);
    }

    public Emoticon getEmoticonByClassPkIdAndClassPkNameAndUserId(long customerId,
                                                                  long classPKId,
                                                                  String classPKName,
                                                                  long userId) throws PortalException {

        EmoticonEntry emoticonEntry = _emoticonEntryLocalService.
                getEmoticonEntriesByClassPkIdAndClassPkNameAndUser(customerId , classPKId,classPKName , userId);

        if (emoticonEntry == null ){
            return _mapper.mapFromEmoticonToCommentEmoticonNull() ;
        }
        return _mapper.mapFromEmoticonToCommentEmoticon(emoticonEntry);
    }

    public void deleteEmoticon(long emoticonId) throws PortalException {
        _emoticonEntryLocalService.deleteEmoticonEntry(emoticonId);
    }

    public Emoticon updateEmoticonByEmotionId(long emoticonId ,
                                              Emoticon emoticon ,
                                              ServiceContext serviceContext) throws PortalException {

        EmoticonEntry emoticonEntry = _emoticonEntryLocalService.fetchEmoticonEntry(emoticonId);

        Emoticon emoticon1 = emoticon;
        emoticon1.setClassPkId(emoticonEntry.getClassPkId());
        emoticon1.setClassPkName(emoticonEntry.getClassPkName());
        emoticon1.setCreatorUserName(emoticonEntry.getCreatorFullName());

        EmoticonMapperModel model = _mapper.mapEmoticonMapperModelFromEmoticon(emoticon1);

        EmoticonEntry emoticonEntry1 = _emoticonEntryLocalService.updateEmoticon(
                emoticonId ,model , serviceContext);
        return _mapper.mapFromEmoticonToCommentEmoticon(emoticonEntry1);
    }

    @Reference
    private EmoticonEntryLocalService _emoticonEntryLocalService ;

    @Reference
    private EmoticonMapper _mapper;

}
