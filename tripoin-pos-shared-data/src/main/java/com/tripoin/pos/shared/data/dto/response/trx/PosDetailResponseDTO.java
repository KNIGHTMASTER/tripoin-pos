package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PosDetailResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8406461481289419940L;

    private PosHeaderResponseDTO posHeader;
    private BigDecimal openBalance;
    private Date openTime;
    private Integer isOpenBalance;
    private BigDecimal closeBalance;
    private Date closeTime;
    private Integer isCloseBalance;

    public PosHeaderResponseDTO getPosHeader() {
        return posHeader;
    }

    public void setPosHeader(PosHeaderResponseDTO posHeader) {
        this.posHeader = posHeader;
    }

    public BigDecimal getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(BigDecimal openBalance) {
        this.openBalance = openBalance;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Integer getIsOpenBalance() {
        return isOpenBalance;
    }

    public void setIsOpenBalance(Integer isOpenBalance) {
        this.isOpenBalance = isOpenBalance;
    }

    public BigDecimal getCloseBalance() {
        return closeBalance;
    }

    public void setCloseBalance(BigDecimal closeBalance) {
        this.closeBalance = closeBalance;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getIsCloseBalance() {
        return isCloseBalance;
    }

    public void setIsCloseBalance(Integer isCloseBalance) {
        this.isCloseBalance = isCloseBalance;
    }
}
