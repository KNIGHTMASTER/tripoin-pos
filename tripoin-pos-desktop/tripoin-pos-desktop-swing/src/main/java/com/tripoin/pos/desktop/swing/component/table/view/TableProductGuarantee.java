package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IProductGuaranteeClient;
import com.tripoin.pos.desktop.swing.component.table.model.TableModelProductGuarantee;
import com.tripoin.pos.shared.data.dto.response.ProductGuaranteeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 6/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableProductGuarantee extends AScaffoldingTable<ProductGuaranteeResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1711663676408632418L;

    @Autowired
    private IProductGuaranteeClient productGuaranteeClient;

    @Autowired
    private TableModelProductGuarantee tableModelProductGuarantee;

    @Override
    public void initComponents() {
        scaffoldingClient = productGuaranteeClient;
        scaffoldingTableModel = tableModelProductGuarantee;

        super.initComponents();
    }
}
