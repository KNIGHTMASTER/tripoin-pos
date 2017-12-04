package com.tripoin.pos.shared.data.dto.response;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/21/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProductGuaranteeResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8508021967372538815L;

    private int merchantGuarantee;
    private int brandGuarantee;

    public int getMerchantGuarantee() {
        return merchantGuarantee;
    }

    public void setMerchantGuarantee(int merchantGuarantee) {
        this.merchantGuarantee = merchantGuarantee;
    }

    public int getBrandGuarantee() {
        return brandGuarantee;
    }

    public void setBrandGuarantee(int brandGuarantee) {
        this.brandGuarantee = brandGuarantee;
    }
}
