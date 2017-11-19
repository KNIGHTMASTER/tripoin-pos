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
@Table(name = "mst_company")
public class Company extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4144907972179173016L;

    private Set<Branch> branch;

    @JsonManagedReference
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Branch> getBranch() {
        return branch;
    }

    public void setBranch(Set<Branch> branch) {
        this.branch = branch;
    }

    @Override
    public String tableName() {
        return "mst_company";
    }
}
