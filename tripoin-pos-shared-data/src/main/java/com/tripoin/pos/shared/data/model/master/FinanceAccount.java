package com.tripoin.pos.shared.data.model.master;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import javax.validation.constraints.Max;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_finance_account")
public class FinanceAccount extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4265486300540903767L;

    private String accountNumber;
    private Bank bank;

    @Column(name = "account_number")
    @Max(value = 50)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String tableName() {
        return "mst_finance_account";
    }
}
