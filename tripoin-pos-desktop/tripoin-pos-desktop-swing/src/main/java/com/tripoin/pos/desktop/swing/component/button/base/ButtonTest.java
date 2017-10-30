package com.tripoin.pos.desktop.swing.component.button.base;

import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ButtonTest extends JButton implements IComponentInitializer {
    
    private static final long serialVersionUID = -1441161236689632531L;

    @Override
    public void initComponents() {
        this.setText("Test");
        this.setMnemonic('T');
        this.setFocusable(false);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

}
