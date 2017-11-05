package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelScaffoldingNorth extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6769450010111493264L;

    @Autowired
    private PanelScaffoldingNorthBottom panelScaffoldingNorthBottom;

    @Autowired
    private PanelScaffoldingNorthTop panelScaffoldingNorthTop;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new GridLayout(2, 1));
        this.add(panelScaffoldingNorthTop);
        this.add(panelScaffoldingNorthBottom);

    }

    public PanelScaffoldingNorthTop getPanelScaffoldingNorthTop() {
        return panelScaffoldingNorthTop;
    }
}
