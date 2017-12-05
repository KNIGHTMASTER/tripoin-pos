package com.tripoin.pos.shared.data.model.master;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created on Oct 30, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_employee")
public class Employee extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8022359358845268458L;

    @Override
    public String tableName() {
        return "mst_employee";
    }
}
