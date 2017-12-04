package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableBank;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.bank.BankPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameBank extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private BankPanel bankPanel;

    @Autowired
    private TableBank tableBank;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = bankPanel;
        scaffoldingTable = tableBank;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.bank.title";
    }
}
