package com.tripoin.pos.rest.desktop.service.master.impl;

import com.tripoin.pos.rest.desktop.dao.master.IProductDAO;
import com.tripoin.pos.rest.desktop.service.master.IProductService;
import com.tripoin.pos.shared.data.model.master.Product;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductServiceImpl extends AScaffoldingService<Product> implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productDAO;
    }
}
