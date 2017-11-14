package com.tripoin.pos.desktop.swing.component.button.base;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class SimpleButton extends JButton implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7420729900328221642L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(getRb().getValue(getCaption()));
    }

    public abstract String getCaption();

    public abstract IResourceBundleLocator getRb();
}
