package com.tripoin.pos.rest.desktop.service.master.impl;

import com.tripoin.pos.rest.desktop.dao.master.IProductGuaranteeDAO;
import com.tripoin.pos.rest.desktop.service.master.IProductGuaranteeService;
import com.tripoin.pos.shared.data.model.master.ProductGuarantee;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/21/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductGuaranteeServiceImpl extends AScaffoldingService<ProductGuarantee> implements IProductGuaranteeService {

    @Autowired
    private IProductGuaranteeDAO productGuaranteeDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productGuaranteeDAO;
    }
}
