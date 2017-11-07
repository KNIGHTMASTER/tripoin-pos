package com.tripoin.pos.desktop.swing.component.popup;

import com.tripoin.pos.desktop.swing.client.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.dialog.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemDelete;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemDetail;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemRefresh;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemUpdate;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AControllerScaffolding;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public abstract class AScaffoldingPopUp extends JPopupMenu implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6532399252379970915L;

    @Autowired
    private MenuItemDetail menuItemDetail;

    @Autowired
    private MenuItemRefresh menuItemRefresh;

    @Autowired
    private MenuItemUpdate menuItemUpdate;

    @Autowired
    private MenuItemDelete menuItemDelete;

    @Autowired
    private IResourceBundleLocator rb;

    @Autowired
    private AControllerScaffolding controllerScaffolding;

    @Autowired
    private ComboBoxDisplayNumberOfData comboBoxDisplayNumberOfData;

    private Point point = null;
    protected AScaffoldingTable scaffoldingTable;

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void initComponents() {
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), rb.getValue("ui.scaffolding.popup.title")));
        this.add(new JSeparator());
        this.add(menuItemRefresh);
        this.add(menuItemDetail);
        this.add(menuItemUpdate);
        this.add(menuItemDelete);

        initAction();
    }

    @Override
    public void initAction() {
        ControllerScaffoldingParam param = new ControllerScaffoldingParam();
        param.setScaffoldingClient(getScaffoldingClient());
        param.setScaffoldingTable(scaffoldingTable);
        param.setScaffoldingDialog(getScaffoldingDialog());
        controllerScaffolding.setParam(param);

        menuItemRefresh.addActionListener(e -> {
            param.setComboBoxDisplayNumberOfData(comboBoxDisplayNumberOfData);
            controllerScaffolding.setParam(param);
            controllerScaffolding.refresh();
        });

        menuItemDetail.addActionListener(e -> {
            param.setPoint(point);
            controllerScaffolding.setParam(param);
            controllerScaffolding.showDetailDialog();
        });

        menuItemDelete.addActionListener(e -> {
            int row = scaffoldingTable.getSelectedRows().length;
            if (row <= -1){
                JOptionPane.showMessageDialog(null, "Please choose a record on table");
            }else if (row == 1 ){
                param.setSelectedTableRow(1);
                param.setPoint(point);
                param.setComboBoxDisplayNumberOfData(comboBoxDisplayNumberOfData);
                controllerScaffolding.setParam(param);
                controllerScaffolding.delete();
            }else if (row > 1){
                param.setSelectedTableRow(null);
                param.setSelectedTableRows(scaffoldingTable.getSelectedRows());
                param.setPoint(point);
                param.setComboBoxDisplayNumberOfData(comboBoxDisplayNumberOfData);
                controllerScaffolding.setParam(param);
                controllerScaffolding.delete();
            }
        });

        menuItemUpdate.addActionListener(e -> {
            param.setPoint(point);
            controllerScaffolding.setParam(param);
            controllerScaffolding.showUpdateDialog();
        });
    }

    protected abstract IScaffoldingClient getScaffoldingClient();

    protected abstract AScaffoldingDialog getScaffoldingDialog();
}
