package com.tripoin.pos.desktop.swing.component.list;

import com.tripoin.pos.desktop.swing.view.desktoppane.DesktopPaneMain;
import com.tripoin.pos.desktop.swing.view.internalframe.SideBarInternalFrame;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Created on 10/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public abstract class ListSideBarMenu extends JList<String> implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5901978938946809737L;

    @Autowired
    private DesktopPaneMain desktopPaneMain;

    @Override
    public void initComponents() {
        this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.setVisibleRowCount(-1);
        this.setListData(getListData());

        initAction();
    }

    @Override
    public void initAction() {
        this.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (this.getSelectedIndex() != -1) {
                    if (getPreventionInternalFrame().isVisible()) {
                        System.out.println(getPreventionComponentName());
                        if (desktopPaneMain.getComponentCount() <= 0) {
                            desktopPaneMain.add(getPreventionInternalFrame());
                            getPreventionInternalFrame().toFront();
                        } else {
                            for (java.awt.Component component : desktopPaneMain.getComponents()) {
                                if (component.getName().equals(getPreventionComponentName())) {
                                    getPreventionInternalFrame().setVisible(true);
                                    getPreventionInternalFrame().toFront();
                                    break;
                                } else {
                                    if (getPreventionInternalFrame().isClosed()) {
                                        getPreventionInternalFrame().toFront();
                                    }else {
                                        try{
                                            getPreventionInternalFrame().showNewComponent(desktopPaneMain.getComponentCount());
                                            desktopPaneMain.add(getPreventionInternalFrame());
                                            getPreventionInternalFrame().toFront();
                                        }catch (Exception ex) {
                                            getPreventionInternalFrame().toFront();
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (desktopPaneMain.getComponentCount() <= 0){
                            getPreventionInternalFrame().resetComponent();
                            desktopPaneMain.add(getPreventionInternalFrame());
                            getPreventionInternalFrame().setVisible(true);
                            getPreventionInternalFrame().toFront();
                        }else {
                            getPreventionInternalFrame().showNewComponent(desktopPaneMain.getComponentCount());
                            desktopPaneMain.add(getPreventionInternalFrame());
                            getPreventionInternalFrame().setVisible(true);
                            getPreventionInternalFrame().toFront();
                        }
                    }
                    this.clearSelection();
                }
            }
        });
    }

    protected String getPreventionComponentName(){
        return getPreventionInternalFrame().getClass().getSimpleName();
    }

    public abstract SideBarInternalFrame getPreventionInternalFrame();
    public abstract String[] getListData();
}
