package com.tripoin.pos.desktop.swing.component.button.base;

import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class SimpleIconButton extends JButton implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2510653414251904076L;

    @PostConstruct
    @Override
    public void initComponents() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Icon frameIcon = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource(getImagePath())));
        this.setIcon(frameIcon);
    }

    public abstract String getImagePath();


}
