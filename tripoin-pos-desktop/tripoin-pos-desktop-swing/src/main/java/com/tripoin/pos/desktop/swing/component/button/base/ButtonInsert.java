package com.tripoin.pos.desktop.swing.component.button.base;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ButtonInsert extends SimpleButton {
    /**
     *
     *
     */
    private static final long serialVersionUID = 158175583875077099L;

    @Override
    public void initComponents() {
        this.setMnemonic('I');
        super.initComponents();
    }

    @Override
    public String getCaption() {
        return "ui.button.insert";
    }
}
