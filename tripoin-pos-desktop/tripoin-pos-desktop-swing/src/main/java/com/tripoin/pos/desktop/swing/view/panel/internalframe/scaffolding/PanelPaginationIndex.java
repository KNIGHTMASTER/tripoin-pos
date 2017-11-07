package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelPaginationIndex extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2467889427733714865L;

    private int startNumber = 0;
    private int endNumber = 0;
    private int totalNumber = 0;

    private JLabel labelIndex;

    @PostConstruct
    @Override
    public void initComponents() {
        labelIndex = new JLabel();
        labelIndex.setFont(new Font("Serif", Font.PLAIN, 18));
        String text = "Showing "+startNumber+" - "+endNumber+" from "+totalNumber+" Record";
        labelIndex.setText(text);

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
