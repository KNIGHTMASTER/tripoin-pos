package com.tripoin.pos.desktop.swing.view.internalframe;

import com.tripoin.pos.desktop.swing.component.internalframe.AScaffoldingInternalFrame;
import com.tripoin.pos.desktop.swing.component.table.view.TableProductCategory;
import com.tripoin.pos.desktop.swing.view.panel.internalframe.productcategory.ProductCategoryPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameProductCategory extends AScaffoldingInternalFrame {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private ProductCategoryPanel productCategoryPanel;

    @Autowired
    private TableProductCategory tableProductCategory;

    @PostConstruct
    @Override
    public void initComponents(){
        scaffoldingPanel = productCategoryPanel;
        scaffoldingTable = tableProductCategory;

        super.initComponents();
    }

    @Override
    public String getTitleResourceBundle() {
        return "ui.internalframe.productcategory.title";
    }
}
