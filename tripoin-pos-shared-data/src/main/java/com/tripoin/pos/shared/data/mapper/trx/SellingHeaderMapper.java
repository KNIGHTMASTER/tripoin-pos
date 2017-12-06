package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.SellingHeaderResponseDTO;
import com.tripoin.pos.shared.data.model.trx.SellingHeader;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SellingHeaderMapper extends ADATAMapper<SellingHeader, SellingHeaderResponseDTO> {

    @Autowired
    private PromoMapper promoMapper;

    @Override
    public SellingHeaderResponseDTO convert(SellingHeader sellingHeader) {
        SellingHeaderResponseDTO responseDTO = new SellingHeaderResponseDTO();
        responseDTO.setId(sellingHeader.getId());
        responseDTO.setCode(sellingHeader.getCode());
        responseDTO.setName(sellingHeader.getName());
        responseDTO.setRemarks(sellingHeader.getRemarks());
        responseDTO.setTrxDate(sellingHeader.getTrxDate());
        responseDTO.setTotalItem(sellingHeader.getTotalItem());
        responseDTO.setTotalPrice(sellingHeader.getTotalPrice());
        if (sellingHeader.getPromo() != null) {
            responseDTO.setPromo(promoMapper.convert(sellingHeader.getPromo()));
        }
        responseDTO.setRefferenceId(sellingHeader.getRefferenceId());
        return responseDTO;
    }
}
