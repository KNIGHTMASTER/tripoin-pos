package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CashierBalanceHeaderResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8574715248394442967L;

    private Date trxDate;

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }
}
