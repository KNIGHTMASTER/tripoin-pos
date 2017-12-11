package com.tripoin.pos.desktop.swing.component.menubar.home;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.controller.frame.ControllerFrameMain;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MenuClearDesktop extends JMenuItem implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8050702222633472824L;

    @Autowired
    private IResourceBundleLocator rb;

    @Autowired
    private ControllerFrameMain controllerFrameMain;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.cleardesktop.name"));
        this.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));

        initAction();
    }

    @Override
    public void initAction() {
        this.addActionListener(e -> controllerFrameMain.subMenuClearDesktopActionPerformed());
    }
}
