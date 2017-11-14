package com.tripoin.pos.desktop.swing.component.dialog;

import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.base.TripoinSwingManager;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxTheme;
import com.tripoin.pos.desktop.swing.controller.dialog.ControllerDialogTheme;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogTheme extends JDialog implements IComponentInitializer {
    
    private static final long serialVersionUID = -910170184194682402L;
    
    @Autowired
    private ControllerDialogTheme themeChooser;

    @Autowired
    private ComboBoxTheme comboBoxTheme;

    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    @Autowired
    private IResourceBundleLocator rb;

    @Autowired
    private TripoinSwingManager tripoinSwingManager;

    @Value("${splashscreen.icon.imageurl}")
    private String dialogThemeIcon;
    
    private java.awt.Component component;
    
    private boolean isInitiated = false;

    public void setComponent(java.awt.Component component) {
        this.component = component;
    }
            
    @Override
    public void initComponents() {
        this.setModal(true);
        this.setSize(300, 80);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogIcon = kit.getImage(getClass().getClassLoader().getResource(dialogThemeIcon));
        this.setIconImage(dialogIcon);

        centralizePositionComponent.setDialogToCenter(this);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle(rb.getValue("ui.dialog.theme.title"));
        this.getContentPane().setLayout(new GridLayout(1, 2));

        JLabel lblOption = new JLabel("Option : ");        
        this.getContentPane().add(lblOption);                                
        
        this.getContentPane().add(comboBoxTheme);
        
        comboBoxTheme.addActionListener(evt -> themeChooser.start(comboBoxTheme, component));
        isInitiated = true;

        tripoinSwingManager.setLAF(this);
    }

    public boolean isIsInitiated() {
        return isInitiated;
    }
    
}
