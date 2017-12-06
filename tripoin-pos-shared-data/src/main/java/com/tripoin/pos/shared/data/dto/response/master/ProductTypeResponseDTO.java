package com.tripoin.pos.shared.data.dto.response.master;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProductTypeResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4458327710851194936L;

    private ProductCategoryResponseDTO productCategory;

    public ProductCategoryResponseDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryResponseDTO productCategory) {
        this.productCategory = productCategory;
    }
}
