package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.AddressResponseDTO;
import com.tripoin.pos.shared.data.model.master.Address;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class AddressMapper extends ADATAMapper<Address, AddressResponseDTO> {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private VillageMapper villageMapper;

    @Override
    public AddressResponseDTO convert(Address address) {
        AddressResponseDTO responseDTO = new AddressResponseDTO();
        responseDTO.setId(address.getId());
        responseDTO.setCode(address.getCode());
        responseDTO.setName(address.getName());
        responseDTO.setRemarks(address.getRemarks());
        responseDTO.setDetailAddress(address.getDetailAddress());
        responseDTO.setPostalCode(address.getPostalCode());
        if (address.getCountry() != null) {
            responseDTO.setCountry(countryMapper.convert(address.getCountry()));
        }
        if (address.getProvince() != null) {
            responseDTO.setProvince(provinceMapper.convert(address.getProvince()));
        }
        if (address.getCity() != null) {
            responseDTO.setCity(cityMapper.convert(address.getCity()));
        }
        if (address.getDistrict() != null) {
            responseDTO.setDistrict(districtMapper.convert(address.getDistrict()));
        }
        if (address.getVillage() != null) {
            responseDTO.setVillage(villageMapper.convert(address.getVillage()));
        }
        return responseDTO;
    }
}
