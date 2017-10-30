package com.tripoin.pos.desktop.swing.view.internalframe;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameDashboard extends SideBarInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.dashboard.title";
    }
}
