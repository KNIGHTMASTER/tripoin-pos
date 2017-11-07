package com.tripoin.pos.desktop.swing.component.label;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class LabelScaffoldingTitle extends JLabel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 332587950901187861L;

    @Autowired
    IResourceBundleLocator rb;

    @Override
    public void initComponents() {
        this.setFont(new Font("Serif", Font.PLAIN, 25));
        this.setText(rb.getValue(getCaption()));
    }

    public abstract String getCaption();
}
