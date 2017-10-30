package com.tripoin.pos.desktop.swing;

import com.tripoin.pos.desktop.swing.dto.param.SplashScreenParam;
import com.tripoin.pos.desktop.swing.view.splash.SplashScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <p>Launch the application GUI</p>
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
@Component
public class Runner implements CommandLineRunner {

    /**
     * Pull in the JFrame to be displayed.
     */
    @Autowired
    protected SplashScreen splashScreen;

    @Value("${splashscreen.icon.imageurl}")
    protected String splashScreenIconImageUrl;

    @Value("${splashscreen.background.imageurl}")
    protected String splashScreenBackgroundImageUrl;

    @Override
    public void run(String... args) throws Exception {
        SplashScreenParam splashScreenParam = new SplashScreenParam();
        splashScreenParam.setIconImageUrl(splashScreenIconImageUrl);
        splashScreenParam.setSplashScreenImageUrl(splashScreenBackgroundImageUrl);
        splashScreen.setParam(splashScreenParam);

        java.awt.EventQueue.invokeLater(() -> {
            try {
                splashScreen.startSplash();
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
