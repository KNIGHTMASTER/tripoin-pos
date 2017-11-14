package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class PanelScaffoldingNorth extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6769450010111493264L;

    protected PanelScaffoldingNorthTop panelScaffoldingNorthTop;
    protected PanelScaffoldingNorthBottom panelScaffoldingNorthBottom;

    @Override
    public void initComponents() {
        panelScaffoldingNorthTop = getPanelScaffoldingNorthTop();
        panelScaffoldingNorthTop.initComponents();
        panelScaffoldingNorthBottom = getPanelScaffoldingNorthBottom();
        panelScaffoldingNorthBottom.initComponents();

        this.setLayout(new GridLayout(2, 1));
        this.add(panelScaffoldingNorthTop);
        this.add(panelScaffoldingNorthBottom);
    }

    public abstract PanelScaffoldingNorthTop getPanelScaffoldingNorthTop();
    public abstract PanelScaffoldingNorthBottom getPanelScaffoldingNorthBottom();
}
