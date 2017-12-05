package com.tripoin.pos.shared.data.model.master;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.pos.shared.data.model.trx.Price;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_product")
public class Product extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5652993912169160783L;

    private ProductCategory productCategory;
    private ProductType productType;
    private ProductBrand productBrand;
    private Supplier supplier;
    private Price price;
    private ProductStock productStock;
    private ProductGuarantee productGuarantee;
    private String imageUrl;

    @JsonBackReference(value = "productCategory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @JsonBackReference(value = "productType")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @JsonBackReference(value = "productBrand")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }

    @JsonBackReference(value = "supplier")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    public ProductStock getProductStock() {
        return productStock;
    }

    public void setProductStock(ProductStock productStock) {
        this.productStock = productStock;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guarantee_id")
    public ProductGuarantee getProductGuarantee() {
        return productGuarantee;
    }

    public void setProductGuarantee(ProductGuarantee productGuarantee) {
        this.productGuarantee = productGuarantee;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String tableName() {
        return "mst_product";
    }
}
