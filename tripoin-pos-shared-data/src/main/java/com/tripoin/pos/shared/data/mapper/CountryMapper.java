package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.CountryResponseDTO;
import com.tripoin.pos.shared.data.model.master.Country;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CountryMapper extends ADATAMapper<Country, CountryResponseDTO> {

    @Override
    public CountryResponseDTO convert(Country country) {
        CountryResponseDTO responseDTO = new CountryResponseDTO();
        responseDTO.setId(country.getId());
        responseDTO.setCode(country.getCode());
        responseDTO.setName(country.getName());
        responseDTO.setRemarks(country.getRemarks());
        return responseDTO;
    }
}
