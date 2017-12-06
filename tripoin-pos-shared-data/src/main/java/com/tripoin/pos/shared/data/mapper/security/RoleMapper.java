package com.tripoin.pos.shared.data.mapper.security;

import com.tripoin.pos.shared.data.dto.response.security.RoleResponseDTO;
import com.tripoin.pos.shared.data.model.security.Role;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class RoleMapper extends ADATAMapper<Role, RoleResponseDTO> {

    @Override
    public RoleResponseDTO convert(Role role) {
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.setId(role.getId());
        responseDTO.setCode(role.getCode());
        responseDTO.setName(role.getName());
        responseDTO.setRemarks(role.getRemarks());
        return responseDTO;
    }
}
