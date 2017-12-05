package com.tripoin.pos.shared.data.model.trx;

import com.tripoin.pos.shared.data.model.master.Employee;
import com.tripoin.pos.shared.data.model.system.PaymentTypeDetail;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_payment")
public class Payment extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7896539099689971198L;

    private PaymentTypeDetail paymentType;
    private Employee employee;
    private Date trxDate;
    private Integer totalItem;
    private Double tax;
    private Integer refferenceId;

    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    public PaymentTypeDetail getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeDetail paymentType) {
        this.paymentType = paymentType;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

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

    @Column(name = "tax")
    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Column(name = "reff_id")
    public Integer getRefferenceId() {
        return refferenceId;
    }

    public void setRefferenceId(Integer refferenceId) {
        this.refferenceId = refferenceId;
    }

    @Override
    public String tableName() {
        return "trx_payment";
    }
}
