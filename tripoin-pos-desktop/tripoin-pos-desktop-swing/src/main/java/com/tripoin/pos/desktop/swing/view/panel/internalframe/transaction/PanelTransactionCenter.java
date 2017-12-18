package com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction;

import com.tripoin.pos.desktop.swing.component.scrollpane.TransactionScrollPane;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 10/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTransactionCenter extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6134432811624469132L;

    @Autowired
    private TransactionScrollPane transactionScrollPane;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(transactionScrollPane, BorderLayout.NORTH);
    }
}
