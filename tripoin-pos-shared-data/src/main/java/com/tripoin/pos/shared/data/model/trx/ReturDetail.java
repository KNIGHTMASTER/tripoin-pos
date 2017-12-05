package com.tripoin.pos.shared.data.model.trx;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.pos.shared.data.model.master.Product;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_retur_detail")
public class ReturDetail extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4313546557216689448L;

    private ReturHeader returHeader;
    private Product product;
    private BigDecimal itemPrice;
    private Integer qty;
    private String productName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "retur_header_id")
    public ReturHeader getReturHeader() {
        return returHeader;
    }

    public void setReturHeader(ReturHeader returHeader) {
        this.returHeader = returHeader;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "item_price")
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Column(name = "qty")
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String tableName() {
        return "trx_retur_detail";
    }
}
