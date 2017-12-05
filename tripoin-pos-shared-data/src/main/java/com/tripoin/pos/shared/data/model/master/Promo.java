package com.tripoin.pos.shared.data.model.master;

import com.tripoin.pos.shared.data.model.trx.Price;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_promo")
public class Promo extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3367863301270679599L;

    private Date startDate;
    private Date endDate;
    private Double discountRate;
    private Price price;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "discount_rate")
    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    @OneToOne(mappedBy = "promo")
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String tableName() {
        return "trx_promo";
    }
}
