package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IProductUnitClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelProductUnit;
import com.tripoin.pos.shared.data.dto.response.master.BankResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableProductUnit extends AScaffoldingTable<BankResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IProductUnitClient productUnitClient;

    @Autowired
    private TableModelProductUnit tableModelProductUnit;

    @Override
    public void initComponents() {
        scaffoldingClient = productUnitClient;
        scaffoldingTableModel = tableModelProductUnit;

        super.initComponents();
    }
}
