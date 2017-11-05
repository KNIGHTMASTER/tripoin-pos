package com.tripoin.pos.desktop.swing.component.popup;

import com.tripoin.pos.desktop.swing.client.ICompanyClient;
import com.tripoin.pos.desktop.swing.client.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.dialog.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.dialog.ScaffoldingDialogCompany;
import com.tripoin.pos.desktop.swing.component.table.view.TableCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class CompanyPopUp extends AScaffoldingPopUp {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1273015372061110255L;

    @Autowired
    private TableCompany tableCompany;

    @Autowired
    private ICompanyClient companyClient;

    @Autowired
    private ScaffoldingDialogCompany dialogDetailCompany;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingTable = tableCompany;
        super.initComponents();
    }

    @Override
    protected IScaffoldingClient getScaffoldingClient() {
        return companyClient;
    }

    @Override
    protected AScaffoldingDialog getScaffoldingDialog() {
        return dialogDetailCompany;
    }
}
