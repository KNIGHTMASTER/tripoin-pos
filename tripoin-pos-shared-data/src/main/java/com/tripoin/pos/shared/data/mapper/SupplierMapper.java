package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.SupplierResponseDTO;
import com.tripoin.pos.shared.data.model.master.Supplier;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SupplierMapper extends ADATAMapper<Supplier, SupplierResponseDTO> {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public SupplierResponseDTO convert(Supplier supplier) {
        SupplierResponseDTO responseDTO = new SupplierResponseDTO();
        responseDTO.setId(supplier.getId());
        responseDTO.setCode(supplier.getCode());
        responseDTO.setName(supplier.getName());
        responseDTO.setRemarks(supplier.getRemarks());
        if (supplier.getAddress() != null) {
            responseDTO.setAddress(addressMapper.convert(supplier.getAddress()));
        }
        if (supplier.getContact() != null) {
            responseDTO.setContact(contactMapper.convert(supplier.getContact()));
        }
        return responseDTO;
    }
}
