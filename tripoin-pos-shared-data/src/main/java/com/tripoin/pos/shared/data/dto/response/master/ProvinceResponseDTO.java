package com.tripoin.pos.shared.data.dto.response.master;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProvinceResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2322062046370513024L;

    private CountryResponseDTO country;

    public CountryResponseDTO getCountry() {
        return country;
    }

    public void setCountry(CountryResponseDTO country) {
        this.country = country;
    }
}
