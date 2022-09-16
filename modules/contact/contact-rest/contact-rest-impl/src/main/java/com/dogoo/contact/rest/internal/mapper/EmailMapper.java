package com.dogoo.contact.rest.internal.mapper;


import com.dogoo.contact.rest.dto.v2_0.Email;
import com.dogoo.contact.service.model.EmailEntry;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        service = EmailMapper.class
)
public class EmailMapper {

    public Email mapEmailFromEmailEntry(EmailEntry from) {
        Email to = new Email();

        to.setId(from.getEmailId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setDescription(from.getDescription());
        to.setEmailAddress(from.getEmailAddress());
        to.setIsDefaulted(from.getIsDefaulted());

        return to;
    }

    public  Email[] mapEmailListFromEmailEntries(List<EmailEntry> from) {
        List<Email> to = new ArrayList<>();
        from.forEach(item -> {
            to.add(mapEmailFromEmailEntry(item));
        });
        Email[] emailArray = new Email[to.size()];
        emailArray = to.toArray(emailArray );
        return emailArray;
    }
}
