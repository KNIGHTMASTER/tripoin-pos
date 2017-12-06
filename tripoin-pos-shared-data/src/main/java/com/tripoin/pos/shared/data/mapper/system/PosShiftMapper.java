package com.tripoin.pos.shared.data.mapper.system;

import com.tripoin.pos.shared.data.dto.response.system.PosShiftResponseDTO;
import com.tripoin.pos.shared.data.model.system.PosShift;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PosShiftMapper extends ADATAMapper<PosShift, PosShiftResponseDTO> {
    @Override
    public PosShiftResponseDTO convert(PosShift posShift) {
        PosShiftResponseDTO responseDTO = new PosShiftResponseDTO();
        responseDTO.setId(posShift.getId());
        responseDTO.setCode(posShift.getCode());
        responseDTO.setName(posShift.getName());
        responseDTO.setRemarks(posShift.getRemarks());
        responseDTO.setStartTime(posShift.getStartTime());
        responseDTO.setEndTime(posShift.getEndTime());
        return responseDTO;
    }
}
