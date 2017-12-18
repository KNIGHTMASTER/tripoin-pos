package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.component.table.model.TableModelTransaction;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableTransaction extends JTable  implements IComponentInitializer , IComponentAction{
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private TableModelTransaction tableModelTransaction;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setRowSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setAutoCreateRowSorter(true);

        this.setModel(tableModelTransaction);

        initAction();
    }

    @Override
    public void initAction() {

    }
}
