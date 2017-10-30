package com.tripoin.pos.desktop.swing.util;

import com.tripoin.pos.desktop.swing.view.frame.MainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Created on 7/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class BeanEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanEventListener.class);

    @Autowired
    private MainFrame mainFrame;

    @Value("${general.app.theme}")
    private String appTheme;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("All Beans Have Been Initialized || Refreshed");

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if (appTheme.equals(info.getName())){
                try {
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                        SwingUtilities.updateComponentTreeUI(mainFrame);
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
