package com.tripoin.pos.shared.data.mapper.system;

import com.tripoin.pos.shared.data.dto.response.system.PaymentTypeDetailResponseDTO;
import com.tripoin.pos.shared.data.model.system.PaymentTypeDetail;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PaymentTypeDetailMapper extends ADATAMapper<PaymentTypeDetail, PaymentTypeDetailResponseDTO> {
    @Override
    public PaymentTypeDetailResponseDTO convert(PaymentTypeDetail paymentTypeDetail) {
        PaymentTypeDetailResponseDTO responseDTO = new PaymentTypeDetailResponseDTO();
        responseDTO.setId(paymentTypeDetail.getId());
        responseDTO.setCode(paymentTypeDetail.getCode());
        responseDTO.setName(paymentTypeDetail.getName());
        responseDTO.setRemarks(paymentTypeDetail.getRemarks());
        responseDTO.setPaymentType(paymentTypeDetail.getPaymentType());
        responseDTO.setCardNumber(paymentTypeDetail.getCardNumber());
        responseDTO.setReceipt(paymentTypeDetail.getReceipt());
        return responseDTO;
    }
}
