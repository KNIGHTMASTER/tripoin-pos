package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

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
public class PanelScaffoldingSouth extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -453749034602751480L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.add(new JLabel("Panel South"));
    }
}
