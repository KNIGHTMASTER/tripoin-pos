package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.VillageResponseDTO;
import com.tripoin.pos.shared.data.model.master.Village;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class VillageMapper extends ADATAMapper<Village, VillageResponseDTO> {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public VillageResponseDTO convert(Village village) {
        VillageResponseDTO responseDTO = new VillageResponseDTO();
        responseDTO.setId(village.getId());
        responseDTO.setCode(village.getCode());
        responseDTO.setName(village.getName());
        responseDTO.setRemarks(village.getRemarks());
        if (village.getDistrict() != null) {
            responseDTO.setDistrict(districtMapper.convert(village.getDistrict()));
        }
        return responseDTO;
    }
}
