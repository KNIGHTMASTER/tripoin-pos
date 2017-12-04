package com.tripoin.pos.desktop.swing.component.dialog.base;

import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.base.TripoinSwingManager;
import com.tripoin.pos.desktop.swing.controller.dialog.ControllerDialogLogin;
import com.tripoin.pos.desktop.swing.view.frame.MainFrame;
import com.tripoin.pos.desktop.swing.view.panel.login.DialogLoginPanelBottom;
import com.tripoin.pos.desktop.swing.view.panel.login.DialogLoginPanelTop;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
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
public class DialogLogin extends JDialog implements IComponentInitializer, IComponentAction {
    
    private static final long serialVersionUID = 6858232016968301160L;    
    
    @Autowired
    private ControllerDialogLogin controllerDialogLogin;
    
    @Autowired
    private DialogLoginPanelTop dialogLoginPanelTop;
    
    @Autowired
    private DialogLoginPanelBottom dialogLoginPanelBottom;

    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    @Autowired
    private IResourceBundleLocator rb;

    @Autowired
    private TripoinSwingManager tripoinSwingManager;

    @Value("${splashscreen.icon.imageurl}")
    private String dialogLoginIcon;

    private MainFrame mainFrame;
    
    private boolean isInitiated = false;

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }            
    
    @Override
    public void initComponents() {
        this.setTitle(rb.getValue("ui.dialog.login.title"));
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogIcon = kit.getImage(getClass().getClassLoader().getResource(dialogLoginIcon));
        this.setIconImage(dialogIcon);

        this.getContentPane().add(dialogLoginPanelTop, BorderLayout.CENTER);
        this.getContentPane().add(dialogLoginPanelBottom, BorderLayout.PAGE_END);
        this.setModal(true);
        this.setSize(400, 150);
        centralizePositionComponent.setDialogToCenter(this);

        initAction();
        isInitiated = true;

        tripoinSwingManager.setLAF(this);
    }                
    
    @Override
    public void initAction() {
        final JTextField txtUserName = dialogLoginPanelTop.getDialogLoginPanelRight().getTxtUserName();
        final JPasswordField txtPassword = dialogLoginPanelTop.getDialogLoginPanelRight().getTxtPassword();
        dialogLoginPanelBottom.getBtLogin().addActionListener(evt -> controllerDialogLogin.btLoginActionPerformed(evt, txtUserName, mainFrame, rootPane, txtPassword, DialogLogin.this));
        
        dialogLoginPanelBottom.getBtReset().addActionListener(evt -> controllerDialogLogin.btResetActionPerformed(evt, txtUserName, txtPassword));
        this.getRootPane().registerKeyboardAction(e -> this.dispose(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }           

    public boolean isInitiated() {
        return isInitiated;
    }
        
}
