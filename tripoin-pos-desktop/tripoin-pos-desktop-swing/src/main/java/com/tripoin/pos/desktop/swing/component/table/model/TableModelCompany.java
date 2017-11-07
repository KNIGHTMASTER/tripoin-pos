package com.tripoin.pos.desktop.swing.component.table.model;

import com.tripoin.pos.shared.data.CompanyTableDTO;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableModelCompany extends AScaffoldingTableModel<CompanyTableDTO> {
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
            default: return null;
        }
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"Id", "Code", "Name"};
    }

}