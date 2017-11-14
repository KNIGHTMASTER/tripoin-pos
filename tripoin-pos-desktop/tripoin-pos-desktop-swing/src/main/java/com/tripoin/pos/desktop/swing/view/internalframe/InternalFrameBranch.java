package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableBranch;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.branch.BranchPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameBranch extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private BranchPanel branchPanel;

    @Autowired
    private TableBranch tableBranch;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = branchPanel;
        scaffoldingTable = tableBranch;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.branch.title";
    }
}
