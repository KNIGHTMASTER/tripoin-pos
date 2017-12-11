package com.tripoin.pos.shared.data.dto.request;

import java.io.Serializable;

/**
 * Created on 12/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SelectLOVProductTypeByProductCategoryRequestDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2095999749500291082L;
    private String productCategoryId;

    public SelectLOVProductTypeByProductCategoryRequestDTO() {
    }

    public SelectLOVProductTypeByProductCategoryRequestDTO(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
