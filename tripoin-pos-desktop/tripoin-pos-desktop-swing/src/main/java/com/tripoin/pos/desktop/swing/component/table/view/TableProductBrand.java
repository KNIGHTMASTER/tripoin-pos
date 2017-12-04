package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IProductBrandClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelProductBrand;
import com.tripoin.pos.shared.data.dto.response.ProductBrandResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableProductBrand extends AScaffoldingTable<ProductBrandResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IProductBrandClient productBrandClient;

    @Autowired
    private TableModelProductBrand tableModelProductBrand;

    @Override
    public void initComponents() {
        scaffoldingClient = productBrandClient;
        scaffoldingTableModel = tableModelProductBrand;

        super.initComponents();
    }
}
