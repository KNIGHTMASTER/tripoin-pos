package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableProductGuarantee;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.productguarantee.ProductGuaranteePanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameProductGuarantee extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private ProductGuaranteePanel productGuaranteePanel;

    @Autowired
    private TableProductGuarantee tableProductGuarantee;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingPanel = productGuaranteePanel;
        scaffoldingTable = tableProductGuarantee;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.productguarantee.title";
    }
}
