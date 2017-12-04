package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IPriceDAO;
import com.tripoin.pos.rest.desktop.service.IPriceService;
import com.tripoin.pos.shared.data.model.Price;
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
public class PriceServiceImpl extends AScaffoldingService<Price> implements IPriceService {

    @Autowired
    private IPriceDAO priceDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = priceDAO;
    }
}
