package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IBankClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelBank;
import com.tripoin.pos.shared.data.dto.response.master.BankResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableBank extends AScaffoldingTable<BankResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IBankClient bankClient;

    @Autowired
    private TableModelBank tableModelBank;

    @Override
    public void initComponents() {
        scaffoldingClient = bankClient;
        scaffoldingTableModel = tableModelBank;

        super.initComponents();
    }
}
