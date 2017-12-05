package com.tripoin.pos.shared.data.model.master;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Set;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_product_unit")
public class ProductUnit extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1042260722271465002L;

    private Set<ProductStock> productStocks;

    @Override
    public String tableName() {
        return "mst_product_unit";
    }

    @JsonManagedReference(value = "unitStock")
    @OneToMany(mappedBy = "productUnit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<ProductStock> getProductStocks() {
        return productStocks;
    }

    public void setProductStocks(Set<ProductStock> productStocks) {
        this.productStocks = productStocks;
    }
}
