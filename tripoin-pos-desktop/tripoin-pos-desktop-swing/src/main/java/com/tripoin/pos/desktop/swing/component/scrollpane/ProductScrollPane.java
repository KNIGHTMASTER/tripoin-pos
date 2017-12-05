package com.tripoin.pos.desktop.swing.component.scrollpane;

import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.component.table.view.TableProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ProductScrollPane extends AScaffoldingScrollPane {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5782555036729246491L;

    @Autowired
    private TableProduct tableProduct;

    @PostConstruct
    @Override
    public void initComponents() {
        scaffoldingTable = tableProduct;
        super.initComponents();
    }

    @Override
    public AScaffoldingTable getScaffoldingTable() {
        return tableProduct;
    }
}
