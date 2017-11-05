package com.tripoin.pos.shared.data.model;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

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

    @Override
    public String tableName() {
        return "mst_company";
    }
}
