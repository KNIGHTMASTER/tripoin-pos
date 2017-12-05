package com.tripoin.pos.shared.data.model.system;

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
@Table(name = "sys_payment_type_detail")
public class PaymentTypeDetail extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1099821405484266283L;

    private Integer paymentType;
    private String cardNumber;
    private String receipt;

    @Column(name = "payment_type")
    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @Column(name = "card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Column(name = "receipt")
    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    @Override
    public String tableName() {
        return "sys_payment_type_detail";
    }
}
