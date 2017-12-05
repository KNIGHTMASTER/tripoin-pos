package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IExpensePriceEndPoint;
import com.tripoin.pos.rest.desktop.service.trx.IExpensePriceService;
import com.tripoin.pos.shared.data.mapper.ExpensePriceMapper;
import com.tripoin.pos.shared.data.model.trx.ExpensePrice;
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
@RequestMapping("/expenseprice")
public class ExpensePriceEndPointImpl extends AScaffoldingEndPoint<ExpensePrice> implements IExpensePriceEndPoint {
    @Autowired
    private IExpensePriceService expensePriceService;

    @Autowired
    private ExpensePriceMapper expensePriceMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = expensePriceMapper;
        scaffoldingService = expensePriceService;
    }
}
