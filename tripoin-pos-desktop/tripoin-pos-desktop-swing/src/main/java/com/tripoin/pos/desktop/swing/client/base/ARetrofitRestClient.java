package com.tripoin.pos.desktop.swing.client.base;

import com.tripoin.pos.desktop.swing.util.RetrofitFactory;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public abstract class ARetrofitRestClient implements IComponentInitializer{

    @Autowired
    protected RetrofitFactory retrofitFactory;
}
