package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IProductEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IProductService;
import com.tripoin.pos.shared.data.mapper.master.ProductMapper;
import com.tripoin.pos.shared.data.model.master.Product;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/product")
public class ProductEndPointImpl extends AScaffoldingEndPoint<Product> implements IProductEndPoint {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = productService;
        dataMapperIntegration = productMapper;
    }
}
