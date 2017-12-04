package com.tripoin.pos.shared.data.dto.response;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class IncomePriceResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1548804879106548683L;

    private BigDecimal capitalPrice;
    private int capitalQuantity;

    public BigDecimal getCapitalPrice() {
        return capitalPrice;
    }

    public void setCapitalPrice(BigDecimal capitalPrice) {
        this.capitalPrice = capitalPrice;
    }

    public int getCapitalQuantity() {
        return capitalQuantity;
    }

    public void setCapitalQuantity(int capitalQuantity) {
        this.capitalQuantity = capitalQuantity;
    }
}
