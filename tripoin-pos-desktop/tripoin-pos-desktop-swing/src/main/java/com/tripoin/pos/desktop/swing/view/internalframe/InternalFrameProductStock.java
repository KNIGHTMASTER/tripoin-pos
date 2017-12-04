package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableProductStock;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.productstock.ProductStockPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameProductStock extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private ProductStockPanel productStockPanel;

    @Autowired
    private TableProductStock tableProductStock;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingTable = tableProductStock;
        scaffoldingPanel = productStockPanel;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.productstock.title";
    }
}
