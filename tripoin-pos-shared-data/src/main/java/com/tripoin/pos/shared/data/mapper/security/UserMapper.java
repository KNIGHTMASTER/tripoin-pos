package com.tripoin.pos.shared.data.mapper.security;

import com.tripoin.pos.shared.data.dto.response.security.UserResponseDTO;
import com.tripoin.pos.shared.data.model.security.User;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class UserMapper extends ADATAMapper<User, UserResponseDTO> {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserResponseDTO convert(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setCode(user.getCode());
        responseDTO.setName(user.getName());
        responseDTO.setRemarks(user.getRemarks());
        responseDTO.setEnabled(user.getEnabled());
        responseDTO.setExpiredDate(user.getExpiredDate());
        responseDTO.setCredentialsExpiredDate(user.getCredentialsExpiredDate());
        responseDTO.setNonLocked(user.getNonLocked());

        if (user.getRole() != null) {
            responseDTO.setRole(roleMapper.convert(user.getRole()));
        }
        return responseDTO;
    }
}
