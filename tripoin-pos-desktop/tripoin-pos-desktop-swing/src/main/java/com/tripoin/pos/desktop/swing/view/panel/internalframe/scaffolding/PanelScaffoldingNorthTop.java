package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelScaffoldingNorthTop extends JPanel implements IComponentInitializer  {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5182990025311642595L;

    @Autowired
    private PanelScaffoldingActionButton panelScaffoldingActionButton;

    @Autowired
    public LabelScaffoldingTitle labelScaffoldingTitle;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(panelScaffoldingActionButton, BorderLayout.EAST);
        this.add(labelScaffoldingTitle, BorderLayout.WEST);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)));
    }

    public PanelScaffoldingActionButton getPanelScaffoldingActionButton() {
        return panelScaffoldingActionButton;
    }
}
