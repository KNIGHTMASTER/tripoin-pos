package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IProductStockEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IProductStockService;
import com.tripoin.pos.shared.data.mapper.ProductStockMapper;
import com.tripoin.pos.shared.data.model.master.ProductStock;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/21/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/productstock")
public class ProductStockEndPointImpl extends AScaffoldingEndPoint<ProductStock> implements IProductStockEndPoint {

    @Autowired
    private IProductStockService productStockService;

    @Autowired
    private ProductStockMapper productStockMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = productStockMapper;
        scaffoldingService = productStockService;
    }
}
