package com.tripoin.pos.shared.data.mapper.system;

import com.tripoin.pos.shared.data.dto.response.system.ParameterResponseDTO;
import com.tripoin.pos.shared.data.model.system.Parameter;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ParameterMapper extends ADATAMapper<Parameter, ParameterResponseDTO> {
    @Override
    public ParameterResponseDTO convert(Parameter parameter) {
        ParameterResponseDTO responseDTO = new ParameterResponseDTO();
        responseDTO.setId(parameter.getId());
        responseDTO.setCode(parameter.getCode());
        responseDTO.setName(parameter.getName());
        responseDTO.setRemarks(parameter.getRemarks());
        return responseDTO;
    }
}
