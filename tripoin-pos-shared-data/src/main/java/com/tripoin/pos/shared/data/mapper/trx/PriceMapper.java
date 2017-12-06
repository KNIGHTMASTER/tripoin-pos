package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.PriceResponseDTO;
import com.tripoin.pos.shared.data.model.trx.Price;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PriceMapper extends ADATAMapper<Price, PriceResponseDTO> {
    @Override
    public PriceResponseDTO convert(Price price) {
        PriceResponseDTO priceResponseDTO = new PriceResponseDTO();
        priceResponseDTO.setId(price.getId());
        priceResponseDTO.setCode(price.getCode());
        priceResponseDTO.setName(price.getName());
        priceResponseDTO.setRemarks(price.getRemarks());
        return priceResponseDTO;
    }
}
