package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction.PanelCatalog;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction.PanelTransaction;
import id.co.telkomsigma.tgf.util.IComponentAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFramePos extends SideBarInternalFrame implements IComponentAction {
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
        gbc.weightx = 80;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(panelCatalog, gbc);

        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = gbc.weighty = 20;
        this.add(panelTransaction, gbc);


        this.pack();

        initAction();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.pos.title";
    }

    @Override
    public void initAction() {
        this.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                panelCatalog.refreshCategory();
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {

            }
        });
    }
}
