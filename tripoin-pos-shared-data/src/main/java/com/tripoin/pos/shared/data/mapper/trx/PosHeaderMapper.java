package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.PosHeaderResponseDTO;
import com.tripoin.pos.shared.data.mapper.master.EmployeeMapper;
import com.tripoin.pos.shared.data.mapper.master.PointOfSalesMapper;
import com.tripoin.pos.shared.data.model.trx.PosHeader;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PosHeaderMapper extends ADATAMapper<PosHeader, PosHeaderResponseDTO> {

    @Autowired
    private CashierBalanceDetailMapper cashierBalanceDetailMapper;

    @Autowired
    private PointOfSalesMapper pointOfSalesMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PosHeaderResponseDTO convert(PosHeader posHeader) {
        PosHeaderResponseDTO responseDTO = new PosHeaderResponseDTO();
        responseDTO.setId(posHeader.getId());
        responseDTO.setCode(posHeader.getCode());
        responseDTO.setName(posHeader.getName());
        responseDTO.setRemarks(posHeader.getRemarks());
        if (posHeader.getCashierBalanceDetail() != null) {
            responseDTO.setCashierBalanceDetail(cashierBalanceDetailMapper.convert(posHeader.getCashierBalanceDetail()));
        }
        if (posHeader.getPointOfSales() != null) {
            responseDTO.setPointOfSales(pointOfSalesMapper.convert(posHeader.getPointOfSales()));
        }
        if (posHeader.getEmployee() != null) {
            responseDTO.setEmployeeResponse(employeeMapper.convert(posHeader.getEmployee()));
        }
        if (posHeader.getEmployee() != null) {
            responseDTO.setEmployeeResponse(employeeMapper.convert(posHeader.getEmployee()));
        }
        responseDTO.setDebit(posHeader.getDebit());
        responseDTO.setCredit(posHeader.getCredit());
        return responseDTO;
    }
}
