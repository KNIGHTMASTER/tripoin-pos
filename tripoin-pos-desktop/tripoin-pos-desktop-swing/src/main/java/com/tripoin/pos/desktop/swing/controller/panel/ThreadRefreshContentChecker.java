package com.tripoin.pos.desktop.swing.controller.panel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created on 1/8/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ThreadRefreshContentChecker {

    @Autowired
    private RefreshContentChecker refreshContentChecker;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadRefreshContentChecker.class);

    /*@Async*/
    public Integer check() {
        Integer firstValue = refreshContentChecker.check();
        Integer newValue = 0;
        while (Objects.equals(newValue, firstValue)) {
            newValue = refreshContentChecker.check();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return newValue;
    }

    @Async
    public void update(){
        refreshContentChecker.update();
    }
}
