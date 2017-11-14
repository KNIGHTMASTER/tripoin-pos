package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */

public abstract class PanelScaffoldingSouth extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -453749034602751480L;

    protected PanelPaginationButton panelPaginationButton;
    protected PanelPaginationIndex panelPaginationIndex;

    @Override
    public void initComponents() {
        panelPaginationButton = getPanelPaginationButton();

        panelPaginationIndex = new PanelPaginationIndex();
        panelPaginationIndex.initComponents();

        this.setLayout(new BorderLayout());
        this.add(panelPaginationIndex, BorderLayout.WEST);
        this.add(panelPaginationButton, BorderLayout.EAST);
    }

    public abstract PanelPaginationButton getPanelPaginationButton();

    public PanelPaginationIndex getPanelPaginationIndex() {
        return panelPaginationIndex;
    }
}
