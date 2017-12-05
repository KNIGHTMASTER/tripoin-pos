package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IFinanceAccountEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IFinanceAccountService;
import com.tripoin.pos.shared.data.mapper.FinanceAccountMapper;
import com.tripoin.pos.shared.data.model.master.FinanceAccount;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 12/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/financeaccount")
public class FinanceAccountEndPointImpl extends AScaffoldingEndPoint<FinanceAccount> implements IFinanceAccountEndPoint {

    @Autowired
    private IFinanceAccountService financeAccountService;

    @Autowired
    private FinanceAccountMapper financeAccountMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = financeAccountMapper;
        scaffoldingService = financeAccountService;
    }
}
