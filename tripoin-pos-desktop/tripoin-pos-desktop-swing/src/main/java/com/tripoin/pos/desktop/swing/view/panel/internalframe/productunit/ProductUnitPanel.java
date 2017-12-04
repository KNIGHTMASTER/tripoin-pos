package com.tripoin.pos.desktop.swing.view.panel.internalframe.productunit;

import com.tripoin.pos.desktop.swing.client.IProductUnitClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.dialog.impl.ScaffoldingDialogProductUnit;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingProductUnit;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.popup.AScaffoldingPopUp;
import com.tripoin.pos.desktop.swing.component.scrollpane.ProductUnitScrollPane;
import com.tripoin.pos.desktop.swing.component.table.listener.AScaffoldingTableListener;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.controller.panel.productunit.ScaffoldingControllerProductUnit;
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
public class ProductUnitPanel extends AScaffoldingPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8769175557093613896L;

    @Autowired
    private LabelScaffoldingProductUnit labelScaffoldingProductUnit;

    @Autowired
    private ScaffoldingControllerProductUnit scaffoldingControllerProductUnit;

    @Autowired
    private IProductUnitClient productUnitClient;

    @Autowired
    private ProductUnitScrollPane productUnitScrollPane;

    @Value("${splashscreen.icon.imageurl}")
    private String scaffoldingDialogIcon;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingScrollPane = productUnitScrollPane;
        scaffoldingDialog = new ScaffoldingDialogProductUnit() {
            private static final long serialVersionUID = -2243165273326500179L;

            @Override
            public IScaffoldingClient getScaffoldingClient() {
                return productUnitClient;
            }

            @Override
            public AScaffoldingController getControllerScaffolding() {
                return ProductUnitPanel.this.getControllerScaffolding();
            }

            @Override
            public AScaffoldingTable getScaffoldingTable() {
                return ProductUnitPanel.this.getScaffoldingTable();
            }

            @Override
            public IResourceBundleLocator getRb() {
                return ProductUnitPanel.this.rb;
            }

            @Override
            public ICentralizePositionComponent getCentralizePositionComponent() {
                return ProductUnitPanel.this.centralizePositionComponent;
            }

            @Override
            public String getScaffoldingDialogIcon() {
                return scaffoldingDialogIcon;
            }
        };
        scaffoldingDialog.initComponents();

        productUnitScrollPane.scaffoldingTable.scaffoldingTableListener = new AScaffoldingTableListener() {
            @Override
            public AScaffoldingPopUp getScaffoldingPopUp() {
                AScaffoldingPopUp popUp = new AScaffoldingPopUp() {
                    private static final long serialVersionUID = -2076651271275989746L;

                    @Override
                    public IScaffoldingClient getScaffoldingClient() {
                        return productUnitClient;
                    }

                    @Override
                    public AScaffoldingDialog getScaffoldingDialog() {
                        return scaffoldingDialog;
                    }

                    @Override
                    public AScaffoldingController getScaffoldingController() {
                        return scaffoldingControllerProductUnit;
                    }

                    @Override
                    public ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData() {
                        return ProductUnitPanel.this.panelScaffoldingNorth.getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData();
                    }

                    @Override
                    public IResourceBundleLocator getRb() {
                        return ProductUnitPanel.this.rb;
                    }

                    @Override
                    public AScaffoldingTable getScaffoldingTable() {
                        return productUnitScrollPane.getScaffoldingTable();
                    }
                };
                popUp.initComponents();
                return popUp;
            }
        };
        productUnitScrollPane.scaffoldingTable.initComponents();
        super.initComponents();
    }


    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return scaffoldingScrollPane.getScaffoldingTable();
    }

    @Override
    public AScaffoldingController getControllerScaffolding() {
        return scaffoldingControllerProductUnit;
    }

    @Override
    public LabelScaffoldingTitle getLabelScaffoldingTitle() {
        return labelScaffoldingProductUnit;
    }
}
