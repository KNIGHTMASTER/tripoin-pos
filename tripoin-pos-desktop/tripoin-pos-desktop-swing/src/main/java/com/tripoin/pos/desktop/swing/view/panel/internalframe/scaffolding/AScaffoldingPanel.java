package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.dialog.ScaffoldingDialogCompany;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.scrollpane.AScaffoldingScrollPane;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AControllerScaffolding;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.util.UIConstant;
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

    private int currentPage = 0;
    private int totalPage = 0;

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

        getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonRefresh().addActionListener(e -> refreshContent(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedValue(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedIndex()), 0, AScaffoldingTable.FindMode.DEFAULT, UIConstant.Common.Punctuation.EMPTY));
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
            int row = getScaffoldingTable().getSelectedRows().length;
            if (row <= -1){
                JOptionPane.showMessageDialog(null, "Please choose a record on table");
            }else if (row == 1 ){
                controllerScaffoldingParam.setSelectedTableRow(getScaffoldingTable().getSelectedRow());
                controllerScaffoldingParam.setComboBoxDisplayNumberOfData(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData());
                getControllerScaffolding().setParam(controllerScaffoldingParam);
                getControllerScaffolding().delete();
            }else if (row > 1){
                controllerScaffoldingParam.setSelectedTableRow(null);
                controllerScaffoldingParam.setSelectedTableRows(getScaffoldingTable().getSelectedRows());
                controllerScaffoldingParam.setComboBoxDisplayNumberOfData(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData());
                getControllerScaffolding().setParam(controllerScaffoldingParam);
                getControllerScaffolding().delete();
            }

        });

        getScaffoldingTable().getSelectionModel().addListSelectionListener(e -> {
            int row = getScaffoldingTable().getSelectedRow();
            if (row > -1) {
                getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonDelete().setEnabled(true);
                getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonUpdate().setEnabled(true);
            } else {
                getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonDelete().setEnabled(false);
                getPanelScaffoldingNorth().getPanelScaffoldingNorthTop().getPanelScaffoldingActionButton().getButtonUpdate().setEnabled(false);
            }
        });

        getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().addActionListener(e -> refreshContent(
                getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedValue(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedIndex()),
                0,
                AScaffoldingTable.FindMode.DEFAULT,
                UIConstant.Common.Punctuation.EMPTY
        ));

        getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getTxtSearch().addActionListener(e -> refreshContent(
                getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedValue(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedIndex()),
                0,
                getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxFilter().getSelectedMode(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxFilter().getSelectedIndex()),
                getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getTxtSearch().getText()
        ));

        panelScaffoldingSouth.getPanelPaginationButton().getButtonNextPage().addActionListener(e -> {
            refreshContent(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedValue(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedIndex()),
                    currentPage+1,
                    AScaffoldingTable.FindMode.DEFAULT,
                    UIConstant.Common.Punctuation.EMPTY
            );
            currentPage +=1;
        });

        panelScaffoldingSouth.getPanelPaginationButton().getButtonPrevPage().addActionListener(e -> {
            refreshContent(
                    getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedValue(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedIndex()),
                    currentPage - 1,
                    AScaffoldingTable.FindMode.DEFAULT,
                    UIConstant.Common.Punctuation.EMPTY
            );
            currentPage -=1;
        });

        panelScaffoldingSouth.getPanelPaginationButton().getButtonFirstPage().addActionListener(e -> {
            refreshContent(
                    getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedValue(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedIndex()),
                    0,
                    AScaffoldingTable.FindMode.DEFAULT,
                    UIConstant.Common.Punctuation.EMPTY
            );
            currentPage = 0;
        });

        panelScaffoldingSouth.getPanelPaginationButton().getButtonLastPage().addActionListener(e -> {
            refreshContent(
                    getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedValue(getPanelScaffoldingNorth().getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData().getSelectedIndex()),
                    totalPage,
                    AScaffoldingTable.FindMode.DEFAULT,
                    UIConstant.Common.Punctuation.EMPTY
            );
            currentPage = totalPage;
        });
    }

    public void refreshContent(int p_Size, int p_TargetPage, AScaffoldingTable.FindMode p_FindMode, String p_TextToSearch) {
        ControllerScaffoldingParam controllerScaffoldingParam = new ControllerScaffoldingParam();
        controllerScaffoldingParam.setScaffoldingDialog(dialogDetailCompany);
        controllerScaffoldingParam.setScaffoldingTable(getScaffoldingTable());
        controllerScaffoldingParam.setScaffoldingClient(getScaffoldingTable().scaffoldingClient);

        ResponseGenericPaginationDTO responseGenericPaginationDTO = getScaffoldingTable().refreshTableWithWorker(p_Size, p_TargetPage, p_FindMode, p_TextToSearch);
        controllerScaffoldingParam.setLabelIndex(panelScaffoldingSouth.getPanelPaginationIndex().getLabelIndex());
        controllerScaffoldingParam.setPanelPaginationButton(panelScaffoldingSouth.getPanelPaginationButton());
        controllerScaffoldingParam.setComboBoxDisplayNumberOfData(panelScaffoldingNorth.getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData());
        getControllerScaffolding().setParam(controllerScaffoldingParam);
        getControllerScaffolding().refreshTable(responseGenericPaginationDTO);
        totalPage = responseGenericPaginationDTO.getTotalPages()-1;
    }

    public PanelScaffoldingNorth getPanelScaffoldingNorth() {
        return panelScaffoldingNorth;
    }

    public abstract AScaffoldingTable getScaffoldingTable();

    public abstract AControllerScaffolding getControllerScaffolding();
}
