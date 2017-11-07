package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.ICompanyClient;
import com.tripoin.pos.desktop.swing.component.table.ITableListener;
import com.tripoin.pos.desktop.swing.component.table.listener.CompanyTableListener;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelCompany;
import com.tripoin.pos.shared.data.CompanyTableDTO;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableCompany extends AScaffoldingTable<CompanyTableDTO> implements IComponentInitializer, IComponentAction, ITableListener {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private ICompanyClient companyClient;

    @Autowired
    private TableModelCompany tableModelCompany;

    @Autowired
    private CompanyTableListener companyTableListener;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingClient = companyClient;
        scaffoldingTableModel = tableModelCompany;
        scaffoldingTableListener = companyTableListener;

        super.initComponents();
    }
}
