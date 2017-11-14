package com.tripoin.pos.desktop.swing.component.label;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class LabelScaffoldingSearch extends JLabel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1398055428650053672L;

    public abstract IResourceBundleLocator getRb();

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(getRb().getValue("ui.scaffolding.label.search"));
    }
}
