package com.tripoin.pos.shared.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Set;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_bank")
public class Bank extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4144907972179173016L;

    private Set<FinanceAccount> financeAccounts;

    @JsonManagedReference
    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<FinanceAccount> getFinanceAccounts() {
        return financeAccounts;
    }

    public void setFinanceAccounts(Set<FinanceAccount> financeAccounts) {
        this.financeAccounts = financeAccounts;
    }

    @Override
    public String tableName() {
        return "mst_bank";
    }
}
