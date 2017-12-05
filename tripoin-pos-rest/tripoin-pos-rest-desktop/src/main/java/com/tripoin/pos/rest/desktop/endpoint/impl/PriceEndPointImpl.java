package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IPriceEndPoint;
import com.tripoin.pos.rest.desktop.service.trx.IPriceService;
import com.tripoin.pos.shared.data.mapper.PriceMapper;
import com.tripoin.pos.shared.data.model.trx.Price;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/price")
public class PriceEndPointImpl extends AScaffoldingEndPoint<Price> implements IPriceEndPoint {

    @Autowired
    private IPriceService priceService;

    @Autowired
    private PriceMapper priceMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = priceMapper;
        scaffoldingService = priceService;
    }
}
