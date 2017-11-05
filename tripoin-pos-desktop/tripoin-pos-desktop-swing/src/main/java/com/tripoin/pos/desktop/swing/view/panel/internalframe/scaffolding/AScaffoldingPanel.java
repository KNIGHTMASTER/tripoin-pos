package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.dialog.ScaffoldingDialogCompany;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.scrollpane.AScaffoldingScrollPane;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AControllerScaffolding;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AScaffoldingPanel extends JPanel implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4014844416320630738L;

    @Autowired
    private PanelScaffoldingNorth panelScaffoldingNorth;

    @Autowired
    private PanelScaffoldingSouth panelScaffoldingSouth;

    @Autowired
    private ScaffoldingDialogCompany dialogDetailCompany;

    protected AScaffoldingScrollPane scrollPaneScaffolding;

    protected LabelScaffoldingTitle labelScaffoldingTitle;

    @Override
    public void initComponents() {
        this.panelScaffoldingNorth.getPanelScaffoldingNorthTop().labelScaffoldingTitle = labelScaffoldingTitle;

        this.setLayout(new BorderLayout());
        this.add(panelScaffoldingNorth, BorderLayout.NORTH);
        this.add(scrollPaneScaffolding, BorderLayout.CENTER);
        this.add(panelScaffoldingSouth, BorderLayout.SOUTH);

        initAction();
    }

    @Override
    public void initAction() {
        ControllerScaffoldingParam controllerScaffoldingParam = new ControllerScaffoldingParam();
        controllerScaffoldingParam.setScaffoldingDialog(dialogDetailCompany);
        controllerScaffoldingParam.setScaffoldingTable(getScaffoldingTable());
        controllerScaffoldingParam.setScaffoldingClient(getScaffoldingTable().scaffoldingClient);
        getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonRefresh().addActionListener(e -> getScaffoldingTable().refreshTableWithWorker());
        getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonInsert().addActionListener(e -> {
            getControllerScaffolding().setParam(controllerScaffoldingParam);
            getControllerScaffolding().showInsertDialog();
        });
        getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonUpdate().addActionListener(e -> {
            controllerScaffoldingParam.setSelectedTableRow(getScaffoldingTable().getSelectedRow());
            getControllerScaffolding().setParam(controllerScaffoldingParam);
            getControllerScaffolding().showUpdateDialog();
        });
        getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonDelete().addActionListener(e -> {
            controllerScaffoldingParam.setSelectedTableRow(getScaffoldingTable().getSelectedRow());
            getControllerScaffolding().setParam(controllerScaffoldingParam);
            getControllerScaffolding().delete();
        });
    }

    public PanelScaffoldingNorth getPanelScaffoldingNorth() {
        return panelScaffoldingNorth;
    }

    public abstract AScaffoldingTable getScaffoldingTable();

    public abstract AControllerScaffolding getControllerScaffolding();
}
