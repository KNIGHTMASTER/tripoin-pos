package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.pos.shared.data.dto.response.master.ProductResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ReturDetailResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3190037569791160451L;

    private ReturHeaderResponseDTO returHeader;
    private ProductResponseDTO product;
    private BigDecimal itemPrice;
    private Integer qty;
    private String productName;

    public ReturHeaderResponseDTO getReturHeader() {
        return returHeader;
    }

    public void setReturHeader(ReturHeaderResponseDTO returHeader) {
        this.returHeader = returHeader;
    }

    public ProductResponseDTO getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDTO product) {
        this.product = product;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
