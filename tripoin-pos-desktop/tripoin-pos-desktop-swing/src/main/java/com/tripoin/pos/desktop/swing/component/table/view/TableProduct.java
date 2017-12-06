package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IProductClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelProduct;
import com.tripoin.pos.shared.data.dto.response.master.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableProduct extends AScaffoldingTable<ProductResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IProductClient productClient;

    @Autowired
    private TableModelProduct tableModelProduct;

    @Override
    public void initComponents() {
        scaffoldingClient = productClient;
        scaffoldingTableModel = tableModelProduct;

        super.initComponents();
    }
}
