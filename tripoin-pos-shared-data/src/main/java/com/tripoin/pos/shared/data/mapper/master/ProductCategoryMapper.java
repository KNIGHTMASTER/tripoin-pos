package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.ProductCategoryResponseDTO;
import com.tripoin.pos.shared.data.model.master.ProductCategory;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductCategoryMapper extends ADATAMapper<ProductCategory, ProductCategoryResponseDTO> {

    @Override
    public ProductCategoryResponseDTO convert(ProductCategory p_ProductCategory) {
        ProductCategoryResponseDTO productCategory = new ProductCategoryResponseDTO();
        productCategory.setId(p_ProductCategory.getId());
        productCategory.setCode(p_ProductCategory.getCode());
        productCategory.setName(p_ProductCategory.getName());
        productCategory.setRemarks(p_ProductCategory.getRemarks());
        return productCategory;
    }
}
