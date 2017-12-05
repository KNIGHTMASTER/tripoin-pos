package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ProductUnitResponseDTO;
import com.tripoin.pos.shared.data.model.master.ProductUnit;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class UnitMapper extends ADATAMapper<ProductUnit, ProductUnitResponseDTO> {

    @Override
    public ProductUnitResponseDTO convert(ProductUnit productUnit) {
        ProductUnitResponseDTO responseDTO = new ProductUnitResponseDTO();
        responseDTO.setId(productUnit.getId());
        responseDTO.setCode(productUnit.getCode());
        responseDTO.setName(productUnit.getName());
        responseDTO.setRemarks(productUnit.getRemarks());
        return responseDTO;
    }
}
