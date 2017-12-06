package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ReturHeaderResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2586958841382163325L;

    private Date trxDate;
    private Integer totalItem;
    private BigDecimal totalPrice;
    private Integer refferenceId;
    private String customerName;
    private String phoneNumber;
    private Integer appSpv;

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getRefferenceId() {
        return refferenceId;
    }

    public void setRefferenceId(Integer refferenceId) {
        this.refferenceId = refferenceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAppSpv() {
        return appSpv;
    }

    public void setAppSpv(Integer appSpv) {
        this.appSpv = appSpv;
    }
}
