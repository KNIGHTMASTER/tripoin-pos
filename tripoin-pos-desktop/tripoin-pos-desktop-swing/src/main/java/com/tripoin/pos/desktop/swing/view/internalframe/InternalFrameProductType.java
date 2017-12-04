package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableProductType;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.producttype.ProductTypePanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameProductType extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private ProductTypePanel productTypePanel;

    @Autowired
    private TableProductType tableProductType;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = productTypePanel;
        scaffoldingTable = tableProductType;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.producttype.title";
    }
}
