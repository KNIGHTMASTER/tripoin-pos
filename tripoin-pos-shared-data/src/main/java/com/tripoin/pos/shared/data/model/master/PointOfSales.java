package com.tripoin.pos.shared.data.model.master;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_point_of_sales")
public class PointOfSales extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6057533287308849005L;

    @Override
    public String tableName() {
        return "mst_point_of_sales";
    }
}
