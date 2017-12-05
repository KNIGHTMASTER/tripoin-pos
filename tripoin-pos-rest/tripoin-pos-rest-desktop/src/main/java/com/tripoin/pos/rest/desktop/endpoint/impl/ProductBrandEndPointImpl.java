package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IProductBrandEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IProductBrandService;
import com.tripoin.pos.shared.data.mapper.ProductBrandMapper;
import com.tripoin.pos.shared.data.model.master.ProductBrand;
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
@RequestMapping("/productbrand")
public class ProductBrandEndPointImpl extends AScaffoldingEndPoint<ProductBrand> implements IProductBrandEndPoint{

    @Autowired
    private IProductBrandService productBrandService;

    @Autowired
    private ProductBrandMapper productBrandMapper;
    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = productBrandService;
        dataMapperIntegration = productBrandMapper;
    }
}
