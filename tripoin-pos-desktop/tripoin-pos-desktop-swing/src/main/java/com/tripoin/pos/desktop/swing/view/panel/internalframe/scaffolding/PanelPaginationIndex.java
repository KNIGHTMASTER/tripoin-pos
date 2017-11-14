package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PanelPaginationIndex extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2467889427733714865L;

    protected JLabel labelIndex;

    @Override
    public void initComponents() {
        labelIndex = new JLabel();
        labelIndex.setFont(new Font("Serif", Font.PLAIN, 18));


        this.setLayout(new BorderLayout());
        this.add(labelIndex);
    }

    public JLabel getLabelIndex() {
        return labelIndex;
    }

    public void setLabelIndex(JLabel labelIndex) {
        this.labelIndex = labelIndex;
    }
}
