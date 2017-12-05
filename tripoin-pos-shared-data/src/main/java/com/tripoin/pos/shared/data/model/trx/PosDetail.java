package com.tripoin.pos.shared.data.model.trx;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_pos_detail")
public class PosDetail extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6565410956491308075L;

    private PosHeader posHeader;
    private BigDecimal openBalance;
    private Date openTime;
    private Integer isOpenBalance;
    private BigDecimal closeBalance;
    private Date closeTime;
    private Integer isCloseBalance;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trx_pos_header_id")
    public PosHeader getPosHeader() {
        return posHeader;
    }

    public void setPosHeader(PosHeader posHeader) {
        this.posHeader = posHeader;
    }

    @Column(name = "open_balance")
    public BigDecimal getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(BigDecimal openBalance) {
        this.openBalance = openBalance;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "open_time")
    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    @Column(name = "is_open_balance")
    public Integer getIsOpenBalance() {
        return isOpenBalance;
    }

    public void setIsOpenBalance(Integer isOpenBalance) {
        this.isOpenBalance = isOpenBalance;
    }

    @Column(name = "close_balance")
    public BigDecimal getCloseBalance() {
        return closeBalance;
    }

    public void setCloseBalance(BigDecimal closeBalance) {
        this.closeBalance = closeBalance;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "close_time")
    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    @Column(name = "is_close_balance")
    public Integer getIsCloseBalance() {
        return isCloseBalance;
    }

    public void setIsCloseBalance(Integer isCloseBalance) {
        this.isCloseBalance = isCloseBalance;
    }

    @Override
    public String tableName() {
        return "trx_pos_detail";
    }
}
