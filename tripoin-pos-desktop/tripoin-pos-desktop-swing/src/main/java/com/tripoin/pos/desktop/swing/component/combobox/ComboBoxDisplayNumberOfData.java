package com.tripoin.pos.desktop.swing.component.combobox;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ComboBoxDisplayNumberOfData extends JComboBox<String> implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7406884693673187302L;

    @Override
    public void initComponents() {
        this.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{
                                "10",
                                "25",
                                "50",
                                "100",
                        }
                )
        );
    }

    public int getSelectedValue(int p_Index){
        int result = 0;
        switch (p_Index) {
            case 0 : result = 10; break;
            case 1 : result = 25; break;
            case 2 : result = 50; break;
            case 3 : result = 100; break;
            default:
        }
        return result;
    }
}
