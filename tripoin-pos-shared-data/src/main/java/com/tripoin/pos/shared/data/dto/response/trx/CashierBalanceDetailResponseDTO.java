package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.pos.shared.data.dto.response.system.PosShiftResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CashierBalanceDetailResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2541429423170064198L;

    private CashierBalanceHeaderResponseDTO cashierBalanceHeader;
    private Integer isAppSpv;
    private Date appSpvTime;
    private PosShiftResponseDTO posShift;

    public CashierBalanceHeaderResponseDTO getCashierBalanceHeader() {
        return cashierBalanceHeader;
    }

    public void setCashierBalanceHeader(CashierBalanceHeaderResponseDTO cashierBalanceHeader) {
        this.cashierBalanceHeader = cashierBalanceHeader;
    }

    public Integer getIsAppSpv() {
        return isAppSpv;
    }

    public void setIsAppSpv(Integer isAppSpv) {
        this.isAppSpv = isAppSpv;
    }

    public Date getAppSpvTime() {
        return appSpvTime;
    }

    public void setAppSpvTime(Date appSpvTime) {
        this.appSpvTime = appSpvTime;
    }

    public PosShiftResponseDTO getPosShift() {
        return posShift;
    }

    public void setPosShift(PosShiftResponseDTO posShift) {
        this.posShift = posShift;
    }
}
