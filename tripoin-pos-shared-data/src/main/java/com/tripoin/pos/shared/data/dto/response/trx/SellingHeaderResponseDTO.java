package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SellingHeaderResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1635584150873398781L;

    private Date trxDate;
    private Integer totalItem;
    private BigDecimal totalPrice;
    private PromoResponseDTO promo;
    private Integer refferenceId;

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PromoResponseDTO getPromo() {
        return promo;
    }

    public void setPromo(PromoResponseDTO promo) {
        this.promo = promo;
    }

    public Integer getRefferenceId() {
        return refferenceId;
    }

    public void setRefferenceId(Integer refferenceId) {
        this.refferenceId = refferenceId;
    }
}
