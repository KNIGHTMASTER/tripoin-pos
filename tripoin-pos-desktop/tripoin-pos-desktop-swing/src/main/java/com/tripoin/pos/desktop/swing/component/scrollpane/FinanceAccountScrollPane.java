package com.tripoin.pos.desktop.swing.component.scrollpane;

import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.component.table.view.TableFinanceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class FinanceAccountScrollPane extends AScaffoldingScrollPane {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5782555036729246491L;

    @Autowired
    private TableFinanceAccount tableFinanceAccount;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingTable = tableFinanceAccount;
        super.initComponents();
    }

    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return tableFinanceAccount;
    }
}
