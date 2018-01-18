package com.tripoin.pos.desktop.swing.component.label;

import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 1/8/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class LabelIndex extends JLabel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2580814501886011835L;

    @Override
    public void initComponents() {
        this.setFont(new Font("Serif", Font.PLAIN, 18));
    }

}
