package com.tripoin.pos.desktop.swing.component.table.model;

import com.tripoin.pos.shared.data.dto.response.ProductTypeResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableModelProductType extends AScaffoldingTableModel<ProductTypeResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8026556520606567692L;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return dataList.get(rowIndex).getId();
            case 1 : return dataList.get(rowIndex).getCode();
            case 2 : return dataList.get(rowIndex).getName();
            case 3 : return dataList.get(rowIndex).getRemarks();
            default: return null;
        }
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"Id", "Code", "Name", "Remarks"};
    }

}
