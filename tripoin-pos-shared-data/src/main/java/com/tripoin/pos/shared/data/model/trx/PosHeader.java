package com.tripoin.pos.shared.data.model.trx;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.pos.shared.data.model.master.Employee;
import com.tripoin.pos.shared.data.model.master.PointOfSales;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_pos_header")
public class PosHeader extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4278258449729347649L;

    private CashierBalanceDetail cashierBalanceDetail;
    private PointOfSales pointOfSales;
    private Employee employee;
    private BigDecimal debit;
    private BigDecimal credit;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "trx_cashier_balance_detail_id")
    public CashierBalanceDetail getCashierBalanceDetail() {
        return cashierBalanceDetail;
    }

    public void setCashierBalanceDetail(CashierBalanceDetail cashierBalanceDetail) {
        this.cashierBalanceDetail = cashierBalanceDetail;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pos_id")
    public PointOfSales getPointOfSales() {
        return pointOfSales;
    }

    public void setPointOfSales(PointOfSales pointOfSales) {
        this.pointOfSales = pointOfSales;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Column(name = "debit")
    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    @Column(name = "credit")
    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public String tableName() {
        return "trx_pos_header";
    }
}
