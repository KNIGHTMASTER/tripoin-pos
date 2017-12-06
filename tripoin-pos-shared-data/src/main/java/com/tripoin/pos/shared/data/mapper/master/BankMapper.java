package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.BankResponseDTO;
import com.tripoin.pos.shared.data.model.master.Bank;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BankMapper extends ADATAMapper<Bank, BankResponseDTO> {

    @Override
    public BankResponseDTO convert(Bank bank) {
        BankResponseDTO response = new BankResponseDTO();
        response.setId(bank.getId());
        response.setCode(bank.getCode());
        response.setName(bank.getName());
        response.setRemarks(bank.getRemarks());
        return response;
    }
}
