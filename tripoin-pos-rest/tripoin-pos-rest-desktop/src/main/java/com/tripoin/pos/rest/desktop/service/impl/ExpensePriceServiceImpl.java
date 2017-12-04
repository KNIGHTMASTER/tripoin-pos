package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IExpensePriceDAO;
import com.tripoin.pos.rest.desktop.service.IExpensePriceService;
import com.tripoin.pos.shared.data.model.ExpensePrice;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ExpensePriceServiceImpl extends AScaffoldingService<ExpensePrice> implements IExpensePriceService {

    @Autowired
    private IExpensePriceDAO expensePriceDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = expensePriceDAO;
    }
}
