package com.tripoin.pos.shared.data.dto.response;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ExpensePriceResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2833758821439753664L;

    private int retailQuantity;
    private BigDecimal retailPrice;
    private int distributorQuantity;
    private BigDecimal distributorPrice;

    public int getRetailQuantity() {
        return retailQuantity;
    }

    public void setRetailQuantity(int retailQuantity) {
        this.retailQuantity = retailQuantity;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getDistributorQuantity() {
        return distributorQuantity;
    }

    public void setDistributorQuantity(int distributorQuantity) {
        this.distributorQuantity = distributorQuantity;
    }

    public BigDecimal getDistributorPrice() {
        return distributorPrice;
    }

    public void setDistributorPrice(BigDecimal distributorPrice) {
        this.distributorPrice = distributorPrice;
    }
}
