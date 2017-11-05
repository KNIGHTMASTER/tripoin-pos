package com.tripoin.pos.desktop.swing.dto.param;

import com.tripoin.pos.desktop.swing.client.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.dialog.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;

import java.awt.*;

/**
 * Created on 11/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public class ControllerScaffoldingParam<DATA> {

    private AScaffoldingTable scaffoldingTable;
    private IScaffoldingClient scaffoldingClient;
    private Point point;
    private AScaffoldingDialog scaffoldingDialog;
    private DATA data;
    private int selectedTableRow;

    public int getSelectedTableRow() {
        return selectedTableRow;
    }

    public void setSelectedTableRow(int selectedTableRow) {
        this.selectedTableRow = selectedTableRow;
    }

    public void setData(DATA data) {
        this.data = data;
    }

    public DATA getData() {
        return data;
    }

    public AScaffoldingDialog getScaffoldingDialog() {
        return scaffoldingDialog;
    }

    public void setScaffoldingDialog(AScaffoldingDialog scaffoldingDialog) {
        this.scaffoldingDialog = scaffoldingDialog;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public IScaffoldingClient getScaffoldingClient() {
        return scaffoldingClient;
    }

    public void setScaffoldingClient(IScaffoldingClient scaffoldingClient) {
        this.scaffoldingClient = scaffoldingClient;
    }

    public AScaffoldingTable getScaffoldingTable() {
        return scaffoldingTable;
    }

    public void setScaffoldingTable(AScaffoldingTable scaffoldingTable) {
        this.scaffoldingTable = scaffoldingTable;
    }
}
