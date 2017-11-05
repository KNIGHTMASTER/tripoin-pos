package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxFilter;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingDisplay;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingSearch;
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
public class PanelScaffoldingNorthBottom extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5182990025311642595L;

    @Autowired
    private LabelScaffoldingDisplay labelScaffoldingDisplay;

    @Autowired
    private ComboBoxDisplayNumberOfData comboBoxDisplayNumberOfData;

    @Autowired
    private LabelScaffoldingSearch labelScaffoldingSearch;

    @Autowired
    private ComboBoxFilter comboBoxFilter;

    private TextField txtSearch = new TextField();

    @PostConstruct
    @Override
    public void initComponents() {
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(1, 2));
        panelLeft.add(labelScaffoldingDisplay);
        panelLeft.add(comboBoxDisplayNumberOfData);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(1, 3));
        panelRight.add(labelScaffoldingSearch);
        panelRight.add(comboBoxFilter);
        panelRight.add(txtSearch);

        this.setLayout(new BorderLayout());
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
    }

    public TextField getTxtSearch() {
        return txtSearch;
    }
}
