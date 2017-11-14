package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxFilter;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingDisplay;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingSearch;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class PanelScaffoldingNorthBottom extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5182990025311642595L;

    protected ComboBoxDisplayNumberOfData comboBoxDisplayNumberOfData;
    protected ComboBoxFilter comboBoxFilter;
    protected TextField txtSearch;

    @Override
    public void initComponents() {
        txtSearch = new TextField();
        comboBoxDisplayNumberOfData = getComboBoxDisplayNumberOfData();
        comboBoxFilter = getComboBoxFilter();

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(1, 2));
        panelLeft.add(getLabelScaffoldingDisplay());
        panelLeft.add(comboBoxDisplayNumberOfData);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(1, 3));
        panelRight.add(getLabelScaffoldingSearch());
        panelRight.add(getComboBoxFilter());
        panelRight.add(txtSearch);

        this.setLayout(new BorderLayout());
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
    }

    public TextField getTxtSearch() {
        return txtSearch;
    }

    public abstract LabelScaffoldingDisplay getLabelScaffoldingDisplay();

    public abstract ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData();

    public abstract LabelScaffoldingSearch getLabelScaffoldingSearch();

    public abstract ComboBoxFilter getComboBoxFilter();
}
