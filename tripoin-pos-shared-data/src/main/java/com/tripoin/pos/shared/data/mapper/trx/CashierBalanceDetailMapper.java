package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.CashierBalanceDetailResponseDTO;
import com.tripoin.pos.shared.data.mapper.system.PosShiftMapper;
import com.tripoin.pos.shared.data.model.trx.CashierBalanceDetail;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CashierBalanceDetailMapper extends ADATAMapper<CashierBalanceDetail, CashierBalanceDetailResponseDTO> {

    @Autowired
    private CashierBalanceHeaderMapper cashierBalanceHeaderMapper;

    @Autowired
    private PosShiftMapper posShiftMapper;

    @Override
    public CashierBalanceDetailResponseDTO convert(CashierBalanceDetail cashierBalanceDetail) {
        CashierBalanceDetailResponseDTO responseDTO = new CashierBalanceDetailResponseDTO();
        responseDTO.setId(cashierBalanceDetail.getId());
        responseDTO.setCode(cashierBalanceDetail.getCode());
        responseDTO.setName(cashierBalanceDetail.getName());
        responseDTO.setRemarks(cashierBalanceDetail.getRemarks());
        if (cashierBalanceDetail.getCashierBalanceHeader() != null) {
            responseDTO.setCashierBalanceHeader(cashierBalanceHeaderMapper.convert(cashierBalanceDetail.getCashierBalanceHeader()));
        }
        responseDTO.setIsAppSpv(cashierBalanceDetail.getIsAppSpv());
        responseDTO.setAppSpvTime(cashierBalanceDetail.getAppSpvTime());
        if (cashierBalanceDetail.getPosShift() != null) {
            responseDTO.setPosShift(posShiftMapper.convert(cashierBalanceDetail.getPosShift()));
        }
        return responseDTO;
    }
}
