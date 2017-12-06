package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.PaymentResponseDTO;
import com.tripoin.pos.shared.data.mapper.master.EmployeeMapper;
import com.tripoin.pos.shared.data.mapper.system.PaymentTypeDetailMapper;
import com.tripoin.pos.shared.data.model.trx.Payment;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PaymentMapper extends ADATAMapper<Payment, PaymentResponseDTO> {

    @Autowired
    private PaymentTypeDetailMapper paymentTypeDetailMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PaymentResponseDTO convert(Payment payment) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setId(payment.getId());
        responseDTO.setCode(payment.getCode());
        responseDTO.setName(payment.getName());
        responseDTO.setRemarks(payment.getRemarks());
        if (payment.getPaymentType() != null) {
            responseDTO.setPaymentTypeDetail(paymentTypeDetailMapper.convert(payment.getPaymentType()));
        }
        if (payment.getEmployee() != null) {
            responseDTO.setEmployeeResponse(employeeMapper.convert(payment.getEmployee()));
        }
        responseDTO.setTrxDate(payment.getTrxDate());
        responseDTO.setTotalItem(payment.getTotalItem());
        responseDTO.setTax(payment.getTax());
        responseDTO.setRefferenceId(payment.getRefferenceId());
        return responseDTO;
    }
}
