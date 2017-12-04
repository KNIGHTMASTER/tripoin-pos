package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IProductStockDAO;
import com.tripoin.pos.rest.desktop.service.IProductStockService;
import com.tripoin.pos.shared.data.model.ProductStock;
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
public class ProductStockServiceImpl extends AScaffoldingService<ProductStock> implements IProductStockService {
    @Autowired
    private IProductStockDAO productStockDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productStockDAO;
    }
}
