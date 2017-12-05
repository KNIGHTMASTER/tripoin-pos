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
@Table(name = "mst_city")
public class City extends AAuditTrail {
	
	/**
	 * 
	 * 
	 */
    private static final long serialVersionUID = -5329991434389083265L;

    @Override
    public String tableName() {
        return "mst_city";
    }

    @JsonBackReference
    private Province province;

    @JsonManagedReference
    private Set<District> districts;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    public Set<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "province=" + province +
                '}';
    }
}
