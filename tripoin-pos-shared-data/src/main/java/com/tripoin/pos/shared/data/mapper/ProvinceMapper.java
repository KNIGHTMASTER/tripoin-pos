package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ProvinceResponseDTO;
import com.tripoin.pos.shared.data.model.master.Province;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProvinceMapper extends ADATAMapper<Province, ProvinceResponseDTO> {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public ProvinceResponseDTO convert(Province province) {
        ProvinceResponseDTO responseDTO = new ProvinceResponseDTO();
        responseDTO.setId(province.getId());
        responseDTO.setCode(province.getCode());
        responseDTO.setName(province.getName());
        responseDTO.setRemarks(province.getRemarks());
        if (province.getCountry() != null) {
            responseDTO.setCountry(countryMapper.convert(province.getCountry()));
        }
        return responseDTO;
    }
}
