package com.tripoin.pos.desktop.swing.component.table.listener;

import com.tripoin.pos.desktop.swing.component.popup.AScaffoldingPopUp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created on 7/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AScaffoldingTableListener extends MouseAdapter {

    @Autowired
    AScaffoldingPopUp scaffoldingPopUp;

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
}
