package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.pos.shared.data.dto.response.master.EmployeeResponseDTO;
import com.tripoin.pos.shared.data.dto.response.system.PaymentTypeDetailResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PaymentResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4167537399323982156L;

    private PaymentTypeDetailResponseDTO paymentTypeDetail;
    private EmployeeResponseDTO employeeResponse;
    private Date trxDate;
    private Integer totalItem;
    private BigDecimal totalPrice;
    private BigDecimal tax;
    private Integer refferenceId;

    public PaymentTypeDetailResponseDTO getPaymentTypeDetail() {
        return paymentTypeDetail;
    }

    public void setPaymentTypeDetail(PaymentTypeDetailResponseDTO paymentTypeDetail) {
        this.paymentTypeDetail = paymentTypeDetail;
    }

    public EmployeeResponseDTO getEmployeeResponse() {
        return employeeResponse;
    }

    public void setEmployeeResponse(EmployeeResponseDTO employeeResponse) {
        this.employeeResponse = employeeResponse;
    }

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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Integer getRefferenceId() {
        return refferenceId;
    }

    public void setRefferenceId(Integer refferenceId) {
        this.refferenceId = refferenceId;
    }
}
