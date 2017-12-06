package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.DistrictResponseDTO;
import com.tripoin.pos.shared.data.model.master.District;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class DistrictMapper extends ADATAMapper<District, DistrictResponseDTO> {

    @Autowired
    private CityMapper cityMapper;
    @Override
    public DistrictResponseDTO convert(District district) {
        DistrictResponseDTO responseDTO = new DistrictResponseDTO();
        responseDTO.setId(district.getId());
        responseDTO.setCode(district.getCode());
        responseDTO.setName(district.getName());
        responseDTO.setRemarks(district.getRemarks());
        if (district.getCity() != null){
            responseDTO.setCity(cityMapper.convert(district.getCity()));
        }
        return responseDTO;
    }
}
