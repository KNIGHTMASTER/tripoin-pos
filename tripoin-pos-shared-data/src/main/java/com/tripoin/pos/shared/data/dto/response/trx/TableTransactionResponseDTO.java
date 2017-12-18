package com.tripoin.pos.shared.data.dto.response.trx;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created on 12/17/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TableTransactionResponseDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5630089728232247192L;
    private String product;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal total;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
