package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ContactResponseDTO;
import com.tripoin.pos.shared.data.model.master.Contact;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ContactMapper extends ADATAMapper<Contact, ContactResponseDTO> {
    @Override
    public ContactResponseDTO convert(Contact contact) {
        ContactResponseDTO responseDTO = new ContactResponseDTO();
        responseDTO.setPersonalNumber(contact.getPersonalNumber());
        responseDTO.setPhoneNumber1(contact.getPhoneNumber1());
        responseDTO.setPhoneNumber2(contact.getPhoneNumber2());
        responseDTO.setFaxNumber(contact.getFaxNumber());
        responseDTO.setEmail(contact.getEmail());
        return responseDTO;
    }
}
