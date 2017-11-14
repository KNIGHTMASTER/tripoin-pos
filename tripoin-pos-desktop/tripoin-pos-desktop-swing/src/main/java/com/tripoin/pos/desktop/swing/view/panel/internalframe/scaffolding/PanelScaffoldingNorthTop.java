package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class PanelScaffoldingNorthTop extends JPanel implements IComponentInitializer  {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5182990025311642595L;

    protected PanelScaffoldingActionButton panelScaffoldingActionButton;

    @Override
    public void initComponents() {
        panelScaffoldingActionButton = getPanelScaffoldingActionButton();
        panelScaffoldingActionButton.initComponents();

        this.setLayout(new BorderLayout());
        this.add(panelScaffoldingActionButton, BorderLayout.EAST);
        this.add(getLabelScaffoldingTitle(), BorderLayout.WEST);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)));
    }

    public abstract PanelScaffoldingActionButton getPanelScaffoldingActionButton();
    public abstract LabelScaffoldingTitle getLabelScaffoldingTitle();
}
