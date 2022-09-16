package com.dogoo.contact.rest.internal.mapper;

import com.dogoo.contact.rest.dto.v2_0.Phone;
import com.dogoo.contact.rest.dto.v2_0.Phone;
import com.dogoo.contact.service.model.PhoneEntry;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;
@Component(
        immediate = true,
        service = PhoneMapper.class
)
public class PhoneMapper {

    public Phone mapPhoneFromPhoneEntry(PhoneEntry from) {
        Phone to = new Phone();

        to.setId(from.getPhoneId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setDescription(from.getDescription());
        to.setNumber(from.getNumber());
        to.setIsDefaulted(from.getIsDefaulted());

        return to;
    }

    public Phone[]mapPhoneListFromPhoneEntries(List<PhoneEntry> from) {
        List<Phone> to = new ArrayList<>();
        from.forEach(item -> {
            to.add(mapPhoneFromPhoneEntry(item));
        });
        Phone[] phoneArray = new Phone[to.size()];
        phoneArray = to.toArray(phoneArray );
        return phoneArray;
    }
}
