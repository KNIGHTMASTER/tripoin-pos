package com.tripoin.pos.shared.data.dto.response.master;

import com.tripoin.pos.shared.data.dto.response.trx.PriceResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProductBrandResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8669008868142138581L;

    private ProductCategoryResponseDTO productCategory;
    private ProductTypeResponseDTO productType;
    private ProductBrandResponseDTO productBrand;
    private SupplierResponseDTO supplier;
    private PriceResponseDTO price;
    private ProductStockResponseDTO productStock;

    public ProductCategoryResponseDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryResponseDTO productCategory) {
        this.productCategory = productCategory;
    }

    public ProductTypeResponseDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeResponseDTO productType) {
        this.productType = productType;
    }

    public ProductBrandResponseDTO getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrandResponseDTO productBrand) {
        this.productBrand = productBrand;
    }

    public SupplierResponseDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierResponseDTO supplier) {
        this.supplier = supplier;
    }

    public PriceResponseDTO getPrice() {
        return price;
    }

    public void setPrice(PriceResponseDTO price) {
        this.price = price;
    }

    public ProductStockResponseDTO getProductStock() {
        return productStock;
    }

    public void setProductStock(ProductStockResponseDTO productStock) {
        this.productStock = productStock;
    }
}
