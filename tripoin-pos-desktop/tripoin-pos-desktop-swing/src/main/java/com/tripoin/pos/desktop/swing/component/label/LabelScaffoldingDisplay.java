package com.tripoin.pos.desktop.swing.component.label;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LabelScaffoldingDisplay extends JLabel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1398055428650053672L;

    @Autowired
    IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("ui.scaffolding.label.show"));
    }
}
