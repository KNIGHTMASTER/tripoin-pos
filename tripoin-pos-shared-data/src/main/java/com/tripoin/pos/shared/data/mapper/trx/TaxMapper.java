package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.TaxResponseDTO;
import com.tripoin.pos.shared.data.model.trx.Tax;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class TaxMapper extends ADATAMapper<Tax, TaxResponseDTO> {
    @Override
    public TaxResponseDTO convert(Tax tax) {
        TaxResponseDTO responseDTO = new TaxResponseDTO();
        responseDTO.setId(tax.getId());
        responseDTO.setCode(tax.getCode());
        responseDTO.setName(tax.getName());
        responseDTO.setRemarks(tax.getRemarks());
        responseDTO.setTaxRate(tax.getTaxRate());
        return responseDTO;
    }
}
