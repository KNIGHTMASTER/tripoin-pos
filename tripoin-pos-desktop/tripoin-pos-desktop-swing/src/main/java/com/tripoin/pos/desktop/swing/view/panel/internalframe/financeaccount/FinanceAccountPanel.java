package com.tripoin.pos.desktop.swing.view.panel.internalframe.financeaccount;

import com.tripoin.pos.desktop.swing.client.IFinanceAccountClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.dialog.impl.ScaffoldingDialogFinanceAccount;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingFinanceAccount;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.popup.AScaffoldingPopUp;
import com.tripoin.pos.desktop.swing.component.scrollpane.FinanceAccountScrollPane;
import com.tripoin.pos.desktop.swing.component.table.listener.AScaffoldingTableListener;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.controller.panel.financeaccount.ScaffoldingControllerFinanceAccount;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding.AScaffoldingPanel;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class FinanceAccountPanel extends AScaffoldingPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8769175557093613896L;

    @Autowired
    private LabelScaffoldingFinanceAccount labelScaffoldingFinanceAccount;

    @Autowired
    private ScaffoldingControllerFinanceAccount scaffoldingControllerFinanceAccount;

    @Autowired
    private IFinanceAccountClient financeAccountClient;

    @Autowired
    private FinanceAccountScrollPane financeAccountScrollPane;

    @Value("${splashscreen.icon.imageurl}")
    private String scaffoldingDialogIcon;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingScrollPane = financeAccountScrollPane;
        scaffoldingDialog = new ScaffoldingDialogFinanceAccount() {
            private static final long serialVersionUID = -2243165273326500179L;

            @Override
            public IScaffoldingClient getScaffoldingClient() {
                return financeAccountClient;
            }

            @Override
            public AScaffoldingController getControllerScaffolding() {
                return FinanceAccountPanel.this.getControllerScaffolding();
            }

            @Override
            public AScaffoldingTable getScaffoldingTable() {
                return FinanceAccountPanel.this.getScaffoldingTable();
            }

            @Override
            public IResourceBundleLocator getRb() {
                return FinanceAccountPanel.this.rb;
            }

            @Override
            public ICentralizePositionComponent getCentralizePositionComponent() {
                return FinanceAccountPanel.this.centralizePositionComponent;
            }

            @Override
            public String getScaffoldingDialogIcon() {
                return scaffoldingDialogIcon;
            }
        };
        scaffoldingDialog.initComponents();

        financeAccountScrollPane.scaffoldingTable.scaffoldingTableListener = new AScaffoldingTableListener() {
            @Override
            public AScaffoldingPopUp getScaffoldingPopUp() {
                AScaffoldingPopUp popUp = new AScaffoldingPopUp() {
                    private static final long serialVersionUID = -2076651271275989746L;

                    @Override
                    public IScaffoldingClient getScaffoldingClient() {
                        return financeAccountClient;
                    }

                    @Override
                    public AScaffoldingDialog getScaffoldingDialog() {
                        return scaffoldingDialog;
                    }

                    @Override
                    public AScaffoldingController getScaffoldingController() {
                        return scaffoldingControllerFinanceAccount;
                    }

                    @Override
                    public ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData() {
                        return FinanceAccountPanel.this.panelScaffoldingNorth.getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData();
                    }

                    @Override
                    public IResourceBundleLocator getRb() {
                        return FinanceAccountPanel.this.rb;
                    }

                    @Override
                    public AScaffoldingTable getScaffoldingTable() {
                        return financeAccountScrollPane.getScaffoldingTable();
                    }
                };
                popUp.initComponents();
                return popUp;
            }
        };
        financeAccountScrollPane.scaffoldingTable.initComponents();
        super.initComponents();
    }


    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return scaffoldingScrollPane.getScaffoldingTable();
    }

    @Override
    public AScaffoldingController getControllerScaffolding() {
        return scaffoldingControllerFinanceAccount;
    }

    @Override
    public LabelScaffoldingTitle getLabelScaffoldingTitle() {
        return labelScaffoldingFinanceAccount;
    }
}
