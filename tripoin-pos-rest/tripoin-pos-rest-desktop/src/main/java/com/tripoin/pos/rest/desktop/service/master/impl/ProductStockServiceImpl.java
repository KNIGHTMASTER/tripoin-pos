package com.tripoin.pos.rest.desktop.service.master.impl;

import com.tripoin.pos.rest.desktop.dao.master.IProductStockDAO;
import com.tripoin.pos.rest.desktop.service.master.IProductStockService;
import com.tripoin.pos.shared.data.model.master.ProductStock;
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
