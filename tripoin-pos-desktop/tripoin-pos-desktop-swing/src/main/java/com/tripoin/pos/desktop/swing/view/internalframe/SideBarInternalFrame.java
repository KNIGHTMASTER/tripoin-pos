package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.base.TripoinSwingManager;
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
public abstract class SideBarInternalFrame extends JInternalFrame implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2470709694216660636L;

    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    @Autowired
    private IResourceBundleLocator rb;

    @Autowired
    private TripoinSwingManager tripoinSwingManager;

    private int yDefaultAxis = 180;
    private int xDefaultAxis = 70;
    @Override
    public void initComponents() {
        this.setName(this.getClass().getSimpleName());
        this.setTitle(rb.getValue(getTitleResourceBundle()));
        this.setMaximizable(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);

        resetComponent();

        tripoinSwingManager.setLAF(this);
    }

    public void resetComponent() {
        this.setSize(1200, 700);

        centralizePositionComponent.setIFrameToPosition(this, yDefaultAxis, xDefaultAxis);
    }

    public void showNewComponent(int p_NumberOfComponent){
        if (p_NumberOfComponent >= 1){
            int x = yDefaultAxis +(p_NumberOfComponent * 30);
            int y = xDefaultAxis +(p_NumberOfComponent * 25);
            centralizePositionComponent.setIFrameToPosition(this, x, y);
        }
    }


    public abstract String getTitleResourceBundle();
}
