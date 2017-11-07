package com.tripoin.pos.desktop.swing.component.button.base;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonUpdate extends SimpleButton {
    /**
     *
     *
     */
    private static final long serialVersionUID = 158175583875077099L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMnemonic('U');
        this.setEnabled(false);
        super.initComponents();
    }

    @Override
    public String getCaption() {
        return "ui.button.update";
    }
}
