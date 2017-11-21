package com.tripoin.pos.shared.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "mst_country")
public class Country extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3871254896944959025L;

    @JsonManagedReference
    private Set<Province> province;
    
    @Override
    public String tableName() {
        return "mst_country";
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	public Set<Province> getProvince() {
		return province;
	}

	public void setProvince(Set<Province> province) {
		this.province = province;
	}

}
