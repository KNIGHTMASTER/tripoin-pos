package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.ISupplierClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelSupplier;
import com.tripoin.pos.shared.data.dto.response.master.SupplierResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableSupplier extends AScaffoldingTable<SupplierResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private ISupplierClient supplierClient;

    @Autowired
    private TableModelSupplier tableModelSupplier;

    @Override
    public void initComponents() {
        scaffoldingClient = supplierClient;
        scaffoldingTableModel = tableModelSupplier;

        super.initComponents();
    }
}
