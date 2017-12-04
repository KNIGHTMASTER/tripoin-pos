package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableFinanceAccount;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.financeaccount.FinanceAccountPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameFinanceAccount extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private FinanceAccountPanel financeAccountPanel;

    @Autowired
    private TableFinanceAccount tableFinanceAccount;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = financeAccountPanel;
        scaffoldingTable = tableFinanceAccount;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.financeaccount.title";
    }
}
