package com.tripoin.pos.shared.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_product_stock")
public class ProductStock extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8781346168552375893L;

    private Integer warehouseStock;
    private Integer displayStock;
    private ProductUnit productUnit;

    private Product product;

    @Column(name = "warehouse_stock")
    public Integer getWarehouseStock() {
        return warehouseStock;
    }

    public void setWarehouseStock(Integer warehouseStock) {
        this.warehouseStock = warehouseStock;
    }

    @Column(name = "display_stock")
    public Integer getDisplayStock() {
        return displayStock;
    }

    public void setDisplayStock(Integer displayStock) {
        this.displayStock = displayStock;
    }

    @JsonBackReference(value = "unitStock")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    public ProductUnit getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    @OneToOne(mappedBy = "productStock")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String tableName() {
        return "mst_product_stock";
    }
}
