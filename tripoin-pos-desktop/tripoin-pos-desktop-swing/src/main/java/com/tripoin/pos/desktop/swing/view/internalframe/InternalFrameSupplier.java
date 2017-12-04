package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableSupplier;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.supplier.SupplierPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameSupplier extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private SupplierPanel supplierPanel;

    @Autowired
    private TableSupplier tableSupplier;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = supplierPanel;
        scaffoldingTable = tableSupplier;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.supplier.title";
    }
}
