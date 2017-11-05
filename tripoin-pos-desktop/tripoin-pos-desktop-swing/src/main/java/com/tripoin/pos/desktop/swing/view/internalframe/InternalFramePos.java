package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.view.panel.internalframe.PanelCatalog;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.PanelTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFramePos extends SideBarInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private PanelCatalog panelCatalog;

    @Autowired
    private PanelTransaction panelTransaction;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 65;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(panelCatalog, gbc);

        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = gbc.weighty = 35;
        this.add(panelTransaction, gbc);


        this.pack();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.pos.title";
    }
}
