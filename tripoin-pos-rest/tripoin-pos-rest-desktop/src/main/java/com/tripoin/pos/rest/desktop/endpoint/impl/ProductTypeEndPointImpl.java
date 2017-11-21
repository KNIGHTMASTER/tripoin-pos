package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IProductTypeEndPoint;
import com.tripoin.pos.rest.desktop.service.IProductTypeService;
import com.tripoin.pos.shared.data.mapper.ProductTypeMapper;
import com.tripoin.pos.shared.data.model.ProductType;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/producttype")
public class ProductTypeEndPointImpl extends AScaffoldingEndPoint<ProductType> implements IProductTypeEndPoint {
    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = productTypeService;
        dataMapperIntegration = productTypeMapper;
    }
}
