package com.tripoin.pos.shared.data.dto.response;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CityResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 252845830290377243L;

    private ProvinceResponseDTO province;

    public ProvinceResponseDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceResponseDTO province) {
        this.province = province;
    }
}
