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
                            System.out.println("1");
                            desktopPaneMain.add(getPreventionInternalFrame());
                        } else {
                            for (java.awt.Component component : desktopPaneMain.getComponents()) {
                                System.out.println("2");
                                if (component.getName().equals(getPreventionComponentName())) {
                                    System.out.println("3");
                                    getPreventionInternalFrame().setVisible(true);
                                    break;
                                } else {
                                    if (getPreventionInternalFrame().isClosed()) {
                                        System.out.println("4");
                                        getPreventionInternalFrame().toFront();
                                    }else {
                                        System.out.println("4-1");
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
                            System.out.println("5");
                            getPreventionInternalFrame().resetComponent();
                            desktopPaneMain.add(getPreventionInternalFrame());
                            getPreventionInternalFrame().setVisible(true);
                        }else {
                            System.out.println("6");
                            getPreventionInternalFrame().showNewComponent(desktopPaneMain.getComponentCount());
                            desktopPaneMain.add(getPreventionInternalFrame());
                            getPreventionInternalFrame().setVisible(true);
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
