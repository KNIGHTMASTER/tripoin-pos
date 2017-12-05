package com.tripoin.pos.rest.desktop.service.master.impl;

import com.tripoin.pos.rest.desktop.dao.master.IFinanceAccountDAO;
import com.tripoin.pos.rest.desktop.service.master.IFinanceAccountService;
import com.tripoin.pos.shared.data.model.master.FinanceAccount;
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
