package com.tripoin.pos.desktop.swing.component.scrollpane;

import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AScaffoldingScrollPane extends JScrollPane implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3925046385966946640L;

    public AScaffoldingTable scaffoldingTable;

    @Override
    public void initComponents() {
        setViewportView(scaffoldingTable);
    }

    public AScaffoldingTable getScaffoldingTable() {
        return scaffoldingTable;
    }
}
