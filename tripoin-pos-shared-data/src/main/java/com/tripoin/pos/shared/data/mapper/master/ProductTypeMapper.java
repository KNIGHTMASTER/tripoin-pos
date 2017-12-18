package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.ProductTypeResponseDTO;
import com.tripoin.pos.shared.data.model.master.ProductType;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductTypeMapper extends ADATAMapper<ProductType, ProductTypeResponseDTO> {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductTypeResponseDTO convert(ProductType productType) {
        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();
        productTypeResponseDTO.setImageUrl(productType.getImageUrl());
        productTypeResponseDTO.setId(productType.getId());
        productTypeResponseDTO.setCode(productType.getCode());
        productTypeResponseDTO.setName(productType.getName());
        if (productType.getProductCategory() != null) {
            productTypeResponseDTO.setProductCategory(productCategoryMapper.convert(productType.getProductCategory()));
        }
        productTypeResponseDTO.setRemarks(productType.getRemarks());
        return productTypeResponseDTO;
    }
}
