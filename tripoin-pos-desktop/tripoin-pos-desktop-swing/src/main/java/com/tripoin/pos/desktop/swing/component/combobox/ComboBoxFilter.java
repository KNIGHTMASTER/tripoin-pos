package com.tripoin.pos.desktop.swing.component.combobox;

import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ComboBoxFilter extends JComboBox<String> implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7406884693673187302L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{
                                "Code",
                                "Name"
                        }
                )
        );
    }

    public AScaffoldingTable.FindMode getSelectedMode(int p_Index){
        switch (p_Index) {
            case 0 : return AScaffoldingTable.FindMode.CODE;
            case 1 : return AScaffoldingTable.FindMode.NAME;
            default: return AScaffoldingTable.FindMode.DEFAULT;
        }
    }
}
