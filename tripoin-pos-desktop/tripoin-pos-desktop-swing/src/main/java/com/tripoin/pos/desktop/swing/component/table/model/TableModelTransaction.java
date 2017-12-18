package com.tripoin.pos.desktop.swing.component.table.model;

import com.tripoin.pos.shared.data.dto.response.trx.TableTransactionResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableModelTransaction extends AScaffoldingTableModel<TableTransactionResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8026556520606567692L;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return dataList.get(rowIndex).getProduct();
            case 1 : return dataList.get(rowIndex).getPrice();
            case 2 : return dataList.get(rowIndex).getQuantity();
            case 3 : return dataList.get(rowIndex).getTotal();
            default: return null;
        }
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"Product", "Price", "Quantity", "Total"};
    }

}
