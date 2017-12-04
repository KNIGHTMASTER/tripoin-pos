package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IBankDAO;
import com.tripoin.pos.rest.desktop.service.IBankService;
import com.tripoin.pos.shared.data.model.Bank;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BankServiceImpl extends AScaffoldingService<Bank> implements IBankService {

    @Autowired
    private IBankDAO bankDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = bankDAO;
    }
}
