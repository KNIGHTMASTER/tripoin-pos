package com.tripoin.pos.shared.data.model.master;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tripoin.pos.shared.data.model.trx.Price;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private Set<Price> prices;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "promo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }


    @Override
    public String tableName() {
        return "trx_promo";
    }
}
