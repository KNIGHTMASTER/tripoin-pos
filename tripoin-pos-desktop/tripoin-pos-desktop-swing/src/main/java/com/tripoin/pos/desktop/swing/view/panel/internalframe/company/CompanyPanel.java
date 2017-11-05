package com.tripoin.pos.desktop.swing.view.panel.internalframe.company;

import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingCompany;
import com.tripoin.pos.desktop.swing.component.scrollpane.CompanyScrollPane;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AControllerScaffolding;
import com.tripoin.pos.desktop.swing.controller.panel.company.AControllerScaffoldingCompany;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding.AScaffoldingPanel;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class CompanyPanel extends AScaffoldingPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8769175557093613896L;

    @Autowired
    private CompanyScrollPane companyScrollPane;

    @Autowired
    private LabelScaffoldingCompany labelScaffoldingCompany;

    @Autowired
    private AControllerScaffoldingCompany controllerScaffoldingCompany;

    @PostConstruct
    @Override
    public void initComponents() {
        this.labelScaffoldingTitle = labelScaffoldingCompany;
        this.scrollPaneScaffolding = companyScrollPane;

        super.initComponents();
    }


    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return companyScrollPane.getTableCompany();
    }

    @Override
    public AControllerScaffolding getControllerScaffolding() {
        return controllerScaffoldingCompany;
    }
}
