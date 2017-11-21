package com.tripoin.pos.shared.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;

/**
 * created on 1/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_village")
public class Village extends AAuditTrail {
    private static final long serialVersionUID = -882333480264178395L;

    @Override
    public String tableName() {
        return "mst_village";
    }

    @JsonBackReference
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Village{" +
                "district=" + district +
                '}';
    }
}
