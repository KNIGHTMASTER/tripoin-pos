package com.tripoin.pos.desktop.swing.component.popup;

import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemDelete;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemDetail;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemRefresh;
import com.tripoin.pos.desktop.swing.component.menuitem.MenuItemUpdate;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

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

    protected MenuItemDetail menuItemDetail;
    protected MenuItemRefresh menuItemRefresh;
    protected MenuItemUpdate menuItemUpdate;
    protected MenuItemDelete menuItemDelete;

    private Point point = null;

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void initComponents() {
        menuItemDetail = new MenuItemDetail() {
            private static final long serialVersionUID = -796628711893014367L;

            @Override
            public IResourceBundleLocator getRb() {
                return AScaffoldingPopUp.this.getRb();
            }
        };
        menuItemDetail.initComponents();

        menuItemRefresh = new MenuItemRefresh() {
            private static final long serialVersionUID = -6156663993817221562L;

            @Override
            public IResourceBundleLocator getRb() {
                return AScaffoldingPopUp.this.getRb();
            }
        };
        menuItemRefresh.initComponents();

        menuItemUpdate = new MenuItemUpdate() {
            private static final long serialVersionUID = 6647566479772783683L;

            @Override
            public IResourceBundleLocator getRb() {
                return AScaffoldingPopUp.this.getRb();
            }
        };
        menuItemUpdate.initComponents();

        menuItemDelete = new MenuItemDelete() {
            private static final long serialVersionUID = 7898387858874160844L;

            @Override
            public IResourceBundleLocator getRb() {
                return AScaffoldingPopUp.this.getRb();
            }
        };
        menuItemDelete.initComponents();

        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), getRb().getValue("ui.scaffolding.popup.title")));
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
        param.setScaffoldingTable(getScaffoldingTable());
        param.setScaffoldingDialog(getScaffoldingDialog());
        getScaffoldingController().setParam(param);

        menuItemRefresh.addActionListener(e -> {
            param.setComboBoxDisplayNumberOfData(getComboBoxDisplayNumberOfData());
            getScaffoldingController().setParam(param);
            getScaffoldingController().refresh();
        });

        menuItemDetail.addActionListener(e -> {
            param.setPoint(point);
            getScaffoldingController().setParam(param);
            getScaffoldingController().showDetailDialog();
        });

        menuItemDelete.addActionListener(e -> {
            int row = getScaffoldingTable().getSelectedRows().length;
            if (row <= -1){
                JOptionPane.showMessageDialog(null, "Please choose a record on table");
            }else if (row == 1 ){
                param.setSelectedTableRow(1);
                param.setPoint(point);
                param.setComboBoxDisplayNumberOfData(getComboBoxDisplayNumberOfData());
                getScaffoldingController().setParam(param);
                getScaffoldingController().delete();
            }else if (row > 1){
                param.setSelectedTableRow(null);
                param.setSelectedTableRows(getScaffoldingTable().getSelectedRows());
                param.setPoint(point);
                param.setComboBoxDisplayNumberOfData(getComboBoxDisplayNumberOfData());
                getScaffoldingController().setParam(param);
                getScaffoldingController().delete();
            }
        });

        menuItemUpdate.addActionListener(e -> {
            param.setPoint(point);
            getScaffoldingController().setParam(param);
            getScaffoldingController().showUpdateDialog();
        });
    }

    public abstract IScaffoldingClient getScaffoldingClient();

    public abstract AScaffoldingDialog getScaffoldingDialog();

    public abstract AScaffoldingController getScaffoldingController();

    public abstract ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData();

    public abstract IResourceBundleLocator getRb();

    public abstract AScaffoldingTable getScaffoldingTable();
}
