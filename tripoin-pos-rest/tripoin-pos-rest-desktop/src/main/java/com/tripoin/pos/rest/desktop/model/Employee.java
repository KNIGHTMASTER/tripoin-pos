package com.tripoin.pos.rest.desktop.model;

import id.co.telkomsigma.core.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created on Oct 30, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_employee")
public class Employee extends AAuditTrail {


    @Override
    public String tableName() {
        return "mst_employee";
    }
}
