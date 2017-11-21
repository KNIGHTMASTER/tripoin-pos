package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.ICompanyEndPoint;
import com.tripoin.pos.rest.desktop.service.ICompanyService;
import com.tripoin.pos.shared.data.mapper.CompanyMapper;
import com.tripoin.pos.shared.data.model.Company;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/1/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/company")
public class CompanyEndPointImpl extends AScaffoldingEndPoint<Company> implements ICompanyEndPoint {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = companyMapper;
        scaffoldingService = companyService;
    }
}
