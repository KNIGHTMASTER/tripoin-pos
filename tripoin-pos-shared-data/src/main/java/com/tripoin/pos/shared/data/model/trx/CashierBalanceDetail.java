package com.tripoin.pos.shared.data.model.trx;

import com.tripoin.pos.shared.data.model.system.PosShift;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_cashier_balance_detail")
public class CashierBalanceDetail extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7830037713602315233L;

    private CashierBalanceHeader cashierBalanceHeader;
    private Integer isAppSpv;
    private Date appSpvTime;
    private PosShift posShift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trx_cashier_header_id")
    public CashierBalanceHeader getCashierBalanceHeader() {
        return cashierBalanceHeader;
    }

    public void setCashierBalanceHeader(CashierBalanceHeader cashierBalanceHeader) {
        this.cashierBalanceHeader = cashierBalanceHeader;
    }

    @Column(name = "is_app_spv")
    public Integer getIsAppSpv() {
        return isAppSpv;
    }

    public void setIsAppSpv(Integer isAppSpv) {
        this.isAppSpv = isAppSpv;
    }

    @Column(name = "app_spv_time")
    public Date getAppSpvTime() {
        return appSpvTime;
    }

    public void setAppSpvTime(Date appSpvTime) {
        this.appSpvTime = appSpvTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id")
    public PosShift getPosShift() {
        return posShift;
    }

    public void setPosShift(PosShift posShift) {
        this.posShift = posShift;
    }

    @Override
    public String tableName() {
        return "trx_cashier_balance_detail";
    }
}
