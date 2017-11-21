package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.ICompanyClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelCompany;
import com.tripoin.pos.shared.data.dto.response.CompanyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableCompany extends AScaffoldingTable<CompanyResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private ICompanyClient companyClient;

    @Autowired
    private TableModelCompany tableModelCompany;

    @Override
    public void initComponents() {
        scaffoldingClient = companyClient;
        scaffoldingTableModel = tableModelCompany;

        super.initComponents();
    }
}
