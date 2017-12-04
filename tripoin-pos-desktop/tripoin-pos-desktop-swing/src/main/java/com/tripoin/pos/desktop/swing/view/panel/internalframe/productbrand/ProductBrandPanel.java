package com.tripoin.pos.desktop.swing.view.panel.internalframe.productbrand;

import com.tripoin.pos.desktop.swing.client.IProductBrandClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.dialog.impl.ScaffoldingDialogProductBrand;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingProductBrand;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.popup.AScaffoldingPopUp;
import com.tripoin.pos.desktop.swing.component.scrollpane.ProductBrandScrollPane;
import com.tripoin.pos.desktop.swing.component.table.listener.AScaffoldingTableListener;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.controller.panel.productbrand.ScaffoldingControllerProductBrand;
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
public class ProductBrandPanel extends AScaffoldingPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8769175557093613896L;

    @Autowired
    private LabelScaffoldingProductBrand labelScaffoldingProductBrand;

    @Autowired
    private ScaffoldingControllerProductBrand scaffoldingControllerProductBrand;

    @Autowired
    private IProductBrandClient productBrandClient;

    @Autowired
    private ProductBrandScrollPane productBrandScrollPane;

    @Value("${splashscreen.icon.imageurl}")
    private String scaffoldingDialogIcon;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingScrollPane = productBrandScrollPane;
        scaffoldingDialog = new ScaffoldingDialogProductBrand() {
            private static final long serialVersionUID = -2243165273326500179L;

            @Override
            public IScaffoldingClient getScaffoldingClient() {
                return productBrandClient;
            }

            @Override
            public AScaffoldingController getControllerScaffolding() {
                return ProductBrandPanel.this.getControllerScaffolding();
            }

            @Override
            public AScaffoldingTable getScaffoldingTable() {
                return ProductBrandPanel.this.getScaffoldingTable();
            }

            @Override
            public IResourceBundleLocator getRb() {
                return ProductBrandPanel.this.rb;
            }

            @Override
            public ICentralizePositionComponent getCentralizePositionComponent() {
                return ProductBrandPanel.this.centralizePositionComponent;
            }

            @Override
            public String getScaffoldingDialogIcon() {
                return scaffoldingDialogIcon;
            }
        };
        scaffoldingDialog.initComponents();

        productBrandScrollPane.scaffoldingTable.scaffoldingTableListener = new AScaffoldingTableListener() {
            @Override
            public AScaffoldingPopUp getScaffoldingPopUp() {
                AScaffoldingPopUp popUp = new AScaffoldingPopUp() {
                    private static final long serialVersionUID = -2076651271275989746L;

                    @Override
                    public IScaffoldingClient getScaffoldingClient() {
                        return productBrandClient;
                    }

                    @Override
                    public AScaffoldingDialog getScaffoldingDialog() {
                        return scaffoldingDialog;
                    }

                    @Override
                    public AScaffoldingController getScaffoldingController() {
                        return scaffoldingControllerProductBrand;
                    }

                    @Override
                    public ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData() {
                        return ProductBrandPanel.this.panelScaffoldingNorth.getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData();
                    }

                    @Override
                    public IResourceBundleLocator getRb() {
                        return ProductBrandPanel.this.rb;
                    }

                    @Override
                    public AScaffoldingTable getScaffoldingTable() {
                        return productBrandScrollPane.getScaffoldingTable();
                    }
                };
                popUp.initComponents();
                return popUp;
            }
        };
        productBrandScrollPane.scaffoldingTable.initComponents();
        super.initComponents();
    }


    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return scaffoldingScrollPane.getScaffoldingTable();
    }

    @Override
    public AScaffoldingController getControllerScaffolding() {
        return scaffoldingControllerProductBrand;
    }

    @Override
    public LabelScaffoldingTitle getLabelScaffoldingTitle() {
        return labelScaffoldingProductBrand;
    }
}
