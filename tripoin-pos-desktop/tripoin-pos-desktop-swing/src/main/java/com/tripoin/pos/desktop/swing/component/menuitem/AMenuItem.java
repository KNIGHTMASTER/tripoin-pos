package com.tripoin.pos.desktop.swing.component.menuitem;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AMenuItem extends JMenuItem implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2594553140544513091L;

    @Autowired
    private IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue(getCaption()));
    }

    public abstract String getCaption();
}
