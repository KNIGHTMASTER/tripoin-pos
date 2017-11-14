package com.tripoin.pos.desktop.swing.component.label;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class LabelScaffoldingDisplay extends JLabel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1398055428650053672L;

    @Override
    public void initComponents() {
        this.setText(getRb().getValue("ui.scaffolding.label.show"));
    }

    public abstract IResourceBundleLocator getRb();
}
