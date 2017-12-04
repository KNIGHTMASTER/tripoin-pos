package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableProductBrand;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.productbrand.ProductBrandPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameProductBrand extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private ProductBrandPanel productBrandPanel;

    @Autowired
    private TableProductBrand tableProductBrand;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = productBrandPanel;
        scaffoldingTable = tableProductBrand;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.productbrand.title";
    }
}
