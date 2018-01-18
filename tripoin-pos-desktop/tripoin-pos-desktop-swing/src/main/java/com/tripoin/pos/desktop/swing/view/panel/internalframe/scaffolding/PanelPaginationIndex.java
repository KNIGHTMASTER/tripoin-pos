package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.label.LabelIndex;
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

    protected LabelIndex labelIndex;

    @Override
    public void initComponents() {
        labelIndex = new LabelIndex();
        labelIndex.initComponents();

        this.setLayout(new BorderLayout());
        this.add(labelIndex);
    }

    public LabelIndex getLabelIndex() {
        return labelIndex;
    }

    public void setLabelIndex(LabelIndex labelIndex) {
        this.labelIndex = labelIndex;
    }
}
