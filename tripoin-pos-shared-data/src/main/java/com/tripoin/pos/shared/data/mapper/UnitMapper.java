package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.UnitResponseDTO;
import com.tripoin.pos.shared.data.model.Unit;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class UnitMapper extends ADATAMapper<Unit, UnitResponseDTO> {

    @Override
    public UnitResponseDTO convert(Unit unit) {
        UnitResponseDTO responseDTO = new UnitResponseDTO();
        responseDTO.setId(unit.getId());
        responseDTO.setCode(unit.getCode());
        responseDTO.setName(unit.getName());
        responseDTO.setRemarks(unit.getRemarks());
        return responseDTO;
    }
}
