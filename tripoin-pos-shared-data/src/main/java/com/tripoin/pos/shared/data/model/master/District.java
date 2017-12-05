package com.tripoin.pos.shared.data.model.master;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_district")
public class District extends AAuditTrail {

    /**
     *
     *
     */
    private static final long serialVersionUID = -6165282598525095185L;

    @JsonManagedReference
    private Set<Village> villages;

    @JsonBackReference
    private City city;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    public Set<Village> getVillages() {
        return villages;
    }

    public void setVillages(Set<Village> villages) {
        this.villages = villages;
    }

    @Override
    public String tableName() {
        return "mst_district";
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
