package com.tripoin.pos.shared.data.dto.response.security;

import com.tripoin.pos.shared.data.dto.response.master.AddressResponseDTO;
import com.tripoin.pos.shared.data.dto.response.master.BranchResponseDTO;
import com.tripoin.pos.shared.data.dto.response.master.ContactResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class UserProfileResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8279028473062476939L;

    private AddressResponseDTO address;
    private ContactResponseDTO contact;
    private UserResponseDTO user;
    private BranchResponseDTO branch;

    public AddressResponseDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDTO address) {
        this.address = address;
    }

    public ContactResponseDTO getContact() {
        return contact;
    }

    public void setContact(ContactResponseDTO contact) {
        this.contact = contact;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    public BranchResponseDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchResponseDTO branch) {
        this.branch = branch;
    }
}
