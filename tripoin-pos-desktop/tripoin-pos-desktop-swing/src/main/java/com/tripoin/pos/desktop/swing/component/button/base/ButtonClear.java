package com.tripoin.pos.desktop.swing.component.button.base;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonClear extends SimpleButton {

    /**
     *
     *
     */
    private static final long serialVersionUID = -1441161236689632531L;

    @PostConstruct
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
