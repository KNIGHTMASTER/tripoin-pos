package com.tripoin.pos.desktop.swing.dto.param;

import com.tripoin.pos.desktop.swing.component.dialog.base.DialogAbout;
import com.tripoin.pos.desktop.swing.component.dialog.base.DialogLogin;
import com.tripoin.pos.desktop.swing.component.dialog.base.DialogServer;
import com.tripoin.pos.desktop.swing.component.dialog.base.DialogTheme;
import com.tripoin.pos.desktop.swing.view.desktoppane.DesktopPaneMain;
import com.tripoin.pos.desktop.swing.view.frame.MainFrame;

import java.io.Serializable;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ControllerFrameMainParam implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5049333533348088550L;

    private int screenSizeWidth;
    private int screenSizeHeight;
    private int observerWidth;
    private int observerHeight;

    private MainFrame mainFrame;
    private DialogLogin dialogLogin;
    private DialogAbout dialogAbout;
    private DialogServer dialogServer;
    private DialogTheme dialogTheme;
    private DesktopPaneMain desktopPaneMain;

    public DesktopPaneMain getDesktopPaneMain() {
        return desktopPaneMain;
    }

    public void setDesktopPaneMain(DesktopPaneMain desktopPaneMain) {
        this.desktopPaneMain = desktopPaneMain;
    }

    public int getScreenSizeWidth() {
        return screenSizeWidth;
    }

    public void setScreenSizeWidth(int screenSizeWidth) {
        this.screenSizeWidth = screenSizeWidth;
    }

    public int getScreenSizeHeight() {
        return screenSizeHeight;
    }

    public void setScreenSizeHeight(int screenSizeHeight) {
        this.screenSizeHeight = screenSizeHeight;
    }

    public int getObserverWidth() {
        return observerWidth;
    }

    public void setObserverWidth(int observerWidth) {
        this.observerWidth = observerWidth;
    }

    public int getObserverHeight() {
        return observerHeight;
    }

    public void setObserverHeight(int observerHeight) {
        this.observerHeight = observerHeight;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public DialogLogin getDialogLogin() {
        return dialogLogin;
    }

    public void setDialogLogin(DialogLogin dialogLogin) {
        this.dialogLogin = dialogLogin;
    }

    public DialogAbout getDialogAbout() {
        return dialogAbout;
    }

    public void setDialogAbout(DialogAbout dialogAbout) {
        this.dialogAbout = dialogAbout;
    }

    public DialogServer getDialogServer() {
        return dialogServer;
    }

    public void setDialogServer(DialogServer dialogServer) {
        this.dialogServer = dialogServer;
    }

    public DialogTheme getDialogTheme() {
        return dialogTheme;
    }

    public void setDialogTheme(DialogTheme dialogTheme) {
        this.dialogTheme = dialogTheme;
    }
}
