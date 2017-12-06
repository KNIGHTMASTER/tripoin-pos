package com.tripoin.pos.shared.data.dto.response.master;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class VillageResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1829587478500677918L;

    private DistrictResponseDTO district;

    public DistrictResponseDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictResponseDTO district) {
        this.district = district;
    }
}
