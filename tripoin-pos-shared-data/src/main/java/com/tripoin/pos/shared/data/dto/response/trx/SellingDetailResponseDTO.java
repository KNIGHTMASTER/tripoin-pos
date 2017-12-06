package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.pos.shared.data.dto.response.master.ProductResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SellingDetailResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5093887131486455296L;

    private SellingHeaderResponseDTO sellingHeader;
    private ProductResponseDTO product;
    private BigDecimal itemPrice;
    private Integer qty;
    private String productName;

    public SellingHeaderResponseDTO getSellingHeader() {
        return sellingHeader;
    }

    public void setSellingHeader(SellingHeaderResponseDTO sellingHeader) {
        this.sellingHeader = sellingHeader;
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
