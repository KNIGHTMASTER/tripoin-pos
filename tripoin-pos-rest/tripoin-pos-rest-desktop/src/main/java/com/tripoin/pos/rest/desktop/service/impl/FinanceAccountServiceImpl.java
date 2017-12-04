package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IFinanceAccountDAO;
import com.tripoin.pos.rest.desktop.service.IFinanceAccountService;
import com.tripoin.pos.shared.data.model.FinanceAccount;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 12/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class FinanceAccountServiceImpl extends AScaffoldingService<FinanceAccount> implements IFinanceAccountService {

    @Autowired
    private IFinanceAccountDAO financeAccountDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = financeAccountDAO;
    }
}
