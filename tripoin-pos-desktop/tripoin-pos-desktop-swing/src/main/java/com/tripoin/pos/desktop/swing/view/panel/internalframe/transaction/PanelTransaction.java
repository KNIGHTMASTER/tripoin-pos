package com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction;

import com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction.PanelTransactionNorth;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTransaction extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6662193437727910549L;

    @Autowired
    private PanelTransactionNorth panelTransactionNorth;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());
        this.add(panelTransactionNorth, BorderLayout.NORTH);
    }
}