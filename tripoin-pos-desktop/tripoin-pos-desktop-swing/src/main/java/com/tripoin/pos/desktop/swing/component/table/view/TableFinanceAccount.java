package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IFinanceAccountClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelFinanceAccount;
import com.tripoin.pos.shared.data.dto.response.FinanceAccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableFinanceAccount extends AScaffoldingTable<FinanceAccountResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IFinanceAccountClient financeAccountClient;

    @Autowired
    private TableModelFinanceAccount tableModelFinanceAccount;

    @Override
    public void initComponents() {
        scaffoldingClient = financeAccountClient;
        scaffoldingTableModel = tableModelFinanceAccount;

        super.initComponents();
    }
}
