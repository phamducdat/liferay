package com.dogoo.common.comment.rest.internal.validator;

import com.dogoo.common.comment.rest.internal.service.LanguageService;
import com.dogoo.common.comment.service.exception.NoSuchEmoticonEntryException;
import com.dogoo.common.comment.service.model.EmoticonEntry;
import com.dogoo.common.comment.service.service.EmoticonEntryLocalService;
import com.dogoo.common.exception.model.DG_NoSuchEntryException;
import com.dogoo.common.exception.model.DG_UnAuthorizationException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Locale;

@Component(immediate = true, service = EmoticonValidator.class)
public class EmoticonValidator {

    public void validatorEmoticonIsNotOfUserId(long UserId ,
                                               long emoticonId ,
                                               Locale locale) throws DG_UnAuthorizationException {

        EmoticonEntry emoticonEntry = _emoticonEntryLocalService.fetchEmoticonEntry(emoticonId);
        if(emoticonEntry.getCreatorId() == UserId){
            return;
        }
        throw new DG_UnAuthorizationException(_languageService.getMessage(locale, "emoticon.creator.not.emoticon"));
    }

    public void validatorUserIdWasExpressive(long customerId,
                                             long UserId ,
                                             long classPkId ,
                                             String classPkName,
                                             Locale locale) throws NoSuchEmoticonEntryException, DG_NoSuchEntryException {

        EmoticonEntry emoticonEntry = _emoticonEntryLocalService.
                getEmoticonEntriesByClassPkIdAndClassPkNameAndUser(
                                                    customerId ,
                                                    classPkId,
                                                    classPkName,
                                                    UserId);
        if(emoticonEntry == null ){
            return;
        }
        throw  new DG_NoSuchEntryException(_languageService.getMessage(locale, "emoticon.creator.Expressive"));
    }

    public void validatorEmojiNotFound(String emoji ,
                                       Locale locale) throws DG_NoSuchEntryException {

        switch (emoji) {
            case "like":
            case "haha":
            case "love":
            case "wow":
            case "angry":
            case "sad":
                return ;
            default:
                throw  new DG_NoSuchEntryException(_languageService.getMessage(locale, "emoticon.emoji.not.found"));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private EmoticonEntryLocalService _emoticonEntryLocalService ;
}
