package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.ICompanyDAO;
import com.tripoin.pos.rest.desktop.model.Company;
import com.tripoin.pos.rest.desktop.service.ICompanyService;
import id.co.telkomsigma.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CompanyServiceImpl extends AScaffoldingService<Company> implements ICompanyService {

    @Autowired
    private ICompanyDAO ICompanyDAO;

    @PostConstruct
    @Override
    public void init() {
        this.scaffoldingDAO = ICompanyDAO;
    }
}
