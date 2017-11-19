package com.tripoin.pos.desktop.swing.component.button.base;

import javax.swing.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ButtonClear extends SimpleButton {

    /**
     *
     *
     */
    private static final long serialVersionUID = -1441161236689632531L;

    @Override
    public void initComponents() {
        this.setMnemonic('C');
        this.setFocusable(false);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);

        super.initComponents();
    }

    @Override
    public String getCaption() {
        return "ui.button.clear";
    }

}
