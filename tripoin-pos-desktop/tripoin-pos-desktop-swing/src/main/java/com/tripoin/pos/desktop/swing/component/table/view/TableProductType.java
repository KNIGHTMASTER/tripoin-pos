package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IProductTypeClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelProductType;
import com.tripoin.pos.shared.data.dto.response.master.ProductTypeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableProductType extends AScaffoldingTable<ProductTypeResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IProductTypeClient productTypeClient;

    @Autowired
    private TableModelProductType tableModelProductType;

    @Override
    public void initComponents() {
        scaffoldingClient = productTypeClient;
        scaffoldingTableModel = tableModelProductType;

        super.initComponents();
    }
}
