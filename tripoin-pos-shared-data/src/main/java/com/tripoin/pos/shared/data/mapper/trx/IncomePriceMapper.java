package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.IncomePriceResponseDTO;
import com.tripoin.pos.shared.data.model.trx.IncomePrice;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class IncomePriceMapper extends ADATAMapper<IncomePrice, IncomePriceResponseDTO> {
    @Override
    public IncomePriceResponseDTO convert(IncomePrice incomePrice) {
        IncomePriceResponseDTO incomePriceResponseDTO = new IncomePriceResponseDTO();
        incomePriceResponseDTO.setId(incomePrice.getId());
        incomePriceResponseDTO.setCode(incomePrice.getCode());
        incomePriceResponseDTO.setName(incomePrice.getName());
        incomePriceResponseDTO.setRemarks(incomePrice.getRemarks());
        incomePriceResponseDTO.setCapitalPrice(incomePrice.getCapitalPrice());
        incomePriceResponseDTO.setCapitalQuantity(incomePrice.getCapitalQuantity());
        return incomePriceResponseDTO;
    }
}
