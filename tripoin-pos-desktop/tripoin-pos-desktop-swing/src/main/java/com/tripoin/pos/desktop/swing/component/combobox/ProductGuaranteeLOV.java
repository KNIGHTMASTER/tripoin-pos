package com.tripoin.pos.desktop.swing.component.combobox;

import com.tripoin.pos.desktop.swing.client.IProductGuaranteeClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 11/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ProductGuaranteeLOV extends ALOV {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7102025858813221345L;

    @Autowired
    private IProductGuaranteeClient productGuaranteeClient;

    @Override
    public IScaffoldingClient getScaffoldingClient() {
        return productGuaranteeClient;
    }
}
