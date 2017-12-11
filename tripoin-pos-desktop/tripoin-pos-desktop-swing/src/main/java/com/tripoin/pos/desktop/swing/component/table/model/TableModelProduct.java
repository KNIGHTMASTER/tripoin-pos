package com.tripoin.pos.desktop.swing.component.table.model;

import com.tripoin.pos.shared.data.dto.response.master.ProductResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableModelProduct extends AScaffoldingTableModel<ProductResponseDTO> {
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
            case 3 : return dataList.get(rowIndex).getProductCategory().getName();
            case 4 : return dataList.get(rowIndex).getProductType().getName();
            case 5 : return dataList.get(rowIndex).getProductBrand().getName();
            case 6 : return dataList.get(rowIndex).getSupplier().getName();
            case 7 : return dataList.get(rowIndex).getPrice().getName();
            case 8 : return dataList.get(rowIndex).getProductStock().getDisplayStock();
            case 9 : return dataList.get(rowIndex).getProductGuarantee().getBrandGuarantee();
            default: return null;
        }
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {"Id", "Code", "Name", "Category", "Type", "Brand", "Supplier", "Price", "Display Stock", "Guarantee"};
    }

}
