package com.tripoin.pos.desktop.swing.view.frame;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.dialog.DialogAbout;
import com.tripoin.pos.desktop.swing.component.dialog.DialogLogin;
import com.tripoin.pos.desktop.swing.component.dialog.DialogServer;
import com.tripoin.pos.desktop.swing.component.dialog.DialogTheme;
import com.tripoin.pos.desktop.swing.component.frame.IFrameSetup;
import com.tripoin.pos.desktop.swing.component.menubar.AppSwingMenuBar;
import com.tripoin.pos.desktop.swing.component.sidebar.DefaultSideBarMenu;
import com.tripoin.pos.desktop.swing.controller.frame.ControllerFrameMain;
import com.tripoin.pos.desktop.swing.dto.param.ControllerFrameMainParam;
import com.tripoin.pos.desktop.swing.view.internalframe.InternalFrameDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MainFrame extends JFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7864902051693765103L;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainFrame.class);

    final Toolkit toolkit = Toolkit.getDefaultToolkit();
    final Dimension screenSize = toolkit.getScreenSize();

    private ControllerFrameMainParam controllerFrameMainParam;

    @Autowired
    private IFrameSetup frameSetup;

    @Autowired
    private DialogTheme dialogTheme;

    @Autowired
    private DialogLogin dialogLogin;

    @Autowired
    private DialogAbout dialogAbout;

    @Autowired
    private DialogServer dialogServer;

    @Autowired
    private InternalFrameDashboard internalFrameDashboard;

    @Autowired
    private ControllerFrameMain controllerFrameMain;

    @Autowired
    private DefaultSideBarMenu defaultSideBarMenu;

    @Autowired
    private AppSwingMenuBar appMenuBar;

    @Autowired
    private IResourceBundleLocator rb;

    @PostConstruct
    public void setupFrame(){
        frameSetup.doCompleteSetup(MainFrame.this, MainFrame.this);
        initParam();
        controllerFrameMain.setParam(controllerFrameMainParam);
        initComponents();
    }


    private void initParam(){
        controllerFrameMainParam = new ControllerFrameMainParam();

        controllerFrameMainParam.setScreenSizeHeight(screenSize.height);
        controllerFrameMainParam.setScreenSizeWidth(screenSize.width);
        controllerFrameMainParam.setObserverHeight(HEIGHT);
        controllerFrameMainParam.setObserverWidth(WIDTH);

        controllerFrameMainParam.setMainFrame(this);
        controllerFrameMainParam.setDialogAbout(dialogAbout);
        controllerFrameMainParam.setDialogLogin(dialogLogin);
        controllerFrameMainParam.setDialogServer(dialogServer);
        controllerFrameMainParam.setDialogTheme(dialogTheme);
    }

    public void setMenuVisibility(boolean b){
        internalFrameDashboard.setVisible(b);
        appMenuBar.setMenuVisibility(b);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        setTitle(rb.getValue("ui.main.title"));
        setMenuVisibility(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(appMenuBar);
        this.setLayout(new BorderLayout());
        this.add(defaultSideBarMenu, BorderLayout.CENTER);
        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
