package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ProductTypeResponseDTO;
import com.tripoin.pos.shared.data.model.ProductType;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductTypeMapper extends ADATAMapper<ProductType, ProductTypeResponseDTO> {

    @Override
    public ProductTypeResponseDTO convert(ProductType productType) {
        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();
        productTypeResponseDTO.setId(productType.getId());
        productTypeResponseDTO.setCode(productType.getCode());
        productTypeResponseDTO.setName(productType.getName());
        productTypeResponseDTO.setRemarks(productType.getRemarks());
        return productTypeResponseDTO;
    }
}
