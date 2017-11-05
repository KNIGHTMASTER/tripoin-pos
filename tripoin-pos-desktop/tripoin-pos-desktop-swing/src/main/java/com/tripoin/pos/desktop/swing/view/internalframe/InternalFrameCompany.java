package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableCompany;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.company.CompanyPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameCompany extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private CompanyPanel panelCompany;

    @Autowired
    private TableCompany tableCompany;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = panelCompany;
        scaffoldingTable = tableCompany;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.company.title";
    }
}
