package com.tripoin.pos.desktop.swing.component.button.base;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ButtonDelete extends SimpleButton {
    /**
     *
     *
     */
    private static final long serialVersionUID = 158175583875077099L;

    @Override
    public void initComponents() {
        this.setMnemonic('D');
        this.setEnabled(false);
        super.initComponents();
    }

    @Override
    public String getCaption() {
        return "ui.button.delete";
    }
}
