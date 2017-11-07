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
public class PanelScaffoldingSouth extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -453749034602751480L;

    @Autowired
    private PanelPaginationButton panelPaginationButton;

    @Autowired
    private PanelPaginationIndex panelPaginationIndex;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(panelPaginationIndex, BorderLayout.WEST);
        this.add(panelPaginationButton, BorderLayout.EAST);
    }

    public PanelPaginationButton getPanelPaginationButton() {
        return panelPaginationButton;
    }

    public PanelPaginationIndex getPanelPaginationIndex() {
        return panelPaginationIndex;
    }
}
