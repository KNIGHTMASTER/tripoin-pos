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
@Table(name = "trx_purchase_detail")
public class PurchaseDetail extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5584753883253857691L;

    private PurchaseHeader purchaseHeader;
    private Product product;
    private Integer quantity;
    private BigDecimal itemPrice;
    private String productName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_header_id")
    public PurchaseHeader getPurchaseHeader() {
        return purchaseHeader;
    }

    public void setPurchaseHeader(PurchaseHeader purchaseHeader) {
        this.purchaseHeader = purchaseHeader;
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

    @Column(name = "qty")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "item_price")
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
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
        return "trx_purchase_detail";
    }
}
