package com.tripoin.pos.desktop.swing.component.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class TripoinSwingManager {

    @Value("${general.app.theme}")
    private String appTheme;

    public void  setLAF(Component p_Component){
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if (appTheme.equals(info.getName())){
                try {
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                        SwingUtilities.updateComponentTreeUI(p_Component);
                        break;
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
