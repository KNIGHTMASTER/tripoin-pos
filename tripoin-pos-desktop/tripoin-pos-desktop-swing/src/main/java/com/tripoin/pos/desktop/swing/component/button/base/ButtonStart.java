package com.tripoin.pos.desktop.swing.component.button.base;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonStart extends JButton implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -9199121169433925741L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText("Start");
    }
}