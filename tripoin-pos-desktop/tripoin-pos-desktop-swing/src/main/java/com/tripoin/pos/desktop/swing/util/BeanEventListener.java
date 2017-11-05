package com.tripoin.pos.desktop.swing.util;

import com.tripoin.pos.desktop.swing.component.base.TripoinSwingManager;
import com.tripoin.pos.desktop.swing.view.frame.MainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

    @Autowired
    private TripoinSwingManager tripoinSwingManager;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("All Beans Have Been Initialized || Refreshed");
        tripoinSwingManager.setLAF(mainFrame);
    }
}
