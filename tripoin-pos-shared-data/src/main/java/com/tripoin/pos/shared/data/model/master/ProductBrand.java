package com.tripoin.pos.shared.data.model.master;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Set;

/**
 * Created on 11/19/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_product_brand")
public class ProductBrand extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8478198949012356307L;

    private Set<Product> products;

    @JsonManagedReference(value = "productBrand")
    @OneToMany(mappedBy = "productBrand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String tableName() {
        return "mst_product_brand";
    }
}
