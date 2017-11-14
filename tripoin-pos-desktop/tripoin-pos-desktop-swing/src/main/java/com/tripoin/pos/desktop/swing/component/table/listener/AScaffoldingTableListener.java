package com.tripoin.pos.desktop.swing.component.table.listener;

import com.tripoin.pos.desktop.swing.component.popup.AScaffoldingPopUp;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created on 7/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AScaffoldingTableListener extends MouseAdapter implements IComponentInitializer {

    public AScaffoldingPopUp scaffoldingPopUp;

    @Override
    public void initComponents() {
        scaffoldingPopUp = getScaffoldingPopUp();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)){
            if (e.isPopupTrigger()){
                scaffoldingPopUp.setPoint(e.getPoint());
                scaffoldingPopUp.setVisible(true);
                scaffoldingPopUp.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    public abstract AScaffoldingPopUp getScaffoldingPopUp();
}
