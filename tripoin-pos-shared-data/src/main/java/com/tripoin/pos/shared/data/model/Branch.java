package com.tripoin.pos.shared.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;

/**
 * Created on 11/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_branch")
public class Branch extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1471277092740839775L;

    private Company company;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String tableName() {
        return "mst_branch";
    }

}
