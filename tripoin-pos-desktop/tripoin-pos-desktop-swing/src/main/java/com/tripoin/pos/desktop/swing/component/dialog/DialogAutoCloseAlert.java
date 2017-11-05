package com.tripoin.pos.desktop.swing.component.dialog;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogAutoCloseAlert extends JDialog implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4119242185252798649L;

    public enum MODE {
        INFO, WARNING, ERROR
    }

    @Value("${dialog.alert.autoclose.delay.time}")
    private int delay;

    @Override
    public void initComponents() {
        Timer timer = new Timer(delay, e -> {
            DialogAutoCloseAlert.this.setVisible(false);
            DialogAutoCloseAlert.this.dispose();
        });
        timer.setRepeats(false);
        timer.start();

        this.setModal(false);
        this.setSize(new Dimension(300, 150));
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public void setMode(MODE p_MODE) {
        JLabel lblInfo = new JLabel();
        switch (p_MODE) {
            case INFO: lblInfo.setText("Info");break;
            case ERROR: lblInfo.setText("Error");break;
            case WARNING: lblInfo.setText("Warning");break;
            default:
        }
        this.setLayout(new BorderLayout());
        this.add(lblInfo);
    }
}
