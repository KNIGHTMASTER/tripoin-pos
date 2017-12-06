package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.CityResponseDTO;
import com.tripoin.pos.shared.data.model.master.City;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CityMapper extends ADATAMapper<City, CityResponseDTO> {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public CityResponseDTO convert(City city) {
        CityResponseDTO responseDTO = new CityResponseDTO();
        responseDTO.setId(city.getId());
        responseDTO.setCode(city.getCode());
        responseDTO.setName(city.getName());
        responseDTO.setRemarks(city.getRemarks());
        if (city.getProvince() != null) {
            responseDTO.setProvince(provinceMapper.convert(city.getProvince()));
        }
        return responseDTO;
    }
}
