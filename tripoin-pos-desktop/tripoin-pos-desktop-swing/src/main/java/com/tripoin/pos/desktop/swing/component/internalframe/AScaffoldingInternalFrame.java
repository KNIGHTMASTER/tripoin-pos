package com.tripoin.pos.desktop.swing.component.internalframe;

import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.view.internalframe.SideBarInternalFrame;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding.AScaffoldingPanel;
import id.co.telkomsigma.tgf.util.IComponentAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AScaffoldingInternalFrame extends SideBarInternalFrame implements IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -9150039503020378664L;

    @Autowired
    private ComboBoxDisplayNumberOfData comboBoxDisplayNumberOfData;

    protected AScaffoldingPanel scaffoldingPanel;
    protected AScaffoldingTable scaffoldingTable;

    @Override
    public void initComponents() {
        super.initComponents();
        this.setLayout(new BorderLayout());
        this.add(scaffoldingPanel, BorderLayout.CENTER);

        initAction();
    }

    @Override
    public void initAction() {
        this.addInternalFrameListener(new ScaffoldingInternalFrameListener() {
            @Override
            public AScaffoldingPanel getScaffoldingPanel() {
                return scaffoldingPanel;
            }

            @Override
            public ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData() {
                return comboBoxDisplayNumberOfData;
            }
        });
    }
}
