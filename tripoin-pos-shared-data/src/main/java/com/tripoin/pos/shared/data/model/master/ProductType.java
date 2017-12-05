package com.tripoin.pos.shared.data.model.master;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "mst_product_type")
public class ProductType extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4511414093059596310L;

    private Set<Product> products;
    private ProductCategory productCategory;

    @Override
    public String tableName() {
        return "mst_product_type";
    }

    @JsonBackReference(value = "productCategoryProductType")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @JsonManagedReference(value = "productType")
    @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
