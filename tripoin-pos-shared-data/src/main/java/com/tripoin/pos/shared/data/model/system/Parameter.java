package com.tripoin.pos.shared.data.model.system;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "sys_parameter")
public class Parameter extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5239065055309852645L;

    @Override
    public String tableName() {
        return "sys_parameter";
    }
}
