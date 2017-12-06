package com.tripoin.pos.shared.data.dto.response.master;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DistrictResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4978440001636905508L;

    private CityResponseDTO city;

    public CityResponseDTO getCity() {
        return city;
    }

    public void setCity(CityResponseDTO city) {
        this.city = city;
    }
}
