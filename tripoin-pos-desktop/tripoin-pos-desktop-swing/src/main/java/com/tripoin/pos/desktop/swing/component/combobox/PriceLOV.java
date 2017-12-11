package com.tripoin.pos.desktop.swing.component.combobox;

import com.tripoin.pos.desktop.swing.client.IPriceClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 11/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PriceLOV extends ALOV {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7102025858813221345L;

    @Autowired
    private IPriceClient priceClient;

    @Override
    public IScaffoldingClient getScaffoldingClient() {
        return priceClient;
    }
}
