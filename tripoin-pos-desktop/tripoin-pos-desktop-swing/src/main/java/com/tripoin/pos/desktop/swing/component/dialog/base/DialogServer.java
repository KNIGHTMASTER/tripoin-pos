package com.tripoin.pos.desktop.swing.component.dialog.base;

import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IComponentMenuCallable;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.base.TripoinSwingManager;
import com.tripoin.pos.desktop.swing.controller.dialog.ControllerDialogServer;
import com.tripoin.pos.desktop.swing.view.tab.TabSettings;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogServer extends JDialog implements IComponentInitializer, IComponentAction, IComponentMenuCallable {

    /**
     *
     *
     */
    private static final long serialVersionUID = 6858232016968301160L;

    private static final Logger LOGGER = LoggerFactory.getLogger(DialogServer.class);

    @Autowired
    private TabSettings tabSettings;

    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    @Autowired
    private ControllerDialogServer controllerDialogServer;

    @Autowired
    private IResourceBundleLocator rb;

    @Autowired
    private TripoinSwingManager tripoinSwingManager;

    @Value("${splashscreen.icon.imageurl}")
    private String dialogServerIcon;

    public boolean isInitialized = false;

    @Override
    public void initComponents() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogServiceIcon = kit.getImage(getClass().getClassLoader().getResource(dialogServerIcon));
        this.setIconImage(dialogServiceIcon);
        this.setTitle(rb.getValue("ui.dialog.server.title"));
        this.setModal(true);
        this.setResizable(false);
        this.setSize(500, 250);
        centralizePositionComponent.setDialogToCenter(this);

        this.add(tabSettings);

        isInitialized = true;

        tripoinSwingManager.setLAF(this);

        initAction();
    }
    
    @Override
    public void initAction() {
        this.getRootPane().registerKeyboardAction(e -> this.dispose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    @Override
    public void setMainFrame(JFrame p_MainFrame) {

    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }
}
