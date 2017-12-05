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
@Table(name = "trx_cashier_balance_header")
public class CashierBalanceHeader extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5226846971213817604L;

    private Date trxDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "trx_date")
    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    @Override
    public String tableName() {
        return "trx_cashier_balance_header";
    }
}
