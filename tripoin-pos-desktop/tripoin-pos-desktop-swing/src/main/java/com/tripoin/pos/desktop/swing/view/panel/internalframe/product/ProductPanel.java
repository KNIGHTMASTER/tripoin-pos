package com.tripoin.pos.desktop.swing.view.panel.internalframe.product;

import com.tripoin.pos.desktop.swing.client.IProductClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.combobox.*;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.dialog.impl.ScaffoldingDialogProduct;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingProduct;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.popup.AScaffoldingPopUp;
import com.tripoin.pos.desktop.swing.component.scrollpane.ProductScrollPane;
import com.tripoin.pos.desktop.swing.component.table.listener.AScaffoldingTableListener;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.controller.panel.product.ScaffoldingControllerProduct;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding.AScaffoldingPanel;
import id.co.telkomsigma.tgf.util.IComponentAction;
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
public class ProductPanel extends AScaffoldingPanel implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8769175557093613896L;

    @Autowired
    private LabelScaffoldingProduct labelScaffoldingProduct;

    @Autowired
    private ScaffoldingControllerProduct scaffoldingControllerProduct;

    @Autowired
    private IProductClient productClient;

    @Autowired
    private ProductScrollPane productScrollPane;

    @Value("${splashscreen.icon.imageurl}")
    private String scaffoldingDialogIcon;

    @Autowired
    private ProductCategoryLOV productCategoryLOV;

    @Autowired
    private ProductTypeLOV productTypeLOV;

    @Autowired
    private ProductBrandLOV productBrandLOV;

    @Autowired
    private SupplierLOV supplierLOV;

    @Autowired
    private PriceLOV priceLOV;

    @Autowired
    private ProductStockLOV productStockLOV;

    @Autowired
    private ProductGuaranteeLOV productGuaranteeLOV;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingScrollPane = productScrollPane;
        scaffoldingDialog = new ScaffoldingDialogProduct() {
            @Override
            public ProductCategoryLOV getProductCategoryLOV() {
                return ProductPanel.this.productCategoryLOV;
            }

            @Override
            public ProductTypeLOV getProductTypeLOV() {
                return ProductPanel.this.productTypeLOV;
            }

            @Override
            public ProductBrandLOV getProductBrandLOV() {
                return ProductPanel.this.productBrandLOV;
            }

            @Override
            public SupplierLOV getSupplierLOV() {
                return ProductPanel.this.supplierLOV;
            }

            @Override
            public PriceLOV getPriceLOV() {
                return ProductPanel.this.priceLOV;
            }

            @Override
            public ProductStockLOV getProductStockLOV() {
                return ProductPanel.this.productStockLOV;
            }

            @Override
            public ProductGuaranteeLOV getProductGuaranteeLOV() {
                return ProductPanel.this.productGuaranteeLOV;
            }

            private static final long serialVersionUID = -2243165273326500179L;

            @Override
            public IScaffoldingClient getScaffoldingClient() {
                return productClient;
            }

            @Override
            public AScaffoldingController getControllerScaffolding() {
                return ProductPanel.this.getControllerScaffolding();
            }

            @Override
            public AScaffoldingTable getScaffoldingTable() {
                return ProductPanel.this.getScaffoldingTable();
            }

            @Override
            public IResourceBundleLocator getRb() {
                return ProductPanel.this.rb;
            }

            @Override
            public ICentralizePositionComponent getCentralizePositionComponent() {
                return ProductPanel.this.centralizePositionComponent;
            }

            @Override
            public String getScaffoldingDialogIcon() {
                return scaffoldingDialogIcon;
            }
        };
        scaffoldingDialog.initComponents();

        productScrollPane.scaffoldingTable.scaffoldingTableListener = new AScaffoldingTableListener() {
            @Override
            public AScaffoldingPopUp getScaffoldingPopUp() {
                AScaffoldingPopUp popUp = new AScaffoldingPopUp() {
                    private static final long serialVersionUID = -2076651271275989746L;

                    @Override
                    public IScaffoldingClient getScaffoldingClient() {
                        return productClient;
                    }

                    @Override
                    public AScaffoldingDialog getScaffoldingDialog() {
                        return scaffoldingDialog;
                    }

                    @Override
                    public AScaffoldingController getScaffoldingController() {
                        return scaffoldingControllerProduct;
                    }

                    @Override
                    public ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData() {
                        return ProductPanel.this.panelScaffoldingNorth.getPanelScaffoldingNorthBottom().getComboBoxDisplayNumberOfData();
                    }

                    @Override
                    public IResourceBundleLocator getRb() {
                        return ProductPanel.this.rb;
                    }

                    @Override
                    public AScaffoldingTable getScaffoldingTable() {
                        return productScrollPane.getScaffoldingTable();
                    }
                };
                popUp.initComponents();
                return popUp;
            }
        };
        productScrollPane.scaffoldingTable.initComponents();
        super.initComponents();

        initAction();
    }


    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return scaffoldingScrollPane.getScaffoldingTable();
    }

    @Override
    public AScaffoldingController getControllerScaffolding() {
        return scaffoldingControllerProduct;
    }

    @Override
    public LabelScaffoldingTitle getLabelScaffoldingTitle() {
        return labelScaffoldingProduct;
    }

    @Override
    public void initAction() {
        productCategoryLOV.addActionListener(e -> {
            LOGGER.info("ACTION PRODUCT CATEGORY");
            Long productCategoryId = productCategoryLOV.getSelectedId(productCategoryLOV.getSelectedIndex());
            productTypeLOV.setContentByParent(productCategoryId);

        });
        super.initAction();
    }
}
