package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.PurchaseHeaderResponseDTO;
import com.tripoin.pos.shared.data.model.trx.PurchaseHeader;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PurchaseHeaderMapper extends ADATAMapper<PurchaseHeader, PurchaseHeaderResponseDTO> {

    @Autowired
    private PromoMapper promoMapper;

    @Override
    public PurchaseHeaderResponseDTO convert(PurchaseHeader purchaseHeader) {
        PurchaseHeaderResponseDTO responseDTO = new PurchaseHeaderResponseDTO();
        responseDTO.setId(purchaseHeader.getId());
        responseDTO.setCode(purchaseHeader.getCode());
        responseDTO.setName(purchaseHeader.getName());
        responseDTO.setRemarks(purchaseHeader.getRemarks());
        responseDTO.setTrxDate(purchaseHeader.getTrxDate());
        responseDTO.setTotalItem(purchaseHeader.getTotalItem());
        responseDTO.setTotalPrice(purchaseHeader.getTotalPrice());
        if (purchaseHeader.getPromo() != null) {
            responseDTO.setPromo(promoMapper.convert(purchaseHeader.getPromo()));
        }
        responseDTO.setRefferenceId(purchaseHeader.getRefferenceId());
        return responseDTO;
    }
}
