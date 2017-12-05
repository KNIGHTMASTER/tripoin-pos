package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IIncomePriceEndPoint;
import com.tripoin.pos.rest.desktop.service.trx.IIncomePriceService;
import com.tripoin.pos.shared.data.mapper.IncomePriceMapper;
import com.tripoin.pos.shared.data.model.trx.IncomePrice;
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
@RequestMapping("/incomeprice")
public class IncomePriceEndPointImpl extends AScaffoldingEndPoint<IncomePrice> implements IIncomePriceEndPoint{

    @Autowired
    private IIncomePriceService incomePriceService;

    @Autowired
    private IncomePriceMapper incomePriceMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = incomePriceMapper;
        scaffoldingService = incomePriceService;
    }
}
