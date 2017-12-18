package com.tripoin.pos.shared.data.model.master;

import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_product_guarantee")
public class ProductGuarantee extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5098370836414057605L;

    private Integer merchantGuarantee;
    private Integer brandGuarantee;

    private Product product;

    @Column(name = "merchant_guarantee")
    public Integer getMerchantGuarantee() {
        return merchantGuarantee;
    }

    public void setMerchantGuarantee(Integer merchantGuarantee) {
        this.merchantGuarantee = merchantGuarantee;
    }

    @Column(name = "brand_guarantee")
    public Integer getBrandGuarantee() {
        return brandGuarantee;
    }

    public void setBrandGuarantee(Integer brandGuarantee) {
        this.brandGuarantee = brandGuarantee;
    }

    @OneToOne(mappedBy = "productGuarantee", cascade = CascadeType.ALL)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String tableName() {
        return "mst_product_guarantee";
    }
}
