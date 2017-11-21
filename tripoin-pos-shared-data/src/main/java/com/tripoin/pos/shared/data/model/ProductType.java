package com.tripoin.pos.shared.data.model;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_product_type")
public class ProductType extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4511414093059596310L;

    @Override
    public String tableName() {
        return "mst_product_type";
    }
}
