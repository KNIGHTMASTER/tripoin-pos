package com.tripoin.pos.desktop.swing.component.menubar.settings;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.controller.frame.ControllerFrameMain;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 10/25/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MenuServer extends JMenuItem implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -555234408223400258L;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.server.imageurl}")
    private String menuServerImageUrl;

    @Autowired
    private ControllerFrameMain controllerFrameMain;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.server.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuServerImageUrl)));
        this.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        this.addActionListener(e -> controllerFrameMain.subMenuServerActionPerformed());
    }
}
