package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IProductCategoryClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelProductCategory;
import com.tripoin.pos.shared.data.dto.response.ProductCategoryResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableProductCategory extends AScaffoldingTable<ProductCategoryResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IProductCategoryClient productCategoryClient;

    @Autowired
    private TableModelProductCategory tableModelProductCategory;

    @Override
    public void initComponents() {
        scaffoldingClient = productCategoryClient;
        scaffoldingTableModel = tableModelProductCategory;

        super.initComponents();
    }
}
