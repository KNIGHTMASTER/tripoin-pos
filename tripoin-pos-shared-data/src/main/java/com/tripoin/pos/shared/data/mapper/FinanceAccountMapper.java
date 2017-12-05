package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.FinanceAccountResponseDTO;
import com.tripoin.pos.shared.data.model.master.FinanceAccount;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class FinanceAccountMapper extends ADATAMapper<FinanceAccount, FinanceAccountResponseDTO> {
    @Override
    public FinanceAccountResponseDTO convert(FinanceAccount financeAccount) {
        FinanceAccountResponseDTO response = new FinanceAccountResponseDTO();
        response.setId(financeAccount.getId());
        response.setCode(financeAccount.getCode());
        response.setName(financeAccount.getName());
        response.setRemarks(financeAccount.getRemarks());
        return response;
    }
}
