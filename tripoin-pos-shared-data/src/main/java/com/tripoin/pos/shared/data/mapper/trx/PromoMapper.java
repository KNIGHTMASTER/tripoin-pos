package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.PromoResponseDTO;
import com.tripoin.pos.shared.data.model.trx.Promo;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PromoMapper extends ADATAMapper<Promo, PromoResponseDTO> {
    @Override
    public PromoResponseDTO convert(Promo promo) {
        PromoResponseDTO responseDTO = new PromoResponseDTO();
        responseDTO.setId(promo.getId());
        responseDTO.setCode(promo.getCode());
        responseDTO.setName(promo.getName());
        responseDTO.setRemarks(promo.getRemarks());
        responseDTO.setStartDate(promo.getStartDate());
        responseDTO.setEndDate(promo.getEndDate());
        responseDTO.setDiscountRate(promo.getDiscountRate());
        return responseDTO;
    }
}
