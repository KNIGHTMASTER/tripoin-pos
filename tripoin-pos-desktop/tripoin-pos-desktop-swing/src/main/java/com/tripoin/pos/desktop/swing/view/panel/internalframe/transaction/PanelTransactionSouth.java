package com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 12/17/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTransactionSouth extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3859112246420264955L;

    private JPanel panelTransactionSummary = new JPanel();
    private JLabel lblSubTotal = new JLabel("Sub Total");
    private JLabel lblOrderTax = new JLabel("Order Tax");
    private JLabel lblDiscount = new JLabel("Discount");
    private JLabel lblTotal = new JLabel("Total");

    private JTextField txtSubTotal = new JTextField();
    private JTextField txtOrderTax = new JTextField();
    private JTextField txtDiscount = new JTextField();
    private JTextField txtTotal = new JTextField();

    private JPanel panelButtonAction = new JPanel();
    private JButton btCancel = new JButton("CANCEL");
    private JButton btPayment = new JButton("PAYMENT");

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());

        panelTransactionSummary.setLayout(new GridLayout(4, 2));
        txtSubTotal.setEnabled(false);
        txtOrderTax.setEnabled(false);
        txtDiscount.setEnabled(false);
        txtTotal.setEnabled(false);

        panelTransactionSummary.add(lblSubTotal);
        panelTransactionSummary.add(txtSubTotal);

        panelTransactionSummary.add(lblOrderTax);
        panelTransactionSummary.add(txtOrderTax);

        panelTransactionSummary.add(lblDiscount);
        panelTransactionSummary.add(txtDiscount);

        panelTransactionSummary.add(lblTotal);
        panelTransactionSummary.add(txtTotal);

        panelButtonAction.setLayout(new GridLayout(1, 2));
        panelButtonAction.add(btCancel);
        panelButtonAction.add(btPayment);

        panelTransactionSummary.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        this.add(panelTransactionSummary, BorderLayout.CENTER);
        this.add(panelButtonAction, BorderLayout.SOUTH);
    }
}
