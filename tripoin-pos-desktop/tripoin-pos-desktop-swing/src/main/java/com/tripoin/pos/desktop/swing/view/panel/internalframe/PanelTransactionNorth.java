package com.tripoin.pos.desktop.swing.view.panel.internalframe;

import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxCustomerType;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTransactionNorth extends JPanel implements IComponentInitializer {

    @Autowired
    private ComboBoxCustomerType comboBoxCustomerType;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new GridLayout(3, 1));
        JLabel lblChooseCustomer = new JLabel("Choose Customer");
        lblChooseCustomer.setFont(new Font("Serif", Font.PLAIN, 30));

        JTextField textFieldProductCode = new JTextField("Product Code");
        textFieldProductCode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textFieldProductCode.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldProductCode.getText() == null || (textFieldProductCode.getText().trim()).length() <=0 ){
                    textFieldProductCode.setText("Product Code");
                }
            }
        });
        this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        this.add(lblChooseCustomer);
        this.add(comboBoxCustomerType);
        this.add(textFieldProductCode);
    }
}
