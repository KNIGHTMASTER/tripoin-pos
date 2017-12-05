package com.tripoin.pos.shared.data.model.trx;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 12/5/17.
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
    private static final long serialVersionUID = -8574415324115531774L;

    private Date startDate;
    private Date endDate;
    private Double discountRate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
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

    @Override
    public String tableName() {
        return "trx_promo";
    }
}
