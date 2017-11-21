package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IProductTypeDAO;
import com.tripoin.pos.rest.desktop.service.IProductTypeService;
import com.tripoin.pos.shared.data.model.ProductType;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductTypeServiceImpl extends AScaffoldingService<ProductType> implements IProductTypeService {

    @Autowired
    private IProductTypeDAO productTypeDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productTypeDAO;
    }
}
