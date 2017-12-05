package com.tripoin.pos.shared.data.model.trx;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_tax")
public class Tax extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5973686576479842963L;

    private Double taxRate;

    @Column(name = "tax_rate")
    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String tableName() {
        return "trx_tax";
    }
}
