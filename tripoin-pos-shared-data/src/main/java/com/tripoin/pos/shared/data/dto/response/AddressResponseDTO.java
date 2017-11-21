package com.tripoin.pos.shared.data.dto.response;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AddressResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -920552324636788449L;

    private String detailAddress;
    private String postalCode;

    private CountryResponseDTO country;
    private ProvinceResponseDTO province;
    private CityResponseDTO city;
    private DistrictResponseDTO district;
    private VillageResponseDTO village;

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CountryResponseDTO getCountry() {
        return country;
    }

    public void setCountry(CountryResponseDTO country) {
        this.country = country;
    }

    public ProvinceResponseDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceResponseDTO province) {
        this.province = province;
    }

    public CityResponseDTO getCity() {
        return city;
    }

    public void setCity(CityResponseDTO city) {
        this.city = city;
    }

    public DistrictResponseDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictResponseDTO district) {
        this.district = district;
    }

    public VillageResponseDTO getVillage() {
        return village;
    }

    public void setVillage(VillageResponseDTO village) {
        this.village = village;
    }
}
