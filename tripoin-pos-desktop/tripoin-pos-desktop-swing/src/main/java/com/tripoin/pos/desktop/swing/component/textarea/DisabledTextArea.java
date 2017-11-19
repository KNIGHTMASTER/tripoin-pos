package com.tripoin.pos.desktop.swing.component.textarea;

import javax.swing.*;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DisabledTextArea extends JTextArea {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1477003709484195185L;

    public DisabledTextArea() {
        this.setEnabled(false);
    }
}
