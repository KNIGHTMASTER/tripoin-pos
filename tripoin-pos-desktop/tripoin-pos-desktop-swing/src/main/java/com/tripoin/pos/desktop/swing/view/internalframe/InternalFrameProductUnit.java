package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableProductUnit;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.productunit.ProductUnitPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameProductUnit extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private ProductUnitPanel productUnitPanel;

    @Autowired
    private TableProductUnit tableProductUnit;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = productUnitPanel;
        scaffoldingTable = tableProductUnit;
        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.productunit.title";
    }
}
