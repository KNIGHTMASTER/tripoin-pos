package com.tripoin.pos.desktop.swing.component.internalframe;

import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding.AScaffoldingPanel;
import id.co.telkomsigma.tgf.util.UIConstant;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public abstract class ScaffoldingInternalFrameListener implements InternalFrameListener {

    public abstract AScaffoldingPanel getScaffoldingPanel();

    public abstract ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData();

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
//        System.out.println("closing");
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
//        System.out.println("close");
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
//        System.out.println("icon");
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
//        System.out.println("deicon");
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        getScaffoldingPanel().refreshContent(
                getComboBoxDisplayNumberOfData().getSelectedValue(getComboBoxDisplayNumberOfData().getSelectedIndex()),
                0,
                AScaffoldingTable.FindMode.DEFAULT,
                UIConstant.Common.Punctuation.EMPTY
        );
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
//        System.out.println("deactive");
    }
}
