package com.tripoin.pos.shared.data.mapper.security;

import com.tripoin.pos.shared.data.dto.response.security.UserProfileResponseDTO;
import com.tripoin.pos.shared.data.mapper.master.AddressMapper;
import com.tripoin.pos.shared.data.mapper.master.BranchMapper;
import com.tripoin.pos.shared.data.mapper.master.ContactMapper;
import com.tripoin.pos.shared.data.model.security.UserProfile;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class UserProfileMapper extends ADATAMapper<UserProfile, UserProfileResponseDTO> {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BranchMapper branchMapper;

    @Override
    public UserProfileResponseDTO convert(UserProfile userProfile) {
        UserProfileResponseDTO responseDTO = new UserProfileResponseDTO();
        responseDTO.setId(userProfile.getId());
        responseDTO.setCode(userProfile.getCode());
        responseDTO.setName(userProfile.getName());
        responseDTO.setRemarks(userProfile.getRemarks());
        if (userProfile.getContact() != null) {
            responseDTO.setContact(contactMapper.convert(userProfile.getContact()));
        }
        if (userProfile.getAddress() != null) {
            responseDTO.setAddress(addressMapper.convert(userProfile.getAddress()));
        }
        if (userProfile.getUser() != null) {
            responseDTO.setUser(userMapper.convert(userProfile.getUser()));
        }
        if (userProfile.getBranch() != null) {
            responseDTO.setBranch(branchMapper.convert(userProfile.getBranch()));
        }
        return responseDTO;
    }
}
