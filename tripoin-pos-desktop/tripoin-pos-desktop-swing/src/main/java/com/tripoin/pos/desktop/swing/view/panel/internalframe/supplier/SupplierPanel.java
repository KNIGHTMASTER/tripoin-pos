package com.tripoin.pos.desktop.swing.view.panel.internalframe.supplier;

import com.tripoin.pos.desktop.swing.client.ISupplierClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.dialog.impl.ScaffoldingDialogSupplier;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingSupplier;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.popup.AScaffoldingPopUp;
import com.tripoin.pos.desktop.swing.component.scrollpane.SupplierScrollPane;
import com.tripoin.pos.desktop.swing.component.table.listener.AScaffoldingTableListener;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.controller.panel.supplier.ScaffoldingControllerSupplier;
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
public class SupplierPanel extends AScaffoldingPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8769175557093613896L;

    @Autowired
    private LabelScaffoldingSupplier labelScaffoldingSupplier;

    @Autowired
    private ScaffoldingControllerSupplier scaffoldingControllerSupplier;

    @Autowired
    private ISupplierClient supplierClient;

    @Autowired
    private SupplierScrollPane supplierScrollPane;

    @Value("${splashscreen.icon.imageurl}")
    private String scaffoldingDialogIcon;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingScrollPane = supplierScrollPane;
        scaffoldingDialog = new ScaffoldingDialogSupplier() {
            private static final long serialVersionUID = -2243165273326500179L;

            @Override
            public IScaffoldingClient getScaffoldingClient() {
                return supplierClient;
            }

            @Override
            public AScaffoldingController getControllerScaffolding() {
                return SupplierPanel.this.getControllerScaffolding();
            }

            @Override
            public AScaffoldingTable getScaffoldingTable() {
                return SupplierPanel.this.getScaffoldingTable();
            }

            @Override
            public IResourceBundleLocator getRb() {
                return SupplierPanel.this.rb;
            }

            @Override
            public ICentralizePositionComponent getCentralizePositionComponent() {
                return SupplierPanel.this.centralizePositionComponent;
            }

            @Override
            public String getScaffoldingDialogIcon() {
                return scaffoldingDialogIcon;
            }
        };
        scaffoldingDialog.initComponents();

        supplierScrollPane.scaffoldingTable.scaffoldingTableListener = new AScaffoldingTableListener() {
            @Override
            public AScaffoldingPopUp getScaffoldingPopUp() {
                AScaffoldingPopUp popUp = new AScaffoldingPopUp() {
                    private static final long serialVersionUID = -2076651271275989746L;

                    @Override
                    public IScaffoldingClient getScaffoldingClient() {
                        return supplierClient;
                    }

                    @Override
                    public AScaffoldingDialog getScaffoldingDialog() {
                        return scaffoldingDialog;
                    }

                    @Override
                    public AScaffoldingController getScaffoldingController() {
                        return scaffoldingControllerSupplier;
                    }

                    @Override
                    public ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData() {
                        return SupplierPanel.this.panelScaffoldingNorth.getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData();
                    }

                    @Override
                    public IResourceBundleLocator getRb() {
                        return SupplierPanel.this.rb;
                    }

                    @Override
                    public AScaffoldingTable getScaffoldingTable() {
                        return supplierScrollPane.getScaffoldingTable();
                    }
                };
                popUp.initComponents();
                return popUp;
            }
        };
        supplierScrollPane.scaffoldingTable.initComponents();
        super.initComponents();
    }


    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return scaffoldingScrollPane.getScaffoldingTable();
    }

    @Override
    public AScaffoldingController getControllerScaffolding() {
        return scaffoldingControllerSupplier;
    }

    @Override
    public LabelScaffoldingTitle getLabelScaffoldingTitle() {
        return labelScaffoldingSupplier;
    }
}
