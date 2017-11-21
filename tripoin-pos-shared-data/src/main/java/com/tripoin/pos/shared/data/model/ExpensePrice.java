package com.tripoin.pos.shared.data.model;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_expense_price")
public class ExpensePrice extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6520189491675373166L;

    private Integer retailQuantity;
    private BigDecimal retailPrice;
    private Integer distributorQuantity;
    private BigDecimal distributorPrice;
    private Price price;

    @Column(name = "retail_quantity")
    public Integer getRetailQuantity() {
        return retailQuantity;
    }

    public void setRetailQuantity(Integer retailQuantity) {
        this.retailQuantity = retailQuantity;
    }

    @Column(name = "retail_price")
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Column(name = "distributor_quantity")
    public Integer getDistributorQuantity() {
        return distributorQuantity;
    }

    public void setDistributorQuantity(Integer distributorQuantity) {
        this.distributorQuantity = distributorQuantity;
    }

    @Column(name = "distributor_price")
    public BigDecimal getDistributorPrice() {
        return distributorPrice;
    }

    public void setDistributorPrice(BigDecimal distributorPrice) {
        this.distributorPrice = distributorPrice;
    }

    @OneToOne(mappedBy = "expensePrice")
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String tableName() {
        return "trx_expense_price";
    }
}
