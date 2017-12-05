package com.tripoin.pos.shared.data.model.trx;

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
@Table(name = "trx_retur_header")
public class ReturHeader extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -9040562564150790326L;

    private Date trxDate;
    private Integer totalItem;
    private BigDecimal totalPrice;
    private Integer refferenceId;
    private String customerName;
    private String phoneNumber;
    private Integer appSpv;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "trx_date")
    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    @Column(name = "total_item")
    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    @Column(name = "total_price")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name = "reff_id")
    public Integer getRefferenceId() {
        return refferenceId;
    }

    public void setRefferenceId(Integer refferenceId) {
        this.refferenceId = refferenceId;
    }

    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "app_spv")
    public Integer getAppSpv() {
        return appSpv;
    }

    public void setAppSpv(Integer appSpv) {
        this.appSpv = appSpv;
    }

    @Override
    public String tableName() {
        return "trx_retur_header";
    }
}
