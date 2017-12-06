package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.ExpensePriceResponseDTO;
import com.tripoin.pos.shared.data.model.trx.ExpensePrice;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ExpensePriceMapper extends ADATAMapper<ExpensePrice, ExpensePriceResponseDTO> {
    @Override
    public ExpensePriceResponseDTO convert(ExpensePrice expensePrice) {
        ExpensePriceResponseDTO expensePriceResponseDTO = new ExpensePriceResponseDTO();
        expensePriceResponseDTO.setId(expensePrice.getId());
        expensePriceResponseDTO.setCode(expensePrice.getCode());
        expensePriceResponseDTO.setName(expensePrice.getName());
        expensePriceResponseDTO.setRemarks(expensePrice.getRemarks());
        expensePriceResponseDTO.setRetailQuantity(expensePrice.getRetailQuantity());
        expensePriceResponseDTO.setRetailPrice(expensePrice.getRetailPrice());
        expensePriceResponseDTO.setDistributorQuantity(expensePrice.getDistributorQuantity());
        expensePriceResponseDTO.setDistributorPrice(expensePrice.getDistributorPrice());
        return expensePriceResponseDTO;
    }
}
