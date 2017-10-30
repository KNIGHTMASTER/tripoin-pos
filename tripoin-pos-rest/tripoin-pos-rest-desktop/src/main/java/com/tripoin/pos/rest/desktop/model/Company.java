package com.tripoin.pos.rest.desktop.model;

import id.co.telkomsigma.core.data.AAuditTrail;

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


    @Override
    public String tableName() {
        return "mst_company";
    }
}
