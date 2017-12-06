package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.pos.shared.data.dto.response.master.ProductResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PurchaseDetailResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2459870983175509704L;

    private PurchaseHeaderResponseDTO purchaseHeader;
    private ProductResponseDTO product;
    private Integer qty;
    private BigDecimal itemPrice;
    private String productName;

    public PurchaseHeaderResponseDTO getPurchaseHeader() {
        return purchaseHeader;
    }

    public void setPurchaseHeader(PurchaseHeaderResponseDTO purchaseHeader) {
        this.purchaseHeader = purchaseHeader;
    }

    public ProductResponseDTO getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDTO product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
