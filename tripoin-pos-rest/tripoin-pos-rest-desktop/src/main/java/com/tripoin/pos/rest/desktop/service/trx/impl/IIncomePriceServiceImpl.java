package com.tripoin.pos.rest.desktop.service.trx.impl;

import com.tripoin.pos.rest.desktop.dao.trx.IIncomePriceDAO;
import com.tripoin.pos.rest.desktop.service.trx.IIncomePriceService;
import com.tripoin.pos.shared.data.model.trx.IncomePrice;
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
public class IIncomePriceServiceImpl extends AScaffoldingService<IncomePrice> implements IIncomePriceService {

    @Autowired
    private IIncomePriceDAO incomePriceDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = incomePriceDAO;
    }
}
