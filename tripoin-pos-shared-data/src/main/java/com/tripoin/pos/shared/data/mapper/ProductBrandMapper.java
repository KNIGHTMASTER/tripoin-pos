package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ProductBrandResponseDTO;
import com.tripoin.pos.shared.data.model.ProductBrand;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductBrandMapper extends ADATAMapper<ProductBrand, ProductBrandResponseDTO> {

    @Override
    public ProductBrandResponseDTO convert(ProductBrand p_ProductBrand) {
        ProductBrandResponseDTO productCategory = new ProductBrandResponseDTO();
        productCategory.setId(p_ProductBrand.getId());
        productCategory.setCode(p_ProductBrand.getCode());
        productCategory.setName(p_ProductBrand.getName());
        productCategory.setRemarks(p_ProductBrand.getRemarks());
        return productCategory;
    }
}
