package com.tripoin.pos.desktop.swing.component.combobox;

import com.tripoin.pos.desktop.swing.client.IProductTypeClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 11/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ProductTypeLOV extends ALOV {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7102025858813221345L;

    @Autowired
    private IProductTypeClient productTypeClient;

    @Override
    public IScaffoldingClient getScaffoldingClient() {
        return productTypeClient;
    }
}
