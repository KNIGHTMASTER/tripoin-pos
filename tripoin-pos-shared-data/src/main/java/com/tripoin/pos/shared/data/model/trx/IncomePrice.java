package com.tripoin.pos.shared.data.model.trx;

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
@Table(name = "trx_income_price")
public class IncomePrice extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4410833623532480454L;

    private BigDecimal capitalPrice;
    private Integer capitalQuantity;
    private Price price;

    @Column(name = "capital_price")
    public BigDecimal getCapitalPrice() {
        return capitalPrice;
    }

    public void setCapitalPrice(BigDecimal capitalPrice) {
        this.capitalPrice = capitalPrice;
    }

    @Column(name = "capital_quantity")
    public Integer getCapitalQuantity() {
        return capitalQuantity;
    }

    public void setCapitalQuantity(Integer capitalQuantity) {
        this.capitalQuantity = capitalQuantity;
    }

    @OneToOne(mappedBy = "incomePrice")
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String tableName() {
        return "trx_income_price";
    }
}
