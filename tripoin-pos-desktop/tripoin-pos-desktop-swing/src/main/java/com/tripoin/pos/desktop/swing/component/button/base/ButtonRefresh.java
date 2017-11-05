package com.tripoin.pos.desktop.swing.component.button.base;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 6/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonRefresh extends SimpleButton implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4586525469944550439L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMnemonic('R');
        super.initComponents();
    }

    @Override
    public String getCaption() {
        return "ui.button.refresh";
    }
}
