package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.CashierBalanceHeaderResponseDTO;
import com.tripoin.pos.shared.data.model.trx.CashierBalanceHeader;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CashierBalanceHeaderMapper extends ADATAMapper<CashierBalanceHeader, CashierBalanceHeaderResponseDTO> {
    @Override
    public CashierBalanceHeaderResponseDTO convert(CashierBalanceHeader cashierBalanceHeader) {
        CashierBalanceHeaderResponseDTO responseDTO = new CashierBalanceHeaderResponseDTO();
        responseDTO.setId(cashierBalanceHeader.getId());
        responseDTO.setCode(cashierBalanceHeader.getCode());
        responseDTO.setName(cashierBalanceHeader.getName());
        responseDTO.setRemarks(cashierBalanceHeader.getRemarks());
        responseDTO.setTrxDate(cashierBalanceHeader.getTrxDate());
        return responseDTO;
    }
}
