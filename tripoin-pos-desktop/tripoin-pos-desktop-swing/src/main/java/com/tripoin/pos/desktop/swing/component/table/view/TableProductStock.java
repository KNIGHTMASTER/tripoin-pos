package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.endpoint.IProductStockClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelProductStock;
import com.tripoin.pos.shared.data.dto.response.master.ProductStockResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableProductStock extends AScaffoldingTable<ProductStockResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IProductStockClient productStockClient;

    @Autowired
    private TableModelProductStock tableModelProductStock;

    @Override
    public void initComponents() {
        scaffoldingClient = productStockClient;
        scaffoldingTableModel = tableModelProductStock;

        super.initComponents();
    }
}
