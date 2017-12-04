package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IBankEndPoint;
import com.tripoin.pos.rest.desktop.service.IBankService;
import com.tripoin.pos.shared.data.mapper.BankMapper;
import com.tripoin.pos.shared.data.model.Bank;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/bank")
public class BankEndPointImpl extends AScaffoldingEndPoint<Bank> implements IBankEndPoint {

    @Autowired
    private IBankService bankService;

    @Autowired
    private BankMapper bankMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = bankService;
        dataMapperIntegration = bankMapper;
    }
}
