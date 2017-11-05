package com.tripoin.pos.desktop.swing.component.combobox;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ComboBoxCustomerType extends JComboBox<String> implements IComponentInitializer {

    @PostConstruct
    @Override
    public void initComponents() {
        this.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{
                                "Walkin Customer",
                                "Member",
                        }
                )
        );
    }
}
