package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IBranchClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelBranch;
import com.tripoin.pos.shared.data.dto.response.BranchResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableBranch extends AScaffoldingTable<BranchResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IBranchClient branchClient;

    @Autowired
    private TableModelBranch tableModelBranch;

    @Override
    public void initComponents() {
        scaffoldingClient = branchClient;
        scaffoldingTableModel = tableModelBranch;

        super.initComponents();
    }
}
